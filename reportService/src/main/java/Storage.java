import domain.model.Payment;

import java.util.List;

public class Storage implements IStorage {
    private final IRepository repository;

    public Storage(IRepository repository) {
        this.repository = repository;
    }


    @Override
    public void addPayment(Payment payment) {
        repository.addPayment(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return repository.getPayments();
    }

    @Override
    public void cleanUp() {
        repository.getPayments().clear();

    }
}
