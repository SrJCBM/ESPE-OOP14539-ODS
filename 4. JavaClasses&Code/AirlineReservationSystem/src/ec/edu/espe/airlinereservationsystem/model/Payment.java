package ec.edu.espe.airlinereservationsystem.model;

import java.io.Serializable;
import enums.PaymentMethods;
import java.util.Date;

/**
 *
 * @author Julio Blacio, Overnight Developers Squad, DCCO-ESPE
 */
public class Payment implements Serializable {

    private int paymentId;
    private PaymentMethods method;
    private double amount;
    private Date date;

    public Payment(int paymentId, PaymentMethods method, double amount, Date date) {
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
    public PaymentMethods getMethod() {
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
