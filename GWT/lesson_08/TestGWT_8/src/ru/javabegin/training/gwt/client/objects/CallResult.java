package ru.javabegin.training.gwt.client.objects;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CallResult implements Serializable {

	private String text;
	private int code;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
