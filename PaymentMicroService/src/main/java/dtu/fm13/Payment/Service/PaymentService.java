/*Harald
 */
package dtu.fm13.Payment.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import dtu.fm13.Payment.Interfaces.TokenInterface;
import dtu.fm13.Payment.Repository.PaymentRepository;
import dtu.fm13.Payment.models.Account;
import dtu.fm13.Payment.models.Payment;
import dtu.fm13.Payment.models.TokenRequest;
import dtu.ws.fastmoney.BankService;
import dtu.ws.fastmoney.BankServiceException_Exception;
import dtu.ws.fastmoney.BankServiceService;

public class PaymentService {
    BankService bank = new BankServiceService().getBankServicePort();
    PaymentRepository paymentRepository;
    private TokenInterface tokenInterface= new TokenInterface();
  
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.getPayments();
    }

    public boolean add(Payment payment) {
        //token authentic
        //merchant exist
        TokenRequest request = tokenInterface.authenticate(payment.getPayerToken());
         if (request.getUserid()==null) return false;
        System.out.println("token accepted!");
        if (!paymentRepository.merchantExists(payment.getMerchantId())) return false;

        
            String payerBankAccount = paymentRepository.getCustomerBankID(UUID.fromString(request.getUserid()));
            String recieverBankAccount = paymentRepository.getCustomerBankID(payment.getMerchantId());
            System.out.println("pID:" + payerBankAccount + ". rID:" + recieverBankAccount);
            try {
         
                bank.transferMoneyFromTo(payerBankAccount, recieverBankAccount, new BigDecimal(payment.getAmount()),
                        recieverBankAccount);
                paymentRepository.addPayment(payment);
                //Send payment to ReportMicroService
                return true;
            } catch (BankServiceException_Exception e) {
         
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
        
 }

    public boolean addCustomer(Account customer) {
        return paymentRepository.addCustomer(customer);
    }
}