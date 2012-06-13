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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Device</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Device#getDeviceIdType <em>Device Id Type</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Device#getTree <em>Tree</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Device#getDeviceId <em>Device Id</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Device#getLogin <em>Login</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Device#getPassword <em>Password</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Device#getServerUrl <em>Server Url</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Device#getAuthentication <em>Authentication</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getDevice()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='groupPathMustBeAValidPath\nmodelNameMustBeValid\ncustomerPathMustBeAValidPath\ndeviceIdMustBeValid\nrootNodeCategoryMustBeValid'"
 * @generated
 */
public interface Device extends EObject {
	/**
	 * Returns the value of the '<em><b>Device Id Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.koneki.simulators.omadm.model.DeviceIdType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Device Id Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Device Id Type</em>' attribute.
	 * @see org.eclipse.koneki.simulators.omadm.model.DeviceIdType
	 * @see #setDeviceIdType(DeviceIdType)
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getDevice_DeviceIdType()
	 * @model required="true"
	 * @generated
	 */
	DeviceIdType getDeviceIdType();

	/**
	 * Sets the value of the '{@link org.eclipse.koneki.simulators.omadm.model.Device#getDeviceIdType <em>Device Id Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Device Id Type</em>' attribute.
	 * @see org.eclipse.koneki.simulators.omadm.model.DeviceIdType
	 * @see #getDeviceIdType()
	 * @generated
	 */
	void setDeviceIdType(DeviceIdType value);

	/**
	 * Returns the value of the '<em><b>Tree</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tree</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tree</em>' containment reference.
	 * @see #setTree(Node)
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getDevice_Tree()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Node getTree();

	/**
	 * Sets the value of the '{@link org.eclipse.koneki.simulators.omadm.model.Device#getTree <em>Tree</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tree</em>' containment reference.
	 * @see #getTree()
	 * @generated
	 */
	void setTree(Node value);

	/**
	 * Returns the value of the '<em><b>Device Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Device Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Device Id</em>' attribute.
	 * @see #setDeviceId(String)
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getDevice_DeviceId()
	 * @model required="true" transient="true" derived="true"
	 * @generated
	 */
	String getDeviceId();

	/**
	 * Sets the value of the '{@link org.eclipse.koneki.simulators.omadm.model.Device#getDeviceId <em>Device Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Device Id</em>' attribute.
	 * @see #getDeviceId()
	 * @generated
	 */
	void setDeviceId(String value);

	/**
	 * Returns the value of the '<em><b>Login</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Login</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Login</em>' attribute.
	 * @see #setLogin(String)
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getDevice_Login()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	String getLogin();

	/**
	 * Sets the value of the '{@link org.eclipse.koneki.simulators.omadm.model.Device#getLogin <em>Login</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Login</em>' attribute.
	 * @see #getLogin()
	 * @generated
	 */
	void setLogin(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getDevice_Password()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link org.eclipse.koneki.simulators.omadm.model.Device#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Server Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Url</em>' attribute.
	 * @see #setServerUrl(String)
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getDevice_ServerUrl()
	 * @model required="true" transient="true" derived="true"
	 * @generated
	 */
	String getServerUrl();

	/**
	 * Sets the value of the '{@link org.eclipse.koneki.simulators.omadm.model.Device#getServerUrl <em>Server Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Url</em>' attribute.
	 * @see #getServerUrl()
	 * @generated
	 */
	void setServerUrl(String value);

	/**
	 * Returns the value of the '<em><b>Authentication</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.koneki.simulators.omadm.model.AuthenticationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Authentication</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Authentication</em>' attribute.
	 * @see org.eclipse.koneki.simulators.omadm.model.AuthenticationType
	 * @see #setAuthentication(AuthenticationType)
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getDevice_Authentication()
	 * @model required="true"
	 * @generated
	 */
	AuthenticationType getAuthentication();

	/**
	 * Sets the value of the '{@link org.eclipse.koneki.simulators.omadm.model.Device#getAuthentication <em>Authentication</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Authentication</em>' attribute.
	 * @see org.eclipse.koneki.simulators.omadm.model.AuthenticationType
	 * @see #getAuthentication()
	 * @generated
	 */
	void setAuthentication(AuthenticationType value);

} // Device
