/*Harald
 */
package dtu.fm13.interfaces;

import java.util.List;
import dtu.fm13.models.TokenRequest;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;

public class TokenInterface {
	WebTarget webTarget;

	public TokenInterface() {
		Client client = ClientBuilder.newClient();
		this.webTarget = client.target("http://tokenservice:8080");
	}

	public List<TokenRequest> tokenlist(String customerID) {
		WebTarget paymentWebTarget = webTarget.path("/tokens/" + customerID + "/tokens");
		System.out.println("sending request");
		Invocation.Builder invocationBuilder = paymentWebTarget.request();
		Response response = invocationBuilder.get();
		System.out.println("request returned :" + response.getStatus());
		List<TokenRequest> tokenList = response.readEntity(new GenericType<List<TokenRequest>>() {
		});
		return tokenList;
	}
}
