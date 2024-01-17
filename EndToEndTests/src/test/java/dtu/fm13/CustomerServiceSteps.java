package dtu.fm13;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dtu.fm13.interfaces.CustomerInterface;
import dtu.fm13.models.Customer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;

public class CustomerServiceSteps {

	Customer customer;
	CustomerInterface customerInterface = new CustomerInterface();
	private List<Customer> customers = new ArrayList<Customer>();
	private Response response;

	@When("I call the personService to get person via Json")
	public void iCallTheHelloServiceToGetPersonViaJson() {

		customers = customerInterface.customerList();
	}

	@Then("I get a customer with name {string} and address {string}")
	public void iGetAPersonWithNameAndAddress(String firstName, String lastName) {
		// Write code here that turns the phrase above into concrete actions
		customer = new Customer(firstName, lastName, "1234567890");
		customer.setId(UUID.randomUUID());
		customers.contains(customer);

	}

	@Given("a customer with first name {string}, last name {string} and crp {string}")
	public void aCustomerWithFirstNameLastNameAndCrp(String firstname, String lastname, String cpr) {
		customer = new Customer(firstname, lastname, cpr);
		customer.setId(UUID.randomUUID());
		customer.setCpr("cpr");
		customers.add(customer);
	}

	@When("the customer is registered with DTU Pay")
	public void thePersonIsRegisteredWithDTUPay() {

		customer = new Customer();
		customer.setFirstName("Børge");
		customer.setAccountID("94136db5-52c1-47a4-bebe-09a65803d8cf");
		response = customerInterface.create(customer);

		customer.setId(response.readEntity(new GenericType<UUID>() {
		}));

	}

	@Then("the customer is registered")
	public void thePersonIsRegistered() {
		customers = customerInterface.customerList();
		assertEquals(200, response.getStatus());
		assertTrue(customers.contains(customer));
	}

	@When("the customer is deleted")
	public void theCustomerIsDeleted() {
		response =customerInterface.delete(customer);
	}

	@Then("the customer is not registered")
	public void theCustomerIsNotRegistered() {
		assertEquals(200, response.getStatus());
	}
}
