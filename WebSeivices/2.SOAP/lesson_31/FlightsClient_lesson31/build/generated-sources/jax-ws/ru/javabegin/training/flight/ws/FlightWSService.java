
package ru.javabegin.training.flight.ws;

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
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "FlightWSService", targetNamespace = "http://ws.flight.training.javabegin.ru/", wsdlLocation = "http://localhost:8080/Flights_WS_lesson31/FlightWSService?WSDL")
public class FlightWSService
    extends Service
{

    private final static URL FLIGHTWSSERVICE_WSDL_LOCATION;
    private final static WebServiceException FLIGHTWSSERVICE_EXCEPTION;
    private final static QName FLIGHTWSSERVICE_QNAME = new QName("http://ws.flight.training.javabegin.ru/", "FlightWSService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/Flights_WS_lesson31/FlightWSService?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FLIGHTWSSERVICE_WSDL_LOCATION = url;
        FLIGHTWSSERVICE_EXCEPTION = e;
    }

    public FlightWSService() {
        super(__getWsdlLocation(), FLIGHTWSSERVICE_QNAME);
    }

    public FlightWSService(WebServiceFeature... features) {
        super(__getWsdlLocation(), FLIGHTWSSERVICE_QNAME, features);
    }

    public FlightWSService(URL wsdlLocation) {
        super(wsdlLocation, FLIGHTWSSERVICE_QNAME);
    }

    public FlightWSService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FLIGHTWSSERVICE_QNAME, features);
    }

    public FlightWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FlightWSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns FlightWS
     */
    @WebEndpoint(name = "FlightWSPort")
    public FlightWS getFlightWSPort() {
        return super.getPort(new QName("http://ws.flight.training.javabegin.ru/", "FlightWSPort"), FlightWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FlightWS
     */
    @WebEndpoint(name = "FlightWSPort")
    public FlightWS getFlightWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.flight.training.javabegin.ru/", "FlightWSPort"), FlightWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FLIGHTWSSERVICE_EXCEPTION!= null) {
            throw FLIGHTWSSERVICE_EXCEPTION;
        }
        return FLIGHTWSSERVICE_WSDL_LOCATION;
    }

}