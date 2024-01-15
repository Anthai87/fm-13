package dtu.fm13;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import dtu.fm13.helpers.UserHelper;
import dtu.fm13.interfaces.CustomerInterface;
import dtu.fm13.interfaces.PaymentInterface;
import dtu.fm13.models.Customer;
import dtu.fm13.models.Payment;
import dtu.ws.fastmoney.BankService;
import dtu.ws.fastmoney.BankServiceException_Exception;
import dtu.ws.fastmoney.BankServiceService;
import dtu.ws.fastmoney.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;

public class PaymentServiceSteps {
	private Customer customer;
	private Customer merchant;
	private Payment payment;
	private PaymentInterface paymentService = new PaymentInterface();
	private int returncode;
	private List<Payment> payments;
	private final BankService bankService = new BankServiceService().getBankServicePort();
	private String returnID;
	private CustomerInterface customerService = new CustomerInterface();
	private Response responseCode;;
	private UserHelper userHelper = new UserHelper();
	private String customerBankID;
	private String merchantBankID;
	

	// Harald & Elias
	@Given("a customer with id {string}")
	public void aCustomerWithId(String id) {
		customer = new Customer("customer", "name");
		customer.setId(UUID.fromString(id));

		User user = userHelper.getCustomer();

		String bankID = userHelper.getBankID(user);
		System.out.println("BankID: " + bankID);
		Response response = customerService.create(bankID);
		
		customer.setId(response.readEntity(new GenericType<UUID>() {
		}));
	}

	// Harald &Elias
	@Given("a merchant with id {string}")
	public void aMerchantWithId(String id) {
		merchant = new Customer("merchant", "name");
		User user = userHelper.getMerchant();
		String bankID = userHelper.getBankID(user);

		merchant.setId(UUID.fromString(id));

		Response response = customerService.create(bankID);
		merchant.setId(response.readEntity(new GenericType<UUID>() {}));
	}

	// Haraldhttp://fm-00.compute.dtu.dk/rest/accounts
	@When("the merchant initiates a payment for {int} kr by the customer")
	public void theMerchantInitiatesAPaymentForKrByTheCustomer(Integer amount) {
		payment = new Payment(customer.getId(), merchant.getId(), amount);

		returncode = paymentService.postPayment(payment);
	}

	// Harald
	@Then("the payment is successful")
	public void thePaymentIsSuccessful() {
		assertEquals(201, returncode);
	}

	// Harald
	@Given("a successful payment of {int} kr from customer with name {string} to merchant {string}")
	public void aSuccessfulPaymentOfKrFromCustomerToMerchant(Integer amount, String cust, String mer) {
		User user = userHelper.getCustomer();
		customer = new Customer();
		customer.setFirstName(cust);
		String bankID = userHelper.getBankID(user);
		Response response = customerService.create(bankID);
		customer.setId(response.readEntity(new GenericType<UUID>() {
		}));

		User user2 = userHelper.getCustomer();
		merchant = new Customer();
		merchant.setFirstName(mer);
		bankID = userHelper.getBankID(user2);http://fm-00.compute.dtu.dk/rest/accounts
		response = customerService.create(bankID);
		merchant.setId(response.readEntity(new GenericType<UUID>() {
		}));
		payment = new Payment();
		payment.setPayerId(customer.getId());
		payment.setRecieverId(merchant.getId());
		payment.setAmount(amount);
		theMerchantInitiatesAPaymentForKrByTheCustomer(amount);
		thePaymentIsSuccessful();
	}

	// Anthony
	@When("the manager asks for a list of payments")
	public void theManagerAsksForAListOfPayments() {
		payments = paymentService.getList(merchant);
	}

	// Harald
	@Then("the list contains a payments where customer {string} paid {int} kr to merchant {string}")
	public void theListContainsAPaymentsWhereCustomerPaidKrToMerchant(String cust, Integer amount, String mer) {
		assertTrue(payments.contains(payment));
	}

	@Given("a customer with a bank account with balance {int}")
	public void aCustomerWithABankAccountWithBalance(Integer int1) {
		User user = new User();
		user.setCprNumber(UUID.randomUUID().toString());
		user.setFirstName("mister");
		user.setLastName("bean");
		customer = new Customer();
		customerBankID = userHelper.createBankAccount(user, int1);
		BigDecimal amount = new BigDecimal(0);
		try {
			amount = bankService.getAccount(customerBankID).getBalance();
		} catch (BankServiceException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(int1, amount.intValue());
	}

	@Given("that the customer is registered with DTU Pay")
	public void thatTheCustomerIsRegisteredWithDTUPay() {
		Response response = customerService.create(customerBankID);
		customer.setId(response.readEntity(new GenericType<UUID>() {}));
		assertNotNull(customer.getId());
	}

	@Given("a merchant with a bank account with balance {int}")
	public void aMerchantWithABankAccountWithBalance(Integer int1) {
		User user = new User();
		user.setCprNumber(UUID.randomUUID().toString());
		user.setFirstName("iste");
		user.setLastName("mNam");
		merchant = new Customer();
		merchantBankID = userHelper.createBankAccount(user, int1);
		BigDecimal amount = new BigDecimal(0);
		//Move to server!!!!
		try {
			amount = bankService.getAccount(merchantBankID).getBalance();
		} catch (BankServiceException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(int1, amount.intValue());
	}

	

	@Given("that the merchant is registered with DTU Pay")
	public void thatTheMerchantIsRegisteredWithDTUPay() {

		Response response = customerService.create(merchantBankID);
		merchant.setId(response.readEntity(new GenericType<UUID>() {}));
		assertNotNull(merchant.getId());

	}

	@Then("the balance of the customer at the bank is {int} kr")
	public void theBalanceOfTheCustomerAtTheBankIsKr(Integer int1) {
		BigDecimal balance= new BigDecimal(-1);
		try {
			balance = bankService.getAccount(customerBankID).getBalance();
		} catch (BankServiceException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(int1,balance.intValue());
	}

	@Then("the balance of the merchant at the bank is {int} kr")
	public void theBalanceOfTheMerchantAtTheBankIsKr(Integer int1) {
		BigDecimal balance= new BigDecimal(-1);
		try {
			balance = bankService.getAccount(merchantBankID).getBalance();
		} catch (BankServiceException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(int1,balance);
	}

}
