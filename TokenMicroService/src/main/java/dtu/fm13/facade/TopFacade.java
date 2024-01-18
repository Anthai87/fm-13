package dtu.fm13.facade;

import dtu.fm13.repository.TokenRepository;
import jakarta.ws.rs.Path;

@Path("/")
public class TopFacade {
    TokenRepository tokenRepository = new TokenRepository();
   
    @Path("tokens")
    public TokenFacade getReportService() {
    	return new TokenFacade(tokenRepository);
        
    }
}
