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
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.koneki.simulators.omadm.model.AuthenticationType;
import org.eclipse.koneki.simulators.omadm.model.CommandManagement;
import org.eclipse.koneki.simulators.omadm.model.Device;
import org.eclipse.koneki.simulators.omadm.model.Node;
import org.eclipse.koneki.simulators.omadm.model.NodeFormat;
import org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage;
import org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Node</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.NodeImpl#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.NodeImpl#getFormat <em>Format</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.NodeImpl#getChildren <em>Children</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.NodeImpl#getType <em>Type</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.NodeImpl#getData <em>Data</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.NodeImpl#getParent <em>Parent</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.NodeImpl#getGetManagement <em>Get Management</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.NodeImpl#getGetCode <em>Get Code</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.NodeImpl#getAddManagement <em>Add Management</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.NodeImpl#getDeleteManagement <em>Delete Management</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.NodeImpl#getCopyManagement <em>Copy Management</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.NodeImpl#getReplaceManagement <em>Replace Management</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.NodeImpl#getExecManagement <em>Exec Management</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.NodeImpl#getAddCode <em>Add Code</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.NodeImpl#getDeleteCode <em>Delete Code</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.NodeImpl#getCopyCode <em>Copy Code</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.NodeImpl#getReplaceCode <em>Replace Code</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.impl.NodeImpl#getExecCode <em>Exec Code</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class NodeImpl extends EObjectImpl implements Node {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFormat() <em>Format</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected static final NodeFormat FORMAT_EDEFAULT = NodeFormat.CHR;

	/**
	 * The cached value of the '{@link #getFormat() <em>Format</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected NodeFormat format = FORMAT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> children;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getData() <em>Data</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected String data = DATA_EDEFAULT;

	/**
	 * The default value of the '{@link #getGetManagement() <em>Get Management</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGetManagement()
	 * @generated
	 * @ordered
	 */
	protected static final CommandManagement GET_MANAGEMENT_EDEFAULT = CommandManagement.INHERITED;

	/**
	 * The cached value of the '{@link #getGetManagement() <em>Get Management</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGetManagement()
	 * @generated
	 * @ordered
	 */
	protected CommandManagement getManagement = GET_MANAGEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getGetCode() <em>Get Code</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGetCode()
	 * @generated
	 * @ordered
	 */
	protected static final int GET_CODE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getGetCode() <em>Get Code</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGetCode()
	 * @generated
	 * @ordered
	 */
	protected int getCode = GET_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAddManagement() <em>Add Management</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAddManagement()
	 * @generated
	 * @ordered
	 */
	protected static final CommandManagement ADD_MANAGEMENT_EDEFAULT = CommandManagement.INHERITED;

	/**
	 * The cached value of the '{@link #getAddManagement() <em>Add Management</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAddManagement()
	 * @generated
	 * @ordered
	 */
	protected CommandManagement addManagement = ADD_MANAGEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDeleteManagement() <em>Delete Management</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDeleteManagement()
	 * @generated
	 * @ordered
	 */
	protected static final CommandManagement DELETE_MANAGEMENT_EDEFAULT = CommandManagement.INHERITED;

	/**
	 * The cached value of the '{@link #getDeleteManagement() <em>Delete Management</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDeleteManagement()
	 * @generated
	 * @ordered
	 */
	protected CommandManagement deleteManagement = DELETE_MANAGEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getCopyManagement() <em>Copy Management</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCopyManagement()
	 * @generated
	 * @ordered
	 */
	protected static final CommandManagement COPY_MANAGEMENT_EDEFAULT = CommandManagement.INHERITED;

	/**
	 * The cached value of the '{@link #getCopyManagement() <em>Copy Management</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCopyManagement()
	 * @generated
	 * @ordered
	 */
	protected CommandManagement copyManagement = COPY_MANAGEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getReplaceManagement() <em>Replace Management</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReplaceManagement()
	 * @generated
	 * @ordered
	 */
	protected static final CommandManagement REPLACE_MANAGEMENT_EDEFAULT = CommandManagement.INHERITED;

	/**
	 * The cached value of the '{@link #getReplaceManagement() <em>Replace Management</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReplaceManagement()
	 * @generated
	 * @ordered
	 */
	protected CommandManagement replaceManagement = REPLACE_MANAGEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getExecManagement() <em>Exec Management</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExecManagement()
	 * @generated
	 * @ordered
	 */
	protected static final CommandManagement EXEC_MANAGEMENT_EDEFAULT = CommandManagement.INHERITED;

	/**
	 * The cached value of the '{@link #getExecManagement() <em>Exec Management</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExecManagement()
	 * @generated
	 * @ordered
	 */
	protected CommandManagement execManagement = EXEC_MANAGEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getAddCode() <em>Add Code</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAddCode()
	 * @generated
	 * @ordered
	 */
	protected static final int ADD_CODE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAddCode() <em>Add Code</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAddCode()
	 * @generated
	 * @ordered
	 */
	protected int addCode = ADD_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDeleteCode() <em>Delete Code</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDeleteCode()
	 * @generated
	 * @ordered
	 */
	protected static final int DELETE_CODE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDeleteCode() <em>Delete Code</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDeleteCode()
	 * @generated
	 * @ordered
	 */
	protected int deleteCode = DELETE_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCopyCode() <em>Copy Code</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCopyCode()
	 * @generated
	 * @ordered
	 */
	protected static final int COPY_CODE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCopyCode() <em>Copy Code</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCopyCode()
	 * @generated
	 * @ordered
	 */
	protected int copyCode = COPY_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getReplaceCode() <em>Replace Code</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReplaceCode()
	 * @generated
	 * @ordered
	 */
	protected static final int REPLACE_CODE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getReplaceCode() <em>Replace Code</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReplaceCode()
	 * @generated
	 * @ordered
	 */
	protected int replaceCode = REPLACE_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExecCode() <em>Exec Code</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExecCode()
	 * @generated
	 * @ordered
	 */
	protected static final int EXEC_CODE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getExecCode() <em>Exec Code</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExecCode()
	 * @generated
	 * @ordered
	 */
	protected int execCode = EXEC_CODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OMADMSimulatorPackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.NODE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NodeFormat getFormat() {
		return format;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFormat(NodeFormat newFormat) {
		NodeFormat oldFormat = format;
		format = newFormat == null ? FORMAT_EDEFAULT : newFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.NODE__FORMAT, oldFormat, format));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Node> getChildren() {
		if (children == null) {
			children = new EObjectContainmentWithInverseEList<Node>(Node.class, this, OMADMSimulatorPackage.NODE__CHILDREN,
					OMADMSimulatorPackage.NODE__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.NODE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getData() {
		return data;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setData(String newData) {
		String oldData = data;
		data = newData;

		if (oldData != null && !oldData.equals(newData)) {

			Device device = (Device) this.getRoot().eContainer();
			if (NodeHelpers.findFirstNode(NodeHelpers.getNode(getRoot(), "./DevInfo"), "DevId") == this) {
				device.setDeviceId(newData);
			} else if (NodeHelpers.findFirstNode(NodeHelpers.getNode(getRoot(), "./DMAcc/AppAuth"), "AuthName") == this) {
				device.setLogin(newData);
			} else if (NodeHelpers.findFirstNode(NodeHelpers.getNode(getRoot(), "./DMAcc/AppAuth"), "AuthSecret") == this) {
				device.setPassword(newData);
			} else if (NodeHelpers.findFirstNode(NodeHelpers.getNode(getRoot(), "./DMAcc"), "AuthPref") == this) {

				try {
					AuthenticationType auth = AuthenticationType.getByName(newData);

					device.setAuthentication(auth);
				} catch (Exception e) {
					// The authentication type doesn't exist for the value of newData
					device.setAuthentication(AuthenticationType.NONE);
				}
			} else if (NodeHelpers.findFirstNode(NodeHelpers.getNode(getRoot(), "./DMAcc/AppAddr"), "AddrType") == this) {

				Node AddrNode = NodeHelpers.findFirstNode(NodeHelpers.getNode(getRoot(), "./DMAcc/AppAddr"), "Addr");

				try {
					URL oldUrl = new URL(AddrNode.getData());
					int oldPortNumber = oldUrl.getPort();
					if (oldPortNumber == -1) {
						oldPortNumber = 80;
					}

					URL newUrl = new URL(newData);
					int newPortNumber = newUrl.getPort();
					if (newPortNumber == -1) {
						newPortNumber = 80;
					}
					String newServerName = newUrl.getHost();
					String newPath = newUrl.getPath();
					String newProtocol = newUrl.getProtocol();

					if (oldPortNumber != 80) {
						AddrNode.setData(newProtocol + "://" + newServerName + ":" + oldPortNumber + newPath);
					} else {
						AddrNode.setData(newProtocol + "://" + newServerName + newPath);
					}

				} catch (MalformedURLException e) {
				}

			} else if (NodeHelpers.findFirstNode(NodeHelpers.getNode(getRoot(), "./DMAcc/AppAddr"), "Addr") == this) {
				try {
					URL newUrl = new URL(newData);
					int newPortNumber = newUrl.getPort();
					if (newPortNumber == -1) {
						newPortNumber = 80;
					}
					String newServerName = newUrl.getHost();
					String newPath = newUrl.getPath();
					String newProtocol = newUrl.getProtocol();

					if (newPortNumber != 80) {
						device.setServerUrl(newProtocol + "://" + newServerName + ":" + newPortNumber + newPath);
					} else {
						device.setServerUrl(newProtocol + "://" + newServerName + newPath);
					}

				} catch (MalformedURLException e) {
					device.setServerUrl("");
				}
			} else if (NodeHelpers.findFirstNode(NodeHelpers.findFirstNode(NodeHelpers.getNode(getRoot(), "./DMAcc/AppAddr"), "Port"), "PortNbr") == this) {

				Node AddrNode = NodeHelpers.findFirstNode(NodeHelpers.getNode(getRoot(), "./DMAcc/AppAddr"), "Addr");

				try {

					URL oldUrl = new URL(AddrNode.getData());
					int oldPortNumber = oldUrl.getPort();
					if (oldPortNumber == -1) {
						oldPortNumber = 80;
					}
					String oldServerName = oldUrl.getHost();
					String oldPath = oldUrl.getPath();
					String oldProtocol = oldUrl.getProtocol();

					int newPortNumber = 80;
					try {
						newPortNumber = Integer.valueOf(newData);
					} catch (Exception e) {
					}

					if (newPortNumber != 80) {
						AddrNode.setData(oldProtocol + "://" + oldServerName + ":" + newPortNumber + oldPath);
					} else {
						AddrNode.setData(oldProtocol + "://" + oldServerName + oldPath);
					}
				} catch (MalformedURLException e) {
				}
			}

		}
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.NODE__DATA, oldData, data));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Node getParent() {
		if (eContainerFeatureID() != OMADMSimulatorPackage.NODE__PARENT)
			return null;
		return (Node) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetParent(Node newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParent, OMADMSimulatorPackage.NODE__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParent(Node newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != OMADMSimulatorPackage.NODE__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject) newParent).eInverseAdd(this, OMADMSimulatorPackage.NODE__CHILDREN, Node.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.NODE__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CommandManagement getGetManagement() {
		return getManagement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setGetManagement(CommandManagement newGetManagement) {
		CommandManagement oldGetManagement = getManagement;
		getManagement = newGetManagement == null ? GET_MANAGEMENT_EDEFAULT : newGetManagement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.NODE__GET_MANAGEMENT, oldGetManagement, getManagement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getGetCode() {
		return getCode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setGetCode(int newGetCode) {
		int oldGetCode = getCode;
		getCode = newGetCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.NODE__GET_CODE, oldGetCode, getCode));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CommandManagement getAddManagement() {
		return addManagement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAddManagement(CommandManagement newAddManagement) {
		CommandManagement oldAddManagement = addManagement;
		addManagement = newAddManagement == null ? ADD_MANAGEMENT_EDEFAULT : newAddManagement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.NODE__ADD_MANAGEMENT, oldAddManagement, addManagement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CommandManagement getDeleteManagement() {
		return deleteManagement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDeleteManagement(CommandManagement newDeleteManagement) {
		CommandManagement oldDeleteManagement = deleteManagement;
		deleteManagement = newDeleteManagement == null ? DELETE_MANAGEMENT_EDEFAULT : newDeleteManagement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.NODE__DELETE_MANAGEMENT, oldDeleteManagement,
					deleteManagement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CommandManagement getCopyManagement() {
		return copyManagement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCopyManagement(CommandManagement newCopyManagement) {
		CommandManagement oldCopyManagement = copyManagement;
		copyManagement = newCopyManagement == null ? COPY_MANAGEMENT_EDEFAULT : newCopyManagement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.NODE__COPY_MANAGEMENT, oldCopyManagement, copyManagement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CommandManagement getReplaceManagement() {
		return replaceManagement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setReplaceManagement(CommandManagement newReplaceManagement) {
		CommandManagement oldReplaceManagement = replaceManagement;
		replaceManagement = newReplaceManagement == null ? REPLACE_MANAGEMENT_EDEFAULT : newReplaceManagement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.NODE__REPLACE_MANAGEMENT, oldReplaceManagement,
					replaceManagement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CommandManagement getExecManagement() {
		return execManagement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setExecManagement(CommandManagement newExecManagement) {
		CommandManagement oldExecManagement = execManagement;
		execManagement = newExecManagement == null ? EXEC_MANAGEMENT_EDEFAULT : newExecManagement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.NODE__EXEC_MANAGEMENT, oldExecManagement, execManagement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getAddCode() {
		return addCode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAddCode(int newAddCode) {
		int oldAddCode = addCode;
		addCode = newAddCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.NODE__ADD_CODE, oldAddCode, addCode));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getDeleteCode() {
		return deleteCode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDeleteCode(int newDeleteCode) {
		int oldDeleteCode = deleteCode;
		deleteCode = newDeleteCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.NODE__DELETE_CODE, oldDeleteCode, deleteCode));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getCopyCode() {
		return copyCode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCopyCode(int newCopyCode) {
		int oldCopyCode = copyCode;
		copyCode = newCopyCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.NODE__COPY_CODE, oldCopyCode, copyCode));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getReplaceCode() {
		return replaceCode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setReplaceCode(int newReplaceCode) {
		int oldReplaceCode = replaceCode;
		replaceCode = newReplaceCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.NODE__REPLACE_CODE, oldReplaceCode, replaceCode));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getExecCode() {
		return execCode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setExecCode(int newExecCode) {
		int oldExecCode = execCode;
		execCode = newExecCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMADMSimulatorPackage.NODE__EXEC_CODE, oldExecCode, execCode));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String getPath() {
		if (getParent() == null) {
			return getName();
		} else {
			return new StringBuffer().append(getParent().getPath()).append("/").append(getName()).toString();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Node getRoot() {
		if (isRoot()) {
			return this;
		} else {
			return getParent().getRoot();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public CommandManagement getRealGetManagement() {
		if (getGetManagement() == CommandManagement.INHERITED) {
			return getParent().getRealGetManagement();
		} else {
			return getGetManagement();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public CommandManagement getRealAddManagement() {
		if (getAddManagement() == CommandManagement.INHERITED) {
			return getParent().getRealAddManagement();
		} else {
			return getAddManagement();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public CommandManagement getRealDeleteManagement() {
		if (getDeleteManagement() == CommandManagement.INHERITED) {
			return getParent().getRealDeleteManagement();
		} else {
			return getDeleteManagement();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public CommandManagement getRealCopyManagement() {
		if (getCopyManagement() == CommandManagement.INHERITED) {
			return getParent().getRealCopyManagement();
		} else {
			return getCopyManagement();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public CommandManagement getRealReplaceManagement() {
		if (getReplaceManagement() == CommandManagement.INHERITED) {
			return getParent().getRealReplaceManagement();
		} else {
			return getReplaceManagement();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public CommandManagement getRealExecManagement() {
		if (getExecManagement() == CommandManagement.INHERITED) {
			return getParent().getRealExecManagement();
		} else {
			return getExecManagement();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public int getRealGetCode() {
		if (getGetManagement() == CommandManagement.INHERITED) {
			return getParent().getRealGetCode();
		} else {
			return getGetCode();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public int getRealAddCode() {
		if (getAddManagement() == CommandManagement.INHERITED) {
			return getParent().getRealAddCode();
		} else {
			return getAddCode();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public int getRealDeleteCode() {
		if (getDeleteManagement() == CommandManagement.INHERITED) {
			return getParent().getRealDeleteCode();
		} else {
			return getDeleteCode();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public int getRealCopyCode() {
		if (getCopyManagement() == CommandManagement.INHERITED) {
			return getParent().getRealCopyCode();
		} else {
			return getCopyCode();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public int getRealReplaceCode() {
		if (getReplaceManagement() == CommandManagement.INHERITED) {
			return getParent().getRealReplaceCode();
		} else {
			return getReplaceCode();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public int getRealExecCode() {
		if (getExecManagement() == CommandManagement.INHERITED) {
			return getParent().getRealExecCode();
		} else {
			return getExecCode();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isRoot() {

		boolean res = getParent() == null;
		return res;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isInterior() {
		return !isRoot() && !isLeaf();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isLeaf() {
		return getFormat() != NodeFormat.NODE && getParent() != null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case OMADMSimulatorPackage.NODE__CHILDREN:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getChildren()).basicAdd(otherEnd, msgs);
		case OMADMSimulatorPackage.NODE__PARENT:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParent((Node) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case OMADMSimulatorPackage.NODE__CHILDREN:
			return ((InternalEList<?>) getChildren()).basicRemove(otherEnd, msgs);
		case OMADMSimulatorPackage.NODE__PARENT:
			return basicSetParent(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case OMADMSimulatorPackage.NODE__PARENT:
			return eInternalContainer().eInverseRemove(this, OMADMSimulatorPackage.NODE__CHILDREN, Node.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OMADMSimulatorPackage.NODE__NAME:
			return getName();
		case OMADMSimulatorPackage.NODE__FORMAT:
			return getFormat();
		case OMADMSimulatorPackage.NODE__CHILDREN:
			return getChildren();
		case OMADMSimulatorPackage.NODE__TYPE:
			return getType();
		case OMADMSimulatorPackage.NODE__DATA:
			return getData();
		case OMADMSimulatorPackage.NODE__PARENT:
			return getParent();
		case OMADMSimulatorPackage.NODE__GET_MANAGEMENT:
			return getGetManagement();
		case OMADMSimulatorPackage.NODE__GET_CODE:
			return getGetCode();
		case OMADMSimulatorPackage.NODE__ADD_MANAGEMENT:
			return getAddManagement();
		case OMADMSimulatorPackage.NODE__DELETE_MANAGEMENT:
			return getDeleteManagement();
		case OMADMSimulatorPackage.NODE__COPY_MANAGEMENT:
			return getCopyManagement();
		case OMADMSimulatorPackage.NODE__REPLACE_MANAGEMENT:
			return getReplaceManagement();
		case OMADMSimulatorPackage.NODE__EXEC_MANAGEMENT:
			return getExecManagement();
		case OMADMSimulatorPackage.NODE__ADD_CODE:
			return getAddCode();
		case OMADMSimulatorPackage.NODE__DELETE_CODE:
			return getDeleteCode();
		case OMADMSimulatorPackage.NODE__COPY_CODE:
			return getCopyCode();
		case OMADMSimulatorPackage.NODE__REPLACE_CODE:
			return getReplaceCode();
		case OMADMSimulatorPackage.NODE__EXEC_CODE:
			return getExecCode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case OMADMSimulatorPackage.NODE__NAME:
			setName((String) newValue);
			return;
		case OMADMSimulatorPackage.NODE__FORMAT:
			setFormat((NodeFormat) newValue);
			return;
		case OMADMSimulatorPackage.NODE__CHILDREN:
			getChildren().clear();
			getChildren().addAll((Collection<? extends Node>) newValue);
			return;
		case OMADMSimulatorPackage.NODE__TYPE:
			setType((String) newValue);
			return;
		case OMADMSimulatorPackage.NODE__DATA:
			setData((String) newValue);
			return;
		case OMADMSimulatorPackage.NODE__PARENT:
			setParent((Node) newValue);
			return;
		case OMADMSimulatorPackage.NODE__GET_MANAGEMENT:
			setGetManagement((CommandManagement) newValue);
			return;
		case OMADMSimulatorPackage.NODE__GET_CODE:
			setGetCode((Integer) newValue);
			return;
		case OMADMSimulatorPackage.NODE__ADD_MANAGEMENT:
			setAddManagement((CommandManagement) newValue);
			return;
		case OMADMSimulatorPackage.NODE__DELETE_MANAGEMENT:
			setDeleteManagement((CommandManagement) newValue);
			return;
		case OMADMSimulatorPackage.NODE__COPY_MANAGEMENT:
			setCopyManagement((CommandManagement) newValue);
			return;
		case OMADMSimulatorPackage.NODE__REPLACE_MANAGEMENT:
			setReplaceManagement((CommandManagement) newValue);
			return;
		case OMADMSimulatorPackage.NODE__EXEC_MANAGEMENT:
			setExecManagement((CommandManagement) newValue);
			return;
		case OMADMSimulatorPackage.NODE__ADD_CODE:
			setAddCode((Integer) newValue);
			return;
		case OMADMSimulatorPackage.NODE__DELETE_CODE:
			setDeleteCode((Integer) newValue);
			return;
		case OMADMSimulatorPackage.NODE__COPY_CODE:
			setCopyCode((Integer) newValue);
			return;
		case OMADMSimulatorPackage.NODE__REPLACE_CODE:
			setReplaceCode((Integer) newValue);
			return;
		case OMADMSimulatorPackage.NODE__EXEC_CODE:
			setExecCode((Integer) newValue);
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
		case OMADMSimulatorPackage.NODE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case OMADMSimulatorPackage.NODE__FORMAT:
			setFormat(FORMAT_EDEFAULT);
			return;
		case OMADMSimulatorPackage.NODE__CHILDREN:
			getChildren().clear();
			return;
		case OMADMSimulatorPackage.NODE__TYPE:
			setType(TYPE_EDEFAULT);
			return;
		case OMADMSimulatorPackage.NODE__DATA:
			setData(DATA_EDEFAULT);
			return;
		case OMADMSimulatorPackage.NODE__PARENT:
			setParent((Node) null);
			return;
		case OMADMSimulatorPackage.NODE__GET_MANAGEMENT:
			setGetManagement(GET_MANAGEMENT_EDEFAULT);
			return;
		case OMADMSimulatorPackage.NODE__GET_CODE:
			setGetCode(GET_CODE_EDEFAULT);
			return;
		case OMADMSimulatorPackage.NODE__ADD_MANAGEMENT:
			setAddManagement(ADD_MANAGEMENT_EDEFAULT);
			return;
		case OMADMSimulatorPackage.NODE__DELETE_MANAGEMENT:
			setDeleteManagement(DELETE_MANAGEMENT_EDEFAULT);
			return;
		case OMADMSimulatorPackage.NODE__COPY_MANAGEMENT:
			setCopyManagement(COPY_MANAGEMENT_EDEFAULT);
			return;
		case OMADMSimulatorPackage.NODE__REPLACE_MANAGEMENT:
			setReplaceManagement(REPLACE_MANAGEMENT_EDEFAULT);
			return;
		case OMADMSimulatorPackage.NODE__EXEC_MANAGEMENT:
			setExecManagement(EXEC_MANAGEMENT_EDEFAULT);
			return;
		case OMADMSimulatorPackage.NODE__ADD_CODE:
			setAddCode(ADD_CODE_EDEFAULT);
			return;
		case OMADMSimulatorPackage.NODE__DELETE_CODE:
			setDeleteCode(DELETE_CODE_EDEFAULT);
			return;
		case OMADMSimulatorPackage.NODE__COPY_CODE:
			setCopyCode(COPY_CODE_EDEFAULT);
			return;
		case OMADMSimulatorPackage.NODE__REPLACE_CODE:
			setReplaceCode(REPLACE_CODE_EDEFAULT);
			return;
		case OMADMSimulatorPackage.NODE__EXEC_CODE:
			setExecCode(EXEC_CODE_EDEFAULT);
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
		case OMADMSimulatorPackage.NODE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case OMADMSimulatorPackage.NODE__FORMAT:
			return format != FORMAT_EDEFAULT;
		case OMADMSimulatorPackage.NODE__CHILDREN:
			return children != null && !children.isEmpty();
		case OMADMSimulatorPackage.NODE__TYPE:
			return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
		case OMADMSimulatorPackage.NODE__DATA:
			return DATA_EDEFAULT == null ? data != null : !DATA_EDEFAULT.equals(data);
		case OMADMSimulatorPackage.NODE__PARENT:
			return getParent() != null;
		case OMADMSimulatorPackage.NODE__GET_MANAGEMENT:
			return getManagement != GET_MANAGEMENT_EDEFAULT;
		case OMADMSimulatorPackage.NODE__GET_CODE:
			return getCode != GET_CODE_EDEFAULT;
		case OMADMSimulatorPackage.NODE__ADD_MANAGEMENT:
			return addManagement != ADD_MANAGEMENT_EDEFAULT;
		case OMADMSimulatorPackage.NODE__DELETE_MANAGEMENT:
			return deleteManagement != DELETE_MANAGEMENT_EDEFAULT;
		case OMADMSimulatorPackage.NODE__COPY_MANAGEMENT:
			return copyManagement != COPY_MANAGEMENT_EDEFAULT;
		case OMADMSimulatorPackage.NODE__REPLACE_MANAGEMENT:
			return replaceManagement != REPLACE_MANAGEMENT_EDEFAULT;
		case OMADMSimulatorPackage.NODE__EXEC_MANAGEMENT:
			return execManagement != EXEC_MANAGEMENT_EDEFAULT;
		case OMADMSimulatorPackage.NODE__ADD_CODE:
			return addCode != ADD_CODE_EDEFAULT;
		case OMADMSimulatorPackage.NODE__DELETE_CODE:
			return deleteCode != DELETE_CODE_EDEFAULT;
		case OMADMSimulatorPackage.NODE__COPY_CODE:
			return copyCode != COPY_CODE_EDEFAULT;
		case OMADMSimulatorPackage.NODE__REPLACE_CODE:
			return replaceCode != REPLACE_CODE_EDEFAULT;
		case OMADMSimulatorPackage.NODE__EXEC_CODE:
			return execCode != EXEC_CODE_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", format: ");
		result.append(format);
		result.append(", type: ");
		result.append(type);
		result.append(", data: ");
		result.append(data);
		result.append(", getManagement: ");
		result.append(getManagement);
		result.append(", getCode: ");
		result.append(getCode);
		result.append(", addManagement: ");
		result.append(addManagement);
		result.append(", deleteManagement: ");
		result.append(deleteManagement);
		result.append(", copyManagement: ");
		result.append(copyManagement);
		result.append(", replaceManagement: ");
		result.append(replaceManagement);
		result.append(", execManagement: ");
		result.append(execManagement);
		result.append(", addCode: ");
		result.append(addCode);
		result.append(", deleteCode: ");
		result.append(deleteCode);
		result.append(", copyCode: ");
		result.append(copyCode);
		result.append(", replaceCode: ");
		result.append(replaceCode);
		result.append(", execCode: ");
		result.append(execCode);
		result.append(')');
		return result.toString();
	}

} // NodeImpl
