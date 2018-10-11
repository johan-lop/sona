package co.com.johan.green.persistencia;

import co.com.johan.green.persistencia.entity.*;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class CotizacionGastosAdministrativosDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * Retorna una lista con los CotizacionGastosAdministrativos que se
     * encuentran en la base de datos.
     *
     * @return lista de CotizacionGastosAdministrativos
     * @generated
     */
    public List<CotizacionGastosAdministrativos> obtenerTodos() {
        return em.createNamedQuery("CotizacionGastosAdministrativos.obtenerTodos").getResultList();
    }
    
    public List<CotizacionGastosAdministrativos> obtenerPorCotizacion(Long cotizacionId) {
        return em.createNamedQuery("CotizacionGastosAdministrativos.obtenerPorCotizacion")
                .setParameter("cotizacion", cotizacionId)
                .getResultList();
    }

    /**
     * Obtiene CotizacionGastosAdministrativos dado su identificador.
     *
     * @param id identificador del elemento CotizacionGastosAdministrativos
     * @return CotizacionGastosAdministrativos del id dado
     * @generated
     */
    public CotizacionGastosAdministrativos obtener(Long id) {
        return em.find(CotizacionGastosAdministrativos.class, id);
    }

    /**
     * Almacena la informacion de CotizacionGastosAdministrativos
     *
     * @param entidad CotizacionGastosAdministrativos a guardar
     * @return CotizacionGastosAdministrativos con los cambios realizados por el
     * proceso de guardar
     * @generated
     */
    public CotizacionGastosAdministrativos guardar(CotizacionGastosAdministrativos entidad) {
        em.persist(entidad);
        return entidad;
    }

    /**
     * Elimina el registro CotizacionGastosAdministrativos con el identificador
     * dado.
     *
     * @param id identificador del CotizacionGastosAdministrativos
     * @generated
     */
    public void borrar(Long id) {
        em.remove(em.find(CotizacionGastosAdministrativos.class, id));
    }

    /**
     * Actualiza la informacion de CotizacionGastosAdministrativos.
     *
     * @param entidad CotizacionGastosAdministrativos a actualizar
     * @generated
     */
    public void actualizar(CotizacionGastosAdministrativos entidad) {
        em.merge(entidad);
    }

    public void borrarPorCotizacion(Long cotizacionId) {
        em.createNamedQuery("CotizacionGastosAdministrativos.borrarPorCotizacion")
                .setParameter("cotizacion", cotizacionId)
                .executeUpdate();
    }

}
