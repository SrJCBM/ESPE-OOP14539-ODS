/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.AirlineReservationSystem.model;

/**
 *
 * @author Joffre
 */
public class Ticket {
    private int TicketNumber;
    private String CustomerName;
    private int IdFlight;
    private String ticketclass;

    public Ticket(int TicketNumber, String CustomerName, int IdFlight, String ticketclass) {
        this.TicketNumber = TicketNumber;
        this.CustomerName = CustomerName;
        this.IdFlight = IdFlight;
        this.ticketclass = ticketclass;
    }

    
    
    public int getTicketNumber() {
        return TicketNumber;
    }

    public void setTicketNumber(int TicketNumber) {
        this.TicketNumber = TicketNumber;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public int getIdFlight() {
        return IdFlight;
    }

    public void setIdFlight(int IdFlight) {
        this.IdFlight = IdFlight;
    }

    public String getTicketclass() {
        return ticketclass;
    }

    public void setTicketclass(String ticketclass) {
        this.ticketclass = ticketclass;
    }
    
    
}
