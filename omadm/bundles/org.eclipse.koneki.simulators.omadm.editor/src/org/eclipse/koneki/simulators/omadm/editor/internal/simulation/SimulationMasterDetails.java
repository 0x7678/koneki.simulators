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
package org.eclipse.koneki.simulators.omadm.editor.internal.simulation;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.koneki.simulators.omadm.editor.Messages;
import org.eclipse.koneki.simulators.omadm.editor.OMADMSimulatorEditor;
import org.eclipse.koneki.simulators.omadm.model.Node;
import org.eclipse.pde.emfforms.editor.EmfFormEditor;
import org.eclipse.pde.emfforms.editor.EmfMasterDetailBlock;
import org.eclipse.ui.forms.IDetailsPage;

public class SimulationMasterDetails extends EmfMasterDetailBlock {

	public SimulationMasterDetails(EmfFormEditor<?> editor) {
		super(editor, Messages.DeviceSection_Title);
	}

	@Override
	public IDetailsPage getPage(Object key) {
		return new SimulationPart(getEditor());
	}

	@Override
	protected void createContextMenuFor(StructuredViewer viewer) {
		final MenuManager menuManager = new MenuManager();
		menuManager.setRemoveAllWhenShown(true);
		menuManager.addMenuListener(this);
		viewer.getControl().setMenu(menuManager.createContextMenu(viewer.getControl()));
	}

	@Override
	public void menuAboutToShow(IMenuManager manager) {
		if (getTreeViewer().getSelection() instanceof TreeSelection) {
			final TreeSelection selection = (TreeSelection) getTreeViewer().getSelection();
			if (selection.size() == 1) {
				if (selection.getFirstElement() instanceof Node) {
					menuAboutToShowForNode(manager, (Node) selection.getFirstElement());
				}
			}
		}
	}

	private void menuAboutToShowForNode(IMenuManager manager, final Node node) {
		manager.add(new AddInteriorNode(getEditor(), node));
		manager.add(new AddLeafNode(getEditor(), node));
		manager.add(new DeleteNode(getEditor(), node));
	}

	@Override
	public OMADMSimulatorEditor getEditor() {
		return (OMADMSimulatorEditor) super.getEditor();
	}

}
