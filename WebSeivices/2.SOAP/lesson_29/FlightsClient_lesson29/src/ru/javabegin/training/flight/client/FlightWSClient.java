package ru.javabegin.training.flight.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.javabegin.training.flight.object.ExtCity;
import ru.javabegin.training.flight.ws.City;
import ru.javabegin.training.flight.ws.CityEmptyException_Exception;
import ru.javabegin.training.flight.ws.Flight;
import ru.javabegin.training.flight.ws.FlightWS;
import ru.javabegin.training.flight.ws.FlightWSService;
import ru.javabegin.training.flight.ws.Passenger;
import ru.javabegin.training.flight.ws.Place;
import ru.javabegin.training.flight.ws.Reservation;

public class FlightWSClient {

    private static FlightWSClient flightClient;

    public static FlightWSClient getInstance() {
        if (flightClient == null) {
            flightClient = new FlightWSClient();
        }

        return flightClient;
    }
    private FlightWSService flightWSService;
    private FlightWS flightWS;

    private FlightWSClient() {
        flightWSService = new FlightWSService();
        flightWS = flightWSService.getFlightWSPort();
    }

    public ArrayList<ExtCity> getAllCities() {
        ArrayList<ExtCity> cityList = new ArrayList<>();
        
        for (City city : flightWS.getAllCities()) {
            ExtCity extCity = new ExtCity();
            extCity.setCode(city.getCode());
            extCity.setCountry(city.getCountry());
            extCity.setDesc(city.getDesc());
            extCity.setId(city.getId());
            extCity.setName(city.getName());
            cityList.add(extCity);
        }
        
        Collections.sort(cityList, new Comparator<City>() {
            @Override
            public int compare(City t, City t1) {
                return t.getName().compareTo(t1.getName());
            }
        });
        return cityList;
    }

    public ArrayList<Flight> searchFlight(long date, City cityFrom, City cityTo) {
        ArrayList<Flight> flightList = new ArrayList<>();
       
        try {
            flightList.addAll(flightWS.searchFlight(date, cityFrom, cityTo));
        } catch (CityEmptyException_Exception ex) {
            Logger.getLogger(FlightWSClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flightList;
    }

    public boolean buyTicket(Flight flight, Place place, Passenger passenger, String addInfo) {
        return flightWS.buyTicket(flight, place, passenger, addInfo);
    }


    public Reservation checkReservationByCode(String code){
        return flightWS.checkReservationByCode(code);
    }

}
