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
@Path("/Cotizacion")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CotizacionServicio {
	
	@EJB
    private CotizacionLogica logica;

	
	/**
	* retorna una lista con los Cotizacion que se encuentran en la base de datos
	* @return retorna una lista de CotizacionDTO
	* @generated
	*/
	@GET
	public List<CotizacionDTO> obtenerTodosCotizacions(){
		return logica.obtenerTodos();
	}
	
	/**
	* @param id identificador del elemento Cotizacion
	* @return Cotizacion del id dado
	* @generated
	*/
	@GET
	@Path("/{id}")
	public CotizacionDTO obtenerCotizacion(@PathParam("id") Long id){
		return logica.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de Cotizacion
	 * @param dto Cotizacion a guardar
	 * @return Cotizacion con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	public CotizacionDTO guardarCotizacion(CotizacionDTO dto){
	    if(dto.getId()!=null){
	        logica.actualizar(dto);
	        return dto;
	    }else{
	        return logica.guardar(dto);
	    }
	}
	
	
	/**
	 * elimina el registro Cotizacion con el identificador dado
	 * @param id identificador del Cotizacion
	 * @generated 
	 */
	@DELETE
	@Path("/{id}")
	public void borrarCotizacion(@PathParam("id") Long id){
		logica.borrar(id);
	}
	
	
}
