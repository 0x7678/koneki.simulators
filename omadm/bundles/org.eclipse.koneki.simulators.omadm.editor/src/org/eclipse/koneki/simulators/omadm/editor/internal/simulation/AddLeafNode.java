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

class AddLeafNode extends Action {

	private static final String TEXT_PLAIN = "text/plain"; //$NON-NLS-1$

	private final OMADMSimulatorEditor editor;
	private final Node parentNode;

	public AddLeafNode(final OMADMSimulatorEditor editor, final Node parentNode) {
		this.editor = editor;
		this.parentNode = parentNode;

		setText(Messages.AddLeafNode_Text);
		setToolTipText(Messages.AddLeafNode_Tooltip);
		setEnabled(canAddChildren(this.parentNode));
	}

	@Override
	public final void run() {
		final Node leaf = OMADMSimulatorFactory.eINSTANCE.createNode();
		leaf.setName(""); //$NON-NLS-1$
		leaf.setFormat(NodeFormat.CHR);
		leaf.setType(TEXT_PLAIN);
		leaf.setData(""); //$NON-NLS-1$
		leaf.setGetManagement(CommandManagement.INHERITED);
		leaf.setGetCode(StatusCode.OK.getCode());
		leaf.setAddManagement(CommandManagement.INHERITED);
		leaf.setAddCode(StatusCode.OK.getCode());
		leaf.setDeleteManagement(CommandManagement.INHERITED);
		leaf.setDeleteCode(StatusCode.OK.getCode());
		leaf.setCopyManagement(CommandManagement.INHERITED);
		leaf.setCopyCode(StatusCode.OK.getCode());
		leaf.setReplaceManagement(CommandManagement.INHERITED);
		leaf.setReplaceCode(StatusCode.OK.getCode());
		leaf.setExecManagement(CommandManagement.INHERITED);
		leaf.setExecCode(StatusCode.OPTIONAL_FEATURE_NOT_SUPPORTED.getCode());
		this.editor.getEditingDomain().getCommandStack()
				.execute(new AddCommand(this.editor.getEditingDomain(), this.parentNode, OMADMSimulatorPackage.Literals.NODE__CHILDREN, leaf));
	}

}
