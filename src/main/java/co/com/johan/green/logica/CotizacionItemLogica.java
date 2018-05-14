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
public class CotizacionItemLogica {
	
	@EJB
    private CotizacionItemDAO persistencia;


	
	/**
	* Retorna una lista con los CotizacionItem que se encuentran en la base de datos
	* @return retorna una lista de CotizacionItemDTO
	* @generated
	*/
	public List<CotizacionItemDTO> obtenerTodos(){
		return convertirEntidad(persistencia.obtenerTodos());
	}
	
	/**
	* Obtiene CotizacionItem dado su identificador. 	
	* @param id identificador del elemento CotizacionItem
	* @return CotizacionItem del id dado
	* @generated
	*/
	public CotizacionItemDTO obtener(Long id){
		return convertirEntidad(persistencia.obtener(id));
	}
	
	
	/**
	 * Almacena la informacion de CotizacionItem
	 * @param dto CotizacionItem a guardar
	 * @return CotizacionItem con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public CotizacionItemDTO guardar(CotizacionItemDTO dto){
		return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
	}
	
	
	/**
	 * Elimina el registro CotizacionItem con el identificador dado
	 * @param id identificador del CotizacionItem
	 * @generated 
	 */
	public void borrar(Long id){
		persistencia.borrar(id);
	}
	
	
	/**
	 * Actualiza la informacion de CotizacionItem
	 * @param dto CotizacionItem a guardar
	 * @generated
	 */
	public void actualizar(CotizacionItemDTO dto){
		persistencia.actualizar(convertirDTO(dto));
	}
	
	
	/**
	* Convierte un CotizacionItemDTO en la entidad CotizacionItem.  
	* @param dto a convertir
	* @return entidad CotizacionItem
	* @generated
	*/
	public CotizacionItem convertirDTO(CotizacionItemDTO dto){
		if(dto==null)return null;
		CotizacionItem entidad=new CotizacionItem();
		entidad.setId(dto.getId());
			entidad.setCantidad(dto.getCantidad());
			entidad.setValorUnitario(dto.getValorUnitario());
		
			if(dto.getCotizacionCapitulo()!=null){
				entidad.setCotizacionCapitulo(new CotizacionCapitulo());
				entidad.getCotizacionCapitulo().setId(dto.getCotizacionCapitulo().getId());
			}
			if(dto.getCargo()!=null){
				entidad.setCargo(new Cargo());
				entidad.getCargo().setId(dto.getCargo().getId());
			}
			if(dto.getHerramienta()!=null){
				entidad.setHerramienta(new Herramienta());
				entidad.getHerramienta().setId(dto.getHerramienta().getId());
			}
			if(dto.getMaterial()!=null){
				entidad.setMaterial(new Material());
				entidad.getMaterial().setId(dto.getMaterial().getId());
			}
		
		return entidad;
	}
	
	
	/**
	* Convierte una lista de  CotizacionItemDTO en una lista de CotizacionItem.  
	* @param dtos a convertir
	* @return entidades List<CotizacionItem>
	* @generated
	*/
	public List<CotizacionItem> convertirDTO(List<CotizacionItemDTO> dtos){
		List<CotizacionItem> entidades=new ArrayList<CotizacionItem>();
		for(CotizacionItemDTO dto:dtos){
			entidades.add(convertirDTO(dto));
		}
		return entidades;
	}
	
	
	/**
	* Convierte CotizacionItem en un DTO CotizacionItemDTO.  
	* @param entidad a convertir
	* @return dto CotizacionItemDTO
	* @generated
	*/
	public CotizacionItemDTO convertirEntidad(CotizacionItem entidad){
		CotizacionItemDTO dto=new CotizacionItemDTO();
		dto.setId(entidad.getId());
				dto.setCantidad(entidad.getCantidad());
				dto.setValorUnitario(entidad.getValorUnitario());
		
			if(entidad.getCotizacionCapitulo()!=null){
				dto.setCotizacionCapitulo(
					new CotizacionCapituloDTO(
						entidad.getCotizacionCapitulo().getId()));
			}
			if(entidad.getHerramienta()!=null){
				dto.setHerramienta(
					new HerramientaDTO(
						entidad.getHerramienta().getId()));
			}
			if(entidad.getCargo()!=null){
				dto.setCargo(
					new CargoDTO(
						entidad.getCargo().getId()));
			}
			if(entidad.getMaterial()!=null){
				dto.setMaterial(
					new MaterialDTO(
						entidad.getMaterial().getId()));
			}
		
		return dto;
	}
	
	
	/**
	* Convierte una lista de CotizacionItem en una lista de CotizacionItemDTO.  
	* @param entidades a convertir
	* @return dtos List<CotizacionItemDTO>
	* @generated
	*/
	public List<CotizacionItemDTO> convertirEntidad(List<CotizacionItem> entidades){
		List<CotizacionItemDTO> dtos=new ArrayList<CotizacionItemDTO>();
		for(CotizacionItem entidad:entidades){
			dtos.add(convertirEntidad(entidad));
		}
		return dtos;
	}
	
	
}
