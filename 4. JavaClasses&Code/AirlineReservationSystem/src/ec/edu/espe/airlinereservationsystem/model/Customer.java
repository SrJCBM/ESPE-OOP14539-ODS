package ec.edu.espe.airlinereservationsystem.model;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.CustomerManager;
import utils.FlightManager;

/**
 * Represents a customer in the reservation system.
 */
public class Customer {

    private int customerId;
    private String name;
    private String email;
    private List<Ticket> ticketHistory;

    public Customer(int customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.ticketHistory = new ArrayList<>();
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Ticket> getTicketHistory() {
        return ticketHistory;
    }

    public void addTicket(Ticket ticket) {
        ticketHistory.add(ticket);
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("customerId", customerId);
        jsonObject.put("name", name);
        jsonObject.put("email", email);

        JSONArray ticketArray = new JSONArray();
        for (Ticket ticket : ticketHistory) {
            ticketArray.put(ticket.toJSON());
        }
        jsonObject.put("ticketHistory", ticketArray);
        return jsonObject;
    }

    public static Customer fromJSON(JSONObject jsonObject, CustomerManager customerManager, FlightManager flightManager) {
        int customerId = jsonObject.getInt("customerId");
        String name = jsonObject.getString("name");
        String email = jsonObject.getString("email");

        Customer customer = new Customer(customerId, name, email);

        JSONArray ticketArray = jsonObject.getJSONArray("ticketHistory");
        for (int i = 0; i < ticketArray.length(); i++) {
            JSONObject ticketObject = ticketArray.getJSONObject(i);
            int flightId = ticketObject.getInt("flightId");
            Flight flight = flightManager.getFlight(flightId);
            Ticket ticket = Ticket.fromJSON(ticketObject, customer, flight);
            customer.addTicket(ticket);
        }

        return customer;
    }
}
