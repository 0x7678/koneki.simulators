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
package org.eclipse.koneki.simulators.omadm.editor;

import org.eclipse.pde.emfforms.editor.EmfActionBarContributor;
import org.eclipse.ui.IActionBars;

public class OMADMSimulatorActionBarContributor extends EmfActionBarContributor {
	/**
	 * @see org.eclipse.pde.emfforms.editor.EmfActionBarContributor#init(org.eclipse.ui.IActionBars)
	 */
	@Override
	public void init(IActionBars actionBars) {
		super.init(actionBars);

		// Add the Undo/Redo action to the toolbar
		actionBars.getToolBarManager().add(undoAction);
		actionBars.getToolBarManager().add(redoAction);
	}
}
