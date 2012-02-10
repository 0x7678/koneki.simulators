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
package org.eclipse.koneki.simulators.omadm.editor.internal.dashboard;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.koneki.commons.ui.ANWRTToolkit;
import org.eclipse.koneki.protocols.omadm.CommandHandler;
import org.eclipse.koneki.protocols.omadm.DMNode;
import org.eclipse.koneki.protocols.omadm.Result;
import org.eclipse.koneki.protocols.omadm.Status;
import org.eclipse.koneki.protocols.omadm.StatusCode;
import org.eclipse.koneki.simulators.omadm.basic.DMCommandHelper;
import org.eclipse.koneki.simulators.omadm.editor.OMADMSimulatorEditor;
import org.eclipse.koneki.simulators.omadm.editor.internal.Activator;
import org.eclipse.koneki.simulators.omadm.model.Node;
import org.eclipse.koneki.simulators.omadm.model.NodeFormat;
import org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

final class ConnectCommandHandler implements CommandHandler {

	private final DashboardPage page;
	private Status status;

	public ConnectCommandHandler(final DashboardPage page) {
		this.page = page;
	}

	@Override
	public Status get(final String target) {
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				final OMADMSimulatorEditor editor = ConnectCommandHandler.this.page.getEditor();
				final CommandHandlerDialog dialog = new CommandHandlerDialog(editor.getSite().getShell(), editor.getANWRTToolkit());
				dialog.setText("Manual get");
				dialog.setImage(Activator.getDefault().getImage(Activator.GET_COMMAND));
				dialog.setCommandText("Get " + target);
				dialog.setWithResult(true);
				dialog.setCodes(StatusCode.GET_CODES);
				final Node tree = editor.getOMADMSimulation().getDevice().getTree();
				final Status st = DMCommandHelper.get(tree, editor.getEditingDomain(), target, false);
				if (st.getCode() == StatusCode.OK.getCode()) {
					dialog.setDefaultFormat(NodeFormat.get(st.getResult().getFormat()));
					dialog.setDefaultType(st.getResult().getType());
					dialog.setDefaultResults(st.getResult().getData());
				} else {
					dialog.setDefaultFormat(NodeFormat.CHR);
					dialog.setDefaultType("text/plain");
					dialog.setDefaultResults(""); //$NON-NLS-1$
				}
				dialog.setSelectionListener(new CommandHandlerDialog.OKSelectionListener() {

					@Override
					public void selected(final StatusCode statusCode, final String format, final String type, final String results) {
						switch (statusCode) {
						case OK:
							final Node tree = editor.getOMADMSimulation().getDevice().getTree();
							final Node node = NodeHelpers.getNode(tree, target);
							if (node != null) {
								DMCommandHelper.replace(tree, editor.getEditingDomain(), target, format,
										format.equals(NodeFormat.NODE.getLiteral()) ? node.getType() : type,
										format.equals(NodeFormat.NODE.getLiteral()) ? "" : results, true); //$NON-NLS-1$
							} else {
								DMCommandHelper.replace(tree, editor.getEditingDomain(), target, format,
										format.equals(NodeFormat.NODE.getLiteral()) ? "" : type, format.equals(NodeFormat.NODE.getLiteral()) ? "" //$NON-NLS-1$ //$NON-NLS-2$
												: results, true);
							}
							setStatus(new Result(statusCode, new DMNode(target, format, type, results)));
							break;
						default:
							setStatus(statusCode);
							break;
						}
					}
				});
				dialog.open();
			}
		});
		return getStatus();
	}

	@Override
	public Status add(final String target, final String format, final String type, final String data) {
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				final OMADMSimulatorEditor editor = ConnectCommandHandler.this.page.getEditor();
				final CommandHandlerDialog dialog = new CommandHandlerDialog(editor.getSite().getShell(), editor.getANWRTToolkit());
				dialog.setText("Manual add");
				dialog.setImage(Activator.getDefault().getImage(Activator.ADD_COMMAND));
				dialog.setCommandText("Add " + target + " " + data); //$NON-NLS-2$
				dialog.setWithResult(false);
				dialog.setCodes(StatusCode.ADD_CODES);
				dialog.setSelectionListener(new CommandHandlerDialog.OKSelectionListener() {

					@Override
					public void selected(final StatusCode statusCode, final String formatSelected, final String typeSelected,
							final String resultsSelected) {
						if (statusCode == StatusCode.OK) {
							final Node tree = editor.getOMADMSimulation().getDevice().getTree();
							DMCommandHelper.add(tree, editor.getEditingDomain(), target, format, type, data, true);
						}
						setStatus(statusCode);
					}

				});
				dialog.open();
			}

		});
		return getStatus();
	}

	@Override
	public Status copy(final String target, final String source) {
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				final OMADMSimulatorEditor editor = ConnectCommandHandler.this.page.getEditor();
				final CommandHandlerDialog dialog = new CommandHandlerDialog(editor.getSite().getShell(), editor.getANWRTToolkit());
				dialog.setText("Manual copy");
				dialog.setImage(Activator.getDefault().getImage(Activator.COPY_COMMAND));
				dialog.setCommandText("Copy " + target + " " + source); //$NON-NLS-2$
				dialog.setWithResult(false);
				dialog.setCodes(StatusCode.COPY_CODES);
				dialog.setSelectionListener(new CommandHandlerDialog.OKSelectionListener() {

					@Override
					public void selected(final StatusCode statusCode, final String formatSelected, final String typeSelected,
							final String resultsSelected) {
						if (statusCode == StatusCode.OK) {
							final Node tree = editor.getOMADMSimulation().getDevice().getTree();
							DMCommandHelper.copy(tree, editor.getEditingDomain(), target, source, true);
						}
						setStatus(statusCode);
					}

				});
				dialog.open();
			}

		});
		return getStatus();
	}

	@Override
	public Status delete(final String target) {
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				final OMADMSimulatorEditor editor = ConnectCommandHandler.this.page.getEditor();
				final CommandHandlerDialog dialog = new CommandHandlerDialog(editor.getSite().getShell(), editor.getANWRTToolkit());
				dialog.setText("Manual delete");
				dialog.setImage(Activator.getDefault().getImage(Activator.DELETE_COMMAND));
				dialog.setCommandText("Delete " + target);
				dialog.setWithResult(false);
				dialog.setCodes(StatusCode.DELETE_CODES);
				dialog.setSelectionListener(new CommandHandlerDialog.OKSelectionListener() {

					@Override
					public void selected(final StatusCode statusCode, final String format, final String type, final String results) {
						if (statusCode == StatusCode.OK) {
							final Node tree = editor.getOMADMSimulation().getDevice().getTree();
							DMCommandHelper.delete(tree, editor.getEditingDomain(), target, true);
						}
						setStatus(statusCode);
					}

				});
				dialog.open();
			}

		});
		return getStatus();
	}

	@Override
	public Status exec(final String target, final String correlator, final String format, final String type, final String data) {
		return StatusCode.OPTIONAL_FEATURE_NOT_SUPPORTED;
	}

	@Override
	public Status replace(final String target, final String format, final String type, final String data) {
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				final OMADMSimulatorEditor editor = ConnectCommandHandler.this.page.getEditor();
				final CommandHandlerDialog dialog = new CommandHandlerDialog(editor.getSite().getShell(), editor.getANWRTToolkit());
				dialog.setText("Manual replace");
				dialog.setImage(Activator.getDefault().getImage(Activator.REPLACE_COMMAND));
				dialog.setCommandText("Replace " + target + " " + data); //$NON-NLS-2$
				dialog.setWithResult(false);
				dialog.setCodes(StatusCode.REPLACE_CODES);
				dialog.setSelectionListener(new CommandHandlerDialog.OKSelectionListener() {

					@Override
					public void selected(final StatusCode statusCode, final String formatSelected, final String typeSelected, final String results) {
						if (statusCode == StatusCode.OK) {
							final Node tree = editor.getOMADMSimulation().getDevice().getTree();
							DMCommandHelper.replace(tree, editor.getEditingDomain(), target, format, type, data, true);
						}
						setStatus(statusCode);
					}

				});
				dialog.open();
			}

		});
		return getStatus();
	}

	private Status getStatus() {
		return this.status;
	}

	private void setStatus(final Status status) {
		this.status = status;
	}

	private static final class CommandHandlerDialog extends Dialog {

		private final ANWRTToolkit toolkit;
		private String commandText;
		private Image image;
		private boolean withResult;
		private StatusCode[] codes;
		private NodeFormat defaultFormat;
		private String defaultType;
		private String defaultResults;
		private OKSelectionListener selectionListener;

		public CommandHandlerDialog(final Shell parent, final ANWRTToolkit toolkit) {
			super(parent, SWT.TITLE | SWT.BORDER | SWT.APPLICATION_MODAL);
			this.toolkit = toolkit;
		}

		public String getCommandText() {
			return this.commandText;
		}

		public void setCommandText(final String commandText) {
			this.commandText = commandText;
		}

		public Image getImage() {
			return this.image;
		}

		public void setImage(final Image image) {
			this.image = image;
		}

		public boolean isWithResult() {
			return this.withResult;
		}

		public void setWithResult(final boolean withResult) {
			this.withResult = withResult;
		}

		public StatusCode[] getCodes() {
			return this.codes;
		}

		public void setCodes(final StatusCode[] codes) {
			this.codes = codes;
		}

		public OKSelectionListener getSelectionListener() {
			return this.selectionListener;
		}

		public void setSelectionListener(final OKSelectionListener selectionListener) {
			this.selectionListener = selectionListener;
		}

		public void open() {
			final Shell dialog = new Shell(getParent(), getStyle());
			dialog.setText(getText());
			dialog.setImage(getImage());
			createContents(dialog);
			dialog.pack();
			dialog.open();
			final Display display = getParent().getDisplay();
			while (!dialog.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		}

		private void createContents(final Shell parent) {
			GridLayoutFactory.fillDefaults().numColumns(2).margins(20, 10).applyTo(parent);

			final Label commandLabel = this.toolkit.createLabel(parent, getCommandText());
			GridDataFactory.fillDefaults().grab(true, false).span(2, 1).applyTo(commandLabel);

			this.toolkit.createLabel(parent, "Status code:");
			final ComboViewer statusCodeCombo = this.toolkit.createComboViewer(parent, SWT.READ_ONLY);
			statusCodeCombo.setInput(getCodes());
			statusCodeCombo.getCombo().select(0);
			GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(statusCodeCombo.getCombo());

			final SelectionListener okListener;
			if (isWithResult()) {
				this.toolkit.createLabel(parent, "Format:");
				final ComboViewer formatCombo = this.toolkit.createComboViewer(parent, SWT.READ_ONLY);
				formatCombo.setInput(NodeFormat.VALUES);
				formatCombo.getCombo().select(formatCombo.getCombo().indexOf(defaultFormat.toString()));
				GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(formatCombo.getCombo());

				this.toolkit.createLabel(parent, "Type:");
				final Text typeText = this.toolkit.createText(parent, defaultType, SWT.BORDER);
				GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(typeText);

				this.toolkit.createLabel(parent, "Result:");
				final Text resultsText = this.toolkit.createText(parent, defaultResults, SWT.BORDER);
				GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(resultsText);

				statusCodeCombo.addSelectionChangedListener(new ISelectionChangedListener() {

					@Override
					public void selectionChanged(final SelectionChangedEvent event) {
						switch ((StatusCode) ((StructuredSelection) event.getSelection()).getFirstElement()) {
						case OK:
							formatCombo.getCombo().setEnabled(true);
							typeText.setEnabled(true);
							resultsText.setEnabled(true);
							break;
						default:
							formatCombo.getCombo().setEnabled(false);
							typeText.setEnabled(false);
							resultsText.setEnabled(false);
							break;
						}
					}

				});

				okListener = new SelectionAdapter() {

					@Override
					public void widgetSelected(final SelectionEvent e) {
						final StatusCode statusCode = (StatusCode) ((StructuredSelection) statusCodeCombo.getSelection()).getFirstElement();
						final String format = ((NodeFormat) ((StructuredSelection) formatCombo.getSelection()).getFirstElement()).getLiteral();
						final String type = typeText.getText();
						final String results = resultsText.getText();
						getSelectionListener().selected(statusCode, format, type, results);
						parent.close();
					}

				};
			} else {
				okListener = new SelectionAdapter() {

					@Override
					public void widgetSelected(final SelectionEvent e) {
						final StatusCode statusCode = (StatusCode) ((StructuredSelection) statusCodeCombo.getSelection()).getFirstElement();
						getSelectionListener().selected(statusCode, null, null, null);
						parent.close();
					}

				};
			}

			final Button okButton = this.toolkit.createButton(parent, "OK", SWT.PUSH);
			okButton.addSelectionListener(okListener);
			GridDataFactory.fillDefaults().grab(true, false).span(2, 1).align(SWT.CENTER, SWT.FILL).applyTo(okButton);

		}

		public void setDefaultFormat(final NodeFormat defaultFormat) {
			this.defaultFormat = defaultFormat;
		}

		public void setDefaultType(final String defaultType) {
			this.defaultType = defaultType;
		}

		public void setDefaultResults(final String defaultResults) {
			this.defaultResults = defaultResults;
		}

		public static interface OKSelectionListener {

			void selected(final StatusCode statusCode, final String format, final String type, final String results);

		}

	}

}
