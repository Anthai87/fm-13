/*Harald
 */

package dtu.fm13.facade;

import java.util.List;
import java.util.UUID;

import dtu.fm13.models.Customer;
import dtu.fm13.repository.CustomerRepository;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import dtu.fm13.Service.CustomerService;

public class CustomerFacade {
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
    public UUID createCustomer(Customer customer) {
              
    	UUID toReturn= customerService.createCustomer(customer);
        System.out.println("IDtoReturn:" + toReturn);
        return toReturn;
    }

    @Path("{customerID}")
    @DELETE
    public Response deleteCustomer(@PathParam("customerID") String custumerID) {
        System.out.println("Get delete request from:"+ custumerID);
        if (customerService.deleteCustomer(custumerID)){
            return Response.status(200).entity("Request processed successfully").build();
                }
        return Response.status(400).entity("Invalid custumer ID. Please provide a valid input.").build();        
    }

    
    
}