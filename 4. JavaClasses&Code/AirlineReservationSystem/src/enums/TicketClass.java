package enums;


/**
 *
 * @author Kerlly Chiriboga,  Overnight Developers Squad,  ODS
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