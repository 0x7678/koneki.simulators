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
package org.eclipse.koneki.simulators.omadm.editor;

import org.eclipse.osgi.util.NLS;

/**
 * I18N class
 * 
 * CHECKSTYLE NLS: OFF
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.koneki.simulators.omadm.editor.messages"; //$NON-NLS-1$

	public static String SimulationPage_Title;
	public static String SimulationPage_InfoBanner;

	public static String ConfigurationPage_Title;
	public static String ConfigurationPage_InfoBanner;
	public static String ConfigurationPage_ServerSettingsTitle;
	public static String ConfigurationPage_ServerURI;
	public static String ConfigurationPage_ServerLogin;
	public static String ConfigurationPage_ServerPassword;
	public static String ConfigurationPage_SaveSettings;
	public static String ConfigurationPage_DeviceID;

	public static String DeviceSection_Title;
	public static String DeviceSection_Description;

	public static String DevInfoWizardPage_DeviceId;

	public static String DevInfoWizardPage_Language;

	public static String DevInfoWizardPage_ManufacturerName;

	public static String DevInfoWizardPage_ModelName;
	public static String DashBoardPage_ManagementSection_Title;
	public static String DashBoardPage_ManagementSection_Clear;
	public static String DashBoardPage_ManagementSection_Command;
	public static String DashBoardPage_ManagementSection_Messages;
	public static String DashBoardPage_ManagementSection_ConnectButton;
	public static String DashBoardPage_ManagementSection_Session;
	public static String DashBoardPage_ManagementSection_Server;
	public static String DashBoardPage_ManagementSection_Client;

	public static String NodeManagementSection_Title;
	public static String NodeManagementSection_Get;
	public static String NodeManagementSection_Add;
	public static String NodeManagementSection_Delete;
	public static String NodeManagementSection_Copy;
	public static String NodeManagementSection_Replace;
	public static String NodeManagementSection_Exec;

	public static String PropertiesSection_Title;
	public static String PropertiesSection_Title_Name;
	public static String PropertiesSection_Title_Format;
	public static String PropertiesSection_Title_Type;
	public static String PropertiesSection_Title_Data;

	public static String DashBoardPage_Title;
	public static String DashBoardPage_InfoBanner;

	public static String Wizard_Title;
	public static String Wizard_NewFile_Title;
	public static String Wizard_NewFile_Description;
	public static String Wizard_ConfigurationDevice_Title;
	public static String Wizard_ConfigurationDevice_Description;
	public static String Wizard_DeviceID_Is_Invalid;
	public static String Wizard_Creation_Page_Group_Path;
	public static String Wizard_Creation_Page_Device_Model;
	public static String Wizard_Creation_Page_Device_ID;

	public static String Associate_Button;
	public static String Associate_Label;
	public static String Associate_DefaultMessage;
	public static String Associate_ErrorModel;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
