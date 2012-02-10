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
package org.eclipse.koneki.simulators.omadm.internal;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.koneki.protocols.omadm.CommandHandler;
import org.eclipse.koneki.protocols.omadm.DMGenericAlert;
import org.eclipse.koneki.protocols.omadm.ProtocolListener;
import org.eclipse.koneki.protocols.omadm.client.DMClient;
import org.eclipse.koneki.simulators.omadm.DMSimulator;
import org.eclipse.koneki.simulators.omadm.basic.DMBasicSimulator;
import org.eclipse.koneki.simulators.omadm.basic.DMExecHandler;
import org.eclipse.koneki.simulators.omadm.model.Node;
import org.osgi.service.component.ComponentContext;

public class DMBasicSimulatorComponent implements DMSimulator {

	private DMBasicSimulator simulator;
	private final Set<DMExecHandler> execHandlers;

	public DMBasicSimulatorComponent() {
		this.execHandlers = new HashSet<DMExecHandler>();
	}

	protected void activate(final ComponentContext ctxt) {
		this.simulator = new DMBasicSimulator((DMClient) ctxt.locateService("DMClient")); //$NON-NLS-1$
		for (final DMExecHandler execHandler : this.execHandlers) {
			this.simulator.addExecHandler(execHandler);
		}
	}

	protected void deactivate(final ComponentContext ctxt) {
		for (final DMExecHandler execHandler : this.execHandlers) {
			this.simulator.removeExecHandler(execHandler);
		}
		this.simulator = null;
	}

	protected void bind(final DMExecHandler execHandler) {
		this.execHandlers.add(execHandler);
		if (this.simulator != null) {
			this.simulator.addExecHandler(execHandler);
		}
	}

	protected void unbind(final DMExecHandler execHandler) {
		this.execHandlers.remove(execHandler);
		if (this.simulator != null) {
			this.simulator.removeExecHandler(execHandler);
		}
	}

	public void simulate(final URI server, final Node tree, final EditingDomain editingDomain, final CommandHandler commandHandler) {
		this.simulator.simulate(server, tree, editingDomain, commandHandler);
	}

	public void simulate(final URI server, final Node tree, final EditingDomain editingDomain, final CommandHandler commandHandler,
			final ProtocolListener[] protocolLinsteners) {
		this.simulator.simulate(server, tree, editingDomain, commandHandler, protocolLinsteners);
	}

	public void simulate(final URI server, final Node tree, final EditingDomain editingDomain, final CommandHandler commandHandler,
			final DMGenericAlert[] genericAlerts) {
		this.simulator.simulate(server, tree, editingDomain, commandHandler, genericAlerts);
	}

	public void simulate(final URI server, final Node tree, final EditingDomain editingDomain, final CommandHandler commandHandler,
			final ProtocolListener[] protocolListeners, final DMGenericAlert[] genericAlerts) {
		this.simulator.simulate(server, tree, editingDomain, commandHandler, protocolListeners, genericAlerts);
	}

}
