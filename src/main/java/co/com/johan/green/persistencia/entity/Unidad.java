package co.com.johan.green.persistencia.entity;

import javax.persistence.*;

/**
 *
 * @author Johan Lopez
 * @generated
 */
@Entity
@Table(name = "Unidad")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "Unidad.obtenerTodos", query = "select e from Unidad e ORDER BY e.descripcion"),
    @NamedQuery(name = "Unidad.obtenerPorNombre", query = "select e from Unidad e WHERE UPPER(e.descripcion) = UPPER(:descripcion)")
})
public class Unidad {

    public Unidad() {
    }

    public Unidad(Long id) {
        this.id = id;
    }
    
    
    /**
     * Identificador de la tabla Unidad.
     */
    @Id
    //@Column(name = "Unidad_id")
    @GeneratedValue(generator = "UnidadGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "UnidadGen", sequenceName = "Unidad_SEQ", allocationSize = 1)
    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @generated 1-1-false
     */
    //@Column(name = "descripcion")
    private String descripcion;


    /**
     * @generated
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * @generated
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
