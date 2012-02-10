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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.koneki.commons.ui.ANWRTToolkit;
import org.eclipse.koneki.commons.ui.dialogs.RoundedCornerBorderedComposite;
import org.eclipse.koneki.commons.ui.widgets.BorderedComposite;
import org.eclipse.koneki.commons.ui.widgets.InfoBanner;
import org.eclipse.koneki.simulators.omadm.editor.internal.Activator;
import org.eclipse.koneki.simulators.omadm.editor.internal.configuration.ConfigurationPage;
import org.eclipse.koneki.simulators.omadm.editor.internal.dashboard.DashboardPage;
import org.eclipse.koneki.simulators.omadm.editor.internal.simulation.SimulationPage;
import org.eclipse.koneki.simulators.omadm.model.OMADMSimulation;
import org.eclipse.koneki.simulators.omadm.model.util.OMADMSimulatorAdapterFactory;
import org.eclipse.pde.emfforms.editor.EmfFormEditor;
import org.eclipse.pde.emfforms.editor.IEmfFormEditorConfig;
import org.eclipse.pde.emfforms.editor.IEmfFormPage;
import org.eclipse.pde.emfforms.editor.PDEFormToolkit;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.part.FileEditorInput;

public class OMADMSimulatorEditor extends EmfFormEditor<OMADMSimulation> {
	private final ANWRTToolkit toolkit;

	public OMADMSimulatorEditor() {
		this.toolkit = new ANWRTToolkit(Display.getCurrent());
	}

	@Override
	protected AdapterFactory getSpecificAdapterFactory() {
		return new OMADMSimulatorAdapterFactory();
	}

	@Override
	protected List<? extends IEmfFormPage> getPagesToAdd() throws PartInitException {
		final List<IEmfFormPage> pages = new ArrayList<IEmfFormPage>();
		pages.add(new ConfigurationPage(this));
		pages.add(new SimulationPage(this));
		pages.add(new DashboardPage(this));
		return pages;
	}

	@Override
	protected List<Image> getPagesImages() {
		final List<Image> pagesImages = new ArrayList<Image>();
		pagesImages.add(Activator.getDefault().getImage(Activator.CONFIGUATION));
		pagesImages.add(Activator.getDefault().getImage(Activator.SIMULATION));
		pagesImages.add(Activator.getDefault().getImage(Activator.DASHBOARD));
		return pagesImages;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public IEmfFormEditorConfig<EmfFormEditor<OMADMSimulation>, OMADMSimulation> getEditorConfig() {
		// FIXME Need to override the adapt method from the PDEFormToolkit in order to avoid changing InfoBanner background. The adapt method should
		// be never called recursively on the Controls hierarchy.
		final OMADMSimulatorEditorConfig editorConfig = new OMADMSimulatorEditorConfig(this);
		editorConfig.setCustomizedToolkit(new PDEFormToolkit(Display.getDefault()) {

			@Override
			public void adapt(Composite composite) {
				if (composite instanceof ToolBar || composite instanceof InfoBanner || composite instanceof BorderedComposite
						|| composite instanceof Section || composite instanceof RoundedCornerBorderedComposite) {
					return;
				}
				super.adapt(composite);
			}

		});
		return (IEmfFormEditorConfig) editorConfig;
	}

	@Override
	public String getID() {
		return getClass().getName();
	}

	public IProject getProject() {
		return ((FileEditorInput) getEditorInput()).getFile().getProject();
	}

	public OMADMSimulation getOMADMSimulation() {
		return getCurrentEObject();
	}

	public ANWRTToolkit getANWRTToolkit() {
		return toolkit;
	}

}
