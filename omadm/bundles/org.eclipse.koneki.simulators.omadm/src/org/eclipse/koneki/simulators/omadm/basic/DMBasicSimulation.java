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
package org.eclipse.koneki.simulators.omadm.basic;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.koneki.protocols.omadm.CommandHandler;
import org.eclipse.koneki.protocols.omadm.DMAuthentication;
import org.eclipse.koneki.protocols.omadm.DMGenericAlert;
import org.eclipse.koneki.protocols.omadm.DMNode;
import org.eclipse.koneki.protocols.omadm.ProtocolListener;
import org.eclipse.koneki.protocols.omadm.Status;
import org.eclipse.koneki.protocols.omadm.StatusCode;
import org.eclipse.koneki.simulators.omadm.DMSimulatorException;
import org.eclipse.koneki.simulators.omadm.internal.Activator;
import org.eclipse.koneki.simulators.omadm.model.AuthenticationType;
import org.eclipse.koneki.simulators.omadm.model.Node;
import org.eclipse.koneki.simulators.omadm.model.NodeFormat;
import org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers;
import org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers.NodeIterator;

final class DMBasicSimulation implements Runnable, CommandHandler {

	private static final String AUTH_SECRET = "AuthSecret"; //$NON-NLS-1$
	private static final String AUTH_NAME = "AuthName"; //$NON-NLS-1$
	private static final String APP_AUTH = "./DMAcc/AppAuth"; //$NON-NLS-1$

	private final DMBasicSimulator dmSimulator;
	private final URI server;
	private final Node tree;
	private final EditingDomain editingDomain;
	private final CommandHandler commandHandler;
	private final ProtocolListener[] protocolListeners;
	private final DMGenericAlert[] genericAlerts;
	private final AuthenticationType authentication;

	public DMBasicSimulation(final DMBasicSimulator dmSimulator, final URI server, final Node tree, final EditingDomain editingDomain,
			final CommandHandler commandHandler, final ProtocolListener[] protocolListeners, final DMGenericAlert[] genericAlerts) {
		this.dmSimulator = dmSimulator;
		this.server = server;
		this.tree = tree;
		this.authentication = AuthenticationType.NONE;
		this.editingDomain = editingDomain;
		this.commandHandler = commandHandler;
		this.protocolListeners = protocolListeners;
		this.genericAlerts = genericAlerts;
	}

	public DMBasicSimulation(final DMBasicSimulator dmSimulator, final URI server, final Node tree, final AuthenticationType authentication,
			final EditingDomain editingDomain, final CommandHandler commandHandler, final ProtocolListener[] protocolListeners,
			final DMGenericAlert[] genericAlerts) {
		this.dmSimulator = dmSimulator;
		this.server = server;
		this.tree = tree;
		this.authentication = authentication;
		this.editingDomain = editingDomain;
		this.commandHandler = commandHandler;
		this.protocolListeners = protocolListeners;
		this.genericAlerts = genericAlerts;
	}

	@Override
	public void run() {
		try {
			final Node devInfo = NodeHelpers.getNode(this.tree, "./DevInfo"); //$NON-NLS-1$
			if (devInfo == null) {
				throw new DMSimulatorException("The ./DevInfo node does not exist"); //$NON-NLS-1$
			}

			final Node devId = NodeHelpers.getNode(devInfo, "DevInfo/DevId"); //$NON-NLS-1$
			if (devId == null) {
				throw new DMSimulatorException("The ./DevInfo/DevId node does not exist"); //$NON-NLS-1$
			}
			final URI client;
			try {
				client = new URI(devId.getData());
			} catch (final URISyntaxException e) {
				throw new DMSimulatorException(e);
			}

			final List<DMNode> devInfoNodes = new LinkedList<DMNode>();
			NodeHelpers.iterate(devInfo, new NodeIterator() {

				@Override
				public void currentNode(final Node node) {
					if (node.isLeaf()) {
						devInfoNodes.add(new DMNode(node.getPath(), node.getFormat().getLiteral(), node.getType(), node.getData()));
					}
				}

			});

			org.eclipse.koneki.protocols.omadm.AuthenticationType authType = null;

			switch (authentication.getValue()) {
			case (AuthenticationType.NONE_VALUE):
				// dmAuth = new DMAuthentication();
				authType = org.eclipse.koneki.protocols.omadm.AuthenticationType.NONE;
				break;
			case (AuthenticationType.BASIC_VALUE):

				authType = org.eclipse.koneki.protocols.omadm.AuthenticationType.BASIC;
				break;
			case (AuthenticationType.HMAC_VALUE):
				authType = org.eclipse.koneki.protocols.omadm.AuthenticationType.HMAC;
				break;
			case (AuthenticationType.MD5_VALUE):
				authType = org.eclipse.koneki.protocols.omadm.AuthenticationType.MD5;
				break;
			}

			String userName = NodeHelpers.findFirstNode(NodeHelpers.getNode(tree, APP_AUTH), AUTH_NAME).getData();
			String userPassword = NodeHelpers.findFirstNode(NodeHelpers.getNode(tree, APP_AUTH), AUTH_SECRET).getData();
			DMAuthentication dmAuth = new DMAuthentication(authType, userName, userPassword);

			this.dmSimulator.getDMClient().initiateManagementSession(this.server, dmAuth, client, devInfoNodes.toArray(new DMNode[0]), this,
					this.protocolListeners, this.genericAlerts);
		} catch (final DMSimulatorException e) {
			Activator.logError("Problem while initializing management session", e); //$NON-NLS-1$
		}
	}

	@Override
	public Status add(final String target, final String format, final String type, final String data) {
		final Node ancestorNode = NodeHelpers.getExistAncestorNode(this.tree, target);
		switch (ancestorNode.getRealAddManagement()) {
		case AUTOMATIC:
			return DMCommandHelper.add(this.tree, this.editingDomain, target, format, type, data, false);
		case CONSTANT:
			final int code = ancestorNode.getRealAddCode();
			if (code == StatusCode.OK.getCode()) {
				return DMCommandHelper.add(this.tree, this.editingDomain, target, format, type, data, true);
			} else {
				return StatusCode.fromInt(code);
			}
		default:
			return this.commandHandler.add(target, format, type, data);
		}
	}

	@Override
	public Status copy(final String target, final String source) {
		final Node ancestorNode = NodeHelpers.getExistAncestorNode(this.tree, target);
		switch (ancestorNode.getRealCopyManagement()) {
		case AUTOMATIC:
			return DMCommandHelper.copy(this.tree, this.editingDomain, target, source, false);
		case CONSTANT:
			final int code = ancestorNode.getRealCopyCode();
			if (code == StatusCode.OK.getCode()) {
				return DMCommandHelper.copy(this.tree, this.editingDomain, target, source, true);
			} else {
				return StatusCode.fromInt(code);
			}
		default:
			return this.commandHandler.copy(target, source);
		}
	}

	@Override
	public Status delete(final String target) {
		final Node ancestorNode = NodeHelpers.getExistAncestorNode(this.tree, target);
		switch (ancestorNode.getRealDeleteManagement()) {
		case AUTOMATIC:
			return DMCommandHelper.delete(this.tree, this.editingDomain, target, false);
		case CONSTANT:
			final int code = ancestorNode.getRealDeleteCode();
			if (code == StatusCode.OK.getCode()) {
				return DMCommandHelper.delete(this.tree, this.editingDomain, target, true);
			} else {
				return StatusCode.fromInt(code);
			}
		default:
			return this.commandHandler.delete(target);
		}
	}

	@Override
	public Status get(final String target) {
		final Node ancestorNode = NodeHelpers.getExistAncestorNode(this.tree, target);
		switch (ancestorNode.getRealGetManagement()) {
		case AUTOMATIC:
			return DMCommandHelper.get(this.tree, this.editingDomain, target, false);
		case CONSTANT:
			final int code = ancestorNode.getRealGetCode();
			if (code == StatusCode.OK.getCode()) {
				return DMCommandHelper.get(this.tree, this.editingDomain, target, true);
			} else {
				return StatusCode.fromInt(code);
			}
		default:
			return this.commandHandler.get(target);
		}
	}

	@Override
	public Status exec(final String target, final String correlator, final String format, final String type, final String data) {
		final Node node = NodeHelpers.getNode(this.tree, target);
		if (node != null) {
			switch (node.getRealExecManagement()) {
			case AUTOMATIC:
				return this.dmSimulator.exec(node, this.editingDomain, correlator, format, type, data, false);
			case CONSTANT:
				return StatusCode.fromInt(node.getRealExecCode());
			default:
				return this.dmSimulator.exec(node, this.editingDomain, correlator, format, type, data, true);
			}
		} else {
			final Node ancestorNode = NodeHelpers.getExistAncestorNode(this.tree, target);
			switch (ancestorNode.getRealExecManagement()) {
			case AUTOMATIC:
				return StatusCode.NOT_FOUND;
			case CONSTANT:
				return StatusCode.fromInt(ancestorNode.getRealExecCode());
			default:
				DMCommandHelper.add(tree, editingDomain, target, NodeFormat.NODE.getLiteral(), "", "", true); //$NON-NLS-1$ //$NON-NLS-2$
				return this.dmSimulator.exec(node, this.editingDomain, correlator, format, type, data, true);
			}
		}
	}

	@Override
	public Status replace(final String target, final String format, final String type, final String data) {
		final Node ancestorNode = NodeHelpers.getExistAncestorNode(this.tree, target);
		switch (ancestorNode.getRealReplaceManagement()) {
		case AUTOMATIC:
			return DMCommandHelper.replace(this.tree, this.editingDomain, target, format, type, data, false);
		case CONSTANT:
			final int code = ancestorNode.getRealReplaceCode();
			if (code == StatusCode.OK.getCode()) {
				return DMCommandHelper.replace(this.tree, this.editingDomain, target, format, type, data, true);
			} else {
				return StatusCode.fromInt(code);
			}
		default:
			return this.commandHandler.replace(target, format, type, data);
		}
	}

}
