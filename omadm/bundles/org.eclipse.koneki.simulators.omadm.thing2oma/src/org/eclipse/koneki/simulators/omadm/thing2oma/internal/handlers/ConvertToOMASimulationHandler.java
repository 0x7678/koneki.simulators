/*******************************************************************************
 * Copyright (c) 2012 Sierra Wireless and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sierra Wireless - initial API and implementation
 *******************************************************************************/
package org.eclipse.koneki.simulators.omadm.thing2oma.internal.handlers;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.koneki.models.things.Event;
import org.eclipse.koneki.models.things.Property;
import org.eclipse.koneki.models.things.Thing;
import org.eclipse.koneki.models.things.Type;
import org.eclipse.koneki.models.things.Universe;
import org.eclipse.koneki.protocols.omadm.StatusCode;
import org.eclipse.koneki.simulators.omadm.model.CommandManagement;
import org.eclipse.koneki.simulators.omadm.model.Device;
import org.eclipse.koneki.simulators.omadm.model.DeviceIdType;
import org.eclipse.koneki.simulators.omadm.model.Node;
import org.eclipse.koneki.simulators.omadm.model.NodeFormat;
import org.eclipse.koneki.simulators.omadm.model.OMADMSimulation;
import org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorFactory;
import org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers;
import org.eclipse.koneki.simulators.omadm.thing2oma.internal.Activator;
import org.eclipse.ui.handlers.HandlerUtil;

import com.swir.avop.application.Application;
import com.swir.avop.application.Configuration;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 *
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ConvertToOMASimulationHandler extends AbstractHandler {

	public ConvertToOMASimulationHandler() {
	}

	/**
	 * the command has been executed, so extract the needed information from the
	 * application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection sel = HandlerUtil.getCurrentSelection(event);

		if (sel instanceof IStructuredSelection) {
			Object selectedObject = ((IStructuredSelection) sel)
					.getFirstElement();

			IFile f = null;
			if (selectedObject instanceof IFile) {
				f = (IFile) selectedObject;
			} else if (selectedObject instanceof IAdaptable) {
				if (((IAdaptable) selectedObject).getAdapter(IFile.class) != null) {
					f = (IFile) ((IAdaptable) selectedObject)
							.getAdapter(IFile.class);
				}
			} else {

				/*
				 * TODO Add checking with an adapter manager eg :
				 * Platform.getAdapterManager()
				 */
			}

			if (f != null) {
				Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
				Map<String, Object> m = reg.getExtensionToFactoryMap();
				m.put("things", new XMIResourceFactoryImpl());
				ResourceSet resSet = new ResourceSetImpl();

				Resource res = resSet.createResource(URI.createFileURI(f
						.getLocation().toOSString()));
				try {
					res.load(Collections.EMPTY_MAP);
					Universe universe = (Universe) res.getContents().get(0);

					Thing thing = null;
					for (Type t : universe.getContents()) {
						if (t instanceof Thing) {
							thing = (Thing) t;
							break;
						}
					}

					if (thing == null)
						return false;

					/*
					 * Convert the thing to an OMA-DM simulation
					 */
					OMADMSimulation omadmModel = convertThingToOMADMSimulation(thing);

					if (omadmModel != null) {

						/*
						 * Use this function to validate the omadmModel
						 */
						validateOMADMModel(omadmModel);

						/*
						 * Save the omadmModel in a new xml file
						 */

						final String omadmFilePath = f
								.getLocation()
								.toString()
								.replace(f.getName(),
										thing.getName() + "_omadm_simu.xml");

						final ResourceSet resourceSet = new ResourceSetImpl();
						final URI fileURI = URI.createFileURI(omadmFilePath);
						/*
						 * TODO Find a generic method to save the xml file with
						 * a good xmi header
						 */
						final Resource resource = resourceSet
								.createResource(fileURI,
										"org.eclipse.koneki.simulators.omadm.model.OMADMSimulationModel");

						resource.getContents().add(omadmModel);

						try {
							resource.save(null);
						} catch (IOException e) {
							e.printStackTrace();
						}

						/*
						 * refresh the Project Explorer view
						 */
						try {

							IWorkspace workspace = ResourcesPlugin
									.getWorkspace();
							IWorkspaceRoot workspaceRoot = workspace.getRoot();

							workspaceRoot.getProject(f.getProject().getName())
									.refreshLocal(IResource.DEPTH_INFINITE,
											new NullProgressMonitor());

						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/**
	 * Check if the omaddmModel is valid The method print all detected problems
	 *
	 * By default, the tree is not valid. It miss information in the Device.
	 *
	 * @param omadmModel
	 *            : an com.swir.platform.omadmsimulator.model.OMADMSimulation
	 */
	private void validateOMADMModel(final OMADMSimulation omadmModel) {

		Diagnostician d = new Diagnostician();
		Diagnostic diag = d.validate(omadmModel);

		for (Diagnostic dd : diag.getChildren()) {
			if (dd.getSeverity() == Diagnostic.ERROR) {
				Activator.log(new Throwable(dd.getMessage()));
			}
		}
	}

	/**
	 * Find the first Configuration in one Application Model
	 *
	 * @param app
	 *            : an com.swir.avop.application.Application Model
	 * @return the first com.swir.avop.application.Configuration founded in the
	 *         Application Model or null if not founded
	 */
	private Configuration getFirstOMADMConfiguration(final Application app) {
		for (Configuration conf : app.getConfiguration()) {
			if (conf.getProtocolType().toString().equals("OMADM")) {
				return conf;
			}
		}

		return null;
	}

	/**
	 * Create one valid Device with Asset and Communication information
	 *
	 * @param asset
	 *            : an com.swir.avop.application.Asset
	 * @param communication
	 *            : an com.swir.avop.application.Communication
	 * @return one com.swir.platform.omadmsimulator.model.Device
	 */
	private Device createDevice(String id) {

		Device device = OMADMSimulatorFactory.eINSTANCE.createDevice();

		device.setDeviceIdType(DeviceIdType.FREE);
		/*
		 * This information are only knowed by the user
		 */
		device.setDeviceId(id);

		return device;
	}

	/**
	 * Create a valid root {@link Node} for an OMA-DM tree
	 *
	 */
	private Node createRootNode() {

		Node root = OMADMSimulatorFactory.eINSTANCE.createNode();
		root.setParent(null);
		root.setName(".");
		root.setFormat(NodeFormat.NODE);
		root.setType("");
		root.setData("");
		root.setReplaceManagement(CommandManagement.AUTOMATIC);
		root.setReplaceCode(StatusCode.OK.getCode());
		root.setAddManagement(CommandManagement.AUTOMATIC);
		root.setAddCode(StatusCode.OK.getCode());
		root.setExecManagement(CommandManagement.AUTOMATIC);
		root.setExecCode(StatusCode.OPTIONAL_FEATURE_NOT_SUPPORTED.getCode());
		root.setCopyManagement(CommandManagement.AUTOMATIC);
		root.setCopyCode(StatusCode.OK.getCode());
		root.setGetManagement(CommandManagement.AUTOMATIC);
		root.setGetCode(StatusCode.OK.getCode());
		root.setDeleteManagement(CommandManagement.AUTOMATIC);
		root.setDeleteCode(StatusCode.OK.getCode());

		/*
		 * After the root, all important node are also created
		 */

		/*
		 * This node contains some "useless" information about the device
		 */
		Node devInfoNode = OMADMSimulatorFactory.eINSTANCE.createNode();
		devInfoNode.setName("DevInfo");
		devInfoNode.setFormat(NodeFormat.NODE);
		devInfoNode.setType("");
		devInfoNode.setData("");
		devInfoNode = initInheritedNode(devInfoNode);
		devInfoNode.setParent(root);

		/*
		 * This node contains the ID of the device It identify the device one
		 * the OMA-DM platform
		 */
		Node devIdNode = OMADMSimulatorFactory.eINSTANCE.createNode();
		devIdNode.setName("DevId");
		devIdNode.setFormat(NodeFormat.CHR);
		devIdNode.setType("text/plain");
		devIdNode.setData("");
		devIdNode = initInheritedNode(devIdNode);
		devIdNode.setParent(devInfoNode);

		/*
		 * This node contains some "useless" information about the device
		 */
		Node dmVNode = OMADMSimulatorFactory.eINSTANCE.createNode();
		dmVNode.setName("DmV");
		dmVNode.setFormat(NodeFormat.CHR);
		dmVNode.setType("text/plain");
		dmVNode.setData("");
		dmVNode = initInheritedNode(dmVNode);
		dmVNode.setParent(devInfoNode);

		/*
		 * Just some details about the device
		 */
		Node devDetailNode = OMADMSimulatorFactory.eINSTANCE.createNode();
		devDetailNode.setName("DevDetail");
		devDetailNode.setFormat(NodeFormat.NODE);
		devDetailNode.setType("");
		devDetailNode.setData("");
		devDetailNode = initInheritedNode(devDetailNode);
		devDetailNode.setParent(root);

		/*
		 * The firmware version of the device
		 */
		Node fwVNode = OMADMSimulatorFactory.eINSTANCE.createNode();
		fwVNode.setName("FwV");
		fwVNode.setFormat(NodeFormat.CHR);
		fwVNode.setType("text/plain");
		fwVNode.setData("");
		fwVNode = initInheritedNode(fwVNode);
		fwVNode.setParent(devDetailNode);

		/*
		 * The software version of the device
		 */
		Node swVNode = OMADMSimulatorFactory.eINSTANCE.createNode();
		swVNode.setName("SwV");
		swVNode.setFormat(NodeFormat.CHR);
		swVNode.setType("text/plain");
		swVNode.setData("");
		swVNode = initInheritedNode(swVNode);
		swVNode.setParent(devDetailNode);

		/*
		 * Another node, not realy important
		 */
		Node lrgObjNode = OMADMSimulatorFactory.eINSTANCE.createNode();
		lrgObjNode.setName("LrgObj");
		lrgObjNode.setFormat(NodeFormat.BOOL);
		lrgObjNode.setType("text/plain");
		lrgObjNode.setData("");
		/*
		 * False is the default value for the NodeFormat boolean
		 */
		lrgObjNode.setData("false");
		lrgObjNode = initInheritedNode(lrgObjNode);
		lrgObjNode.setParent(devDetailNode);

		return root;
	}

	/**
	 * Each node have to set his management configuration. By default, it's the
	 * inherited configuration
	 *
	 * @param node
	 *            : a com.swir.platform.omadmsimulator.model.Node with no
	 *            management configuration
	 * @return the node with the inherited configuration
	 */
	private Node initInheritedNode(Node node) {

		node.setGetManagement(CommandManagement.INHERITED);
		node.setGetCode(StatusCode.OK.getCode());
		node.setAddManagement(CommandManagement.INHERITED);
		node.setAddCode(StatusCode.OK.getCode());
		node.setDeleteManagement(CommandManagement.INHERITED);
		node.setDeleteCode(StatusCode.OK.getCode());
		node.setCopyManagement(CommandManagement.INHERITED);
		node.setCopyCode(StatusCode.OK.getCode());
		node.setReplaceManagement(CommandManagement.INHERITED);
		node.setReplaceCode(StatusCode.OK.getCode());
		node.setExecManagement(CommandManagement.INHERITED);
		node.setExecCode(StatusCode.OPTIONAL_FEATURE_NOT_SUPPORTED.getCode());

		return node;
	}


	/**
	 * Create one Node with one Setting information
	 *
	 * @param setting
	 *            : one com.swir.avop.application.Setting
	 * @return one com.swir.platform.omadmsimulator.model.Node with interesting
	 *         information from the setting
	 */
	private Node createNodeFromSetting(com.swir.avop.application.Setting setting) {

		Node newNode = OMADMSimulatorFactory.eINSTANCE.createNode();

		if (setting.getPath() == null) {
			newNode.setName("");
		} else {
			newNode.setName(setting.getPath());
		}

		if (setting.getType().equals("int")) {
			newNode.setFormat(NodeFormat.INT);
		} else if (setting.getType().equals("date")) {
			newNode.setFormat(NodeFormat.DATE);
		} else {
			newNode.setFormat(NodeFormat.CHR);
		}

		newNode.setType("text/plain");
		newNode.setData("");
		newNode = initInheritedNode(newNode);

		return newNode;
	}

	/**
	 * Create an OMADM Node from a Koneki Property
	 */
	private Node createNodeFromProperty(Property property) {
		Node newNode = OMADMSimulatorFactory.eINSTANCE.createNode();
		newNode.setName(property.getName());
		newNode.setType("text/plain");
		newNode.setFormat(NodeFormat.CHR);
		newNode.setData("");
		newNode = initInheritedNode(newNode);

		return newNode;
	}

	/**
	 * Create an OMADM Node from a Koneki Event
	 */
	private Node createNodeFromEvent(Event event) {
		Node newNode = OMADMSimulatorFactory.eINSTANCE.createNode();
		newNode.setName(event.getName());
		newNode.setType("text/plain");
		newNode.setFormat(NodeFormat.CHR);
		newNode.setData("");
		newNode = initInheritedNode(newNode);

		return newNode;
	}

	/**
	 * Create one Node with one Node information
	 *
	 * @param variable
	 *            : com.swir.avop.application.Node
	 * @return one com.swir.platform.omadmsimulator.model.Node with interesting
	 *         information from the Node
	 */
	private Node createNodeFromNode(com.swir.avop.application.Node node) {
		Node newNode = OMADMSimulatorFactory.eINSTANCE.createNode();
		if (node.getPath() == null) {
			newNode.setName("");
		} else {
			newNode.setName(node.getPath());
		}
		newNode.setType("");
		newNode.setFormat(NodeFormat.NODE);
		newNode.setData("");
		newNode = initInheritedNode(newNode);

		return newNode;
	}

	private OMADMSimulation convertThingToOMADMSimulation(Thing thing) {

		/*
		 * Create the simulation
		 */
		OMADMSimulation simulation = OMADMSimulatorFactory.eINSTANCE
				.createOMADMSimulation();

		/*
		 * Create the device
		 */
		Device device = null;
		device = createDevice("myDevice");
		simulation.setDevice(device);

		Node root = null;
		root = NodeHelpers.initTree();
		device.setTree(root);

		/*
		 * Check all other information
		 */
//		for (com.swir.avop.application.Node n : data.getNode()) {
//			Node newNode = createTree(n);
//			newNode.setParent(root);
//		}

		for (Event e : thing.getEvents()) {
			Node nNode = createNodeFromEvent(e);
			nNode.setParent(root);
		}

		for (Property p : thing.getProperties()) {
			Node nNode = createNodeFromProperty(p);
			nNode.setParent(root);
		}

		return simulation;
	}
}
