package co.com.johan.green.servicio;

import co.com.johan.green.logica.ImpuestoLogica;
import co.com.johan.green.dto.ImpuestoDTO;
import co.com.johan.green.enumerador.TipoImpuestoEnum;
import co.com.johan.green.exception.ApplicationException;
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
@Path("/Impuesto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ImpuestoServicio {

    @EJB
    private ImpuestoLogica logica;

    /**
     * retorna una lista con los Impuesto que se encuentran en la base de datos
     *
     * @return retorna una lista de ImpuestoDTO
     * @generated
     */
    @GET
    public List<ImpuestoDTO> obtenerTodosImpuestos() {
        return logica.obtenerTodos();
    }

    /**
     * @param id identificador del elemento Impuesto
     * @return Impuesto del id dado
     * @generated
     */
    @GET
    @Path("/{id}")
    public ImpuestoDTO obtenerImpuesto(@PathParam("id") Long id) {
        return logica.obtener(id);
    }
    
    @GET
    @Path("/tipo/{tipo}")
    public List<ImpuestoDTO> obtenerPorTipo(@PathParam("tipo") String tipo) {
        return logica.obtenerPorTipo(tipo);
    }
    
    @GET
    @Path("/tipos")
    public TipoImpuestoEnum[] obtenerTipos() {
        return TipoImpuestoEnum.values();
    }

    /**
     * almacena la informacion de Impuesto
     *
     * @param dto Impuesto a guardar
     * @return Impuesto con los cambios realizados por el proceso de guardar
     * @generated
     */
    @POST
    public ImpuestoDTO guardarImpuesto(ImpuestoDTO dto) {
        if (dto.getId() != null) {
            logica.actualizar(dto);
            return dto;
        } else {
            return logica.guardar(dto);
        }
    }

    /**
     * elimina el registro Impuesto con el identificador dado
     *
     * @param id identificador del Impuesto
     * @generated
     */
    @DELETE
    @Path("/{id}")
    public void borrarImpuesto(@PathParam("id") Long id) {
        logica.borrar(id);
    }

}
