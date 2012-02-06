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

public enum FumoResultCode {

	SUCCESSFUL(200, "Successful"), MANAGEMENT_CLIENT_ERROR(400, "Management client error"), USER_CANCELLED(401, "User cancelled"), CORRUPTED_FIRMWARE_UPDATE_PACKAGE( //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			402, "Corrupted firmware update package"), FIRMWARE_UPDATE_PACKAGE_DEVICE_MISMATCH(403, "Firmware update package device mismatch"), FAILED_FIRMWARE_UPDATE_PACKAGE_VALIDATION( //$NON-NLS-1$ //$NON-NLS-2$
			404, "Failed firmware update package validation"), FIRMWARE_UPDATE_PACKAGE_NOT_ACCEPTABLE(405, "Firmware update package not acceptable"), ALTERNATE_DOWNLOAD_AUTHENTICATION_FAILURE( //$NON-NLS-1$ //$NON-NLS-2$
			406, "Alternate download authentication failure"), ALTERNATE_DOWNLOAD_REQUEST_TIMEOUT(407, "Alternate download request time-out"), NOT_IMPLEMENTED( //$NON-NLS-1$ //$NON-NLS-2$
			408, "Not implemented"), UNDEFINED_ERROR(409, "Undefined error"), FIRMWARE_UPDARE_FAILED(410, "Firmware update failed"), MALFORMED_OR_BAD_URL( //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			411, "Malformed or bad URL"), ALTERNATE_DOWNLOAD_SERVER_UNAVAILABLE(412, "Alternate download server unavailable"), ALTERNATE_DOWNLOAD_SERVER_ERROR( //$NON-NLS-1$ //$NON-NLS-2$
			500, "Alternate download server error"), DOWNLOAD_FAILS_DUE_TO_DEVICE_IS_OUT_OF_MEMORY(501, //$NON-NLS-1$
			"Download fails due to device is out of memory"), FIRMWARE_UPDATE_FAILS_DUE_TO_DEVICE_OUT_OF_MEMORY(502, //$NON-NLS-1$
			"Firmware update fails due to device out of memory"), DOWNLOAD_FAILS_DUE_TO_NETWORK_ISSUES(503, "Download fails due to network issues"); //$NON-NLS-1$ //$NON-NLS-2$

	private FumoResultCode(final int code, final String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}

	@Override
	public String toString() {
		return String.valueOf(this.code) + " " + this.description; //$NON-NLS-1$
	}

	private final int code;
	private final String description;

}
