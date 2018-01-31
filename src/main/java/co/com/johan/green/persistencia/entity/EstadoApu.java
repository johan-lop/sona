package co.com.johan.green.persistencia.entity;

import javax.persistence.*;

/**
 * @generated @author Johan Lopez
 */
@Entity
@Table(name = "EstadoApu")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "EstadoApu.obtenerTodos", query = "select e from EstadoApu e")})
public class EstadoApu {

    public EstadoApu() {
    }

    public EstadoApu(Long id) {
        this.id = id;
    }

    
    @Id
    //@Column(name = "EstadoApu_id")
    @GeneratedValue(generator = "EstadoApuGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "EstadoApuGen", sequenceName = "EstadoApu_SEQ", allocationSize = 1)
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
