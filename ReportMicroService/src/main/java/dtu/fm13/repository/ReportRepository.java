
package dtu.fm13.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dtu.fm13.models.Payment;
import lombok.Getter;
import lombok.Setter;

/**
 * @authors Elias & Anthony
 */

@Setter
@Getter
public class ReportRepository {

    private List<Payment> payments = new ArrayList<>();

    public ReportRepository() {
    }

    public void addPayment(Payment payment) {
        this.payments.add(payment);
    }


    public Optional<Payment> getPaymentById(String paymentId) {
        return payments.stream()
                .filter(payment -> payment.getPayerId().equals(paymentId))
                .findFirst();
    }


    public void deletePayment(String paymentId) {
        Optional<Payment> paymentToDelete = payments.stream().filter(payment ->
                payment.getPayerId().equals(paymentId)).findFirst();
        paymentToDelete.ifPresent(payment -> payments.remove(payment));
    }


}


