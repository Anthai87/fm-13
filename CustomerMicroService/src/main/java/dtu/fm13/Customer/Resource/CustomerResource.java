package dtu.fm13.Customer.Resource;

import java.util.ArrayList;
import java.util.List;

import Model.Customer;
import dtu.fm13.Customer.Payment;

public class CustomerResource {

    private List<Payment> payments = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    public List<Customer> getCustomers() {
        return customers;
    }

    public CustomerResource() {
        Customer p1 = new Customer("John", "Doe");
        p1.setId("1");
        customers.add(p1);
        Customer p2 = new Customer("Alice", "Andersson");
        p2.setId("2");
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

    public boolean existsCustomer(String id) {
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
}


