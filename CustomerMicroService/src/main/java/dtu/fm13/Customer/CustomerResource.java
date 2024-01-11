package dtu.fm13.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerResource {

    private List<Payment> payments = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    public List<Customer> getCustomers() {
        return customers;
    }

    public CustomerResource() {
        Customer p1 = new Customer("John", "Doe");
        p1.setId(UUID.randomUUID());
        customers.add(p1);
        
        Customer p2 = new Customer("Alice", "Andersson");
        p2.setId(UUID.randomUUID());
        customers.add(p2);

    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public boolean existsCustomer(UUID id) {
        for (Customer customer : getCustomers()) {
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
    	for (Customer cust: customers) {
    		if (cust.getId().equals(uuid)) {
    			return cust.getAccountID();
    		}
    	}
    	return null;
    }
}

