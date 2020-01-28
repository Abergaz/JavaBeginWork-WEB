package ru.javabegin.training.flight.ws.exceptions;

import javax.xml.ws.WebFault;


@WebFault
public class CityEmptyException extends Exception{
    
    

    public CityEmptyException(String string) {
        super(string);
    }
     
}
