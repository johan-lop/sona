package co.com.johan.green.servicio;

import co.com.johan.green.logica.UsuarioLogica;
import co.com.johan.green.dto.UsuarioDTO;
import co.com.johan.green.dto.InfoUsuario;
import co.com.johan.green.exception.ApplicationException;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 * @author Johan Lopez
 * @generated
 */
@Stateless
@Path("/Usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioServicio {

    @EJB
    private UsuarioLogica logica;

    @Inject
    private InfoUsuario infoUsuario;

    @Context
    private HttpServletRequest request;

    /**
     * retorna una lista con los Usuario que se encuentran en la base de datos
     *
     * @return retorna una lista de UsuarioDTO
     * @generated
     */
    @GET
    public List<UsuarioDTO> obtenerTodosUsuarios() {
        return logica.obtenerTodos();
    }

    /**
     * @param id identificador del elemento Usuario
     * @return Usuario del id dado
     * @generated
     */
    @GET
    @Path("/{id}")
    public UsuarioDTO obtenerUsuario(@PathParam("id") Long id) {
        return logica.obtener(id);
    }

    @GET
    @Path("/usuarioLogueado")
    public UsuarioDTO obtenerUsuarioLogueado() {
        return infoUsuario.getUsuario();
    }

    /**
     * almacena la informacion de Usuario
     *
     * @param dto Usuario a guardar
     * @return Usuario con los cambios realizados por el proceso de guardar
     * @generated
     */
    @POST
    public UsuarioDTO guardarUsuario(UsuarioDTO dto) {
        if (dto.getId() != null) {
            logica.actualizar(dto);
            return dto;
        } else {
            return logica.guardar(dto, false);
        }
    }

    /**
     * elimina el registro Usuario con el identificador dado
     *
     * @param id identificador del Usuario
     * @generated
     */
    @DELETE
    @Path("/{id}")
    public void borrarUsuario(@PathParam("id") Long id) {
        logica.borrar(id);
    }

}
