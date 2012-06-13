/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.koneki.simulators.omadm.model.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.koneki.protocols.omadm.StatusCode;
import org.eclipse.koneki.simulators.omadm.model.CommandManagement;
import org.eclipse.koneki.simulators.omadm.model.Node;
import org.eclipse.koneki.simulators.omadm.model.NodeFormat;
import org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorFactory;
import org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Node</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getPath() <em>Get Path</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getRoot() <em>Get Root</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getRealGetManagement() <em>Get Real Get Management</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getRealAddManagement() <em>Get Real Add Management</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getRealDeleteManagement() <em>Get Real Delete Management</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getRealCopyManagement() <em>Get Real Copy Management</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getRealReplaceManagement() <em>Get Real Replace Management</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getRealExecManagement() <em>Get Real Exec Management</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getRealGetCode() <em>Get Real Get Code</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getRealAddCode() <em>Get Real Add Code</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getRealDeleteCode() <em>Get Real Delete Code</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getRealCopyCode() <em>Get Real Copy Code</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getRealReplaceCode() <em>Get Real Replace Code</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#getRealExecCode() <em>Get Real Exec Code</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#isRoot() <em>Is Root</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#isInterior() <em>Is Interior</em>}</li>
 *   <li>{@link org.eclipse.koneki.simulators.omadm.model.Node#isLeaf() <em>Is Leaf</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class NodeTest extends TestCase {

	private void initRoot() {
		try {
			setUp();
		} catch (Exception e) {
		}
		fixture = NodeHelpers.initRoot();
	}

	/**
	 * The fixture for this Node test case.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected Node fixture = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(NodeTest.class);
	}

	/**
	 * Constructs a new Node test case with the given name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NodeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Node test case.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Node fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Node test case.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected Node getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(OMADMSimulatorFactory.eINSTANCE.createNode());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getPath() <em>Get Path</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getPath()
	 * @generated NOT
	 */
	public void testGetPath() {
		initRoot();

		List<String> nodeNameList = new LinkedList<String>();
		nodeNameList.add("nodeA");
		nodeNameList.add("nodeB");
		nodeNameList.add("nodeC");
		nodeNameList.add("nodeD");
		nodeNameList.add("nodeE");
		nodeNameList.add("nodeF");
		nodeNameList.add("nodeG");
		Collections.shuffle(nodeNameList);

		Node currentNode = getFixture();
		Node tmp;
		String currentPath = ".";

		Map<String, Node> pathNodes = new HashMap<String, Node>();
		pathNodes.put(currentPath, currentNode);

		for (String s : nodeNameList) {
			tmp = OMADMSimulatorFactory.eINSTANCE.createNode();
			tmp.setName(s);
			tmp.setParent(currentNode);
			currentPath += "/" + s;
			currentNode = tmp;
			pathNodes.put(currentPath, currentNode);
		}

		for (Map.Entry<String, Node> t : pathNodes.entrySet()) {
			assertEquals(t.getKey(), t.getValue().getPath());
		}

		Node test = NodeHelpers.initNode("test", null);
		assertEquals("test", test.getPath());
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getRoot() <em>Get Root</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getRoot()
	 * @generated NOT
	 */
	public void testGetRoot() {

		initRoot();

		List<String> nodeNameList = new LinkedList<String>();
		nodeNameList.add("nodeA");
		nodeNameList.add("nodeB");
		nodeNameList.add("nodeC");
		nodeNameList.add("nodeD");
		nodeNameList.add("nodeE");
		nodeNameList.add("nodeF");
		nodeNameList.add("nodeG");
		Collections.shuffle(nodeNameList);

		Node tmp;
		Node currentNode = getFixture();

		List<Node> nodeList = new ArrayList<Node>();
		nodeList.add(currentNode);

		for (String s : nodeNameList) {
			tmp = OMADMSimulatorFactory.eINSTANCE.createNode();
			tmp.setName(s);
			tmp.setParent(currentNode);
			currentNode = tmp;
			nodeList.add(currentNode);
		}

		Collections.shuffle(nodeNameList);
		currentNode = getFixture();
		for (String s : nodeNameList) {
			tmp = OMADMSimulatorFactory.eINSTANCE.createNode();
			tmp.setName(s);
			tmp.setParent(currentNode);
			currentNode = tmp;
			nodeList.add(currentNode);
		}

		for (Node n : nodeList) {
			assertEquals(getFixture(), n.getRoot());
		}

		Node test = NodeHelpers.initNode("test", null);
		assertEquals(test, test.getRoot());
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getRealGetManagement() <em>Get Real Get Management</em>}' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getRealGetManagement()
	 * @generated NOT
	 */
	public void testGetRealGetManagement() {

		int maxValueManagement = CommandManagement.VALUES.size();
		int nbtestedNode = 100;

		Node tmp;

		Map<Node, CommandManagement> managementTable = new HashMap<Node, CommandManagement>();

		for (int i = 0; i < nbtestedNode; i++) {
			CommandManagement randManagement = CommandManagement.get((int) (Math.random() * maxValueManagement));
			tmp = OMADMSimulatorFactory.eINSTANCE.createNode();
			tmp.setGetManagement(randManagement);
			managementTable.put(tmp, randManagement);
		}

		for (Map.Entry<Node, CommandManagement> t : managementTable.entrySet()) {
			assertEquals(t.getKey().getGetManagement(), t.getValue());
		}
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getRealAddManagement() <em>Get Real Add Management</em>}' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getRealAddManagement()
	 * @generated NOT
	 */
	public void testGetRealAddManagement() {
		int maxValueManagement = CommandManagement.VALUES.size();
		int nbtestedNode = 100;

		Node tmp;

		Map<Node, CommandManagement> managementTable = new HashMap<Node, CommandManagement>();

		for (int i = 0; i < nbtestedNode; i++) {
			CommandManagement randManagement = CommandManagement.get((int) (Math.random() * maxValueManagement));
			tmp = OMADMSimulatorFactory.eINSTANCE.createNode();
			tmp.setAddManagement(randManagement);
			managementTable.put(tmp, randManagement);
		}

		for (Map.Entry<Node, CommandManagement> t : managementTable.entrySet()) {
			assertEquals(t.getKey().getAddManagement(), t.getValue());
		}
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getRealDeleteManagement() <em>Get Real Delete Management</em>}' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getRealDeleteManagement()
	 * @generated NOT
	 */
	public void testGetRealDeleteManagement() {
		int maxValueManagement = CommandManagement.VALUES.size();
		int nbtestedNode = 100;

		Node tmp;

		Map<Node, CommandManagement> managementTable = new HashMap<Node, CommandManagement>();

		for (int i = 0; i < nbtestedNode; i++) {
			CommandManagement randManagement = CommandManagement.get((int) (Math.random() * maxValueManagement));
			tmp = OMADMSimulatorFactory.eINSTANCE.createNode();
			tmp.setDeleteManagement(randManagement);
			managementTable.put(tmp, randManagement);
		}

		for (Map.Entry<Node, CommandManagement> t : managementTable.entrySet()) {
			assertEquals(t.getKey().getDeleteManagement(), t.getValue());
		}
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getRealCopyManagement() <em>Get Real Copy Management</em>}' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getRealCopyManagement()
	 * @generated NOT
	 */
	public void testGetRealCopyManagement() {
		int maxValueManagement = CommandManagement.VALUES.size();
		int nbtestedNode = 100;

		Node tmp;

		Map<Node, CommandManagement> managementTable = new HashMap<Node, CommandManagement>();

		for (int i = 0; i < nbtestedNode; i++) {
			CommandManagement randManagement = CommandManagement.get((int) (Math.random() * maxValueManagement));
			tmp = OMADMSimulatorFactory.eINSTANCE.createNode();
			tmp.setCopyManagement(randManagement);
			managementTable.put(tmp, randManagement);
		}

		for (Map.Entry<Node, CommandManagement> t : managementTable.entrySet()) {
			assertEquals(t.getKey().getCopyManagement(), t.getValue());
		}
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getRealReplaceManagement() <em>Get Real Replace Management</em>}' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getRealReplaceManagement()
	 * @generated NOT
	 */
	public void testGetRealReplaceManagement() {
		int maxValueManagement = CommandManagement.VALUES.size();
		int nbtestedNode = 100;

		Node tmp;

		Map<Node, CommandManagement> managementTable = new HashMap<Node, CommandManagement>();

		for (int i = 0; i < nbtestedNode; i++) {
			CommandManagement randManagement = CommandManagement.get((int) (Math.random() * maxValueManagement));
			tmp = OMADMSimulatorFactory.eINSTANCE.createNode();
			tmp.setReplaceManagement(randManagement);
			managementTable.put(tmp, randManagement);
		}

		for (Map.Entry<Node, CommandManagement> t : managementTable.entrySet()) {
			assertEquals(t.getKey().getReplaceManagement(), t.getValue());
		}
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getRealExecManagement() <em>Get Real Exec Management</em>}' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getRealExecManagement()
	 * @generated NOT
	 */
	public void testGetRealExecManagement() {
		int maxValueManagement = CommandManagement.VALUES.size();
		int nbtestedNode = 100;

		Node tmp;

		Map<Node, CommandManagement> managementTable = new HashMap<Node, CommandManagement>();

		for (int i = 0; i < nbtestedNode; i++) {
			CommandManagement randManagement = CommandManagement.get((int) (Math.random() * maxValueManagement));
			tmp = OMADMSimulatorFactory.eINSTANCE.createNode();
			tmp.setExecManagement(randManagement);
			managementTable.put(tmp, randManagement);
		}

		for (Map.Entry<Node, CommandManagement> t : managementTable.entrySet()) {
			assertEquals(t.getKey().getExecManagement(), t.getValue());
		}
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getRealGetCode() <em>Get Real Get Code</em>}' operation. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getRealGetCode()
	 * @generated NOT
	 */
	public void testGetRealGetCode() {

		StatusCode[] statusList = StatusCode.values();
		CommandManagement[] commandsList = CommandManagement.values();

		Node tmp;
		Node parent;

		Map<Node, Integer> managementTable = new HashMap<Node, Integer>();

		for (int i = 0; i < commandsList.length; i++) {
			for (int j = 0; j < statusList.length; j++) {
				tmp = OMADMSimulatorFactory.eINSTANCE.createNode();
				tmp.setGetManagement(commandsList[i]);

				parent = OMADMSimulatorFactory.eINSTANCE.createNode();
				parent.setGetManagement(CommandManagement.CONSTANT);

				if (commandsList[i].equals(CommandManagement.INHERITED)) {
					parent.setGetCode(StatusCode.values()[j].getCode());
					try {
						tmp.setGetCode(StatusCode.values()[j + 1].getCode());
					} catch (Exception e) {
						tmp.setGetCode(StatusCode.values()[0].getCode());
					}
				} else {
					tmp.setGetCode(StatusCode.values()[j].getCode());
					try {
						parent.setGetCode(StatusCode.values()[j + 1].getCode());
					} catch (Exception e) {
						parent.setGetCode(StatusCode.values()[0].getCode());
					}
				}

				tmp.setParent(parent);
				managementTable.put(tmp, StatusCode.values()[j].getCode());
			}

			for (Map.Entry<Node, Integer> t : managementTable.entrySet()) {
				assertEquals(t.getKey().getRealGetCode(), (int) t.getValue());
			}
		}
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getRealAddCode() <em>Get Real Add Code</em>}' operation. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getRealAddCode()
	 * @generated NOT
	 */
	public void testGetRealAddCode() {

		StatusCode[] statusList = StatusCode.values();
		CommandManagement[] commandsList = CommandManagement.values();

		Node tmp;
		Node parent;

		Map<Node, Integer> managementTable = new HashMap<Node, Integer>();

		for (int i = 0; i < commandsList.length; i++) {
			for (int j = 0; j < statusList.length; j++) {
				tmp = OMADMSimulatorFactory.eINSTANCE.createNode();
				tmp.setAddManagement(commandsList[i]);

				parent = OMADMSimulatorFactory.eINSTANCE.createNode();
				parent.setAddManagement(CommandManagement.CONSTANT);

				if (commandsList[i].equals(CommandManagement.INHERITED)) {
					parent.setAddCode(StatusCode.values()[j].getCode());
					try {
						tmp.setAddCode(StatusCode.values()[j + 1].getCode());
					} catch (Exception e) {
						tmp.setAddCode(StatusCode.values()[0].getCode());
					}
				} else {
					tmp.setAddCode(StatusCode.values()[j].getCode());
					try {
						parent.setAddCode(StatusCode.values()[j + 1].getCode());
					} catch (Exception e) {
						parent.setAddCode(StatusCode.values()[0].getCode());
					}
				}

				tmp.setParent(parent);
				managementTable.put(tmp, StatusCode.values()[j].getCode());
			}

			for (Map.Entry<Node, Integer> t : managementTable.entrySet()) {
				assertEquals(t.getKey().getRealAddCode(), (int) t.getValue());
			}
		}
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getRealDeleteCode() <em>Get Real Delete Code</em>}' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getRealDeleteCode()
	 * @generated NOT
	 */
	public void testGetRealDeleteCode() {

		StatusCode[] statusList = StatusCode.values();
		CommandManagement[] commandsList = CommandManagement.values();

		Node tmp;
		Node parent;

		Map<Node, Integer> managementTable = new HashMap<Node, Integer>();

		for (int i = 0; i < commandsList.length; i++) {
			for (int j = 0; j < statusList.length; j++) {
				tmp = OMADMSimulatorFactory.eINSTANCE.createNode();
				tmp.setDeleteManagement(commandsList[i]);

				parent = OMADMSimulatorFactory.eINSTANCE.createNode();
				parent.setDeleteManagement(CommandManagement.CONSTANT);

				if (commandsList[i].equals(CommandManagement.INHERITED)) {
					parent.setDeleteCode(StatusCode.values()[j].getCode());
					try {
						tmp.setDeleteCode(StatusCode.values()[j + 1].getCode());
					} catch (Exception e) {
						tmp.setDeleteCode(StatusCode.values()[0].getCode());
					}
				} else {
					tmp.setDeleteCode(StatusCode.values()[j].getCode());
					try {
						parent.setDeleteCode(StatusCode.values()[j + 1].getCode());
					} catch (Exception e) {
						parent.setDeleteCode(StatusCode.values()[0].getCode());
					}
				}

				tmp.setParent(parent);
				managementTable.put(tmp, StatusCode.values()[j].getCode());
			}

			for (Map.Entry<Node, Integer> t : managementTable.entrySet()) {
				assertEquals(t.getKey().getRealDeleteCode(), (int) t.getValue());
			}
		}
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getRealCopyCode() <em>Get Real Copy Code</em>}' operation. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getRealCopyCode()
	 * @generated NOT
	 */
	public void testGetRealCopyCode() {

		StatusCode[] statusList = StatusCode.values();
		CommandManagement[] commandsList = CommandManagement.values();

		Node tmp;
		Node parent;

		Map<Node, Integer> managementTable = new HashMap<Node, Integer>();

		for (int i = 0; i < commandsList.length; i++) {
			for (int j = 0; j < statusList.length; j++) {
				tmp = OMADMSimulatorFactory.eINSTANCE.createNode();
				tmp.setCopyManagement(commandsList[i]);

				parent = OMADMSimulatorFactory.eINSTANCE.createNode();
				parent.setCopyManagement(CommandManagement.CONSTANT);

				if (commandsList[i].equals(CommandManagement.INHERITED)) {
					parent.setCopyCode(StatusCode.values()[j].getCode());
					try {
						tmp.setCopyCode(StatusCode.values()[j + 1].getCode());
					} catch (Exception e) {
						tmp.setCopyCode(StatusCode.values()[0].getCode());
					}
				} else {
					tmp.setCopyCode(StatusCode.values()[j].getCode());
					try {
						parent.setCopyCode(StatusCode.values()[j + 1].getCode());
					} catch (Exception e) {
						parent.setCopyCode(StatusCode.values()[0].getCode());
					}
				}

				tmp.setParent(parent);
				managementTable.put(tmp, StatusCode.values()[j].getCode());
			}

			for (Map.Entry<Node, Integer> t : managementTable.entrySet()) {
				assertEquals(t.getKey().getRealCopyCode(), (int) t.getValue());
			}
		}
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getRealReplaceCode() <em>Get Real Replace Code</em>}' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getRealReplaceCode()
	 * @generated NOT
	 */
	public void testGetRealReplaceCode() {

		StatusCode[] statusList = StatusCode.values();
		CommandManagement[] commandsList = CommandManagement.values();

		Node tmp;
		Node parent;

		Map<Node, Integer> managementTable = new HashMap<Node, Integer>();

		for (int i = 0; i < commandsList.length; i++) {
			for (int j = 0; j < statusList.length; j++) {
				tmp = OMADMSimulatorFactory.eINSTANCE.createNode();
				tmp.setReplaceManagement(commandsList[i]);

				parent = OMADMSimulatorFactory.eINSTANCE.createNode();
				parent.setReplaceManagement(CommandManagement.CONSTANT);

				if (commandsList[i].equals(CommandManagement.INHERITED)) {
					parent.setReplaceCode(StatusCode.values()[j].getCode());
					try {
						tmp.setReplaceCode(StatusCode.values()[j + 1].getCode());
					} catch (Exception e) {
						tmp.setReplaceCode(StatusCode.values()[0].getCode());
					}
				} else {
					tmp.setReplaceCode(StatusCode.values()[j].getCode());
					try {
						parent.setReplaceCode(StatusCode.values()[j + 1].getCode());
					} catch (Exception e) {
						parent.setReplaceCode(StatusCode.values()[0].getCode());
					}
				}

				tmp.setParent(parent);
				managementTable.put(tmp, StatusCode.values()[j].getCode());
			}

			for (Map.Entry<Node, Integer> t : managementTable.entrySet()) {
				assertEquals(t.getKey().getRealReplaceCode(), (int) t.getValue());
			}
		}
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Node#getRealExecCode() <em>Get Real Exec Code</em>}' operation. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#getRealExecCode()
	 * @generated NOT
	 */
	public void testGetRealExecCode() {

		StatusCode[] statusList = StatusCode.values();
		CommandManagement[] commandsList = CommandManagement.values();

		Node tmp;
		Node parent;

		Map<Node, Integer> managementTable = new HashMap<Node, Integer>();

		for (int i = 0; i < commandsList.length; i++) {
			for (int j = 0; j < statusList.length; j++) {
				tmp = OMADMSimulatorFactory.eINSTANCE.createNode();
				tmp.setExecManagement(commandsList[i]);

				parent = OMADMSimulatorFactory.eINSTANCE.createNode();
				parent.setExecManagement(CommandManagement.CONSTANT);

				if (commandsList[i].equals(CommandManagement.INHERITED)) {
					parent.setExecCode(StatusCode.values()[j].getCode());
					try {
						tmp.setExecCode(StatusCode.values()[j + 1].getCode());
					} catch (Exception e) {
						tmp.setExecCode(StatusCode.values()[0].getCode());
					}
				} else {
					tmp.setExecCode(StatusCode.values()[j].getCode());
					try {
						parent.setExecCode(StatusCode.values()[j + 1].getCode());
					} catch (Exception e) {
						parent.setExecCode(StatusCode.values()[0].getCode());
					}
				}

				tmp.setParent(parent);
				managementTable.put(tmp, StatusCode.values()[j].getCode());
			}

			for (Map.Entry<Node, Integer> t : managementTable.entrySet()) {
				assertEquals(t.getKey().getRealExecCode(), (int) t.getValue());
			}
		}
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Node#isRoot() <em>Is Root</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#isRoot()
	 * @generated NOT
	 */
	public void testIsRoot() {

		Node root = NodeHelpers.initRoot();
		Node child = NodeHelpers.initNode("test", root);

		Map<Node, Boolean> tests = new HashMap<Node, Boolean>();

		tests.put(root, true);
		tests.put(child, false);
		tests.put(NodeHelpers.initLeaf("name", "type", "data", NodeFormat.CHR, child), false);

		for (Map.Entry<Node, Boolean> t : tests.entrySet()) {
			assertEquals(t.getValue(), (Boolean) t.getKey().isRoot());
		}
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Node#isInterior() <em>Is Interior</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#isInterior()
	 * @generated NOT
	 */
	public void testIsInterior() {
		Node root = NodeHelpers.initRoot();
		Node child = NodeHelpers.initNode("test", root);

		Map<Node, Boolean> tests = new HashMap<Node, Boolean>();

		tests.put(root, false);
		tests.put(child, true);
		tests.put(NodeHelpers.initLeaf("name", "type", "data", NodeFormat.CHR, child), false);

		for (Map.Entry<Node, Boolean> t : tests.entrySet()) {
			assertEquals(t.getValue(), (Boolean) t.getKey().isInterior());
		}
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Node#isLeaf() <em>Is Leaf</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Node#isLeaf()
	 * @generated NOT
	 */
	public void testIsLeaf() {
		Node root = NodeHelpers.initRoot();
		Node child = NodeHelpers.initNode("test", root);

		Map<Node, Boolean> tests = new HashMap<Node, Boolean>();

		tests.put(root, false);
		tests.put(child, false);
		tests.put(NodeHelpers.initLeaf("name", "type", "data", NodeFormat.CHR, child), true);

		for (Map.Entry<Node, Boolean> t : tests.entrySet()) {
			assertEquals(t.getValue(), (Boolean) t.getKey().isLeaf());
		}
	}

} // NodeTest
