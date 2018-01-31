package co.com.johan.green.persistencia;

import co.com.johan.green.persistencia.entity.*;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class ApuItemDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * Retorna una lista con los ApuItem que se encuentran en la base de datos.
     *
     * @return lista de ApuItem
     * @generated
     */
    public List<ApuItem> obtenerTodos() {
        return em.createNamedQuery("ApuItem.obtenerTodos").getResultList();
    }
    
    public List<ApuItem> obtenerPorApu(Long apuId) {
        return em.createNamedQuery("ApuItem.obtenerPorApu")
                .setParameter("apu", apuId)
                .getResultList();
    }

    /**
     * Obtiene ApuItem dado su identificador.
     *
     * @param id identificador del elemento ApuItem
     * @return ApuItem del id dado
     * @generated
     */
    public ApuItem obtener(Long id) {
        return em.find(ApuItem.class, id);
    }

    /**
     * Almacena la informacion de ApuItem
     *
     * @param entidad ApuItem a guardar
     * @return ApuItem con los cambios realizados por el proceso de guardar
     * @generated
     */
    public ApuItem guardar(ApuItem entidad) {
        em.persist(entidad);
        return entidad;
    }

    /**
     * Elimina el registro ApuItem con el identificador dado.
     *
     * @param id identificador del ApuItem
     * @generated
     */
    public void borrar(Long id) {
        em.remove(em.find(ApuItem.class, id));
    }

    /**
     * Actualiza la informacion de ApuItem.
     *
     * @param entidad ApuItem a actualizar
     * @generated
     */
    public void actualizar(ApuItem entidad) {
        em.merge(entidad);
    }

}
