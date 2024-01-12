package dtu.fm13.Payment.facade;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;
import java.util.List;

import dtu.fm13.Payment.Repository.PaymentRepository;
import dtu.fm13.Payment.Service.PaymentService;
import dtu.fm13.Payment.models.Payment;

@Path("/payments2")
public class PaymentFacade {

    private PaymentService paymentService;
    private PaymentRepository paymentRepository;

    public PaymentFacade(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
        this.paymentService=new PaymentService(paymentRepository);
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
      
		 if ( paymentService.add(payment)){
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
       
    }
}