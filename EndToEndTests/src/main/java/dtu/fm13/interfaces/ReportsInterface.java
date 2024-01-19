/*Harald, Anthony og Elias
 */
package dtu.fm13.interfaces;

import java.util.List;
import java.util.UUID;

import dtu.fm13.models.Payment;
import dtu.fm13.models.PaymentInformation;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;



public class ReportsInterface {

	WebTarget webTarget;
	Client client = ClientBuilder.newClient();

	public ReportsInterface() {
	this.webTarget = client.target("http://localhost:8000");
	}
	
	public List<Payment> Report() {
		WebTarget personWebTarget = webTarget.path("/reports");
		Invocation.Builder invocationBuilder = personWebTarget.request();
		Response response = invocationBuilder.get();
		List<Payment> paymentList = response.readEntity(new GenericType<List<Payment>>() {});
		return paymentList;
	}

    public List<PaymentInformation> payments() {
		WebTarget personWebTarget = webTarget.path("/reports");
		Invocation.Builder invocationBuilder = personWebTarget.request();
		Response response = invocationBuilder.get();
		List<PaymentInformation> paymentList = response.readEntity(new GenericType<List<PaymentInformation>>() {});
		return paymentList;
    }

    public List<PaymentInformation> payments(UUID id) {
        WebTarget personWebTarget = webTarget.path("/reports/" + id);
		Invocation.Builder invocationBuilder = personWebTarget.request();
		Response response = invocationBuilder.get();
		List<PaymentInformation> paymentList = response.readEntity(new GenericType<List<PaymentInformation>>() {});
		return paymentList;
    }
}
