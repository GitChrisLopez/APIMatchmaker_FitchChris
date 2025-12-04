/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package api;

import dtos.ProfileDTO;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.websocket.server.ServerEndpoint;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.GregorianCalendar;

/**
 * REST Web Service
 *
 * @author chris
 */
@Path("profiles")
@RequestScoped
public class ProfilesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProfilesResource
     */
    public ProfilesResource() {
    }

    /**
     * Retrieves representation of an instance of api.ProfilesResource
     *
     * @return an instance of dtos.ProfileDTO
     */
    @GET
    //@Path("perfiles")
    @Produces(MediaType.APPLICATION_JSON)
    public ProfileDTO getJson() { //@QueryParam("edad") int edad //@PathParam("pais") String pais
        return new ProfileDTO("Alexander", "Lopez", "william", new GregorianCalendar(1987, 12, 14),
                "https://images7.memedroid.com/images/UPLOADED871/60c79dd157eb0.jpeg", "alex.gw@gmail.com",
                "Male", "GB", "(513)472-0987", "(513)656-7642", "3648 Westheimer rd", 37);

        /**
         * ProfileDTO ejemplo = new ProfileDTO("Juan","Garcia",
         * "Lopez","Brasil");
        ejemplo.setPais(pais);*
         */
        //return ejemplo;
    }

    /**
     * PUT method for updating or creating an instance of ProfilesResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(ProfileDTO content) {
        //logger.info(content.toString());
    }
    
}
