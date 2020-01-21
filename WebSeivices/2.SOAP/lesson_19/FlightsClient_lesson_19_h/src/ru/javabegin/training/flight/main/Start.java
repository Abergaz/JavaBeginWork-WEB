package ru.javabegin.training.flight.main;

import java.util.ArrayList;
import ru.javabegin.training.flight.ws.City;
import ru.javabegin.training.flight.ws.Flight;
import ru.javabegin.training.flight.ws.FlightService;
import ru.javabegin.training.flight.ws.SearchImpl;

public class Start {

    public static void main(String[] args) {
        FlightService flightService = new FlightService();
        SearchImpl searchImpl = flightService.getSearchImplPort();

        ArrayList<City> cityList = new ArrayList<>();
        cityList.addAll(searchImpl.getAllCities());

        for (City city : cityList) {
            System.out.println(city.getName());
        }

        ArrayList<Flight> flightList = new ArrayList<>();



        flightList.addAll(searchImpl.searchFlight(1328191800000L, cityList.get(0), cityList.get(1)));

        for (Flight flight : flightList) {
            System.out.println(flight.getCode());
        }

    }
}
