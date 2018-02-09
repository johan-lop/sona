package co.com.johan.green.persistencia.entity;

import javax.persistence.*;

/**
 *
 * @author Johan Lopez
 * @generated
 */
@Entity
@Table(name = "Cliente")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "Cliente.obtenerTodos", query = "select e from Cliente e ORDER BY e.nombre"),
    @NamedQuery(name = "Cliente.obtenerPorDescripcion", query = "select e from Cliente e WHERE UPPER(e.nombre) like :nombre ORDER BY e.nombre"),
    @NamedQuery(name = "Cliente.obtenerPorNit", query = "select e from Cliente e WHERE e.nit = :nit")
})
public class Cliente {

    /**
     * Identificador de la tabla Cliente.
     */
    @Id
    //@Column(name = "Cliente_id")
    @GeneratedValue(generator = "ClienteGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ClienteGen", sequenceName = "Cliente_SEQ", allocationSize = 1)
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
    //@Column(name = "nit")
    private String nit;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "nombre")
    private String nombre;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "direccion")
    private String direccion;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "telefono")
    private String telefono;

    /**
     * @generated
     */
    public String getNit() {
        return this.nit;
    }

    /**
     * @generated
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * @generated
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @generated
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @generated
     */
    public String getDireccion() {
        return this.direccion;
    }

    /**
     * @generated
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @generated
     */
    public String getTelefono() {
        return this.telefono;
    }

    /**
     * @generated
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
