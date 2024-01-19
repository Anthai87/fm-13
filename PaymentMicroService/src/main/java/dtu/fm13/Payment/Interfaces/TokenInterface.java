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
		WebTarget paymentWebTarget = webTarget.path("/tokens/" + customerID + "/tokens");
		Invocation.Builder invocationBuilder = paymentWebTarget.request();
		Response response = invocationBuilder.get();
		List<TokenRequest> tokenList = response.readEntity(new GenericType<List<TokenRequest>>() {
		});
		return tokenList;
	}

	public TokenRequest authenticate(UUID payerToken) {
		TokenRequest request = new TokenRequest();
		request.setToken(payerToken);

		WebTarget personWebTarget = webTarget.path("/tokens");
		Invocation.Builder invocationBuilder = personWebTarget.request();
		Response response = invocationBuilder.post(Entity.entity(request, MediaType.APPLICATION_JSON));
		TokenRequest responseFromTokenservice = response.readEntity(new GenericType<TokenRequest>() {
		});
		return responseFromTokenservice;
	}
}
