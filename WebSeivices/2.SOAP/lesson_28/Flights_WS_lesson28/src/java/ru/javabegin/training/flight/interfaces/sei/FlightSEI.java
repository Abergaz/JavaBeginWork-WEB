package ru.javabegin.training.flight.interfaces.sei;

import java.util.ArrayList;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import ru.javabegin.training.flight.objects.Flight;
import ru.javabegin.training.flight.objects.Passenger;
import ru.javabegin.training.flight.objects.Reservation;
import ru.javabegin.training.flight.spr.objects.City;
import ru.javabegin.training.flight.spr.objects.Place;



@WebService(name="FlightWS", targetNamespace = "http://javabegin.ru/training/ws")
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL)
public interface FlightSEI{
    
    Reservation checkReservationByCode(@WebParam(name = "code") String code);

    ArrayList<City> getAllCities();

    ArrayList<Flight> searchFlight(@WebParam(name = "date") long date, @WebParam(name = "cityFrom") City cityFrom, @WebParam(name = "cityTo") City cityTo);
   
    boolean buyTicket(@WebParam(name = "flight") Flight flight, @WebParam(name = "place") Place place, @WebParam(name = "passenger") Passenger passenger, @WebParam(name = "addInfo") String addInfo);

}
