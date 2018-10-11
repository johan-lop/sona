package co.com.johan.green.persistencia;

import co.com.johan.green.persistencia.entity.CotizacionImpuesto;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class CotizacionImpuestoDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * Retorna una lista con los CotizacionImpuesto que se encuentran en la base
     * de datos.
     *
     * @return lista de CotizacionImpuesto
     * @generated
     */
    public List<CotizacionImpuesto> obtenerTodos() {
        return em.createNamedQuery("CotizacionImpuesto.obtenerTodos").getResultList();
    }

    public List<CotizacionImpuesto> obtenerPorTipo(Long cotizacion) {
        return em.createNamedQuery("CotizacionImpuesto.obtenerPorCotizacion")
                .setParameter("cotizacion", cotizacion)
                .getResultList();
    }

    public void borrarPorCotizacion(Long cotizacion) {
        em.createNamedQuery("CotizacionImpuesto.borrarPorCotizacion")
                .setParameter("cotizacion", cotizacion)
                .executeUpdate();
    }

    /**
     * Obtiene CotizacionImpuesto dado su identificador.
     *
     * @param id identificador del elemento CotizacionImpuesto
     * @return CotizacionImpuesto del id dado
     * @generated
     */
    public CotizacionImpuesto obtener(Long id) {
        return em.find(CotizacionImpuesto.class, id);
    }

    /**
     * Almacena la informacion de CotizacionImpuesto
     *
     * @param entidad CotizacionImpuesto a guardar
     * @return CotizacionImpuesto con los cambios realizados por el proceso de
     * guardar
     * @generated
     */
    public CotizacionImpuesto guardar(CotizacionImpuesto entidad) {
        em.persist(entidad);
        return entidad;
    }

    /**
     * Elimina el registro CotizacionImpuesto con el identificador dado.
     *
     * @param id identificador del CotizacionImpuesto
     * @generated
     */
    public void borrar(Long id) {
        em.remove(em.find(CotizacionImpuesto.class, id));
    }

    /**
     * Actualiza la informacion de CotizacionImpuesto.
     *
     * @param entidad CotizacionImpuesto a actualizar
     * @generated
     */
    public void actualizar(CotizacionImpuesto entidad) {
        em.merge(entidad);
    }

}
