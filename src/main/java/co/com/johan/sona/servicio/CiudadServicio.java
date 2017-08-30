package co.com.johan.sona.servicio;

import co.com.johan.sona.dto.*;
import co.com.johan.sona.logica.*;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 * @author Johan Lopez
 * @generated
 */
@Stateless
@Path("/Ciudad")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CiudadServicio {

    @EJB
    private CiudadLogica logica;

    /**
     * retorna una lista con los Ciudad que se encuentran en la base de datos
     *
     * @return retorna una lista de CiudadDTO
     * @generated
     */
    @GET
    public List<CiudadDTO> obtenerTodosCiudads() {
        return logica.obtenerTodos();
    }

    /**
     * @param id identificador del elemento Ciudad
     * @return Ciudad del id dado
     * @generated
     */
    @GET
    @Path("/{id}")
    public CiudadDTO obtenerCiudad(@PathParam("id") Long id) {
        return logica.obtener(id);
    }
    
    @GET
    @Path("/Nombre/{nombre}")
    public List<CiudadDTO> obtenerTodosNombre(@PathParam("nombre") String nombre) {
        return logica.obtenerTodosNombre(nombre);
    }
    
    @GET
    @Path("/Nombre")
    public List<CiudadDTO> obtenerTodosNombre() {
        return logica.obtenerTodosNombre("");
    }

    /**
     * almacena la informacion de Ciudad
     *
     * @param dto Ciudad a guardar
     * @return Ciudad con los cambios realizados por el proceso de guardar
     * @generated
     */
    @POST
    public CiudadDTO guardarCiudad(CiudadDTO dto) {
        if (dto.getId() != null) {
            logica.actualizar(dto);
            return dto;
        } else {
            return logica.guardar(dto);
        }
    }

    /**
     * elimina el registro Ciudad con el identificador dado
     *
     * @param id identificador del Ciudad
     * @generated
     */
    @DELETE
    @Path("/{id}")
    public void borrarCiudad(@PathParam("id") Long id) {
        logica.borrar(id);
    }

}
