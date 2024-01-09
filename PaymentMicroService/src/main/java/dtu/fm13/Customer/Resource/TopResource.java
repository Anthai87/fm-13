package dtu.fm13.Customer.Resource;

import java.util.List;

import dtu.fm13.Customer.Service.CustomerService;
import dtu.fm13.Customer.Service.PaymentResource;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
public class TopResource {
    CustomerResource customerResource = new CustomerResource();
   
    @Path("customers")
    public CustomerService getCustomerService() {
      	return new CustomerService(customerResource);
        
    }

    @Path("payments")
    public PaymentResource getPaymentResource() {
    	return new PaymentResource(customerResource);
      }
   
}
