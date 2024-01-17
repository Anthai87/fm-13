/*Harald
 */
package dtu.fm13.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dtu.fm13.models.Account;
import dtu.fm13.models.Payment;

public class CustomerRepository {

    private List<Payment> payments = new ArrayList<>();
    private List<Account> customers = new ArrayList<>();

    public List<Account> getCustomers() {
        return customers;
    }

    public CustomerRepository() {
    }

    public void setCustomers(List<Account> customers) {
        this.customers = customers;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public void addCustomer(Account customer) {
        //TODO check CPR if exists already
        customer.setId(UUID.randomUUID());
        customers.add(customer);
    }

    public boolean existsCustomer(UUID id) {
        for (Account customer : getCustomers()) {
            if (customer.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }
    public String getCustomerBankID(UUID uuid) {
    	for (Account cust: customers) {
    		if (cust.getId().equals(uuid)) {
    			return cust.getAccountID();
    		}
    	}
    	return null;
    }
}


