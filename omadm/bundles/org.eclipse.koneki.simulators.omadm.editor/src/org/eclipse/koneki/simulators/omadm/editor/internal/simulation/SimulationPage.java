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

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.koneki.commons.ui.ANWRTToolkit;
import org.eclipse.koneki.commons.ui.CommonFonts;
import org.eclipse.koneki.commons.ui.widgets.InfoBanner;
import org.eclipse.koneki.simulators.omadm.editor.Messages;
import org.eclipse.koneki.simulators.omadm.editor.OMADMSimulatorEditor;
import org.eclipse.koneki.simulators.omadm.editor.internal.dashboard.DashboardPage;
import org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage;
import org.eclipse.pde.emfforms.editor.AbstractEmfFormPage;
import org.eclipse.pde.emfforms.editor.EmfMasterDetailBlock;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;

public class SimulationPage extends AbstractEmfFormPage {

	public SimulationPage(OMADMSimulatorEditor editor) {
		super(editor, 1, Messages.SimulationPage_Title);
		this.masterDetail = new SimulationMasterDetails(editor);
	}

	@Override
	public String getId() {
		return getClass().getName();
	}

	@Override
	public void bind(DataBindingContext bindingContext) {
		bindingContext.bindValue(ViewerProperties.input().observe(this.masterDetail.getTreeViewer()), EMFEditObservables.observeDetailValue(
				Realm.getDefault(), getEditor().getEditingDomain(), getEditor().getInputObservable(),
				OMADMSimulatorPackage.Literals.OMADM_SIMULATION__DEVICE));
	}

	@Override
	public void createContents(Composite parent) {
		final ANWRTToolkit toolkit = getEditor().getANWRTToolkit();

		final Composite pageComposite = toolkit.createComposite(getManagedForm().getForm().getBody());
		GridLayoutFactory.swtDefaults().numColumns(1).spacing(20, 20).applyTo(pageComposite);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(pageComposite);

		final InfoBanner infoBanner = toolkit.createInfoBanner(pageComposite);
		infoBanner.getFormText().setText(Messages.SimulationPage_InfoBanner, true, true);
		infoBanner.getFormText().setFont(CommonFonts.BOLD);
		infoBanner.getFormText().addHyperlinkListener(new HyperlinkAdapter() {

			@Override
			public void linkActivated(HyperlinkEvent e) {
				getEditor().setActivePage(DashboardPage.class.getName());
			}

		});
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(infoBanner);

		this.masterDetail.createContent(getManagedForm());
	}

	@Override
	protected EmfMasterDetailBlock getMainMasterDetailBlock() {
		return this.masterDetail;
	}

	@Override
	public OMADMSimulatorEditor getEditor() {
		return (OMADMSimulatorEditor) super.getEditor();
	}

	private final EmfMasterDetailBlock masterDetail;
}
