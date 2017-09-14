package co.com.johan.green.logica;

import co.com.johan.green.persistencia.entity.Departamento;
import co.com.johan.green.persistencia.DepartamentoDAO;
import co.com.johan.green.dto.DepartamentoDTO;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
  *  @generated
  *  @author Johan Lopez
  */
@Stateless
public class DepartamentoLogica {
	
	@EJB
    private DepartamentoDAO persistencia;


	
	/**
	* Retorna una lista con los Departamento que se encuentran en la base de datos
	* @return retorna una lista de DepartamentoDTO
	* @generated
	*/
	public List<DepartamentoDTO> obtenerTodos(){
		return convertirEntidad(persistencia.obtenerTodos());
	}
	
	/**
	* Obtiene Departamento dado su identificador. 	
	* @param id identificador del elemento Departamento
	* @return Departamento del id dado
	* @generated
	*/
	public DepartamentoDTO obtener(Long id){
		return convertirEntidad(persistencia.obtener(id));
	}
	
	
	/**
	 * Almacena la informacion de Departamento
	 * @param dto Departamento a guardar
	 * @return Departamento con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public DepartamentoDTO guardar(DepartamentoDTO dto){
		return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
	}
	
	
	/**
	 * Elimina el registro Departamento con el identificador dado
	 * @param id identificador del Departamento
	 * @generated 
	 */
	public void borrar(Long id){
		persistencia.borrar(id);
	}
	
	
	/**
	 * Actualiza la informacion de Departamento
	 * @param dto Departamento a guardar
	 * @generated
	 */
	public void actualizar(DepartamentoDTO dto){
		persistencia.actualizar(convertirDTO(dto));
	}
	
	
	/**
	* Convierte un DepartamentoDTO en la entidad Departamento.  
	* @param dto a convertir
	* @return entidad Departamento
	* @generated
	*/
	public Departamento convertirDTO(DepartamentoDTO dto){
		if(dto==null)return null;
		Departamento entidad=new Departamento();
		entidad.setId(dto.getId());
			entidad.setCodigo(dto.getCodigo());
			entidad.setNombre(dto.getNombre());
		
		
		return entidad;
	}
	
	
	/**
	* Convierte una lista de  DepartamentoDTO en una lista de Departamento.  
	* @param dtos a convertir
	* @return entidades List<Departamento>
	* @generated
	*/
	public List<Departamento> convertirDTO(List<DepartamentoDTO> dtos){
		List<Departamento> entidades=new ArrayList<Departamento>();
		for(DepartamentoDTO dto:dtos){
			entidades.add(convertirDTO(dto));
		}
		return entidades;
	}
	
	
	/**
	* Convierte Departamento en un DTO DepartamentoDTO.  
	* @param entidad a convertir
	* @return dto DepartamentoDTO
	* @generated
	*/
	public DepartamentoDTO convertirEntidad(Departamento entidad){
		DepartamentoDTO dto=new DepartamentoDTO();
		dto.setId(entidad.getId());
				dto.setCodigo(entidad.getCodigo());
				dto.setNombre(entidad.getNombre());
		
		
		return dto;
	}
	
	
	/**
	* Convierte una lista de Departamento en una lista de DepartamentoDTO.  
	* @param entidades a convertir
	* @return dtos List<DepartamentoDTO>
	* @generated
	*/
	public List<DepartamentoDTO> convertirEntidad(List<Departamento> entidades){
		List<DepartamentoDTO> dtos=new ArrayList<DepartamentoDTO>();
		for(Departamento entidad:entidades){
			dtos.add(convertirEntidad(entidad));
		}
		return dtos;
	}
	
	
}
