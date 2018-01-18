package co.com.johan.green.persistencia.entity;

import javax.persistence.*;

/**
 *
 * @author Johan Lopez
 * @generated
 */
@Entity
@Table(name = "SalariosRecargos")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "SalariosRecargos.obtenerTodos", query = "select e from SalariosRecargos e"),
    @NamedQuery(name = "SalariosRecargos.obtenerPorCargo", query = "select e from SalariosRecargos e where e.cargo.id = :cargo")
})
public class SalariosRecargos {

    /**
     * Identificador de la tabla SalariosRecargos.
     */
    @Id
    //@Column(name = "SalariosRecargos_id")
    @GeneratedValue(generator = "SalariosRecargosGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SalariosRecargosGen", sequenceName = "SalariosRecargos_SEQ", allocationSize = 1)
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
    //@Column(name = "unidad")
    private String unidad;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "cantidad")
    private Double cantidad;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "valor")
    private Double valor;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "total")
    private Double total;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "activo")
    private Boolean activo;

    /**
     * @generated 0-1-false
     */
    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private Cargo cargo;

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
    public String getUnidad() {
        return this.unidad;
    }

    /**
     * @generated
     */
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    /**
     * @generated
     */
    public Double getCantidad() {
        return this.cantidad;
    }

    /**
     * @generated
     */
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @generated
     */
    public Double getValor() {
        return this.valor;
    }

    /**
     * @generated
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @generated
     */
    public Double getTotal() {
        return this.total;
    }

    /**
     * @generated
     */
    public void setTotal(Double total) {
        this.total = total;
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
    public Cargo getCargo() {
        return this.cargo;
    }

    /**
     * @generated
     */
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

}
