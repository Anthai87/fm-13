package org.RedGreenRefactor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import dtu.redGreenRefactor.main.model.Person;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class PersonResource {

	PaymentResource paymentResource;
	private HelloService helloService;

	public PersonResource(HelloService helloService) {
		this.helloService = helloService;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getPersons() {
		return helloService.getPersons();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void postPerson(Person person) {
		helloService.addPerson(person);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deletePersons(Person person) {
		try {
			List<Person> newlist = helloService.getPersons();
			newlist.removeIf(p -> p.getId() == person.getId());
			helloService.setPersons(newlist);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	public PersonResource getPersonResource() {
		return this;
	}

}