package co.com.johan.sona.logica;

import co.com.johan.sona.dto.*;
import co.com.johan.sona.persistencia.*;
import co.com.johan.sona.persistencia.entity.*;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class CiudadLogica {

    @EJB
    private CiudadDAO persistencia;

    /**
     * Retorna una lista con los Ciudad que se encuentran en la base de datos
     *
     * @return retorna una lista de CiudadDTO
     * @generated
     */
    public List<CiudadDTO> obtenerTodos() {
        return convertirEntidad(persistencia.obtenerTodos());
    }
    
    /**
     * 
     * @return 
     */
    public List<CiudadDTO> obtenerTodosNombre(String nombre) {
        return convertirEntidad(persistencia.obtenerTodosNombre(nombre));
    }

    /**
     * Obtiene Ciudad dado su identificador.
     *
     * @param id identificador del elemento Ciudad
     * @return Ciudad del id dado
     * @generated
     */
    public CiudadDTO obtener(Long id) {
        return convertirEntidad(persistencia.obtener(id));
    }

    /**
     * Almacena la informacion de Ciudad
     *
     * @param dto Ciudad a guardar
     * @return Ciudad con los cambios realizados por el proceso de guardar
     * @generated
     */
    public CiudadDTO guardar(CiudadDTO dto) {
        return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
    }

    /**
     * Elimina el registro Ciudad con el identificador dado
     *
     * @param id identificador del Ciudad
     * @generated
     */
    public void borrar(Long id) {
        persistencia.borrar(id);
    }

    /**
     * Actualiza la informacion de Ciudad
     *
     * @param dto Ciudad a guardar
     * @generated
     */
    public void actualizar(CiudadDTO dto) {
        persistencia.actualizar(convertirDTO(dto));
    }

    /**
     * Convierte un CiudadDTO en la entidad Ciudad.
     *
     * @param dto a convertir
     * @return entidad Ciudad
     * @generated
     */
    public Ciudad convertirDTO(CiudadDTO dto) {
        if (dto == null) {
            return null;
        }
        Ciudad entidad = new Ciudad();
        entidad.setId(dto.getId());
        entidad.setNombre(dto.getNombre());
        entidad.setEstado(dto.getEstado());
        entidad.setDivipo(dto.getDivipo());

        if (dto.getDepartamento() != null) {
            entidad.setDepartamento(new Departamento());
            entidad.getDepartamento().setId(dto.getDepartamento().getId());
        }

        return entidad;
    }

    /**
     * Convierte una lista de CiudadDTO en una lista de Ciudad.
     *
     * @param dtos a convertir
     * @return entidades List<Ciudad>
     * @generated
     */
    public List<Ciudad> convertirDTO(List<CiudadDTO> dtos) {
        List<Ciudad> entidades = new ArrayList<Ciudad>();
        for (CiudadDTO dto : dtos) {
            entidades.add(convertirDTO(dto));
        }
        return entidades;
    }

    /**
     * Convierte Ciudad en un DTO CiudadDTO.
     *
     * @param entidad a convertir
     * @return dto CiudadDTO
     * @generated
     */
    public CiudadDTO convertirEntidad(Ciudad entidad) {
        CiudadDTO dto = new CiudadDTO();
        dto.setId(entidad.getId());
        dto.setNombre(entidad.getNombre());
        dto.setEstado(entidad.getEstado());
        dto.setDivipo(entidad.getDivipo());

        if (entidad.getDepartamento() != null) {
            dto.setDepartamento(new DepartamentoDTO(entidad.getDepartamento().getId()));
            dto.getDepartamento().setNombre(entidad.getDepartamento().getNombre());
        }

        return dto;
    }

    /**
     * Convierte una lista de Ciudad en una lista de CiudadDTO.
     *
     * @param entidades a convertir
     * @return dtos List<CiudadDTO>
     * @generated
     */
    public List<CiudadDTO> convertirEntidad(List<Ciudad> entidades) {
        List<CiudadDTO> dtos = new ArrayList<CiudadDTO>();
        for (Ciudad entidad : entidades) {
            dtos.add(convertirEntidad(entidad));
        }
        return dtos;
    }

}
