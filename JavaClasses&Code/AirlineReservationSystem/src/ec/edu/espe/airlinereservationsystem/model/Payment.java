

package ec.edu.espe.airlinereservationsystem.model;
import java.io.Serializable;
import enums.PaymentMethod;
import java.util.Date;

/**
 *
 * @author Julio Blacio, Overnight Developers Squad, DCCO-ESPE
 */
public class Payment {
    private int paymentId;
    private PaymentMethod method;
    private double amount;
    private Date date;

    public Payment(int paymentId, PaymentMethod method, double amount, Date date) {
        this.paymentId = paymentId;
        this.method = method;
        this.amount = amount;
        this.date = date;
    }

    /**
     * @return the paymentId
     */
    public int getPaymentId() {
        return paymentId;
    }

    /**
     * @return the method
     */
    public PaymentMethod getMethod() {
        return method;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

}
