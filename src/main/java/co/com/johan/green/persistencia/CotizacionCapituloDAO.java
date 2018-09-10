package co.com.johan.green.persistencia;

import co.com.johan.green.persistencia.entity.*;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class CotizacionCapituloDAO {

    @PersistenceContext
    private EntityManager em;
    

    /**
     * Retorna una lista con los CotizacionCapitulo que se encuentran en la base
     * de datos.
     *
     * @return lista de CotizacionCapitulo
     * @generated
     */
    public List<CotizacionCapitulo> obtenerTodos() {
        return em.createNamedQuery("CotizacionCapitulo.obtenerTodos").getResultList();
    }

    public List<CotizacionCapitulo> obtenerPorCotizacion(Long cotizacion) {
        return em.createNamedQuery("CotizacionCapitulo.porCotizacion")
                .setParameter("cotizacion", cotizacion)
                .getResultList();
    }

    /**
     * Obtiene CotizacionCapitulo dado su identificador.
     *
     * @param id identificador del elemento CotizacionCapitulo
     * @return CotizacionCapitulo del id dado
     * @generated
     */
    public CotizacionCapitulo obtener(Long id) {
        return em.find(CotizacionCapitulo.class, id);
    }

    /**
     * Almacena la informacion de CotizacionCapitulo
     *
     * @param entidad CotizacionCapitulo a guardar
     * @return CotizacionCapitulo con los cambios realizados por el proceso de
     * guardar
     * @generated
     */
    public CotizacionCapitulo guardar(CotizacionCapitulo entidad) {
        em.persist(entidad);
        return entidad;
    }

    /**
     * Elimina el registro CotizacionCapitulo con el identificador dado.
     *
     * @param id identificador del CotizacionCapitulo
     * @generated
     */
    public void borrar(Long id) {
        em.remove(em.find(CotizacionCapitulo.class, id));
    }

    /**
     * Actualiza la informacion de CotizacionCapitulo.
     *
     * @param entidad CotizacionCapitulo a actualizar
     * @generated
     */
    public void actualizar(CotizacionCapitulo entidad) {
        em.merge(entidad);
    }
    

}
