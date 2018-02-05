package co.com.johan.green.persistencia;

import co.com.johan.green.persistencia.entity.Menu;
import co.com.johan.green.persistencia.entity.MenuRol;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class MenuRolDAO {

    @PersistenceContext
    private EntityManager em;

    public void borrarPorRol(Long rolId) {
        em.createNamedQuery("MenuRol.borrarPorRol")
                .setParameter("rol", rolId)
                .executeUpdate();
    }
    
    public MenuRol guardar(MenuRol menuRol) {
        em.persist(menuRol);
        return menuRol;
    }

}
