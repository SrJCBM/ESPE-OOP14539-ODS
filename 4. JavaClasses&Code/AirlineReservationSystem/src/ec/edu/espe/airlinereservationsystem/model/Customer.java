package ec.edu.espe.airlinereservationsystem.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import ec.edu.espe.airlinereservationsystem.utils.CustomerManager;
import ec.edu.espe.airlinereservationsystem.utils.FlightManager;

public class Customer {

    private int customerId;
    private String name;
    private String email;
    private List<Ticket> tickets;

    public Customer(int customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.tickets = new ArrayList<>();
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("customerId", customerId);
        jsonObject.put("name", name);
        jsonObject.put("email", email);

        JSONArray ticketsArray = new JSONArray();
        for (Ticket ticket : tickets) {
            ticketsArray.put(ticket.toJSON());
        }
        jsonObject.put("tickets", ticketsArray);

        return jsonObject;
    }

    public static Customer fromJSON(JSONObject jsonObject, CustomerManager customerManager, FlightManager flightManager) {
        int customerId = jsonObject.getInt("customerId");
        String name = jsonObject.getString("name");
        String email = jsonObject.getString("email");

        Customer customer = new Customer(customerId, name, email);

        JSONArray ticketsArray = jsonObject.getJSONArray("tickets");
        for (int i = 0; i < ticketsArray.length(); i++) {
            JSONObject ticketJson = ticketsArray.getJSONObject(i);
            Ticket ticket = Ticket.fromJSON(ticketJson, customerManager, flightManager);
            customer.addTicket(ticket);
        }

        return customer;
    }

    public void addTicket(Ticket ticket) {
        System.out.println("Adding ticket with ID: " + ticket.getTicketId() + " to customer ID: " + this.customerId);
        tickets.add(ticket);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
