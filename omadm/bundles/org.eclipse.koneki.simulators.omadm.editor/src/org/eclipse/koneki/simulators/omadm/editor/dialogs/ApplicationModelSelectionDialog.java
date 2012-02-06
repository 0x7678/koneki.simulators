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
package org.eclipse.koneki.simulators.omadm.editor.dialogs;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.koneki.commons.ui.widgets.InfoBanner;
import org.eclipse.koneki.simulators.omadm.editor.internal.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class ApplicationModelSelectionDialog extends Dialog {
	private static final int DIALOG_WIDTH = 400;

	private static final int DIALOG_HEIGHT = 350;

	private final IContainer root;

	private IFile selection;

	public ApplicationModelSelectionDialog(Shell parentShell, IContainer root) {
		super(parentShell);
		this.root = root;
	}

	@Override
	protected void configureShell(Shell newShell) {
		newShell.setText("Application model selection");
		super.configureShell(newShell);
	}

	public IFile getSelectedApplicationIFile() {
		return selection;
	}

	/**
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		GridDataFactory.fillDefaults().grab(true, true).hint(DIALOG_WIDTH, DIALOG_HEIGHT).applyTo(composite);

		InfoBanner infoBanner = new InfoBanner(composite, SWT.NONE);

		infoBanner.setIcon(Activator.getDefault().getImage(Activator.INFO_32));
		infoBanner
				.getFormText()
				.setText(
						"<form>Associating a Application model will offer you new features:<li bindent=\"20\">Quick overridable paremeters visualization</li><li bindent=\"20\">Quick parameters overriding</li></form>",
						true, true);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(infoBanner);

		InfoBanner infoBanner2 = new InfoBanner(composite, SWT.NONE);
		infoBanner2.setIcon(Activator.getDefault().getImage(Activator.INFO_32));
		infoBanner2.getFormText().setText("<form>You only see Application models present in the \"" + root.getName() + "\" project.</form>", true,
				true);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(infoBanner2);

		TreeViewer treeViewer = new TreeViewer(composite, SWT.SINGLE | SWT.BORDER);
		treeViewer.setContentProvider(new WorkbenchContentProvider());
		treeViewer.setLabelProvider(new WorkbenchLabelProvider());
		treeViewer.addFilter(new FileExtensionFilter(new String[] { "*.xml" }, new ApplicationModelFilter())); //$NON-NLS-1$
		GridDataFactory.fillDefaults().grab(true, true).applyTo(treeViewer.getControl());
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection sel = (IStructuredSelection) event.getSelection();
				boolean validSelection = false;
				if (!sel.isEmpty() && sel.getFirstElement() instanceof IFile) {
					selection = (IFile) sel.getFirstElement();
					validSelection = true;
				}
				getButton(IDialogConstants.OK_ID).setEnabled(validSelection);
			}
		});
		GridDataFactory.fillDefaults().grab(false, true).applyTo(treeViewer.getTree());
		treeViewer.setInput(root);
		composite.setFocus();

		return composite;
	}

	/**
	 * @see org.eclipse.jface.dialogs.Dialog#createContents(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {
		Control control = super.createContents(parent);

		getButton(IDialogConstants.OK_ID).setEnabled(false);
		return control;
	}

	private class FileExtensionFilter extends ViewerFilter {
		private final String[] acceptedExtensions;

		private final ViewerFilter customFilter;

		public FileExtensionFilter(String[] acceptedExtensions, ViewerFilter customFilter) {
			this.acceptedExtensions = acceptedExtensions;
			this.customFilter = customFilter;
		}

		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			IResource resource = (IResource) element;

			if ((resource instanceof IFolder) && (!resource.getName().startsWith("."))) //$NON-NLS-1$
				return true;
			else if (resource instanceof IFile) {
				IFile file = (IFile) resource;
				String fileExtension = file.getFileExtension();
				for (String extension : acceptedExtensions) {
					if (extension.endsWith(fileExtension)) {
						// Ask the client to filter only when the element passes
						// the local filter
						return customFilter.select(viewer, parentElement, element);
					}
				}
			}
			return false;
		}
	}
}
