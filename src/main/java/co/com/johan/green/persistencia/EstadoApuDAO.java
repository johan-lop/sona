package co.com.johan.green.persistencia;

import co.com.johan.green.persistencia.entity.EstadoApu;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class EstadoApuDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    public List<EstadoApu> obtenerTodos() {
        return em.createNamedQuery("EstadoApu.obtenerTodos").getResultList();
    }

    /**
     * @generated
     */
    public EstadoApu obtener(Long id) {
        return em.find(EstadoApu.class, id);
    }

    /**
     * @generated
     */
    public EstadoApu guardar(EstadoApu entidad) {
        em.persist(entidad);
        return entidad;
    }

    /**
     * @generated
     */
    public void borrar(Long id) {
        em.remove(em.find(EstadoApu.class, id));
    }

    /**
     * @generated
     */
    public void actualizar(EstadoApu entidad) {
        em.merge(entidad);
    }

}
