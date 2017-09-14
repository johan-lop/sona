package co.com.johan.green.servicio;

import co.com.johan.green.logica.ViaticoLogica;
import co.com.johan.green.dto.ViaticoDTO;
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
@Path("/Viatico")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ViaticoServicio {
	
	@EJB
    private ViaticoLogica logica;

	
	/**
	* retorna una lista con los Viatico que se encuentran en la base de datos
	* @return retorna una lista de ViaticoDTO
	* @generated
	*/
	@GET
	public List<ViaticoDTO> obtenerTodosViaticos(){
		return logica.obtenerTodos();
	}
	
	/**
	* @param id identificador del elemento Viatico
	* @return Viatico del id dado
	* @generated
	*/
	@GET
	@Path("/{id}")
	public ViaticoDTO obtenerViatico(@PathParam("id") Long id){
		return logica.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de Viatico
	 * @param dto Viatico a guardar
	 * @return Viatico con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	public ViaticoDTO guardarViatico(ViaticoDTO dto){
	    if(dto.getId()!=null){
	        logica.actualizar(dto);
	        return dto;
	    }else{
	        return logica.guardar(dto);
	    }
	}
	
	
	/**
	 * elimina el registro Viatico con el identificador dado
	 * @param id identificador del Viatico
	 * @generated 
	 */
	@DELETE
	@Path("/{id}")
	public void borrarViatico(@PathParam("id") Long id){
		logica.borrar(id);
	}
	
	
}
