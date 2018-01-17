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
public class GastosAdministrativosLogica {
	
	@EJB
    private GastosAdministrativosDAO persistencia;


	
	/**
	* Retorna una lista con los GastosAdministrativos que se encuentran en la base de datos
	* @return retorna una lista de GastosAdministrativosDTO
	* @generated
	*/
	public List<GastosAdministrativosDTO> obtenerTodos(){
		return convertirEntidad(persistencia.obtenerTodos());
	}
	
	/**
	* Obtiene GastosAdministrativos dado su identificador. 	
	* @param id identificador del elemento GastosAdministrativos
	* @return GastosAdministrativos del id dado
	* @generated
	*/
	public GastosAdministrativosDTO obtener(Long id){
		return convertirEntidad(persistencia.obtener(id));
	}
	
	
	/**
	 * Almacena la informacion de GastosAdministrativos
	 * @param dto GastosAdministrativos a guardar
	 * @return GastosAdministrativos con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public GastosAdministrativosDTO guardar(GastosAdministrativosDTO dto){
		return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
	}
	
	
	/**
	 * Elimina el registro GastosAdministrativos con el identificador dado
	 * @param id identificador del GastosAdministrativos
	 * @generated 
	 */
	public void borrar(Long id){
		persistencia.borrar(id);
	}
	
	
	/**
	 * Actualiza la informacion de GastosAdministrativos
	 * @param dto GastosAdministrativos a guardar
	 * @generated
	 */
	public void actualizar(GastosAdministrativosDTO dto){
		persistencia.actualizar(convertirDTO(dto));
	}
	
	
	/**
	* Convierte un GastosAdministrativosDTO en la entidad GastosAdministrativos.  
	* @param dto a convertir
	* @return entidad GastosAdministrativos
	* @generated
	*/
	public GastosAdministrativos convertirDTO(GastosAdministrativosDTO dto){
		if(dto==null)return null;
		GastosAdministrativos entidad=new GastosAdministrativos();
		entidad.setId(dto.getId());
			entidad.setPorcentaje(dto.getPorcentaje());
			entidad.setDescripcion(dto.getDescripcion());
		
		
		return entidad;
	}
	
	
	/**
	* Convierte una lista de  GastosAdministrativosDTO en una lista de GastosAdministrativos.  
	* @param dtos a convertir
	* @return entidades List<GastosAdministrativos>
	* @generated
	*/
	public List<GastosAdministrativos> convertirDTO(List<GastosAdministrativosDTO> dtos){
		List<GastosAdministrativos> entidades=new ArrayList<GastosAdministrativos>();
		for(GastosAdministrativosDTO dto:dtos){
			entidades.add(convertirDTO(dto));
		}
		return entidades;
	}
	
	
	/**
	* Convierte GastosAdministrativos en un DTO GastosAdministrativosDTO.  
	* @param entidad a convertir
	* @return dto GastosAdministrativosDTO
	* @generated
	*/
	public GastosAdministrativosDTO convertirEntidad(GastosAdministrativos entidad){
		GastosAdministrativosDTO dto=new GastosAdministrativosDTO();
		dto.setId(entidad.getId());
				dto.setPorcentaje(entidad.getPorcentaje());
				dto.setDescripcion(entidad.getDescripcion());
		
		
		return dto;
	}
	
	
	/**
	* Convierte una lista de GastosAdministrativos en una lista de GastosAdministrativosDTO.  
	* @param entidades a convertir
	* @return dtos List<GastosAdministrativosDTO>
	* @generated
	*/
	public List<GastosAdministrativosDTO> convertirEntidad(List<GastosAdministrativos> entidades){
		List<GastosAdministrativosDTO> dtos=new ArrayList<GastosAdministrativosDTO>();
		for(GastosAdministrativos entidad:entidades){
			dtos.add(convertirEntidad(entidad));
		}
		return dtos;
	}
	
	
}
