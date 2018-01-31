package co.com.johan.green.logica;

import co.com.johan.green.persistencia.entity.EstadoApu;
import co.com.johan.green.persistencia.EstadoApuDAO;
import co.com.johan.green.dto.EstadoApuDTO;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class EstadoApuLogica {

    @EJB
    private EstadoApuDAO persistencia;

    /**
     * retorna una lista con los EstadoApu que se encuentran en la base de
     * datos
     *
     * @return retorna una lista de EstadoApuDTO
     * @generated
     */
    public List<EstadoApuDTO> obtenerTodos() {
        return convertirEntidad(persistencia.obtenerTodos());
    }

    /**
     * @param id identificador del elemento EstadoApu
     * @return EstadoApu del id dado
     * @generated
     */
    public EstadoApuDTO obtener(Long id) {
        return convertirEntidad(persistencia.obtener(id));
    }

    /**
     * almacena la informacion de EstadoApu
     *
     * @param dto EstadoApu a guardar
     * @return EstadoApu con los cambios realizados por el proceso de
     * guardar
     * @generated
     */
    public EstadoApuDTO guardar(EstadoApuDTO dto) {
        return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
    }

    /**
     * Elimina el registro EstadoApu con el identificador dado
     *
     * @param id identificador del EstadoApu
     * @generated
     */
    public void borrar(Long id) {
        persistencia.borrar(id);
    }

    /**
     * actualiza la informacion de EstadoApu
     *
     * @param dto EstadoApu a guardar
     * @return EstadoApu con los cambios realizados por el proceso de
     * guardar
     * @generated
     */
    public void actualizar(EstadoApuDTO dto) {
        persistencia.actualizar(convertirDTO(dto));
    }

    /**
     * @generated
     */
    public EstadoApu convertirDTO(EstadoApuDTO dto) {
        if (dto == null) {
            return null;
        }
        EstadoApu entidad = new EstadoApu();
        entidad.setId(dto.getId());
        entidad.setDescripcion(dto.getDescripcion());
        return entidad;
    }

    /**
     * @generated
     */
    public List<EstadoApu> convertirDTO(List<EstadoApuDTO> dtos) {
        List<EstadoApu> entidades = new ArrayList<EstadoApu>();
        for (EstadoApuDTO dto : dtos) {
            entidades.add(convertirDTO(dto));
        }
        return entidades;
    }

    /**
     * @generated
     */
    public EstadoApuDTO convertirEntidad(EstadoApu entidad) {
        EstadoApuDTO dto = new EstadoApuDTO();
        dto.setId(entidad.getId());
        dto.setDescripcion(entidad.getDescripcion());
        return dto;
    }

    /**
     * @generated
     */
    public List<EstadoApuDTO> convertirEntidad(List<EstadoApu> entidades) {
        List<EstadoApuDTO> dtos = new ArrayList<EstadoApuDTO>();
        for (EstadoApu entidad : entidades) {
            dtos.add(convertirEntidad(entidad));
        }
        return dtos;
    }

}
