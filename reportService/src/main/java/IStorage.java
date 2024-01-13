import domain.model.Payment;

import java.util.List;

public interface IStorage {
    void addPayment(Payment payment);
    List<Payment> getAllPayments();
    void cleanUp();

}
