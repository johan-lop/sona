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
public class EmpresaLogica {
	@EJB
    private EmpresaDAO persistencia;


	
	/**
	* retorna una lista con los Empresa que se encuentran en la base de datos
	* @return retorna una lista de EmpresaDTO
	* @generated
	*/
	public List<EmpresaDTO> obtenerTodos(){
		return convertirEntidad(persistencia.obtenerTodos());
	}
	
        public List<EmpresaDTO> obtenerTodosPorNombre(String nombreEmpresa){
            List<Empresa> empresas = persistencia.obtenerTodosPorNombre(nombreEmpresa);
            if (empresas.isEmpty()) {
                return null;
            }
            return convertirEntidad(empresas);
	}
	
	/**
	* @param id identificador del elemento Empresa
	* @return Empresa del id dado
	* @generated
	*/
	public EmpresaDTO obtener(Long id){
		return convertirEntidad(persistencia.obtener(id));
	}
	
	
	/**
	 * almacena la informacion de Empresa
	 * @param dto Empresa a guardar
	 * @return Empresa con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public EmpresaDTO guardar(EmpresaDTO dto){
		return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
	}
	
	
	/**
	 * Elimina el registro Empresa con el identificador dado
	 * @param id identificador del Empresa
	 * @generated 
	 */
	public void borrar(Long id){
		persistencia.borrar(id);
	}
	
	
	/**
	 * actualiza la informacion de Empresa
	 * @param dto Empresa a guardar
	 * @return Empresa con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public void actualizar(EmpresaDTO dto){
		persistencia.actualizar(convertirDTO(dto));
	}
	
	
	/**
	* @generated
	*/
	public Empresa convertirDTO(EmpresaDTO dto){
		if(dto==null)return null;
		Empresa entidad=new Empresa();
		entidad.setId(dto.getId());
			entidad.setNumeroDocumento(dto.getNumeroDocumento());
			entidad.setNombreEmpresa(dto.getNombreEmpresa());
			entidad.setDireccion(dto.getDireccion());
			entidad.setTelefono(dto.getTelefono());
		
			if(dto.getTipoDocumento()!=null){
				entidad.setTipoDocumento(new TipoDocumento());
				entidad.getTipoDocumento().setId(dto.getTipoDocumento().getId());
			}
		
		return entidad;
	}
	
	
	/**
	* @generated
	*/
	public List<Empresa> convertirDTO(List<EmpresaDTO> dtos){
		List<Empresa> entidades=new ArrayList<Empresa>();
		for(EmpresaDTO dto:dtos){
			entidades.add(convertirDTO(dto));
		}
		return entidades;
	}
	
	
	/**
	* @generated
	*/
	public EmpresaDTO convertirEntidad(Empresa entidad){
		EmpresaDTO dto=new EmpresaDTO();
		dto.setId(entidad.getId());
			dto.setNumeroDocumento(entidad.getNumeroDocumento());
			dto.setNombreEmpresa(entidad.getNombreEmpresa());
			dto.setDireccion(entidad.getDireccion());
			dto.setTelefono(entidad.getTelefono());
		
			if(entidad.getTipoDocumento()!=null){
				dto.setTipoDocumento(
					new TipoDocumentoDTO(
						entidad.getTipoDocumento().getId()));
			}
		
		return dto;
	}
	
	
	/**
	* @generated
	*/
	public List<EmpresaDTO> convertirEntidad(List<Empresa> entidades){
		List<EmpresaDTO> dtos=new ArrayList<EmpresaDTO>();
		for(Empresa entidad:entidades){
			dtos.add(convertirEntidad(entidad));
		}
		return dtos;
	}
	
	
}
