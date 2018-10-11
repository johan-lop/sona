package co.com.johan.green.persistencia.entity;

import javax.persistence.*;

/**
 * @generated @author Johan Lopez
 */
@Entity
@Table(name = "CotizacionImpuesto")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "CotizacionImpuesto.obtenerTodos", query = "select e from CotizacionImpuesto e"),
    @NamedQuery(name = "CotizacionImpuesto.obtenerPorCotizacion", 
            query = "select e from CotizacionImpuesto e WHERE e.cotizacion.id = :cotizacion"),
    @NamedQuery(name = "CotizacionImpuesto.borrarPorCotizacion", 
            query = "DELETE FROM CotizacionImpuesto e WHERE e.cotizacion.id = :cotizacion")
})
public class CotizacionImpuesto {
    
    @Id
    @GeneratedValue(generator = "CotizacionImpuestoGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CotizacionImpuestoGen", sequenceName = "CotizacionImpuesto_SEQ", allocationSize = 1)
    private Long id;

    public CotizacionImpuesto() {
    }

    public CotizacionImpuesto(Long id) {
        this.id = id;
    }

    private String descripcion;
    
    private Double porcentaje;
    
    private Double porcentajeAdicional;
    
    @ManyToOne(cascade = {})
    private Cotizacion cotizacion;

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

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public Double getPorcentajeAdicional() {
        return porcentajeAdicional;
    }

    public void setPorcentajeAdicional(Double porcentajeAdicional) {
        this.porcentajeAdicional = porcentajeAdicional;
    }

  
}
