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

import static org.eclipse.koneki.simulators.omadm.model.util.DeviceHelpers.isValidDeviceId;
import static org.eclipse.koneki.simulators.omadm.model.util.DeviceHelpers.isValidRootNodeType;
import static org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers.isRespectAuthorizationChildren;
import static org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers.isUniqueChildrenName;
import static org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers.isValidChildrenType;
import static org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers.isValidNodeData;
import static org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers.isValidNodeFormat;
import static org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers.isValidNodeManagement;
import static org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers.isValidNodeName;
import static org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers.isValidNodeType;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.koneki.simulators.omadm.model.*;
import org.eclipse.koneki.simulators.omadm.model.CommandManagement;
import org.eclipse.koneki.simulators.omadm.model.Device;
import org.eclipse.koneki.simulators.omadm.model.DeviceIdType;
import org.eclipse.koneki.simulators.omadm.model.Node;
import org.eclipse.koneki.simulators.omadm.model.NodeFormat;
import org.eclipse.koneki.simulators.omadm.model.OMADMSimulation;
import org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage;
import org.eclipse.koneki.simulators.omadm.model.internal.OMADMSimulationModelPlugin;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc -->
 * @see org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage
 * @generated
 */
public class OMADMSimulatorValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final OMADMSimulatorValidator INSTANCE = new OMADMSimulatorValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.koneki.simulators.omadm.model";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OMADMSimulatorValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return OMADMSimulatorPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case OMADMSimulatorPackage.OMADM_SIMULATION:
				return validateOMADMSimulation((OMADMSimulation)value, diagnostics, context);
			case OMADMSimulatorPackage.DEVICE:
				return validateDevice((Device)value, diagnostics, context);
			case OMADMSimulatorPackage.NODE:
				return validateNode((Node)value, diagnostics, context);
			case OMADMSimulatorPackage.DEVICE_ID_TYPE:
				return validateDeviceIdType((DeviceIdType)value, diagnostics, context);
			case OMADMSimulatorPackage.NODE_FORMAT:
				return validateNodeFormat((NodeFormat)value, diagnostics, context);
			case OMADMSimulatorPackage.COMMAND_MANAGEMENT:
				return validateCommandManagement((CommandManagement)value, diagnostics, context);
			case OMADMSimulatorPackage.AUTHENTICATION_TYPE:
				return validateAuthenticationType((AuthenticationType)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOMADMSimulation(OMADMSimulation omadmSimulation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(omadmSimulation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDevice(Device device, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(device, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(device, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(device, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(device, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(device, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(device, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(device, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(device, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(device, diagnostics, context);
		if (result || diagnostics != null) result &= validateDevice_groupPathMustBeAValidPath(device, diagnostics, context);
		if (result || diagnostics != null) result &= validateDevice_modelNameMustBeValid(device, diagnostics, context);
		if (result || diagnostics != null) result &= validateDevice_customerPathMustBeAValidPath(device, diagnostics, context);
		if (result || diagnostics != null) result &= validateDevice_deviceIdMustBeValid(device, diagnostics, context);
		if (result || diagnostics != null) result &= validateDevice_rootNodeCategoryMustBeValid(device, diagnostics, context);
		return result;
	}

	/**
	 * Validates the groupPathMustBeAValidPath constraint of '<em>Device</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDevice_groupPathMustBeAValidPath(Device device, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "groupPathMustBeAValidPath", getObjectLabel(device, context) },
						 new Object[] { device },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the modelNameMustBeValid constraint of '<em>Device</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDevice_modelNameMustBeValid(Device device, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "modelNameMustBeValid", getObjectLabel(device, context) },
						 new Object[] { device },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the customerPathMustBeAValidPath constraint of '<em>Device</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDevice_customerPathMustBeAValidPath(Device device, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "customerPathMustBeAValidPath", getObjectLabel(device, context) },
						 new Object[] { device },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * @param device
	 * @param diagnostics
	 * @param context
	 * @return
	 */
	public boolean validateDevice_passwordURLMustBeValid(Device device, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * @param device
	 * @param diagnostics
	 * @param context
	 * @return
	 */
	public boolean validateDevice_loginMustBeValid(Device device, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Validates the serverURLMustBeValid constraint of '<em>Device</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateDevice_serverURLMustBeValid(Device device, DiagnosticChain diagnostics, Map<Object, Object> context) {
		assert (device != null);

		boolean isValid = DeviceHelpers.isValidServerURL(device);

		if (!isValid) {
			diagnostics.add(createErrorDiagnostic(createDeviceMessage(device, context, "URL server", "The url server must be valid."),
					new Object[] { device }));
		}

		return isValid;
	}

	/**
	 * Validates the deviceIdMustBeValid constraint of '<em>Device</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateDevice_deviceIdMustBeValid(Device device, DiagnosticChain diagnostics, Map<Object, Object> context) {
		assert (device != null);
		if (isValidDeviceId(device)) {
			return true;
		} else {
			if (diagnostics != null) {
				switch (device.getDeviceIdType()) {
				case IMEI:
					diagnostics.add(createErrorDiagnostic(createDeviceMessage(device, context, "IMEI number", "must have 15 digits."),
							new Object[] { device }));
					break;
				case MAC_ADDRESS:
					diagnostics.add(createErrorDiagnostic(createDeviceMessage(device, context, "MAC address", "must have 12 hexadecimal digits."),
							new Object[] { device }));
					break;
				default:
					diagnostics.add(createErrorDiagnostic(createDeviceMessage(device, context, "deviceId", "is invalid."), new Object[] { device }));
					break;
				}
			}
			return false;
		}
	}

	/**
	 * Validates the rootNodeCategoryMustBeValid constraint of '<em>Device</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateDevice_rootNodeCategoryMustBeValid(Device device, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (isValidRootNodeType(device)) {
			return true;
		} else {
			if (diagnostics != null) {
				diagnostics.add(createErrorDiagnostic(createDeviceMessage(device, context, "root node", "must be a root node."),
						new Object[] { device }));
			}
			return false;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNode(Node node, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(node, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(node, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(node, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(node, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(node, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(node, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(node, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(node, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(node, diagnostics, context);
		if (result || diagnostics != null) result &= validateNode_nodeNameMustBeValid(node, diagnostics, context);
		if (result || diagnostics != null) result &= validateNode_nodeFormatMustBeValid(node, diagnostics, context);
		if (result || diagnostics != null) result &= validateNode_nodeTypeMustBeValid(node, diagnostics, context);
		if (result || diagnostics != null) result &= validateNode_nodeDataMustBeValid(node, diagnostics, context);
		if (result || diagnostics != null) result &= validateNode_nodeManagementMustBeValid(node, diagnostics, context);
		if (result || diagnostics != null) result &= validateNode_childrenMustBeAuthorized(node, diagnostics, context);
		if (result || diagnostics != null) result &= validateNode_childrenCategoryMustBeValid(node, diagnostics, context);
		if (result || diagnostics != null) result &= validateNode_childrenNameMustBeUnique(node, diagnostics, context);
		return result;
	}

	/**
	 * Validates the nodeNameMustBeValid constraint of '<em>Node</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateNode_nodeNameMustBeValid(Node node, DiagnosticChain diagnostics, Map<Object, Object> context) {
		assert (node != null);
		if (isValidNodeName(node)) {
			return true;
		} else {
			if (diagnostics != null) {
				if (node.isRoot()) {
					diagnostics.add(createErrorDiagnostic(createNodeMessage(node, context, "name", "must be \".\"."), new Object[] { node }));
				} else if (node.isLeaf() || node.isInterior()) {
					diagnostics.add(createErrorDiagnostic(createNodeMessage(node, context, "name", "is invalid."), new Object[] { node }));
				}
			}
			return false;
		}
	}

	/**
	 * Validates the nodeFormatMustBeValid constraint of '<em>Node</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateNode_nodeFormatMustBeValid(Node node, DiagnosticChain diagnostics, Map<Object, Object> context) {
		assert (node != null);
		if (isValidNodeFormat(node)) {
			return true;
		} else {
			if (diagnostics != null) {
				if (node.isRoot() || node.isInterior()) {
					diagnostics.add(createErrorDiagnostic(
							createNodeMessage(node, context, "format", "must be \"" + NodeFormat.NODE.getLiteral() + "\"."), new Object[] { node }));
				} else if (node.isLeaf()) {
					diagnostics
							.add(createErrorDiagnostic(
									createNodeMessage(node, context, "format", "mustn't be \"" + NodeFormat.NODE.getLiteral() + "\"."),
									new Object[] { node }));
				}
			}
			return false;
		}
	}

	/**
	 * Validates the nodeTypeMustBeValid constraint of '<em>Node</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateNode_nodeTypeMustBeValid(Node node, DiagnosticChain diagnostics, Map<Object, Object> context) {
		assert (node != null);
		if (isValidNodeType(node)) {
			return true;
		} else {
			if (diagnostics != null) {
				diagnostics.add(createErrorDiagnostic(createNodeMessage(node, context, "type", "must be valid."), new Object[] { node }));
			}
			return false;
		}
	}

	/**
	 * Validates the nodeDataMustBeValid constraint of '<em>Node</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateNode_nodeDataMustBeValid(Node node, DiagnosticChain diagnostics, Map<Object, Object> context) {
		assert (node != null);
		if (isValidNodeData(node)) {
			return true;
		} else {
			if (diagnostics != null) {
				diagnostics.add(createErrorDiagnostic(createNodeMessage(node, context, "data", "must be valid."), new Object[] { node }));
			}
			return false;
		}
	}

	/**
	 * Validates the nodeManagementMustBeValid constraint of '<em>Node</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateNode_nodeManagementMustBeValid(Node node, DiagnosticChain diagnostics, Map<Object, Object> context) {
		assert (node != null);
		if (isValidNodeManagement(node)) {
			return true;
		} else {
			if (diagnostics != null) {
				diagnostics.add(createErrorDiagnostic(createNodeMessage(node, context, "management", "must be valid."), new Object[] { node }));
			}
			return false;
		}
	}

	/**
	 * Validates the childrenMustBeAuthorized constraint of '<em>Node</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateNode_childrenMustBeAuthorized(Node node, DiagnosticChain diagnostics, Map<Object, Object> context) {
		assert (node != null);
		if (isRespectAuthorizationChildren(node)) {
			return true;
		} else {
			if (diagnostics != null) {
				diagnostics.add(createErrorDiagnostic(createNodeMessage(node, context, "possibility to have children", "isn't authorized."),
						new Object[] { node }));
			}
			return false;
		}
	}

	/**
	 * Validates the childrenCategoryMustBeValid constraint of '<em>Node</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateNode_childrenCategoryMustBeValid(Node node, DiagnosticChain diagnostics, Map<Object, Object> context) {
		assert (node != null);
		if (isValidChildrenType(node)) {
			return true;
		} else {
			if (diagnostics != null) {
				if (!node.isLeaf()) {
					diagnostics.add(createErrorDiagnostic(createNodeMessage(node, context, "children type", "musn't be a root node."),
							new Object[] { node }));
				}
			}
			return false;
		}
	}

	/**
	 * Validates the childrenNameMustBeUnique constraint of '<em>Node</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateNode_childrenNameMustBeUnique(Node node, DiagnosticChain diagnostics, Map<Object, Object> context) {
		assert (node != null);
		if (isUniqueChildrenName(node)) {
			return true;
		} else {
			if (diagnostics != null) {
				if (!node.isLeaf()) {
					diagnostics.add(createErrorDiagnostic(createNodeMessage(node, context, "children name", "isn't unique."), new Object[] { node }));
				}
			}
			return false;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeviceIdType(DeviceIdType deviceIdType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNodeFormat(NodeFormat nodeFormat, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCommandManagement(CommandManagement commandManagement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAuthenticationType(AuthenticationType authenticationType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return OMADMSimulationModelPlugin.INSTANCE;
	}

	private static final Diagnostic createErrorDiagnostic(final String message, final Object[] data) {
		assert (message != null);
		assert (data != null);
		return new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, message, data);
	}

	private static final String createNodeMessage(final Node node, final Map<Object, Object> context, final String what, final String endMessage) {
		assert (node != null);
		assert (what != null);
		assert (endMessage != null);
		assert (what.matches("\\S+.*\\S+"));
		assert (what.matches("\\S+.*\\S+"));
		return "The " + what + " of the " + getCategory(node) + " node " + (node.isRoot() ? "" : ("\"" + getObjectLabel(node, context) + "\" "))
				+ endMessage;
	}

	private static final String createDeviceMessage(final Device device, final Map<Object, Object> context, final String what, final String endMessage) {
		assert (device != null);
		assert (what != null);
		assert (endMessage != null);
		assert (what.matches("\\S+.*\\S+"));
		assert (what.matches("\\S+.*\\S+"));
		return "The " + what + " of the " + getObjectLabel(device, context) + " " + endMessage;
	}

	private static final String getCategory(final Node node) {
		if (node.isRoot()) {
			return "root";
		} else if (node.isInterior()) {
			return "interior";
		} else if (node.isLeaf()) {
			return "leaf";
		} else {
			return "";
		}
	}

} // OMADMSimulatorValidator
