package ru.javabegin.training.gwt.client;

import ru.javabegin.training.gwt.client.objects.CallInput;
import ru.javabegin.training.gwt.client.objects.CallResult;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface StringServiceAsync {

	void checkString(CallInput input, AsyncCallback<CallResult> callback);

}
