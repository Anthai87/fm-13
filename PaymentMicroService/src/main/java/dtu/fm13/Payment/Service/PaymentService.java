package dtu.fm13.Payment.Service;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;
import java.util.List;

import dtu.fm13.Payment.Repository.PaymentRepository;
import dtu.fm13.Payment.models.Payment;

@Path("/payments2")
public class PaymentService {

    PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.getPayments();
    }

    public boolean add(Payment payment) {
    //    if (customerResource.existsCustomer(payment.getPayerId())
	// 			&& customerResource.existsCustomer(payment.getRecieverId())) {
	// 		String payerBankAccount = customerResource.getCustomerBankID(payment.getPayerId());
	// 		String recieverBankAccount = customerResource.getCustomerBankID(payment.getRecieverId());
	// 		try {
	// 			bank.transferMoneyFromTo(payerBankAccount.toString(),recieverBankAccount.toString(),new BigDecimal( payment.getAmount()), recieverBankAccount.toString());
	// 		} catch (BankServiceException_Exception e) {
	// 			// TODO Auto-generated catch block
	// 			e.printStackTrace();
	// 		}
	// 		customerResource.addPayment(payment);
	// 	}
       
       
        paymentRepository.add(payment);
        //catch nonexisting users 
        return true;
    }
}