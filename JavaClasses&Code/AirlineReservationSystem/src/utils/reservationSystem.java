
package utils;

import ec.edu.espe.airlinereservationsystem.model.Customer;
import ec.edu.espe.airlinereservationsystem.model.Flight;
import ec.edu.espe.airlinereservationsystem.model.Payment;
import ec.edu.espe.airlinereservationsystem.model.Ticket;
import enums.PaymentMethod;
import enums.TicketClass;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Julio Blacio, Overnight Developers Squad, DCCO-ESPE
 */
public class reservationSystem {

    private CustomerManager customerManager;
    private FlightManager flightManager;
    private TicketManager ticketManager;
    private PaymentManager paymentManager;
    private OfferManager offerManager;
    private FAQManager faqManager;

    public reservationSystem() {
        this.customerManager = new CustomerManager();
        this.flightManager = new FlightManager();
        this.ticketManager = new TicketManager();
        this.paymentManager = new PaymentManager();
        this.offerManager = new OfferManager();
        this.faqManager = new FAQManager();
    }

    /**
     * @return the customerManager
     */
    public CustomerManager getCustomerManager() {
        return customerManager;
    }

    /**
     * @return the flightManager
     */
    public FlightManager getFlightManager() {
        return flightManager;
    }

    /**
     * @return the ticketManager
     */
    public TicketManager getTicketManager() {
        return ticketManager;
    }

    /**
     * @return the paymentManager
     */
    public PaymentManager getPaymentManager() {
        return paymentManager;
    }

    /**
     * @return the offerManager
     */
    public OfferManager getOfferManager() {
        return offerManager;
    }

    /**
     * @return the faqManager
     */
    public FAQManager getFaqManager() {
        return faqManager;
    }

}
