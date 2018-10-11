package co.com.johan.green.logica;

import co.com.johan.green.persistencia.entity.Impuesto;
import co.com.johan.green.persistencia.ImpuestoDAO;
import co.com.johan.green.dto.ImpuestoDTO;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class ImpuestoLogica {
    
    @EJB
    private ImpuestoDAO persistencia;

    /**
     * retorna una lista con los Impuesto que se encuentran en la base de datos
     *
     * @return retorna una lista de ImpuestoDTO
     * @generated
     */
    public List<ImpuestoDTO> obtenerTodos() {
        return convertirEntidad(persistencia.obtenerTodos());
    }
    
    public List<ImpuestoDTO> obtenerPorTipo(String tipo) {
        return convertirEntidad(persistencia.obtenerPorTipo(tipo));
    }

    /**
     * @param id identificador del elemento Impuesto
     * @return Impuesto del id dado
     * @generated
     */
    public ImpuestoDTO obtener(Long id) {
        return convertirEntidad(persistencia.obtener(id));
    }

    /**
     * almacena la informacion de Impuesto
     *
     * @param dto Impuesto a guardar
     * @return Impuesto con los cambios realizados por el proceso de guardar
     * @generated
     */
    public ImpuestoDTO guardar(ImpuestoDTO dto) {
        return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
    }

    /**
     * Elimina el registro Impuesto con el identificador dado
     *
     * @param id identificador del Impuesto
     * @generated
     */
    public void borrar(Long id) {
        persistencia.borrar(id);
    }

    /**
     * actualiza la informacion de Impuesto
     *
     * @param dto Impuesto a guardar
     * @generated
     */
    public void actualizar(ImpuestoDTO dto) {
        persistencia.actualizar(convertirDTO(dto));
    }

    public Impuesto convertirDTO(ImpuestoDTO dto) {
        if (dto == null) {
            return null;
        }
        Impuesto entidad = new Impuesto();
        entidad.setId(dto.getId());
        entidad.setDescripcion(dto.getDescripcion());
        entidad.setTipo(dto.getTipo());
        entidad.setPorcentaje(dto.getPorcentaje());
        entidad.setPorcentajeAdicional(dto.getPorcentajeAdicional());
        return entidad;
    }

    public List<Impuesto> convertirDTO(List<ImpuestoDTO> dtos) {
        List<Impuesto> entidades = new ArrayList<>();
        for (ImpuestoDTO dto : dtos) {
            entidades.add(convertirDTO(dto));
        }
        return entidades;
    }

    public ImpuestoDTO convertirEntidad(Impuesto entidad) {
        ImpuestoDTO dto = new ImpuestoDTO();
        dto.setId(entidad.getId());
        dto.setDescripcion(entidad.getDescripcion());
        dto.setPorcentaje(entidad.getPorcentaje());
        dto.setTipo(entidad.getTipo());
        dto.setPorcentajeAdicional(entidad.getPorcentajeAdicional());
        return dto;
    }

    public List<ImpuestoDTO> convertirEntidad(List<Impuesto> entidades) {
        List<ImpuestoDTO> dtos = new ArrayList<>();
        for (Impuesto entidad : entidades) {
            dtos.add(convertirEntidad(entidad));
        }
        return dtos;
    }
    
}
