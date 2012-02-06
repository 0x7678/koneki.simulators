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
package org.eclipse.koneki.simulators.omadm.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorFactory
 * @model kind="package"
 * @generated
 */
public interface OMADMSimulatorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "omadm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/koneki/omadm/simulator/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "omadm-sim";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "org.eclipse.koneki.simulators.omadm.model.OMADMSimulationModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	OMADMSimulatorPackage eINSTANCE = org.eclipse.koneki.simulators.omadm.model.impl.OMADMSimulatorPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.koneki.simulators.omadm.model.impl.OMADMSimulationImpl <em>OMADM Simulation</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.koneki.simulators.omadm.model.impl.OMADMSimulationImpl
	 * @see org.eclipse.koneki.simulators.omadm.model.impl.OMADMSimulatorPackageImpl#getOMADMSimulation()
	 * @generated
	 */
	int OMADM_SIMULATION = 0;

	/**
	 * The feature id for the '<em><b>Device</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OMADM_SIMULATION__DEVICE = 0;

	/**
	 * The number of structural features of the '<em>OMADM Simulation</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OMADM_SIMULATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.koneki.simulators.omadm.model.impl.DeviceImpl <em>Device</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.eclipse.koneki.simulators.omadm.model.impl.DeviceImpl
	 * @see org.eclipse.koneki.simulators.omadm.model.impl.OMADMSimulatorPackageImpl#getDevice()
	 * @generated
	 */
	int DEVICE = 1;

	/**
	 * The feature id for the '<em><b>Device Id Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__DEVICE_ID_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Tree</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__TREE = 1;

	/**
	 * The feature id for the '<em><b>Device Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__DEVICE_ID = 2;

	/**
	 * The feature id for the '<em><b>Login</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__LOGIN = 3;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__PASSWORD = 4;

	/**
	 * The feature id for the '<em><b>Server Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__SERVER_URL = 5;

	/**
	 * The number of structural features of the '<em>Device</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.koneki.simulators.omadm.model.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.eclipse.koneki.simulators.omadm.model.impl.NodeImpl
	 * @see org.eclipse.koneki.simulators.omadm.model.impl.OMADMSimulatorPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__FORMAT = 1;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__CHILDREN = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__DATA = 4;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__PARENT = 5;

	/**
	 * The feature id for the '<em><b>Get Management</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__GET_MANAGEMENT = 6;

	/**
	 * The feature id for the '<em><b>Get Code</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__GET_CODE = 7;

	/**
	 * The feature id for the '<em><b>Add Management</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ADD_MANAGEMENT = 8;

	/**
	 * The feature id for the '<em><b>Delete Management</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__DELETE_MANAGEMENT = 9;

	/**
	 * The feature id for the '<em><b>Copy Management</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__COPY_MANAGEMENT = 10;

	/**
	 * The feature id for the '<em><b>Replace Management</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__REPLACE_MANAGEMENT = 11;

	/**
	 * The feature id for the '<em><b>Exec Management</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__EXEC_MANAGEMENT = 12;

	/**
	 * The feature id for the '<em><b>Add Code</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ADD_CODE = 13;

	/**
	 * The feature id for the '<em><b>Delete Code</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__DELETE_CODE = 14;

	/**
	 * The feature id for the '<em><b>Copy Code</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__COPY_CODE = 15;

	/**
	 * The feature id for the '<em><b>Replace Code</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__REPLACE_CODE = 16;

	/**
	 * The feature id for the '<em><b>Exec Code</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__EXEC_CODE = 17;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 18;

	/**
	 * The meta object id for the '{@link org.eclipse.koneki.simulators.omadm.model.DeviceIdType <em>Device Id Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.koneki.simulators.omadm.model.DeviceIdType
	 * @see org.eclipse.koneki.simulators.omadm.model.impl.OMADMSimulatorPackageImpl#getDeviceIdType()
	 * @generated
	 */
	int DEVICE_ID_TYPE = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.koneki.simulators.omadm.model.NodeFormat <em>Node Format</em>}' enum.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.eclipse.koneki.simulators.omadm.model.NodeFormat
	 * @see org.eclipse.koneki.simulators.omadm.model.impl.OMADMSimulatorPackageImpl#getNodeFormat()
	 * @generated
	 */
	int NODE_FORMAT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.koneki.simulators.omadm.model.CommandManagement <em>Command Management</em>}' enum. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.koneki.simulators.omadm.model.CommandManagement
	 * @see org.eclipse.koneki.simulators.omadm.model.impl.OMADMSimulatorPackageImpl#getCommandManagement()
	 * @generated
	 */
	int COMMAND_MANAGEMENT = 5;

	/**
	 * Returns the meta object for class '{@link org.eclipse.koneki.simulators.omadm.model.OMADMSimulation <em>OMADM Simulation</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>OMADM Simulation</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulation
	 * @generated
	 */
	EClass getOMADMSimulation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.koneki.simulators.omadm.model.OMADMSimulation#getDevice <em>Device</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Device</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulation#getDevice()
	 * @see #getOMADMSimulation()
	 * @generated
	 */
	EReference getOMADMSimulation_Device();

	/**
	 * Returns the meta object for class '{@link org.eclipse.koneki.simulators.omadm.model.Device <em>Device</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for class '<em>Device</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Device
	 * @generated
	 */
	EClass getDevice();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.koneki.simulators.omadm.model.Device#getDeviceIdType <em>Device Id Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Device Id Type</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Device#getDeviceIdType()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_DeviceIdType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.koneki.simulators.omadm.model.Device#getTree <em>Tree</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference '<em>Tree</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Device#getTree()
	 * @see #getDevice()
	 * @generated
	 */
	EReference getDevice_Tree();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.koneki.simulators.omadm.model.Device#getDeviceId <em>Device Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Device Id</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Device#getDeviceId()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_DeviceId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.koneki.simulators.omadm.model.Device#getLogin <em>Login</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Login</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Device#getLogin()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_Login();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.koneki.simulators.omadm.model.Device#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Device#getPassword()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_Password();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.koneki.simulators.omadm.model.Device#getServerUrl <em>Server Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Server Url</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Device#getServerUrl()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_ServerUrl();

	/**
	 * Returns the meta object for class '{@link org.eclipse.koneki.simulators.omadm.model.Node <em>Node</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.koneki.simulators.omadm.model.Node#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getName()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.koneki.simulators.omadm.model.Node#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getFormat()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Format();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.koneki.simulators.omadm.model.Node#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getChildren()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Children();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.koneki.simulators.omadm.model.Node#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getType()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.koneki.simulators.omadm.model.Node#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getData()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Data();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.koneki.simulators.omadm.model.Node#getParent <em>Parent</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getParent()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Parent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.koneki.simulators.omadm.model.Node#getGetManagement <em>Get Management</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Get Management</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getGetManagement()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_GetManagement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.koneki.simulators.omadm.model.Node#getGetCode <em>Get Code</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Get Code</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getGetCode()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_GetCode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.koneki.simulators.omadm.model.Node#getAddManagement <em>Add Management</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Add Management</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getAddManagement()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_AddManagement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.koneki.simulators.omadm.model.Node#getDeleteManagement <em>Delete Management</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delete Management</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getDeleteManagement()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_DeleteManagement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.koneki.simulators.omadm.model.Node#getCopyManagement <em>Copy Management</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Copy Management</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getCopyManagement()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_CopyManagement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.koneki.simulators.omadm.model.Node#getReplaceManagement <em>Replace Management</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Replace Management</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getReplaceManagement()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_ReplaceManagement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.koneki.simulators.omadm.model.Node#getExecManagement <em>Exec Management</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exec Management</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getExecManagement()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_ExecManagement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.koneki.simulators.omadm.model.Node#getAddCode <em>Add Code</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Add Code</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getAddCode()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_AddCode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.koneki.simulators.omadm.model.Node#getDeleteCode <em>Delete Code</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Delete Code</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getDeleteCode()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_DeleteCode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.koneki.simulators.omadm.model.Node#getCopyCode <em>Copy Code</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Copy Code</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getCopyCode()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_CopyCode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.koneki.simulators.omadm.model.Node#getReplaceCode <em>Replace Code</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Replace Code</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getReplaceCode()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_ReplaceCode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.koneki.simulators.omadm.model.Node#getExecCode <em>Exec Code</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Exec Code</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getExecCode()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_ExecCode();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.koneki.simulators.omadm.model.DeviceIdType <em>Device Id Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Device Id Type</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.DeviceIdType
	 * @generated
	 */
	EEnum getDeviceIdType();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.koneki.simulators.omadm.model.NodeFormat <em>Node Format</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for enum '<em>Node Format</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.NodeFormat
	 * @generated
	 */
	EEnum getNodeFormat();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.koneki.simulators.omadm.model.CommandManagement <em>Command Management</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for enum '<em>Command Management</em>'.
	 * @see org.eclipse.koneki.simulators.omadm.model.CommandManagement
	 * @generated
	 */
	EEnum getCommandManagement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OMADMSimulatorFactory getOMADMSimulatorFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.koneki.simulators.omadm.model.impl.OMADMSimulationImpl <em>OMADM Simulation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.koneki.simulators.omadm.model.impl.OMADMSimulationImpl
		 * @see org.eclipse.koneki.simulators.omadm.model.impl.OMADMSimulatorPackageImpl#getOMADMSimulation()
		 * @generated
		 */
		EClass OMADM_SIMULATION = eINSTANCE.getOMADMSimulation();

		/**
		 * The meta object literal for the '<em><b>Device</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OMADM_SIMULATION__DEVICE = eINSTANCE.getOMADMSimulation_Device();

		/**
		 * The meta object literal for the '{@link org.eclipse.koneki.simulators.omadm.model.impl.DeviceImpl <em>Device</em>}' class.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @see org.eclipse.koneki.simulators.omadm.model.impl.DeviceImpl
		 * @see org.eclipse.koneki.simulators.omadm.model.impl.OMADMSimulatorPackageImpl#getDevice()
		 * @generated
		 */
		EClass DEVICE = eINSTANCE.getDevice();

		/**
		 * The meta object literal for the '<em><b>Device Id Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__DEVICE_ID_TYPE = eINSTANCE.getDevice_DeviceIdType();

		/**
		 * The meta object literal for the '<em><b>Tree</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE__TREE = eINSTANCE.getDevice_Tree();

		/**
		 * The meta object literal for the '<em><b>Device Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__DEVICE_ID = eINSTANCE.getDevice_DeviceId();

		/**
		 * The meta object literal for the '<em><b>Login</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__LOGIN = eINSTANCE.getDevice_Login();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__PASSWORD = eINSTANCE.getDevice_Password();

		/**
		 * The meta object literal for the '<em><b>Server Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__SERVER_URL = eINSTANCE.getDevice_ServerUrl();

		/**
		 * The meta object literal for the '{@link org.eclipse.koneki.simulators.omadm.model.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.koneki.simulators.omadm.model.impl.NodeImpl
		 * @see org.eclipse.koneki.simulators.omadm.model.impl.OMADMSimulatorPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__NAME = eINSTANCE.getNode_Name();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__FORMAT = eINSTANCE.getNode_Format();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 *
		 * @generated
		 */
		EReference NODE__CHILDREN = eINSTANCE.getNode_Children();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__TYPE = eINSTANCE.getNode_Type();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__DATA = eINSTANCE.getNode_Data();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__PARENT = eINSTANCE.getNode_Parent();

		/**
		 * The meta object literal for the '<em><b>Get Management</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__GET_MANAGEMENT = eINSTANCE.getNode_GetManagement();

		/**
		 * The meta object literal for the '<em><b>Get Code</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__GET_CODE = eINSTANCE.getNode_GetCode();

		/**
		 * The meta object literal for the '<em><b>Add Management</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__ADD_MANAGEMENT = eINSTANCE.getNode_AddManagement();

		/**
		 * The meta object literal for the '<em><b>Delete Management</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__DELETE_MANAGEMENT = eINSTANCE.getNode_DeleteManagement();

		/**
		 * The meta object literal for the '<em><b>Copy Management</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__COPY_MANAGEMENT = eINSTANCE.getNode_CopyManagement();

		/**
		 * The meta object literal for the '<em><b>Replace Management</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__REPLACE_MANAGEMENT = eINSTANCE.getNode_ReplaceManagement();

		/**
		 * The meta object literal for the '<em><b>Exec Management</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__EXEC_MANAGEMENT = eINSTANCE.getNode_ExecManagement();

		/**
		 * The meta object literal for the '<em><b>Add Code</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__ADD_CODE = eINSTANCE.getNode_AddCode();

		/**
		 * The meta object literal for the '<em><b>Delete Code</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__DELETE_CODE = eINSTANCE.getNode_DeleteCode();

		/**
		 * The meta object literal for the '<em><b>Copy Code</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__COPY_CODE = eINSTANCE.getNode_CopyCode();

		/**
		 * The meta object literal for the '<em><b>Replace Code</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__REPLACE_CODE = eINSTANCE.getNode_ReplaceCode();

		/**
		 * The meta object literal for the '<em><b>Exec Code</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__EXEC_CODE = eINSTANCE.getNode_ExecCode();

		/**
		 * The meta object literal for the '{@link org.eclipse.koneki.simulators.omadm.model.DeviceIdType <em>Device Id Type</em>}' enum. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @see org.eclipse.koneki.simulators.omadm.model.DeviceIdType
		 * @see org.eclipse.koneki.simulators.omadm.model.impl.OMADMSimulatorPackageImpl#getDeviceIdType()
		 * @generated
		 */
		EEnum DEVICE_ID_TYPE = eINSTANCE.getDeviceIdType();

		/**
		 * The meta object literal for the '{@link org.eclipse.koneki.simulators.omadm.model.NodeFormat <em>Node Format</em>}' enum.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @see org.eclipse.koneki.simulators.omadm.model.NodeFormat
		 * @see org.eclipse.koneki.simulators.omadm.model.impl.OMADMSimulatorPackageImpl#getNodeFormat()
		 * @generated
		 */
		EEnum NODE_FORMAT = eINSTANCE.getNodeFormat();

		/**
		 * The meta object literal for the '{@link org.eclipse.koneki.simulators.omadm.model.CommandManagement <em>Command Management</em>}' enum. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @see org.eclipse.koneki.simulators.omadm.model.CommandManagement
		 * @see org.eclipse.koneki.simulators.omadm.model.impl.OMADMSimulatorPackageImpl#getCommandManagement()
		 * @generated
		 */
		EEnum COMMAND_MANAGEMENT = eINSTANCE.getCommandManagement();

	}

} // OMADMSimulatorPackage
