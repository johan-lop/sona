package co.com.johan.green.persistencia.entity;

import javax.persistence.*;

/**
 *
 * @author Johan Lopez
 * @generated
 */
@Entity
@Table(name = "Contacto")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "Contacto.obtenerTodos", query = "select e from Contacto e ORDER BY e.nombres"),
    @NamedQuery(name = "Contacto.obtenerPorCliente", query = "select e from Contacto e WHERE e.cliente.id = :cliente ORDER BY e.nombres")
})
public class Contacto {

    /**
     * Identificador de la tabla Contacto.
     */
    @Id
    //@Column(name = "Contacto_id")
    @GeneratedValue(generator = "ContactoGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ContactoGen", sequenceName = "Contacto_SEQ", allocationSize = 1)
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
    //@Column(name = "nombres")
    private String nombres;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "telefono")
    private String telefono;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "correo")
    private String correo;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "celular")
    private String celular;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "activo")
    private Boolean activo;

    /**
     * @generated 0-1-false
     */
    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private Cliente cliente;

    /**
     * @generated
     */
    public String getNombres() {
        return this.nombres;
    }

    /**
     * @generated
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
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

    /**
     * @generated
     */
    public String getCorreo() {
        return this.correo;
    }

    /**
     * @generated
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @generated
     */
    public String getCelular() {
        return this.celular;
    }

    /**
     * @generated
     */
    public void setCelular(String celular) {
        this.celular = celular;
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

    /**
     * @generated
     */
    public Cliente getCliente() {
        return this.cliente;
    }

    /**
     * @generated
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
