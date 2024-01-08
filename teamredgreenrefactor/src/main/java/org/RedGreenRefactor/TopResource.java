package org.RedGreenRefactor;

import jakarta.ws.rs.Path;

@Path("/")
public class TopResource {
    HelloService helloService = new HelloService();
   
    @Path("person")
    public PersonResource getPersonResource() {
      	return new PersonResource(helloService);
        
    }

    @Path("payment")
    public PaymentResource getPaymentResource() {
      return new PaymentResource(helloService);
      }

}
