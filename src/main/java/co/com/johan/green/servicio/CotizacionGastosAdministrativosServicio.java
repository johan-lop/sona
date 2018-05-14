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
@Path("/CotizacionGastosAdministrativos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CotizacionGastosAdministrativosServicio {
	
	@EJB
    private CotizacionGastosAdministrativosLogica logica;

	
	/**
	* retorna una lista con los CotizacionGastosAdministrativos que se encuentran en la base de datos
	* @return retorna una lista de CotizacionGastosAdministrativosDTO
	* @generated
	*/
	@GET
	public List<CotizacionGastosAdministrativosDTO> obtenerTodosCotizacionGastosAdministrativoss(){
		return logica.obtenerTodos();
	}
	
	/**
	* @param id identificador del elemento CotizacionGastosAdministrativos
	* @return CotizacionGastosAdministrativos del id dado
	* @generated
	*/
	@GET
	@Path("/{id}")
	public CotizacionGastosAdministrativosDTO obtenerCotizacionGastosAdministrativos(@PathParam("id") Long id){
		return logica.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de CotizacionGastosAdministrativos
	 * @param dto CotizacionGastosAdministrativos a guardar
	 * @return CotizacionGastosAdministrativos con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	public CotizacionGastosAdministrativosDTO guardarCotizacionGastosAdministrativos(CotizacionGastosAdministrativosDTO dto){
	    if(dto.getId()!=null){
	        logica.actualizar(dto);
	        return dto;
	    }else{
	        return logica.guardar(dto);
	    }
	}
	
	
	/**
	 * elimina el registro CotizacionGastosAdministrativos con el identificador dado
	 * @param id identificador del CotizacionGastosAdministrativos
	 * @generated 
	 */
	@DELETE
	@Path("/{id}")
	public void borrarCotizacionGastosAdministrativos(@PathParam("id") Long id){
		logica.borrar(id);
	}
	
	
}
