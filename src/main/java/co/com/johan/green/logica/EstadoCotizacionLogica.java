package co.com.johan.green.logica;

import co.com.johan.green.persistencia.entity.EstadoCotizacion;
import co.com.johan.green.persistencia.EstadoCotizacionDAO;
import co.com.johan.green.dto.EstadoCotizacionDTO;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class EstadoCotizacionLogica {

    @EJB
    private EstadoCotizacionDAO persistencia;

    /**
     * retorna una lista con los EstadoCotizacion que se encuentran en la base de
     * datos
     *
     * @return retorna una lista de EstadoCotizacionDTO
     * @generated
     */
    public List<EstadoCotizacionDTO> obtenerTodos() {
        return convertirEntidad(persistencia.obtenerTodos());
    }

    /**
     * @param id identificador del elemento EstadoCotizacion
     * @return EstadoCotizacion del id dado
     * @generated
     */
    public EstadoCotizacionDTO obtener(Long id) {
        return convertirEntidad(persistencia.obtener(id));
    }

    /**
     * almacena la informacion de EstadoCotizacion
     *
     * @param dto EstadoCotizacion a guardar
     * @return EstadoCotizacion con los cambios realizados por el proceso de
     * guardar
     * @generated
     */
    public EstadoCotizacionDTO guardar(EstadoCotizacionDTO dto) {
        return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
    }

    /**
     * Elimina el registro EstadoCotizacion con el identificador dado
     *
     * @param id identificador del EstadoCotizacion
     * @generated
     */
    public void borrar(Long id) {
        persistencia.borrar(id);
    }

    /**
     * actualiza la informacion de EstadoCotizacion
     *
     * @param dto EstadoCotizacion a guardar
     * @return EstadoCotizacion con los cambios realizados por el proceso de
     * guardar
     * @generated
     */
    public void actualizar(EstadoCotizacionDTO dto) {
        persistencia.actualizar(convertirDTO(dto));
    }

    /**
     * @generated
     */
    public EstadoCotizacion convertirDTO(EstadoCotizacionDTO dto) {
        if (dto == null) {
            return null;
        }
        EstadoCotizacion entidad = new EstadoCotizacion();
        entidad.setId(dto.getId());
        entidad.setDescripcion(dto.getDescripcion());
        return entidad;
    }

    /**
     * @generated
     */
    public List<EstadoCotizacion> convertirDTO(List<EstadoCotizacionDTO> dtos) {
        List<EstadoCotizacion> entidades = new ArrayList<EstadoCotizacion>();
        for (EstadoCotizacionDTO dto : dtos) {
            entidades.add(convertirDTO(dto));
        }
        return entidades;
    }

    /**
     * @generated
     */
    public EstadoCotizacionDTO convertirEntidad(EstadoCotizacion entidad) {
        EstadoCotizacionDTO dto = new EstadoCotizacionDTO();
        dto.setId(entidad.getId());
        dto.setDescripcion(entidad.getDescripcion());
        return dto;
    }

    /**
     * @generated
     */
    public List<EstadoCotizacionDTO> convertirEntidad(List<EstadoCotizacion> entidades) {
        List<EstadoCotizacionDTO> dtos = new ArrayList<EstadoCotizacionDTO>();
        for (EstadoCotizacion entidad : entidades) {
            dtos.add(convertirEntidad(entidad));
        }
        return dtos;
    }

}
