package co.com.johan.green.persistencia;

import co.com.johan.green.persistencia.entity.EstadoCotizacion;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class EstadoCotizacionDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    public List<EstadoCotizacion> obtenerTodos() {
        return em.createNamedQuery("EstadoCotizacion.obtenerTodos").getResultList();
    }

    /**
     * @generated
     */
    public EstadoCotizacion obtener(Long id) {
        return em.find(EstadoCotizacion.class, id);
    }

    /**
     * @generated
     */
    public EstadoCotizacion guardar(EstadoCotizacion entidad) {
        em.persist(entidad);
        return entidad;
    }

    /**
     * @generated
     */
    public void borrar(Long id) {
        em.remove(em.find(EstadoCotizacion.class, id));
    }

    /**
     * @generated
     */
    public void actualizar(EstadoCotizacion entidad) {
        em.merge(entidad);
    }

}
