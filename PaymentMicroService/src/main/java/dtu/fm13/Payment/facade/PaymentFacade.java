// Harald

package dtu.fm13.Payment.facade;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import dtu.fm13.Payment.Repository.PaymentRepository;
import dtu.fm13.Payment.Service.PaymentService;
import dtu.fm13.Payment.models.Account;
import dtu.fm13.Payment.models.Payment;

public class PaymentFacade {

    private PaymentService paymentService;

    public PaymentFacade(PaymentRepository paymentRepository) {
        this.paymentService = new PaymentService(paymentRepository);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postPayment(Payment payment) {
        if (paymentService.add(payment)) {
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();

    }
    @Path("/customer")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCostumer(Account customer){
        if (paymentService.addCustomer(customer)) {
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}