package ru.javabegin.training.flight.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import ru.javabegin.training.flight.ws.City;
import ru.javabegin.training.flight.ws.Flight;
import ru.javabegin.training.flight.ws.Passenger;
import ru.javabegin.training.flight.ws.Place;
import ru.javabegin.training.flight.ws.Reservation;
import ru.javabegin.training.flight.ws.SearchWS;
import ru.javabegin.training.flight.ws.SearchWS_Service;

public class SearchClient {

    private static SearchClient searchClient;

    public static SearchClient getInstance() {
        if (searchClient == null) {
            searchClient = new SearchClient();
        }

        return searchClient;
    }
    private SearchWS_Service searchService;
    private SearchWS searchWS;

    public SearchClient() {
        searchService = new SearchWS_Service();
        searchWS = searchService.getSearchWSPort();
    }

    public ArrayList<City> getAllCities() {
        ArrayList<City> cityList = new ArrayList<>();
        
        for (City city : searchWS.getAllCities()) {
            City extCity = new City();
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
        flightList.addAll(searchWS.searchFlight(date, cityFrom, cityTo));
        return flightList;
    }

    
}
