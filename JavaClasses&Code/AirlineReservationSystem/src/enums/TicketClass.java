package enums;


/**
 *
 * @author Julio Blacio, Overnight Developers Squad, DCCO-ESPE
 */
public enum TicketClass {
    ECONOMY(100.0), // Set the constant price for economy class
    BUSINESS(200.0); // Set the constant price for business class

    private final double price;

    TicketClass(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}