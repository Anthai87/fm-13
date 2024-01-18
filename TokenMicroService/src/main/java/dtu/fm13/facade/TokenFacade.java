
package dtu.fm13.facade;

import dtu.fm13.Service.TokenService;
import dtu.fm13.models.TokenRequest;
import dtu.fm13.repository.TokenRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

/**
 * @authors  Anthony  & Harald & Elias*/

public class TokenFacade {
    private TokenService tokenService;


    public TokenFacade(TokenRepository tokenRepository) {
        this.tokenService = new TokenService(tokenRepository);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticateToken(TokenRequest tokenrequest) {
        tokenrequest=tokenService.authenticate(tokenrequest);
        
        if(tokenrequest.getUserid().isEmpty()){
            return Response.status(Response.Status.BAD_REQUEST).build();   
        }
        return Response.status(Response
                .Status.CREATED).entity(tokenrequest).build();
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TokenRequest> getTokens(@PathParam("id") String id) {
        return tokenService.getTokens(id);
    }

}




