package dtu.fm13.Customer.Resource;

import dtu.fm13.Customer.Service.CustomerService;
import dtu.fm13.Customer.Service.PaymentResource;
import jakarta.ws.rs.Path;

@Path("/")
public class TopResource {
    CustomerResource customerResource = new CustomerResource();
   
    @Path("customer")
    public CustomerService getCustomerService() {
      	return new CustomerService(customerResource);
        
    }

    @Path("payment")
    public PaymentResource getPaymentResource() {
      return new PaymentResource(customerResource);
      }

}
