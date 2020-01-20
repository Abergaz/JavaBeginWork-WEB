/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.javabegin.training.flight.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.javabegin.training.flight.database.FlightDB;
import ru.javabegin.training.flight.database.PassengerDB;
import ru.javabegin.training.flight.database.PlaceDB;
import ru.javabegin.training.flight.database.ReservationDB;
import ru.javabegin.training.flight.objects.Flight;
import ru.javabegin.training.flight.objects.Passenger;
import ru.javabegin.training.flight.objects.Reservation;
import ru.javabegin.training.flight.spr.objects.Place;

/**
 *
 * @author Tim
 */
@WebServlet(name = "TestSearch", urlPatterns = {"/TestSearch"})
public class TestSearch extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet TestSearch</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet TestSearch at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");

            
            Flight flight = FlightDB.getInstance().getFlight(1);
            
            Place place = PlaceDB.getInstance().getPlace(2);
            
            // убедитесь, что у вас нет пассажира с passenger_id=1 в таблице reservation (это уникальное поле)
            // иначе будет ошибка  Duplicate entry '1-1' for key 'idx_reserve'
            Passenger passenger = PassengerDB.getInstance().getPassenger(1);
            
            Calendar date = Calendar.getInstance();
            date.setTimeInMillis(1328418000000L);
            
            Reservation reserv = new Reservation();
            reserv.setAddInfo("Без обеда");
            reserv.setCode(UUID.randomUUID().toString());
            reserv.setPassenger(passenger);
            reserv.setReserveDateTime(date);
            reserv.setPlace(place);
            reserv.setFlight(flight);
            
            ReservationDB.getInstance().insertReservation(reserv);
            
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
