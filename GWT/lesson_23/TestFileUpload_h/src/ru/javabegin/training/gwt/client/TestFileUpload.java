/**
 * Sencha GXT 3.1.2 - Sencha for GWT
 * Copyright(c) 2007-2014, Sencha, Inc.
 * licensing@sencha.com
 *
 * http://www.sencha.com/products/gxt/license/
 */
package ru.javabegin.training.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FileUploadField;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import com.sencha.gxt.widget.core.client.form.FormPanel.Encoding;
import com.sencha.gxt.widget.core.client.form.FormPanel.Method;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.info.Info;

public class TestFileUpload implements IsWidget, EntryPoint {

	private static final String UPLOAD_ACTION_URL = GWT.getModuleBaseURL() + "upload";

	private FramedPanel panel;

	public Widget asWidget() {
		if (panel == null) {
			panel = new FramedPanel();
			panel.setHeading("File Upload Example");
			panel.setButtonAlign(BoxLayoutPack.CENTER);
			panel.setWidth(350);
			panel.setLayoutData(new MarginData(10));

			final FormPanel form = new FormPanel();
			form.setAction(UPLOAD_ACTION_URL);
			form.setEncoding(Encoding.MULTIPART);
			form.setMethod(Method.POST);
			panel.add(form);

			VerticalLayoutContainer p = new VerticalLayoutContainer();
			form.add(p, new MarginData(10));

			TextField firstName = new TextField();
			firstName.setAllowBlank(false);
			p.add(new FieldLabel(firstName, "Name"), new VerticalLayoutData(-18, -1));

			final FileUploadField file = new FileUploadField();
			file.addChangeHandler(new ChangeHandler() {

				@Override
				public void onChange(ChangeEvent event) {
					Info.display("File Changed", "You selected " + file.getValue());
				}
			});
			file.setName("uploadedfile");
			file.setAllowBlank(false);

			p.add(new FieldLabel(file, "File"), new VerticalLayoutData(-18, -1));

			TextButton btn = new TextButton("Reset");
			btn.addSelectHandler(new SelectHandler() {

				@Override
				public void onSelect(SelectEvent event) {
					form.reset();
					// TODO needs to be part of form panel, ie a Field interface
					file.reset();
				}
			});

			panel.addButton(btn);

			btn = new TextButton("Submit");
			btn.addSelectHandler(new SelectHandler() {

				@Override
				public void onSelect(SelectEvent event) {
					if (!form.isValid()) {
						return;
					}
					// normally would submit the form but for example no server set up to
					// handle the post
					form.submit();
					MessageBox box = new MessageBox("File Upload Example", "Your file was uploaded.");
					box.setIcon(MessageBox.ICONS.info());
					box.show();
				}
			});
			panel.addButton(btn);
		}
		return panel;
	}

	public void onModuleLoad() {
		RootPanel.get("sendButtonContainer").add(asWidget());
	}

}
