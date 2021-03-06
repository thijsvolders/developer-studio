/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.security.project.ui.form;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.IFormPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.wst.sse.ui.StructuredTextEditor;
import org.wso2.developerstudio.eclipse.artifact.security.utils.SecurityFormMessageConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.security.Activator;

public class SecurityFormEditor extends FormEditor {

	private static final IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static final String SECURITY_DESIGN_VIEW = "Design";
	private static final String SECURITY_SOURCE_VIEW = "Source";

	private SecurityFormPage formPage;
	private File file;
	private IProject project;
	private boolean isDesignDirty;
	private boolean isSourceDirty;
	private StructuredTextEditor sourceEditor;
	private int formEditorIndex;
	private int sourceEditorIndex;
	private Display display;

	/**
	 * Initializes the security form editor
	 * 
	 * @throws PartInitException
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);

		file = getFile().getLocation().toFile();
		project = getFile().getProject();
		setPartName(getFile().getName());
		display = Display.getCurrent();
	}

	@Override
	protected void addPages() {
		formPage = new SecurityFormPage(this, Activator.PLUGIN_ID, SECURITY_DESIGN_VIEW, project, file, display);
		sourceEditor = new StructuredTextEditor();
		sourceEditor.setEditorPart(this);

		try {
			formEditorIndex = addPage(formPage);
			sourceEditorIndex = addPage(sourceEditor, getEditorInput());

		} catch (PartInitException e) {
			log.error("Cannot initialize SecurityDashboard page", e);
			MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
			msg.setMessage(SecurityFormMessageConstants.MESSAGE_FORM_LOAD_ERROR);
			msg.open();
		}

		setPageText(sourceEditorIndex, SECURITY_SOURCE_VIEW);
		getDocument().addDocumentListener(new IDocumentListener() {
			public void documentAboutToBeChanged(final DocumentEvent event) {
			}

			public void documentChanged(final DocumentEvent event) {
				isSourceDirty = true;
				updateDirtyState();
			}
		});
	}

	private IDocument getDocument() {
		final IDocumentProvider provider = sourceEditor.getDocumentProvider();
		return provider.getDocument(getEditorInput());
	}

	@Override
	public void doSave(IProgressMonitor pm) {
		if (isDesignDirty) {
			formPage.doPageSave();
			isSourceDirty = false;
			isDesignDirty = false;
			updateDirtyState();

		} else if (isSourceDirty) {
			isSourceDirty = false;
			isDesignDirty = false;

			InputStream content = new ByteArrayInputStream(getDocument().get().getBytes());
			try {
				getFile().setContents(content, true, true, null);
				content.close();
				formPage.RefreshProject();
			} catch (CoreException | IOException e) {
				log.error("Error in loading the Editor when deserializing", e);
				MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
				msg.setMessage(SecurityFormMessageConstants.MESSAGE_LOAD_UI_ERROR);
				msg.open();
			}
			formPage.updateUI(getDocument().get());
			updateDirtyState();

		}
	}

	private IFile getFile() {
		final IEditorInput input = getEditorInput();
		if (input instanceof FileEditorInput)
			return ((FileEditorInput) input).getFile();
		return null;
	}

	public StructuredTextEditor getSourceEditor() {
		return sourceEditor;
	}

	@Override
	protected void pageChange(int newPageIndex) {

		if (newPageIndex == sourceEditorIndex) {
			String content = formPage.doSourceUpdate();
			getDocument().set(content);
			isSourceDirty = false;
			updateDirtyState();
		} else if (newPageIndex == formEditorIndex) {
			String xmlSource = getDocument().get();
			formPage.updateUI(xmlSource);
			updateDirtyState();
		}
		super.pageChange(newPageIndex);
		final IFormPage page = getActivePageInstance();
		if (page != null) {
			page.setFocus();
		}
	}

	@Override
	public void doSaveAs() {
		 formPage.doPageSave();
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	public void updateDirtyState() {
		isDesignDirty = formPage.isDirty();
		firePropertyChange(PROP_DIRTY);
		editorDirtyStateChanged();
	}

	public boolean isDirty() {
		return isDesignDirty || isSourceDirty;
	}

	public void setDirty(boolean isDirty) {
		this.isDesignDirty = isDirty;
	}

}