package dtu.fm13.Payment.Interfaces;
/*Harald
 */


import dtu.fm13.Payment.models.Payment;
import dtu.fm13.Payment.models.PaymentInformation;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class ReportInterface {
   	
	WebTarget webTarget;

	public ReportInterface() {
	Client client = ClientBuilder.newClient();
	this.webTarget = client.target("http://reportservice:8080");
	}
	
	public int add(PaymentInformation payment) {
	 	WebTarget personWebTarget = webTarget.path("/reports");
	 	Invocation.Builder invocationBuilder = personWebTarget.request();
	 	Response response = invocationBuilder.post(Entity.entity(payment, MediaType.APPLICATION_JSON));
	 	return response.getStatus();
	 }

}
