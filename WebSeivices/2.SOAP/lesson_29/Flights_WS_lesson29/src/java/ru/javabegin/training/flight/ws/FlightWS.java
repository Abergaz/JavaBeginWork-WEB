package ru.javabegin.training.flight.ws;

import java.util.ArrayList;
import java.util.Calendar;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;
import ru.javabegin.training.flight.interfaces.impls.BuyImpl;
import ru.javabegin.training.flight.interfaces.impls.CheckImpl;
import ru.javabegin.training.flight.interfaces.impls.SearchImpl;
import ru.javabegin.training.flight.interfaces.sei.FlightSEI;
import ru.javabegin.training.flight.objects.Flight;
import ru.javabegin.training.flight.objects.Passenger;
import ru.javabegin.training.flight.objects.Reservation;
import ru.javabegin.training.flight.spr.objects.City;
import ru.javabegin.training.flight.spr.objects.Place;
import ru.javabegin.training.flight.utils.GMTCalendar;
import ru.javabegin.training.flight.ws.exceptions.CityEmptyException;

@MTOM
@WebService(endpointInterface = "ru.javabegin.training.flight.interfaces.sei.FlightSEI")
//@BindingType(value = SOAPBinding.SOAP12HTTP_MTOM_BINDING)
@HandlerChain(file = "FlightWS_handler.xml")
public class FlightWS implements FlightSEI {

    private SearchImpl searchImpl = new SearchImpl();
    private BuyImpl buyImpl = new BuyImpl();
    private CheckImpl checkImpl = new CheckImpl();    

    @Override
    public ArrayList<Flight> searchFlight(long date, City cityFrom, City cityTo) throws CityEmptyException{
        
        if (cityFrom == null){
            throw new CityEmptyException("CityFrom is empty");
        }
        

        if (cityTo == null){
            throw new CityEmptyException("CityTo is empty");
        }


        ArrayList<Flight> list = new ArrayList<>();
        Calendar c = GMTCalendar.getInstance();
        c.setTimeInMillis(date);

        list.addAll(searchImpl.searchFlight(date, cityFrom, cityTo));

        return list;
    }

    @Override
    public ArrayList<City> getAllCities() {
        ArrayList<City> list = new ArrayList<>();
        list.addAll(searchImpl.getAllCities());
        return list;
    }

    @Override
    public boolean buyTicket(Flight flight, Place place, Passenger passenger, String addInfo) {
        boolean result = false;

        result = buyImpl.buyTicket(flight, place, passenger, addInfo);

        return result;
    }

    @Override
    public Reservation checkReservationByCode(String code) {
        return checkImpl.checkReservationByCode(code);
    }
    
    
    
   
    
}
