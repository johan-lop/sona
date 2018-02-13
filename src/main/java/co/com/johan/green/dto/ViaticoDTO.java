package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.ArrayList;

/**
 * @generated @author Johan Lopez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ViaticoDTO {

    public ViaticoDTO() {
        //constructor base
    }

    public ViaticoDTO(Long id) {
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
    private UnidadDTO unidad;

    /**
     * @generated
     */
    private Double valorDiario;

    /**
     * @generated
     */
    private Boolean activo;

    /**
     * @generated
     */
    private CiudadDTO ciudad;

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

    public UnidadDTO getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadDTO unidad) {
        this.unidad = unidad;
    }


    /**
     * @return @generated
     */
    public Double getValorDiario() {
        return this.valorDiario;
    }

    /**
     * @param @generated
     */
    public void setValorDiario(Double valorDiario) {
        this.valorDiario = valorDiario;
    }

    /**
     * @return @generated
     */
    public Boolean getActivo() {
        return this.activo;
    }

    /**
     * @param @generated
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    /**
     * @return @generated
     */
    public CiudadDTO getCiudad() {
        return this.ciudad;
    }

    /**
     * @param @generated
     */
    public void setCiudad(CiudadDTO ciudad) {
        this.ciudad = ciudad;
    }

}
