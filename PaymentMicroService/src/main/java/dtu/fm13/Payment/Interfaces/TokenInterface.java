/**
 * @author Harald
 *
 * */
package dtu.fm13.Payment.Interfaces;

import java.util.List;
import java.util.UUID;

import dtu.fm13.Payment.models.TokenRequest;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;



public class TokenInterface {
	
	WebTarget webTarget;

	public TokenInterface() {
	Client client = ClientBuilder.newClient();
	this.webTarget = client.target("http://tokenservice:8080");
	}

    public List<TokenRequest> tokenlist(String customerID) {
		 	WebTarget paymentWebTarget = webTarget.path("/tokens/" +customerID+ "/tokens");
			System.out.println("sending request");
		 	Invocation.Builder invocationBuilder = paymentWebTarget.request();
		 	Response response = invocationBuilder.get();
			System.out.println("request returned :" + response.getStatus());
		 	List<TokenRequest> tokenList = response.readEntity(new GenericType<List<TokenRequest>>() {});
			return tokenList;
    }

    public TokenRequest authenticate(UUID payerToken) {
        TokenRequest request = new TokenRequest();
		request.setToken(payerToken);
		
		 WebTarget personWebTarget = webTarget.path("/tokens");
		 Invocation.Builder invocationBuilder = personWebTarget.request();
		 Response response = invocationBuilder.post(Entity.entity(request, MediaType.APPLICATION_JSON));
		 TokenRequest responseFromTokenservice = response.readEntity(new GenericType<TokenRequest>() {});
		 return responseFromTokenservice;
	}
    }

	
	// public int add(Payment payment) {
	// 	WebTarget personWebTarget = webTarget.path("/payments");
	// 	Invocation.Builder invocationBuilder = personWebTarget.request();
	// 	Response response = invocationBuilder.post(Entity.entity(payment, MediaType.APPLICATION_JSON));
	// 	return response.getStatus();
	// }

	// public List<Payment> getList(Account merchant) {
	// 	WebTarget paymentWebTarget = webTarget.path("/payments");
	// 	Invocation.Builder invocationBuilder = paymentWebTarget.request();
	// 	Response response = invocationBuilder.get();
	// 	List<Payment> paymentList = response.readEntity(new GenericType<List<Payment>>() {});
	// 	return paymentList;
		
	// }

    // public void addCustomer(Account customer) {
	// 	PaymentCustomer pCustomer = new PaymentCustomer();
    //     pCustomer.setAccountID(customer.getAccountID());
	// 	pCustomer.setId(customer.getId());
	// 	System.out.println("Sending to payment, Bank ID: " +pCustomer.getAccountID());
    //     WebTarget personWebTarget = webTarget.path("/payments/customer");
	// 	Invocation.Builder invocationBuilder = personWebTarget.request();
	// 	invocationBuilder.post(Entity.entity(pCustomer, MediaType.APPLICATION_JSON));
    // }



















//  */
// package dtu.fm13.interfaces;

// import java.util.List;
// import java.util.UUID;

// import dtu.fm13.Payment.models.TokenRequest;



// import jakarta.ws.rs.client.Client;
// import jakarta.ws.rs.client.ClientBuilder;
// import jakarta.ws.rs.client.Entity;
// import jakarta.ws.rs.client.Invocation;
// import jakarta.ws.rs.client.WebTarget;
// import jakarta.ws.rs.core.GenericType;
// import jakarta.ws.rs.core.MediaType;
// import jakarta.ws.rs.core.Response;



// public class TokenInterface {
	
// 	WebTarget webTarget;

// 	public TokenInterface() {
// 	Client client = ClientBuilder.newClient();
// 	this.webTarget = client.target("http://tokenservice:8080");
// 	}

	// public TokenRequest authenticate(UUID payerToken) {
	// 	TokenRequest tokenRequest = new TokenRequest();
	// 	tokenRequest.setToken(payerToken);
	
	// 	WebTarget personWebTarget = webTarget.path("/tokens");
	// 	Invocation.Builder invocationBuilder = personWebTarget.request();
	// 	Response response = invocationBuilder.post(Entity.entity(tokenRequest, MediaType.APPLICATION_JSON));
	// 	return response.readEntity(new GenericType<TokenRequest>() {});
	// }
	

    // public List<TokenRequest> tokenlist(String customerID) {
	// 	 	WebTarget paymentWebTarget = webTarget.path("/tokens/" +customerID+ "/tokens");
	// 		System.out.println("sending request");
	// 	 	Invocation.Builder invocationBuilder = paymentWebTarget.request();
	// 	 	Response response = invocationBuilder.get();
	// 		System.out.println("request returned :" + response.getStatus());
	// 	 	List<TokenRequest> tokenList = response.readEntity(new GenericType<List<TokenRequest>>() {});
	// 		return tokenList;
    // }

	

