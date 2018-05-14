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
@Path("/HorarioTrabajo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HorarioTrabajoServicio {
	
	@EJB
    private HorarioTrabajoLogica logica;

	
	/**
	* retorna una lista con los HorarioTrabajo que se encuentran en la base de datos
	* @return retorna una lista de HorarioTrabajoDTO
	* @generated
	*/
	@GET
	public List<HorarioTrabajoDTO> obtenerTodosHorarioTrabajos(){
		return logica.obtenerTodos();
	}
	
	/**
	* @param id identificador del elemento HorarioTrabajo
	* @return HorarioTrabajo del id dado
	* @generated
	*/
	@GET
	@Path("/{id}")
	public HorarioTrabajoDTO obtenerHorarioTrabajo(@PathParam("id") Long id){
		return logica.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de HorarioTrabajo
	 * @param dto HorarioTrabajo a guardar
	 * @return HorarioTrabajo con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	public HorarioTrabajoDTO guardarHorarioTrabajo(HorarioTrabajoDTO dto){
	    if(dto.getId()!=null){
	        logica.actualizar(dto);
	        return dto;
	    }else{
	        return logica.guardar(dto);
	    }
	}
	
	
	/**
	 * elimina el registro HorarioTrabajo con el identificador dado
	 * @param id identificador del HorarioTrabajo
	 * @generated 
	 */
	@DELETE
	@Path("/{id}")
	public void borrarHorarioTrabajo(@PathParam("id") Long id){
		logica.borrar(id);
	}
	
	
}
