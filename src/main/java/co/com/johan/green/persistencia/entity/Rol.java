package co.com.johan.green.persistencia.entity;

import java.util.List;
import javax.persistence.*;

/**
 * @generated @author Johan Lopez
 */
@Entity
@Table(name = "Rol")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "Rol.obtenerTodos", query = "select e from Rol e ORDER BY e.nombre"),
    @NamedQuery(name = "Rol.obtenerPorDefecto", query = "select e from Rol e WHERE e.defecto = true ORDER BY e.nombre")
})
public class Rol {

    public Rol() {
    }

    public Rol(Long id) {
        this.id = id;
    }

    @Id
    //@Column(name = "Rol_id")
    @GeneratedValue(generator = "RolGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "RolGen", sequenceName = "Rol_SEQ", allocationSize = 1)
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
    //@Column(name = "nombre")
    private String nombre;


    private Boolean defecto;
    
    @OneToMany(mappedBy = "rol")
    private List<MenuRol> menusRol;

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

    public Boolean getDefecto() {
        return defecto;
    }

    public void setDefecto(Boolean defecto) {
        this.defecto = defecto;
    }

}
