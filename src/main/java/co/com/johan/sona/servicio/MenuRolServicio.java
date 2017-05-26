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
@Path("/MenuRol")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MenuRolServicio {
	@EJB
    private MenuRolLogica logica;

	
	/**
	* retorna una lista con los MenuRol que se encuentran en la base de datos
	* @return retorna una lista de MenuRolDTO
	* @generated
	*/
	@GET
	public List<MenuRolDTO> obtenerTodosMenuRols(){
		return logica.obtenerTodos();
	}
	
	/**
	* @param id identificador del elemento MenuRol
	* @return MenuRol del id dado
	* @generated
	*/
	@GET
	@Path("/{id}")
	public MenuRolDTO obtenerMenuRol(@PathParam("id") Long id){
		return logica.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de MenuRol
	 * @param dto MenuRol a guardar
	 * @return MenuRol con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	public MenuRolDTO guardarMenuRol(MenuRolDTO dto){
	    if(dto.getId()!=null){
	        logica.actualizar(dto);
	        return dto;
	    }else{
	        return logica.guardar(dto);
	    }
	}
	
	
	/**
	 * elimina el registro MenuRol con el identificador dado
	 * @param id identificador del MenuRol
	 * @generated 
	 */
	@DELETE
	@Path("/{id}")
	public void borrarMenuRol(@PathParam("id") Long id){
		logica.borrar(id);
	}
	
	
}
