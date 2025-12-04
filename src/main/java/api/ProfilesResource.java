/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package api;

import dtos.ProfileDTO;
import entities.Profile;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.websocket.server.ServerEndpoint;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.GregorianCalendar;
import services.ProfileService;

/**
 * REST Web Service
 *
 * @author chris
 */
@Path("profiles")
//@RequestScoped
public class ProfilesResource {

    @Context
    private UriInfo context;

    private ProfileService service = new ProfileService();

    /**
     * Creates a new instance of ProfilesResource
     */
    public ProfilesResource() {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProfile(ProfileDTO dto) {
        Profile p = new Profile();

        p.setNombre(dto.getNombre());
        p.setApellidoPaterno(dto.getApellidoPaterno());
        p.setApellidoMaterno(dto.getApellidoMaterno());

        if (dto.getFechaNacimiento() != null) {
            p.setFechaNacimiento(dto.getFechaNacimiento().getTime());
        }

        p.setFoto(dto.getFoto());
        p.setEmail(dto.getEmail());
        p.setGenero(dto.getGenero());
        p.setPais(dto.getPais());
        p.setTelefono(dto.getTelefono());
        p.setCelular(dto.getCelular());
        p.setDireccion(dto.getDireccion());
        p.setEdad(dto.getEdad());

        service.addProfile(p);
        return Response.ok("Perfil agregado").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(
            @QueryParam("genero") String genero,
            @QueryParam("pais") String pais,
            @QueryParam("edad") @DefaultValue("-1") int edad
    ) {
        Profile p = service.search(genero, pais, edad);

        if (p == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No encontrado").build();
        }

        return Response.ok(p).build();
    }

    /**
     * Retrieves representation of an instance of api.ProfilesResource
     *
     * @return an instance of dtos.ProfileDTO
     *
     * @GET //@Path("perfiles")
     * @Produces(MediaType.APPLICATION_JSON) public ProfileDTO getJson() {
     * //@QueryParam("edad") int edad //@PathParam("pais") String pais return
     * new ProfileDTO("Alexander", "Lopez", "william", new
     * GregorianCalendar(1987, 12, 14),
     * "https://images7.memedroid.com/images/UPLOADED871/60c79dd157eb0.jpeg",
     * "alex.gw@gmail.com", "Male", "GB", "(513)472-0987", "(513)656-7642",
     * "3648 Westheimer rd", 37);
     *
     * /**
     * ProfileDTO ejemplo = new ProfileDTO("Juan","Garcia", "Lopez","Brasil");
     * ejemplo.setPais(pais);*
     *
     * //return ejemplo; }
     */
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
