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

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.koneki.commons.ui.ANWRTToolkit;
import org.eclipse.koneki.commons.ui.CommonFonts;
import org.eclipse.koneki.commons.ui.widgets.ClickableIconAndLabel;
import org.eclipse.koneki.commons.ui.widgets.InfoBanner;
import org.eclipse.koneki.protocols.omadm.DMGenericAlert;
import org.eclipse.koneki.simulators.omadm.editor.Messages;
import org.eclipse.koneki.simulators.omadm.editor.OMADMSimulatorEditor;
import org.eclipse.koneki.simulators.omadm.editor.internal.Activator;
import org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage;
import org.eclipse.pde.emfforms.editor.AbstractEmfFormPage;
import org.eclipse.pde.emfforms.editor.EmfMasterDetailBlock;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Sash;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.Section;

public class DashboardPage extends AbstractEmfFormPage {

	private final OMADMSimulatorEditor editor;
	private final EmfMasterDetailBlock masterDetail;
	private TabFolder sessionManagementCompositeTabs;
	private ToolItem clearToolItem;
	private Tree commandsViewTree;
	private Tree messagesViewTree;
	private StyledText messagesViewText;
	private ClickableIconAndLabel connectIcon;
	private Label alertWaitingLabel;
	private Queue<DMGenericAlert> genericAlertsQueue;

	public DashboardPage(OMADMSimulatorEditor editor) {
		super(editor, 1, Messages.DashBoardPage_Title);
		this.editor = editor;
		this.masterDetail = new DashboardMasterDetails(this);
	}

	@Override
	public String getId() {
		return getClass().getName();
	}

	@Override
	public void bind(DataBindingContext bindingContext) {
		bindingContext.bindValue(ViewerProperties.input().observe(this.masterDetail.getTreeViewer()), EMFEditObservables.observeDetailValue(
				Realm.getDefault(), getEditor().getEditingDomain(), getEditor().getInputObservable(),
				OMADMSimulatorPackage.Literals.OMADM_SIMULATION__DEVICE));
	}

	@Override
	public void createContents(Composite parent) {
		final ANWRTToolkit toolkit = getEditor().getANWRTToolkit();

		final Composite pageComposite = toolkit.createComposite(getManagedForm().getForm().getBody());
		GridLayoutFactory.swtDefaults().numColumns(1).spacing(20, 20).applyTo(pageComposite);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(pageComposite);

		final InfoBanner infoBanner = toolkit.createInfoBanner(pageComposite);
		infoBanner.getFormText().setText(Messages.DashBoardPage_InfoBanner, true, true);
		infoBanner.getFormText().setFont(CommonFonts.BOLD);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(infoBanner);

		this.genericAlertsQueue = new ConcurrentLinkedQueue<DMGenericAlert>();

		this.masterDetail.createContent(getManagedForm());

		createSessionManagement(getManagedForm().getForm().getBody(), toolkit);

		this.clearToolItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(final SelectionEvent e) {
				switch (DashboardPage.this.sessionManagementCompositeTabs.getSelectionIndex()) {
				case 0:
					DashboardPage.this.commandsViewTree.removeAll();
					break;
				case 1:
					DashboardPage.this.messagesViewTree.removeAll();
					DashboardPage.this.messagesViewText.setText("");
					break;
				default:
					break;
				}
			}

		});

		this.connectIcon.addSelectionListener(new ConnectSelection(editor, this));

		this.messagesViewTree.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				final Object data = event.item.getData();
				if (data != null && data instanceof String) {
					DashboardPage.this.messagesViewText.setText((String) data);
				} else {
					DashboardPage.this.messagesViewText.setText("");
				}
			}

		});
	}

	private void createSessionManagement(Composite parent, ANWRTToolkit toolkit) {
		final Section sessionManagementSection = toolkit.createSection(parent, ExpandableComposite.TITLE_BAR);
		sessionManagementSection.setText(Messages.DashBoardPage_ManagementSection_Title);
		sessionManagementSection.marginWidth = 5;
		sessionManagementSection.marginHeight = 5;
		GridDataFactory.fillDefaults().grab(true, true).span(1, 1).hint(1, 200).applyTo(sessionManagementSection);

		final Composite sessionManagementComposite = toolkit.createComposite(sessionManagementSection);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(sessionManagementComposite);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(sessionManagementComposite);

		final ToolBar sessionManagementToolBar = new ToolBar(sessionManagementSection, SWT.FLAT);
		this.clearToolItem = new ToolItem(sessionManagementToolBar, SWT.PUSH);
		this.clearToolItem.setImage(Activator.getDefault().getImage(Activator.CLEAR));
		this.clearToolItem.setToolTipText(Messages.DashBoardPage_ManagementSection_Clear);

		this.sessionManagementCompositeTabs = new TabFolder(sessionManagementComposite, SWT.NONE);
		final TabItem commandsTab = new TabItem(this.sessionManagementCompositeTabs, SWT.NONE);
		commandsTab.setText(Messages.DashBoardPage_ManagementSection_Command);
		commandsTab.setControl(createCommandsView(this.sessionManagementCompositeTabs, toolkit));
		final TabItem messagesTab = new TabItem(this.sessionManagementCompositeTabs, SWT.NONE);
		messagesTab.setText(Messages.DashBoardPage_ManagementSection_Messages);
		messagesTab.setControl(createMessagesView(this.sessionManagementCompositeTabs, toolkit));
		GridDataFactory.fillDefaults().grab(true, true).span(1, 1).applyTo(this.sessionManagementCompositeTabs);

		final Composite actionComposite = toolkit.createComposite(sessionManagementComposite);
		GridDataFactory.fillDefaults().grab(false, true).span(1, 1).align(SWT.END, SWT.CENTER).applyTo(actionComposite);
		GridLayoutFactory.fillDefaults().numColumns(1).applyTo(actionComposite);

		final Label topDummyLabel = toolkit.createLabel(actionComposite, "Wait 99 alerts");
		topDummyLabel.setVisible(false);
		multiplyFontSize(topDummyLabel, 0.8);
		GridDataFactory.fillDefaults().grab(false, true).span(1, 1).align(SWT.CENTER, SWT.FILL).applyTo(topDummyLabel);
		this.connectIcon = toolkit.createClickableIconAndLabel(actionComposite, Activator.getDefault().getImage(Activator.START),
				Messages.DashBoardPage_ManagementSection_ConnectButton, true);
		GridDataFactory.fillDefaults().grab(false, true).span(1, 1).align(SWT.CENTER, SWT.FILL).applyTo(this.connectIcon);
		this.alertWaitingLabel = toolkit.createLabel(actionComposite, "");
		multiplyFontSize(this.alertWaitingLabel, 0.8);
		GridDataFactory.fillDefaults().grab(false, true).span(1, 1).align(SWT.CENTER, SWT.FILL).applyTo(this.alertWaitingLabel);
		final Label bottomDummyLabel = toolkit.createLabel(actionComposite, "Wait 99 alerts");
		bottomDummyLabel.setVisible(false);
		multiplyFontSize(bottomDummyLabel, 0.8);
		GridDataFactory.fillDefaults().grab(false, true).span(1, 1).align(SWT.CENTER, SWT.FILL).applyTo(bottomDummyLabel);

		sessionManagementSection.setClient(sessionManagementComposite);
		sessionManagementSection.setTextClient(sessionManagementToolBar);
	}

	private Control createCommandsView(Composite parent, ANWRTToolkit toolkit) {
		this.commandsViewTree = toolkit.createTree(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.SINGLE);
		this.commandsViewTree.setHeaderVisible(true);
		this.commandsViewTree.setLinesVisible(true);
		final TreeColumn sessionColumn = new TreeColumn(this.commandsViewTree, SWT.NONE);
		sessionColumn.setText(Messages.DashBoardPage_ManagementSection_Session);
		sessionColumn.setWidth(110);
		final TreeColumn serverColumn = new TreeColumn(this.commandsViewTree, SWT.NONE);
		serverColumn.setText(Messages.DashBoardPage_ManagementSection_Server);
		serverColumn.setWidth(325);
		final TreeColumn clientColumn = new TreeColumn(this.commandsViewTree, SWT.NONE);
		clientColumn.setText(Messages.DashBoardPage_ManagementSection_Client);
		clientColumn.setWidth(325);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(this.commandsViewTree);
		return this.commandsViewTree;
	}

	private Control createMessagesView(Composite parent, ANWRTToolkit toolkit) {
		final Composite messagesViewComposite = toolkit.createComposite(parent);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(messagesViewComposite);
		messagesViewComposite.setLayout(new FormLayout());

		final Sash sash = new Sash(messagesViewComposite, SWT.VERTICAL);
		sash.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				((FormData) sash.getLayoutData()).left = new FormAttachment(0, event.x);
				sash.getParent().layout();
			}

		});
		final FormData sashData = new FormData();
		sashData.top = new FormAttachment(0, 0);
		sashData.bottom = new FormAttachment(100, 0);
		sashData.left = new FormAttachment(25, 0);
		sash.setLayoutData(sashData);

		this.messagesViewTree = toolkit.createTree(messagesViewComposite, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.SINGLE);
		final FormData messagesViewTreeData = new FormData();
		messagesViewTreeData.top = new FormAttachment(0, 0);
		messagesViewTreeData.bottom = new FormAttachment(100, 0);
		messagesViewTreeData.left = new FormAttachment(0, 0);
		messagesViewTreeData.right = new FormAttachment(sash, 0);
		this.messagesViewTree.setLayoutData(messagesViewTreeData);

		this.messagesViewText = new StyledText(messagesViewComposite, SWT.BORDER | SWT.READ_ONLY | SWT.V_SCROLL);
		final FormData messagesViewTextData = new FormData();
		messagesViewTextData.top = new FormAttachment(0, 0);
		messagesViewTextData.bottom = new FormAttachment(100, 0);
		messagesViewTextData.left = new FormAttachment(sash, 0);
		messagesViewTextData.right = new FormAttachment(100, 0);
		this.messagesViewText.setLayoutData(messagesViewTextData);

		return messagesViewComposite;
	}

	@Override
	protected EmfMasterDetailBlock getMainMasterDetailBlock() {
		return this.masterDetail;
	}

	@Override
	public OMADMSimulatorEditor getEditor() {
		return (OMADMSimulatorEditor) super.getEditor();
	}

	Tree getCommandsViewTree() {
		return this.commandsViewTree;
	}

	Tree getMessagesViewTree() {
		return this.messagesViewTree;
	}

	ClickableIconAndLabel getConnectIcon() {
		return this.connectIcon;
	}

	void addGenericAlert(final DMGenericAlert genericAlert) {
		this.genericAlertsQueue.offer(genericAlert);
		updateAlertWaitingLabel();
	}

	DMGenericAlert pollGenericAlert() {
		final DMGenericAlert genericAlert = this.genericAlertsQueue.poll();
		updateAlertWaitingLabel();
		return genericAlert;
	}

	private void updateAlertWaitingLabel() {
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				final StringBuffer sb = new StringBuffer();
				final int size = genericAlertsQueue.size();
				if (size != 0) {
					sb.append("(").append(size).append(" alert");
					if (size > 1) {
						sb.append("s");
					}
					sb.append(" waiting)");
				}
				alertWaitingLabel.setText(sb.toString());
				alertWaitingLabel.getParent().layout();
			}

		});
	}

	private static void multiplyFontSize(final Control control, final double k) {
		final FontData[] fontData = control.getFont().getFontData();
		for (int i = 0; i < fontData.length; ++i) {
			fontData[i].setHeight((int) (fontData[i].getHeight() * k));
		}

		final Font newFont = new Font(control.getDisplay(), fontData);

		control.setFont(newFont);
		control.addDisposeListener(new DisposeListener() {

			@Override
			public void widgetDisposed(DisposeEvent e) {
				newFont.dispose();
			}

		});
	}
}
