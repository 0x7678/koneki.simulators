/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.koneki.simulators.omadm.model.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.koneki.simulators.omadm.model.AuthenticationType;
import org.eclipse.koneki.simulators.omadm.model.Device;
import org.eclipse.koneki.simulators.omadm.model.DeviceIdType;
import org.eclipse.koneki.simulators.omadm.model.Node;
import org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorFactory;
import org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Device</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.Device#getDeviceId() <em>Device Id</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.Device#getLogin() <em>Login</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.Device#getPassword() <em>Password</em>}</li>
 * <li>{@link org.eclipse.koneki.simulators.omadm.model.Device#getServerUrl() <em>Server Url</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DeviceTest extends TestCase {

	class ComplexMap<T0, T1, T2> extends HashMap<T0, HashMap<T1, T2>> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 8859090664972443041L;

		public ComplexMap() {
			super();
		}

		public void put(final T0 data0, final T1 data1, final T2 data2) {
			HashMap<T1, T2> data = new HashMap<T1, T2>();
			data.put(data1, data2);
			super.put(data0, data);
		}

		public T2 getT2(final T0 data0) {
			T2 data = null;

			for (Map.Entry<T0, HashMap<T1, T2>> entry : super.entrySet()) {

				if (entry.getKey().equals(data0)) {
					data = entry.getValue().get(getT1(data0));
				}
			}

			return data;
		}

		public T1 getT1(final T0 data0) {
			T1 data = null;

			for (Map.Entry<T0, HashMap<T1, T2>> entry : super.entrySet()) {

				if (entry.getKey().equals(data0)) {
					data = entry.getValue().keySet().iterator().next();
				}
			}

			return data;
		}
	}

	/**
	 * The fixture for this Device test case. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Device fixture = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DeviceTest.class);
	}

	/**
	 * Constructs a new Device test case with the given name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DeviceTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Device test case. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void setFixture(Device fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Device test case. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Device getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(OMADMSimulatorFactory.eINSTANCE.createDevice());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	private void initDevice() {
		try {
			setUp();
		} catch (Exception e) {
		}
		Node root = NodeHelpers.initTree();
		getFixture().setTree(root);
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Device#getDeviceId() <em>Device Id</em>}' feature getter. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Device#getDeviceId()
	 * @generated NOT
	 */
	public void testGetDeviceId() {
		initDevice();
		Node tmp;

		Map<String, DeviceIdType> tests = new HashMap<String, DeviceIdType>();
		tests.put("FREE:MyDevice", DeviceIdType.FREE);
		tests.put("MAC_ADDRESS:MyDevice", DeviceIdType.MAC_ADDRESS);
		tests.put("IMEI:MyDevice", DeviceIdType.IMEI);
		tests.put("WHAT_YOU_WANT:MyDevice", DeviceIdType.FREE);
		tests.put("", DeviceIdType.FREE);
		tests.put("FREE:", DeviceIdType.FREE);
		tests.put("WHAT_YOU_WANT:", DeviceIdType.FREE);
		tests.put("IMEI:", DeviceIdType.IMEI);
		tests.put("MAC_ADDRESS:", DeviceIdType.MAC_ADDRESS);
		tests.put("anything", DeviceIdType.FREE);

		for (Map.Entry<String, DeviceIdType> t : tests.entrySet()) {
			tmp = NodeHelpers.getNode(getFixture().getTree(), "./DevInfo/DevId");
			tmp.setData(t.getKey());
			assertEquals(t.getKey(), getFixture().getDeviceId());
			assertEquals(t.getValue(), getFixture().getDeviceIdType());
		}
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Device#setDeviceId(java.lang.String) <em>Device Id</em>}' feature setter. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Device#setDeviceId(java.lang.String)
	 * @generated NOT
	 */
	public void testSetDeviceId() {
		initDevice();

		Map<String, DeviceIdType> tests = new HashMap<String, DeviceIdType>();
		tests.put("FREE:MyDevice", DeviceIdType.FREE);
		tests.put("MAC_ADDRESS:MyDevice", DeviceIdType.MAC_ADDRESS);
		tests.put("WHAT_YOU_WANT:MyDevice", DeviceIdType.FREE);
		tests.put("WHAT_YOU_WANT:", DeviceIdType.FREE);
		tests.put("", DeviceIdType.FREE);
		tests.put("FREE:", DeviceIdType.FREE);
		tests.put("IMEI:", DeviceIdType.IMEI);
		tests.put("MAC_ADDRESS:", DeviceIdType.MAC_ADDRESS);
		tests.put("FREE:MyDevice", DeviceIdType.FREE);
		tests.put("anything", DeviceIdType.FREE);

		for (Map.Entry<String, DeviceIdType> t : tests.entrySet()) {
			getFixture().setDeviceId(t.getKey());
			assertEquals(t.getValue(), getFixture().getDeviceIdType());
			assertEquals(t.getKey(), getFixture().getDeviceId());
			assertEquals(t.getKey(), NodeHelpers.getNode(getFixture().getTree(), "./DevInfo/DevId").getData());
		}
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Device#getAuthentication() <em>Login</em>}' feature getter. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Device#getAuthentication()
	 * @generated NOT
	 */
	public void testGetAuthentication() {
		initDevice();
		Node testedNode = NodeHelpers.findFirstNode(NodeHelpers.getNode(getFixture().getTree(), "./DMAcc"), "AuthPref");

		for (AuthenticationType auth : AuthenticationType.values()) {
			testedNode.setData(auth.getName());
			assertEquals(auth, getFixture().getAuthentication());
		}

		Map<String, AuthenticationType> tests = new HashMap<String, AuthenticationType>();
		tests.put("Foo", AuthenticationType.BASIC);
		tests.put("", AuthenticationType.BASIC);

		for (Map.Entry<String, AuthenticationType> t : tests.entrySet()) {
			testedNode.setData(t.getKey());
			assertEquals(t.getValue(), getFixture().getAuthentication());
		}
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Device#getLogin() <em>Login</em>}' feature getter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Device#getLogin()
	 * @generated NOT
	 */
	public void testGetLogin() {
		initDevice();
		Node testedNode = NodeHelpers.findFirstNode(NodeHelpers.getNode(getFixture().getTree(), "./DMAcc/AppAuth"), "AuthName");

		Map<String, String> tests = new HashMap<String, String>();
		tests.put("MyLogin", "MyLogin");
		tests.put("", "");

		for (Map.Entry<String, String> t : tests.entrySet()) {
			testedNode.setData(t.getKey());
			assertEquals(t.getValue(), getFixture().getLogin());
		}
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Device#setLogin(java.lang.String) <em>Login</em>}' feature setter. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Device#setLogin(java.lang.String)
	 * @generated NOT
	 */
	public void testSetLogin() {

		initDevice();

		List<String> tests = new ArrayList<String>();
		tests.add("MyLogin");
		tests.add("");

		for (String t : tests) {
			getFixture().setLogin(t);
			assertEquals(t, getFixture().getLogin());
			assertEquals(t, NodeHelpers.findFirstNode(NodeHelpers.getNode(getFixture().getTree(), "./DMAcc/AppAuth"), "AuthName").getData());
		}
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Device#getPassword() <em>Password</em>}' feature getter. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Device#getPassword()
	 * @generated NOT
	 */
	public void testGetPassword() {
		initDevice();
		Node testedNode = NodeHelpers.findFirstNode(NodeHelpers.getNode(getFixture().getTree(), "./DMAcc/AppAuth"), "AuthSecret");

		Map<String, String> tests = new HashMap<String, String>();
		tests.put("MyPassword", "MyPassword");
		tests.put("", "");

		for (Map.Entry<String, String> t : tests.entrySet()) {
			testedNode.setData(t.getKey());
			assertEquals(t.getValue(), getFixture().getPassword());
		}
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Device#setAuthentication(Authentication) <em>Password</em>}' feature setter. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Device#setAuthentication(Authentication)
	 * @generated NOT
	 */
	public void testSetAuthentication() {

		initDevice();

		for (AuthenticationType auth : AuthenticationType.values()) {
			getFixture().setAuthentication(auth);
			assertEquals(auth.getName(), getFixture().getAuthentication().getName());
			assertEquals(auth.getName(), NodeHelpers.findFirstNode(NodeHelpers.getNode(getFixture().getTree(), "./DMAcc"), "AuthPref").getData());
		}
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Device#setPassword(java.lang.String) <em>Password</em>}' feature setter. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Device#setPassword(java.lang.String)
	 * @generated NOT
	 */
	public void testSetPassword() {

		initDevice();

		List<String> tests = new ArrayList<String>();
		tests.add("MyPassword");
		tests.add("");

		for (String t : tests) {
			getFixture().setPassword(t);
			assertEquals(t, getFixture().getPassword());
			assertEquals(t, NodeHelpers.findFirstNode(NodeHelpers.getNode(getFixture().getTree(), "./DMAcc/AppAuth"), "AuthSecret").getData());
		}
	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Device#getServerUrl() <em>Server Url</em>}' feature getter. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Device#getServerUrl()
	 * @generated NOT
	 */
	public void testGetServerUrl() {

		initDevice();
		Node tmp;

		ComplexMap<String, String, String> tests = new ComplexMap<String, String, String>();
		tests.put("http://localhost:8080/funambol/dm", "http://localhost/funambol/dm", "8080");
		tests.put("http://localhost/funambol/dm", "http://localhost/funambol/dm", "80");
		tests.put("http://localhost", "http://localhost", "80");
		tests.put("http://localhost:8956", "http://localhost", "8956");
		tests.put("https://localhost", "https://localhost", "80");
		tests.put("", "", "80");

		for (Map.Entry<String, ?> t : tests.entrySet()) {
			tmp = NodeHelpers.findFirstNode(NodeHelpers.getNode(getFixture().getTree(), "./DMAcc/AppAddr"), "Addr");
			tmp.setData(t.getKey());
			assertEquals(t.getKey(), getFixture().getServerUrl());
			tmp = NodeHelpers.findFirstNode(NodeHelpers.getNode(getFixture().getTree(), "./DMAcc/AppAddr"), "AddrType");
			assertEquals(tests.getT1(t.getKey()), tmp.getData());
			tmp = NodeHelpers.findFirstNode(NodeHelpers.findFirstNode(NodeHelpers.getNode(getFixture().getTree(), "./DMAcc/AppAddr"), "Port"),
					"PortNbr");
			assertEquals(tests.getT2(t.getKey()), tmp.getData());
		}

		tests = new ComplexMap<String, String, String>();
		tests.put("htqdfsdqtp://localhost/funambol/dm", "", "80");

		for (Map.Entry<String, ?> t : tests.entrySet()) {
			tmp = NodeHelpers.findFirstNode(NodeHelpers.getNode(getFixture().getTree(), "./DMAcc/AppAddr"), "Addr");
			tmp.setData(t.getKey());
			assertEquals(tests.getT1(t.getKey()), getFixture().getServerUrl());
			tmp = NodeHelpers.findFirstNode(NodeHelpers.getNode(getFixture().getTree(), "./DMAcc/AppAddr"), "AddrType");
			assertEquals(tests.getT1(t.getKey()), tmp.getData());
			tmp = NodeHelpers.findFirstNode(NodeHelpers.findFirstNode(NodeHelpers.getNode(getFixture().getTree(), "./DMAcc/AppAddr"), "Port"),
					"PortNbr");
			assertEquals(tests.getT2(t.getKey()), tmp.getData());
		}

	}

	/**
	 * Tests the '{@link org.eclipse.koneki.simulators.omadm.model.Device#setServerUrl(java.lang.String) <em>Server Url</em>}' feature setter. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.koneki.simulators.omadm.model.Device#setServerUrl(java.lang.String)
	 * @generated NOT
	 */
	public void testSetServerUrl() {
		initDevice();

		ComplexMap<String, String, String> tests = new ComplexMap<String, String, String>();
		tests.put("http://localhost:8080/funambol/dm", "http://localhost/funambol/dm", "8080");
		tests.put("http://localhost/funambol/dm", "http://localhost/funambol/dm", "80");
		tests.put("http://localhost:8089", "http://localhost", "8089");
		tests.put("", "", "80");

		for (Map.Entry<String, ?> t : tests.entrySet()) {
			getFixture().setServerUrl(t.getKey());
			assertEquals(t.getKey(), NodeHelpers.findFirstNode(NodeHelpers.getNode(getFixture().getTree(), "./DMAcc/AppAddr"), "Addr").getData());
			assertEquals(tests.getT1(t.getKey()),
					NodeHelpers.findFirstNode(NodeHelpers.getNode(getFixture().getTree(), "./DMAcc/AppAddr"), "AddrType").getData());
			assertEquals(
					tests.getT2(t.getKey()),
					NodeHelpers.findFirstNode(NodeHelpers.findFirstNode(NodeHelpers.getNode(getFixture().getTree(), "./DMAcc/AppAddr"), "Port"),
							"PortNbr").getData());
		}

		tests = new ComplexMap<String, String, String>();
		tests.put("htqdfsdqtp://localhost/funambol/dm", "", "80");

		for (Map.Entry<String, ?> t : tests.entrySet()) {
			getFixture().setServerUrl(t.getKey());
			assertEquals(tests.getT1(t.getKey()), NodeHelpers.findFirstNode(NodeHelpers.getNode(getFixture().getTree(), "./DMAcc/AppAddr"), "Addr")
					.getData());
			assertEquals(tests.getT1(t.getKey()),
					NodeHelpers.findFirstNode(NodeHelpers.getNode(getFixture().getTree(), "./DMAcc/AppAddr"), "AddrType").getData());
			assertEquals(
					tests.getT2(t.getKey()),
					NodeHelpers.findFirstNode(NodeHelpers.findFirstNode(NodeHelpers.getNode(getFixture().getTree(), "./DMAcc/AppAddr"), "Port"),
							"PortNbr").getData());
		}
	}
}
