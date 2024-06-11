package ec.edu.espe.airlinereservationsystem.model;

import enums.TicketClass;
import org.json.JSONObject;

/**
 * Represents a ticket in the reservation system.
 */
public class Ticket {

    private int ticketId;
    private Customer customer;
    private Flight flight;
    private TicketClass ticketClass;
    private int numberOfPeople;
    private String status;
    private boolean eTicket;

    public Ticket(int ticketId, Customer customer, Flight flight, TicketClass ticketClass, int numberOfPeople) {
        this.ticketId = ticketId;
        this.customer = customer;
        this.flight = flight;
        this.ticketClass = ticketClass;
        this.numberOfPeople = numberOfPeople;
        this.status = "Booked";
        this.eTicket = true;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Flight getFlight() {
        return flight;
    }

    public TicketClass getTicketClass() {
        return ticketClass;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public String getStatus() {
        return status;
    }

    public boolean iseTicket() {
        return eTicket;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void seteTicket(boolean eTicket) {
        this.eTicket = eTicket;
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ticketId", ticketId);
        jsonObject.put("customerId", customer.getCustomerId());
        jsonObject.put("flightId", flight.getFlightId());
        jsonObject.put("ticketClass", ticketClass.name());
        jsonObject.put("numberOfPeople", numberOfPeople);
        jsonObject.put("status", status);
        jsonObject.put("eTicket", eTicket);
        return jsonObject;
    }

    public static Ticket fromJSON(JSONObject jsonObject, Customer customer, Flight flight) {
        int ticketId = jsonObject.getInt("ticketId");
        TicketClass ticketClass = TicketClass.valueOf(jsonObject.getString("ticketClass"));
        int numberOfPeople = jsonObject.getInt("numberOfPeople");
        String status = jsonObject.getString("status");
        boolean eTicket = jsonObject.getBoolean("eTicket");

        Ticket ticket = new Ticket(ticketId, customer, flight, ticketClass, numberOfPeople);
        ticket.setStatus(status);
        ticket.seteTicket(eTicket);
        return ticket;
    }
}
