package ec.edu.espe.airlinereservationsystem.model;

import ec.edu.espe.airlinereservationsystem.utils.CustomerManager;
import ec.edu.espe.airlinereservationsystem.utils.FlightManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {

    
     private int customerId;
    private String name;
    private String email;
    private String username;
    private String password; 
    private List<Ticket> tickets;

    public Customer(int customerId, String name, String email, String username, String password) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.tickets = new ArrayList<>();
    }

    public Customer(int customerId, String name, String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("customerId", customerId);
        jsonObject.put("name", name);
        jsonObject.put("email", email);
        jsonObject.put("username", username);
        jsonObject.put("password", password); 

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
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password"); 

        Customer customer = new Customer(customerId, name, email, username, password);

        JSONArray ticketsArray = jsonObject.getJSONArray("tickets");
        for (int i = 0; i < ticketsArray.length(); i++) {
            JSONObject ticketJson = ticketsArray.getJSONObject(i);
            Ticket ticket = Ticket.fromJSON(ticketJson, customerManager, flightManager);
            customer.addTicket(ticket);
        }

        return customer;
    }

    public void addTicket(Ticket ticket) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}