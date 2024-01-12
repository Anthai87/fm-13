package dtu.fm13.Customer.Service;

import dtu.fm13.Customer.Payment;
import dtu.fm13.Customer.Resource.CustomerResource;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/payments2")
public class PaymentResource {

    
    private CustomerResource customerResource;

    public PaymentResource(CustomerResource customerResource) {
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
            customerResource.addPayment(payment);
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();

    }
}