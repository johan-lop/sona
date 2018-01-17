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
public class SalariosRecargosLogica {
	
	@EJB
    private SalariosRecargosDAO persistencia;


	
	/**
	* Retorna una lista con los SalariosRecargos que se encuentran en la base de datos
	* @return retorna una lista de SalariosRecargosDTO
	* @generated
	*/
	public List<SalariosRecargosDTO> obtenerTodos(){
		return convertirEntidad(persistencia.obtenerTodos());
	}
	
	/**
	* Obtiene SalariosRecargos dado su identificador. 	
	* @param id identificador del elemento SalariosRecargos
	* @return SalariosRecargos del id dado
	* @generated
	*/
	public SalariosRecargosDTO obtener(Long id){
		return convertirEntidad(persistencia.obtener(id));
	}
	
	
	/**
	 * Almacena la informacion de SalariosRecargos
	 * @param dto SalariosRecargos a guardar
	 * @return SalariosRecargos con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public SalariosRecargosDTO guardar(SalariosRecargosDTO dto){
		return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
	}
	
	
	/**
	 * Elimina el registro SalariosRecargos con el identificador dado
	 * @param id identificador del SalariosRecargos
	 * @generated 
	 */
	public void borrar(Long id){
		persistencia.borrar(id);
	}
	
	
	/**
	 * Actualiza la informacion de SalariosRecargos
	 * @param dto SalariosRecargos a guardar
	 * @generated
	 */
	public void actualizar(SalariosRecargosDTO dto){
		persistencia.actualizar(convertirDTO(dto));
	}
	
	
	/**
	* Convierte un SalariosRecargosDTO en la entidad SalariosRecargos.  
	* @param dto a convertir
	* @return entidad SalariosRecargos
	* @generated
	*/
	public SalariosRecargos convertirDTO(SalariosRecargosDTO dto){
		if(dto==null)return null;
		SalariosRecargos entidad=new SalariosRecargos();
		entidad.setId(dto.getId());
			entidad.setDescripcion(dto.getDescripcion());
			entidad.setUnidad(dto.getUnidad());
			entidad.setCantidad(dto.getCantidad());
			entidad.setValor(dto.getValor());
			entidad.setTotal(dto.getTotal());
			entidad.setActivo(dto.getActivo());
		
			if(dto.getCargo()!=null){
				entidad.setCargo(new Cargo());
				entidad.getCargo().setId(dto.getCargo().getId());
			}
		
		return entidad;
	}
	
	
	/**
	* Convierte una lista de  SalariosRecargosDTO en una lista de SalariosRecargos.  
	* @param dtos a convertir
	* @return entidades List<SalariosRecargos>
	* @generated
	*/
	public List<SalariosRecargos> convertirDTO(List<SalariosRecargosDTO> dtos){
		List<SalariosRecargos> entidades=new ArrayList<SalariosRecargos>();
		for(SalariosRecargosDTO dto:dtos){
			entidades.add(convertirDTO(dto));
		}
		return entidades;
	}
	
	
	/**
	* Convierte SalariosRecargos en un DTO SalariosRecargosDTO.  
	* @param entidad a convertir
	* @return dto SalariosRecargosDTO
	* @generated
	*/
	public SalariosRecargosDTO convertirEntidad(SalariosRecargos entidad){
		SalariosRecargosDTO dto=new SalariosRecargosDTO();
		dto.setId(entidad.getId());
				dto.setDescripcion(entidad.getDescripcion());
				dto.setUnidad(entidad.getUnidad());
				dto.setCantidad(entidad.getCantidad());
				dto.setValor(entidad.getValor());
				dto.setTotal(entidad.getTotal());
				dto.setActivo(entidad.getActivo());
		
			if(entidad.getCargo()!=null){
				dto.setCargo(
					new CargoDTO(
						entidad.getCargo().getId()));
			}
		
		return dto;
	}
	
	
	/**
	* Convierte una lista de SalariosRecargos en una lista de SalariosRecargosDTO.  
	* @param entidades a convertir
	* @return dtos List<SalariosRecargosDTO>
	* @generated
	*/
	public List<SalariosRecargosDTO> convertirEntidad(List<SalariosRecargos> entidades){
		List<SalariosRecargosDTO> dtos=new ArrayList<SalariosRecargosDTO>();
		for(SalariosRecargos entidad:entidades){
			dtos.add(convertirEntidad(entidad));
		}
		return dtos;
	}
	
	
}
