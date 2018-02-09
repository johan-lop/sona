package co.com.johan.green.logica;

import co.com.johan.green.dto.*;
import co.com.johan.green.exception.ApplicationException;
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
public class ClienteLogica {

    @EJB
    private ClienteDAO persistencia;

    @EJB
    private ContactoLogica contactoLogica;

    /**
     * Retorna una lista con los Cliente que se encuentran en la base de datos
     *
     * @return retorna una lista de ClienteDTO
     * @generated
     */
    public List<ClienteDTO> obtenerTodos() {
        return convertirEntidad(persistencia.obtenerTodos());
    }

    public List<ClienteDTO> obtenerPorNombre(String nombre) {
        return convertirEntidad(persistencia.obtenerPorNombre(nombre));
    }

    public List<ClienteDTO> obtenerPorNit(String nit) {
        return convertirEntidad(persistencia.obtenerPorNit(nit));
    }

    /**
     * Obtiene Cliente dado su identificador.
     *
     * @param id identificador del elemento Cliente
     * @return Cliente del id dado
     * @generated
     */
    public ClienteDTO obtener(Long id) {
        return convertirEntidad(persistencia.obtener(id));
    }

    /**
     * Almacena la informacion de Cliente
     *
     * @param dto Cliente a guardar
     * @return Cliente con los cambios realizados por el proceso de guardar
     * @generated
     */
    public ClienteDTO guardar(ClienteDTO dto) {
        List<ClienteDTO> clientes = this.obtenerPorNit(dto.getNit());
        if (clientes.isEmpty()) {
            ClienteDTO cliente = convertirEntidad(persistencia.guardar(convertirDTO(dto)));
            if (dto.getContactos() != null && !dto.getContactos().isEmpty()) {
                for (ContactoDTO contacto : dto.getContactos()) {
                    contacto.setCliente(new ClienteDTO(cliente.getId()));
                    contactoLogica.guardar(contacto);
                }
            }
            return cliente;
        } else {
            throw new ApplicationException("El nit " + dto.getNit() + " ya se encuentra registrado");
        }
    }

    /**
     * Elimina el registro Cliente con el identificador dado
     *
     * @param id identificador del Cliente
     * @generated
     */
    public void borrar(Long id) {
        persistencia.borrar(id);
    }

    /**
     * Actualiza la informacion de Cliente
     *
     * @param dto Cliente a guardar
     * @generated
     */
    public void actualizar(ClienteDTO dto) {
        List<ClienteDTO> clientes = this.obtenerPorNit(dto.getNit());
        if (clientes.isEmpty() || clientes.get(0).getId().equals(dto.getId())) {
            persistencia.actualizar(convertirDTO(dto));
        } else {
            throw new ApplicationException("El nit " + dto.getNit() + " ya se encuentra registrado");
        }
    }

    /**
     * Convierte un ClienteDTO en la entidad Cliente.
     *
     * @param dto a convertir
     * @return entidad Cliente
     * @generated
     */
    public Cliente convertirDTO(ClienteDTO dto) {
        if (dto == null) {
            return null;
        }
        Cliente entidad = new Cliente();
        entidad.setId(dto.getId());
        entidad.setNit(dto.getNit());
        entidad.setNombre(dto.getNombre());
        entidad.setDireccion(dto.getDireccion());
        entidad.setTelefono(dto.getTelefono());

        return entidad;
    }

    /**
     * Convierte una lista de ClienteDTO en una lista de Cliente.
     *
     * @param dtos a convertir
     * @return entidades List<Cliente>
     * @generated
     */
    public List<Cliente> convertirDTO(List<ClienteDTO> dtos) {
        List<Cliente> entidades = new ArrayList<Cliente>();
        for (ClienteDTO dto : dtos) {
            entidades.add(convertirDTO(dto));
        }
        return entidades;
    }

    /**
     * Convierte Cliente en un DTO ClienteDTO.
     *
     * @param entidad a convertir
     * @return dto ClienteDTO
     * @generated
     */
    public ClienteDTO convertirEntidad(Cliente entidad) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(entidad.getId());
        dto.setNit(entidad.getNit());
        dto.setNombre(entidad.getNombre());
        dto.setDireccion(entidad.getDireccion());
        dto.setTelefono(entidad.getTelefono());

        return dto;
    }

    /**
     * Convierte una lista de Cliente en una lista de ClienteDTO.
     *
     * @param entidades a convertir
     * @return dtos List<ClienteDTO>
     * @generated
     */
    public List<ClienteDTO> convertirEntidad(List<Cliente> entidades) {
        List<ClienteDTO> dtos = new ArrayList<ClienteDTO>();
        for (Cliente entidad : entidades) {
            dtos.add(convertirEntidad(entidad));
        }
        return dtos;
    }

}
