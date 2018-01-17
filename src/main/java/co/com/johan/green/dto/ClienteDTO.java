package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * @generated @author Johan Lopez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteDTO {

    public ClienteDTO() {
        //constructor base
    }

    public ClienteDTO(Long id) {
        this.id = id;
    }

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @generated
     */
    private String nit;

    /**
     * @generated
     */
    private String nombre;

    /**
     * @generated
     */
    private String direccion;

    /**
     * @generated
     */
    private String telefono;
    
    private List<ContactoDTO> contactos;

    /**
     * @return @generated
     */
    public String getNit() {
        return this.nit;
    }

    /**
     * @param @generated
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * @return @generated
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @param @generated
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return @generated
     */
    public String getDireccion() {
        return this.direccion;
    }

    /**
     * @param @generated
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return @generated
     */
    public String getTelefono() {
        return this.telefono;
    }

    /**
     * @param @generated
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<ContactoDTO> getContactos() {
        return contactos;
    }

    public void setContactos(List<ContactoDTO> contactos) {
        this.contactos = contactos;
    }

}
