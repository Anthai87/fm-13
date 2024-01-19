
package dtu.fm13.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dtu.fm13.models.TokenRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * @authors Elias, Anthony & Harald
 */

@Setter
@Getter
public class TokenRepository {
    List<TokenRequest> tokenList = new ArrayList<>();

    public List<TokenRequest> getCustomerTokens(String id) {
        List<TokenRequest> newList = new ArrayList<>();
        for (TokenRequest t : tokenList) {

            if (t.getUserid().equals(UUID.fromString(id))) newList.add(t);
        }
        return newList;
    }

    public void add(TokenRequest token) {
        tokenList.add(token);
    }

    public TokenRequest exists(TokenRequest tokenrequest) {
       
        for (TokenRequest token : tokenList) {
            if (token.getToken().equals(tokenrequest.getToken())) {
                tokenrequest.setUserid(token.getUserid());
                tokenList.remove(token);
                break;
            }
        }
        return tokenrequest;
    }

}
