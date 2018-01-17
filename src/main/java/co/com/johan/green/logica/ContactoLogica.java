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
public class ContactoLogica {

    @EJB
    private ContactoDAO persistencia;

    /**
     * Retorna una lista con los Contacto que se encuentran en la base de datos
     *
     * @return retorna una lista de ContactoDTO
     * @generated
     */
    public List<ContactoDTO> obtenerTodos() {
        return convertirEntidad(persistencia.obtenerTodos());
    }

    /**
     * Obtiene Contacto dado su identificador.
     *
     * @param id identificador del elemento Contacto
     * @return Contacto del id dado
     * @generated
     */
    public ContactoDTO obtener(Long id) {
        return convertirEntidad(persistencia.obtener(id));
    }
    
    public List<ContactoDTO> obtenerPorCliente(Long clienteId) {
        return convertirEntidad(persistencia.obtenerPorCliente(clienteId));
    }

    /**
     * Almacena la informacion de Contacto
     *
     * @param dto Contacto a guardar
     * @return Contacto con los cambios realizados por el proceso de guardar
     * @generated
     */
    public ContactoDTO guardar(ContactoDTO dto) {
        return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
    }

    /**
     * Elimina el registro Contacto con el identificador dado
     *
     * @param id identificador del Contacto
     * @generated
     */
    public void borrar(Long id) {
        persistencia.borrar(id);
    }

    /**
     * Actualiza la informacion de Contacto
     *
     * @param dto Contacto a guardar
     * @generated
     */
    public void actualizar(ContactoDTO dto) {
        persistencia.actualizar(convertirDTO(dto));
    }

    /**
     * Convierte un ContactoDTO en la entidad Contacto.
     *
     * @param dto a convertir
     * @return entidad Contacto
     * @generated
     */
    public Contacto convertirDTO(ContactoDTO dto) {
        if (dto == null) {
            return null;
        }
        Contacto entidad = new Contacto();
        entidad.setId(dto.getId());
        entidad.setNombres(dto.getNombres());
        entidad.setTelefono(dto.getTelefono());
        entidad.setCorreo(dto.getCorreo());
        entidad.setCelular(dto.getCelular());
        entidad.setActivo(dto.getActivo());

        if (dto.getCliente() != null) {
            entidad.setCliente(new Cliente());
            entidad.getCliente().setId(dto.getCliente().getId());
        }

        return entidad;
    }

    /**
     * Convierte una lista de ContactoDTO en una lista de Contacto.
     *
     * @param dtos a convertir
     * @return entidades List<Contacto>
     * @generated
     */
    public List<Contacto> convertirDTO(List<ContactoDTO> dtos) {
        List<Contacto> entidades = new ArrayList<Contacto>();
        for (ContactoDTO dto : dtos) {
            entidades.add(convertirDTO(dto));
        }
        return entidades;
    }

    /**
     * Convierte Contacto en un DTO ContactoDTO.
     *
     * @param entidad a convertir
     * @return dto ContactoDTO
     * @generated
     */
    public ContactoDTO convertirEntidad(Contacto entidad) {
        ContactoDTO dto = new ContactoDTO();
        dto.setId(entidad.getId());
        dto.setNombres(entidad.getNombres());
        dto.setTelefono(entidad.getTelefono());
        dto.setCorreo(entidad.getCorreo());
        dto.setCelular(entidad.getCelular());
        dto.setActivo(entidad.getActivo());

        if (entidad.getCliente() != null) {
            dto.setCliente(
                    new ClienteDTO(
                            entidad.getCliente().getId()));
        }

        return dto;
    }

    /**
     * Convierte una lista de Contacto en una lista de ContactoDTO.
     *
     * @param entidades a convertir
     * @return dtos List<ContactoDTO>
     * @generated
     */
    public List<ContactoDTO> convertirEntidad(List<Contacto> entidades) {
        List<ContactoDTO> dtos = new ArrayList<ContactoDTO>();
        for (Contacto entidad : entidades) {
            dtos.add(convertirEntidad(entidad));
        }
        return dtos;
    }

}
