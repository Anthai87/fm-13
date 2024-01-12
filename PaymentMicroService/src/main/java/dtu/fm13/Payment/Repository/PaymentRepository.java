package dtu.fm13.Payment.Repository;

import java.util.ArrayList;
import java.util.List;

import dtu.fm13.Payment.models.Payment;
import jakarta.ws.rs.Path;

@Path("/Payments")
public class PaymentRepository {

    private List<Payment> payments = new ArrayList<>();
        public PaymentRepository() {
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

 
 
    public void add(Payment payment) {
        payments.add(payment);
    }
}


