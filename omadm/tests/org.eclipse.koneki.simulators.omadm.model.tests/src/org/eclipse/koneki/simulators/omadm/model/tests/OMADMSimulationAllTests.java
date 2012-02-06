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
 * A test suite for the '<em><b>OMADMSimulation</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class OMADMSimulationAllTests extends TestSuite {

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
		TestSuite suite = new OMADMSimulationAllTests("OMADMSimulation Tests");
		suite.addTest(OMADMSimulatorTests.suite());
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMADMSimulationAllTests(String name) {
		super(name);
	}

} //OMADMSimulationAllTests
