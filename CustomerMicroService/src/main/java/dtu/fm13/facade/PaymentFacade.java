package dtu.fm13.facade;

import dtu.fm13.models.Payment;
import dtu.fm13.repository.CustomerRepository;
import dtu.ws.fastmoney.BankService;
import dtu.ws.fastmoney.BankServiceException_Exception;
import dtu.ws.fastmoney.BankServiceService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;
import java.util.List;

public class PaymentFacade {

	private CustomerRepository customerResource;
	BankService bank = new BankServiceService().getBankServicePort();

	public PaymentFacade(CustomerRepository customerResource) {
		this.customerResource = customerResource;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payment> getAllPayments() {
		return customerResource.getPayments();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postPayment(Payment payment) {
		if (customerResource.existsCustomer(payment.getPayerId())
				&& customerResource.existsCustomer(payment.getRecieverId())) {
			String payerBankAccount = customerResource.getCustomerBankID(payment.getPayerId());
			String recieverBankAccount = customerResource.getCustomerBankID(payment.getRecieverId());
			try {
				bank.transferMoneyFromTo(payerBankAccount.toString(),recieverBankAccount.toString(),new BigDecimal( payment.getAmount()), recieverBankAccount.toString());
			} catch (BankServiceException_Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			customerResource.addPayment(payment);

			return Response.status(Response.Status.CREATED).build();
		}
		return Response.status(Response.Status.BAD_REQUEST).build();

	}
}