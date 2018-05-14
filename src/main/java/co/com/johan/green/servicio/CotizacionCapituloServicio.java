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
@Path("/CotizacionCapitulo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CotizacionCapituloServicio {
	
	@EJB
    private CotizacionCapituloLogica logica;

	
	/**
	* retorna una lista con los CotizacionCapitulo que se encuentran en la base de datos
	* @return retorna una lista de CotizacionCapituloDTO
	* @generated
	*/
	@GET
	public List<CotizacionCapituloDTO> obtenerTodosCotizacionCapitulos(){
		return logica.obtenerTodos();
	}
	
	/**
	* @param id identificador del elemento CotizacionCapitulo
	* @return CotizacionCapitulo del id dado
	* @generated
	*/
	@GET
	@Path("/{id}")
	public CotizacionCapituloDTO obtenerCotizacionCapitulo(@PathParam("id") Long id){
		return logica.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de CotizacionCapitulo
	 * @param dto CotizacionCapitulo a guardar
	 * @return CotizacionCapitulo con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	public CotizacionCapituloDTO guardarCotizacionCapitulo(CotizacionCapituloDTO dto){
	    if(dto.getId()!=null){
	        logica.actualizar(dto);
	        return dto;
	    }else{
	        return logica.guardar(dto);
	    }
	}
	
	
	/**
	 * elimina el registro CotizacionCapitulo con el identificador dado
	 * @param id identificador del CotizacionCapitulo
	 * @generated 
	 */
	@DELETE
	@Path("/{id}")
	public void borrarCotizacionCapitulo(@PathParam("id") Long id){
		logica.borrar(id);
	}
	
	
}
