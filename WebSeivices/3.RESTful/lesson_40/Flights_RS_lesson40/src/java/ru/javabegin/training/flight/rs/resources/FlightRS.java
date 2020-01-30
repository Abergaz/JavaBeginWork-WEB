package ru.javabegin.training.flight.rs.resources;

import java.net.ProxySelector;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ru.javabegin.training.flight.interfaces.impls.SearchImpl;
import ru.javabegin.training.flight.rs.resources.objects.CityList;
import ru.javabegin.training.flight.spr.objects.City;
import ru.javabegin.training.flight.ws.proxy.CustomProxySelector;

@Path("flight")
public class FlightRS {

    private SearchImpl searchImpl = new SearchImpl();
//    private BuyImpl buyImpl = new BuyImpl();
//    private CheckImpl checkImpl = new CheckImpl();

    public FlightRS() {
        ProxySelector.setDefault(new CustomProxySelector());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/allcities")
    public CityList getAllCities() {
        List<City> list = searchImpl.getAllCities();
        CityList cityList = new CityList();
        cityList.setList(list);
        return cityList;
    }

   
}
