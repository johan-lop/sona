package co.com.johan.green.logica;

import co.com.johan.green.dto.*;
import co.com.johan.green.exception.ApplicationException;
import co.com.johan.green.persistencia.*;
import co.com.johan.green.persistencia.entity.*;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class UnidadLogica {

    @EJB
    private UnidadDAO persistencia;


    /**
     * Retorna una lista con los Unidad que se encuentran en la base de datos
     *
     * @return retorna una lista de UnidadDTO
     * @generated
     */
    public List<UnidadDTO> obtenerTodos() {
        return convertirEntidad(persistencia.obtenerTodos());
    }
    
    public List<UnidadDTO> obtenerPorDescripcion(String descripcion) {
        return convertirEntidad(persistencia.obtenerPorNombre(descripcion));
    }

    /**
     * Obtiene Unidad dado su identificador.
     *
     * @param id identificador del elemento Unidad
     * @return Unidad del id dado
     * @generated
     */
    public UnidadDTO obtener(Long id) {
        return convertirEntidad(persistencia.obtener(id));
    }

    /**
     * Almacena la informacion de Unidad
     *
     * @param dto Unidad a guardar
     * @return Unidad con los cambios realizados por el proceso de guardar
     * @generated
     */
    public UnidadDTO guardar(UnidadDTO dto) {
        List<UnidadDTO> unidades = this.obtenerPorDescripcion(dto.getDescripcion());
        if (!unidades.isEmpty()) {
            throw new ApplicationException("La unidad " + dto.getDescripcion() + " ya se encuentra parametrizada");
        }
        return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
    }

    /**
     * Elimina el registro Unidad con el identificador dado
     *
     * @param id identificador del Unidad
     * @generated
     */
    public void borrar(Long id) {
        persistencia.borrar(id);
    }

    /**
     * Actualiza la informacion de Unidad
     *
     * @param dto Unidad a guardar
     * @generated
     */
    public void actualizar(UnidadDTO dto) {
        persistencia.actualizar(convertirDTO(dto));
    }

    /**
     * Convierte un UnidadDTO en la entidad Unidad.
     *
     * @param dto a convertir
     * @return entidad Unidad
     * @generated
     */
    public Unidad convertirDTO(UnidadDTO dto) {
        if (dto == null) {
            return null;
        }
        Unidad entidad = new Unidad();
        entidad.setId(dto.getId());
        entidad.setDescripcion(dto.getDescripcion());
        return entidad;
    }

    /**
     * Convierte una lista de UnidadDTO en una lista de Unidad.
     *
     * @param dtos a convertir
     * @return entidades List<Unidad>
     * @generated
     */
    public List<Unidad> convertirDTO(List<UnidadDTO> dtos) {
        List<Unidad> entidades = new ArrayList<Unidad>();
        for (UnidadDTO dto : dtos) {
            entidades.add(convertirDTO(dto));
        }
        return entidades;
    }

    /**
     * Convierte Unidad en un DTO UnidadDTO.
     *
     * @param entidad a convertir
     * @return dto UnidadDTO
     * @generated
     */
    public UnidadDTO convertirEntidad(Unidad entidad) {
        UnidadDTO dto = new UnidadDTO();
        dto.setId(entidad.getId());
        dto.setDescripcion(entidad.getDescripcion());
        return dto;
    }

    /**
     * Convierte una lista de Unidad en una lista de UnidadDTO.
     *
     * @param entidades a convertir
     * @return dtos List<UnidadDTO>
     * @generated
     */
    public List<UnidadDTO> convertirEntidad(List<Unidad> entidades) {
        List<UnidadDTO> dtos = new ArrayList<UnidadDTO>();
        for (Unidad entidad : entidades) {
            dtos.add(convertirEntidad(entidad));
        }
        return dtos;
    }

}
