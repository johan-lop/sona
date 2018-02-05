package co.com.johan.green.persistencia.entity;

import java.util.List;
import javax.persistence.*;

/**
 * @generated @author Johan Lopez
 */
@Entity
@Table(name = "menu_rol")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "MenuRol.obtenerTodos", query = "select e from MenuRol e"),
    @NamedQuery(name = "MenuRol.borrarPorRol", query = "DELETE from MenuRol m WHERE m.rol.id = :rol")
})
public class MenuRol {

    public MenuRol() {
    }

    public MenuRol(Long id) {
        this.id = id;
    }
    
    @Id
    //@Column(name = "Menu_id")
    @GeneratedValue(generator = "MenuRolGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "MenuRolGen", sequenceName = "MenuRol_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private Menu menu;

    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private Rol rol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    
}
