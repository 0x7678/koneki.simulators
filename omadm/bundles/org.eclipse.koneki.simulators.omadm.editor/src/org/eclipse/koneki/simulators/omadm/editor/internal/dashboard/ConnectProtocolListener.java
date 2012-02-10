/*******************************************************************************
 * Copyright (c) 2012 Sierra Wireless and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sierra Wireless - initial API and implementation
 *******************************************************************************/
package org.eclipse.koneki.simulators.omadm.editor.internal.dashboard;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.koneki.protocols.omadm.DMItem;
import org.eclipse.koneki.protocols.omadm.DMNode;
import org.eclipse.koneki.protocols.omadm.ProtocolListener;
import org.eclipse.koneki.protocols.omadm.Status;
import org.eclipse.koneki.simulators.omadm.editor.internal.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TreeItem;

final class ConnectProtocolListener implements ProtocolListener {

	private final DashboardPage page;
	private TreeItem sessionCommandItem;
	private TreeItem sessionMessageItem;
	private TreeItem phaseMessageItem;
	private boolean isSetupPhase;
	private boolean isManagementPhase;

	public ConnectProtocolListener(final DashboardPage page) {
		this.page = page;
	}

	@Override
	public void sessionBegin(final String sessionID) {
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				ConnectProtocolListener.this.sessionCommandItem = new TreeItem(ConnectProtocolListener.this.page.getCommandsViewTree(), SWT.NONE);
				ConnectProtocolListener.this.sessionCommandItem.setText(new String[] { "Session " + sessionID, "", "" }); //$NON-NLS-2$ //$NON-NLS-3$
				ConnectProtocolListener.this.sessionCommandItem
						.setImage(new Image[] { Activator.getDefault().getImage(Activator.SESSION), null, null });
				ConnectProtocolListener.this.sessionMessageItem = new TreeItem(ConnectProtocolListener.this.page.getMessagesViewTree(), SWT.NONE);
				ConnectProtocolListener.this.sessionMessageItem.setText("Session " + sessionID);
				ConnectProtocolListener.this.sessionMessageItem.setImage(Activator.getDefault().getImage(Activator.SESSION));
			}

		});
	}

	@Override
	public void sessionEnd() {
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				ConnectProtocolListener.this.page.getConnectIcon().setEnabled(true);
			}

		});
	}

	@Override
	public void sessionEnd(final Throwable t) {
		sessionEnd();
		Activator.log(t);
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				MessageDialog.openWarning(ConnectProtocolListener.this.page.getEditor().getSite().getShell(), "Simulation", t.getMessage());
			}

		});
	}

	@Override
	public void setupPhaseBegin() {
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				ConnectProtocolListener.this.phaseMessageItem = new TreeItem(ConnectProtocolListener.this.sessionMessageItem, SWT.NONE);
				ConnectProtocolListener.this.phaseMessageItem.setText("Setup phase");
				ConnectProtocolListener.this.phaseMessageItem.setImage(Activator.getDefault().getImage(Activator.PHASE));
				expandIfNot(ConnectProtocolListener.this.sessionMessageItem);
			}

		});
		this.isSetupPhase = true;
	}

	@Override
	public void setupPhaseEnd() {
		this.isSetupPhase = false;
	}

	@Override
	public void managementPhaseBegin() {
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				ConnectProtocolListener.this.phaseMessageItem = new TreeItem(ConnectProtocolListener.this.sessionMessageItem, SWT.NONE);
				ConnectProtocolListener.this.phaseMessageItem.setText("Management phase");
				ConnectProtocolListener.this.phaseMessageItem.setImage(Activator.getDefault().getImage(Activator.PHASE));
				expandIfNot(ConnectProtocolListener.this.sessionMessageItem);
			}

		});
		this.isManagementPhase = true;
	}

	@Override
	public void managementPhaseEnd() {
		this.isManagementPhase = false;
	}

	@Override
	public void newClientPackage(final String message) {
		newPackage("Package " + getClientPackageNumber(), message, Activator.getDefault().getImage(Activator.CLIENT_PACKAGE));
	}

	@Override
	public void newServerPackage(final String message) {
		newPackage("Package " + getServerPackageNumber(), message, Activator.getDefault().getImage(Activator.SERVER_PACKAGE));
	}

	private void newPackage(final String text, final String message, final Image image) {
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				final TreeItem item = new TreeItem(ConnectProtocolListener.this.phaseMessageItem, SWT.NONE);
				item.setText(text);
				item.setData(prettyPrint(message));
				item.setImage(image);
				expandIfNot(ConnectProtocolListener.this.phaseMessageItem);
			}

		});
	}

	@Override
	public void clientAlert(final String alertCode, final String correlator, final DMItem[] items, final Status status) {
		final StringBuffer sb = new StringBuffer();
		sb.append("Alert - Code: ").append(alertCode);
		if (correlator != null) {
			sb.append(", Correlator: ").append(correlator);
		}
		if (alertCode.equals("1226")) {
			genericAlert(sb, items[0]);
		}
		clientCommand(sb.toString(), Activator.getDefault().getImage(Activator.ALERT_COMMAND), status);
	}

	private void genericAlert(final StringBuffer sb, final DMItem item) {
		sb.append(", Type: ").append(item.getMeta().getType()).append(", Result: ").append(item.getData());
	}

	@Override
	public void get(final String target, final Status status) {
		serverCommand("Get - Target: " + target, Activator.getDefault().getImage(Activator.GET_COMMAND), status);
	}

	@Override
	public void add(final String target, final String data, final Status status) {
		serverCommand("Add - Target: " + target + ", Data: " + data, Activator.getDefault().getImage(Activator.ADD_COMMAND), status);
	}

	@Override
	public void copy(final String target, final String source, final Status status) {
		serverCommand("Copy - Target: " + target + ", Source: " + source, Activator.getDefault().getImage(Activator.COPY_COMMAND), status);
	}

	@Override
	public void delete(final String target, final Status status) {
		serverCommand("Delete - Target: " + target, Activator.getDefault().getImage(Activator.DELETE_COMMAND), status);
	}

	@Override
	public void exec(final String target, final String correlator, final String data, final Status status) {
		final StringBuffer sb = new StringBuffer();
		sb.append("Exec - Target: ").append(target);
		if (correlator != null) {
			sb.append(", Correlator: ").append(correlator);
		}
		if (data != null) {
			sb.append(", Data: ").append(data);
		}
		serverCommand(sb.toString(), Activator.getDefault().getImage(Activator.EXEC_COMMAND), status);
	}

	@Override
	public void replace(final String target, final String data, final Status status) {
		serverCommand("Replace - Target: " + target + ", Data: " + data, Activator.getDefault().getImage(Activator.REPLACE_COMMAND), status);
	}

	private void clientCommand(final String commandText, final Image commandImage, final Status status) {
		command(getTextStatus(status), commandText, getImageStatus(status), commandImage);
	}

	private void serverCommand(final String commandText, final Image commandImage, final Status status) {
		command(commandText, getTextStatus(status), commandImage, getImageStatus(status));
	}

	private static String getTextStatus(final Status status) {
		final StringBuffer sb = new StringBuffer();
		sb.append("Status - Code: ").append(status.getCode()).append(" ").append(status.getDescription());
		final DMNode results = status.getResult();
		if (results != null) {
			sb.append(", Result: ").append(results.getData());
		}
		return sb.toString();
	}

	private static Image getImageStatus(final Status status) {
		return Activator.getDefault().getImage(status.getCode() < 300 ? Activator.STATUS_OK : Activator.STATUS_FAIL);
	}

	private void command(final String textCol1, final String textCol2, final Image imageCol1, final Image imageCol2) {
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {

				final TreeItem item = new TreeItem(ConnectProtocolListener.this.sessionCommandItem, SWT.NONE);
				item.setText(new String[] { null, textCol1, textCol2 });
				item.setImage(new Image[] { null, imageCol1, imageCol2 });
				expandIfNot(ConnectProtocolListener.this.sessionCommandItem);
			}

		});
	}

	private void expandIfNot(final TreeItem item) {
		if (!item.getExpanded()) {
			item.setExpanded(true);
		}
	}

	private String getClientPackageNumber() {
		if (this.isSetupPhase) {
			return "1";
		} else if (this.isManagementPhase) {
			return "3";
		} else {
			return null;
		}
	}

	private String getServerPackageNumber() {
		if (this.isSetupPhase) {
			return "2";
		} else if (this.isManagementPhase) {
			return "4";
		} else {
			return null;
		}
	}

	private static String prettyPrint(final String xml) {
		Source xmlInput = new StreamSource(new StringReader(xml));
		StreamResult xmlOutput = new StreamResult(new StringWriter());

		try {
			Transformer transformer;
			transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes"); //$NON-NLS-1$
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2"); //$NON-NLS-1$ //$NON-NLS-2$
			transformer.transform(xmlInput, xmlOutput);
			return xmlOutput.getWriter().toString();
		} catch (TransformerException ex) {
			// log the error and return the non-prettified XML document
			Activator.log(ex);
			return xml;
		}
	}

}
