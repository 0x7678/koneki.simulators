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

import org.eclipse.osgi.util.NLS;

//CHECKSTYLE NLS: OFF
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.koneki.simulators.omadm.editor.wizards.messages"; //$NON-NLS-1$
	public static String DevDetailWizardPage_DeviceType;
	public static String DevDetailWizardPage_FirmwareRevision;
	public static String DevDetailWizardPage_HardwareRevision;
	public static String DevDetailWizardPage_OEMName;
	public static String DevDetailWizardPage_SoftwareRevision;

	public static String NewOMADMSimulationWizard_Device_Details_desc;
	public static String NewOMADMSimulationWizard_Device_Details_title;
	public static String NewOMADMSimulationWizard_Device_Information_desc;
	public static String NewOMADMSimulationWizard_Device_Information_title;
	public static String NewOMADMSimulationWizard_Open_Editor;
	public static String NewOMADMSimulationWizard_Open_error;
	public static String NewOMADMSimulationWizard_Save_error;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
// CHECKSTYLE NLS: ON
