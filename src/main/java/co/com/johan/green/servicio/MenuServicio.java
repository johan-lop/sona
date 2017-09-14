package co.com.johan.green.servicio;

import co.com.johan.green.logica.MenuLogica;
import co.com.johan.green.dto.MenuDTO;
import co.com.johan.green.exception.ApplicationException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 * @author Johan Lopez
 * @generated
 */
@Stateless
@Path("/Menu")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MenuServicio {

    @EJB
    private MenuLogica logica;
    
    @Context
    private HttpServletRequest request;

    /**
     * retorna una lista con los Menu que se encuentran en la base de datos
     *
     * @return retorna una lista de MenuDTO
     * @generated
     */
    @GET
    public List<MenuDTO> obtenerTodosMenus() {
        return logica.obtenerTodos();
    }
    
    @GET
    @Path("/submenus")
    public List<MenuDTO> obtenerTodosMenusSubmenus() {
        return logica.obtenerTodosSubmenus();
    }

    /**
     * @param id identificador del elemento Menu
     * @return Menu del id dado
     * @generated
     */
    @GET
    @Path("/{id}")
    public MenuDTO obtenerMenu(@PathParam("id") Long id) {
        return logica.obtener(id);
    }

    /**
     * almacena la informacion de Menu
     *
     * @param dto Menu a guardar
     * @return Menu con los cambios realizados por el proceso de guardar
     * @generated
     */
    @POST
    public MenuDTO guardarMenu(MenuDTO dto) {
        if (dto.getId() != null) {
            logica.actualizar(dto);
            return dto;
        } else {
            return logica.guardar(dto);
        }
    }

    /**
     * elimina el registro Menu con el identificador dado
     *
     * @param id identificador del Menu
     * @generated
     */
    @DELETE
    @Path("/{id}")
    public void borrarMenu(@PathParam("id") Long id) {
        logica.borrar(id);
    }
    
    
    @GET
    @Path("/html")
    @Produces("text/html")
    public String obtenerMenuHtml() throws ApplicationException {
        String menu=(String) request.getSession().getAttribute("menu");
        if(menu==null){
            throw new ApplicationException("Error consultando el menu, por favor vuelva a autenticarse");
        }
        return menu;
    }
}
