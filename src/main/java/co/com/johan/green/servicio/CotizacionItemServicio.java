package co.com.johan.green.servicio;

import co.com.johan.green.dto.*;
import co.com.johan.green.logica.*;
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
@Path("/CotizacionItem")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CotizacionItemServicio {

    @EJB
    private CotizacionItemLogica logica;

    /**
     * retorna una lista con los CotizacionItem que se encuentran en la base de
     * datos
     *
     * @return retorna una lista de CotizacionItemDTO
     * @generated
     */
    @GET
    public List<CotizacionItemDTO> obtenerTodosCotizacionItems() {
        return logica.obtenerTodos();
    }

    /**
     * @param id identificador del elemento CotizacionItem
     * @return CotizacionItem del id dado
     * @generated
     */
    @GET
    @Path("/{id}")
    public CotizacionItemDTO obtenerCotizacionItem(@PathParam("id") Long id) {
        return logica.obtener(id);
    }

    /**
     * almacena la informacion de CotizacionItem
     *
     * @param dto CotizacionItem a guardar
     * @return CotizacionItem con los cambios realizados por el proceso de
     * guardar
     * @generated
     */
    @POST
    public CotizacionItemDTO guardarCotizacionItem(CotizacionItemDTO dto) {
        if (dto.getId() != null) {
            logica.actualizar(dto);
            return dto;
        } else {
            return logica.guardar(dto);
        }
    }

    /**
     * elimina el registro CotizacionItem con el identificador dado
     *
     * @param id identificador del CotizacionItem
     * @generated
     */
    @DELETE
    @Path("/{id}")
    public void borrarCotizacionItem(@PathParam("id") Long id) {
        logica.borrar(id);
    }
    
    @POST
    @Path("/RecalcularValores")    
    public List<CotizacionCapituloDTO> actualizaItemsCotizacion(ParametrosCotizacionDTO parametros) {
        return logica.actualizarItemsCotizacion(parametros);
    }

}
