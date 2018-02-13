package co.com.johan.green.persistencia.entity;

import javax.persistence.*;

/**
 *
 * @author Johan Lopez
 * @generated
 */
@Entity
@Table(name = "Material")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "material.obtenerTodos", query = "select e from Material e ORDER BY e.descripcion"),
    @NamedQuery(name = "material.obtenerPorDescripcion", 
            query = "select e from Material e WHERE UPPER(e.descripcion) like :descripcion ORDER BY e.descripcion")
})
public class Material {

    /**
     * Identificador de la tabla Material.
     */
    @Id
    //@Column(name = "material_id")
    @GeneratedValue(generator = "materialGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "materialGen", sequenceName = "material_SEQ", allocationSize = 1)
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
    //@Column(name = "marca")
    private String marca;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "descripcion")
    private String descripcion;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "precio")
    private Double precio;

    
    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private Unidad unidad;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "activo")
    private Boolean activo;

    /**
     * @generated
     */
    public String getMarca() {
        return this.marca;
    }

    /**
     * @generated
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
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
