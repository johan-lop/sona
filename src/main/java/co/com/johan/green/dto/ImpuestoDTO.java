package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.ArrayList;

/**
 * @generated @author Johan Lopez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImpuestoDTO {

    public ImpuestoDTO() {
        //constructor base
    }

    public ImpuestoDTO(Long id) {
        this.id = id;
    }

    private Long id;

    private String descripcion;

    private String tipo;

    private Double porcentaje;
    
    private Double porcentajeAdicional;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Double getPorcentajeAdicional() {
        return porcentajeAdicional;
    }

    public void setPorcentajeAdicional(Double porcentajeAdicional) {
        this.porcentajeAdicional = porcentajeAdicional;
    }
    
    
    
}
