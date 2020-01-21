package ru.javabegin.training.flight.interfaces.impls;

import ru.javabegin.training.flight.interfaces.Buy;
import ru.javabegin.training.flight.objects.Flight;
import ru.javabegin.training.flight.objects.Reservation;
import ru.javabegin.training.flight.spr.objects.Place;



public class BuyImpl implements Buy{

    @Override
    public Reservation buyTicket(Flight flight, Place place, String addInfo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
