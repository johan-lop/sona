package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.ArrayList;

/**
 * @generated @author Johan Lopez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CotizacionItemDTO {

    public CotizacionItemDTO() {
        //constructor base
    }

    public CotizacionItemDTO(Long id) {
        this.id = id;
    }

    private Long id;
    
    private Double cantidad;

    private Double totalMaterialesViatico;

    private Double totalManoObraViatico;

    private CotizacionCapituloDTO cotizacionCapitulo;
    
    private String descripcion;
    
    private UnidadDTO unidad;
    
    private Double valorTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotalMaterialesViatico() {
        return totalMaterialesViatico;
    }

    public void setTotalMaterialesViatico(Double totalMaterialesViatico) {
        this.totalMaterialesViatico = totalMaterialesViatico;
    }

    public Double getTotalManoObraViatico() {
        return totalManoObraViatico;
    }

    public void setTotalManoObraViatico(Double totalManoObraViatico) {
        this.totalManoObraViatico = totalManoObraViatico;
    }

    public CotizacionCapituloDTO getCotizacionCapitulo() {
        return cotizacionCapitulo;
    }

    public void setCotizacionCapitulo(CotizacionCapituloDTO cotizacionCapitulo) {
        this.cotizacionCapitulo = cotizacionCapitulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public UnidadDTO getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadDTO unidad) {
        this.unidad = unidad;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    

}
