package dtu.fm13.facade;

import dtu.fm13.repository.ReportRepository;
import jakarta.ws.rs.Path;

@Path("/")
public class TopFacade {
    ReportRepository reportRepository = new ReportRepository();
   
    @Path("reports")
    public ReportFacade getReportService() {
    	return new ReportFacade(reportRepository);
        
    }
}
