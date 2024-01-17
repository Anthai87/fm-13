/*Harald
 */
package dtu.fm13.Payment.facade;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import dtu.fm13.Payment.Repository.PaymentRepository;
import dtu.fm13.Payment.Service.PaymentService;
import dtu.fm13.Payment.models.account;
import dtu.fm13.Payment.models.Payment;

@Path("/payments")
public class PaymentFacade {

    private PaymentService paymentService;
    private PaymentRepository paymentRepository;

    public PaymentFacade() {
        this.paymentRepository = new PaymentRepository();
        this.paymentService = new PaymentService(paymentRepository);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Payment> getAllPayments() {
        return paymentRepository.getPayments();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postPayment(Payment payment) {
        System.out.println("got a payment request, PID:" + payment.getPayerId() +". RID:" + payment.getRecieverId());
        if (paymentService.add(payment)) {
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();

    }
    @Path("/customer")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCostumer(account customer){
        if (paymentService.addCustomer(customer)) {
            System.out.println("CID:" + customer.getId() + ", BankID: " + customer.getAccountID());
            return Response.status(Response.Status.CREATED).build();

        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}