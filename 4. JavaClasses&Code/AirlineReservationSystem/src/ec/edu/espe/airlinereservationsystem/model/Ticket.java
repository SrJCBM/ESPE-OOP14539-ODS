package ec.edu.espe.airlinereservationsystem.model;

import org.json.JSONObject;
import enums.TicketClass;
import utils.CustomerManager;
import utils.FlightManager;

public class Ticket {

    private int ticketId;
    private int flightId;
    private int customerId;
    private TicketClass ticketClass;
    private int numberOfPeople;
    private String status;

    public Ticket(int ticketId, int flightId, int customerId, TicketClass ticketClass, int numberOfPeople) {
        this.ticketId = ticketId;
        this.flightId = flightId;
        this.customerId = customerId;
        this.ticketClass = ticketClass;
        this.numberOfPeople = numberOfPeople;
        this.status = "Booked";
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ticketId", ticketId);
        jsonObject.put("flightId", flightId);
        jsonObject.put("customerId", customerId);
        jsonObject.put("ticketClass", ticketClass.name());
        jsonObject.put("numberOfPeople", numberOfPeople);
        jsonObject.put("status", status);

        return jsonObject;
    }

    public static Ticket fromJSON(JSONObject jsonObject, CustomerManager customerManager, FlightManager flightManager) {
        int ticketId = jsonObject.getInt("ticketId");
        int flightId = jsonObject.getInt("flightId");
        int customerId = jsonObject.getInt("customerId");
        TicketClass ticketClass = TicketClass.valueOf(jsonObject.getString("ticketClass"));
        int numberOfPeople = jsonObject.getInt("numberOfPeople");
        String status = jsonObject.getString("status");

        Ticket ticket = new Ticket(ticketId, flightId, customerId, ticketClass, numberOfPeople);
        ticket.setStatus(status);

        return ticket;
    }

    public int getTicketId() {
        return ticketId;
    }

    public int getFlightId() {
        return flightId;
    }

    public int getCustomerId() {
        return customerId;
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

    public void setStatus(String status) {
        this.status = status;
    }

    public Flight getFlight(FlightManager flightManager) {
        return flightManager.getFlight(flightId);
    }
}
