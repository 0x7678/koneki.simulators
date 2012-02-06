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
package org.eclipse.koneki.simulators.omadm;

import java.net.URI;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.koneki.protocols.omadm.CommandHandler;
import org.eclipse.koneki.protocols.omadm.DMGenericAlert;
import org.eclipse.koneki.protocols.omadm.ProtocolListener;
import org.eclipse.koneki.simulators.omadm.model.Node;

/**
 * Interface of a DM simulator.
 */
public interface DMSimulator {

	/**
	 * Simulate the given tree with commands received from the server.
	 * 
	 * @param server
	 *            the DM server
	 * @param tree
	 *            the tree to simulate
	 * @param editingDomain
	 *            the editing domain for modify the tree
	 * @param commandHandler
	 *            the command handler for node with is in manual management mode
	 * @throws NullPointerException
	 *             if {@code server}, {@code tree}, {@code editingDomain} or {@code commandHandler} are {@code null}
	 */
	void simulate(final URI server, final Node tree, final EditingDomain editingDomain, final CommandHandler commandHandler);

	/**
	 * Simulate the given tree with commands received from the server.
	 * 
	 * @param server
	 *            the DM server
	 * @param tree
	 *            the tree to simulate
	 * @param editingDomain
	 *            the editing domain for modify the tree
	 * @param commandHandler
	 *            the command handler for node with is in manual management mode
	 * @param protocolListeners
	 *            objects want listen protocol event
	 * @throws NullPointerException
	 *             if {@code server}, {@code tree}, {@code editingDomain}, {@code commandHandler} or {@code protocolListeners} are {@code null}
	 */
	void simulate(final URI server, final Node tree, final EditingDomain editingDomain, final CommandHandler commandHandler,
			final ProtocolListener[] protocolListeners);

	/**
	 * Simulate the given tree with commands received from the server.
	 * 
	 * @param server
	 *            the DM server
	 * @param tree
	 *            the tree to simulate
	 * @param editingDomain
	 *            the editing domain for modify the tree
	 * @param commandHandler
	 *            the command handler for node with is in manual management mode
	 * @param genericAlerts
	 *            generic alerts must be send to server at the beginning of the DM session
	 * @throws NullPointerException
	 *             if {@code server}, {@code tree}, {@code editingDomain}, {@code commandHandler} or {@code genericAlerts} are {@code null}
	 */
	void simulate(final URI server, final Node tree, final EditingDomain editingDomain, final CommandHandler commandHandler,
			final DMGenericAlert[] genericAlerts);

	/**
	 * Simulate the given tree with commands received from the server.
	 * 
	 * @param server
	 *            the DM server
	 * @param tree
	 *            the tree to simulate
	 * @param editingDomain
	 *            the editing domain for modify the tree
	 * @param commandHandler
	 *            the command handler for node with is in manual management mode
	 * @param protocolListeners
	 *            objects want listen protocol event
	 * @param genericAlerts
	 *            generic alerts must be send to server at the beginning of the DM session
	 * @throws NullPointerException
	 *             if {@code server}, {@code tree}, {@code editingDomain}, {@code commandHandler}, {@code protocolListeners} or {@code genericAlerts}
	 *             are {@code null}
	 */
	void simulate(final URI server, final Node tree, final EditingDomain editingDomain, final CommandHandler commandHandler,
			final ProtocolListener[] protocolListeners, final DMGenericAlert[] genericAlerts);

}
