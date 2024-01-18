
package dtu.fm13.Service;

import java.util.List;
import java.util.UUID;

import dtu.fm13.models.TokenRequest;
import dtu.fm13.repository.TokenRepository;

//import dtu.fm13.interfaces.PaymentInterface;


public class TokenService {
    TokenRepository tokenRepository;

    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository= tokenRepository;
    }

    public List<TokenRequest> getTokens(String id) {
       //generere en liste af tokens
       List<TokenRequest> tokenList=tokenRepository.getCustomerTokens(id);
       //krav max 5 aktive tokens
       int size=5-tokenList.size();
       for (int i=0; i<size; i++){
            TokenRequest token =new TokenRequest();
            token.setUserid(id);
            token.setToken(UUID.randomUUID());
            tokenRepository.add(token);
            tokenList.add(token);
       }
       return tokenList;
        
    }

    public TokenRequest authenticate(TokenRequest tokenrequest) {
        return tokenRepository.exists(tokenrequest);
    }

   


}