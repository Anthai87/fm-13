
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
 * @authors Elias & Anthony & Harald
 */

public class ReportFacade {
    private ReportRepository reportRepository;
    private ReportService reportService;

    public ReportFacade(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
        this.reportService = new ReportService(reportRepository);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPayments(Payment payment) {
        reportRepository.addPayment(payment);
        return Response.status(Response.Status.CREATED).entity(payment).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Payment> getAllPayments() {
        return reportService.getPayments();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaymentsById(@PathParam("id") String paymentId) {
        List<Payment> payment = reportService.getPaymentsById(paymentId);
        return Response.ok(payment).build();

    }
}
