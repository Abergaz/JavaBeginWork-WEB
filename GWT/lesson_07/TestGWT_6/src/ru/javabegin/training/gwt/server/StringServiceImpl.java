package ru.javabegin.training.gwt.server;

import ru.javabegin.training.gwt.client.StringService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class StringServiceImpl extends RemoteServiceServlet implements StringService {

	public String checkString(String input) {
		System.out.println("input = " + input);
		return "Hello text:" + input;
	}

}
