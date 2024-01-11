/*Interface for the Customer MicroService
 * implements:
 * Customer 
 * - get
 * - post
 * - delete
 * needs:
 * Customer/?name={name}
 */

package dtu.fm13.Customer;

import java.util.List;
import java.util.UUID;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

public class CustomerService {

    PaymentResource paymentResource;
    private CustomerResource customerResource;

    public CustomerService(CustomerResource customerResource) {
        this.customerResource = customerResource;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers() {
        return customerResource.getCustomers();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public UUID createCustomer(String accountID) {
    	Customer customer = new Customer();
    	//customer.setId(customerID);
    	customer.setAccountID(accountID);
    	System.out.println(accountID);
    	customerResource.addCustomer(customer);
        return customer.getId();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCustomer(Customer customer) {
        try {
            List<Customer> newlist = customerResource.getCustomers();
            newlist.removeIf(p -> p.getId() == customer.getId());
            customerResource.setCustomers(newlist);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public CustomerService getCustomerResource() {
        return this;
    }

}