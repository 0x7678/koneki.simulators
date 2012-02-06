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

public class DMSimulatorException extends Exception {

	private static final long serialVersionUID = 1L;

	public DMSimulatorException() {
		super();
	}

	public DMSimulatorException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public DMSimulatorException(final String message) {
		super(message);
	}

	public DMSimulatorException(final Throwable cause) {
		super(cause);
	}

}
