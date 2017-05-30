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
public class RolLogica {

    @EJB
    private RolDAO persistencia;

    /**
     * retorna una lista con los Rol que se encuentran en la base de datos
     *
     * @return retorna una lista de RolDTO
     * @generated
     */
    public List<RolDTO> obtenerTodos() {
        return convertirEntidad(persistencia.obtenerTodos());
    }
    
    public List<RolDTO> obtenerPorDefecto() {
        return convertirEntidad(persistencia.obtenerPorDefecto());
    }

    /**
     * @param id identificador del elemento Rol
     * @return Rol del id dado
     * @generated
     */
    public RolDTO obtener(Long id) {
        return convertirEntidad(persistencia.obtener(id));
    }

    /**
     * almacena la informacion de Rol
     *
     * @param dto Rol a guardar
     * @return Rol con los cambios realizados por el proceso de guardar
     * @generated
     */
    public RolDTO guardar(RolDTO dto) {
        return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
    }

    /**
     * Elimina el registro Rol con el identificador dado
     *
     * @param id identificador del Rol
     * @generated
     */
    public void borrar(Long id) {
        persistencia.borrar(id);
    }

    /**
     * actualiza la informacion de Rol
     *
     * @param dto Rol a guardar
     * @return Rol con los cambios realizados por el proceso de guardar
     * @generated
     */
    public void actualizar(RolDTO dto) {
        persistencia.actualizar(convertirDTO(dto));
    }

    /**
     * @generated
     */
    public Rol convertirDTO(RolDTO dto) {
        if (dto == null) {
            return null;
        }
        Rol entidad = new Rol();
        entidad.setId(dto.getId());
        entidad.setNombre(dto.getNombre());
        return entidad;
    }

    /**
     * @generated
     */
    public List<Rol> convertirDTO(List<RolDTO> dtos) {
        List<Rol> entidades = new ArrayList<Rol>();
        for (RolDTO dto : dtos) {
            entidades.add(convertirDTO(dto));
        }
        return entidades;
    }

    /**
     * @generated
     */
    public RolDTO convertirEntidad(Rol entidad) {
        RolDTO dto = new RolDTO();
        dto.setId(entidad.getId());
        dto.setNombre(entidad.getNombre());

        return dto;
    }

    /**
     * @generated
     */
    public List<RolDTO> convertirEntidad(List<Rol> entidades) {
        List<RolDTO> dtos = new ArrayList<RolDTO>();
        for (Rol entidad : entidades) {
            dtos.add(convertirEntidad(entidad));
        }
        return dtos;
    }

}
