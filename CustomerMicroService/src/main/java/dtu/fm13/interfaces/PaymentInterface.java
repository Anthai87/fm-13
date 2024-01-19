/*Harald
 */
package dtu.fm13.interfaces;

import dtu.fm13.models.Account;
import dtu.fm13.models.CustomerToPayment;
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
		CustomerToPayment pCustomer = new CustomerToPayment();
		pCustomer.setAccountID(customer.getAccountID());
		pCustomer.setId(customer.getId());
		WebTarget personWebTarget = webTarget.path("/payments/customer");
		Invocation.Builder invocationBuilder = personWebTarget.request();
		invocationBuilder.post(Entity.entity(pCustomer, MediaType.APPLICATION_JSON));
	}

}
