package dtu.fm13.facade;

import dtu.fm13.repository.CustomerRepository;
import jakarta.ws.rs.Path;

@Path("/")
public class TopFacade {
    CustomerRepository customerRepository = new CustomerRepository();
   
    @Path("customers")
    public CustomerFacade getCustomerService() {
    	return new CustomerFacade(customerRepository);
        
    }

    // @Path("payments")
    // public PaymentFacade getPaymentResource() {
    //   return new PaymentFacade(customerResource);
    //   }
//    @Path("payment2")
//    public PaymentResource getPaymentResource2() {
//    	Client client = ClientBuilder.newClient();
//    	WebTarget webTarget;
//    	webTarget = client.target("http://paymentservice:8080");
//    	WebTarget personWebTarget = webTarget.path("/payment");
//		Invocation.Builder invocationBuilder = personWebTarget.request();
//		Response response = invocationBuilder.get();
//		PaymentResource paymenResource = response.readEntity(new GenericType<PaymentResource>() {});
//		return paymenResource;
//      //return new PaymentResource(customerResource);
//      }
}
