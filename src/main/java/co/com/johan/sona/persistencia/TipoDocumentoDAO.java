package co.com.johan.sona.persistencia;

import co.com.johan.sona.persistencia.entity.*;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class TipoDocumentoDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    public List<TipoDocumento> obtenerTodos() {
        return em.createNamedQuery("TipoDocumento.obtenerTodos").getResultList();
    }

    public List<TipoDocumento> obtenerTodosEmpresa() {
        return em.createNamedQuery("TipoDocumento.obtenerTodosEmpresa").getResultList();
    }

    /**
     * @generated
     */
    public TipoDocumento obtener(Long id) {
        return em.find(TipoDocumento.class, id);
    }

    /**
     * @generated
     */
    public TipoDocumento guardar(TipoDocumento entidad) {
        em.persist(entidad);
        return entidad;
    }

    /**
     * @generated
     */
    public void borrar(Long id) {
        em.remove(em.find(TipoDocumento.class, id));
    }

    /**
     * @generated
     */
    public void actualizar(TipoDocumento entidad) {
        em.merge(entidad);
    }

}
