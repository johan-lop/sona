package co.com.johan.green.servicio;

import co.com.johan.green.dto.*;
import co.com.johan.green.logica.*;
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
@Path("/Unidad")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UnidadServicio {

    @EJB
    private UnidadLogica logica;

    /**
     * retorna una lista con los Unidad que se encuentran en la base de datos
     *
     * @return retorna una lista de UnidadDTO
     * @generated
     */
    @GET
    public List<UnidadDTO> obtenerTodosUnidads() {
        return logica.obtenerTodos();
    }
    
    /**
     * @param id identificador del elemento Unidad
     * @return Unidad del id dado
     * @generated
     */
    @GET
    @Path("/{id}")
    public UnidadDTO obtenerUnidad(@PathParam("id") Long id) {
        return logica.obtener(id);
    }

    /**
     * almacena la informacion de Unidad
     *
     * @param dto Unidad a guardar
     * @return Unidad con los cambios realizados por el proceso de guardar
     * @generated
     */
    @POST
    public UnidadDTO guardarUnidad(UnidadDTO dto) {
        if (dto.getId() != null) {
            logica.actualizar(dto);
            return dto;
        } else {
            return logica.guardar(dto);
        }
    }

    /**
     * elimina el registro Unidad con el identificador dado
     *
     * @param id identificador del Unidad
     * @generated
     */
    @DELETE
    @Path("/{id}")
    public void borrarUnidad(@PathParam("id") Long id) {
        logica.borrar(id);
    }

}
