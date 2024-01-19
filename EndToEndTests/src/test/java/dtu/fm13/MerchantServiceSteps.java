//Harald

package dtu.fm13;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dtu.fm13.interfaces.MerchantInterface;
import dtu.fm13.interfaces.ReportsInterface;
import dtu.fm13.models.Account;
import dtu.fm13.models.Payment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;

public class MerchantServiceSteps {

	Account merchant;
	MerchantInterface merchantInterface = new MerchantInterface();
	private List<Account> merchants = new ArrayList<Account>();
	private Response response;
	
	@Then("I get a merchant with name {string} and address {string}")
	public void iGetAPersonWithNameAndAddress(String firstName, String lastName) {
		// Write code here that turns the phrase above into concrete actions
		merchant = new Account(firstName, lastName, "1234567890");
		merchant.setId(UUID.randomUUID());
		merchants.contains(merchant);

	}

	@Given("a merchant with first name {string}, last name {string} and crp {string}")
	public void aCustomerWithFirstNameLastNameAndCrp(String firstname, String lastname, String cpr) {
		merchant = new Account(firstname, lastname, cpr);
		merchant.setId(UUID.randomUUID());
		merchant.setCpr("cpr");
		merchants.add(merchant);
	}

	@When("the merchant is registered with DTU Pay")
	public void thePersonIsRegisteredWithDTUPay() {

		merchant = new Account();
		merchant.setFirstName("Børge");
		merchant.setAccountID("94136db5-52c1-47a4-bebe-09a65803d8cf");
		response = merchantInterface.create(merchant);

		merchant.setId(response.readEntity(new GenericType<UUID>() {
		}));

	}

	@Then("the merchant is registered")
	public void thePersonIsRegistered() {
		merchants = merchantInterface.merchantList();
		assertEquals(200, response.getStatus());
		assertTrue(merchants.contains(merchant));
	}

	@When("the merchant is deleted")
	public void theCustomerIsDeleted() {
		response = merchantInterface.delete(merchant);
	}

	@Then("the merchant is not registered")
	public void theCustomerIsNotRegistered() {
		assertEquals(200, response.getStatus());
	}

	

}
