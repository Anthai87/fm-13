/**
 *
 * @author Harald
 *
 * */
package dtu.fm13.Payment.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import dtu.fm13.Payment.Interfaces.ReportInterface;
import dtu.fm13.Payment.Interfaces.TokenInterface;
import dtu.fm13.Payment.Repository.PaymentRepository;
import dtu.fm13.Payment.models.Account;
import dtu.fm13.Payment.models.Payment;
import dtu.fm13.Payment.models.PaymentInformation;
import dtu.fm13.Payment.models.TokenRequest;
import dtu.ws.fastmoney.BankService;
import dtu.ws.fastmoney.BankServiceException_Exception;
import dtu.ws.fastmoney.BankServiceService;

public class PaymentService {
    BankService bank = new BankServiceService().getBankServicePort();
    PaymentRepository paymentRepository;
    private TokenInterface tokenInterface = new TokenInterface();
    private ReportInterface reportsInterface = new ReportInterface();

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public boolean add(Payment payment) {
        TokenRequest request = tokenInterface.authenticate(payment.getPayerToken());
        if (request.getUserid() == null)
            return false;
        if (!paymentRepository.merchantExists(payment.getMerchantId()))
            return false;

        String payerBankAccount = paymentRepository.getCustomerBankID(UUID.fromString(request.getUserid()));
        String recieverBankAccount = paymentRepository.getCustomerBankID(payment.getMerchantId());
        try {

            bank.transferMoneyFromTo(payerBankAccount, recieverBankAccount, new BigDecimal(payment.getAmount()),
                    recieverBankAccount);

            // Send payment to ReportMicroService
            PaymentInformation p = new PaymentInformation();
            p.setAmount(payment.getAmount());
            p.setPayerId(request.getUserid());
            p.setRecieverId(payment.getMerchantId().toString());
            p.setToken(payment.getPayerToken().toString());
            reportsInterface.add(p);
            return true;
        } catch (BankServiceException_Exception e) {
            return false;
        }

    }

    public boolean addCustomer(Account customer) {
        return paymentRepository.addCustomer(customer);
    }
}