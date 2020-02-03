package ru.javabegin.training.gwt.server;

import ru.javabegin.training.gwt.client.StringService;
import ru.javabegin.training.gwt.client.objects.CallInput;
import ru.javabegin.training.gwt.client.objects.CallResult;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class StringServiceImpl extends RemoteServiceServlet implements StringService {

	public CallResult checkString(CallInput input) throws Exception {

		CallResult callResult = new CallResult();
		callResult.setText("Hello text:" + input.getText());
		callResult.setCode(1);

		if (input.getText().length() < 5) {
			throw new Exception("Length < 5");
		}

		return callResult;
	}

}
