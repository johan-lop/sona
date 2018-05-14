package co.com.johan.green.logica;

import co.com.johan.green.dto.*;
import co.com.johan.green.persistencia.*;
import co.com.johan.green.persistencia.entity.*;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
  *  @generated
  *  @author Johan Lopez
  */
@Stateless
public class HorarioTrabajoLogica {
	
	@EJB
    private HorarioTrabajoDAO persistencia;


	
	/**
	* Retorna una lista con los HorarioTrabajo que se encuentran en la base de datos
	* @return retorna una lista de HorarioTrabajoDTO
	* @generated
	*/
	public List<HorarioTrabajoDTO> obtenerTodos(){
		return convertirEntidad(persistencia.obtenerTodos());
	}
	
	/**
	* Obtiene HorarioTrabajo dado su identificador. 	
	* @param id identificador del elemento HorarioTrabajo
	* @return HorarioTrabajo del id dado
	* @generated
	*/
	public HorarioTrabajoDTO obtener(Long id){
		return convertirEntidad(persistencia.obtener(id));
	}
	
	
	/**
	 * Almacena la informacion de HorarioTrabajo
	 * @param dto HorarioTrabajo a guardar
	 * @return HorarioTrabajo con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public HorarioTrabajoDTO guardar(HorarioTrabajoDTO dto){
		return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
	}
	
	
	/**
	 * Elimina el registro HorarioTrabajo con el identificador dado
	 * @param id identificador del HorarioTrabajo
	 * @generated 
	 */
	public void borrar(Long id){
		persistencia.borrar(id);
	}
	
	
	/**
	 * Actualiza la informacion de HorarioTrabajo
	 * @param dto HorarioTrabajo a guardar
	 * @generated
	 */
	public void actualizar(HorarioTrabajoDTO dto){
		persistencia.actualizar(convertirDTO(dto));
	}
	
	
	/**
	* Convierte un HorarioTrabajoDTO en la entidad HorarioTrabajo.  
	* @param dto a convertir
	* @return entidad HorarioTrabajo
	* @generated
	*/
	public HorarioTrabajo convertirDTO(HorarioTrabajoDTO dto){
		if(dto==null)return null;
		HorarioTrabajo entidad=new HorarioTrabajo();
		entidad.setId(dto.getId());
			entidad.setDescripcion(dto.getDescripcion());
			entidad.setPorcentaje(dto.getPorcentaje());
		
		
		return entidad;
	}
	
	
	/**
	* Convierte una lista de  HorarioTrabajoDTO en una lista de HorarioTrabajo.  
	* @param dtos a convertir
	* @return entidades List<HorarioTrabajo>
	* @generated
	*/
	public List<HorarioTrabajo> convertirDTO(List<HorarioTrabajoDTO> dtos){
		List<HorarioTrabajo> entidades=new ArrayList<HorarioTrabajo>();
		for(HorarioTrabajoDTO dto:dtos){
			entidades.add(convertirDTO(dto));
		}
		return entidades;
	}
	
	
	/**
	* Convierte HorarioTrabajo en un DTO HorarioTrabajoDTO.  
	* @param entidad a convertir
	* @return dto HorarioTrabajoDTO
	* @generated
	*/
	public HorarioTrabajoDTO convertirEntidad(HorarioTrabajo entidad){
		HorarioTrabajoDTO dto=new HorarioTrabajoDTO();
		dto.setId(entidad.getId());
				dto.setDescripcion(entidad.getDescripcion());
				dto.setPorcentaje(entidad.getPorcentaje());
		
		
		return dto;
	}
	
	
	/**
	* Convierte una lista de HorarioTrabajo en una lista de HorarioTrabajoDTO.  
	* @param entidades a convertir
	* @return dtos List<HorarioTrabajoDTO>
	* @generated
	*/
	public List<HorarioTrabajoDTO> convertirEntidad(List<HorarioTrabajo> entidades){
		List<HorarioTrabajoDTO> dtos=new ArrayList<HorarioTrabajoDTO>();
		for(HorarioTrabajo entidad:entidades){
			dtos.add(convertirEntidad(entidad));
		}
		return dtos;
	}
	
	
}
