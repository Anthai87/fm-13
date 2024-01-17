/*Harald
 */
package dtu.fm13.Payment.Service;

import java.math.BigDecimal;
import java.util.List;

import dtu.fm13.Payment.Repository.PaymentRepository;
import dtu.fm13.Payment.models.account;
import dtu.fm13.Payment.models.Payment;
import dtu.ws.fastmoney.BankService;
import dtu.ws.fastmoney.BankServiceException_Exception;
import dtu.ws.fastmoney.BankServiceService;

public class PaymentService {
    BankService bank = new BankServiceService().getBankServicePort();
    PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.getPayments();
    }

    public boolean add(Payment payment) {
        if (paymentRepository.customerExists(payment.getPayerId())
                && paymentRepository.customerExists(payment.getRecieverId())) {
        
            String payerBankAccount = paymentRepository.getCustomerBankID(payment.getPayerId());
            String recieverBankAccount = paymentRepository.getCustomerBankID(payment.getRecieverId());
            System.out.println("pID:" + payerBankAccount + ". rID:" + recieverBankAccount);
            try {
         
                bank.transferMoneyFromTo(payerBankAccount, recieverBankAccount, new BigDecimal(payment.getAmount()),
                        recieverBankAccount);
                paymentRepository.addPayment(payment);
                return true;
            } catch (BankServiceException_Exception e) {
         
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
        }
      
        //paymentRepository.addPayment(payment);
        return false;
    }

    public boolean addCustomer(account customer) {
        return paymentRepository.addCustomer(customer);
    }
}