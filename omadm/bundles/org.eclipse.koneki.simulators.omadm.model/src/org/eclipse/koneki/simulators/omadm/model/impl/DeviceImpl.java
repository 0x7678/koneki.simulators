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
package org.eclipse.koneki.simulators.omadm.model.impl;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.koneki.simulators.omadm.model.AuthenticationType;
import org.eclipse.koneki.simulators.omadm.model.Device;
import org.eclipse.koneki.simulators.omadm.model.DeviceIdType;
import org.eclipse.koneki.simulators.omadm.model.Node;
import org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage;
import org.eclipse.koneki.simulators.omadm.model.util.DeviceHelpers;
import org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Device</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.DeviceImpl#getDeviceIdType <em>Device Id Type</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.DeviceImpl#getTree <em>Tree</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.DeviceImpl#getDeviceId <em>Device Id</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.DeviceImpl#getLogin <em>Login</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.DeviceImpl#getPassword <em>Password</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.DeviceImpl#getServerUrl <em>Server Url</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.DeviceImpl#getAuthentication <em>Authentication</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DeviceImpl extends EObjectImpl implements Device {
	/**
	 * The default value of the '{@link #getDeviceIdType() <em>Device Id Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDeviceIdType()
	 * @generated
	 * @ordered
	 */
	protected static final DeviceIdType DEVICE_ID_TYPE_EDEFAULT = DeviceIdType.FREE;

	/**
	 * The cached value of the '{@link #getDeviceIdType() <em>Device Id Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDeviceIdType()
	 * @generated
	 * @ordered
	 */
	protected DeviceIdType deviceIdType = DEVICE_ID_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTree() <em>Tree</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTree()
	 * @generated
	 * @ordered
	 */
	protected Node tree;

	/**
	 * The default value of the '{@link #getDeviceId() <em>Device Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDeviceId()
	 * @generated
	 * @ordered
	 */
	protected static final String DEVICE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDeviceId() <em>Device Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDeviceId()
	 * @generated
	 * @ordered
	 */
	protected String deviceId = DEVICE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getLogin() <em>Login</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLogin()
	 * @generated
	 * @ordered
	 */
	protected static final String LOGIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLogin() <em>Login</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLogin()
	 * @generated
	 * @ordered
	 */
	protected String login = LOGIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getServerUrl() <em>Server Url</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getServerUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVER_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServerUrl() <em>Server Url</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getServerUrl()
	 * @generated
	 * @ordered
	 */
	protected String serverUrl = SERVER_URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getAuthentication() <em>Authentication</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAuthentication()
	 * @generated
	 * @ordered
	 */
	protected static final AuthenticationType AUTHENTICATION_EDEFAULT = AuthenticationType.BASIC;

	/**
	 * The cached value of the '{@link #getAuthentication() <em>Authentication</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAuthentication()
	 * @generated
	 * @ordered
	 */
	protected AuthenticationType authentication = AUTHENTICATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected DeviceImpl() {
		super();
		setTree(NodeHelpers.initTree());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OMADMSimulatorPackage.Literals.DEVICE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public DeviceIdType getDeviceIdType() {
		return deviceIdType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setDeviceIdType(DeviceIdType newDeviceIdType) {
		if (deviceIdType != newDeviceIdType) {

			DeviceIdType oldDeviceIdType = deviceIdType;
			deviceIdType = newDeviceIdType == null ? DEVICE_ID_TYPE_EDEFAULT : newDeviceIdType;

			String newDeviceId = DeviceHelpers.getDeviceIdTypeAndValue(deviceId)[1];

			if (newDeviceIdType != DEVICE_ID_TYPE_EDEFAULT) {
				if (newDeviceId != null) {
					setDeviceId(deviceIdType.getName() + ":" + DeviceHelpers.getDeviceIdTypeAndValue(deviceId)[1]);
				} else {
					setDeviceId(deviceIdType.getName() + ":" + deviceId);
				}
			}
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.DEVICE__DEVICE_ID_TYPE, oldDeviceIdType, deviceIdType));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Node getTree() {
		return tree;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetTree(Node newTree, NotificationChain msgs) {
		Node oldTree = tree;
		tree = newTree;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.DEVICE__TREE, oldTree, newTree);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setTree(Node newTree) {
		if (newTree != tree) {
			NotificationChain msgs = null;
			if (tree != null)
				msgs = ((InternalEObject) tree).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OMADMSimulatorPackage.DEVICE__TREE, null, msgs);
			if (newTree != null)
				msgs = ((InternalEObject) newTree).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OMADMSimulatorPackage.DEVICE__TREE, null, msgs);
			msgs = basicSetTree(newTree, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.DEVICE__TREE, newTree, newTree));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getDeviceId() {
		Node devIdNode = NodeHelpers.findFirstNode(NodeHelpers.getNode(getTree(), "./DevInfo"), "DevId");
		if (devIdNode != null) {
			deviceId = devIdNode.getData();
			return deviceId;
		}
		return deviceId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setDeviceId(String newDeviceId) {
		String oldDeviceId = deviceId;
		Node root = getTree();
		Node devIdNode = NodeHelpers.findFirstNode(NodeHelpers.getNode(root, "./DevInfo"), "DevId");
		if (devIdNode != null && newDeviceId != null) {
			if (newDeviceId != null && !newDeviceId.equals(oldDeviceId)) {
				devIdNode.setData(newDeviceId);
			}
			deviceId = newDeviceId;

			String deviceIdType = DeviceHelpers.getDeviceIdTypeAndValue(deviceId)[0];
			if (deviceIdType != null) {

				DeviceIdType newDeviceIdType = DeviceIdType.getByName(deviceIdType);

				if (newDeviceIdType != null) {
					setDeviceIdType(newDeviceIdType);
				} else {
					setDeviceIdType(DeviceIdType.FREE);
				}
			} else {
				if (deviceId != null) {
					if (deviceId.matches("^[0-9]{15}$")) {
						setDeviceIdType(DeviceIdType.IMEI);
					} else if (deviceId.matches("^[a-fA-F0-9]{12}$")) {
						setDeviceIdType(DeviceIdType.MAC_ADDRESS);
					} else {
						setDeviceIdType(DeviceIdType.FREE);
					}
				}
			}
		}

		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.DEVICE__DEVICE_ID, oldDeviceId, newDeviceId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getLogin() {
		Node loginNode = NodeHelpers.findFirstNode(NodeHelpers.getNode(getTree(), "./DMAcc/AppAuth"), "AuthName");
		if (loginNode != null) {
			login = loginNode.getData();
			return login;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setLogin(String newLogin) {
		String oldLogin = login;
		Node loginNode = NodeHelpers.findFirstNode(NodeHelpers.getNode(getTree(), "./DMAcc/AppAuth"), "AuthName");
		if (loginNode != null) {
			if (!newLogin.equals(oldLogin)) {
				loginNode.setData(newLogin);
			}
			login = newLogin;
		}

		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.DEVICE__LOGIN, oldLogin, newLogin));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getPassword() {
		Node passwordNode = NodeHelpers.findFirstNode(NodeHelpers.getNode(getTree(), "./DMAcc/AppAuth"), "AuthSecret");
		if (passwordNode != null) {
			password = passwordNode.getData();
			return password;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setPassword(String newPassword) {
		String oldPassword = password;
		Node passwordNode = NodeHelpers.findFirstNode(NodeHelpers.getNode(getTree(), "./DMAcc/AppAuth"), "AuthSecret");
		if (passwordNode != null) {
			if (!newPassword.equals(oldPassword)) {
				passwordNode.setData(newPassword);
			}
			password = newPassword;
		}

		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.DEVICE__PASSWORD, oldPassword, newPassword));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getServerUrl() {
		Node serverIDNode = NodeHelpers.findFirstNode(NodeHelpers.getNode(getTree(), "./DMAcc/AppAddr"), "Addr");
		if (serverIDNode != null) {
			serverUrl = serverIDNode.getData();
			return serverUrl;
		}

		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setServerUrl(String newServerUrl) {
		String oldServerURL = serverUrl;
		serverUrl = newServerUrl;

		Node addrNode = NodeHelpers.findFirstNode(NodeHelpers.getNode(getTree(), "./DMAcc/AppAddr"), "Addr");
		Node addrTypeNode = NodeHelpers.findFirstNode(NodeHelpers.getNode(getTree(), "./DMAcc/AppAddr"), "AddrType");
		Node portNumberNode = NodeHelpers.findFirstNode(NodeHelpers.findFirstNode(NodeHelpers.getNode(getTree(), "./DMAcc/AppAddr"), "Port"),
				"PortNbr");

		try {
			URL newUrl = new URL(newServerUrl);
			int newPortNumber = newUrl.getPort();
			if (newPortNumber == -1) {
				newPortNumber = 80;
			}
			String newServerName = newUrl.getHost();
			String newSubDirectories = newUrl.getPath();
			String newProtocol = newUrl.getProtocol();

			if (!newServerUrl.equals(oldServerURL)) {
				if (addrNode != null) {
					addrNode.setData(newServerUrl);
				}

				if (addrTypeNode != null) {
					addrTypeNode.setData(newProtocol + "://" + newServerName + newSubDirectories);
				}

				if (portNumberNode != null) {
					portNumberNode.setData(String.valueOf(newPortNumber));
				}
			}
		} catch (MalformedURLException e) {
			addrNode.setData("");
			addrTypeNode.setData("");
			portNumberNode.setData("80");
		}

		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.DEVICE__SERVER_URL, oldServerURL, newServerUrl));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AuthenticationType getAuthentication() {
		return authentication;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setAuthentication(AuthenticationType newAuthentication) {
		Node authNode = NodeHelpers.findFirstNode(NodeHelpers.getNode(getTree(), "./DMAcc"), "AuthPref");
		AuthenticationType oldAuthentication = authentication;

		if (newAuthentication != null) {

			if (authNode != null) {
				if (!newAuthentication.equals(oldAuthentication)) {
					authNode.setData(newAuthentication.getName());
				}
				authentication = newAuthentication;
			}

			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.DEVICE__AUTHENTICATION, oldAuthentication,
						newAuthentication));
		} else {
			authNode.setData(AuthenticationType.NONE.getName());
			authentication = AuthenticationType.NONE;

			if (eNotificationRequired()) {
				eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.DEVICE__AUTHENTICATION, oldAuthentication,
						AuthenticationType.NONE));
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case OMADMSimulatorPackage.DEVICE__TREE:
			return basicSetTree(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OMADMSimulatorPackage.DEVICE__DEVICE_ID_TYPE:
			return getDeviceIdType();
		case OMADMSimulatorPackage.DEVICE__TREE:
			return getTree();
		case OMADMSimulatorPackage.DEVICE__DEVICE_ID:
			return getDeviceId();
		case OMADMSimulatorPackage.DEVICE__LOGIN:
			return getLogin();
		case OMADMSimulatorPackage.DEVICE__PASSWORD:
			return getPassword();
		case OMADMSimulatorPackage.DEVICE__SERVER_URL:
			return getServerUrl();
		case OMADMSimulatorPackage.DEVICE__AUTHENTICATION:
			return getAuthentication();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case OMADMSimulatorPackage.DEVICE__DEVICE_ID_TYPE:
			setDeviceIdType((DeviceIdType) newValue);
			return;
		case OMADMSimulatorPackage.DEVICE__TREE:
			setTree((Node) newValue);
			return;
		case OMADMSimulatorPackage.DEVICE__DEVICE_ID:
			setDeviceId((String) newValue);
			return;
		case OMADMSimulatorPackage.DEVICE__LOGIN:
			setLogin((String) newValue);
			return;
		case OMADMSimulatorPackage.DEVICE__PASSWORD:
			setPassword((String) newValue);
			return;
		case OMADMSimulatorPackage.DEVICE__SERVER_URL:
			setServerUrl((String) newValue);
			return;
		case OMADMSimulatorPackage.DEVICE__AUTHENTICATION:
			setAuthentication((AuthenticationType) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case OMADMSimulatorPackage.DEVICE__DEVICE_ID_TYPE:
			setDeviceIdType(DEVICE_ID_TYPE_EDEFAULT);
			return;
		case OMADMSimulatorPackage.DEVICE__TREE:
			setTree((Node) null);
			return;
		case OMADMSimulatorPackage.DEVICE__DEVICE_ID:
			setDeviceId(DEVICE_ID_EDEFAULT);
			return;
		case OMADMSimulatorPackage.DEVICE__LOGIN:
			setLogin(LOGIN_EDEFAULT);
			return;
		case OMADMSimulatorPackage.DEVICE__PASSWORD:
			setPassword(PASSWORD_EDEFAULT);
			return;
		case OMADMSimulatorPackage.DEVICE__SERVER_URL:
			setServerUrl(SERVER_URL_EDEFAULT);
			return;
		case OMADMSimulatorPackage.DEVICE__AUTHENTICATION:
			setAuthentication(AUTHENTICATION_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case OMADMSimulatorPackage.DEVICE__DEVICE_ID_TYPE:
			return deviceIdType != DEVICE_ID_TYPE_EDEFAULT;
		case OMADMSimulatorPackage.DEVICE__TREE:
			return tree != null;
		case OMADMSimulatorPackage.DEVICE__DEVICE_ID:
			return DEVICE_ID_EDEFAULT == null ? deviceId != null : !DEVICE_ID_EDEFAULT.equals(deviceId);
		case OMADMSimulatorPackage.DEVICE__LOGIN:
			return LOGIN_EDEFAULT == null ? login != null : !LOGIN_EDEFAULT.equals(login);
		case OMADMSimulatorPackage.DEVICE__PASSWORD:
			return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
		case OMADMSimulatorPackage.DEVICE__SERVER_URL:
			return SERVER_URL_EDEFAULT == null ? serverUrl != null : !SERVER_URL_EDEFAULT.equals(serverUrl);
		case OMADMSimulatorPackage.DEVICE__AUTHENTICATION:
			return authentication != AUTHENTICATION_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (deviceIdType: ");
		result.append(deviceIdType);
		result.append(", deviceId: ");
		result.append(deviceId);
		result.append(", login: ");
		result.append(login);
		result.append(", password: ");
		result.append(password);
		result.append(", serverUrl: ");
		result.append(serverUrl);
		result.append(", authentication: ");
		result.append(authentication);
		result.append(')');
		return result.toString();
	}

} // DeviceImpl
