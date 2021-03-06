
package ru.javabegin.training.flight.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SearchWS", targetNamespace = "http://ws.flight.training.javabegin.ru/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SearchWS {


    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<ru.javabegin.training.flight.ws.Flight>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "searchFlight", targetNamespace = "http://ws.flight.training.javabegin.ru/", className = "ru.javabegin.training.flight.ws.SearchFlight")
    @ResponseWrapper(localName = "searchFlightResponse", targetNamespace = "http://ws.flight.training.javabegin.ru/", className = "ru.javabegin.training.flight.ws.SearchFlightResponse")
    @Action(input = "http://ws.flight.training.javabegin.ru/SearchWS/searchFlightRequest", output = "http://ws.flight.training.javabegin.ru/SearchWS/searchFlightResponse")
    public List<Flight> searchFlight(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        City arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        City arg2);

    /**
     * 
     * @return
     *     returns java.util.List<ru.javabegin.training.flight.ws.City>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllCities", targetNamespace = "http://ws.flight.training.javabegin.ru/", className = "ru.javabegin.training.flight.ws.GetAllCities")
    @ResponseWrapper(localName = "getAllCitiesResponse", targetNamespace = "http://ws.flight.training.javabegin.ru/", className = "ru.javabegin.training.flight.ws.GetAllCitiesResponse")
    @Action(input = "http://ws.flight.training.javabegin.ru/SearchWS/getAllCitiesRequest", output = "http://ws.flight.training.javabegin.ru/SearchWS/getAllCitiesResponse")
    public List<City> getAllCities();

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buyTicket", targetNamespace = "http://ws.flight.training.javabegin.ru/", className = "ru.javabegin.training.flight.ws.BuyTicket")
    @ResponseWrapper(localName = "buyTicketResponse", targetNamespace = "http://ws.flight.training.javabegin.ru/", className = "ru.javabegin.training.flight.ws.BuyTicketResponse")
    @Action(input = "http://ws.flight.training.javabegin.ru/SearchWS/buyTicketRequest", output = "http://ws.flight.training.javabegin.ru/SearchWS/buyTicketResponse")
    public boolean buyTicket(
        @WebParam(name = "arg0", targetNamespace = "")
        Flight arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Place arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        Passenger arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3);

    /**
     * 
     * @param arg0
     * @return
     *     returns ru.javabegin.training.flight.ws.Reservation
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkReservationByCode", targetNamespace = "http://ws.flight.training.javabegin.ru/", className = "ru.javabegin.training.flight.ws.CheckReservationByCode")
    @ResponseWrapper(localName = "checkReservationByCodeResponse", targetNamespace = "http://ws.flight.training.javabegin.ru/", className = "ru.javabegin.training.flight.ws.CheckReservationByCodeResponse")
    @Action(input = "http://ws.flight.training.javabegin.ru/SearchWS/checkReservationByCodeRequest", output = "http://ws.flight.training.javabegin.ru/SearchWS/checkReservationByCodeResponse")
    public Reservation checkReservationByCode(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
