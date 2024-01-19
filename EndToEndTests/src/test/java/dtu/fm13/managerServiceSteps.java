package dtu.fm13;

import static org.junit.Assert.assertTrue;

import java.util.List;

import dtu.fm13.interfaces.ReportsInterface;
import dtu.fm13.models.PaymentInformation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class managerServiceSteps {

    private ReportsInterface reportsInterface = new ReportsInterface();
    private PaymentServiceSteps paymentServiceSteps = new PaymentServiceSteps();
    private List<PaymentInformation> reports;

    @Given("a mangager asks for a list of all payments")
    public void aMangagerAsksForAListOfAllPayments() {
        reports = reportsInterface.payments();
    }

    @Then("he gets a list of all payments")
    public void heGetsAListOfAllPayments() {
        assertTrue(reports.size() > 0);
    }

    // Harald, Anthony
    @Given("a successful payment of {int} kr from customer with name {string} to merchant {string}")
    public void aSuccessfulPaymentOfKrFromCustomerToMerchant(Integer amount, String cust, String mer) {
        // creating accounts in bank and DTU-Pay
        paymentServiceSteps.aCustomerWithABankAccountWithBalance(1000);
        paymentServiceSteps.thatTheCustomerIsRegisteredWithDTUPay();
        paymentServiceSteps.aMerchantWithABankAccountWithBalance(1000);
        paymentServiceSteps.thatTheMerchantIsRegisteredWithDTUPay();
        // Tokens
        paymentServiceSteps.aCustomerRequestsTokens();
        paymentServiceSteps.customerGivesTheMerchantAToken();
        // transaction and saving accounts for destruction at @after
        paymentServiceSteps.theMerchantInitiatesAPaymentForKrByTheCustomer(amount);
        paymentServiceSteps.thePaymentIsSuccessful();
        paymentServiceSteps.accounts.add(paymentServiceSteps.customer);
        paymentServiceSteps.accounts.add(paymentServiceSteps.merchant);
    }

    @Given("a merchant asks for a list of payments")
    public void aMerchantAsksForAListOfPayments() {

        reports = reportsInterface.payments(paymentServiceSteps.merchant.getId());
    }

    @Then("all payments contains only merchants ID")
    public void allPaymentsContainsOnlyMerchantsID() {
        boolean test = true;
        for (PaymentInformation p : reports) {
            if (!(p.getPayerId().equals(paymentServiceSteps.merchant.getId().toString())
                    || p.getRecieverId().equals(paymentServiceSteps.merchant.getId().toString()))) {
                test = false;
            }
        }
        assertTrue(test);
    }

    @Given("a Customer asks for a list of payments")
    public void aCustomerAsksForAListOfPayments() {
        reports = reportsInterface.payments(paymentServiceSteps.customer.getId());
    }

    @Then("all payments contains only customers ID")
    public void allPaymentsContainsOnlyCustomersID() {
        boolean test = true;
        for (PaymentInformation p : reports) {
            if (!(p.getPayerId().equals(paymentServiceSteps.customer.getId().toString())
                    || p.getRecieverId().equals(paymentServiceSteps.customer.getId().toString()))) {
                test = false;
            }
        }
        assertTrue(test);
    }

}
