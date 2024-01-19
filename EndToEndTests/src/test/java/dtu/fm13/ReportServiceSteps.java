package dtu.fm13;

import static org.junit.Assert.assertTrue;

import java.util.List;

import dtu.fm13.interfaces.ReportsInterface;
import dtu.fm13.models.Payment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ReportServiceSteps{

private ReportsInterface reportsInterface= new ReportsInterface();
private List<Payment> reports;

@Given("a mangager asks for a list of all payments")
public void aMangagerAsksForAListOfAllPayments() {
    reports=  reportsInterface.payments();
}

@Then("he gets a list of all payments")
public void heGetsAListOfAllPayments() {
    assertTrue(reports.size()>0);
}

@Given("a merchant asks for a list of payments")
public void aMerchantAsksForAListOfPayments() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("all payments contains only merchants ID")
public void allPaymentsContainsOnlyMerchantsID() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("all payments contains only customers ID")
public void allPaymentsContainsOnlyCustomersID() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
}
