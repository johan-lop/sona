package co.com.johan.green.persistencia.entity;

import javax.persistence.*;

/**
 *
 * @author Johan Lopez
 * @generated
 */
@Entity
@Table(name = "Cargo")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "Cargo.obtenerTodos", query = "select e from Cargo e ORDER BY e.descripcion"),
    @NamedQuery(name = "Cargo.obtenerPorDescripcion", query = "select e from Cargo e WHERE UPPER(e.descripcion) = UPPER(:descripcion) ORDER BY e.descripcion")
})
public class Cargo {

    /**
     * Identificador de la tabla Cargo.
     */
    @Id
    //@Column(name = "Cargo_id")
    @GeneratedValue(generator = "CargoGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CargoGen", sequenceName = "Cargo_SEQ", allocationSize = 1)
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
     * @generated 1-1-false
     */
    //@Column(name = "activo")
    private Boolean activo;

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

    /**
     * @generated
     */
    public Boolean getActivo() {
        return this.activo;
    }

    /**
     * @generated
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}
