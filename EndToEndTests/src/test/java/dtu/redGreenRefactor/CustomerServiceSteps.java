package dtu.redGreenRefactor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dtu.fm13.customer.CustomerService;
import dtu.fm13.customer.model.Customer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jakarta.ws.rs.core.Response;

public class CustomerServiceSteps {

	Customer customer;
	CustomerService customerService = new CustomerService();
	private List<Customer> customers = new ArrayList<Customer>();
	private Response responseCode;

	@When("I call the personService to get person via Json")
	public void iCallTheHelloServiceToGetPersonViaJson() {
	    
		customers = customerService.getPerson();
	}

	@Then("I get a customer with name {string} and address {string}")
	public void iGetAPersonWithNameAndAddress(String firstName, String lastName) {
		// Write code here that turns the phrase above into concrete actions
		customer = new Customer(firstName, lastName);
		customer.setCpr("cpr");
		customer.setId(UUID.randomUUID());
		customers.contains(customer);
		
		
	}
	@Given("a customer with name {string} and andress {string}")
	public void aPersonWithNameAndAndress(String name, String address) {
	    customer = new Customer(name, address);
	    customer.setId(UUID.randomUUID());
	    customer.setCpr("cpr");
	    customers.add(customer);
	}
	@When("the customer is registered with DTU Pay")
	public void thePersonIsRegisteredWithDTUPay() {
		
	    responseCode =customerService.create(customer.getId());
	    
	}

	@Then("the customer is registered")
	public void thePersonIsRegistered() {
		customers = customerService.getPerson();
		assertEquals(200,responseCode.getStatus());
		
	    System.out.println("custid: "+ customer.getId());
	    for (Customer c: customers) {
		    System.out.println("custid: "+ c.getId());

	    }
	    assertTrue(customers.contains(customer));
	}

}
