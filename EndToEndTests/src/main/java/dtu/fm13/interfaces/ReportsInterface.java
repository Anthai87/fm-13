/*Harald, Anthony og Elias
 */
package dtu.fm13.interfaces;

import java.util.List;
import dtu.fm13.models.Payment;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;



public class ReportsInterface {

	WebTarget webTarget;

	public ReportsInterface() {
	Client client = ClientBuilder.newClient();
	this.webTarget = client.target("http://localhost:8000");
	}
	
	public List<Payment> Report() {
		WebTarget personWebTarget = webTarget.path("/reports");
		Invocation.Builder invocationBuilder = personWebTarget.request();
		Response response = invocationBuilder.get();
		List<Payment> paymentList = response.readEntity(new GenericType<List<Payment>>() {});
		
		return paymentList;
	}

    public List<Payment> payments() {
		WebTarget personWebTarget = webTarget.path("/reports");
		Invocation.Builder invocationBuilder = personWebTarget.request();
		Response response = invocationBuilder.get();
		List<Payment> paymentList = response.readEntity(new GenericType<List<Payment>>() {});
		
		return paymentList;
    }
}
