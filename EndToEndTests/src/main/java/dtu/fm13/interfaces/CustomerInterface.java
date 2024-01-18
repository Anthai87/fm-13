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



public class CustomerInterface {

	WebTarget webTarget;

	public CustomerInterface() {
	Client client = ClientBuilder.newClient();
	this.webTarget = client.target("http://localhost:8000");
	}
	//For EndToEnd tests, to see if customers are created successfully
	public List<Account> customerList() {
		WebTarget personWebTarget = webTarget.path("/customers");
		Invocation.Builder invocationBuilder = personWebTarget.request();
		Response response = invocationBuilder.get();
		List<Account> personList = response.readEntity(new GenericType<List<Account>>() {});
		
		return personList;
	}

	public Response create(Account customer) {
		WebTarget personWebTarget = webTarget.path("/customers");
		Invocation.Builder invocationBuilder = personWebTarget.request();
		Response response = invocationBuilder.post(Entity.entity(customer, MediaType.APPLICATION_JSON));
		return response;
	}
	public Response delete(Account customer) {
		WebTarget personWebTarget = webTarget.path("/customers/"+customer.getId().toString());
		Invocation.Builder invocationBuilder = personWebTarget.request();
		Response response = invocationBuilder.delete();
		return response;
	}
    public List<String> tokenlist(Account customer) {
        WebTarget personWebTarget = webTarget.path("/customers/"+customer.getId().toString()+"/tokens");
		Invocation.Builder invocationBuilder = personWebTarget.request();
		Response response = invocationBuilder.get();
		return response.readEntity(new GenericType<List<String>>() {});

    }
	
	//gettokens
	//getreports

}