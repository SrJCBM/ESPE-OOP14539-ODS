package enums;

/**
 *
 * @author Julio Blacio, Overnight Developers Squad, DCCO-ESPE
 */
public enum TicketClass {
    ECONOMY(100.0),
    BUSINESS(200.0);

    private final double price;

    TicketClass(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
