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
}
