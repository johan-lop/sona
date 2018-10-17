package co.com.johan.green.persistencia;

import co.com.johan.green.persistencia.entity.*;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class CotizacionDAO {
    
    @PersistenceContext
    private EntityManager em;

    /**
     * Retorna una lista con los Cotizacion que se encuentran en la base de
     * datos.
     *
     * @return lista de Cotizacion
     * @generated
     */
    public List<Cotizacion> obtenerTodos() {
        return em.createNamedQuery("Cotizacion.obtenerTodos").getResultList();
    }

    /**
     * Obtiene Cotizacion dado su identificador.
     *
     * @param id identificador del elemento Cotizacion
     * @return Cotizacion del id dado
     * @generated
     */
    public Cotizacion obtener(Long id) {
        return em.find(Cotizacion.class, id);
    }

    /**
     * Almacena la informacion de Cotizacion
     *
     * @param entidad Cotizacion a guardar
     * @return Cotizacion con los cambios realizados por el proceso de guardar
     * @generated
     */
    public Cotizacion guardar(Cotizacion entidad) {
        entidad.setFechaRegistro(LocalDateTime.now());
        em.persist(entidad);
        return entidad;
    }

    /**
     * Elimina el registro Cotizacion con el identificador dado.
     *
     * @param id identificador del Cotizacion
     * @generated
     */
    public void borrar(Long id) {
        em.remove(em.find(Cotizacion.class, id));
    }

    /**
     * Actualiza la informacion de Cotizacion.
     *
     * @param entidad Cotizacion a actualizar
     * @generated
     */
    public void actualizar(Cotizacion entidad) {
        em.merge(entidad);
    }
    
}
