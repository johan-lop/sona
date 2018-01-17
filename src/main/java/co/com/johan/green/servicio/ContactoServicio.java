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
@Path("/Contacto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContactoServicio {

    @EJB
    private ContactoLogica logica;

    /**
     * retorna una lista con los Contacto que se encuentran en la base de datos
     *
     * @return retorna una lista de ContactoDTO
     * @generated
     */
    @GET
    public List<ContactoDTO> obtenerTodosContactos() {
        return logica.obtenerTodos();
    }

    /**
     * @param id identificador del elemento Contacto
     * @return Contacto del id dado
     * @generated
     */
    @GET
    @Path("/{id}")
    public ContactoDTO obtenerContacto(@PathParam("id") Long id) {
        return logica.obtener(id);
    }
    
    @GET
    @Path("/Cliente/{id}")
    public List<ContactoDTO> obtenerPorCliente(@PathParam("id") Long id) {
        return logica.obtenerPorCliente(id);
    }

    /**
     * almacena la informacion de Contacto
     *
     * @param dto Contacto a guardar
     * @return Contacto con los cambios realizados por el proceso de guardar
     * @generated
     */
    @POST
    public ContactoDTO guardarContacto(ContactoDTO dto) {
        if (dto.getId() != null) {
            logica.actualizar(dto);
            return dto;
        } else {
            return logica.guardar(dto);
        }
    }

    /**
     * elimina el registro Contacto con el identificador dado
     *
     * @param id identificador del Contacto
     * @generated
     */
    @DELETE
    @Path("/{id}")
    public void borrarContacto(@PathParam("id") Long id) {
        logica.borrar(id);
    }

}
