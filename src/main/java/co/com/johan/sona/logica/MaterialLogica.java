package co.com.johan.sona.logica;

import co.com.johan.sona.dto.*;
import co.com.johan.sona.persistencia.*;
import co.com.johan.sona.persistencia.entity.*;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
  *  @generated
  *  @author Johan Lopez
  */
@Stateless
public class MaterialLogica {
	
	@EJB
    private MaterialDAO persistencia;


	
	/**
	* Retorna una lista con los Material que se encuentran en la base de datos
	* @return retorna una lista de MaterialDTO
	* @generated
	*/
	public List<MaterialDTO> obtenerTodos(){
		return convertirEntidad(persistencia.obtenerTodos());
	}
	
	/**
	* Obtiene Material dado su identificador. 	
	* @param id identificador del elemento Material
	* @return Material del id dado
	* @generated
	*/
	public MaterialDTO obtener(Long id){
		return convertirEntidad(persistencia.obtener(id));
	}
	
	
	/**
	 * Almacena la informacion de Material
	 * @param dto Material a guardar
	 * @return Material con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public MaterialDTO guardar(MaterialDTO dto){
		return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
	}
	
	
	/**
	 * Elimina el registro Material con el identificador dado
	 * @param id identificador del Material
	 * @generated 
	 */
	public void borrar(Long id){
		persistencia.borrar(id);
	}
	
	
	/**
	 * Actualiza la informacion de Material
	 * @param dto Material a guardar
	 * @generated
	 */
	public void actualizar(MaterialDTO dto){
		persistencia.actualizar(convertirDTO(dto));
	}
	
	
	/**
	* Convierte un MaterialDTO en la entidad Material.  
	* @param dto a convertir
	* @return entidad Material
	* @generated
	*/
	public Material convertirDTO(MaterialDTO dto){
		if(dto==null)return null;
		Material entidad=new Material();
		entidad.setId(dto.getId());
			entidad.setMarca(dto.getMarca());
			entidad.setDescripcion(dto.getDescripcion());
			entidad.setPrecio(dto.getPrecio());
			entidad.setUnidad(dto.getUnidad());
			entidad.setActivo(dto.getActivo());
		
		
		return entidad;
	}
	
	
	/**
	* Convierte una lista de  MaterialDTO en una lista de Material.  
	* @param dtos a convertir
	* @return entidades List<material>
	* @generated
	*/
	public List<Material> convertirDTO(List<MaterialDTO> dtos){
		List<Material> entidades=new ArrayList<Material>();
		for(MaterialDTO dto:dtos){
			entidades.add(convertirDTO(dto));
		}
		return entidades;
	}
	
	
	/**
	* Convierte Material en un DTO MaterialDTO.  
	* @param entidad a convertir
	* @return dto MaterialDTO
	* @generated
	*/
	public MaterialDTO convertirEntidad(Material entidad){
		MaterialDTO dto=new MaterialDTO();
		dto.setId(entidad.getId());
				dto.setMarca(entidad.getMarca());
				dto.setDescripcion(entidad.getDescripcion());
				dto.setPrecio(entidad.getPrecio());
				dto.setUnidad(entidad.getUnidad());
				dto.setActivo(entidad.getActivo());
		
		
		return dto;
	}
	
	
	/**
	* Convierte una lista de Material en una lista de MaterialDTO.  
	* @param entidades a convertir
	* @return dtos List<materialDTO>
	* @generated
	*/
	public List<MaterialDTO> convertirEntidad(List<Material> entidades){
		List<MaterialDTO> dtos=new ArrayList<MaterialDTO>();
		for(Material entidad:entidades){
			dtos.add(convertirEntidad(entidad));
		}
		return dtos;
	}
	
	
}
