package dtu.redGreenRefactor;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;

public class HelloService {
	WebTarget webTarget;
	
	public HelloService() {
	Client client = ClientBuilder.newClient();
	this.webTarget = client.target("http://localhost:8080");
	}
	
	public String hello() {
		WebTarget employeeWebTarget = webTarget.path("/hello");
		Invocation.Builder invocationBuilder = employeeWebTarget.request();
		String response = invocationBuilder.get(String.class);
		return response;
	}

}
