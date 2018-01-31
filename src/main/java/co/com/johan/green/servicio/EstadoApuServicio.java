package co.com.johan.green.servicio;

import co.com.johan.green.logica.EstadoApuLogica;
import co.com.johan.green.dto.EstadoApuDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 * @author Johan Lopez
 * @generated
 */
@Stateless
@Path("/EstadoApu")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstadoApuServicio {

    @EJB
    private EstadoApuLogica logica;

    /**
     * retorna una lista con los EstadoApu que se encuentran en la base de
     * datos
     *
     * @return retorna una lista de EstadoApuDTO
     * @generated
     */
    @GET
    public List<EstadoApuDTO> obtenerTodosEstadoApus() {
        return logica.obtenerTodos();
    }

    /**
     * @param id identificador del elemento EstadoApu
     * @return EstadoApu del id dado
     * @generated
     */
    @GET
    @Path("/{id}")
    public EstadoApuDTO obtenerEstadoApu(@PathParam("id") Long id) {
        return logica.obtener(id);
    }

    /**
     * almacena la informacion de EstadoApu
     *
     * @param dto EstadoApu a guardar
     * @return EstadoApu con los cambios realizados por el proceso de
     * guardar
     * @generated
     */
    @POST
    public EstadoApuDTO guardarEstadoApu(EstadoApuDTO dto) {
        if (dto.getId() != null) {
            logica.actualizar(dto);
            return dto;
        } else {
            return logica.guardar(dto);
        }
    }

    /**
     * elimina el registro EstadoApu con el identificador dado
     *
     * @param id identificador del EstadoApu
     * @generated
     */
    @DELETE
    @Path("/{id}")
    public void borrarEstadoApu(@PathParam("id") Long id) {
        logica.borrar(id);
    }

}
