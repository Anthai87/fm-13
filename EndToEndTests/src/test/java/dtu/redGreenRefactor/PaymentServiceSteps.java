package dtu.redGreenRefactor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import dtu.fm13.customer.PaymentService;
import dtu.fm13.customer.model.Customer;
import dtu.fm13.customer.model.Payment;
import dtu.ws.fastmoney.BankService;
import dtu.ws.fastmoney.BankServiceException_Exception;
import dtu.ws.fastmoney.BankServiceService;
import dtu.ws.fastmoney.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentServiceSteps {
	private Customer customer;
	private Customer merchant;
	private Payment payment;
	private PaymentService paymentService = new PaymentService();
	private int returncode;
	private List<Payment> payments;
	private final BankService bankService = new BankServiceService().getBankServicePort();
	private String returnID;

	// Harald
	@Given("a customer with id {string}")
	public void aCustomerWithId(String id) {
		customer = new Customer("customer", "name");

		customer.setId(id);
	}

	// Harald
	@Given("a merchant with id {string}")
	public void aMerchantWithId(String id) {
		merchant = new Customer("merchant", "name");
		
		merchant.setId(id);

	}

	// Harald
	@When("the merchant initiates a payment for {float} kr by the customer")
	public void theMerchantInitiatesAPaymentForKrByTheCustomer(Float amount) {
		payment = new Payment(customer.getId(), merchant.getId(), amount);
		returncode = paymentService.postPayment(payment, merchant);
	}

	// Harald
	@Then("the payment is successful")
	public void thePaymentIsSuccessful() {
		assertEquals(201, returncode);
	}

	// Harald
	@Given("a successful payment of {float} kr from customer {string} to merchant {string}")
	public void aSuccessfulPaymentOfKrFromCustomerToMerchant(float amount, String cust, String mer) {
		aCustomerWithId(cust);
		aMerchantWithId(mer);
		theMerchantInitiatesAPaymentForKrByTheCustomer(amount);
		thePaymentIsSuccessful();
	}

	// Anthony
	@When("the manager asks for a list of payments")
	public void theManagerAsksForAListOfPayments() {
		payments = paymentService.getList(merchant);
	}

	// Harald
	@Then("the list contains a payments where customer {string} paid {float} kr to merchant {string}")
	public void theListContainsAPaymentsWhereCustomerPaidKrToMerchant(String cust, float amount, String mer) {
		payment.setPayerId(cust);
		payment.setAmount(amount);
		payment.setRecieverId(mer);
		assertTrue(payments.contains(payment));
	}

	@Given("a customer with a bank account with balance {int}")
	public void aCustomerWithABankAccountWithBalance(Integer int1) {
		User user = new User();
		user.setCprNumber("1234567891");
		user.setFirstName("Harald");
		user.setLastName("testLastname");

		try {
			returnID = bankService.createAccountWithBalance(user, new BigDecimal(int1));
			System.out.println(returnID);
			customer.setId(returnID);
			customer.setFirstName(user.getFirstName());
			customer.setCpr(user.getCprNumber());
			customer.setLastName(user.getLastName());
		} catch (BankServiceException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Given("that the customer is registered with DTU Pay")
	public void thatTheCustomerIsRegisteredWithDTUPay() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("a merchant with a bank account with balance {int}")
	public void aMerchantWithABankAccountWithBalance(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("that the merchant is registered with DTU Pay")
	public void thatTheMerchantIsRegisteredWithDTUPay() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the balance of the customer at the bank is {int} kr")
	public void theBalanceOfTheCustomerAtTheBankIsKr(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the balance of the merchant at the bank is {int} kr")
	public void theBalanceOfTheMerchantAtTheBankIsKr(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
