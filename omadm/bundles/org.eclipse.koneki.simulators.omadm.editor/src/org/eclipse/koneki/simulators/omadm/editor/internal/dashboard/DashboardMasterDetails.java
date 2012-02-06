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
package org.eclipse.koneki.simulators.omadm.editor.internal.dashboard;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.koneki.simulators.omadm.editor.Messages;
import org.eclipse.koneki.simulators.omadm.editor.OMADMSimulatorEditor;
import org.eclipse.pde.emfforms.editor.EmfMasterDetailBlock;
import org.eclipse.ui.forms.IDetailsPage;

public class DashboardMasterDetails extends EmfMasterDetailBlock {

	public DashboardMasterDetails(DashboardPage page) {
		super(page.getEditor(), Messages.DeviceSection_Title);
		this.page = page;
	}

	@Override
	public IDetailsPage getPage(Object key) {
		return new DashboardPart(this.page);
	}

	@Override
	protected void createContextMenuFor(StructuredViewer viewer) {
	}

	@Override
	public void menuAboutToShow(IMenuManager manager) {
	}

	@Override
	public OMADMSimulatorEditor getEditor() {
		return (OMADMSimulatorEditor) super.getEditor();
	}

	private final DashboardPage page;

}
