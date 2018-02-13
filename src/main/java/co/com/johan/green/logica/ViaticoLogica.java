package co.com.johan.green.logica;

import co.com.johan.green.persistencia.entity.Ciudad;
import co.com.johan.green.persistencia.entity.Viatico;
import co.com.johan.green.persistencia.ViaticoDAO;
import co.com.johan.green.dto.CiudadDTO;
import co.com.johan.green.dto.UnidadDTO;
import co.com.johan.green.dto.ViaticoDTO;
import co.com.johan.green.persistencia.entity.Unidad;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class ViaticoLogica {

    @EJB
    private ViaticoDAO persistencia;

    /**
     * Retorna una lista con los Viatico que se encuentran en la base de datos
     *
     * @return retorna una lista de ViaticoDTO
     * @generated
     */
    public List<ViaticoDTO> obtenerTodos() {
        return convertirEntidad(persistencia.obtenerTodos());
    }
    
    public List<ViaticoDTO> obtenerTodosCiudad(Long ciudadId) {
        return convertirEntidad(persistencia.obtenerTodosCiudad(ciudadId));
    }

    /**
     * Obtiene Viatico dado su identificador.
     *
     * @param id identificador del elemento Viatico
     * @return Viatico del id dado
     * @generated
     */
    public ViaticoDTO obtener(Long id) {
        return convertirEntidad(persistencia.obtener(id));
    }

    /**
     * Almacena la informacion de Viatico
     *
     * @param dto Viatico a guardar
     * @return Viatico con los cambios realizados por el proceso de guardar
     * @generated
     */
    public ViaticoDTO guardar(ViaticoDTO dto) {
        return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
    }

    /**
     * Elimina el registro Viatico con el identificador dado
     *
     * @param id identificador del Viatico
     * @generated
     */
    public void borrar(Long id) {
        persistencia.borrar(id);
    }

    /**
     * Actualiza la informacion de Viatico
     *
     * @param dto Viatico a guardar
     * @generated
     */
    public void actualizar(ViaticoDTO dto) {
        persistencia.actualizar(convertirDTO(dto));
    }

    /**
     * Convierte un ViaticoDTO en la entidad Viatico.
     *
     * @param dto a convertir
     * @return entidad Viatico
     * @generated
     */
    public Viatico convertirDTO(ViaticoDTO dto) {
        if (dto == null) {
            return null;
        }
        Viatico entidad = new Viatico();
        entidad.setId(dto.getId());
        entidad.setDescripcion(dto.getDescripcion());
        if (dto.getUnidad() != null) {
            entidad.setUnidad(new Unidad(dto.getUnidad().getId()));
        }
        entidad.setValorDiario(dto.getValorDiario());
        entidad.setActivo(dto.getActivo());

        if (dto.getCiudad() != null) {
            entidad.setCiudad(new Ciudad());
            entidad.getCiudad().setId(dto.getCiudad().getId());
        }

        return entidad;
    }

    /**
     * Convierte una lista de ViaticoDTO en una lista de Viatico.
     *
     * @param dtos a convertir
     * @return entidades List<Viatico>
     * @generated
     */
    public List<Viatico> convertirDTO(List<ViaticoDTO> dtos) {
        List<Viatico> entidades = new ArrayList<Viatico>();
        for (ViaticoDTO dto : dtos) {
            entidades.add(convertirDTO(dto));
        }
        return entidades;
    }

    /**
     * Convierte Viatico en un DTO ViaticoDTO.
     *
     * @param entidad a convertir
     * @return dto ViaticoDTO
     * @generated
     */
    public ViaticoDTO convertirEntidad(Viatico entidad) {
        ViaticoDTO dto = new ViaticoDTO();
        dto.setId(entidad.getId());
        dto.setDescripcion(entidad.getDescripcion());
        if (entidad.getUnidad() != null) {
            dto.setUnidad(new UnidadDTO(entidad.getUnidad().getId(), entidad.getUnidad().getDescripcion()));
        }
        dto.setValorDiario(entidad.getValorDiario());
        dto.setActivo(entidad.getActivo());
        if (entidad.getCiudad() != null) {
            dto.setCiudad(new CiudadDTO(entidad.getCiudad().getId()));
            dto.getCiudad().setNombre(entidad.getCiudad().getNombre());
        }
        return dto;
    }

    /**
     * Convierte una lista de Viatico en una lista de ViaticoDTO.
     *
     * @param entidades a convertir
     * @return dtos List<ViaticoDTO>
     * @generated
     */
    public List<ViaticoDTO> convertirEntidad(List<Viatico> entidades) {
        List<ViaticoDTO> dtos = new ArrayList<ViaticoDTO>();
        for (Viatico entidad : entidades) {
            dtos.add(convertirEntidad(entidad));
        }
        return dtos;
    }

}
