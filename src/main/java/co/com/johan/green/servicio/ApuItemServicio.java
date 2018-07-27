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
@Path("/ApuItem")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ApuItemServicio {

    @EJB
    private ApuItemLogica logica;

    /**
     * retorna una lista con los ApuItem que se encuentran en la base de datos
     *
     * @return retorna una lista de ApuItemDTO
     * @generated
     */
    @GET
    public List<ApuItemDTO> obtenerTodosApuItems() {
        return logica.obtenerTodos();
    }

    /**
     * @param id identificador del elemento ApuItem
     * @return ApuItem del id dado
     * @generated
     */
    @GET
    @Path("/{id}")
    public ApuItemDTO obtenerApuItem(@PathParam("id") Long id) {
        return logica.obtener(id);
    }

    /**
     * almacena la informacion de ApuItem
     *
     * @param dto ApuItem a guardar
     * @return ApuItem con los cambios realizados por el proceso de guardar
     * @generated
     */
    @POST
    public ApuItemDTO guardarApuItem(ApuItemDTO dto) {
        if (dto.getId() != null) {
            logica.actualizar(dto);
            return dto;
        } else {
            return logica.guardar(dto);
        }
    }

    /**
     * elimina el registro ApuItem con el identificador dado
     *
     * @param id identificador del ApuItem
     * @generated
     */
    @DELETE
    @Path("/{id}")
    public void borrarApuItem(@PathParam("id") Long id) {
        logica.borrar(id);
    }

}
