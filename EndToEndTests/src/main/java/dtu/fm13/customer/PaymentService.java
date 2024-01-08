
package dtu.fm13.customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import dtu.fm13.customer.model.Customer;
import dtu.fm13.customer.model.Payment;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;



public class PaymentService {
	
	WebTarget webTarget;

	public PaymentService() {
	Client client = ClientBuilder.newClient();
	this.webTarget = client.target("http://localhost:8080");
	}
	
	public int postPayment(Payment payment, Customer merchant) {
		WebTarget personWebTarget = webTarget.path("/payment");
		Invocation.Builder invocationBuilder = personWebTarget.request();
		Response response = invocationBuilder.post(Entity.entity(payment, MediaType.APPLICATION_JSON));
		return response.getStatus();
	}

	public List<Payment> getList(Customer merchant) {
		WebTarget paymentWebTarget = webTarget.path("/payment");
		Invocation.Builder invocationBuilder = paymentWebTarget.request();
		Response response = invocationBuilder.get();
		List<Payment> paymentList = response.readEntity(new GenericType<List<Payment>>() {});
		return paymentList;
		
	}
}
