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
package org.eclipse.koneki.simulators.omadm.fumo.manual.internal;

import java.util.concurrent.Callable;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.koneki.commons.ui.ANWRTToolkit;
import org.eclipse.koneki.protocols.omadm.DMGenericAlert;
import org.eclipse.koneki.protocols.omadm.DelayedProcessing;
import org.eclipse.koneki.protocols.omadm.Status;
import org.eclipse.koneki.protocols.omadm.StatusCode;
import org.eclipse.koneki.simulators.omadm.basic.DMCommandHelper;
import org.eclipse.koneki.simulators.omadm.basic.DMExecHandler;
import org.eclipse.koneki.simulators.omadm.fumo.Fumo;
import org.eclipse.koneki.simulators.omadm.fumo.FumoResultCode;
import org.eclipse.koneki.simulators.omadm.model.Node;
import org.eclipse.koneki.simulators.omadm.model.NodeFormat;
import org.eclipse.koneki.simulators.omadm.model.util.NodeHelpers;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class DMFumoManualExecHandler implements DMExecHandler {

	private static final String FUMO = "FUMO"; //$NON-NLS-1$
	private static final String CHR = "chr"; //$NON-NLS-1$
	private static final String TEXT_PLAIN = "text/plain"; //$NON-NLS-1$

	private DMGenericAlert genericAlert;

	@Override
	public Status exec(final Node nodeToExec, final EditingDomain editingDomain, final String correlator, final String format, final String type,
			final String data) {
		if (!nodeToExec.getParent().getType().equals(Fumo.OMI)) {
			Display.getDefault().syncExec(new Runnable() {

				@Override
				public void run() {
					if (MessageDialog.openQuestion(Display.getDefault().getActiveShell(), FUMO, "Do you want to use FUMO for the Exec command on "
							+ nodeToExec.getPath() + "?")) { //$NON-NLS-1$
						DMCommandHelper.replace(nodeToExec.getRoot(), editingDomain, nodeToExec.getParent().getPath(), NodeFormat.NODE.getLiteral(),
								Fumo.OMI, "", true); //$NON-NLS-1$
					}
				}

			});
		}
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
				Display.getDefault().syncExec(new Runnable() {

					@Override
					public void run() {
						final FumoDialog dialog = new FumoDialog(Display.getDefault().getActiveShell());
						dialog.setText("FUMO download");
						dialog.setExecText("FUMO download on " + nodeToExec.getPath());
						dialog.setCodes(FumoResultCode.values());
						dialog.setWithNewVersion(false);
						dialog.setSelectionListener(new FumoDialog.OKSelectionListener() {

							@Override
							public void selected(final FumoResultCode resultCode, final String firmwareVersion, final String softwareVersion) {
								final String mark;
								if (resultCode.getCode() < 300) {
									mark = Fumo.SUCCESS_LEVEL;
								} else {
									mark = Fumo.FAIL_LEVEL;
								}
								setGenericAlert(new DMGenericAlert(Fumo.TYPE_DOWNLOAD, Fumo.FORMAT, mark, String.valueOf(resultCode.getCode()),
										correlator, nodeToExec.getPath()));
							}

						});
						dialog.open();
					}

				});
				return getGenericAlert();
			}

		});
	}

	private Status update(final Node nodeToExec, final EditingDomain editingDomain, final String correlator, final String format, final String type,
			final String data) {
		return new DelayedProcessing(StatusCode.ACCEPTED_FOR_PROCESSING, new Callable<DMGenericAlert>() {

			@Override
			public DMGenericAlert call() throws Exception {
				Display.getDefault().syncExec(new Runnable() {

					@Override
					public void run() {
						final FumoDialog dialog = new FumoDialog(Display.getDefault().getActiveShell());
						dialog.setText("FUMO update");
						dialog.setExecText("FUMO update on " + nodeToExec.getPath());
						dialog.setCodes(FumoResultCode.values());
						dialog.setWithNewVersion(true);
						dialog.setFirmawareVersion(getFwV(nodeToExec));
						dialog.setSoftwareVersion(getSwV(nodeToExec));
						dialog.setSelectionListener(new FumoDialog.OKSelectionListener() {

							@Override
							public void selected(final FumoResultCode resultCode, final String firmwareVersion, final String softwareVersion) {
								final String mark;
								if (resultCode.getCode() < 300) {
									mark = Fumo.SUCCESS_LEVEL;
									DMCommandHelper.replace(nodeToExec.getRoot(), editingDomain, "./DevDetail/FwV", CHR, TEXT_PLAIN, firmwareVersion,
											true);
									DMCommandHelper.replace(nodeToExec.getRoot(), editingDomain, "./DevDetail/SwV", CHR, TEXT_PLAIN, softwareVersion,
											true);
								} else {
									mark = Fumo.FAIL_LEVEL;
								}
								setGenericAlert(new DMGenericAlert(Fumo.TYPE_UPDATE, Fumo.FORMAT, mark, String.valueOf(resultCode.getCode()),
										correlator, nodeToExec.getPath()));
							}

						});
						dialog.open();
					}

				});
				return getGenericAlert();
			}

		});
	}

	private Status downloadAndUpdate(final Node nodeToExec, final EditingDomain editingDomain, final String correlator, final String format,
			final String type, final String data) {
		return new DelayedProcessing(StatusCode.ACCEPTED_FOR_PROCESSING, new Callable<DMGenericAlert>() {

			@Override
			public DMGenericAlert call() throws Exception {
				Display.getDefault().syncExec(new Runnable() {

					@Override
					public void run() {
						final FumoDialog dialog = new FumoDialog(Display.getDefault().getActiveShell());
						dialog.setText("FUMO download and update");
						dialog.setExecText("FUMO download and update on " + nodeToExec.getPath());
						dialog.setCodes(FumoResultCode.values());
						dialog.setWithNewVersion(true);
						dialog.setFirmawareVersion(getFwV(nodeToExec));
						dialog.setSoftwareVersion(getSwV(nodeToExec));
						dialog.setSelectionListener(new FumoDialog.OKSelectionListener() {

							@Override
							public void selected(final FumoResultCode resultCode, final String firmwareVersion, final String softwareVersion) {
								final String mark;
								if (resultCode.getCode() < 300) {
									mark = Fumo.SUCCESS_LEVEL;
									DMCommandHelper.replace(nodeToExec.getRoot(), editingDomain, "./DevDetail/FwV", CHR, TEXT_PLAIN, firmwareVersion,
											true);
									DMCommandHelper.replace(nodeToExec.getRoot(), editingDomain, "./DevDetail/SwV", CHR, TEXT_PLAIN, softwareVersion,
											true);
								} else {
									mark = Fumo.FAIL_LEVEL;
								}
								setGenericAlert(new DMGenericAlert(Fumo.TYPE_DOWNLOAD_UPDATE, Fumo.FORMAT, mark,
										String.valueOf(resultCode.getCode()), correlator, nodeToExec.getPath()));
							}

						});
						dialog.open();
					}

				});
				return getGenericAlert();
			}

		});
	}

	@Override
	public String getManagementObjectIdentifierSupported() {
		return Fumo.OMI;
	}

	@Override
	public String[] getNodePathsSupported() {
		return new String[] { "./Download", "./Update", "./DownloadAndUpdate" };
	}

	@Override
	public boolean requireUserInteraction() {
		return true;
	}

	private static String getFwV(final Node node) {
		final Node fwV = NodeHelpers.getNode(node.getRoot(), "./DevDetail/FwV");
		return fwV != null ? fwV.getData() : ""; //$NON-NLS-1$
	}

	private static String getSwV(final Node node) {
		final Node swV = NodeHelpers.getNode(node.getRoot(), "./DevDetail/SwV");
		return swV != null ? swV.getData() : ""; //$NON-NLS-1$
	}

	private DMGenericAlert getGenericAlert() {
		return this.genericAlert;
	}

	public void setGenericAlert(final DMGenericAlert genericAlert) {
		this.genericAlert = genericAlert;
	}

	private static final class FumoDialog extends Dialog {

		private final ANWRTToolkit toolkit;
		private String execText;
		private FumoResultCode[] codes;
		private boolean withNewVersion;
		private String firmawareVersion;
		private String softwareVersion;
		private OKSelectionListener selectionListener;

		public FumoDialog(final Shell parent) {
			super(parent, SWT.TITLE | SWT.BORDER);
			this.toolkit = new ANWRTToolkit(Display.getDefault());
		}

		public void open() {
			final Shell dialog = new Shell(getParent(), getStyle());
			dialog.setText(getText());
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

			final Label execLabel = this.toolkit.createLabel(parent, getExecText());
			GridDataFactory.fillDefaults().grab(true, false).span(2, 1).applyTo(execLabel);

			this.toolkit.createLabel(parent, "Result code:");
			final ComboViewer resultCodeCombo = this.toolkit.createComboViewer(parent, SWT.READ_ONLY);
			resultCodeCombo.setInput(getCodes());
			resultCodeCombo.getCombo().select(0);
			GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(resultCodeCombo.getCombo());

			final SelectionListener okListener;
			if (getWithNewVersion()) {
				this.toolkit.createLabel(parent, "Firmware version:");
				final Text firmwareVersionText = this.toolkit.createText(parent, getFirmawareVersion(), SWT.BORDER);
				GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(firmwareVersionText);

				this.toolkit.createLabel(parent, "Software version:");
				final Text softwareVersionText = this.toolkit.createText(parent, getSoftwareVersion(), SWT.BORDER);
				GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(softwareVersionText);

				resultCodeCombo.addSelectionChangedListener(new ISelectionChangedListener() {

					@Override
					public void selectionChanged(final SelectionChangedEvent event) {
						switch ((FumoResultCode) ((StructuredSelection) event.getSelection()).getFirstElement()) {
						case SUCCESSFUL:
							firmwareVersionText.setEnabled(true);
							softwareVersionText.setEnabled(true);
							break;
						default:
							firmwareVersionText.setEnabled(false);
							softwareVersionText.setEnabled(false);
							break;
						}
					}

				});

				okListener = new SelectionAdapter() {

					@Override
					public void widgetSelected(final SelectionEvent e) {
						final FumoResultCode resultCode = (FumoResultCode) ((StructuredSelection) resultCodeCombo.getSelection()).getFirstElement();
						getSelectionListener().selected(resultCode, firmwareVersionText.getText(), softwareVersionText.getText());
						parent.close();
					}

				};
			} else {
				okListener = new SelectionAdapter() {

					@Override
					public void widgetSelected(final SelectionEvent e) {
						final FumoResultCode resultCode = (FumoResultCode) ((StructuredSelection) resultCodeCombo.getSelection()).getFirstElement();
						getSelectionListener().selected(resultCode, null, null);
						parent.close();
					}

				};
			}

			final Button okButton = this.toolkit.createButton(parent, "OK", SWT.PUSH);
			okButton.addSelectionListener(okListener);
			GridDataFactory.fillDefaults().grab(true, false).span(2, 1).align(SWT.CENTER, SWT.FILL).applyTo(okButton);
		}

		public String getExecText() {
			return this.execText;
		}

		public void setExecText(final String execText) {
			this.execText = execText;
		}

		public FumoResultCode[] getCodes() {
			return this.codes;
		}

		public void setCodes(final FumoResultCode[] codes) {
			this.codes = codes;
		}

		private String getFirmawareVersion() {
			return this.firmawareVersion;
		}

		public void setFirmawareVersion(final String firmawareVersion) {
			this.firmawareVersion = firmawareVersion;
		}

		private String getSoftwareVersion() {
			return this.softwareVersion;
		}

		public void setSoftwareVersion(final String softwareVersion) {
			this.softwareVersion = softwareVersion;
		}

		private boolean getWithNewVersion() {
			return this.withNewVersion;
		}

		public void setWithNewVersion(final boolean withNewVersion) {
			this.withNewVersion = withNewVersion;
		}

		public OKSelectionListener getSelectionListener() {
			return this.selectionListener;
		}

		public void setSelectionListener(final OKSelectionListener selectionListener) {
			this.selectionListener = selectionListener;
		}

		public static interface OKSelectionListener {
			void selected(final FumoResultCode resultCode, final String firmwareVersion, final String softwareVersion);
		}

	}

}
