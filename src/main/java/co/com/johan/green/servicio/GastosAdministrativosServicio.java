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
 *  @author Johan Lopez
 *  @generated
 */
@Stateless
@Path("/GastosAdministrativos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GastosAdministrativosServicio {
	
	@EJB
    private GastosAdministrativosLogica logica;

	
	/**
	* retorna una lista con los GastosAdministrativos que se encuentran en la base de datos
	* @return retorna una lista de GastosAdministrativosDTO
	* @generated
	*/
	@GET
	public List<GastosAdministrativosDTO> obtenerTodosGastosAdministrativoss(){
		return logica.obtenerTodos();
	}
	
	/**
	* @param id identificador del elemento GastosAdministrativos
	* @return GastosAdministrativos del id dado
	* @generated
	*/
	@GET
	@Path("/{id}")
	public GastosAdministrativosDTO obtenerGastosAdministrativos(@PathParam("id") Long id){
		return logica.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de GastosAdministrativos
	 * @param dto GastosAdministrativos a guardar
	 * @return GastosAdministrativos con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	public GastosAdministrativosDTO guardarGastosAdministrativos(GastosAdministrativosDTO dto){
	    if(dto.getId()!=null){
	        logica.actualizar(dto);
	        return dto;
	    }else{
	        return logica.guardar(dto);
	    }
	}
	
	
	/**
	 * elimina el registro GastosAdministrativos con el identificador dado
	 * @param id identificador del GastosAdministrativos
	 * @generated 
	 */
	@DELETE
	@Path("/{id}")
	public void borrarGastosAdministrativos(@PathParam("id") Long id){
		logica.borrar(id);
	}
	
	
}
