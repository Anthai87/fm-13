package dtu.redGreenRefactor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import dtu.redGreenRefactor.main.model.Person;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;



public class PersonService {
	private List<Person> persons = new ArrayList<Person>();

	WebTarget webTarget;

	public PersonService() {
	Client client = ClientBuilder.newClient();
	this.webTarget = client.target("http://fm-13.compute.dtu.dk:8080");
	}
	
	public List<Person> getPerson() {
		WebTarget personWebTarget = webTarget.path("/person");
		Invocation.Builder invocationBuilder = personWebTarget.request();
		Response response = invocationBuilder.get();
		List<Person> personList = response.readEntity(new GenericType<List<Person>>() {});
		
		return personList;
	}

	public int add(Person person) {
		WebTarget personWebTarget = webTarget.path("/person");
		Invocation.Builder invocationBuilder = personWebTarget.request();
		Response response = invocationBuilder.post(Entity.entity(person, MediaType.APPLICATION_JSON));
		return response.getStatus();
	}
}