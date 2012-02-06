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
package org.eclipse.koneki.simulators.omadm.fumo.automatic.internal;

import java.util.concurrent.Callable;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.koneki.protocols.omadm.DMGenericAlert;
import org.eclipse.koneki.protocols.omadm.DelayedProcessing;
import org.eclipse.koneki.protocols.omadm.Status;
import org.eclipse.koneki.protocols.omadm.StatusCode;
import org.eclipse.koneki.simulators.omadm.basic.DMExecHandler;
import org.eclipse.koneki.simulators.omadm.fumo.Fumo;
import org.eclipse.koneki.simulators.omadm.fumo.FumoResultCode;
import org.eclipse.koneki.simulators.omadm.model.Node;

public class DMFumoAutomaticExecHandler implements DMExecHandler {

	@Override
	public Status exec(final Node nodeToExec, final EditingDomain editingDomain, final String correlator, final String format, final String type,
			final String data) {
		if (nodeToExec.getName().equals(Fumo.DOWNLOAD_NODE_NAME) && nodeToExec.getParent().getType().equals(Fumo.OMI)) {
			return download(nodeToExec, editingDomain, correlator, format, type, data);
		} else if (nodeToExec.getName().equals(Fumo.UPDATE_NODE_NAME) && nodeToExec.getParent().getType().equals(Fumo.OMI)) {
			return update(nodeToExec, editingDomain, correlator, format, type, data);
		} else if (nodeToExec.getName().equals(Fumo.DOWNLOAD_AND_UPDATE_NODE_NAME) && nodeToExec.getParent().getType().equals(Fumo.OMI)) {
			return downloadAndUpdate(nodeToExec, editingDomain, correlator, format, type, data);
		} else {
			return null;
		}
	}

	private Status download(final Node nodeToExec, final EditingDomain editingDomain, final String correlator, final String format,
			final String type, final String data) {
		return new DelayedProcessing(StatusCode.ACCEPTED_FOR_PROCESSING, new Callable<DMGenericAlert>() {

			@Override
			public DMGenericAlert call() throws Exception {
				return new DMGenericAlert(Fumo.TYPE_DOWNLOAD, Fumo.FORMAT, Fumo.SUCCESS_LEVEL, String.valueOf(FumoResultCode.SUCCESSFUL.getCode()),
						correlator, nodeToExec.getPath());
			}

		});
	}

	private Status update(final Node nodeToExec, final EditingDomain editingDomain, final String correlator, final String format, final String type,
			final String data) {
		return new DelayedProcessing(StatusCode.ACCEPTED_FOR_PROCESSING, new Callable<DMGenericAlert>() {

			@Override
			public DMGenericAlert call() throws Exception {
				return new DMGenericAlert(Fumo.TYPE_UPDATE, Fumo.FORMAT, Fumo.SUCCESS_LEVEL, String.valueOf(FumoResultCode.SUCCESSFUL.getCode()),
						correlator, nodeToExec.getPath());
			}

		});
	}

	private Status downloadAndUpdate(final Node nodeToExec, final EditingDomain editingDomain, final String correlator, final String format,
			final String type, final String data) {
		return new DelayedProcessing(StatusCode.ACCEPTED_FOR_PROCESSING, new Callable<DMGenericAlert>() {

			@Override
			public DMGenericAlert call() throws Exception {
				return new DMGenericAlert(Fumo.TYPE_DOWNLOAD_UPDATE, Fumo.FORMAT, Fumo.SUCCESS_LEVEL, String.valueOf(FumoResultCode.SUCCESSFUL
						.getCode()), correlator, nodeToExec.getPath());
			}

		});
	}

	@Override
	public String getManagementObjectIdentifierSupported() {
		return Fumo.OMI;
	}

	@Override
	public String[] getNodePathsSupported() {
		String baseNode = "./"; //$NON-NLS-1$
		return new String[] { baseNode + Fumo.DOWNLOAD_NODE_NAME, baseNode + Fumo.UPDATE_NODE_NAME, baseNode + Fumo.DOWNLOAD_AND_UPDATE_NODE_NAME };
	}

	@Override
	public boolean requireUserInteraction() {
		return false;
	}

}
