package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @generated @author Johan Lopez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SalariosRecargosDTO {

    public SalariosRecargosDTO() {
        //constructor base
    }

    public SalariosRecargosDTO(Long id) {
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
    private Double cantidad;

    /**
     * @generated
     */
    private Double valor;

    /**
     * @generated
     */
    private Double total;

    /**
     * @generated
     */
    private Boolean activo;

    /**
     * @generated
     */
    private CargoDTO cargo;

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
    public Double getCantidad() {
        return this.cantidad;
    }

    /**
     * @param @generated
     */
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return @generated
     */
    public Double getValor() {
        return this.valor;
    }

    /**
     * @param @generated
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return @generated
     */
    public Double getTotal() {
        return this.total;
    }

    /**
     * @param @generated
     */
    public void setTotal(Double total) {
        this.total = total;
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
    public CargoDTO getCargo() {
        return this.cargo;
    }

    /**
     * @param @generated
     */
    public void setCargo(CargoDTO cargo) {
        this.cargo = cargo;
    }

}
