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

import org.eclipse.koneki.simulators.omadm.model.OMADMSimulation;
import org.eclipse.pde.emfforms.editor.DefaultEmfFormEditorConfig;

public class OMADMSimulatorEditorConfig extends DefaultEmfFormEditorConfig<OMADMSimulatorEditor, OMADMSimulation> {

	public OMADMSimulatorEditorConfig(OMADMSimulatorEditor editor) {
		super(editor);
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public boolean isUsingSharedClipboard() {
		return true;
	}

}
