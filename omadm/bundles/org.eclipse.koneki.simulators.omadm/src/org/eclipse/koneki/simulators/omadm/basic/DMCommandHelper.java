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

import java.util.Arrays;
import java.util.Iterator;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.koneki.protocols.omadm.DMNode;
import org.eclipse.koneki.protocols.omadm.Result;
import org.eclipse.koneki.protocols.omadm.Status;
import org.eclipse.koneki.protocols.omadm.StatusCode;
import org.eclipse.koneki.simulators.omadm.model.CommandManagement;
import org.eclipse.koneki.simulators.omadm.model.Node;
import org.eclipse.koneki.simulators.omadm.model.NodeFormat;
import org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorFactory;
import org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage;
import org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers;

public abstract class DMCommandHelper {

	public static Status add(final Node tree, final EditingDomain editingDomain, final String target, final String format, final String type,
			final String data, final boolean mustWork) {
		final Node node = NodeHelpers.getNode(tree, target);
		if (node != null) {
			if (mustWork) {
				return replace(tree, editingDomain, target, format, type, data, true);
			} else {
				return StatusCode.ALREADY_EXISTS;
			}
		} else {
			final Node ancestorNode = NodeHelpers.getExistAncestorNode(tree, target);
			if (ancestorNode.isLeaf()) {
				if (mustWork) {
					replace(tree, editingDomain, ancestorNode.getPath(), NodeFormat.NODE.getLiteral(), "", "", true); //$NON-NLS-1$ //$NON-NLS-2$
				} else {
					return StatusCode.COMMAND_NOT_ALLOWED;
				}
			}
			final CompoundCommand compoundCommand = new CompoundCommand();
			final String[] childrenName = NodeHelpers.getChildrenNames(ancestorNode.getPath(), target);
			Node precedant = ancestorNode;
			for (int i = 0; i < childrenName.length - 1; ++i) {
				final Node child = OMADMSimulatorFactory.eINSTANCE.createNode();
				child.setData(""); //$NON-NLS-1$
				child.setFormat(NodeFormat.NODE);
				child.setName(childrenName[i]);
				child.setType(""); //$NON-NLS-1$
				defaultManagement(child);
				compoundCommand.append(new AddCommand(editingDomain, precedant, OMADMSimulatorPackage.Literals.NODE__CHILDREN, child));
				precedant = child;
			}
			final Node child = OMADMSimulatorFactory.eINSTANCE.createNode();
			child.setData(data);
			child.setFormat(NodeFormat.get(format));
			child.setName(childrenName[childrenName.length - 1]);
			child.setType(type);
			defaultManagement(child);
			compoundCommand.append(new AddCommand(editingDomain, precedant, OMADMSimulatorPackage.Literals.NODE__CHILDREN, child));
			editingDomain.getCommandStack().execute(compoundCommand);
			return StatusCode.OK;
		}
	}

	public static Status copy(final Node tree, final EditingDomain editingDomain, final String target, final String source, final boolean mustWork) {
		final Node sourceNode = NodeHelpers.getNode(tree, source);
		if (sourceNode != null) {
			return add(tree, editingDomain, target, sourceNode.getFormat().getLiteral(), sourceNode.getType(), sourceNode.getData(), mustWork);
		} else {
			return add(tree, editingDomain, target, NodeFormat.NODE.getLiteral(), "", "", mustWork); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	public static Status delete(final Node tree, final EditingDomain editingDomain, final String target, final boolean mustWork) {
		final Node node = NodeHelpers.getNode(tree, target);
		if (node != null) {
			if (!node.isRoot()) {
				editingDomain.getCommandStack().execute(new DeleteCommand(editingDomain, Arrays.asList(node)));
				return StatusCode.OK;
			} else {
				if (mustWork) {
					return StatusCode.OK;
				} else {
					return StatusCode.COMMAND_NOT_ALLOWED;
				}
			}
		} else {
			if (mustWork) {
				return StatusCode.OK;
			} else {
				return StatusCode.NOT_FOUND;
			}
		}
	}

	public static Status get(final Node tree, final EditingDomain editingDomain, final String target, final boolean mustWork) {
		final Node node = NodeHelpers.getNode(tree, target);
		if (node != null) {
			if (node.isLeaf()) {
				return new Result(StatusCode.OK, new DMNode(target, node.getFormat().getLiteral(), node.getType(), node.getData()));
			} else {
				final StringBuffer dataResults = new StringBuffer();
				if (node.getChildren().size() >= 1) {
					final Iterator<Node> it = node.getChildren().iterator();
					dataResults.append(it.next().getName());
					while (it.hasNext()) {
						dataResults.append("/").append(it.next().getName()); //$NON-NLS-1$
					}
				} else {
					dataResults.append(""); //$NON-NLS-1$
				}
				return new Result(StatusCode.OK, new DMNode(target, "node", "text/plain", dataResults.toString())); //$NON-NLS-1$ //$NON-NLS-2$
			}
		} else {
			if (mustWork) {
				add(tree, editingDomain, target, NodeFormat.NODE.getLiteral(), "", "", true); //$NON-NLS-1$ //$NON-NLS-2$
				return get(tree, editingDomain, target, true);
			} else {
				return StatusCode.NOT_FOUND;
			}
		}
	}

	public static Status replace(final Node tree, final EditingDomain editingDomain, final String target, final String format, final String type,
			final String data, final boolean mustWork) {
		final Node node = NodeHelpers.getNode(tree, target);
		if (node != null) {
			if (!node.isRoot()) {
				final CompoundCommand compoundCommand = new CompoundCommand();
				if (node.isInterior()) {
					if (mustWork && NodeFormat.get(format) != NodeFormat.NODE) {
						compoundCommand.append(new DeleteCommand(editingDomain, node.getChildren()));
					} else if (!mustWork) {
						return StatusCode.COMMAND_NOT_ALLOWED;
					}
				}
				compoundCommand.append(new SetCommand(editingDomain, node, OMADMSimulatorPackage.Literals.NODE__FORMAT, NodeFormat.get(format)));
				compoundCommand.append(new SetCommand(editingDomain, node, OMADMSimulatorPackage.Literals.NODE__TYPE, type));
				compoundCommand.append(new SetCommand(editingDomain, node, OMADMSimulatorPackage.Literals.NODE__DATA, data));
				editingDomain.getCommandStack().execute(compoundCommand);
				return StatusCode.OK;
			} else {
				if (mustWork) {
					return StatusCode.OK;
				} else {
					return StatusCode.COMMAND_NOT_ALLOWED;
				}
			}
		} else {
			if (mustWork) {
				return add(tree, editingDomain, target, format, type, data, true);
			} else {
				return StatusCode.NOT_FOUND;
			}
		}
	}

	// public static Status createOrReplace(final Node tree, final EditingDomain editingDomain, final String target, final String format,
	// final String type, final String data) {
	// final Status status = add(tree, editingDomain, target, format, type, data);
	// if (status.getCode() == StatusCode.ALREADY_EXISTS.getCode()) {
	// return replace(tree, editingDomain, target, format, type, data);
	// } else {
	// return status;
	// }
	// }

	private static void defaultManagement(final Node node) {
		node.setGetManagement(CommandManagement.INHERITED);
		node.setGetCode(StatusCode.OK.getCode());
		node.setAddManagement(CommandManagement.INHERITED);
		node.setAddCode(StatusCode.OK.getCode());
		node.setDeleteManagement(CommandManagement.INHERITED);
		node.setDeleteCode(StatusCode.OK.getCode());
		node.setCopyManagement(CommandManagement.INHERITED);
		node.setCopyCode(StatusCode.OK.getCode());
		node.setReplaceManagement(CommandManagement.INHERITED);
		node.setReplaceCode(StatusCode.OK.getCode());
		node.setExecManagement(CommandManagement.INHERITED);
		node.setExecCode(StatusCode.OPTIONAL_FEATURE_NOT_SUPPORTED.getCode());
	}

}
