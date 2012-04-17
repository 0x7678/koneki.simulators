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
package org.eclipse.koneki.simulators.omadm.thing2oma.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

public class Activator extends Plugin {
	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.koneki.simulators.omadm.thing2oma"; //$NON-NLS-1$

	// The shared instance
	private static Activator INSTANCE;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext
	 */
	public void stop(BundleContext context) throws Exception {
		INSTANCE = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return INSTANCE;
	}

	public static void log(final Throwable thr) {
		String defaultMsg = "No details available.";
		String msg = thr.getMessage() == null ? defaultMsg : thr.getMessage();
		IStatus status = new Status(IStatus.ERROR, PLUGIN_ID, 0, msg, thr);
		getDefault().getLog().log(status);
	}

	public static void logWarning(final Throwable thr) {
		String defaultMsg = "No details available.";
		String msg = thr.getMessage() == null ? defaultMsg : thr.getMessage();
		IStatus status = new Status(IStatus.WARNING, PLUGIN_ID, 0, msg, thr);
		getDefault().getLog().log(status);
	}

	public static void log(final IStatus status) {
		getDefault().getLog().log(status);
	}
}
