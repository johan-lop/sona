package co.com.johan.green.logica;

import co.com.johan.green.dto.CotizacionDTO;
import co.com.johan.green.persistencia.entity.CotizacionImpuesto;
import co.com.johan.green.persistencia.CotizacionImpuestoDAO;
import co.com.johan.green.dto.CotizacionImpuestoDTO;
import co.com.johan.green.persistencia.entity.Cotizacion;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class CotizacionImpuestoLogica {
    
    @EJB
    private CotizacionImpuestoDAO persistencia;

    /**
     * retorna una lista con los CotizacionImpuesto que se encuentran en la base de datos
     *
     * @return retorna una lista de CotizacionImpuestoDTO
     * @generated
     */
    public List<CotizacionImpuestoDTO> obtenerTodos() {
        return convertirEntidad(persistencia.obtenerTodos());
    }
    
    public List<CotizacionImpuestoDTO> obtenerPorCotizacion(Long cotizacionId) {
        return convertirEntidad(persistencia.obtenerPorTipo(cotizacionId));
    }

    /**
     * @param id identificador del elemento CotizacionImpuesto
     * @return CotizacionImpuesto del id dado
     * @generated
     */
    public CotizacionImpuestoDTO obtener(Long id) {
        return convertirEntidad(persistencia.obtener(id));
    }

    /**
     * almacena la informacion de CotizacionImpuesto
     *
     * @param dto CotizacionImpuesto a guardar
     * @return CotizacionImpuesto con los cambios realizados por el proceso de guardar
     * @generated
     */
    public CotizacionImpuestoDTO guardar(CotizacionImpuestoDTO dto) {
        return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
    }

    /**
     * Elimina el registro CotizacionImpuesto con el identificador dado
     *
     * @param id identificador del CotizacionImpuesto
     * @generated
     */
    public void borrar(Long id) {
        persistencia.borrar(id);
    }

    /**
     * actualiza la informacion de CotizacionImpuesto
     *
     * @param dto CotizacionImpuesto a guardar
     * @generated
     */
    public void actualizar(CotizacionImpuestoDTO dto) {
        persistencia.actualizar(convertirDTO(dto));
    }

    public CotizacionImpuesto convertirDTO(CotizacionImpuestoDTO dto) {
        if (dto == null) {
            return null;
        }
        CotizacionImpuesto entidad = new CotizacionImpuesto();
        entidad.setId(dto.getId());
        entidad.setDescripcion(dto.getDescripcion());
        entidad.setPorcentaje(dto.getPorcentaje());
        if (dto.getCotizacionDTO() != null) {
            entidad.setCotizacion(new Cotizacion(dto.getCotizacionDTO().getId()));
        }
        entidad.setPorcentajeAdicional(dto.getPorcentajeAdicional());
        return entidad;
    }

    public List<CotizacionImpuesto> convertirDTO(List<CotizacionImpuestoDTO> dtos) {
        List<CotizacionImpuesto> entidades = new ArrayList<>();
        for (CotizacionImpuestoDTO dto : dtos) {
            entidades.add(convertirDTO(dto));
        }
        return entidades;
    }

    public CotizacionImpuestoDTO convertirEntidad(CotizacionImpuesto entidad) {
        CotizacionImpuestoDTO dto = new CotizacionImpuestoDTO();
        dto.setId(entidad.getId());
        dto.setDescripcion(entidad.getDescripcion());
        dto.setPorcentaje(entidad.getPorcentaje());
        if (entidad.getCotizacion() != null) {
            dto.setCotizacionDTO(new CotizacionDTO(entidad.getCotizacion().getId()));
        }
        dto.setPorcentajeAdicional(entidad.getPorcentajeAdicional());
        return dto;
    }

    public List<CotizacionImpuestoDTO> convertirEntidad(List<CotizacionImpuesto> entidades) {
        List<CotizacionImpuestoDTO> dtos = new ArrayList<>();
        for (CotizacionImpuesto entidad : entidades) {
            dtos.add(convertirEntidad(entidad));
        }
        return dtos;
    }
    
}
