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
@Path("/material")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MaterialServicio {
	
	@EJB
    private MaterialLogica logica;

	
	/**
	* retorna una lista con los material que se encuentran en la base de datos
	* @return retorna una lista de MaterialDTO
	* @generated
	*/
	@GET
	public List<MaterialDTO> obtenerTodosmaterials(){
		return logica.obtenerTodos();
	}
	
	/**
	* @param id identificador del elemento material
	* @return material del id dado
	* @generated
	*/
	@GET
	@Path("/{id}")
	public MaterialDTO obtenermaterial(@PathParam("id") Long id){
		return logica.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de material
	 * @param dto material a guardar
	 * @return material con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	public MaterialDTO guardarmaterial(MaterialDTO dto){
	    if(dto.getId()!=null){
	        logica.actualizar(dto);
	        return dto;
	    }else{
	        return logica.guardar(dto);
	    }
	}
	
	
	/**
	 * elimina el registro material con el identificador dado
	 * @param id identificador del material
	 * @generated 
	 */
	@DELETE
	@Path("/{id}")
	public void borrarmaterial(@PathParam("id") Long id){
		logica.borrar(id);
	}
	
	
}
