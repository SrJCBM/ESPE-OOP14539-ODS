

package ec.edu.espe.airlinereservationsystem.model;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julio Blacio, Overnight Developers Squad, DCCO-ESPE
 */
public class Customer {
    private int customerId  ;
    private String name;
    private String email;
    private List<Ticket> ticketHistory;

    public Customer(int customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.ticketHistory = new ArrayList<>();
    }

    /**
     * @return the customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the ticketHistory
     */
    public List<Ticket> getTicketHistory() {
        return ticketHistory;
    }
    public void addTicketToHistory(Ticket ticket) {
        this.ticketHistory.add(ticket);
    }
    
}
