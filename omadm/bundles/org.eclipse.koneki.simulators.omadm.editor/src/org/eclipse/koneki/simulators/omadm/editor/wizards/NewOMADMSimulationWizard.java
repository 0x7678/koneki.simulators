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
package org.eclipse.koneki.simulators.omadm.editor.wizards;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.koneki.simulators.omadm.editor.internal.Activator;
import org.eclipse.koneki.simulators.omadm.model.Device;
import org.eclipse.koneki.simulators.omadm.model.OMADMSimulation;
import org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorFactory;
import org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.part.FileEditorInput;

public class NewOMADMSimulationWizard extends Wizard implements INewWizard {

	private WizardNewFileCreationPage newFileCreationPage;
	private DevCreationWizardPage devCreationWizardPage;
	private DevInfoWizardPage devInfoWizardPage;
	private DevDetailWizardPage devDetailWizardPage;
	private IWizardPage currentPage;
	private Device device;

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle(org.eclipse.koneki.simulators.omadm.editor.Messages.Wizard_Title);

		device = OMADMSimulatorFactory.eINSTANCE.createDevice();
		device.setTree(NodeHelpers.initTree());

		this.newFileCreationPage = new WizardNewFileCreationPage(getClass().getName() + "#FileCreationPage", selection); //$NON-NLS-1$
		this.newFileCreationPage.setTitle(org.eclipse.koneki.simulators.omadm.editor.Messages.Wizard_NewFile_Title);
		this.newFileCreationPage.setDescription(org.eclipse.koneki.simulators.omadm.editor.Messages.Wizard_NewFile_Description);

		this.devCreationWizardPage = new DevCreationWizardPage(getClass().getName() + "#DevCreationPage"); //$NON-NLS-1$
		this.devCreationWizardPage.setTitle(org.eclipse.koneki.simulators.omadm.editor.Messages.Wizard_ConfigurationDevice_Title);
		this.devCreationWizardPage.setDescription(org.eclipse.koneki.simulators.omadm.editor.Messages.Wizard_ConfigurationDevice_Description);

		this.devInfoWizardPage = new DevInfoWizardPage(device, getClass().getName() + "#DevInfoPage"); //$NON-NLS-1$
		this.devInfoWizardPage.setTitle(Messages.NewOMADMSimulationWizard_Device_Information_title);
		this.devInfoWizardPage.setDescription(Messages.NewOMADMSimulationWizard_Device_Information_desc);

		this.devDetailWizardPage = new DevDetailWizardPage(device, getClass().getName() + "#DevDetailPage"); //$NON-NLS-1$
		this.devDetailWizardPage.setTitle(Messages.NewOMADMSimulationWizard_Device_Details_title);
		this.devDetailWizardPage.setDescription(Messages.NewOMADMSimulationWizard_Device_Details_desc);
	}

	@Override
	public void addPages() {
		addPage(this.newFileCreationPage);
		addPage(this.devCreationWizardPage);
		addPage(this.devInfoWizardPage);
		addPage(this.devDetailWizardPage);
	}

	@Override
	public IWizardPage getNextPage(final IWizardPage page) {
		if (page == devCreationWizardPage) {
			devInfoWizardPage.setDevice(devCreationWizardPage.getDevice());
		} else {

			if (page == devDetailWizardPage) {
				devDetailWizardPage.setDevice(devInfoWizardPage.getDevice());
			}
		}
		currentPage = super.getNextPage(page);
		return currentPage;
	}

	@Override
	public boolean performFinish() {

		// The simulation file wanted by the user
		final IFile file = ResourcesPlugin.getWorkspace().getRoot()
				.getFile(this.newFileCreationPage.getContainerFullPath().append(this.newFileCreationPage.getFileName() + ".xml")); //$NON-NLS-1$

		// The operation for create the file
		final WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.ui.actions.WorkspaceModifyOperation#execute(org.eclipse.core.runtime.IProgressMonitor)
			 */
			@Override
			protected void execute(IProgressMonitor progressMonitor) throws CoreException {
				final ResourceSet resourceSet = new ResourceSetImpl();
				final URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
				final Resource resource = resourceSet.createResource(fileURI, "com.swir.platform.simulators.omadm.model.OMADMSimulationModel"); //$NON-NLS-1$

				if (currentPage == devCreationWizardPage) {
					device = devCreationWizardPage.getDevice();
				} else {

					if (currentPage == devInfoWizardPage) {
						device = devInfoWizardPage.getDevice();
					} else {
						device = devDetailWizardPage.getDevice();
					}
				}

				final OMADMSimulation simulation = OMADMSimulatorFactory.eINSTANCE.createOMADMSimulation();
				simulation.setDevice(device);

				resource.getContents().add(simulation);

				try {
					resource.save(null);
				} catch (IOException e) {
					throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, Messages.NewOMADMSimulationWizard_Save_error, e));
				} finally {
					progressMonitor.done();
				}
			}

		};

		// Execute the operation
		try {
			getContainer().run(false, false, operation);

			// Open editor
			final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			final IEditorDescriptor defaultEditor = EditUIUtil.getDefaultEditor(URI.createPlatformResourceURI(file.getFullPath().toString(), false),
					null);
			page.openEditor(new FileEditorInput(file), defaultEditor.getId());
			return true;
		} catch (InvocationTargetException e) {
			MessageDialog.openError(getShell(), Messages.NewOMADMSimulationWizard_Open_Editor, Messages.NewOMADMSimulationWizard_Save_error);
			return false;
		} catch (InterruptedException e) {
			MessageDialog.openError(getShell(), Messages.NewOMADMSimulationWizard_Open_Editor, Messages.NewOMADMSimulationWizard_Save_error);
			return false;
		} catch (PartInitException e) {
			MessageDialog.openError(getShell(), Messages.NewOMADMSimulationWizard_Open_Editor, Messages.NewOMADMSimulationWizard_Open_error);
			return false;
		}
	}

	IFile getFile() {
		return ResourcesPlugin.getWorkspace().getRoot()
				.getFile(this.newFileCreationPage.getContainerFullPath().append(this.newFileCreationPage.getFileName() + ".xml")); //$NON-NLS-1$
	}

	IProject getProject() {
		return getFile().getProject();
	}

}
