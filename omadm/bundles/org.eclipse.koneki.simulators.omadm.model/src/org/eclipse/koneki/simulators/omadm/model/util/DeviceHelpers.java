/*******************************************************************************
 * Copyright (c) 2011 Sierra Wireless and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sierra Wireless - initial API and implementation
 *******************************************************************************/
package org.eclipse.koneki.simulators.omadm.model.util;

import org.eclipse.koneki.simulators.omadm.model.Device;
import org.eclipse.koneki.simulators.omadm.model.Node;

public class DeviceHelpers {

	public static final String[] getDeviceIdTypeAndValue(final String deviceId) {
		String deviceIdType = null;
		String deviceIdValue = "";

		if (deviceId != null) {
			if (deviceId.contains(":")) {
				for (String s : deviceId.split(":")) {
					if (deviceIdType == null) {
						deviceIdType = s;
					} else {
						deviceIdValue += s;
					}
				}
			} else {
				deviceIdValue = deviceId;
			}
		}

		String[] ret = { deviceIdType, deviceIdValue };
		return ret;
	}

	/**
	 * Checks if the deviceId is valid.
	 * 
	 * @param device
	 *            the device to check
	 * @return true if the customer path is valid, else false
	 */
	public static final boolean isValidDeviceId(final Device device) {
		if (device != null) {
			final String deviceId = device.getDeviceId();
			if (deviceId != null) {
				switch (device.getDeviceIdType()) {
				case IMEI:
					return deviceId.matches("^[0-9]{15}$");
				case MAC_ADDRESS:
					return deviceId.matches("^[a-fA-F0-9]{12}$");
				default:
					return deviceId.matches("^\\S+(\\s+\\S+)*$");
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Checks if the root node type is valid.
	 * 
	 * @param device
	 *            the device to check
	 * @return true if the root node type is valid, else false
	 */
	public static final boolean isValidRootNodeType(final Device device) {
		if (device != null) {
			final Node root = device.getTree();
			return root != null && root.isRoot();
		} else {
			return false;
		}
	}

}
