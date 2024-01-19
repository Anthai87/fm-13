package dtu.fm13;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dtu.fm13.helpers.UserHelper;
import dtu.fm13.interfaces.CustomerInterface;
import dtu.fm13.interfaces.MerchantInterface;
import dtu.fm13.interfaces.PaymentInterface;
import dtu.fm13.models.Account;
import dtu.fm13.models.Payment;
import dtu.ws.fastmoney.BankService;
import dtu.ws.fastmoney.BankServiceException_Exception;
import dtu.ws.fastmoney.BankServiceService;
import dtu.ws.fastmoney.User;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;

public class PaymentServiceSteps {
    Account customer;
    Account merchant;
    List<Account> accounts = new ArrayList<Account>();
    private Payment payment;
    private PaymentInterface paymentService = new PaymentInterface();
    private int returncode;
    private List<Payment> payments;
     final BankService bankService = new BankServiceService().getBankServicePort();
    private CustomerInterface customerService = new CustomerInterface();

    private MerchantInterface merchantInterfaceService = new MerchantInterface();
    private UserHelper userHelper = new UserHelper();
    private List<String> tokenList;
    private String token;


    // Harald & Elias
    @Given("a customer with id {string}")
    public void aCustomerWithId(String id) {
        customer = new Account();
        customer.setId(UUID.fromString(id));
        User user = userHelper.getCustomer();
        String bankID = userHelper.getBankID(user);
        customer.setAccountID(bankID);
        Response response = customerService.create(customer);
       
        customer.setId(response.readEntity(new GenericType<UUID>() {
        }));
        accounts.add(customer);
        assertNotNull(customer.getId());
        assertNotNull(customer.getAccountID()); 
        response.close();
    }

    // Harald &Elias
    @Given("a merchant with id {string}")
    public void aMerchantWithId(String id) {
        merchant = new Account();
        User user = userHelper.getMerchant();
        String bankID = userHelper.getBankID(user);
        merchant.setAccountID(bankID);
        assertNotNull(merchant.getAccountID());
        Response response = merchantInterfaceService.create(merchant);
        
        System.out.println("setting merchant id");
        merchant.setId(response.readEntity(new GenericType<UUID>() {
        }));
        assertNotNull(merchant.getId());
        assertNotNull(customer.getAccountID());
        accounts.add(merchant);
        response.close();
    }

    // Harald
    @When("the merchant initiates a payment for {int} kr by the customer")
    public void theMerchantInitiatesAPaymentForKrByTheCustomer(Integer amount) {

        payment = new Payment(UUID.fromString(token), merchant.getId(), amount);

        returncode = paymentService.postPayment(payment);
    }

    // Harald
    @Then("the payment is successful")
    public void thePaymentIsSuccessful() {
        assertEquals(201, returncode);
    }

    

    // Anthony
    @When("the manager asks for a list of payments")
    public void theManagerAsksForAListOfPayments() {
        payments = paymentService.getList(merchant);
    }

    // Harald, Anthony, Elias
    @Then("the list contains a payments where customer {string} paid {int} kr to merchant {string}")
    public void theListContainsAPaymentsWhereCustomerPaidKrToMerchant(String cust, Integer amount, String mer) {
        assertTrue(payments.contains(payment));
    }

    //Harald
    @Given("a customer with a bank account with balance {int}")
    public void aCustomerWithABankAccountWithBalance(Integer int1) {
        User user = new User();
        user.setCprNumber(UUID.randomUUID().toString());
        user.setFirstName("mister");
        user.setLastName("bean");
        customer = new Account();
        customer.setAccountID((userHelper.createBankAccount(user, int1)));
        BigDecimal amount = new BigDecimal(0);
        try {
            amount = bankService.getAccount(customer.getAccountID()).getBalance();
        } catch (BankServiceException_Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertEquals(int1, amount.intValue());
        accounts.add(customer);
    }

    //Harald
    @Given("that the customer is registered with DTU Pay")
    public void thatTheCustomerIsRegisteredWithDTUPay() {
        Response response = customerService.create(customer);
        customer.setId(response.readEntity(new GenericType<UUID>() {
        }));
        response.close();
        assertNotNull(customer.getId());
    }

    //Harald, Elias
    @Given("a merchant with a bank account with balance {int}")
    public void aMerchantWithABankAccountWithBalance(Integer int1) {
        User user = new User();
        user.setCprNumber(UUID.randomUUID().toString());
        user.setFirstName("mister");
        user.setLastName("bean");
        merchant = new Account();
        merchant.setAccountID((userHelper.createBankAccount(user, int1)));
        BigDecimal amount = new BigDecimal(0);
        //Move to server!!!!
        try {
            amount = bankService.getAccount(merchant.getAccountID()).getBalance();
        } catch (BankServiceException_Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertEquals(int1, amount.intValue());
        accounts.add(merchant);
    }


    //Harald, Anthony
    @Given("that the merchant is registered with DTU Pay")
    public void thatTheMerchantIsRegisteredWithDTUPay() {

        Response response = merchantInterfaceService.create(merchant);
        
        merchant.setId(response.readEntity(new GenericType<UUID>() {
        }));
        response.close();
        assertNotNull(merchant.getId());

    }

    //Harald, Elias
    @Then("the balance of the customer at the bank is {int} kr")
    public void theBalanceOfTheCustomerAtTheBankIsKr(Integer int1) {
        BigDecimal balance = new BigDecimal(-1);
        try {
            balance = bankService.getAccount(customer.getAccountID()).getBalance();
        } catch (BankServiceException_Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertEquals(int1, balance.intValue());
    }

    //Harald, Elias
    @Then("the balance of the merchant at the bank is {int} kr")
    public void theBalanceOfTheMerchantAtTheBankIsKr(Integer int1) {
        BigDecimal balance = new BigDecimal(-1);
        try {
            balance = bankService.getAccount(merchant.getAccountID()).getBalance();
        } catch (BankServiceException_Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertEquals(int1, balance.intValue());
    }


    // Elias, Harald og Anthony
    @When("a customer requests tokens")
    public void aCustomerRequestsTokens() {
        tokenList = customerService.tokenlist(customer);
    }

    // Elias, Harald og Anthony
    @Then("dtu-Pay returns a list of {int} tokens")
    public void dtuPayReturnsAListOfTokens(Integer int1) {
        assertEquals(int1, tokenList.size());
    }

    // Elias, Harald og Anthony
    @When("customer gives the merchant a token")
    public void customerGivesTheMerchantAToken() {
        token = tokenList.get(0);
    }

    // Elias, Harald og Anthony
    @Then("the payment failed")
    public void thePaymentFailed() {
        assertEquals(400, returncode);

    }


    @After
    public void cleanupBank() {
        for (Account a : accounts) {
            try {
                bankService.retireAccount(a.getAccountID());
            } catch (BankServiceException_Exception e) {

            }
        }
    }
    
}
