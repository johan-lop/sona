package co.com.johan.green.persistencia.entity;

import javax.persistence.*;

/**
 * @generated @author Johan Lopez
 */
@Entity
@Table(name = "EstadoCotizacion")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "EstadoCotizacion.obtenerTodos", query = "select e from EstadoCotizacion e")})
public class EstadoCotizacion {

    public EstadoCotizacion() {
    }

    public EstadoCotizacion(Long id) {
        this.id = id;
    }

    
    @Id
    //@Column(name = "EstadoApu_id")
    @GeneratedValue(generator = "EstadoCotizacionGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "EstadoCotizacionGen", sequenceName = "EstadoCotizacion_SEQ", allocationSize = 1)
    private Long id;

    private String descripcion;
    
    public Long getId() {
        return this.id;
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

}
