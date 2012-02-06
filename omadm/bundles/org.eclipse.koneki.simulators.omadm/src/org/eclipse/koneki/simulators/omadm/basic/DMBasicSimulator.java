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
package org.eclipse.koneki.simulators.omadm.basic;

import java.net.URI;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.koneki.protocols.omadm.CommandHandler;
import org.eclipse.koneki.protocols.omadm.DMGenericAlert;
import org.eclipse.koneki.protocols.omadm.ProtocolListener;
import org.eclipse.koneki.protocols.omadm.Status;
import org.eclipse.koneki.protocols.omadm.StatusCode;
import org.eclipse.koneki.protocols.omadm.client.DMClient;
import org.eclipse.koneki.simulators.omadm.DMSimulator;
import org.eclipse.koneki.simulators.omadm.model.Node;

/**
 * A basic thread safe DM simulator.
 */
public class DMBasicSimulator implements DMSimulator {

	public DMBasicSimulator(final DMClient dmClient) {
		if (dmClient != null) {
			this.dmClient = dmClient;
			this.executorService = Executors.newSingleThreadExecutor();
			this.moiPathKeyToExecHandler = new HashMap<DMBasicSimulator.MOIPathKey, PriorityQueue<DMExecHandler>>();
			this.pathKeyToExecHandler = new HashMap<String, PriorityQueue<DMExecHandler>>();
		} else {
			throw new NullPointerException();
		}
	}

	public synchronized void addExecHandler(final DMExecHandler execHandler) {
		for (final String nodePath : execHandler.getNodePathsSupported()) {
			final MOIPathKey key = new MOIPathKey(execHandler.getManagementObjectIdentifierSupported(), nodePath);
			if (this.moiPathKeyToExecHandler.containsKey(key)) {
				this.moiPathKeyToExecHandler.get(key).add(execHandler);
			} else {
				final PriorityQueue<DMExecHandler> execHandlers = new PriorityQueue<DMExecHandler>(1, new Comparator<DMExecHandler>() {

					@Override
					public int compare(final DMExecHandler lhs, final DMExecHandler rhs) {
						if (lhs.requireUserInteraction()) {
							return rhs.requireUserInteraction() ? 0 : 1;
						} else {
							return rhs.requireUserInteraction() ? -1 : 0;
						}
					}

				});
				execHandlers.add(execHandler);
				this.moiPathKeyToExecHandler.put(key, execHandlers);
			}
			if (this.pathKeyToExecHandler.containsKey(nodePath)) {
				this.pathKeyToExecHandler.get(nodePath).add(execHandler);
			} else {
				final PriorityQueue<DMExecHandler> execHandlers = new PriorityQueue<DMExecHandler>(1, new Comparator<DMExecHandler>() {

					@Override
					public int compare(final DMExecHandler lhs, final DMExecHandler rhs) {
						if (lhs.requireUserInteraction()) {
							return rhs.requireUserInteraction() ? 0 : 1;
						} else {
							return rhs.requireUserInteraction() ? -1 : 0;
						}
					}

				});
				execHandlers.add(execHandler);
				this.pathKeyToExecHandler.put(nodePath, execHandlers);
			}
		}
	}

	public synchronized void removeExecHandler(final DMExecHandler execHandler) {
		for (final String nodePath : execHandler.getNodePathsSupported()) {
			{
				final MOIPathKey key = new MOIPathKey(execHandler.getManagementObjectIdentifierSupported(), nodePath);
				final PriorityQueue<DMExecHandler> exechandlers = this.moiPathKeyToExecHandler.get(key);
				if (exechandlers.remove(execHandler) && exechandlers.isEmpty()) {
					this.moiPathKeyToExecHandler.remove(key);
				}
			}
			{
				final PriorityQueue<DMExecHandler> exechandlers = this.pathKeyToExecHandler.get(nodePath);
				if (exechandlers.remove(execHandler) && exechandlers.isEmpty()) {
					this.moiPathKeyToExecHandler.remove(nodePath);
				}
			}
		}
	}

	final synchronized Status exec(final Node nodeToExec, final EditingDomain editingDomain, final String correlator, final String format,
			final String type, final String data, final boolean mustRequireUserInteration) {
		final StringBuffer sb = new StringBuffer();
		Node it = nodeToExec;
		while (it != null) {
			if (!it.getType().isEmpty()) {
				final String nodePath = "." + sb.toString(); //$NON-NLS-1$
				final PriorityQueue<DMExecHandler> execHandlers = this.moiPathKeyToExecHandler.get(new MOIPathKey(it.getType(), nodePath));
				if (execHandlers != null) {
					for (final DMExecHandler execHandler : execHandlers) {
						if (!mustRequireUserInteration || execHandler.requireUserInteraction()) {
							final Status status = execHandler.exec(nodeToExec, editingDomain, correlator, format, type, data);
							if (status != null) {
								return status;
							}
						}
					}
				}
			}
			sb.insert(0, "/" + it.getName()); //$NON-NLS-1$
			it = it.getParent();
		}
		sb.setLength(0);
		it = nodeToExec;
		while (it != null) {
			final String nodePath = "." + sb.toString(); //$NON-NLS-1$
			final PriorityQueue<DMExecHandler> execHandlers = this.pathKeyToExecHandler.get(nodePath);
			if (execHandlers != null) {
				for (final DMExecHandler execHandler : execHandlers) {
					if (!mustRequireUserInteration || execHandler.requireUserInteraction()) {
						final Status status = execHandler.exec(nodeToExec, editingDomain, correlator, format, type, data);
						if (status != null) {
							return status;
						}
					}
				}
			}
			sb.insert(0, "/" + it.getName()); //$NON-NLS-1$
			it = it.getParent();
		}
		return StatusCode.OPTIONAL_FEATURE_NOT_SUPPORTED;
	}

	@Override
	public void simulate(final URI server, final Node tree, final EditingDomain editingDomain, final CommandHandler commandHandler) {
		simulate(server, tree, editingDomain, commandHandler, new ProtocolListener[] {}, new DMGenericAlert[] {});
	}

	@Override
	public void simulate(final URI server, final Node tree, final EditingDomain editingDomain, final CommandHandler commandHandler,
			final ProtocolListener[] protocolListeners) {
		simulate(server, tree, editingDomain, commandHandler, protocolListeners, new DMGenericAlert[] {});
	}

	@Override
	public void simulate(final URI server, final Node tree, final EditingDomain editingDomain, final CommandHandler commandHandler,
			final DMGenericAlert[] genericAlerts) {
		simulate(server, tree, editingDomain, commandHandler, new ProtocolListener[] {}, genericAlerts);
	}

	@Override
	public void simulate(final URI server, final Node tree, final EditingDomain editingDomain, final CommandHandler commandHandler,
			final ProtocolListener[] protocolListeners, final DMGenericAlert[] genericAlerts) {
		if (server == null || tree == null || editingDomain == null || commandHandler == null || protocolListeners == null || genericAlerts == null) {
			throw new NullPointerException();
		}
		this.executorService.execute(new DMBasicSimulation(this, server, tree, editingDomain, commandHandler, protocolListeners, genericAlerts));
	}

	final DMClient getDMClient() {
		return this.dmClient;
	}

	private final DMClient dmClient;
	private final ExecutorService executorService;
	private final Map<MOIPathKey, PriorityQueue<DMExecHandler>> moiPathKeyToExecHandler;
	private final Map<String, PriorityQueue<DMExecHandler>> pathKeyToExecHandler;

	private static final class MOIPathKey {

		public MOIPathKey(final String managementObjectIdentifier, final String nodePath) {
			this.managementObjectIdentifier = managementObjectIdentifier;
			this.nodePath = nodePath;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + this.managementObjectIdentifier.hashCode();
			result = prime * result + this.nodePath.hashCode();
			return result;
		}

		@Override
		public boolean equals(final Object obj) {
			if (this == obj) {
				return true;
			} else if (obj != null && obj instanceof MOIPathKey) {
				final MOIPathKey other = (MOIPathKey) obj;
				return this.managementObjectIdentifier.equals(other.managementObjectIdentifier) && this.nodePath.equals(other.nodePath);
			} else {
				return false;
			}
		}

		private final String managementObjectIdentifier;
		private final String nodePath;

	}

}
