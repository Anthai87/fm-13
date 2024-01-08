package dtu.fm13.services;

import dtu.fm13.resource.PaymentResource;
import dtu.fm13.resource.CustomerService;
import jakarta.ws.rs.Path;

@Path("/")
public class TopResource {
    CustomerResource customerResource = new CustomerResource();
   
    @Path("person")
    public CustomerService getPersonResource() {
      	return new CustomerService(customerResource);
        
    }

    @Path("payment")
    public PaymentResource getPaymentResource() {
      return new PaymentResource(customerResource);
      }

}
