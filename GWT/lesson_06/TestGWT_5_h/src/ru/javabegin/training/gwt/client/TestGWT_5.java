package ru.javabegin.training.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TestGWT_5 implements EntryPoint, ClickHandler, KeyPressHandler {

	private VerticalPanel mainPanel = new VerticalPanel();

	private Button button1 = new Button("Button 1");
	private TextBox textBox = new TextBox();
	private Label label = new Label();

	@Override
	public void onModuleLoad() {

		button1.addClickHandler(this);
		button1.setStyleName("redButton");

		textBox.addKeyPressHandler(this);

		label.setStyleName("counter");

		mainPanel.add(button1);
		mainPanel.add(textBox);
		mainPanel.add(label);

		RootPanel.get("mainContainer").add(mainPanel);

	}

	@Override
	public void onClick(ClickEvent event) {
		Window.alert(event.getSource().toString());
	}

	@Override
	public void onKeyPress(KeyPressEvent event) {
		label.setText(String.valueOf(textBox.getText().trim().length()));
	}

}
