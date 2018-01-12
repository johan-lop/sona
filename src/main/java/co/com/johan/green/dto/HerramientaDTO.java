package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @generated @author Johan Lopez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HerramientaDTO {

    public HerramientaDTO() {
        //constructor base
    }

    public HerramientaDTO(Long id) {
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
    private String descripcion;

    /**
     * @generated
     */
    private Double porcentaje;

    private Double valor;
    
    private Boolean activo;

    /**
     * @return @generated
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * @param @generated
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return @generated
     */
    public Double getPorcentaje() {
        return this.porcentaje;
    }

    /**
     * @param @generated
     */
    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    
}
