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
@Path("/UsuarioRol")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioRolServicio {
	@EJB
    private UsuarioRolLogica logica;

	
	/**
	* retorna una lista con los UsuarioRol que se encuentran en la base de datos
	* @return retorna una lista de UsuarioRolDTO
	* @generated
	*/
	@GET
	public List<UsuarioRolDTO> obtenerTodosUsuarioRols(){
		return logica.obtenerTodos();
	}
	
	/**
	* @param id identificador del elemento UsuarioRol
	* @return UsuarioRol del id dado
	* @generated
	*/
	@GET
	@Path("/{id}")
	public UsuarioRolDTO obtenerUsuarioRol(@PathParam("id") Long id){
		return logica.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de UsuarioRol
	 * @param dto UsuarioRol a guardar
	 * @return UsuarioRol con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	public UsuarioRolDTO guardarUsuarioRol(UsuarioRolDTO dto){
	    if(dto.getId()!=null){
	        logica.actualizar(dto);
	        return dto;
	    }else{
	        return logica.guardar(dto);
	    }
	}
	
	
	/**
	 * elimina el registro UsuarioRol con el identificador dado
	 * @param id identificador del UsuarioRol
	 * @generated 
	 */
	@DELETE
	@Path("/{id}")
	public void borrarUsuarioRol(@PathParam("id") Long id){
		logica.borrar(id);
	}
	
	
}
