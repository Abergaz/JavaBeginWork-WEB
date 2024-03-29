
package ru.javabegin.training.webservices.testws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "TestWS", targetNamespace = "http://testservice.webservices.training.javabegin.ru/", wsdlLocation = "http://localhost:8080/WS_Server/TestWS?WSDL")
public class TestWS_Service
    extends Service
{

    private final static URL TESTWS_WSDL_LOCATION;
    private final static WebServiceException TESTWS_EXCEPTION;
    private final static QName TESTWS_QNAME = new QName("http://testservice.webservices.training.javabegin.ru/", "TestWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/WS_Server/TestWS?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TESTWS_WSDL_LOCATION = url;
        TESTWS_EXCEPTION = e;
    }

    public TestWS_Service() {
        super(__getWsdlLocation(), TESTWS_QNAME);
    }

    public TestWS_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), TESTWS_QNAME, features);
    }

    public TestWS_Service(URL wsdlLocation) {
        super(wsdlLocation, TESTWS_QNAME);
    }

    public TestWS_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TESTWS_QNAME, features);
    }

    public TestWS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TestWS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns TestWS
     */
    @WebEndpoint(name = "TestWSPort")
    public TestWS getTestWSPort() {
        return super.getPort(new QName("http://testservice.webservices.training.javabegin.ru/", "TestWSPort"), TestWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TestWS
     */
    @WebEndpoint(name = "TestWSPort")
    public TestWS getTestWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://testservice.webservices.training.javabegin.ru/", "TestWSPort"), TestWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TESTWS_EXCEPTION!= null) {
            throw TESTWS_EXCEPTION;
        }
        return TESTWS_WSDL_LOCATION;
    }

}
