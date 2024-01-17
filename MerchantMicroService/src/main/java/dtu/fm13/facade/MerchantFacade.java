/*Harald
 */

package dtu.fm13.facade;

import java.util.List;
import java.util.UUID;

import dtu.fm13.repository.AccountRepository;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import dtu.fm13.Service.MerchantService;
import dtu.fm13.models.Account;

public class MerchantFacade {
    private AccountRepository accountRepository;
    private MerchantService merchantService;


    public MerchantFacade(AccountRepository customerRepository) {
        this.accountRepository = customerRepository;
        this.merchantService= new MerchantService(customerRepository);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getMerchants() {
        return accountRepository.getMerchants();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public UUID createCustomer(Account merchant) {
              
    	UUID toReturn= merchantService.createMerchant(merchant);
        System.out.println("IDtoReturn:" + toReturn);
        return toReturn;
    }

    @Path("{customerID}")
    @DELETE
    public Response deleteCustomer(@PathParam("customerID") String custumerID) {
        System.out.println("Get delete request from:"+ custumerID);
        if (merchantService.deleteCustomer(custumerID)){
            return Response.status(200).entity("Request processed successfully").build();
                }
        return Response.status(400).entity("Invalid custumer ID. Please provide a valid input.").build();        
    }

    
    
}