package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @generated @author Johan Lopez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CotizacionImpuestoDTO {

    public CotizacionImpuestoDTO() {
        //constructor base
    }

    public CotizacionImpuestoDTO(Long id) {
        this.id = id;
    }

    private Long id;

    private String descripcion;

    private CotizacionDTO cotizacionDTO;

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

    public CotizacionDTO getCotizacionDTO() {
        return cotizacionDTO;
    }

    public void setCotizacionDTO(CotizacionDTO cotizacionDTO) {
        this.cotizacionDTO = cotizacionDTO;
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
