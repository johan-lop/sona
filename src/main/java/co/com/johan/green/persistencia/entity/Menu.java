package co.com.johan.green.persistencia.entity;

import java.util.List;
import javax.persistence.*;

/**
 * @generated @author Johan Lopez
 */
@Entity
@Table(name = "Menu")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "Menu.obtenerTodos", query = "select e from Menu e"),
    @NamedQuery(name = "Menu.obtenerTodosPadre", query = "select e from Menu e where e.padre is null ORDER BY e.orden ASC"),
    @NamedQuery(name = "Menu.obtenerTodosHijos", query = "select e from Menu e where e.padre = :padreId ORDER BY e.orden ASC"),
    @NamedQuery(name = "Menu.obtenerPorRoles", 
            query = "select distinct e from Menu e join fetch e.menusRol m where m.rol.id = :rol AND e.padre is null AND (e.visible is null or e.visible = true) ORDER by e.orden"),
    @NamedQuery(name = "Menu.obtenerTodosPorRol", query = "select distinct e from Menu e join fetch e.menusRol m where m.rol.id = :rol ORDER by e.orden"),
    @NamedQuery(name = "Menu.obtenerPorRolesHijos", 
            query = "select distinct e from Menu e join fetch e.menusRol m where m.rol.id = :rol AND e.padre = :padreId AND (e.visible is null or e.visible = true) ORDER by e.orden"),
    @NamedQuery(name = "Menu.obtenerPermisosAdicionales", 
            query = "select distinct e from Menu e join fetch e.menusRol m where m.rol.id = :rol AND (e.visible is false)")
})
public class Menu {

    public Menu() {
    }

    public Menu(Long id) {
        this.id = id;
    }
    
    @Id
    //@Column(name = "Menu_id")
    @GeneratedValue(generator = "MenuGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "MenuGen", sequenceName = "Menu_SEQ", allocationSize = 1)
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
    //@Column(name = "padre")
    private Long padre;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "url")
    private String url;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "orden")
    private Integer orden;
    
    private Boolean visible;

    @OneToMany(mappedBy = "menu")
    private List<MenuRol> menusRol;

    private String icono;
    
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
    public Long getPadre() {
        return this.padre;
    }

    /**
     * @generated
     */
    public void setPadre(Long padre) {
        this.padre = padre;
    }

    /**
     * @generated
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * @generated
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @generated
     */
    public Integer getOrden() {
        return this.orden;
    }

    /**
     * @generated
     */
    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public List<MenuRol> getMenusRol() {
        return menusRol;
    }

    public void setMenusRol(List<MenuRol> menusRol) {
        this.menusRol = menusRol;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
    
    
}
