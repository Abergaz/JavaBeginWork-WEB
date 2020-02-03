package ru.javabegin.training.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface StringServiceAsync {

	void checkString(String text, AsyncCallback<String> callback);

}
