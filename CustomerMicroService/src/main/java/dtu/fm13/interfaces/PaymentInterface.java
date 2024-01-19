/*Harald
 */
package dtu.fm13.interfaces;

import dtu.fm13.models.Account;
import dtu.fm13.models.PaymentCustomer;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;



public class PaymentInterface {
	
	WebTarget webTarget;

	public PaymentInterface() {
	Client client = ClientBuilder.newClient();
	this.webTarget = client.target("http://paymentservice:8080");
	}
	
	    public void addCustomer(Account customer) {
		PaymentCustomer pCustomer = new PaymentCustomer();
        pCustomer.setAccountID(customer.getAccountID());
		pCustomer.setId(customer.getId());
        WebTarget personWebTarget = webTarget.path("/payments/customer");
		Invocation.Builder invocationBuilder = personWebTarget.request();
		invocationBuilder.post(Entity.entity(pCustomer, MediaType.APPLICATION_JSON));
    }
	// Todo Reporting
	// public List<Payment> List(Account merchant) {
	// 	WebTarget paymentWebTarget = webTarget.path("/payments");
	// 	Invocation.Builder invocationBuilder = paymentWebTarget.request();
	// 	Response response = invocationBuilder.get();
	// 	List<Payment> paymentList = response.readEntity(new GenericType<List<Payment>>() {});
	// 	return paymentList;
	// }
}
