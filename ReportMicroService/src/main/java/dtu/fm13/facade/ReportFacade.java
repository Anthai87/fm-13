
package dtu.fm13.facade;

import dtu.fm13.Service.ReportService;
import dtu.fm13.models.Payment;
import dtu.fm13.repository.ReportRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

/**
 * @authors Elias & Anthony
 */

public class ReportFacade {
    private ReportRepository reportRepository;
    //private ReportService reportService;


    public ReportFacade(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
        this.reportService = new ReportService(reportRepository);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPayments(Payment payment) {
        reportRepository.addPayment(payment);
        return Response.status(Response
                .Status.CREATED).entity(payment).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Payment> getAllPayments() {
        return reportRepository.getPayments();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaymentById(@PathParam("id") String paymentId) {
        Optional<Payment> payment = reportRepository.getPaymentById(paymentId);
        return payment.map(value -> Response.ok(value).build())
                .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
    }

    @DELETE
    @Path("{id}")
    public Response deletePayment(@PathParam("id") String paymentId) {
        if (reportRepository.getPaymentById(paymentId).isPresent()) {
            reportRepository.deletePayment(paymentId);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}

    ///Get, report/id* return en list hvori personen indgår



