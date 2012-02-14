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
package org.eclipse.koneki.simulators.omadm.model.tests;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.eclipse.koneki.simulators.omadm.model.util.DeviceHelpers.isValidDeviceId;
import static org.eclipse.koneki.simulators.omadm.model.util.DeviceHelpers.isValidRootNodeType;

import org.eclipse.koneki.simulators.omadm.model.Device;
import org.eclipse.koneki.simulators.omadm.model.DeviceIdType;
import org.eclipse.koneki.simulators.omadm.model.Node;
import org.eclipse.koneki.simulators.omadm.model.NodeFormat;
import org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorFactory;
import org.junit.BeforeClass;
import org.junit.Test;

public class DeviceHelpersTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		assertEquals(3, DeviceIdType.VALUES.size());
	}

	@Test
	public void testIsValidDeviceId() {
		assertFalse(isValidDeviceId(null));
		// Tuple: deviceId, freeExpected, imeiExpected, freeExpected
		final Object[][] testDatas = { { null, false, false, false }, { "", false, false, false }, { "  ", false, false, false },
				{ "dazd zad 144 @:ad u azd", true, false, false }, { "012345678901234", true, true, false },
				{ "987654321098765", true, true, false }, { "987654321098765  ", false, false, false }, { "  987654321098765", false, false, false },
				{ "   987654321098765 ", false, false, false }, { "0123456789ab", true, false, true }, { "0123456789AB", true, false, true },
				{ "FEDCBA987654", true, false, true }, { "fedcba987654", true, false, true }, { "AaBcCcDdEeFf", true, false, true }, };
		for (Object[] testData : testDatas) {
			final Device freeDevice = OMADMSimulatorFactory.eINSTANCE.createDevice();
			freeDevice.setDeviceId((String) testData[0]);
			freeDevice.setDeviceIdType(DeviceIdType.FREE);
			assertEquals(freeDevice.getDeviceId(), ((Boolean) testData[1]).booleanValue(), isValidDeviceId(freeDevice));
			final Device imeiDevice = OMADMSimulatorFactory.eINSTANCE.createDevice();
			imeiDevice.setDeviceId((String) testData[0]);
			imeiDevice.setDeviceIdType(DeviceIdType.IMEI);
			assertEquals(imeiDevice.getDeviceId(), ((Boolean) testData[2]).booleanValue(), isValidDeviceId(imeiDevice));
			final Device macDevice = OMADMSimulatorFactory.eINSTANCE.createDevice();
			macDevice.setDeviceId((String) testData[0]);
			macDevice.setDeviceIdType(DeviceIdType.MAC_ADDRESS);
			assertEquals(macDevice.getDeviceId(), ((Boolean) testData[3]).booleanValue(), isValidDeviceId(macDevice));
		}
	}

	@Test
	public void testIsValidRootNodeType() {
		assertFalse(isValidRootNodeType(null));
		final Node root = OMADMSimulatorFactory.eINSTANCE.createNode();
		root.setFormat(NodeFormat.CHR);
		final Device device = OMADMSimulatorFactory.eINSTANCE.createDevice();
		assertTrue(isValidRootNodeType(device));
	}

}
