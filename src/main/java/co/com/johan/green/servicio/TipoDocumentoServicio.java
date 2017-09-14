package co.com.johan.green.servicio;

import co.com.johan.green.logica.TipoDocumentoLogica;
import co.com.johan.green.dto.TipoDocumentoDTO;
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
@Path("/TipoDocumento")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TipoDocumentoServicio {

    @EJB
    private TipoDocumentoLogica logica;

    /**
     * retorna una lista con los TipoDocumento que se encuentran en la base de
     * datos
     *
     * @return retorna una lista de TipoDocumentoDTO
     * @generated
     */
    @GET
    public List<TipoDocumentoDTO> obtenerTodosTipoDocumentos() {
        return logica.obtenerTodos();
    }

    @GET
    @Path("/TodosEmpresa")
    public List<TipoDocumentoDTO> obtenerTodosTipoDocumentosEmpresa() {
        return logica.obtenerTodosEmpresa();
    }

    /**
     * @param id identificador del elemento TipoDocumento
     * @return TipoDocumento del id dado
     * @generated
     */
    @GET
    @Path("/{id}")
    public TipoDocumentoDTO obtenerTipoDocumento(@PathParam("id") Long id) {
        return logica.obtener(id);
    }

    /**
     * almacena la informacion de TipoDocumento
     *
     * @param dto TipoDocumento a guardar
     * @return TipoDocumento con los cambios realizados por el proceso de
     * guardar
     * @generated
     */
    @POST
    public TipoDocumentoDTO guardarTipoDocumento(TipoDocumentoDTO dto) {
        if (dto.getId() != null) {
            logica.actualizar(dto);
            return dto;
        } else {
            return logica.guardar(dto);
        }
    }

    /**
     * elimina el registro TipoDocumento con el identificador dado
     *
     * @param id identificador del TipoDocumento
     * @generated
     */
    @DELETE
    @Path("/{id}")
    public void borrarTipoDocumento(@PathParam("id") Long id) {
        logica.borrar(id);
    }

}
