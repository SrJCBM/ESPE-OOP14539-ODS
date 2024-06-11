package utils;

/**
 *
 * @author Julio Blacio, Overnight Developers Squad, DCCO-ESPE
 */
public class ReservationSystem {

    private static ReservationSystem instance;
    private CustomerManager customerManager;
    private FlightManager flightManager;
    private TicketManager ticketManager;
    private PaymentManager paymentManager;
    private OfferManager offerManager;
    private FAQManager faqManager;

    private ReservationSystem() {
        this.flightManager = new FlightManager();
        this.ticketManager = new TicketManager();
        this.paymentManager = new PaymentManager();
        this.offerManager = new OfferManager();
        this.faqManager = new FAQManager();
        CustomerDataManager.setReservationSystem(this);
    }

    public static synchronized ReservationSystem getInstance() {
        if (instance == null) {
            instance = new ReservationSystem();
        }
        return instance;
    }

    public CustomerManager getCustomerManager() {
        if (customerManager == null) {
            this.customerManager = new CustomerManager();
        }
        return customerManager;
    }

    public FlightManager getFlightManager() {
        return flightManager;
    }

    public TicketManager getTicketManager() {
        return ticketManager;
    }

    public PaymentManager getPaymentManager() {
        return paymentManager;
    }

    public OfferManager getOfferManager() {
        return offerManager;
    }

    public FAQManager getFaqManager() {
        return faqManager;
    }
}
