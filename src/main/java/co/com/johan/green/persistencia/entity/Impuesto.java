package co.com.johan.green.persistencia.entity;

import javax.persistence.*;

/**
 * @generated @author Johan Lopez
 */
@Entity
@Table(name = "Impuesto")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "Impuesto.obtenerTodos", query = "select e from Impuesto e"),
    @NamedQuery(name = "Impuesto.obtenerPorTipo", query = "select e from Impuesto e WHERE e.tipo = :tipo")
})
public class Impuesto {
    
    @Id
    @GeneratedValue(generator = "ImpuestoGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ImpuestoGen", sequenceName = "Impuesto_SEQ", allocationSize = 1)
    private Long id;

    public Impuesto() {
    }

    public Impuesto(Long id) {
        this.id = id;
    }

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
