package dtu.redGreenRefactor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import dtu.redGreenRefactor.main.model.Person;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PersonServiceSteps {

	Person person;
	PersonService personService = new PersonService();
	private List<Person> persons = new ArrayList<Person>();
	private int responseCode;

	@When("I call the personService to get person via Json")
	public void iCallTheHelloServiceToGetPersonViaJson() {
		persons = personService.getPerson();
	}

	@Then("I get a customer with name {string} and address {string}")
	public void iGetAPersonWithNameAndAddress(String name, String address) {
		// Write code here that turns the phrase above into concrete actions
		person = new Person(name, address);
		assertEquals(persons.get(0).getName(),name);
		assertEquals(persons.get(0).getAddress(),address);
		
		
	}
	@Given("a customer with name {string} and andress {string}")
	public void aPersonWithNameAndAndress(String name, String address) {
	    person = new Person(name, address);
	    person.setId(4);
	}
	@When("the customer is registered with DTU Pay")
	public void thePersonIsRegisteredWithDTUPay() {
	    responseCode =personService.add(person);
	    
	}

	@Then("the person is registered")
	public void thePersonIsRegistered() {
	    assertEquals(200,responseCode);
	}

}
