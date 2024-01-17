
package dtu.fm13.Service;

//import dtu.fm13.interfaces.PaymentInterface;

import dtu.fm13.models.Payment;
import dtu.fm13.repository.ReportRepository;

import java.util.List;

public class ReportService {

    private ReportRepository reportRepository;
    // private PaymentInterface paymentInterface = new PaymentInterface();

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public List<Payment> getPayments() {
        return reportRepository.getPayments();
    }

    /*  public UUID createCustomer(Customer cust) {
          System.out.println("Create customer, with BankID :" + cust.getAccountID());
          Customer customer = new Customer();
          customer.setAccountID(cust.getAccountID());
          reportRepository.addCustomer(customer);
         //add to PaymentService
         paymentInterface.addCustomer(customer);

          return customer.getId();
      }*/
  /*  public UUID createCustomer(Customer cust) {
        System.out.println("Create customer, with BankID :" + cust.getAccountID());
        Customer customer = new Customer();
        customer.setAccountID(cust.getAccountID());
        reportRepository.addCustomer(customer);
        //add to PaymentService
        paymentInterface.addCustomer(customer);

        return customer.getId();
    }

    public void deleteCustomer(Customer customer) {

        try {
            List<Customer> newlist = reportRepository.getPayments();
            newlist.removeIf(p -> p.getId() == customer.getId());
            reportRepository.setPayments(newlist);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public boolean exists(String accountID) {
        return reportRepository.existsCustomer(UUID.fromString(accountID));
    }*/


}