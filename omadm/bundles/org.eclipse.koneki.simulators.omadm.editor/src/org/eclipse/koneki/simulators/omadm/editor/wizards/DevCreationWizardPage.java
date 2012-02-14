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

import org.eclipse.core.resources.IContainer;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.koneki.simulators.omadm.editor.Messages;
import org.eclipse.koneki.simulators.omadm.model.Device;
import org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorFactory;
import org.eclipse.koneki.simulators.omadm.model.util.DeviceHelpers;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class DevCreationWizardPage extends WizardPage implements IWizardPage {

	private final Device device;
	private Text deviceIDText;
	private Text serverPasswordText;
	private Text serverLoginText;
	private Text serverURIText;

	public DevCreationWizardPage(final String pageName) {
		super(pageName);
		device = OMADMSimulatorFactory.eINSTANCE.createDevice();
	}

	@Override
	public void createControl(final Composite parent) {

		final Composite devCreationComposite = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(3).applyTo(devCreationComposite);

		Label serverURILabel = new Label(devCreationComposite, SWT.NONE);
		serverURILabel.setText(Messages.ConfigurationPage_ServerURI);
		GridDataFactory.fillDefaults().grab(false, false).span(0, 0).applyTo(serverURILabel);

		serverURIText = new Text(devCreationComposite, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).span(2, 0).applyTo(serverURIText);

		Label label = new Label(devCreationComposite, SWT.NONE);
		label.setText(Messages.ConfigurationPage_ServerLogin);
		GridDataFactory.fillDefaults().grab(false, false).span(0, 0).applyTo(label);

		serverLoginText = new Text(devCreationComposite, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).span(2, 0).applyTo(serverLoginText);

		label = new Label(devCreationComposite, SWT.NONE);
		label.setText(Messages.ConfigurationPage_ServerPassword);
		GridDataFactory.fillDefaults().grab(false, false).span(0, 0).applyTo(label);

		serverPasswordText = new Text(devCreationComposite, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).span(2, 0).applyTo(serverPasswordText);

		label = new Label(devCreationComposite, SWT.NONE);
		label.setText(Messages.ConfigurationPage_DeviceID);
		GridDataFactory.fillDefaults().grab(false, false).span(0, 0).applyTo(label);

		deviceIDText = new Text(devCreationComposite, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).span(2, 0).applyTo(deviceIDText);

		hookListeners();
		setControl(devCreationComposite);
	}

	protected IContainer getSelectedContainer() {

		return ((NewOMADMSimulationWizard) getWizard()).getProject();
	}

	protected void validatePage() {
		device.setDeviceId(this.deviceIDText.getText());
		if (!DeviceHelpers.isValidDeviceId(device)) {
			setMessage(Messages.Wizard_DeviceID_Is_Invalid, WizardPage.ERROR);
			setPageComplete(false);
		} else {
			setMessage(null);
			setPageComplete(true);
		}
	}

	protected void hookListeners() {

		this.deviceIDText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(final ModifyEvent e) {
				validatePage();
			}

		});

	}

	public Device getDevice() {
		device.setServerUrl(serverURIText.getText());
		device.setLogin(serverLoginText.getText());
		device.setPassword(serverPasswordText.getText());
		device.setDeviceId(deviceIDText.getText());
		return device;
	}

}
