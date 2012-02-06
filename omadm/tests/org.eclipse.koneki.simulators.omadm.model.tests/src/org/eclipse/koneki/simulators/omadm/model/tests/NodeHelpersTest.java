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
import static org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers.canAddChildren;
import static org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers.canDeleteNode;
import static org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers.isRespectAuthorizationChildren;
import static org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers.isUniqueChildrenName;
import static org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers.isValidNodeData;
import static org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers.isValidNodeManagement;
import static org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers.isValidNodeName;
import static org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers.isValidNodeType;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.koneki.simulators.omadm.model.CommandManagement;
import org.eclipse.koneki.simulators.omadm.model.Node;
import org.eclipse.koneki.simulators.omadm.model.NodeFormat;
import org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorFactory;
import org.junit.Test;


public class NodeHelpersTest {

	@Test
	public void testIsValidNodeName() {
		assertFalse(isValidNodeName(null));
		// Tuple: nodeName, expectedRoot, expectedInterior, expectedLeaf
		final Object[][] testDatas = { { null, false, false, false }, { "", false, false, false }, { ".", true, false, false },
				{ "DevInf", false, true, true }, { "toto", false, true, true }, { "_-_", false, true, true }, { "12dzzAd90982", false, true, true },
				{ "   account", false, false, false }, { "account   ", false, false, false }, { "acc   ou  nt", false, false, false }, };
		for (final Object[] testData : testDatas) {
			final String nodeName = (String) testData[0];
			final Node rootNode = createRoot();
			rootNode.setName(nodeName);
			assertEquals(rootNode.getName(), ((Boolean) testData[1]).booleanValue(), isValidNodeName(rootNode));
			final Node interiorNode = createInterior();
			interiorNode.setName(nodeName);
			assertEquals(interiorNode.getName(), ((Boolean) testData[2]).booleanValue(), isValidNodeName(interiorNode));
			final Node leafNode = createLeaf();
			leafNode.setName(nodeName);
			assertEquals(leafNode.getName(), ((Boolean) testData[3]).booleanValue(), isValidNodeName(leafNode));
		}
	}

	@Test
	public void testIsValidNodeType() {
		assertFalse(isValidNodeType(null));
		// Tuple: nodeType, expectedRoot, expectedInterior, expectedLeaf
		final Object[][] testDatas = { { null, false, false, false }, { "", true, true, false }, { " ", false, false, false },
				{ "  ", false, false, false }, { "text/plain", false, false, true }, { "text/plain; charset=us-ascii", false, false, true },
				{ "text/plain; charset=us-ascii; charset=UTF8", false, false, true }, { "application/xhtml+xml", false, false, true },
				{ "urn:oma:mo:oma-fumo:1.0", true, true, false }, { "urn:oma:mo:oma-imps:1.0", true, true, false },
				{ "urn:urn:mo:oma-imps:1.0", false, false, false }, { "urn:oma:mo:oma-imps:1.0  ", false, false, false },
				{ " urn:oma:mo:oma-imps:1.0", false, false, false }, { " urn:oma:  mo:oma-im  ps:1.0", false, false, false },
				{ "se.yyy.dm/2.10/Profile/Class1", true, true, false }, { "se.yyy.dm/2.10/Profile/Class1  ", false, false, false },
				{ "   se.yyy.dm/2.10/Profile/Class1  ", false, false, false }, { "se.yyy.dm/2.  10/rofile/Cl  ass1", false, false, false }, };
		for (final Object[] testData : testDatas) {
			final String nodeType = (String) testData[0];
			final Node rootNode = createRoot();
			rootNode.setType(nodeType);
			assertEquals(rootNode.getType(), ((Boolean) testData[1]).booleanValue(), isValidNodeType(rootNode));
			final Node interiorNode = createInterior();
			interiorNode.setType(nodeType);
			assertEquals(interiorNode.getType(), ((Boolean) testData[2]).booleanValue(), isValidNodeType(interiorNode));
			final Node leafNode = createLeaf();
			leafNode.setType(nodeType);
			assertEquals(leafNode.getType(), ((Boolean) testData[3]).booleanValue(), isValidNodeType(leafNode));
		}
	}

	@Test
	public void testIsValidNodeData() {
		assertFalse(isValidNodeData(null));
		// Tuple: nodeData, BOOL, CHR, INT, NODE, NULL
		final Object[][] testDatas = { { null, false, false, false, false, false }, { "", false, true, false, true, true },
				{ "  ", false, true, false, false, false }, { "true", true, true, false, false, false },
				{ "false", true, true, false, false, false }, { "toto", false, true, false, false, false },
				{ "to  t  o", false, true, false, false, false }, { "toto  ", false, true, false, false, false },
				{ "   toto", false, true, false, false, false }, { "0", false, true, true, false, false }, { "1", false, true, true, false, false },
				{ "+1", false, true, true, false, false }, { "-1", false, true, true, false, false }, { "019553", false, true, false, false, false },
				{ "19553", false, true, true, false, false }, { "  19553", false, true, false, false, false },
				{ "19553   ", false, true, false, false, false }, { "19  5 53", false, true, false, false, false }, };
		final Node node = OMADMSimulatorFactory.eINSTANCE.createNode();
		for (final Object[] testData : testDatas) {
			node.setData((String) testData[0]);

			node.setFormat(NodeFormat.BOOL);
			assertEquals(node.getData(), ((Boolean) testData[1]).booleanValue(), isValidNodeData(node));

			node.setFormat(NodeFormat.CHR);
			assertEquals(node.getData(), ((Boolean) testData[2]).booleanValue(), isValidNodeData(node));

			node.setFormat(NodeFormat.INT);
			assertEquals(node.getData(), ((Boolean) testData[3]).booleanValue(), isValidNodeData(node));

			node.setFormat(NodeFormat.NODE);
			assertEquals(node.getData(), ((Boolean) testData[4]).booleanValue(), isValidNodeData(node));

			node.setFormat(NodeFormat.NULL);
			assertEquals(node.getData(), ((Boolean) testData[5]).booleanValue(), isValidNodeData(node));
		}
	}

	@Test
	public void testIsValidNodeManagement() {
		assertFalse(isValidNodeManagement(null));
		// Tupe: nodeManagement, expectedRoot, expectedInterior, expectedLeaf
		final Object[][] testDatas = { { CommandManagement.INHERITED, false, true, true }, { CommandManagement.AUTOMATIC, true, true, true },
				{ CommandManagement.MANUAL, true, true, true }, { CommandManagement.MANUAL, true, true, true } };
		for (final Object[] testData : testDatas) {
			final CommandManagement nodeManagement = (CommandManagement) testData[0];
			final Node rootNode = createRoot();
			rootNode.setGetManagement(nodeManagement);
			rootNode.setAddManagement(nodeManagement);
			rootNode.setDeleteManagement(nodeManagement);
			rootNode.setCopyManagement(nodeManagement);
			rootNode.setReplaceManagement(nodeManagement);
			rootNode.setExecManagement(nodeManagement);
			assertEquals(nodeManagement.getLiteral(), ((Boolean) testData[1]).booleanValue(), isValidNodeManagement(rootNode));
			final Node interiorNode = createInterior();
			interiorNode.setGetManagement(nodeManagement);
			interiorNode.setAddManagement(nodeManagement);
			interiorNode.setDeleteManagement(nodeManagement);
			interiorNode.setCopyManagement(nodeManagement);
			interiorNode.setReplaceManagement(nodeManagement);
			interiorNode.setExecManagement(nodeManagement);
			assertEquals(nodeManagement.getLiteral(), ((Boolean) testData[2]).booleanValue(), isValidNodeManagement(interiorNode));
			final Node leafNode = createLeaf();
			leafNode.setGetManagement(nodeManagement);
			leafNode.setAddManagement(nodeManagement);
			leafNode.setDeleteManagement(nodeManagement);
			leafNode.setCopyManagement(nodeManagement);
			leafNode.setReplaceManagement(nodeManagement);
			leafNode.setExecManagement(nodeManagement);
			assertEquals(nodeManagement.getLiteral(), ((Boolean) testData[3]).booleanValue(), isValidNodeManagement(leafNode));
		}
	}

	@Test
	public void testIsRespectAuthorizationChildren() {
		assertFalse(isRespectAuthorizationChildren(null));
		// Tuple: children, expectedRoot, expectedInterior, expectedLeaf
		final Object[][] testDatas = { { Arrays.asList(), true, true, true },
				{ Arrays.asList(OMADMSimulatorFactory.eINSTANCE.createNode()), true, true, false },
				{ Arrays.asList(OMADMSimulatorFactory.eINSTANCE.createNode(), OMADMSimulatorFactory.eINSTANCE.createNode()), true, true, false }, };
		for (final Object[] testData : testDatas) {
			@SuppressWarnings("unchecked")
			final Collection<Node> nodeChildren = (Collection<Node>) testData[0];
			final Node rootNode = createRoot();
			rootNode.getChildren().addAll(nodeChildren);
			assertEquals(((Boolean) testData[1]).booleanValue(), isRespectAuthorizationChildren(rootNode));
			final Node interiorNode = createInterior();
			interiorNode.getChildren().addAll(nodeChildren);
			assertEquals(((Boolean) testData[2]).booleanValue(), isRespectAuthorizationChildren(interiorNode));
			final Node leafNode = createLeaf();
			leafNode.getChildren().addAll(nodeChildren);
			assertEquals(((Boolean) testData[3]).booleanValue(), isRespectAuthorizationChildren(leafNode));
		}
	}

	@Test
	public void testIsUniqueChildrenName() {
		assertFalse(isUniqueChildrenName(null));
		// Tuple: children, expectedRoot, expectedInterior, expectedLeaf
		final Node NULL_NAME = OMADMSimulatorFactory.eINSTANCE.createNode();
		NULL_NAME.setName(null);
		final Node EMPTY1_NAME = OMADMSimulatorFactory.eINSTANCE.createNode();
		EMPTY1_NAME.setName("");
		final Node EMPTY2_NAME = OMADMSimulatorFactory.eINSTANCE.createNode();
		EMPTY2_NAME.setName("");
		final Node A1_NODE = OMADMSimulatorFactory.eINSTANCE.createNode();
		A1_NODE.setName("A");
		final Node A2_NODE = OMADMSimulatorFactory.eINSTANCE.createNode();
		A2_NODE.setName("A");
		final Node B1_NODE = OMADMSimulatorFactory.eINSTANCE.createNode();
		B1_NODE.setName("B");
		final Node B2_NODE = OMADMSimulatorFactory.eINSTANCE.createNode();
		B2_NODE.setName("B");
		// Tuple: children, expectedRoot, expectedInterior, expectedLeaf
		final Object[][] testDatas = { { Arrays.asList(), true, true, true }, { Arrays.asList(NULL_NAME), true, true, false },
				{ Arrays.asList(NULL_NAME, NULL_NAME), true, true, false }, { Arrays.asList(EMPTY1_NAME), true, true, false },
				{ Arrays.asList(EMPTY1_NAME, EMPTY2_NAME), false, false, false }, { Arrays.asList(A1_NODE), true, true, false },
				{ Arrays.asList(A1_NODE, A2_NODE), false, false, false }, { Arrays.asList(A1_NODE, B1_NODE), true, true, false },
				{ Arrays.asList(A1_NODE, B1_NODE, A2_NODE), false, false, false },
				{ Arrays.asList(A1_NODE, B1_NODE, A2_NODE, B2_NODE), false, false, false }, };
		for (final Object[] testData : testDatas) {
			@SuppressWarnings("unchecked")
			final Collection<Node> nodeChildren = (Collection<Node>) testData[0];
			final Node rootNode = createRoot();
			rootNode.getChildren().addAll(nodeChildren);
			assertEquals(((Boolean) testData[1]).booleanValue(), isUniqueChildrenName(rootNode));
			final Node interiorNode = createInterior();
			interiorNode.getChildren().addAll(nodeChildren);
			assertEquals(((Boolean) testData[2]).booleanValue(), isUniqueChildrenName(interiorNode));
			final Node leafNode = createLeaf();
			leafNode.getChildren().addAll(nodeChildren);
			assertEquals(((Boolean) testData[3]).booleanValue(), isUniqueChildrenName(leafNode));
		}
	}

	@Test
	public void testCanAddChildren() {
		assertFalse(canAddChildren(null));
		for (final NodeFormat nodeFormat : NodeFormat.VALUES) {
			final Node node = OMADMSimulatorFactory.eINSTANCE.createNode();
			node.setFormat(nodeFormat);
			assertEquals(nodeFormat == NodeFormat.NODE, canAddChildren(node));
		}
	}

	@Test
	public void testCanDeleteNode() {
		assertFalse(canDeleteNode(null));
		final Node rootNode = createRoot();
		assertFalse(canDeleteNode(rootNode));
		final Node interiorNode = createInterior();
		assertTrue(canDeleteNode(interiorNode));
		final Node leafNode = createLeaf();
		assertTrue(canDeleteNode(leafNode));
	}

	private static Node createRoot() {
		final Node root = OMADMSimulatorFactory.eINSTANCE.createNode();
		root.setFormat(NodeFormat.NODE);
		assert (root.isRoot());
		assert (!root.isInterior());
		assert (!root.isLeaf());
		;
		return root;
	}

	private static Node createInterior() {
		final Node interior = OMADMSimulatorFactory.eINSTANCE.createNode();
		interior.setFormat(NodeFormat.NODE);
		final Node root = OMADMSimulatorFactory.eINSTANCE.createNode();
		root.setFormat(NodeFormat.NODE);
		root.getChildren().add(interior);
		assert (root.isRoot());
		assert (!root.isInterior());
		assert (!root.isLeaf());
		;
		assert (!interior.isRoot());
		assert (interior.isInterior());
		assert (!interior.isLeaf());
		return interior;
	}

	private static Node createLeaf() {
		final Node leaf = OMADMSimulatorFactory.eINSTANCE.createNode();
		leaf.setFormat(NodeFormat.CHR);
		final Node root = OMADMSimulatorFactory.eINSTANCE.createNode();
		root.setFormat(NodeFormat.NODE);
		root.getChildren().add(leaf);
		assert (root.isRoot());
		assert (!root.isInterior());
		assert (!root.isLeaf());
		;
		assert (!leaf.isRoot());
		assert (!leaf.isInterior());
		assert (leaf.isLeaf());
		return leaf;
	}

}
