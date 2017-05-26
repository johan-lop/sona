package co.com.johan.sona.logica;

import co.com.johan.sona.dto.*;
import co.com.johan.sona.persistencia.*;
import co.com.johan.sona.persistencia.entity.*;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
  *  @generated
  *  @author Johan Lopez
  */
@Stateless
public class MenuRolLogica {
	@EJB
    private MenuRolDAO persistencia;


	
	/**
	* retorna una lista con los MenuRol que se encuentran en la base de datos
	* @return retorna una lista de MenuRolDTO
	* @generated
	*/
	public List<MenuRolDTO> obtenerTodos(){
		return convertirEntidad(persistencia.obtenerTodos());
	}
	
	/**
	* @param id identificador del elemento MenuRol
	* @return MenuRol del id dado
	* @generated
	*/
	public MenuRolDTO obtener(Long id){
		return convertirEntidad(persistencia.obtener(id));
	}
	
	
	/**
	 * almacena la informacion de MenuRol
	 * @param dto MenuRol a guardar
	 * @return MenuRol con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public MenuRolDTO guardar(MenuRolDTO dto){
		return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
	}
	
	
	/**
	 * Elimina el registro MenuRol con el identificador dado
	 * @param id identificador del MenuRol
	 * @generated 
	 */
	public void borrar(Long id){
		persistencia.borrar(id);
	}
	
	
	/**
	 * actualiza la informacion de MenuRol
	 * @param dto MenuRol a guardar
	 * @return MenuRol con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public void actualizar(MenuRolDTO dto){
		persistencia.actualizar(convertirDTO(dto));
	}
	
	
	/**
	* @generated
	*/
	public MenuRol convertirDTO(MenuRolDTO dto){
		if(dto==null)return null;
		MenuRol entidad=new MenuRol();
		entidad.setId(dto.getId());
		
			if(dto.getMenu()!=null){
				entidad.setMenu(new Menu());
				entidad.getMenu().setId(dto.getMenu().getId());
			}
		
		return entidad;
	}
	
	
	/**
	* @generated
	*/
	public List<MenuRol> convertirDTO(List<MenuRolDTO> dtos){
		List<MenuRol> entidades=new ArrayList<MenuRol>();
		for(MenuRolDTO dto:dtos){
			entidades.add(convertirDTO(dto));
		}
		return entidades;
	}
	
	
	/**
	* @generated
	*/
	public MenuRolDTO convertirEntidad(MenuRol entidad){
		MenuRolDTO dto=new MenuRolDTO();
		dto.setId(entidad.getId());
		
			if(entidad.getMenu()!=null){
				dto.setMenu(
					new MenuDTO(
						entidad.getMenu().getId()));
			}
		
		return dto;
	}
	
	
	/**
	* @generated
	*/
	public List<MenuRolDTO> convertirEntidad(List<MenuRol> entidades){
		List<MenuRolDTO> dtos=new ArrayList<MenuRolDTO>();
		for(MenuRol entidad:entidades){
			dtos.add(convertirEntidad(entidad));
		}
		return dtos;
	}
	
	
}
