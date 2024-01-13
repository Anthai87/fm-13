import io.quarkus.runtime.Startup;
import jakarta.enterprise.context.ApplicationScoped;

public class ReportServiceStartup {
    static Report_Main service = null;

    @Startup
    @ApplicationScoped
    public Report_Main startService() {
        if (service != null) return service;
        //var mq = new RabbitMqQueue("rabbitmq");
        //service = new Report_Main(mq);
        return service;
    }

}
