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
public class CotizacionCapituloLogica {

    @EJB
    private CotizacionCapituloDAO persistencia;

    @EJB
    private CotizacionItemLogica cotizacionItemLogica;

    /**
     * Retorna una lista con los CotizacionCapitulo que se encuentran en la base
     * de datos
     *
     * @return retorna una lista de CotizacionCapituloDTO
     * @generated
     */
    public List<CotizacionCapituloDTO> obtenerTodos() {
        return convertirEntidad(persistencia.obtenerTodos());
    }
    
    public List<CotizacionCapituloDTO> obtenerPorCotizacion(Long cotizacionId) {
        return convertirEntidad(persistencia.obtenerPorCotizacion(cotizacionId));
    }

    /**
     * Obtiene CotizacionCapitulo dado su identificador.
     *
     * @param id identificador del elemento CotizacionCapitulo
     * @return CotizacionCapitulo del id dado
     * @generated
     */
    public CotizacionCapituloDTO obtener(Long id) {
        return convertirEntidad(persistencia.obtener(id));
    }

    /**
     * Almacena la informacion de CotizacionCapitulo
     *
     * @param dto CotizacionCapitulo a guardar
     * @return CotizacionCapitulo con los cambios realizados por el proceso de
     * guardar
     * @generated
     */
    public CotizacionCapituloDTO guardar(CotizacionCapituloDTO dto) {
        return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
    }

    /**
     * Elimina el registro CotizacionCapitulo con el identificador dado
     *
     * @param id identificador del CotizacionCapitulo
     * @generated
     */
    public void borrar(Long id) {
        persistencia.borrar(id);
    }

    /**
     * Actualiza la informacion de CotizacionCapitulo
     *
     * @param dto CotizacionCapitulo a guardar
     * @generated
     */
    public void actualizar(CotizacionCapituloDTO dto) {
        persistencia.actualizar(convertirDTO(dto));
    }

    /**
     * Convierte un CotizacionCapituloDTO en la entidad CotizacionCapitulo.
     *
     * @param dto a convertir
     * @return entidad CotizacionCapitulo
     * @generated
     */
    public CotizacionCapitulo convertirDTO(CotizacionCapituloDTO dto) {
        if (dto == null) {
            return null;
        }
        CotizacionCapitulo entidad = new CotizacionCapitulo();
        entidad.setId(dto.getId());
        entidad.setDescripcion(dto.getDescripcion());

        if (dto.getCotizacion() != null) {
            entidad.setCotizacion(new Cotizacion());
            entidad.getCotizacion().setId(dto.getCotizacion().getId());
        }
        
        return entidad;
    }

    /**
     * Convierte una lista de CotizacionCapituloDTO en una lista de
     * CotizacionCapitulo.
     *
     * @param dtos a convertir
     * @return entidades List<CotizacionCapitulo>
     * @generated
     */
    public List<CotizacionCapitulo> convertirDTO(List<CotizacionCapituloDTO> dtos) {
        List<CotizacionCapitulo> entidades = new ArrayList<CotizacionCapitulo>();
        for (CotizacionCapituloDTO dto : dtos) {
            entidades.add(convertirDTO(dto));
        }
        return entidades;
    }

    /**
     * Convierte CotizacionCapitulo en un DTO CotizacionCapituloDTO.
     *
     * @param entidad a convertir
     * @return dto CotizacionCapituloDTO
     * @generated
     */
    public CotizacionCapituloDTO convertirEntidad(CotizacionCapitulo entidad) {
        CotizacionCapituloDTO dto = new CotizacionCapituloDTO();
        dto.setId(entidad.getId());
        dto.setDescripcion(entidad.getDescripcion());
        if (entidad.getCotizacion() != null) {
            dto.setCotizacion(
                    new CotizacionDTO(
                            entidad.getCotizacion().getId()));
        }
        dto.setItems(cotizacionItemLogica.obtenerPorCapitulo(entidad.getId()));
        return dto;
    }

    /**
     * Convierte una lista de CotizacionCapitulo en una lista de
     * CotizacionCapituloDTO.
     *
     * @param entidades a convertir
     * @return dtos List<CotizacionCapituloDTO>
     * @generated
     */
    public List<CotizacionCapituloDTO> convertirEntidad(List<CotizacionCapitulo> entidades) {
        List<CotizacionCapituloDTO> dtos = new ArrayList<CotizacionCapituloDTO>();
        for (CotizacionCapitulo entidad : entidades) {
            dtos.add(convertirEntidad(entidad));
        }
        return dtos;
    }

}
