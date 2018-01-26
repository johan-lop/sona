package co.com.johan.green.persistencia;

import co.com.johan.green.persistencia.entity.Menu;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class MenuDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    public List<Menu> obtenerTodos() {
        return em.createNamedQuery("Menu.obtenerTodos").getResultList();
    }

    /**
     * 
     * @param roles
     * @return 
     */
    public List<Menu> obtenerPadresPorRoles(Long rol) {
        return em.createNamedQuery("Menu.obtenerPorRoles")
                .setParameter("rol", rol)
                .getResultList();
    }
    
    /**
     * 
     * @param roles
     * @param padreId
     * @return 
     */
    public List<Menu> obtenerPadresPorRolesHijos(Long rol, Long padreId) {
        return em.createNamedQuery("Menu.obtenerPorRolesHijos")
                .setParameter("rol", rol)
                .setParameter("padreId", padreId)
                .getResultList();
    }

    /**
     * @generated
     */
    public Menu obtener(Long id) {
        return em.find(Menu.class, id);
    }

    /**
     * @generated
     */
    public Menu guardar(Menu entidad) {
        em.persist(entidad);
        return entidad;
    }

    /**
     * @generated
     */
    public void borrar(Long id) {
        em.remove(em.find(Menu.class, id));
    }

    /**
     * @generated
     */
    public void actualizar(Menu entidad) {
        em.merge(entidad);
    }
    
    /**
     * 
     * @return 
     */
    public List<Menu> obtenerTodosPadre() {
        return em.createNamedQuery("Menu.obtenerTodosPadre").getResultList();
    }
    /**
     * 
     * @param padreId
     * @return 
     */
    public List<Menu> obtenerTodosHijos(Long padreId) {
        return em.createNamedQuery("Menu.obtenerTodosHijos")
                .setParameter("padreId", padreId)
                .getResultList();
    }

}
