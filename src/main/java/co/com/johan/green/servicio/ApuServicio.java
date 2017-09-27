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
@Path("/Apu")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ApuServicio {
	
	@EJB
    private ApuLogica logica;

	
	/**
	* retorna una lista con los Apu que se encuentran en la base de datos
	* @return retorna una lista de ApuDTO
	* @generated
	*/
	@GET
	public List<ApuDTO> obtenerTodosApus(){
		return logica.obtenerTodos();
	}
	
	/**
	* @param id identificador del elemento Apu
	* @return Apu del id dado
	* @generated
	*/
	@GET
	@Path("/{id}")
	public ApuDTO obtenerApu(@PathParam("id") Long id){
		return logica.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de Apu
	 * @param dto Apu a guardar
	 * @return Apu con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	public ApuDTO guardarApu(ApuDTO dto){
	    if(dto.getId()!=null){
	        logica.actualizar(dto);
	        return dto;
	    }else{
	        return logica.guardar(dto);
	    }
	}
	
	
	/**
	 * elimina el registro Apu con el identificador dado
	 * @param id identificador del Apu
	 * @generated 
	 */
	@DELETE
	@Path("/{id}")
	public void borrarApu(@PathParam("id") Long id){
		logica.borrar(id);
	}
	
	
}
