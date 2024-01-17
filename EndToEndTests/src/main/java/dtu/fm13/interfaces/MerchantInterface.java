/*Harald
 */
package dtu.fm13.interfaces;

import java.util.List;
import dtu.fm13.models.Account;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;



public class MerchantInterface {

	WebTarget webTarget;

	public MerchantInterface() {
	Client client = ClientBuilder.newClient();
	this.webTarget = client.target("http://localhost:8000");
	}
	//For EndToEnd tests, to see if customers are created successfully
	public List<Account> merchantList() {
		WebTarget personWebTarget = webTarget.path("/merchants");
		Invocation.Builder invocationBuilder = personWebTarget.request();
		Response response = invocationBuilder.get();
		List<Account> merchantList = response.readEntity(new GenericType<List<Account>>() {});

		return merchantList;
	}
	public List<Account> Report(String id) {
		WebTarget personWebTarget = webTarget.path("/merchants/" +id+ "/report");
		Invocation.Builder invocationBuilder = personWebTarget.request();
		Response response = invocationBuilder.get();
		List<Account> personList = response.readEntity(new GenericType<List<Account>>() {});
		
		return personList;
	}

	public Response create(Account customer) {
		WebTarget personWebTarget = webTarget.path("/merchants");
		Invocation.Builder invocationBuilder = personWebTarget.request();
		Response response = invocationBuilder.post(Entity.entity(customer, MediaType.APPLICATION_JSON));
		return response;
	}
	public Response delete(Account merchant) {
		WebTarget personWebTarget = webTarget.path("/merchants/"+merchant.getId().toString());
		Invocation.Builder invocationBuilder = personWebTarget.request();
		Response response = invocationBuilder.delete();
		return response;
	}
}