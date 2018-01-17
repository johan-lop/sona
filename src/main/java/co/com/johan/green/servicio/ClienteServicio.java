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
@Path("/Cliente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteServicio {
	
	@EJB
    private ClienteLogica logica;

	
	/**
	* retorna una lista con los Cliente que se encuentran en la base de datos
	* @return retorna una lista de ClienteDTO
	* @generated
	*/
	@GET
	public List<ClienteDTO> obtenerTodosClientes(){
		return logica.obtenerTodos();
	}
	
	/**
	* @param id identificador del elemento Cliente
	* @return Cliente del id dado
	* @generated
	*/
	@GET
	@Path("/{id}")
	public ClienteDTO obtenerCliente(@PathParam("id") Long id){
		return logica.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de Cliente
	 * @param dto Cliente a guardar
	 * @return Cliente con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	public ClienteDTO guardarCliente(ClienteDTO dto){
	    if(dto.getId()!=null){
	        logica.actualizar(dto);
	        return dto;
	    }else{
	        return logica.guardar(dto);
	    }
	}
	
	
	/**
	 * elimina el registro Cliente con el identificador dado
	 * @param id identificador del Cliente
	 * @generated 
	 */
	@DELETE
	@Path("/{id}")
	public void borrarCliente(@PathParam("id") Long id){
		logica.borrar(id);
	}
	
	
}
