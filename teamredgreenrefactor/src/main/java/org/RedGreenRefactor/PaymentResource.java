package org.RedGreenRefactor;


import dtu.redGreenRefactor.main.model.Payment;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

public class PaymentResource {
    
    private HelloService helloService;

	public PaymentResource(HelloService helloService) {
       this.helloService = helloService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Payment> getAllPayments() {
        return helloService.getPayments();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postPayment(Payment payment) {

        if (helloService.existsPerson(payment.getPayerId()) && helloService.existsPerson(payment.getRecieverId())) {
            helloService.addPayment(payment);
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();

    }
}