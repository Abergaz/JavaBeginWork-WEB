package ru.javabegin.training.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TestGWT_5 implements EntryPoint {

	private VerticalPanel mainPanel = new VerticalPanel();

	private Button button1 = new Button("Button 1");
	private Button button2 = new Button("Button 2");
	private Button button3 = new Button("Button 3");

	@Override
	public void onModuleLoad() {

		button1.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				buttonClick(event.getSource().toString());
			}
		});

		button2.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				buttonClick(event.getSource().toString());
			}
		});

		button3.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				buttonClick(event.getSource().toString());
			}
		});

		button1.setStyleName("redButton");

		mainPanel.add(button1);
		mainPanel.add(button2);
		mainPanel.add(button3);

		RootPanel.get("mainContainer").add(mainPanel);

	}

	private void buttonClick(String source) {
		Window.alert(source);
	}

}
