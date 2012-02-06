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
package org.eclipse.koneki.simulators.omadm.editor.dialogs;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.koneki.commons.ui.Activator;

public class ApplicationModelFilter extends ViewerFilter {
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		boolean result = false;

		if (element instanceof IFile) {
			try {

				IFile file = (IFile) element;
				/*
				 * TODO change the checking of the application model content type
				 */
				result = getContentType(file).equals("com.swir.avop.application.ApplicationModel");

			} catch (IOException e) {
				Activator.log(e);
			} catch (CoreException e) {
				Activator.log(e);
			}
		}

		return result;
	}

	private String getContentType(IFile file) throws IOException, CoreException {
		IContentType contentType = null;
		if (file.isAccessible()) {
			contentType = Platform.getContentTypeManager().findContentTypeFor(file.getContents(true), file.getName());
		}
		return contentType != null ? contentType.getId() : null;
	}

}