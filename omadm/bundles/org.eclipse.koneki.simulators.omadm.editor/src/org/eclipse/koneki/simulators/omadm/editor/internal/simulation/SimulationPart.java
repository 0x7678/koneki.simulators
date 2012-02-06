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

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.koneki.commons.ui.ANWRTToolkit;
import org.eclipse.koneki.protocols.omadm.StatusCode;
import org.eclipse.koneki.simulators.omadm.editor.Messages;
import org.eclipse.koneki.simulators.omadm.editor.OMADMSimulatorEditor;
import org.eclipse.koneki.simulators.omadm.model.CommandManagement;
import org.eclipse.koneki.simulators.omadm.model.NodeFormat;
import org.eclipse.koneki.simulators.omadm.model.OMADMSimulatorPackage;
import org.eclipse.pde.emfforms.editor.EmfDetailsPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.Section;

//import com.anwrt.platform.ui.editors.internal.actions.RestartEditorAction;

public class SimulationPart extends EmfDetailsPart {

	public SimulationPart(OMADMSimulatorEditor parentEditor) {
		super(parentEditor);
	}

	@Override
	protected void createSpecificContent(Composite parent) {
		final ANWRTToolkit toolkit = ((OMADMSimulatorEditor) getEditor()).getANWRTToolkit();

		createNodePropertiesSection(parent, toolkit);
		createNodeManagementSection(parent, toolkit);

	}

	private void createNodePropertiesSection(Composite parent, ANWRTToolkit toolkit) {
		// Section
		final Section nodePropertiesSection = toolkit.createSection(parent, ExpandableComposite.TITLE_BAR);
		nodePropertiesSection.setText(Messages.PropertiesSection_Title);
		nodePropertiesSection.marginWidth = 5;
		nodePropertiesSection.marginHeight = 5;
		GridDataFactory.fillDefaults().grab(true, true).applyTo(nodePropertiesSection);

		// Composite
		final Composite nodePropertiesComposite = toolkit.createComposite(nodePropertiesSection);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(nodePropertiesComposite);

		// Name
		this.nameText = toolkit.createTitleLabelAndText(nodePropertiesComposite, Messages.PropertiesSection_Title_Name);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(this.nameText);

		// Format
		this.formatCombo = toolkit.createTitleLabelAndComboViewer(nodePropertiesComposite, Messages.PropertiesSection_Title_Format, SWT.READ_ONLY);
		this.formatCombo.setInput(NodeFormat.VALUES);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(this.formatCombo.getCombo());

		// Type
		this.typeText = toolkit.createTitleLabelAndText(nodePropertiesComposite, Messages.PropertiesSection_Title_Type);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(this.typeText);

		// Data
		this.dataText = toolkit.createTitleLabelAndText(nodePropertiesComposite, Messages.PropertiesSection_Title_Data);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(this.dataText);

		nodePropertiesSection.setClient(nodePropertiesComposite);
	}

	private void createNodeManagementSection(Composite parent, ANWRTToolkit toolkit) {
		// Section
		final Section nodeManagementSection = toolkit.createSection(parent, ExpandableComposite.TITLE_BAR);
		nodeManagementSection.setText(Messages.NodeManagementSection_Title);
		nodeManagementSection.marginWidth = 5;
		nodeManagementSection.marginHeight = 5;
		GridDataFactory.fillDefaults().grab(true, true).applyTo(nodeManagementSection);

		// Composite
		final Composite nodeManagementComposite = toolkit.createComposite(nodeManagementSection);
		GridLayoutFactory.fillDefaults().numColumns(3).applyTo(nodeManagementComposite);

		// Get
		this.getManagementCombo = toolkit.createTitleLabelAndComboViewer(nodeManagementComposite, Messages.NodeManagementSection_Get, SWT.READ_ONLY);
		this.getManagementCombo.setInput(CommandManagement.VALUES);
		GridDataFactory.fillDefaults().grab(false, false).span(1, 1).applyTo(this.getManagementCombo.getCombo());
		this.getCodeCombo = toolkit.createComboViewer(nodeManagementComposite, SWT.READ_ONLY);
		this.getCodeCombo.setInput(StatusCode.GET_CODES);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(this.getCodeCombo.getCombo());

		// Add
		this.addManagementCombo = toolkit.createTitleLabelAndComboViewer(nodeManagementComposite, Messages.NodeManagementSection_Add, SWT.READ_ONLY);
		this.addManagementCombo.setInput(CommandManagement.VALUES);
		GridDataFactory.fillDefaults().grab(false, false).span(1, 1).applyTo(this.addManagementCombo.getCombo());
		this.addCodeCombo = toolkit.createComboViewer(nodeManagementComposite, SWT.READ_ONLY);
		this.addCodeCombo.setInput(StatusCode.ADD_CODES);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(this.addCodeCombo.getCombo());

		// Delete
		this.deleteManagementCombo = toolkit.createTitleLabelAndComboViewer(nodeManagementComposite, Messages.NodeManagementSection_Delete,
				SWT.READ_ONLY);
		this.deleteManagementCombo.setInput(CommandManagement.VALUES);
		GridDataFactory.fillDefaults().grab(false, false).span(1, 1).applyTo(this.deleteManagementCombo.getCombo());
		this.deleteCodeCombo = toolkit.createComboViewer(nodeManagementComposite, SWT.READ_ONLY);
		this.deleteCodeCombo.setInput(StatusCode.DELETE_CODES);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(this.deleteCodeCombo.getCombo());

		// Copy
		this.copyManagementCombo = toolkit
				.createTitleLabelAndComboViewer(nodeManagementComposite, Messages.NodeManagementSection_Copy, SWT.READ_ONLY);
		this.copyManagementCombo.setInput(CommandManagement.VALUES);
		GridDataFactory.fillDefaults().grab(false, false).span(1, 1).applyTo(this.copyManagementCombo.getCombo());
		this.copyCodeCombo = toolkit.createComboViewer(nodeManagementComposite, SWT.READ_ONLY);
		this.copyCodeCombo.setInput(StatusCode.COPY_CODES);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(this.copyCodeCombo.getCombo());

		// Replace
		this.replaceManagementCombo = toolkit.createTitleLabelAndComboViewer(nodeManagementComposite, Messages.NodeManagementSection_Replace,
				SWT.READ_ONLY);
		this.replaceManagementCombo.setInput(CommandManagement.VALUES);
		GridDataFactory.fillDefaults().grab(false, false).span(1, 1).applyTo(this.replaceManagementCombo.getCombo());
		this.replaceCodeCombo = toolkit.createComboViewer(nodeManagementComposite, SWT.READ_ONLY);
		this.replaceCodeCombo.setInput(StatusCode.REPLACE_CODES);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(this.replaceCodeCombo.getCombo());

		// Exec
		this.execManagementCombo = toolkit
				.createTitleLabelAndComboViewer(nodeManagementComposite, Messages.NodeManagementSection_Exec, SWT.READ_ONLY);
		this.execManagementCombo.setInput(CommandManagement.VALUES);
		GridDataFactory.fillDefaults().grab(false, false).span(1, 1).applyTo(this.execManagementCombo.getCombo());
		this.execCodeCombo = toolkit.createComboViewer(nodeManagementComposite, SWT.READ_ONLY);
		this.execCodeCombo.setInput(StatusCode.EXEC_CODES);
		GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(this.execCodeCombo.getCombo());

		nodeManagementSection.setClient(nodeManagementComposite);
	}

	@Override
	protected void bind(DataBindingContext dataBindingContext) {
		final EditingDomain editingDomain = getEditingDomain();

		bindNodePropertiesSection(dataBindingContext, editingDomain);
		bindNodeManagementSection(dataBindingContext, editingDomain);
		// bindAssociationSection(dataBindingContext, editingDomain);
		hookListener();
	}

	// private void bindAssociationSection(DataBindingContext dataBindingContext, EditingDomain editingDomain) {
	// dataBindingContext.bindValue(WidgetProperties.text(SWT.BUTTON1).observe(this.associateModelButton), EMFEditObservables.observeDetailValue(
	// Realm.getDefault(), editingDomain, getCurrentSelection(), OMADMSimulatorPackage.Literals.DEVICE__TREE));
	// }

	private void bindNodePropertiesSection(DataBindingContext dataBindingContext, EditingDomain editingDomain) {
		// Name
		dataBindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(this.nameText), EMFEditObservables.observeDetailValue(
				Realm.getDefault(), editingDomain, getCurrentSelection(), OMADMSimulatorPackage.Literals.NODE__NAME));

		// Format
		dataBindingContext.bindValue(WidgetProperties.selection().observe(this.formatCombo.getCombo()), EMFEditObservables.observeDetailValue(
				Realm.getDefault(), editingDomain, getCurrentSelection(), OMADMSimulatorPackage.Literals.NODE__FORMAT));

		// Type
		dataBindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(this.typeText), EMFEditObservables.observeDetailValue(
				Realm.getDefault(), editingDomain, getCurrentSelection(), OMADMSimulatorPackage.Literals.NODE__TYPE));

		// Data
		dataBindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(this.dataText), EMFEditObservables.observeDetailValue(
				Realm.getDefault(), editingDomain, getCurrentSelection(), OMADMSimulatorPackage.Literals.NODE__DATA));
	}

	private void bindNodeManagementSection(DataBindingContext dataBindingContext, EditingDomain editingDomain) {
		final UpdateValueStrategy targetToModel = new UpdateValueStrategy() {

			@Override
			public Object convert(Object value) {
				return Integer.parseInt(((String) value).split(" ")[0]); //$NON-NLS-1$
			}

		};
		final UpdateValueStrategy modelToTarget = new UpdateValueStrategy() {

			@Override
			public Object convert(Object value) {
				return StatusCode.fromInt((Integer) value).toString();
			}

		};

		// Get
		final IChangeListener getChangeListener = new ManagementChangeListener(this.getManagementCombo, this.getCodeCombo);
		dataBindingContext
				.bindValue(
						WidgetProperties.selection().observe(this.getManagementCombo.getCombo()),
						EMFEditObservables.observeDetailValue(Realm.getDefault(), editingDomain, getCurrentSelection(),
								OMADMSimulatorPackage.Literals.NODE__GET_MANAGEMENT)).getTarget().addChangeListener(getChangeListener);
		dataBindingContext.bindValue(WidgetProperties.selection().observe(this.getCodeCombo.getCombo()), EMFEditObservables.observeDetailValue(
				Realm.getDefault(), editingDomain, getCurrentSelection(), OMADMSimulatorPackage.Literals.NODE__GET_CODE), targetToModel,
				modelToTarget);

		// Add
		final IChangeListener addChangeListener = new ManagementChangeListener(this.addManagementCombo, this.addCodeCombo);
		dataBindingContext
				.bindValue(
						WidgetProperties.selection().observe(this.addManagementCombo.getCombo()),
						EMFEditObservables.observeDetailValue(Realm.getDefault(), editingDomain, getCurrentSelection(),
								OMADMSimulatorPackage.Literals.NODE__ADD_MANAGEMENT)).getTarget().addChangeListener(addChangeListener);
		dataBindingContext.bindValue(WidgetProperties.selection().observe(this.addCodeCombo.getCombo()), EMFEditObservables.observeDetailValue(
				Realm.getDefault(), editingDomain, getCurrentSelection(), OMADMSimulatorPackage.Literals.NODE__ADD_CODE), targetToModel,
				modelToTarget);

		// Delete
		final IChangeListener deleteChangeListener = new ManagementChangeListener(this.deleteManagementCombo, this.deleteCodeCombo);
		dataBindingContext
				.bindValue(
						WidgetProperties.selection().observe(this.deleteManagementCombo.getCombo()),
						EMFEditObservables.observeDetailValue(Realm.getDefault(), editingDomain, getCurrentSelection(),
								OMADMSimulatorPackage.Literals.NODE__DELETE_MANAGEMENT)).getTarget().addChangeListener(deleteChangeListener);
		dataBindingContext.bindValue(WidgetProperties.selection().observe(this.deleteCodeCombo.getCombo()), EMFEditObservables.observeDetailValue(
				Realm.getDefault(), editingDomain, getCurrentSelection(), OMADMSimulatorPackage.Literals.NODE__DELETE_CODE), targetToModel,
				modelToTarget);

		// Copy
		final IChangeListener copyChangeListener = new ManagementChangeListener(this.copyManagementCombo, this.copyCodeCombo);
		dataBindingContext
				.bindValue(
						WidgetProperties.selection().observe(this.copyManagementCombo.getCombo()),
						EMFEditObservables.observeDetailValue(Realm.getDefault(), editingDomain, getCurrentSelection(),
								OMADMSimulatorPackage.Literals.NODE__COPY_MANAGEMENT)).getTarget().addChangeListener(copyChangeListener);
		dataBindingContext.bindValue(WidgetProperties.selection().observe(this.copyCodeCombo.getCombo()), EMFEditObservables.observeDetailValue(
				Realm.getDefault(), editingDomain, getCurrentSelection(), OMADMSimulatorPackage.Literals.NODE__COPY_CODE), targetToModel,
				modelToTarget);

		// Replace
		final IChangeListener replaceChangeListener = new ManagementChangeListener(this.replaceManagementCombo, this.replaceCodeCombo);
		dataBindingContext
				.bindValue(
						WidgetProperties.selection().observe(this.replaceManagementCombo.getCombo()),
						EMFEditObservables.observeDetailValue(Realm.getDefault(), editingDomain, getCurrentSelection(),
								OMADMSimulatorPackage.Literals.NODE__REPLACE_MANAGEMENT)).getTarget().addChangeListener(replaceChangeListener);
		dataBindingContext.bindValue(WidgetProperties.selection().observe(this.replaceCodeCombo.getCombo()), EMFEditObservables.observeDetailValue(
				Realm.getDefault(), editingDomain, getCurrentSelection(), OMADMSimulatorPackage.Literals.NODE__REPLACE_CODE), targetToModel,
				modelToTarget);

		// Exec
		final IChangeListener execChangeListener = new ManagementChangeListener(this.execManagementCombo, this.execCodeCombo);
		dataBindingContext
				.bindValue(
						WidgetProperties.selection().observe(this.execManagementCombo.getCombo()),
						EMFEditObservables.observeDetailValue(Realm.getDefault(), editingDomain, getCurrentSelection(),
								OMADMSimulatorPackage.Literals.NODE__EXEC_MANAGEMENT)).getTarget().addChangeListener(execChangeListener);
		dataBindingContext.bindValue(WidgetProperties.selection().observe(this.execCodeCombo.getCombo()), EMFEditObservables.observeDetailValue(
				Realm.getDefault(), editingDomain, getCurrentSelection(), OMADMSimulatorPackage.Literals.NODE__EXEC_CODE), targetToModel,
				modelToTarget);
	}

	private void hookListener() {
		new ManagementChangeListener(this.getManagementCombo, this.getCodeCombo);
	}

	private Text nameText;
	private ComboViewer formatCombo;
	private Text typeText;
	private Text dataText;
	private ComboViewer getManagementCombo;
	private ComboViewer getCodeCombo;
	private ComboViewer addManagementCombo;
	private ComboViewer addCodeCombo;
	private ComboViewer deleteManagementCombo;
	private ComboViewer deleteCodeCombo;
	private ComboViewer copyManagementCombo;
	private ComboViewer copyCodeCombo;
	private ComboViewer replaceManagementCombo;
	private ComboViewer replaceCodeCombo;
	private ComboViewer execManagementCombo;
	private ComboViewer execCodeCombo;

	private static class ManagementChangeListener implements IChangeListener {

		public ManagementChangeListener(final ComboViewer managementCombo, final ComboViewer codeCombo) {
			this.managementCombo = managementCombo;
			this.codeCombo = codeCombo;
		}

		@Override
		public void handleChange(final ChangeEvent event) {
			this.codeCombo.getCombo().setEnabled(
					((StructuredSelection) this.managementCombo.getSelection()).getFirstElement() == CommandManagement.CONSTANT);
		}

		private final ComboViewer managementCombo;
		private final ComboViewer codeCombo;

	}

}
