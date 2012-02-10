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

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.koneki.simulators.omadm.model.Device;
import org.eclipse.koneki.simulators.omadm.model.DeviceIdType;
import org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class DevDetailWizardPage extends WizardPage implements IWizardPage {

	private static final String SW_V = "SwV"; //$NON-NLS-1$
	private static final String FW_V = "FwV"; //$NON-NLS-1$

	private Device device;
	private Text devTypText;
	private Text oemText;
	private Text fwVText;
	private Text swVText;
	private Text hwVText;

	public DevDetailWizardPage(final Device device, final String pageName) {
		super(pageName);
		this.device = device;
	}

	@Override
	public void createControl(final Composite parent) {
		final Composite devDetailComposite = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(devDetailComposite);

		new Label(devDetailComposite, SWT.NONE).setText(Messages.DevDetailWizardPage_DeviceType);
		this.devTypText = new Text(devDetailComposite, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(this.devTypText);

		new Label(devDetailComposite, SWT.NONE).setText(Messages.DevDetailWizardPage_OEMName);
		this.oemText = new Text(devDetailComposite, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(this.oemText);

		new Label(devDetailComposite, SWT.NONE).setText(Messages.DevDetailWizardPage_FirmwareRevision);
		this.fwVText = new Text(devDetailComposite, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(this.fwVText);

		new Label(devDetailComposite, SWT.NONE).setText(Messages.DevDetailWizardPage_SoftwareRevision);
		this.swVText = new Text(devDetailComposite, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(this.swVText);

		new Label(devDetailComposite, SWT.NONE).setText(Messages.DevDetailWizardPage_HardwareRevision);
		this.hwVText = new Text(devDetailComposite, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(this.hwVText);

		setControl(devDetailComposite);
	}

	public String getDevTyp() {
		return this.devTypText.getText();
	}

	public boolean isDevTypSet() {
		return !this.devTypText.getText().isEmpty();
	}

	public String getOEM() {
		return this.oemText.getText();
	}

	public boolean isOEMSet() {
		return !this.oemText.getText().isEmpty();
	}

	public String getFwV() {
		return this.fwVText.getText();
	}

	public boolean isFwVSet() {
		return !this.fwVText.getText().isEmpty();
	}

	public String getSwV() {
		return this.swVText.getText();
	}

	public boolean isSwVSet() {
		return !this.swVText.getText().isEmpty();
	}

	public String getHwV() {
		return this.hwVText.getText();
	}

	public boolean isHwVSet() {
		return !this.hwVText.getText().isEmpty();
	}

	public Device getDevice() {

		NodeHelpers.findFirstNode(device.getTree(), FW_V).setData(getFwV());
		NodeHelpers.findFirstNode(device.getTree(), SW_V).setData(getSwV());
		device.setDeviceIdType(DeviceIdType.getByName(devTypText.getText()));
		return device;
	}

	public void setDevice(final Device device) {
		devTypText.setText(device.getDeviceIdType().getName());
		this.device = device;
	}

}
