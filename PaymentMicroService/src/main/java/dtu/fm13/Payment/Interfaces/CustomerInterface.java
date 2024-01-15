package dtu.fm13.Payment.Interfaces;

import java.util.ArrayList;
import java.util.List;

import Model.Customer;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;



public class CustomerInterface {
	private List<Customer> customers = new ArrayList<Customer>();

	WebTarget webTarget;

	public CustomerInterface() {
	Client client = ClientBuilder.newClient();
	this.webTarget = client.target("http://customers:8080");
	}
	
	public List<Customer> getList() {
		WebTarget personWebTarget = webTarget.path("/customers");
		Invocation.Builder invocationBuilder = personWebTarget.request();
		Response response = invocationBuilder.get();
		List<Customer> personList = response.readEntity(new GenericType<List<Customer>>() {});
		
		return personList;
	}

	public Response create(String bankAccountID) {
		WebTarget personWebTarget = webTarget.path("/customers");
		Invocation.Builder invocationBuilder = personWebTarget.request();
		Response response = invocationBuilder.post(Entity.entity(bankAccountID, MediaType.APPLICATION_JSON));
		return response;
	}
}