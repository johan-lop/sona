package co.com.johan.green.servicio;

import co.com.johan.green.logica.HerramientaLogica;
import co.com.johan.green.dto.HerramientaDTO;
import co.com.johan.green.dto.MaterialDTO;
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
@Path("/herramienta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HerramientaServicio {

    @EJB
    private HerramientaLogica logica;

    /**
     * retorna una lista con los herramienta que se encuentran en la base de
     * datos
     *
     * @return retorna una lista de herramientaDTO
     * @generated
     */
    @GET
    public List<HerramientaDTO> obtenerTodosherramientas() {
        return logica.obtenerTodos();
    }

    @GET
    @Path("/descripcion/{descripcion}")
    public List<HerramientaDTO> obtenermaterialPorDescripcion(@PathParam("descripcion") String descripcion) {
        return logica.obtenerPorDescripcion(descripcion);
    }

    /**
     * @param id identificador del elemento herramienta
     * @return herramienta del id dado
     * @generated
     */
    @GET
    @Path("/{id}")
    public HerramientaDTO obtenerherramienta(@PathParam("id") Long id) {
        return logica.obtener(id);
    }

    /**
     * almacena la informacion de herramienta
     *
     * @param dto herramienta a guardar
     * @return herramienta con los cambios realizados por el proceso de guardar
     * @generated
     */
    @POST
    public HerramientaDTO guardarherramienta(HerramientaDTO dto) {
        if (dto.getId() != null) {
            logica.actualizar(dto);
            return dto;
        } else {
            return logica.guardar(dto);
        }
    }

    /**
     * elimina el registro herramienta con el identificador dado
     *
     * @param id identificador del herramienta
     * @generated
     */
    @DELETE
    @Path("/{id}")
    public void borrarherramienta(@PathParam("id") Long id) {
        logica.borrar(id);
    }

}
