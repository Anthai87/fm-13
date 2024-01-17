
package dtu.fm13.facade;

import dtu.fm13.Service.ReportService;
import dtu.fm13.models.Payment;
import dtu.fm13.repository.ReportRepository;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

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
    public void createPayments(Payment payment) {
        reportRepository.addPayment(payment);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Payment> getAllPayments() {
        return reportRepository.getPayments();
    }

    /*Get, report/id* returne en list hvori personen indgår/

/*    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public UUID createCustomer(Customer customer) {

        UUID toReturn = customerService.createCustomer(customer);
        System.out.println("IDtoReturn:" + toReturn);
        return toReturn;
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCustomer(Customer customer) {
        customerService.deleteCustomer(customer);
    }*/

/*
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPayments(Payment payments) {
        paymentList.add(payments);
        return Response.ok(paymentList).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Payment> getPayments() {
        return paymentList;
    }*/


}