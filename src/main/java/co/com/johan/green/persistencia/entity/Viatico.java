package co.com.johan.green.persistencia.entity;

import javax.persistence.*;

/**
 *
 * @author Johan Lopez
 * @generated
 */
@Entity
@Table(name = "Viatico")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "Viatico.obtenerTodos", query = "select e from Viatico e"),
    @NamedQuery(name = "Viatico.obtenerTodosCiudad", query = "select e from Viatico e where e.ciudad.id = :ciudad")
})
public class Viatico {

    /**
     * Identificador de la tabla Viatico.
     */
    @Id
    //@Column(name = "Viatico_id")
    @GeneratedValue(generator = "ViaticoGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ViaticoGen", sequenceName = "Viatico_SEQ", allocationSize = 1)
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
    //@Column(name = "valorDiario")
    private Double valorDiario;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "activo")
    private Boolean activo;

    /**
     * @generated 0-1-false
     */
    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private Ciudad ciudad;

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
    public Double getValorDiario() {
        return this.valorDiario;
    }

    /**
     * @generated
     */
    public void setValorDiario(Double valorDiario) {
        this.valorDiario = valorDiario;
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
    public Ciudad getCiudad() {
        return this.ciudad;
    }

    /**
     * @generated
     */
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

}
