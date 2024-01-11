package dtu.fm13.Customer;

import jakarta.ws.rs.Path;

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
