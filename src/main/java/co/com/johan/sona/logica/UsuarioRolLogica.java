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
public class UsuarioRolLogica {
	@EJB
    private UsuarioRolDAO persistencia;


	
	/**
	* retorna una lista con los UsuarioRol que se encuentran en la base de datos
	* @return retorna una lista de UsuarioRolDTO
	* @generated
	*/
	public List<UsuarioRolDTO> obtenerTodos(){
		return convertirEntidad(persistencia.obtenerTodos());
	}
	
	/**
	* @param id identificador del elemento UsuarioRol
	* @return UsuarioRol del id dado
	* @generated
	*/
	public UsuarioRolDTO obtener(Long id){
		return convertirEntidad(persistencia.obtener(id));
	}
	
	
	/**
	 * almacena la informacion de UsuarioRol
	 * @param dto UsuarioRol a guardar
	 * @return UsuarioRol con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public UsuarioRolDTO guardar(UsuarioRolDTO dto){
		return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
	}
	
	
	/**
	 * Elimina el registro UsuarioRol con el identificador dado
	 * @param id identificador del UsuarioRol
	 * @generated 
	 */
	public void borrar(Long id){
		persistencia.borrar(id);
	}
	
	
	/**
	 * actualiza la informacion de UsuarioRol
	 * @param dto UsuarioRol a guardar
	 * @return UsuarioRol con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public void actualizar(UsuarioRolDTO dto){
		persistencia.actualizar(convertirDTO(dto));
	}
	
	
	/**
	* @generated
	*/
	public UsuarioRol convertirDTO(UsuarioRolDTO dto){
		if(dto==null)return null;
		UsuarioRol entidad=new UsuarioRol();
		entidad.setId(dto.getId());
		
		
		return entidad;
	}
	
	
	/**
	* @generated
	*/
	public List<UsuarioRol> convertirDTO(List<UsuarioRolDTO> dtos){
		List<UsuarioRol> entidades=new ArrayList<UsuarioRol>();
		for(UsuarioRolDTO dto:dtos){
			entidades.add(convertirDTO(dto));
		}
		return entidades;
	}
	
	
	/**
	* @generated
	*/
	public UsuarioRolDTO convertirEntidad(UsuarioRol entidad){
		UsuarioRolDTO dto=new UsuarioRolDTO();
		dto.setId(entidad.getId());
		
		
		return dto;
	}
	
	
	/**
	* @generated
	*/
	public List<UsuarioRolDTO> convertirEntidad(List<UsuarioRol> entidades){
		List<UsuarioRolDTO> dtos=new ArrayList<UsuarioRolDTO>();
		for(UsuarioRol entidad:entidades){
			dtos.add(convertirEntidad(entidad));
		}
		return dtos;
	}
	
	
}
