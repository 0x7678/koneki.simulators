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
package org.eclipse.koneki.simulators.omadm.editor.internal.simulation;

import static org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers.canDeleteNode;

import java.util.Arrays;

import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.koneki.simulators.omadm.editor.OMADMSimulatorEditor;
import org.eclipse.koneki.simulators.omadm.model.Node;

class DeleteNode extends Action {

	private final OMADMSimulatorEditor editor;
	private final Node node;

	public DeleteNode(final OMADMSimulatorEditor editor, final Node node) {
		this.editor = editor;
		this.node = node;

		setText(Messages.DeleteNode_Text);
		setToolTipText(Messages.DeleteNode_Tooltip);
		setEnabled(canDeleteNode(node));
	}

	@Override
	public final void run() {
		final boolean ok = MessageDialog.openConfirm(this.editor.getSite().getShell(), Messages.DeleteNode_ConfirmDeleteTitle,
				Messages.DeleteNode_ConfirmDeleteMessage);
		if (ok) {
			this.editor.getEditingDomain().getCommandStack().execute(new DeleteCommand(this.editor.getEditingDomain(), Arrays.asList(node)));
		}
	}

}
