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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Node</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getFormat <em>Format</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getData <em>Data</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getGetManagement <em>Get Management</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getGetCode <em>Get Code</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getAddManagement <em>Add Management</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getDeleteManagement <em>Delete Management</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getCopyManagement <em>Copy Management</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getReplaceManagement <em>Replace Management</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getExecManagement <em>Exec Management</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getAddCode <em>Add Code</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getDeleteCode <em>Delete Code</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getCopyCode <em>Copy Code</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getReplaceCode <em>Replace Code</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getExecCode <em>Exec Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getNode()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='nodeNameMustBeValid\nnodeFormatMustBeValid\nnodeTypeMustBeValid\nnodeDataMustBeValid\nnodeManagementMustBeValid\nchildrenMustBeAuthorized\nchildrenCategoryMustBeValid\nchildrenNameMustBeUnique\n'"
 * @generated
 */
public interface Node extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getNode_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Format</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.koneki.simulators.omadm.model.NodeFormat}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Format</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Format</em>' attribute.
	 * @see org.eclipse.koneki.simulators.omadm.model.NodeFormat
	 * @see #setFormat(NodeFormat)
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getNode_Format()
	 * @model required="true"
	 * @generated
	 */
	NodeFormat getFormat();

	/**
	 * Sets the value of the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getFormat <em>Format</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Format</em>' attribute.
	 * @see org.eclipse.koneki.simulators.omadm.model.NodeFormat
	 * @see #getFormat()
	 * @generated
	 */
	void setFormat(NodeFormat value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.koneki.simulators.omadm.model.Node}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.koneki.simulators.omadm.model.Node#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getNode_Children()
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<Node> getChildren();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getNode_Type()
	 * @model required="true"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' attribute.
	 * @see #setData(String)
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getNode_Data()
	 * @model required="true"
	 * @generated
	 */
	String getData();

	/**
	 * Sets the value of the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getData <em>Data</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' attribute.
	 * @see #getData()
	 * @generated
	 */
	void setData(String value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.koneki.simulators.omadm.model.Node#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Node)
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getNode_Parent()
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getChildren
	 * @model opposite="children" transient="false"
	 * @generated
	 */
	Node getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Node value);

	/**
	 * Returns the value of the '<em><b>Get Management</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.koneki.simulators.omadm.model.CommandManagement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Get Management</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Get Management</em>' attribute.
	 * @see org.eclipse.koneki.simulators.omadm.model.CommandManagement
	 * @see #setGetManagement(CommandManagement)
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getNode_GetManagement()
	 * @model required="true"
	 * @generated
	 */
	CommandManagement getGetManagement();

	/**
	 * Sets the value of the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getGetManagement <em>Get Management</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Get Management</em>' attribute.
	 * @see org.eclipse.koneki.simulators.omadm.model.CommandManagement
	 * @see #getGetManagement()
	 * @generated
	 */
	void setGetManagement(CommandManagement value);

	/**
	 * Returns the value of the '<em><b>Get Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Get Code</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Get Code</em>' attribute.
	 * @see #setGetCode(int)
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getNode_GetCode()
	 * @model required="true"
	 * @generated
	 */
	int getGetCode();

	/**
	 * Sets the value of the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getGetCode <em>Get Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Get Code</em>' attribute.
	 * @see #getGetCode()
	 * @generated
	 */
	void setGetCode(int value);

	/**
	 * Returns the value of the '<em><b>Add Management</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.koneki.simulators.omadm.model.CommandManagement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add Management</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add Management</em>' attribute.
	 * @see org.eclipse.koneki.simulators.omadm.model.CommandManagement
	 * @see #setAddManagement(CommandManagement)
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getNode_AddManagement()
	 * @model required="true"
	 * @generated
	 */
	CommandManagement getAddManagement();

	/**
	 * Sets the value of the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getAddManagement <em>Add Management</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Add Management</em>' attribute.
	 * @see org.eclipse.koneki.simulators.omadm.model.CommandManagement
	 * @see #getAddManagement()
	 * @generated
	 */
	void setAddManagement(CommandManagement value);

	/**
	 * Returns the value of the '<em><b>Delete Management</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.koneki.simulators.omadm.model.CommandManagement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delete Management</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delete Management</em>' attribute.
	 * @see org.eclipse.koneki.simulators.omadm.model.CommandManagement
	 * @see #setDeleteManagement(CommandManagement)
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getNode_DeleteManagement()
	 * @model required="true"
	 * @generated
	 */
	CommandManagement getDeleteManagement();

	/**
	 * Sets the value of the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getDeleteManagement <em>Delete Management</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Delete Management</em>' attribute.
	 * @see org.eclipse.koneki.simulators.omadm.model.CommandManagement
	 * @see #getDeleteManagement()
	 * @generated
	 */
	void setDeleteManagement(CommandManagement value);

	/**
	 * Returns the value of the '<em><b>Copy Management</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.koneki.simulators.omadm.model.CommandManagement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Copy Management</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Copy Management</em>' attribute.
	 * @see org.eclipse.koneki.simulators.omadm.model.CommandManagement
	 * @see #setCopyManagement(CommandManagement)
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getNode_CopyManagement()
	 * @model required="true"
	 * @generated
	 */
	CommandManagement getCopyManagement();

	/**
	 * Sets the value of the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getCopyManagement <em>Copy Management</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Copy Management</em>' attribute.
	 * @see org.eclipse.koneki.simulators.omadm.model.CommandManagement
	 * @see #getCopyManagement()
	 * @generated
	 */
	void setCopyManagement(CommandManagement value);

	/**
	 * Returns the value of the '<em><b>Replace Management</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.koneki.simulators.omadm.model.CommandManagement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Replace Management</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Replace Management</em>' attribute.
	 * @see org.eclipse.koneki.simulators.omadm.model.CommandManagement
	 * @see #setReplaceManagement(CommandManagement)
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getNode_ReplaceManagement()
	 * @model required="true"
	 * @generated
	 */
	CommandManagement getReplaceManagement();

	/**
	 * Sets the value of the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getReplaceManagement <em>Replace Management</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Replace Management</em>' attribute.
	 * @see org.eclipse.koneki.simulators.omadm.model.CommandManagement
	 * @see #getReplaceManagement()
	 * @generated
	 */
	void setReplaceManagement(CommandManagement value);

	/**
	 * Returns the value of the '<em><b>Exec Management</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.koneki.simulators.omadm.model.CommandManagement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exec Management</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exec Management</em>' attribute.
	 * @see org.eclipse.koneki.simulators.omadm.model.CommandManagement
	 * @see #setExecManagement(CommandManagement)
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getNode_ExecManagement()
	 * @model required="true"
	 * @generated
	 */
	CommandManagement getExecManagement();

	/**
	 * Sets the value of the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getExecManagement <em>Exec Management</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Exec Management</em>' attribute.
	 * @see org.eclipse.koneki.simulators.omadm.model.CommandManagement
	 * @see #getExecManagement()
	 * @generated
	 */
	void setExecManagement(CommandManagement value);

	/**
	 * Returns the value of the '<em><b>Add Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add Code</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add Code</em>' attribute.
	 * @see #setAddCode(int)
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getNode_AddCode()
	 * @model required="true"
	 * @generated
	 */
	int getAddCode();

	/**
	 * Sets the value of the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getAddCode <em>Add Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add Code</em>' attribute.
	 * @see #getAddCode()
	 * @generated
	 */
	void setAddCode(int value);

	/**
	 * Returns the value of the '<em><b>Delete Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delete Code</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delete Code</em>' attribute.
	 * @see #setDeleteCode(int)
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getNode_DeleteCode()
	 * @model required="true"
	 * @generated
	 */
	int getDeleteCode();

	/**
	 * Sets the value of the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getDeleteCode <em>Delete Code</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delete Code</em>' attribute.
	 * @see #getDeleteCode()
	 * @generated
	 */
	void setDeleteCode(int value);

	/**
	 * Returns the value of the '<em><b>Copy Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Copy Code</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Copy Code</em>' attribute.
	 * @see #setCopyCode(int)
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getNode_CopyCode()
	 * @model required="true"
	 * @generated
	 */
	int getCopyCode();

	/**
	 * Sets the value of the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getCopyCode <em>Copy Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Copy Code</em>' attribute.
	 * @see #getCopyCode()
	 * @generated
	 */
	void setCopyCode(int value);

	/**
	 * Returns the value of the '<em><b>Replace Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Replace Code</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Replace Code</em>' attribute.
	 * @see #setReplaceCode(int)
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getNode_ReplaceCode()
	 * @model required="true"
	 * @generated
	 */
	int getReplaceCode();

	/**
	 * Sets the value of the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getReplaceCode <em>Replace Code</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Replace Code</em>' attribute.
	 * @see #getReplaceCode()
	 * @generated
	 */
	void setReplaceCode(int value);

	/**
	 * Returns the value of the '<em><b>Exec Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exec Code</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exec Code</em>' attribute.
	 * @see #setExecCode(int)
	 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage#getNode_ExecCode()
	 * @model required="true"
	 * @generated
	 */
	int getExecCode();

	/**
	 * Sets the value of the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getExecCode <em>Exec Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exec Code</em>' attribute.
	 * @see #getExecCode()
	 * @generated
	 */
	void setExecCode(int value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	String getPath();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Node getRoot();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	CommandManagement getRealGetManagement();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	CommandManagement getRealAddManagement();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	CommandManagement getRealDeleteManagement();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	CommandManagement getRealCopyManagement();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	CommandManagement getRealReplaceManagement();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	CommandManagement getRealExecManagement();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getRealGetCode();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getRealAddCode();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getRealDeleteCode();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getRealCopyCode();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getRealReplaceCode();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getRealExecCode();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isRoot();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isInterior();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isLeaf();

} // Node
