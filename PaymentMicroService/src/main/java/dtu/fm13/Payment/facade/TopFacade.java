/*Harald & ELias & Anthony
 */
package dtu.fm13.Payment.facade;

import dtu.fm13.Payment.Repository.PaymentRepository;
import jakarta.ws.rs.Path;

@Path("/")
public class TopFacade {
    PaymentRepository paymentRepository = new PaymentRepository();
    @Path("payments/")
    public PaymentFacade getPaymentFacade() {
    	return new PaymentFacade(paymentRepository);
        
    }
}
