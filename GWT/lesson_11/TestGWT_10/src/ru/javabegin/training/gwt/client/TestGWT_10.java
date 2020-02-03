package ru.javabegin.training.gwt.client;

import ru.javabegin.training.gwt.client.objects.CallInput;
import ru.javabegin.training.gwt.client.objects.CallResult;
import ru.javabegin.training.gwt.validator.FieldVerifier;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TestGWT_10 implements EntryPoint, ClickHandler, KeyPressHandler {

	private StringServiceAsync stringService = GWT.create(StringService.class);

	private VerticalPanel mainPanel = new VerticalPanel();

	private Button button1 = new Button("Button 1");
	private TextBox textBox = new TextBox();
	private Label label = new Label();
	private Label labelResult = new Label();

	@Override
	public void onModuleLoad() {

		button1.addClickHandler(this);
		button1.setStyleName("redButton");

		textBox.addKeyPressHandler(this);

		label.setStyleName("counter");

		mainPanel.add(button1);
		mainPanel.add(textBox);
		mainPanel.add(label);
		mainPanel.add(labelResult);

		RootPanel.get("mainContainer").add(mainPanel);

	}

	@Override
	public void onClick(ClickEvent event) {

		if (!FieldVerifier.isValidName(textBox.getText())) {
			labelResult.setStyleName("error");
			labelResult.setText("Текст неверный");
			return;
		}

		CallInput callInput = new CallInput();
		callInput.setText(textBox.getText());

		stringService.checkString(callInput, new AsyncCallback<CallResult>() {

			@Override
			public void onSuccess(CallResult result) {
				labelResult.setStyleName("common");
				labelResult.setText(result.getText() + " (" + result.getCode() + ")");

			}

			@Override
			public void onFailure(Throwable caught) {
				labelResult.setStyleName("error");
				labelResult.setText(caught.getMessage());

			}
		});
	}

	@Override
	public void onKeyPress(KeyPressEvent event) {
		label.setText(String.valueOf(textBox.getText().trim().length()));
	}

}
