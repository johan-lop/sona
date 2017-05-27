package co.com.johan.sona.servicio;

import co.com.johan.sona.dto.*;
import co.com.johan.sona.logica.*;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
  *  @author Johan Lopez
  *  @generated
  */
@Stateless
@Path("/Menu")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MenuServicio {
	@EJB
    private MenuLogica logica;

	
	/**
	* retorna una lista con los Menu que se encuentran en la base de datos
	* @return retorna una lista de MenuDTO
	* @generated
	*/
	@GET
	public List<MenuDTO> obtenerTodosMenus(){
		return logica.obtenerTodos();
	}
	
	/**
	* @param id identificador del elemento Menu
	* @return Menu del id dado
	* @generated
	*/
	@GET
	@Path("/{id}")
	public MenuDTO obtenerMenu(@PathParam("id") Long id){
		return logica.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de Menu
	 * @param dto Menu a guardar
	 * @return Menu con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	public MenuDTO guardarMenu(MenuDTO dto){
	    if(dto.getId()!=null){
	        logica.actualizar(dto);
	        return dto;
	    }else{
	        return logica.guardar(dto);
	    }
	}
	
	
	/**
	 * elimina el registro Menu con el identificador dado
	 * @param id identificador del Menu
	 * @generated 
	 */
	@DELETE
	@Path("/{id}")
	public void borrarMenu(@PathParam("id") Long id){
		logica.borrar(id);
	}
	
	
}
