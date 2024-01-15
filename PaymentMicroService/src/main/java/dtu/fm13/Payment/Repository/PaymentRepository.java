package dtu.fm13.Payment.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dtu.fm13.Payment.models.Customer;
import dtu.fm13.Payment.models.Payment;

public class PaymentRepository {
    private List<Customer> customers = new ArrayList<>();
    private List<Payment> payments = new ArrayList<>();
        public PaymentRepository() {
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

 
 
    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public boolean customerExists(UUID payerId) {
        for (Customer c: customers){
        if (c.getId().equals(payerId)) return true;
       }
       return false;
    }

    public String getCustomerBankID(UUID payerId) {
        for (Customer c: customers){
            if (c.getId().equals(payerId)) return c.getAccountID();
           }
           return null; 
    }

    public boolean addCustomer(Customer customer) {
        if (customerExists(customer.getId())) return false;
            
        customers.add(customer);
        return true;
    }
}


