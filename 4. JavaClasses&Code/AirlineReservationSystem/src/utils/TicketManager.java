
package utils;

import ec.edu.espe.airlinereservationsystem.model.Customer;
import ec.edu.espe.airlinereservationsystem.model.Flight;
import ec.edu.espe.airlinereservationsystem.model.Ticket;
import enums.TicketClass;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Julio Blacio, Overnight Developers Squad, DCCO-ESPE
 */
public class TicketManager {
    private List<Ticket> tickets;

    public TicketManager() {
        this.tickets = new ArrayList<>();
    }
    public Ticket bookTicket(Customer customer, Flight flight, TicketClass ticketClass, int numberOfPeople) {
        int ticketId = tickets.size() + 1;
        Ticket ticket = new Ticket(ticketId, customer, flight, ticketClass, numberOfPeople);
        tickets.add(ticket);
        customer.addTicketToHistory(ticket);
        sendTicketByEmail(customer, ticket);
        return ticket;
    }

    public void addBaggage(Ticket ticket, int carryOn, int checked) {
        System.out.println("Adding baggage to ticket ID: " + ticket.getTicketId());
        System.out.println("Carry-on baggage: " + carryOn + " pcs, Checked baggage: " + checked + " pcs");
    }

    public void changeFlightDate(Ticket ticket, Date newDepartureDate, Date newArrivalDate) {
        if (ticket.getTicketClass() == TicketClass.BUSINESS) {
            Flight flight = ticket.getFlight();
            flight.setDepartureDate(newDepartureDate);
            flight.setArrivalDate(newArrivalDate);
            System.out.println("Flight dates updated for ticket ID: " + ticket.getTicketId());
        } else {
            System.out.println("Date change allowed only for BUSINESS class tickets.");
        }
    }

    public void updateTicketStatus(Ticket ticket, String status) {
        ticket.setStatus(status);
        System.out.println("Ticket status updated to: " + status);
    }

    public void viewTicketHistory(Customer customer) {
        System.out.println("Ticket History for " + customer.getName() + ":");
        for (Ticket ticket : customer.getTicketHistory()) {
            System.out.println("- Ticket ID: " + ticket.getTicketId() + ", Flight ID: " + ticket.getFlight().getFlightId() + ", Class: " + ticket.getTicketClass() + ", Status: " + ticket.getStatus());
        }
    }

    public void sendTicketByEmail(Customer customer, Ticket ticket) {
        System.out.println("Sending ticket to " + customer.getEmail());
        System.out.println("Ticket ID: " + ticket.getTicketId());
        System.out.println("Flight ID: " + ticket.getFlight().getFlightId());
        System.out.println("Ticket Class: " + ticket.getTicketClass());
        System.out.println("Number of People: " + ticket.getNumberOfPeople());
        System.out.println("Status: " + ticket.getStatus());
    }

    public Ticket getTicket(int id) {
        return tickets.get(id - 1);
    }

    public List<Ticket> getAllTickets() {
        return tickets;
    } 
}
