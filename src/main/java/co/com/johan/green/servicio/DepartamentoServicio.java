package co.com.johan.green.servicio;

import co.com.johan.green.logica.DepartamentoLogica;
import co.com.johan.green.dto.DepartamentoDTO;
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
@Path("/Departamento")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartamentoServicio {
	
	@EJB
    private DepartamentoLogica logica;

	
	/**
	* retorna una lista con los Departamento que se encuentran en la base de datos
	* @return retorna una lista de DepartamentoDTO
	* @generated
	*/
	@GET
	public List<DepartamentoDTO> obtenerTodosDepartamentos(){
		return logica.obtenerTodos();
	}
	
	/**
	* @param id identificador del elemento Departamento
	* @return Departamento del id dado
	* @generated
	*/
	@GET
	@Path("/{id}")
	public DepartamentoDTO obtenerDepartamento(@PathParam("id") Long id){
		return logica.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de Departamento
	 * @param dto Departamento a guardar
	 * @return Departamento con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	public DepartamentoDTO guardarDepartamento(DepartamentoDTO dto){
	    if(dto.getId()!=null){
	        logica.actualizar(dto);
	        return dto;
	    }else{
	        return logica.guardar(dto);
	    }
	}
	
	
	/**
	 * elimina el registro Departamento con el identificador dado
	 * @param id identificador del Departamento
	 * @generated 
	 */
	@DELETE
	@Path("/{id}")
	public void borrarDepartamento(@PathParam("id") Long id){
		logica.borrar(id);
	}
	
	
}
