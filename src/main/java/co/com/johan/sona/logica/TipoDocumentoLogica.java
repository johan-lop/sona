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
 * @generated @author Johan Lopez
 */
@Stateless
public class TipoDocumentoLogica {

    @EJB
    private TipoDocumentoDAO persistencia;

    /**
     * retorna una lista con los TipoDocumento que se encuentran en la base de
     * datos
     *
     * @return retorna una lista de TipoDocumentoDTO
     * @generated
     */
    public List<TipoDocumentoDTO> obtenerTodos() {
        return convertirEntidad(persistencia.obtenerTodos());
    }

    public List<TipoDocumentoDTO> obtenerTodosEmpresa() {
        return convertirEntidad(persistencia.obtenerTodosEmpresa());
    }

    /**
     * @param id identificador del elemento TipoDocumento
     * @return TipoDocumento del id dado
     * @generated
     */
    public TipoDocumentoDTO obtener(Long id) {
        return convertirEntidad(persistencia.obtener(id));
    }

    /**
     * almacena la informacion de TipoDocumento
     *
     * @param dto TipoDocumento a guardar
     * @return TipoDocumento con los cambios realizados por el proceso de
     * guardar
     * @generated
     */
    public TipoDocumentoDTO guardar(TipoDocumentoDTO dto) {
        return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
    }

    /**
     * Elimina el registro TipoDocumento con el identificador dado
     *
     * @param id identificador del TipoDocumento
     * @generated
     */
    public void borrar(Long id) {
        persistencia.borrar(id);
    }

    /**
     * actualiza la informacion de TipoDocumento
     *
     * @param dto TipoDocumento a guardar
     * @return TipoDocumento con los cambios realizados por el proceso de
     * guardar
     * @generated
     */
    public void actualizar(TipoDocumentoDTO dto) {
        persistencia.actualizar(convertirDTO(dto));
    }

    /**
     * @generated
     */
    public TipoDocumento convertirDTO(TipoDocumentoDTO dto) {
        if (dto == null) {
            return null;
        }
        TipoDocumento entidad = new TipoDocumento();
        entidad.setId(dto.getId());
        entidad.setDescripcion(dto.getDescripcion());
        entidad.setAplicaEmpresa(dto.getAplicaEmpresa());

        return entidad;
    }

    /**
     * @generated
     */
    public List<TipoDocumento> convertirDTO(List<TipoDocumentoDTO> dtos) {
        List<TipoDocumento> entidades = new ArrayList<TipoDocumento>();
        for (TipoDocumentoDTO dto : dtos) {
            entidades.add(convertirDTO(dto));
        }
        return entidades;
    }

    /**
     * @generated
     */
    public TipoDocumentoDTO convertirEntidad(TipoDocumento entidad) {
        TipoDocumentoDTO dto = new TipoDocumentoDTO();
        dto.setId(entidad.getId());
        dto.setDescripcion(entidad.getDescripcion());
        dto.setAplicaEmpresa(entidad.getAplicaEmpresa());

        return dto;
    }

    /**
     * @generated
     */
    public List<TipoDocumentoDTO> convertirEntidad(List<TipoDocumento> entidades) {
        List<TipoDocumentoDTO> dtos = new ArrayList<TipoDocumentoDTO>();
        for (TipoDocumento entidad : entidades) {
            dtos.add(convertirEntidad(entidad));
        }
        return dtos;
    }

}
