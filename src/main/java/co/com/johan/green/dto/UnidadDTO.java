package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @generated @author Johan Lopez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnidadDTO {

    public UnidadDTO() {
        //constructor base
    }

    public UnidadDTO(Long id) {
        this.id = id;
    }

    public UnidadDTO(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    
    private Long id;

    private String descripcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
