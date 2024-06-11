
package ec.edu.espe.airlinereservationsystem.model;


import enums.TicketClass;


/**
 *
 * @author Julio Blacio, Overnight Developers Squad, DCCO-ESPE
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

    
    
    /**
     * @return the ticketId
     */
    public int getTicketId() {
        return ticketId;
    }

    /**
     * @param ticketId the ticketId to set
     */
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the flight
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     * @param flight the flight to set
     */
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    /**
     * @return the ticketClass
     */
    public TicketClass getTicketClass() {
        return ticketClass;
    }

    /**
     * @param ticketClass the ticketClass to set
     */
    public void setTicketClass(TicketClass ticketClass) {
        this.ticketClass = ticketClass;
    }

    /**
     * @return the numberOfPeople
     */
    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    /**
     * @param numberOfPeople the numberOfPeople to set
     */
    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the eTicket
     */
    public boolean iseTicket() {
        return eTicket;
    }

    /**
     * @param eTicket the eTicket to set
     */
    public void seteTicket(boolean eTicket) {
        this.eTicket = eTicket;
    }
    
    
}

