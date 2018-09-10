package co.com.johan.green.persistencia.entity;

import javax.persistence.*;

/**
 *
 * @author Johan Lopez
 * @generated
 */
@Entity
@Table(name = "CotizacionItem")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "CotizacionItem.obtenerTodos", query = "select e from CotizacionItem e")
    ,
    @NamedQuery(name = "CotizacionItem.obtenerPorCapitulo", query = "select e from CotizacionItem e WHERE e.cotizacionCapitulo.id = :capitulo")
    ,
    @NamedQuery(name = "CotizacionItem.borrarPorCapitulo",
            query = "DELETE FROM CotizacionItem e WHERE e.cotizacionCapitulo.id = :capitulo")
})
public class CotizacionItem {

    /**
     * Identificador de la tabla CotizacionItem.
     */
    @Id
    //@Column(name = "CotizacionItem_id")
    @GeneratedValue(generator = "CotizacionItemGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CotizacionItemGen", sequenceName = "CotizacionItem_SEQ", allocationSize = 1)
    private Long id;

    private Double cantidad;

    private Double totalMaterialesViatico;

    private Double totalManoObraViatico;

    private String descripcion;

    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private Unidad unidad;

    /**
     * @generated 0-1-false
     */
    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private CotizacionCapitulo cotizacionCapitulo;

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

    public CotizacionCapitulo getCotizacionCapitulo() {
        return cotizacionCapitulo;
    }

    public void setCotizacionCapitulo(CotizacionCapitulo cotizacionCapitulo) {
        this.cotizacionCapitulo = cotizacionCapitulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    
}
