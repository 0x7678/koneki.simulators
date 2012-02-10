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

import static org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers.canAddChildren;

import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.koneki.protocols.omadm.StatusCode;
import org.eclipse.koneki.simulators.omadm.editor.OMADMSimulatorEditor;
import org.eclipse.koneki.simulators.omadm.model.CommandManagement;
import org.eclipse.koneki.simulators.omadm.model.Node;
import org.eclipse.koneki.simulators.omadm.model.NodeFormat;
import org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorFactory;
import org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage;

class AddInteriorNode extends Action {

	private final OMADMSimulatorEditor editor;
	private final Node parentNode;

	public AddInteriorNode(final OMADMSimulatorEditor editor, final Node parentNode) {
		this.editor = editor;
		this.parentNode = parentNode;

		setText(Messages.AddInteriorNode_Text);
		setToolTipText(Messages.AddInteriorNode_Tooltip);
		setEnabled(canAddChildren(this.parentNode));
	}

	@Override
	public final void run() {
		final Node interior = OMADMSimulatorFactory.eINSTANCE.createNode();
		interior.setName(""); //$NON-NLS-1$
		interior.setFormat(NodeFormat.NODE);
		interior.setType(""); //$NON-NLS-1$
		interior.setData(""); //$NON-NLS-1$
		interior.setFormat(NodeFormat.NODE);
		interior.setGetManagement(CommandManagement.INHERITED);
		interior.setGetCode(StatusCode.OK.getCode());
		interior.setAddManagement(CommandManagement.INHERITED);
		interior.setAddCode(StatusCode.OK.getCode());
		interior.setDeleteManagement(CommandManagement.INHERITED);
		interior.setDeleteCode(StatusCode.OK.getCode());
		interior.setCopyManagement(CommandManagement.INHERITED);
		interior.setCopyCode(StatusCode.OK.getCode());
		interior.setReplaceManagement(CommandManagement.INHERITED);
		interior.setReplaceCode(StatusCode.OK.getCode());
		interior.setExecManagement(CommandManagement.INHERITED);
		interior.setExecCode(StatusCode.OPTIONAL_FEATURE_NOT_SUPPORTED.getCode());
		this.editor.getEditingDomain().getCommandStack()
				.execute(new AddCommand(this.editor.getEditingDomain(), this.parentNode, OMADMSimulatorPackage.Literals.NODE__CHILDREN, interior));
	}

}
