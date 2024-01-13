import domain.model.Payment;

/**
 * Business Logic
 */
public class Report_Main {
    private final IStorage iStorage;


    public Report_Main(IStorage iStorage) {
        this.iStorage = iStorage;
    }

    /**
    * Putting a payment into storage
    * **/
    public void addPayment(Payment payment) {
        iStorage.addPayment(payment);
    }
}
