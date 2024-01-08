package dtu.redGreenRefactor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import dtu.fm13.customer.CustomerService;
import dtu.fm13.customer.model.Customer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PersonServiceSteps {

	Customer customer;
	CustomerService customerService = new CustomerService();
	private List<Customer> customers = new ArrayList<Customer>();
	private int responseCode;

	@When("I call the personService to get person via Json")
	public void iCallTheHelloServiceToGetPersonViaJson() {
		customers = customerService.getPerson();
	}

	@Then("I get a customer with name {string} and address {string}")
	public void iGetAPersonWithNameAndAddress(String name, String address) {
		// Write code here that turns the phrase above into concrete actions
		customer = new Customer(name, address);
		assertEquals(customers.get(0).getName(),name);
		assertEquals(customers.get(0).getAddress(),address);
		
		
	}
	@Given("a customer with name {string} and andress {string}")
	public void aPersonWithNameAndAndress(String name, String address) {
	    customer = new Customer(name, address);
	    customer.setId(4);
	}
	@When("the customer is registered with DTU Pay")
	public void thePersonIsRegisteredWithDTUPay() {
	    responseCode =customerService.add(customer);
	    
	}

	@Then("the person is registered")
	public void thePersonIsRegistered() {
	    assertEquals(200,responseCode);
	}

}
