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

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.koneki.protocols.omadm.Status;
import org.eclipse.koneki.simulators.omadm.model.Node;


public interface DMExecHandler {

	Status exec(final Node nodeToExec, final EditingDomain editingDomain, final String correlator, final String format, final String type,
			final String data);

	String getManagementObjectIdentifierSupported();

	String[] getNodePathsSupported();

	boolean requireUserInteraction();

}
