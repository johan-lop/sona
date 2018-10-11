package co.com.johan.green.logica;

import co.com.johan.green.dto.*;
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
public class CotizacionGastosAdministrativosLogica {

    @EJB
    private CotizacionGastosAdministrativosDAO persistencia;

    /**
     * Retorna una lista con los CotizacionGastosAdministrativos que se
     * encuentran en la base de datos
     *
     * @return retorna una lista de CotizacionGastosAdministrativosDTO
     * @generated
     */
    public List<CotizacionGastosAdministrativosDTO> obtenerTodos() {
        return convertirEntidad(persistencia.obtenerTodos());
    }
    
    public List<CotizacionGastosAdministrativosDTO> obtenerPorCotizacion(Long cotizacionId) {
        return convertirEntidad(persistencia.obtenerPorCotizacion(cotizacionId));
    }

    /**
     * Obtiene CotizacionGastosAdministrativos dado su identificador.
     *
     * @param id identificador del elemento CotizacionGastosAdministrativos
     * @return CotizacionGastosAdministrativos del id dado
     * @generated
     */
    public CotizacionGastosAdministrativosDTO obtener(Long id) {
        return convertirEntidad(persistencia.obtener(id));
    }

    /**
     * Almacena la informacion de CotizacionGastosAdministrativos
     *
     * @param dto CotizacionGastosAdministrativos a guardar
     * @return CotizacionGastosAdministrativos con los cambios realizados por el
     * proceso de guardar
     * @generated
     */
    public CotizacionGastosAdministrativosDTO guardar(CotizacionGastosAdministrativosDTO dto) {
        return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
    }

    /**
     * Elimina el registro CotizacionGastosAdministrativos con el identificador
     * dado
     *
     * @param id identificador del CotizacionGastosAdministrativos
     * @generated
     */
    public void borrar(Long id) {
        persistencia.borrar(id);
    }

    /**
     * Actualiza la informacion de CotizacionGastosAdministrativos
     *
     * @param dto CotizacionGastosAdministrativos a guardar
     * @generated
     */
    public void actualizar(CotizacionGastosAdministrativosDTO dto) {
        persistencia.actualizar(convertirDTO(dto));
    }

    /**
     * Convierte un CotizacionGastosAdministrativosDTO en la entidad
     * CotizacionGastosAdministrativos.
     *
     * @param dto a convertir
     * @return entidad CotizacionGastosAdministrativos
     * @generated
     */
    public CotizacionGastosAdministrativos convertirDTO(CotizacionGastosAdministrativosDTO dto) {
        if (dto == null) {
            return null;
        }
        CotizacionGastosAdministrativos entidad = new CotizacionGastosAdministrativos();
        entidad.setId(dto.getId());
        entidad.setValor(dto.getPorcentaje());
        entidad.setDescripcion(dto.getDescripcion());

        if (dto.getCotizacion() != null) {
            entidad.setCotizacion(new Cotizacion());
            entidad.getCotizacion().setId(dto.getCotizacion().getId());
        }

        return entidad;
    }

    /**
     * Convierte una lista de CotizacionGastosAdministrativosDTO en una lista de
     * CotizacionGastosAdministrativos.
     *
     * @param dtos a convertir
     * @return entidades List<CotizacionGastosAdministrativos>
     * @generated
     */
    public List<CotizacionGastosAdministrativos> convertirDTO(List<CotizacionGastosAdministrativosDTO> dtos) {
        List<CotizacionGastosAdministrativos> entidades = new ArrayList<CotizacionGastosAdministrativos>();
        for (CotizacionGastosAdministrativosDTO dto : dtos) {
            entidades.add(convertirDTO(dto));
        }
        return entidades;
    }

    /**
     * Convierte CotizacionGastosAdministrativos en un DTO
     * CotizacionGastosAdministrativosDTO.
     *
     * @param entidad a convertir
     * @return dto CotizacionGastosAdministrativosDTO
     * @generated
     */
    public CotizacionGastosAdministrativosDTO convertirEntidad(CotizacionGastosAdministrativos entidad) {
        CotizacionGastosAdministrativosDTO dto = new CotizacionGastosAdministrativosDTO();
        dto.setId(entidad.getId());
        dto.setPorcentaje(entidad.getValor());
        dto.setDescripcion(entidad.getDescripcion());

        if (entidad.getCotizacion() != null) {
            dto.setCotizacion(
                    new CotizacionDTO(
                            entidad.getCotizacion().getId()));
        }

        return dto;
    }

    /**
     * Convierte una lista de CotizacionGastosAdministrativos en una lista de
     * CotizacionGastosAdministrativosDTO.
     *
     * @param entidades a convertir
     * @return dtos List<CotizacionGastosAdministrativosDTO>
     * @generated
     */
    public List<CotizacionGastosAdministrativosDTO> convertirEntidad(List<CotizacionGastosAdministrativos> entidades) {
        List<CotizacionGastosAdministrativosDTO> dtos = new ArrayList<CotizacionGastosAdministrativosDTO>();
        for (CotizacionGastosAdministrativos entidad : entidades) {
            dtos.add(convertirEntidad(entidad));
        }
        return dtos;
    }

}
