package co.com.johan.green.persistencia.entity;

import javax.persistence.*;

/**
 *
 * @author Johan Lopez
 * @generated
 */
@Entity
@Table(name = "ApuItem")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "ApuItem.obtenerTodos", query = "select e from ApuItem e"),
    @NamedQuery(name = "ApuItem.obtenerPorApu", query = "select e from ApuItem e WHERE e.apu.id = :apu"),
    @NamedQuery(name = "ApuItem.borrarPorApu", query = "DELETE FROM ApuItem e WHERE e.apu.id = :apu")
})
public class ApuItem {

    /**
     * Identificador de la tabla ApuItem.
     */
    @Id
    //@Column(name = "ApuItem_id")
    @GeneratedValue(generator = "ApuItemGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ApuItemGen", sequenceName = "ApuItem_SEQ", allocationSize = 1)
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
    //@Column(name = "cantidad")
    private Double cantidad;

    /**
     * @generated 0-1-false
     */
    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private Cargo cargo;

    /**
     * @generated 0-1-false
     */
    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private Herramienta herramienta;

    /**
     * @generated 0-1-false
     */
    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private Material material;

    /**
     * @generated 0-1-false
     */
    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private Apu apu;

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
    public Herramienta getHerramienta() {
        return this.herramienta;
    }

    /**
     * @generated
     */
    public void setHerramienta(Herramienta herramienta) {
        this.herramienta = herramienta;
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

    /**
     * @generated
     */
    public Apu getApu() {
        return this.apu;
    }

    /**
     * @generated
     */
    public void setApu(Apu apu) {
        this.apu = apu;
    }

    /**
     * @generated
     */
    public Material getMaterial() {
        return this.material;
    }

    /**
     * @generated
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

}
