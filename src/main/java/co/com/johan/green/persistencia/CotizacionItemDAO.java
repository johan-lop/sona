package co.com.johan.green.persistencia;

import co.com.johan.green.persistencia.entity.*;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class CotizacionItemDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * Retorna una lista con los CotizacionItem que se encuentran en la base de
     * datos.
     *
     * @return lista de CotizacionItem
     * @generated
     */
    public List<CotizacionItem> obtenerTodos() {
        return em.createNamedQuery("CotizacionItem.obtenerTodos").getResultList();
    }
    
    public List<CotizacionItem> obtenerPorCapitulo(Long capituloId) {
        return em.createNamedQuery("CotizacionItem.obtenerPorCapitulo")
                .setParameter("capitulo", capituloId)
                .getResultList();
    }

    /**
     * Obtiene CotizacionItem dado su identificador.
     *
     * @param id identificador del elemento CotizacionItem
     * @return CotizacionItem del id dado
     * @generated
     */
    public CotizacionItem obtener(Long id) {
        return em.find(CotizacionItem.class, id);
    }

    /**
     * Almacena la informacion de CotizacionItem
     *
     * @param entidad CotizacionItem a guardar
     * @return CotizacionItem con los cambios realizados por el proceso de
     * guardar
     * @generated
     */
    public CotizacionItem guardar(CotizacionItem entidad) {
        em.persist(entidad);
        return entidad;
    }

    /**
     * Elimina el registro CotizacionItem con el identificador dado.
     *
     * @param id identificador del CotizacionItem
     * @generated
     */
    public void borrar(Long id) {
        em.remove(em.find(CotizacionItem.class, id));
    }

    /**
     * Actualiza la informacion de CotizacionItem.
     *
     * @param entidad CotizacionItem a actualizar
     * @generated
     */
    public void actualizar(CotizacionItem entidad) {
        em.merge(entidad);
    }
    
    public void borrarPorCapitulo(Long capituloId) {
        em.createNamedQuery("CotizacionItem.borrarPorCapitulo")
                .setParameter("capitulo", capituloId)
                .executeUpdate();
    }

}
