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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.koneki.protocols.omadm.DMGenericAlert;
import org.eclipse.koneki.protocols.omadm.ProtocolListener;
import org.eclipse.koneki.simulators.omadm.DMSimulator;
import org.eclipse.koneki.simulators.omadm.editor.Messages;
import org.eclipse.koneki.simulators.omadm.editor.OMADMSimulatorEditor;
import org.eclipse.koneki.simulators.omadm.editor.internal.Activator;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.osgi.framework.ServiceException;

class ConnectSelection extends SelectionAdapter {

	private final OMADMSimulatorEditor editor;
	private final DashboardPage page;
	private URI server;
	private boolean isFirst;

	public ConnectSelection(OMADMSimulatorEditor editor, DashboardPage page) {
		this.page = page;
		this.editor = editor;
		updateServerURI(editor);
		isFirst = true;
	}

	@Override
	public synchronized void widgetSelected(SelectionEvent ev) {
		page.getConnectIcon().setEnabled(false);
		final Job wakeupJob = new Job(Messages.DashBoardPage_ManagementSection_ConnectButton) {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					return ConnectSelection.this.run(monitor);
				} catch (ServiceException e) {
					return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "An error has occurred.", e);
				}
			}

		};
		wakeupJob.setUser(isFirst);
		wakeupJob.schedule();
		isFirst = false;
	}

	private synchronized IStatus run(IProgressMonitor monitor) throws ServiceException {
		monitor.beginTask("Wakeup", IProgressMonitor.UNKNOWN); //$NON-NLS-1$

		// Server
		if (server == null) {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Your OMA DM Server URL is not set.");
		}

		// Simulator
		final DMSimulator dmSimulator = Activator.getDefault().getDMSimulator();
		if (dmSimulator == null) {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "No " + DMSimulator.class.getSimpleName() + " are available.");
		} else if (monitor.isCanceled()) {
			return Status.CANCEL_STATUS;
		}

		// Generic alerts
		final List<DMGenericAlert> genericAlerts = new LinkedList<DMGenericAlert>();
		while (true) {
			final DMGenericAlert genericAlert = page.pollGenericAlert();
			if (genericAlert == null) {
				break;
			}
			genericAlerts.add(genericAlert);
		}

		// Get last version of the server
		updateServerURI(editor);

		// Connect
		dmSimulator.simulate(server, page.getEditor().getOMADMSimulation().getDevice().getTree(), page.getEditor().getOMADMSimulation().getDevice()
				.getAuthentication(), page.getEditor().getEditingDomain(), new ConnectCommandHandler(page),
				new ProtocolListener[] { new ConnectProtocolListener(page) }, genericAlerts.toArray(new DMGenericAlert[] {}));
		if (monitor.isCanceled()) {
			return Status.CANCEL_STATUS;
		} else {
			return Status.OK_STATUS;
		}
	}

	private void updateServerURI(OMADMSimulatorEditor e) {
		try {
			server = new URI(e.getOMADMSimulation().getDevice().getServerUrl());
		} catch (URISyntaxException e1) {
			server = null;
		}
	}

}
