package dtu.redGreenRefactor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import dtu.fm13.customer.Payment;
import dtu.fm13.customer.PaymentService;
import dtu.fm13.customer.model.Customer;
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


	@Given("a customer with id {int}")
	public void aCustomerWithId(int id) {
		customer = new Customer("customer", "name");

		customer.setId(id);
	}

	@Given("a merchant with id {int}")
	public void aMerchantWithId(int id) {
		merchant = new Customer("merchant", "name");
		merchant.setId(id);

	}

	@When("the merchant initiates a payment for {float} kr by the customer")
	public void theMerchantInitiatesAPaymentForKrByTheCustomer(Float amount) {
		payment = new Payment(customer.getId(), merchant.getId(), amount);
		returncode = paymentService.postPayment(payment, merchant);
	}

	@Then("the payment is successful")
	public void thePaymentIsSuccessful() {
		assertEquals(201, returncode);
	}

	@Given("a successful payment of {float} kr from customer {int} to merchant {int}")
	public void aSuccessfulPaymentOfKrFromCustomerToMerchant(float amount, Integer cust, Integer mer) {
		aCustomerWithId(cust);
		aMerchantWithId(mer);
		theMerchantInitiatesAPaymentForKrByTheCustomer(amount);
		thePaymentIsSuccessful();
	}

	@When("the manager asks for a list of payments")
	public void theManagerAsksForAListOfPayments() {
		payments = paymentService.getList(merchant);
	}

	@Then("the list contains a payments where customer {int} paid {float} kr to merchant {int}")
	public void theListContainsAPaymentsWhereCustomerPaidKrToMerchant(Integer cust, float amount, Integer mer) {
		payment.setPayerId(cust);
		payment.setAmount(amount);
		payment.setRecieverId(mer);

		boolean predicate = false;
		for (Payment payment2 : payments) {
			if (payment2.equals(payment)) {
				predicate = true;
				break;
			}
		}
		assertTrue(predicate);
	}

	@Given("a customer with a bank account with balance {int}")
	public void aCustomerWithABankAccountWithBalance(Integer int1) {

		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
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
