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

import org.eclipse.emf.common.util.EList;
import org.eclipse.koneki.protocols.omadm.StatusCode;
import org.eclipse.koneki.simulators.omadm.model.CommandManagement;
import org.eclipse.koneki.simulators.omadm.model.Node;
import org.eclipse.koneki.simulators.omadm.model.NodeFormat;
import org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorFactory;

public class NodeHelpers {

	/**
	 * Checks if the node name is valid.
	 * 
	 * @param node
	 *            the node to check
	 * @return true if the node name is valid, else false
	 */
	public static boolean isValidNodeName(final Node node) {
		if (node != null) {
			if (node.isRoot()) {
				return isValidRootNodeName(node.getName());
			} else if (node.isInterior()) {
				return isValidInteriorNodeName(node.getName());
			} else if (node.isLeaf()) {
				return isValidLeafNodeName(node.getName());
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	
	
	private static boolean isValidRootNodeName(final String nodeName) {
		return nodeName != null && nodeName.matches("^.$");
	}

	private static boolean isValidInteriorNodeName(final String nodeName) {
		return nodeName != null && nodeName.matches("^[a-zA-Z0-9\\-_]+$");
	}

	private static boolean isValidLeafNodeName(final String nodeName) {
		return isValidInteriorNodeName(nodeName);
	}

	/**
	 * Checks if the node format is valid.
	 * 
	 * @param node
	 *            the node to check
	 * @return true if the node format is valid, else false
	 */
	public static boolean isValidNodeFormat(final Node node) {
		if (node != null) {
			if (node.isRoot() || node.isInterior()) {
				return node.getFormat() == NodeFormat.NODE;
			} else if (node.isLeaf()) {
				return node.getFormat() != NodeFormat.NODE;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	/**
	 * Checks if the node type is valid.
	 * 
	 * @param node
	 *            the node to check
	 * @return true if the node type is valid, else false
	 */
	public static boolean isValidNodeType(final Node node) {
		if (node != null) {
			if (node.isRoot()) {
				return isValidRootNodeType(node.getType());
			} else if (node.isInterior()) {
				return isValidInteriorNodeType(node.getType());
			} else if (node.isLeaf()) {
				return isValidLeafNodeType(node.getType());
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	private static boolean isValidRootNodeType(final String nodeType) {
		// OMA Device Management Tree and Description and RFC 2141
		final String nid = "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,31}";
		final String nss = "([a-zA-Z0-9()+,-.:=@;$_!*'%/?#]|%[0-9a-fA-F]{2})+";
		final String urn = "urn:" + nid + ":" + nss;

		// OMA Device Management Tree and Description
		final String reversedDomain = "[^.]+(\\.[^.]+)*/[1-9][0-9]*\\.(0|[1-9][0-9]*)(/[a-zA-Z0-9]+)+";

		final String uri = "^(" + urn + "|" + reversedDomain + ")?$";
		return nodeType != null && nodeType.matches(uri) && !nodeType.startsWith("urn:urn:");
	}

	private static boolean isValidInteriorNodeType(final String nodeType) {
		return isValidRootNodeType(nodeType);
	}

	private static boolean isValidLeafNodeType(final String nodeType) {
		// OMA Device Management Tree and Description and RFC 2045
		final String token = "[\\p{ASCII}&&[^\\p{Space}\\p{Cntrl}()<>@,;:\\\\\"/\\[\\]?=]]+";
		final String qtext = "[\\p{ASCII}&&[^\"\\r\\n\\\\]]";
		final String quotedPair = "\\\\\\p{ASCII}";
		final String quotedString = "\"(" + qtext + "|" + quotedPair + ")*\"";
		final String type = token;
		final String subtype = token;
		final String parameter = token + "=" + "(" + token + "|" + quotedString + ")";
		return nodeType != null && nodeType.matches("^" + type + "/" + subtype + "(\\s*;\\s*" + parameter + ")*$");
	}

	/**
	 * Checks if the node data is valid.
	 * 
	 * @param node
	 *            the node to check
	 * @return true if the node data is valid, else false
	 */
	public static boolean isValidNodeData(final Node node) {
		if (node != null) {
			switch (node.getFormat()) {
			case BIN:
				return isValidBinNodeData(node.getData());
			case BOOL:
				return isValidBoolNodeData(node.getData());
			case B64:
				return isValidB64NodeData(node.getData());
			case CHR:
				return isValidChrNodeData(node.getData());
			case INT:
				return isValidIntNodeData(node.getData());
			case NODE:
				return isValidNodeNodeData(node.getData());
			case NULL:
				return isValidNullNodeData(node.getData());
			case XML:
				return isValidXmlNodeData(node.getData());
			case DATE:
				return isValidDateNodeData(node.getData());
			case TIME:
				return isValidTimeNodeData(node.getData());
			case FLOAT:
				return isValidFloatNodeData(node.getData());
			default:
				return true;
			}
		} else {
			return false;
		}
	}

	private static boolean isValidBinNodeData(final String nodeData) {
		return nodeData != null; // FIXME: Improve this predicate.
	}

	private static boolean isValidBoolNodeData(final String nodeData) {
		return nodeData != null && nodeData.matches("true|false");
	}

	private static boolean isValidB64NodeData(final String nodeData) {
		return nodeData != null; // FIXME: Improve this predicate.
	}

	private static boolean isValidChrNodeData(final String nodeData) {
		return nodeData != null;
	}

	private static boolean isValidIntNodeData(final String nodeData) {
		return nodeData != null && nodeData.matches("[+-]?([1-9][0-9]*|0)");
	}

	private static boolean isValidNodeNodeData(final String nodeData) {
		return nodeData != null && nodeData.equals("");
	}

	private static boolean isValidNullNodeData(final String nodeData) {
		return nodeData != null && nodeData.equals("");
	}

	private static boolean isValidXmlNodeData(final String nodeData) {
		return nodeData != null; // FIXME: Improve this predicate.
	}

	private static boolean isValidDateNodeData(final String nodeData) {
		return nodeData != null; // FIXME: Improve this predicate with ISO 8601.
	}

	private static boolean isValidTimeNodeData(final String nodeData) {
		return nodeData != null; // FIXME: Improve this predicate with ISO 8601.
	}

	private static boolean isValidFloatNodeData(final String nodeData) {
		return nodeData != null; // FIXME: Improve this predicate with 32 bit floating point type as defined in XML Schema 1.0.
	}

	/**
	 * Checks if the node data is valid.
	 * 
	 * @param node
	 *            the node to check
	 * @return true if the node data is valid, else false
	 */
	public static boolean isValidNodeManagement(final Node node) {
		if (node != null) {
			if (node.isRoot()) {
				return node.getGetManagement() != CommandManagement.INHERITED && node.getAddManagement() != CommandManagement.INHERITED
						&& node.getDeleteManagement() != CommandManagement.INHERITED && node.getCopyManagement() != CommandManagement.INHERITED
						&& node.getReplaceManagement() != CommandManagement.INHERITED && node.getExecManagement() != CommandManagement.INHERITED;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	/**
	 * Checks if the node respect the authorization to have children.
	 * 
	 * @param node
	 *            the node to check
	 * @return true if the node respect the authorization to have children, else false
	 */
	public static boolean isRespectAuthorizationChildren(final Node node) {
		if (node != null) {
			assert (node.getChildren() != null);
			return node.isRoot() || node.isInterior() || node.getChildren().size() == 0;
		} else {
			return false;
		}
	}

	/**
	 * Checks if the type of children is valid.
	 * 
	 * @param node
	 *            the node to check
	 * @return true if the type of children is valid, else false
	 */
	public static boolean isValidChildrenType(final Node node) {
		if (node != null) {
			assert (node.getChildren() != null);
			if (!node.isLeaf()) {
				for (final Node child : node.getChildren()) {
					if (child.isRoot()) {
						return false;
					}
				}
				return true;
			} else {
				return node.getChildren().size() == 0;
			}
		} else {
			return false;
		}
	}

	/**
	 * Checks if the name of children is unique.
	 * 
	 * @param node
	 *            the node to check
	 * @return true if the name of children is unique, else false
	 */
	public static boolean isUniqueChildrenName(final Node node) {
		if (node != null) {
			assert (node.getChildren() != null);
			if (!node.isLeaf()) {
				final EList<Node> children = node.getChildren();
				final int nbChilds = children.size();
				for (int i = 0, iMax = nbChilds - 1; i < iMax; ++i) {
					final String nodeNameI = children.get(i).getName();
					if (nodeNameI == null) {
						continue;
					}
					for (int j = i + 1, jMax = nbChilds; j < jMax; ++j) {
						final String nodeNameJ = children.get(j).getName();
						if (nodeNameJ != null && nodeNameI.equals(nodeNameJ)) {
							return false;
						}
					}
				}
				return true;
			} else {
				return node.getChildren().size() == 0;
			}
		} else {
			return false;
		}
	}

	/**
	 * Checks if can add children to the node.
	 * 
	 * @param node
	 *            the node to check
	 * @return true if can add children to the node, else false
	 */
	public static boolean canAddChildren(final Node node) {
		if (node != null) {
			return node.getFormat() == NodeFormat.NODE;
		} else {
			return false;
		}
	}

	public static boolean canDeleteNode(final Node node) {

		String[] notAllowedNode = { ".", "DevInfo", "DevId", "DwV", "Man", "Mod", "Lang", "DevDetail", "FwV", "SwV", "lrgObj", "DMAcc", "AppAuth",
				"ServerID", "AppID", "AuthType", "AuthData", "AuthName", "AuthSecret" };

		if (node == null)
			return false;

		for (String name : notAllowedNode) {
			if (name.equals(node.getName())) {
				return false;
			}
		}
		return true;
	}

	private static String getHead(final String path) {
		final int slashIndex = path.indexOf('/');
		return slashIndex != -1 ? path.substring(0, slashIndex) : path;
	}

	private static String getQueue(final String path) {
		final int slashIndex = path.indexOf('/');
		return slashIndex != -1 ? path.substring(slashIndex + 1, path.length()) : null;
	}

	/**
	 * Each node have to set his management configuration. By default, it's the inherited configuration
	 * 
	 * @param node
	 *            : a {@link Node} with no management configuration
	 * @return the node with the inherited configuration
	 */
	private static Node initInheritedNode(Node node) {

		node.setGetManagement(CommandManagement.INHERITED);
		node.setGetCode(StatusCode.OK.getCode());
		node.setAddManagement(CommandManagement.INHERITED);
		node.setAddCode(StatusCode.OK.getCode());
		node.setDeleteManagement(CommandManagement.INHERITED);
		node.setDeleteCode(StatusCode.OK.getCode());
		node.setCopyManagement(CommandManagement.INHERITED);
		node.setCopyCode(StatusCode.OK.getCode());
		node.setReplaceManagement(CommandManagement.INHERITED);
		node.setReplaceCode(StatusCode.OK.getCode());
		node.setExecManagement(CommandManagement.INHERITED);
		node.setExecCode(StatusCode.OPTIONAL_FEATURE_NOT_SUPPORTED.getCode());

		return node;
	}

	public static Node initLeaf(final String name, final String type, final String data, final NodeFormat format, final Node parentNode) {
		Node newLeaf = OMADMSimulatorFactory.eINSTANCE.createNode();

		newLeaf.setName(name);
		newLeaf.setType(type);
		newLeaf.setData(data);
		newLeaf.setFormat(format);
		newLeaf.setParent(parentNode);

		initInheritedNode(newLeaf);

		return newLeaf;
	}

	public static Node initTree() {
		Node root = NodeHelpers.initRoot();

		Node devInfoNode = NodeHelpers.initNode("DevInfo", root);
		NodeHelpers.initLeaf("DevId", "text/plain", "", NodeFormat.CHR, devInfoNode);
		NodeHelpers.initLeaf("DwV", "text/plain", "", NodeFormat.CHR, devInfoNode);
		NodeHelpers.initLeaf("Man", "text/plain", "", NodeFormat.CHR, devInfoNode);
		NodeHelpers.initLeaf("Mod", "text/plain", "", NodeFormat.CHR, devInfoNode);
		NodeHelpers.initLeaf("Lang", "text/plain", "", NodeFormat.CHR, devInfoNode);

		Node devDetailNode = NodeHelpers.initNode("DevDetail", root);
		NodeHelpers.initLeaf("FwV", "text/plain", "", NodeFormat.CHR, devDetailNode);
		NodeHelpers.initLeaf("SwV", "text/plain", "", NodeFormat.CHR, devDetailNode);
		NodeHelpers.initLeaf("HwV", "text/plain", "", NodeFormat.CHR, devDetailNode);
		NodeHelpers.initLeaf("OEM", "text/plain", "", NodeFormat.CHR, devDetailNode);
		NodeHelpers.initLeaf("lrgObj", "text/plain", "false", NodeFormat.BOOL, devDetailNode);
		NodeHelpers.initLeaf("DevTyp", "text/plain", "", NodeFormat.CHR, devDetailNode);

		Node URINode = NodeHelpers.initNode("URI", devDetailNode);
		NodeHelpers.initLeaf("MaxTotLen", "text/plain", "", NodeFormat.CHR, URINode);
		NodeHelpers.initLeaf("MaxSegLen", "text/plain", "false", NodeFormat.BOOL, URINode);
		NodeHelpers.initLeaf("MaxDepth", "text/plain", "", NodeFormat.CHR, URINode);

		Node DMAccNode = NodeHelpers.initNode("DMAcc", root);
		NodeHelpers.initLeaf("ServerID", "text/plain", "", NodeFormat.CHR, DMAccNode);
		NodeHelpers.initLeaf("AppID", "text/plain", "", NodeFormat.CHR, DMAccNode);

		Node AppAuthNode = NodeHelpers.initNode("AppAuth", DMAccNode);
		Node DefaultAuthNode = NodeHelpers.initNode("Default", AppAuthNode);
		NodeHelpers.initLeaf("AuthType", "text/plain", "", NodeFormat.CHR, DefaultAuthNode);
		NodeHelpers.initLeaf("AuthData", "text/plain", "", NodeFormat.CHR, DefaultAuthNode);
		NodeHelpers.initLeaf("AuthName", "text/plain", "", NodeFormat.CHR, DefaultAuthNode);
		NodeHelpers.initLeaf("AuthSecret", "text/plain", "", NodeFormat.CHR, DefaultAuthNode);

		Node AppAddrNode = NodeHelpers.initNode("AppAddr", DMAccNode);
		Node DefaultAddrNode = NodeHelpers.initNode("Default", AppAddrNode);
		NodeHelpers.initLeaf("AddrType", "text/plain", "", NodeFormat.CHR, DefaultAddrNode);
		NodeHelpers.initLeaf("Addr", "text/plain", "", NodeFormat.CHR, DefaultAddrNode);

		Node PortNode = NodeHelpers.initNode("Port", DefaultAddrNode);
		Node DefaultPortNode = NodeHelpers.initNode("Default", PortNode);
		NodeHelpers.initLeaf("PortNbr", "text/plain", "80", NodeFormat.INT, DefaultPortNode);

		return root;
	}

	public static Node initRoot() {
		Node root = OMADMSimulatorFactory.eINSTANCE.createNode();
		root.setParent(null);
		root.setName(".");
		root.setFormat(NodeFormat.NODE);
		root.setType("");
		root.setData("");
		root.setReplaceManagement(CommandManagement.AUTOMATIC);
		root.setReplaceCode(StatusCode.OK.getCode());
		root.setAddManagement(CommandManagement.AUTOMATIC);
		root.setAddCode(StatusCode.OK.getCode());
		root.setExecManagement(CommandManagement.AUTOMATIC);
		root.setExecCode(StatusCode.OPTIONAL_FEATURE_NOT_SUPPORTED.getCode());
		root.setCopyManagement(CommandManagement.AUTOMATIC);
		root.setCopyCode(StatusCode.OK.getCode());
		root.setGetManagement(CommandManagement.AUTOMATIC);
		root.setGetCode(StatusCode.OK.getCode());
		root.setDeleteManagement(CommandManagement.AUTOMATIC);
		root.setDeleteCode(StatusCode.OK.getCode());

		return root;
	}

	public static Node initNode(final String name, final Node parentNode) {
		Node newNode = OMADMSimulatorFactory.eINSTANCE.createNode();

		newNode.setName(name);
		newNode.setFormat(NodeFormat.NODE);
		newNode.setParent(parentNode);
		newNode.setData("");
		newNode.setType("");

		initInheritedNode(newNode);

		return newNode;
	}

	public static Node findFirstNode(final Node node, final String nodeName) {
		if (node != null) {
			if (!nodeName.equals(node.getName())) {
				for (Node n : node.getChildren()) {
					Node search = findFirstNode(n, nodeName);
					if (search != null)
						return search;
				}
				return null;
			}
			return node;
		}
		return null;
	}

	public static Node getNode(final Node tree, final String path) {
		final String queue = getQueue(path);
		if (queue != null) {
			final String head = getHead(queue);
			for (final Node child : tree.getChildren()) {
				if (child.getName().equals(head)) {
					return getNode(child, queue);
				}
			}
			return null;
		} else {
			return tree;
		}
	}

	public static Node getExistAncestorNode(final Node tree, final String path) {
		final String queue = getQueue(path);
		if (queue != null) {
			final String head = getHead(queue);
			for (final Node child : tree.getChildren()) {
				if (child.getName().equals(head)) {
					return getExistAncestorNode(child, queue);
				}
			}
			return tree;
		} else {
			return tree;
		}
	}

	public static String[] getChildrenNames(final String parentPath, final String path) {
		return path.substring(parentPath.length() + 1, path.length()).split("/");
	}

	public interface NodeIterator {

		void currentNode(final Node node);

	}

	public static final void iterate(final Node tree, final NodeIterator nodeIterator) {
		assert (tree != null);
		nodeIterator.currentNode(tree);
		for (final Node child : tree.getChildren()) {
			iterate(child, nodeIterator);
		}
	}

}
