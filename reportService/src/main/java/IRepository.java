import domain.model.Payment;

import java.util.List;

public interface IRepository {
    void addPayment(Payment payment);

    List<Payment> getPayments();

}
