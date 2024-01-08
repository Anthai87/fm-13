package dtu.fm13.customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import dtu.fm13.customer.model.Customer;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;



public class CustomerService {
	private List<Customer> customers = new ArrayList<Customer>();

	WebTarget webTarget;

	public CustomerService() {
	Client client = ClientBuilder.newClient();
	this.webTarget = client.target("http://localhost:8080");
	}
	
	public List<Customer> getPerson() {
		WebTarget personWebTarget = webTarget.path("/customer");
		Invocation.Builder invocationBuilder = personWebTarget.request();
		Response response = invocationBuilder.get();
		List<Customer> personList = response.readEntity(new GenericType<List<Customer>>() {});
		
		return personList;
	}

	public int add(Customer customer) {
		WebTarget personWebTarget = webTarget.path("/customer");
		Invocation.Builder invocationBuilder = personWebTarget.request();
		Response response = invocationBuilder.post(Entity.entity(customer, MediaType.APPLICATION_JSON));
		return response.getStatus();
	}
}