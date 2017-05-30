package co.com.johan.sona.persistencia.entity;

import java.util.List;
import javax.persistence.*;

/**
 * @generated @author Johan Lopez
 */
@Entity
@Table(name = "Rol")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "Rol.obtenerTodos", query = "select e from Rol e"),
    @NamedQuery(name = "Rol.obtenerPorDefecto", query = "select e from Rol e WHERE e.defecto = true")
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

    /**
     * @generated 0-1-false
     */
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Menu> menus;
    
    private Boolean defecto;

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

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Boolean getDefecto() {
        return defecto;
    }

    public void setDefecto(Boolean defecto) {
        this.defecto = defecto;
    }

}
