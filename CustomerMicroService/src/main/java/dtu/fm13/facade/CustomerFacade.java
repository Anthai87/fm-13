/*Interface for the Customer MicroService
 * implements:
 * Customer 
 * - get
 * - post
 * - delete
 * needs:
 * Customer/?name={name}
 */

package dtu.fm13.facade;

import java.util.List;
import java.util.UUID;

import dtu.fm13.models.Customer;
import dtu.fm13.repository.CustomerRepository;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import dtu.fm13.Service.CustomerService;

public class CustomerFacade {

    PaymentFacade paymentResource;
    private CustomerRepository customerRepository;
    private CustomerService customerService;


    public CustomerFacade(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.customerService= new CustomerService(customerRepository);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public UUID createCustomer(String accountID) {
    	return customerService.createCustomer(accountID);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCustomer(Customer customer) {
        customerService.deleteCustomer(customer);
    }

    public CustomerFacade getCustomerRepository() {
        return this;
    }
    @Path("/test")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String test(@QueryParam("id")  String accountID) {
    	return "test!";
    }

    
}