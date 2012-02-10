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
import org.eclipse.koneki.simulators.omadm.editor.Messages;
import org.eclipse.koneki.simulators.omadm.model.Device;
import org.eclipse.koneki.simulators.omadm.model.util.DeviceHelpers;
import org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class DevInfoWizardPage extends WizardPage implements IWizardPage {

	private static final String LANG = "Lang"; //$NON-NLS-1$
	private static final String MOD = "Mod"; //$NON-NLS-1$
	private static final String MAN = "Man"; //$NON-NLS-1$

	private Device device;
	private Text devIdText;
	private Text manText;
	private Text modText;
	private Text langText;

	public DevInfoWizardPage(final Device device, final String pageName) {
		super(pageName);
		this.device = device;
	}

	@Override
	public void createControl(final Composite parent) {
		final Composite devInfoComposite = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(devInfoComposite);

		new Label(devInfoComposite, SWT.NONE).setText(Messages.DevInfoWizardPage_DeviceId);
		this.devIdText = new Text(devInfoComposite, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(this.devIdText);

		new Label(devInfoComposite, SWT.NONE).setText(Messages.DevInfoWizardPage_ManufacturerName);
		this.manText = new Text(devInfoComposite, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(this.manText);

		new Label(devInfoComposite, SWT.NONE).setText(Messages.DevInfoWizardPage_ModelName);
		this.modText = new Text(devInfoComposite, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(this.modText);

		new Label(devInfoComposite, SWT.NONE).setText(Messages.DevInfoWizardPage_Language);
		this.langText = new Text(devInfoComposite, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(this.langText);

		hookListeners();
		validatePage();
		setControl(devInfoComposite);
	}

	private void hookListeners() {
		this.devIdText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(final ModifyEvent e) {
				validatePage();
			}

		});
	}

	private void validatePage() {
		device.setDeviceId(this.devIdText.getText());
		if (!DeviceHelpers.isValidDeviceId(device)) {
			setMessage(Messages.Wizard_DeviceID_Is_Invalid, WizardPage.ERROR);
			setPageComplete(false);
		} else {
			setMessage(null);
			setPageComplete(true);
		}
	}

	public String getDevId() {
		return this.devIdText.getText();
	}

	public String getMan() {
		return this.manText.getText();
	}

	public boolean isManSet() {
		return !this.manText.getText().isEmpty();
	}

	public String getMod() {
		return this.modText.getText();
	}

	public boolean isModSet() {
		return !this.modText.getText().isEmpty();
	}

	public String getLang() {
		return this.langText.getText();
	}

	public boolean isLangSet() {
		return !this.langText.getText().isEmpty();
	}

	public void setDevId(final String devId) {
		this.devIdText.setText(devId);
	}

	public void setDevice(final Device device) {
		this.device = device;
		devIdText.setText(device.getDeviceId().replace(device.getDeviceIdType().getName() + ":", "")); //$NON-NLS-1$ //$NON-NLS-2$
		modText.setText(NodeHelpers.findFirstNode(device.getTree(), MOD).getData());
		manText.setText(NodeHelpers.findFirstNode(device.getTree(), MAN).getData());
	}

	public Device getDevice() {
		NodeHelpers.findFirstNode(device.getTree(), MAN).setData(getMan());
		NodeHelpers.findFirstNode(device.getTree(), MOD).setData(getMod());
		device.setDeviceId(device.getDeviceIdType().getName() + ":" + getDevId()); //$NON-NLS-1$
		NodeHelpers.findFirstNode(device.getTree(), LANG).setData(getLang());
		return device;
	}

}
