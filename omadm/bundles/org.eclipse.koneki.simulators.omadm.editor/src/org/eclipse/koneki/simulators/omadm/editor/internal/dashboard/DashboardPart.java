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

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.koneki.commons.ui.ANWRTToolkit;
import org.eclipse.koneki.protocols.omadm.DMGenericAlert;
import org.eclipse.koneki.simulators.omadm.editor.Messages;
import org.eclipse.koneki.simulators.omadm.editor.OMADMSimulatorEditor;
import org.eclipse.koneki.simulators.omadm.editor.internal.Activator;
import org.eclipse.koneki.simulators.omadm.model.Node;
import org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage;
import org.eclipse.pde.emfforms.editor.EmfDetailsPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.Section;

public class DashboardPart extends EmfDetailsPart {

	public DashboardPart(DashboardPage page) {
		super(page.getEditor());
		this.page = page;
	}

	@Override
	protected void createSpecificContent(Composite parent) {
		final ANWRTToolkit toolkit = ((OMADMSimulatorEditor) getEditor()).getANWRTToolkit();

		// Section
		final Section nodePropertiesSection = toolkit.createSection(parent, ExpandableComposite.TITLE_BAR);
		nodePropertiesSection.setText(Messages.PropertiesSection_Title);
		nodePropertiesSection.marginWidth = 5;
		nodePropertiesSection.marginHeight = 5;
		GridDataFactory.fillDefaults().grab(true, true).applyTo(nodePropertiesSection);
		final ToolBar nodePropertiesToolBar = new ToolBar(nodePropertiesSection, SWT.FLAT);

		// Composite
		final Composite nodePropertiesComposite = toolkit.createComposite(nodePropertiesSection);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(nodePropertiesComposite);

		// Name
		toolkit.createTitleLabel(nodePropertiesComposite, Messages.PropertiesSection_Title_Name);
		this.nameLabel = toolkit.createLabel(nodePropertiesComposite, null);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(this.nameLabel);

		// Format
		toolkit.createTitleLabel(nodePropertiesComposite, Messages.PropertiesSection_Title_Format);
		this.formatLabel = toolkit.createLabel(nodePropertiesComposite, null);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(this.formatLabel);

		// Type
		toolkit.createTitleLabel(nodePropertiesComposite, Messages.PropertiesSection_Title_Type);
		this.typeLabel = toolkit.createLabel(nodePropertiesComposite, null);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(this.typeLabel);

		// Data
		this.dataText = toolkit.createTitleLabelAndText(nodePropertiesComposite, Messages.PropertiesSection_Title_Data);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(this.dataText);
		this.monitoringToolItem = new ToolItem(nodePropertiesToolBar, SWT.PUSH);
		this.monitoringToolItem.setImage(Activator.getDefault().getImage(Activator.MONITORING_ALERT));
		this.monitoringToolItem.setToolTipText("Monitoring alert");
		this.monitoringToolItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(final SelectionEvent e) {
				final Node node = (Node) getCurrentSelection().getValue();
				page.addGenericAlert(new DMGenericAlert(node.getType(), node.getFormat().getLiteral(), "informational", node.getData(), null, node
						.getPath()));
			}

		});

		nodePropertiesSection.setClient(nodePropertiesComposite);
		nodePropertiesSection.setTextClient(nodePropertiesToolBar);
	}

	@Override
	protected void bind(DataBindingContext dataBindingContext) {
		final EditingDomain editingDomain = getEditingDomain();

		// Name
		dataBindingContext.bindValue(WidgetProperties.text().observe(this.nameLabel), EMFEditObservables.observeDetailValue(Realm.getDefault(),
				editingDomain, getCurrentSelection(), OMADMSimulatorPackage.Literals.NODE__NAME));

		// Format
		dataBindingContext.bindValue(WidgetProperties.text().observe(this.formatLabel), EMFEditObservables.observeDetailValue(Realm.getDefault(),
				editingDomain, getCurrentSelection(), OMADMSimulatorPackage.Literals.NODE__FORMAT));

		// Type
		dataBindingContext.bindValue(WidgetProperties.text().observe(this.typeLabel), EMFEditObservables.observeDetailValue(Realm.getDefault(),
				editingDomain, getCurrentSelection(), OMADMSimulatorPackage.Literals.NODE__TYPE));

		// Data
		dataBindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(this.dataText), EMFEditObservables.observeDetailValue(
				Realm.getDefault(), editingDomain, getCurrentSelection(), OMADMSimulatorPackage.Literals.NODE__DATA));

		// Monitoring
		dataBindingContext.bindValue(new AbstractObservableValue() {

			@Override
			public Object getValueType() {
				return Boolean.class;
			}

			@Override
			protected Object doGetValue() {
				return monitoringToolItem.isEnabled();
			}

			@Override
			protected void doSetValue(Object value) {
				monitoringToolItem.setEnabled((Boolean) value);
			}

		}, new ComputedValue() {

			@Override
			protected Object calculate() {
				if (getCurrentSelection() != null && getCurrentSelection().getValue() != null) {
					return ((Node) getCurrentSelection().getValue()).isLeaf();
				} else {
					return false;
				}
			}
		});
	}

	private final DashboardPage page;
	private Label nameLabel;
	private Label formatLabel;
	private Label typeLabel;
	private Text dataText;
	private ToolItem monitoringToolItem;
}
