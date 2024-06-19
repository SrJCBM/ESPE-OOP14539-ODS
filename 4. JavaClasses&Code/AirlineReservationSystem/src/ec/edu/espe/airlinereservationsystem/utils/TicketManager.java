package ec.edu.espe.airlinereservationsystem.utils;

import ec.edu.espe.airlinereservationsystem.model.Customer;
import ec.edu.espe.airlinereservationsystem.model.Flight;
import ec.edu.espe.airlinereservationsystem.model.Ticket;
import ec.edu.espe.airlinereservationsystem.enums.TicketClass;

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
        Ticket ticket = new Ticket(ticketId, flight.getFlightId(), customer.getCustomerId(), ticketClass, numberOfPeople);
        System.out.println("Booking ticket with ID: " + ticketId);
        tickets.add(ticket);
        customer.addTicket(ticket);
        sendTicketByEmail(customer, ticket);
        return ticket;
    }

    public void addBaggage(Ticket ticket, int carryOn, int checked) {
        System.out.println("Adding baggage to ticket ID: " + ticket.getTicketId());
        System.out.println("Carry-on baggage: " + carryOn + " pcs, Checked baggage: " + checked + " pcs");
    }

    public void changeFlightDate(Ticket ticket, Date newDepartureDate, Date newArrivalDate) {
        if (ticket.getTicketClass() == TicketClass.BUSINESS) {
            // Retrieve the flight object associated with the ticket
            Flight flight = ReservationSystem.getInstance().getFlightManager().getFlight(ticket.getFlightId());

            flight.setDepartureDate(newDepartureDate);
            flight.setArrivalDate(newArrivalDate);
            System.out.println("Changed flight dates for ticket ID: " + ticket.getTicketId());
            System.out.println("New departure date: " + newDepartureDate + ", New arrival date: " + newArrivalDate);
        } else {
            System.out.println("Date change allowed only for BUSINESS class tickets.");
        }
    }

    public void updateTicketStatus(Ticket ticket, String status) {
        System.out.println("Updating status for ticket ID: " + ticket.getTicketId() + " to: " + status);
    }

    public void viewTicketHistory(Customer customer) {
        List<Ticket> tickets = customer.getTickets();
        System.out.println("Ticket History for " + customer.getName() + ":");
        for (Ticket ticket : tickets) {  
            System.out.println("- Ticket ID: " + ticket.getTicketId() + ", Flight ID: " + ticket.getFlightId() + ", Ticket Class: " + ticket.getTicketClass());
        }
    }

    public void sendTicketByEmail(Customer customer, Ticket ticket) {
        System.out.println("Sending ticket to " + customer.getEmail());
        System.out.println("Ticket ID: " + ticket.getTicketId());
        System.out.println("Flight ID: " + ticket.getFlightId());
        System.out.println("Ticket Class: " + ticket.getTicketClass());
        System.out.println("Number of People: " + ticket.getNumberOfPeople());
        System.out.println("Status: " + ticket.getStatus());
    }

    public List<Ticket> getTicketsByCustomer(Customer customer) {
        return customer.getTickets();
    }

    public Ticket getTicket(int id) {
        return tickets.get(id - 1);
    }

    public List<Ticket> getAllTickets() {
        return tickets;
    }
}
