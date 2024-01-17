/*Harald & ELias & Anthony
 */
package dtu.fm13.facade;

import dtu.fm13.repository.AccountRepository;
import jakarta.ws.rs.Path;

@Path("/")
public class TopFacade {
    AccountRepository merchantRepository = new AccountRepository();
    @Path("customers/")
    public MerchantFacade getCustomerService() {
    	return new MerchantFacade(merchantRepository);
        
    }
}
