package ru.javabegin.training.gwt.client;

import ru.javabegin.training.gwt.client.objects.CallInput;
import ru.javabegin.training.gwt.client.objects.CallResult;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("check")
public interface StringService extends RemoteService {
	CallResult checkString(CallInput input) throws Exception;
}
