/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.koneki.simulators.omadm.model.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>omadm</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class OMADMSimulatorTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new OMADMSimulatorTests("omadm Tests");
		suite.addTestSuite(DeviceTest.class);
		suite.addTestSuite(NodeTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMADMSimulatorTests(String name) {
		super(name);
	}

} //OMADMSimulatorTests
