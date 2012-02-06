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
package org.eclipse.koneki.simulators.omadm.fumo;

public interface Fumo {

	public static final String OMI = "urn:oma:mo:oma-fumo:1.0"; //$NON-NLS-1$
	public static final String FORMAT = "int"; //$NON-NLS-1$
	public static final String SUCCESS_LEVEL = "informational"; //$NON-NLS-1$
	public static final String FAIL_LEVEL = "critical"; //$NON-NLS-1$
	public static final String TYPE_DOWNLOAD = "org.openmobilealliance.dm.firmwareupdate.download"; //$NON-NLS-1$
	public static final String TYPE_UPDATE = "org.openmobilealliance.dm.firmwareupdate.update"; //$NON-NLS-1$
	public static final String TYPE_DOWNLOAD_UPDATE = "org.openmobilealliance.dm.firmwareupdate.downloadandupdate"; //$NON-NLS-1$

	public static final String DOWNLOAD_NODE_NAME = "Download"; //$NON-NLS-1$
	public static final String UPDATE_NODE_NAME = "Update"; //$NON-NLS-1$
	public static final String DOWNLOAD_AND_UPDATE_NODE_NAME = "DownloadAndUpdate"; //$NON-NLS-1$

}
