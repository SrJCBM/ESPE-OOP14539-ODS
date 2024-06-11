
package utils;

import ec.edu.espe.airlinereservationsystem.model.Payment;
import enums.PaymentMethods;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Julio Blacio, Overnight Developers Squad, DCCO-ESPE
 */
public class PaymentManager {
    private List<Payment> payments;

    public PaymentManager() {
        this.payments = new ArrayList<>();
    }

    public Payment makePayment(PaymentMethods method, double amount) {
        int paymentId = payments.size() + 1;
        Payment payment = new Payment(paymentId, method, amount, new Date());
        payments.add(payment);
        return payment;
    }

    public List<Payment> getAllPayments() {
        return payments;
    }
}
