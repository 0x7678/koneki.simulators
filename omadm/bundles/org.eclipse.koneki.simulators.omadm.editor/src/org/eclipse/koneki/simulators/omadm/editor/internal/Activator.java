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
package org.eclipse.koneki.simulators.omadm.editor.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.koneki.simulators.omadm.DMSimulator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class Activator extends AbstractUIPlugin {
	public static final String PLUGIN_ID = "org.eclipse.koneki.simulators.omadm.editor"; //$NON-NLS-1$

	public static final String ICONS_FOLDER = "icons"; //$NON-NLS-1$
	public static final String OBJ16 = ICONS_FOLDER + "/obj16"; //$NON-NLS-1$
	public static final String OBJ32 = ICONS_FOLDER + "/obj32"; //$NON-NLS-1$

	public static final String ADD_COMMAND = OBJ16 + "/add_command.png"; //$NON-NLS-1$
	public static final String ALERT_COMMAND = OBJ16 + "/alert_command.png"; //$NON-NLS-1$
	public static final String CLIENT_PACKAGE = OBJ16 + "/client_package.png"; //$NON-NLS-1$
	public static final String COPY_COMMAND = OBJ16 + "/copy_command.png"; //$NON-NLS-1$
	public static final String CLEAR = OBJ16 + "/clear.png"; //$NON-NLS-1$
	public static final String DELETE_COMMAND = OBJ16 + "/delete_command.png"; //$NON-NLS-1$
	public static final String CONFIGUATION = OBJ16 + "/configuration.png"; //$NON-NLS-1$
	public static final String EXEC_COMMAND = OBJ16 + "/exec_command.png"; //$NON-NLS-1$
	public static final String MONITORING_ALERT = OBJ16 + "/monitoring_alert.png"; //$NON-NLS-1$
	public static final String GET_COMMAND = OBJ16 + "/get_command.png"; //$NON-NLS-1$
	public static final String PHASE = OBJ16 + "/phase.png"; //$NON-NLS-1$
	public static final String REPLACE_COMMAND = OBJ16 + "/replace_command.png"; //$NON-NLS-1$
	public static final String SERVER_PACKAGE = OBJ16 + "/server_package.png"; //$NON-NLS-1$
	public static final String SESSION = OBJ16 + "/session.png"; //$NON-NLS-1$
	public static final String SIMULATION = OBJ16 + "/simulation.png"; //$NON-NLS-1$
	public static final String DASHBOARD = OBJ16 + "/dashboard.png"; //$NON-NLS-1$
	public static final String STATUS_FAIL = OBJ16 + "/status_fail.png"; //$NON-NLS-1$
	public static final String STATUS_OK = OBJ16 + "/status_ok.png"; //$NON-NLS-1$

	public static final String LINK_16 = OBJ16 + "/link.png"; //$NON-NLS-1$
	public static final String INFO_32 = OBJ32 + "/info.png"; //$NON-NLS-1$
	public static final String WARNING_32 = OBJ32 + "/warning.png"; //$NON-NLS-1$

	public static final String START = OBJ32 + "/start.png"; //$NON-NLS-1$

	private static Activator plugin;

	private ServiceTracker tracker;

	public Activator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		this.tracker = new ServiceTracker(context, DMSimulator.class.getName(), null);
		this.tracker.open();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		this.tracker.close();
		plugin = null;
		super.stop(context);
	}

	public DMSimulator getDMSimulator() {
		return (DMSimulator) this.tracker.getService();
	}

	public Image getImage(String imagePath) {
		Image image = getImageRegistry().get(imagePath);
		if (image == null) {
			getImageRegistry().put(imagePath, getImageDescriptor(imagePath));
			image = getImageRegistry().get(imagePath);
		}
		return image;
	}

	public ImageDescriptor getImageDescriptor(String imagePath) {
		return imageDescriptorFromPlugin(PLUGIN_ID, imagePath);
	}

	public static Activator getDefault() {
		return plugin;
	}

	public static void log(final Throwable thr) {
		String defaultMsg = "No details available."; //$NON-NLS-1$
		String msg = thr.getMessage() == null ? defaultMsg : thr.getMessage();
		IStatus status = new Status(IStatus.ERROR, PLUGIN_ID, 0, msg, thr);
		getDefault().getLog().log(status);
	}

	public static void logWarning(final Throwable thr) {
		String defaultMsg = "No details available."; //$NON-NLS-1$
		String msg = thr.getMessage() == null ? defaultMsg : thr.getMessage();
		IStatus status = new Status(IStatus.WARNING, PLUGIN_ID, 0, msg, thr);
		getDefault().getLog().log(status);
	}

	public static void log(final IStatus status) {
		getDefault().getLog().log(status);
	}

}
