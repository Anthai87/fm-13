package dtu.redGreenRefactor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import dtu.fm13.customer.CustomerService;
import dtu.fm13.customer.model.Customer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerServiceSteps {

	Customer customer;
	CustomerService customerService = new CustomerService();
	private List<Customer> customers = new ArrayList<Customer>();
	private int responseCode;

	@When("I call the personService to get person via Json")
	public void iCallTheHelloServiceToGetPersonViaJson() {
		customers = customerService.getPerson();
	}

	@Then("I get a customer with name {string} and address {string}")
	public void iGetAPersonWithNameAndAddress(String firstName, String lastName) {
		// Write code here that turns the phrase above into concrete actions
		customer = new Customer(firstName, lastName);
		customer.setCpr("cpr");
		customer.setId("4");
		customers.contains(customer);
		
		
	}
	@Given("a customer with name {string} and andress {string}")
	public void aPersonWithNameAndAndress(String name, String address) {
	    customer = new Customer(name, address);
	    customer.setId("4");
	    customer.setCpr("cpr");
	    customers.add(customer);
	}
	@When("the customer is registered with DTU Pay")
	public void thePersonIsRegisteredWithDTUPay() {
	    responseCode =customerService.add(customer);
	    
	}

	@Then("the customer is registered")
	public void thePersonIsRegistered() {
		customers = customerService.getPerson();
		assertEquals(204,responseCode);
	    
	    assertTrue(customers.contains(customer));
	}

}
