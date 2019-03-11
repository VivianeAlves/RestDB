package ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("teste")
public class My1stRest {
    @SuppressWarnings("unused")
    @Context
    private UriInfo context;

    /**
     * Default constructor. 
     */
    public My1stRest() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves representation of an instance of My1stRest
     * @return an instance of String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getXml() {
    	return "meuPrimeiroTesteREst";
    }

    /**
     * PUT method for updating or creating an instance of My1stRest
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }

}