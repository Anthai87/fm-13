/**
 *
 * @author Harald
 *
 * */
package dtu.fm13.Payment.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dtu.fm13.Payment.models.Account;
import dtu.fm13.Payment.models.Payment;

public class PaymentRepository {
    private List<Account> customers = new ArrayList<>();
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

    public boolean merchantExists(UUID payerId) {
        for (Account c: customers){
        if (c.getId().equals(payerId)) return true;
       }
       return false;
    }

    public String getCustomerBankID(UUID payerId) {
        for (Account c: customers){
            if (c.getId().equals(payerId)) return c.getAccountID();
           }
           return null; 
    }

    public boolean addCustomer(Account customer) {
        if (merchantExists(customer.getId())) return false;
            
        customers.add(customer);
        return true;
    }
}


