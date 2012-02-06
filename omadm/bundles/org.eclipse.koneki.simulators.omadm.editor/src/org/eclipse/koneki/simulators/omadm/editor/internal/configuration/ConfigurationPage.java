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
package org.eclipse.koneki.simulators.omadm.editor.internal.configuration;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.koneki.commons.ui.ANWRTToolkit;
import org.eclipse.koneki.commons.ui.CommonFonts;
import org.eclipse.koneki.commons.ui.widgets.InfoBanner;
import org.eclipse.koneki.simulators.omadm.editor.Messages;
import org.eclipse.koneki.simulators.omadm.editor.OMADMSimulatorEditor;
import org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage;
import org.eclipse.pde.emfforms.editor.AbstractEmfFormPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.Section;

public class ConfigurationPage extends AbstractEmfFormPage {

	public ConfigurationPage(OMADMSimulatorEditor editor) {
		super(editor, 1, Messages.ConfigurationPage_Title);
	}

	@Override
	public String getId() {
		return getClass().getName();
	}

	@Override
	public void bind(DataBindingContext bindingContext) {
		final EditingDomain editingDomain = getEditor().getEditingDomain();
		final IObservableValue simulationObservable = getEditor().getInputObservable();
		final IObservableValue deviceObservable = EMFEditObservables.observeDetailValue(Realm.getDefault(), editingDomain, simulationObservable,
				OMADMSimulatorPackage.Literals.OMADM_SIMULATION__DEVICE);

		// ServerURI
		bindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(this.serverURI), EMFEditObservables.observeDetailValue(Realm.getDefault(),
				editingDomain, deviceObservable, OMADMSimulatorPackage.Literals.DEVICE__SERVER_URL));

		// ServerLogin
		bindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(this.serverLogin), EMFEditObservables.observeDetailValue(
				Realm.getDefault(), editingDomain, deviceObservable, OMADMSimulatorPackage.Literals.DEVICE__LOGIN));

		// ServerPassord
		bindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(this.serverPassword), EMFEditObservables.observeDetailValue(
				Realm.getDefault(), editingDomain, deviceObservable, OMADMSimulatorPackage.Literals.DEVICE__PASSWORD));

		// DeviceId
		bindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(this.deviceIdText), EMFEditObservables.observeDetailValue(
				Realm.getDefault(), editingDomain, deviceObservable, OMADMSimulatorPackage.Literals.DEVICE__DEVICE_ID));
	}

	@Override
	public void createContents(Composite parent) {
		final ANWRTToolkit toolkit = getEditor().getANWRTToolkit();

		final Composite pageComposite = toolkit.createComposite(parent);
		GridLayoutFactory.fillDefaults().numColumns(1).spacing(20, 20).applyTo(pageComposite);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(pageComposite);

		final InfoBanner infoBanner = toolkit.createInfoBanner(pageComposite);
		infoBanner.getFormText().setText(Messages.ConfigurationPage_InfoBanner, true, true);
		infoBanner.getFormText().setFont(CommonFonts.BOLD);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(infoBanner);

		createServerSettings(pageComposite, toolkit);
	}

	private void createServerSettings(Composite parent, ANWRTToolkit toolkit) {
		final Section serverSettingsSection = toolkit.createSection(parent, ExpandableComposite.TITLE_BAR);
		serverSettingsSection.setText(Messages.ConfigurationPage_ServerSettingsTitle);
		GridDataFactory.fillDefaults().grab(false, false).applyTo(serverSettingsSection);

		final Composite serverSettingsComposite = toolkit.createComposite(serverSettingsSection);
		GridLayoutFactory.fillDefaults().numColumns(3).applyTo(serverSettingsComposite);
		// currentShell = serverSettingsSection.getShell();

		// Server URI
		serverURI = toolkit.createTitleLabelAndText(serverSettingsComposite, Messages.ConfigurationPage_ServerURI);
		GridDataFactory.fillDefaults().grab(true, false).span(2, 0).applyTo(serverURI);

		// Server Login
		serverLogin = toolkit.createTitleLabelAndText(serverSettingsComposite, Messages.ConfigurationPage_ServerLogin);
		GridDataFactory.fillDefaults().grab(true, false).span(2, 0).applyTo(serverLogin);

		// Server password
		serverPassword = toolkit.createTitleLabelAndText(serverSettingsComposite, Messages.ConfigurationPage_ServerPassword, SWT.DEFAULT,
				SWT.PASSWORD);
		GridDataFactory.fillDefaults().grab(true, false).span(2, 0).applyTo(serverPassword);

		// DeviceId
		deviceIdText = toolkit.createTitleLabelAndText(serverSettingsComposite, Messages.ConfigurationPage_DeviceID);
		GridDataFactory.fillDefaults().grab(true, false).span(2, 0).applyTo(deviceIdText);

		// The association button
		//
		// Label associateLabel = toolkit.createTitleLabel(serverSettingsComposite, Messages.SimulationPage_AssociateLabel);
		// GridDataFactory.fillDefaults().grab(false, false).span(0, 0).applyTo(associateLabel);
		//
		// associatedModel = toolkit.createLabel(serverSettingsComposite, Messages.SimulationPage_DefaultAssociatedFile);
		// GridDataFactory.fillDefaults().grab(false, false).span(1, 0).applyTo(associatedModel);
		//
		// Label model = toolkit.createLabel(serverSettingsComposite, Messages.SimulationPage_DefaultAssociatedFile);
		// GridDataFactory.fillDefaults().grab(true, false).span(0, 0).applyTo(model);
		//
		//
		// associateModelButton = toolkit.createButton(serverSettingsComposite, Messages.SimulationPage_AssociateButton, SWT.PUSH);
		// associateModelButton.setImage(Activator.getDefault().getImage(Activator.LINK_16));
		// associateModelButton.addSelectionListener(new SelectionAdapter() {
		// @Override
		// public void widgetSelected(SelectionEvent e) {
		//
		// associateModel();
		// }
		// });
		// GridDataFactory.fillDefaults().grab(false, true).span(0, 0).applyTo(associateModelButton);

		serverSettingsSection.setClient(serverSettingsComposite);

		getEditor();
	}

	private Text serverURI;
	private Text serverLogin;
	private Text serverPassword;
	// private Shell currentShell;
	private Text deviceIdText;

	// private Button associateModelButton;
	// private Label associatedModel;

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public OMADMSimulatorEditor getEditor() {
		return (OMADMSimulatorEditor) super.getEditor();
	}

}
