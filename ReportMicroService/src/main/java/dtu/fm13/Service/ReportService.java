
package dtu.fm13.Service;

import dtu.fm13.models.Payment;
import dtu.fm13.repository.ReportRepository;

import java.util.ArrayList;
import java.util.List;

public class ReportService {

    private ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public List<Payment> getPayments() {
        return reportRepository.getPayments();
    }

    public List<Payment> getPaymentsById(String paymentId) {
        List<Payment> filteredList = new ArrayList<>();
        for (Payment p : reportRepository.getPayments()) {
            if (p.getPayerId().equals(paymentId) ||
                    p.getRecieverId().equals(paymentId)) {
                filteredList.add(p);
            }
        }

        return filteredList;
    }

}