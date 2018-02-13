package co.com.johan.green.persistencia;

import co.com.johan.green.persistencia.entity.*;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class UnidadDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * Retorna una lista con los Unidad que se encuentran en la base de datos.
     *
     * @return lista de Unidad
     * @generated
     */
    public List<Unidad> obtenerTodos() {
        return em.createNamedQuery("Unidad.obtenerTodos").getResultList();
    }
    
    public List<Unidad> obtenerPorNombre(String descripcion) {
        return em.createNamedQuery("Unidad.obtenerPorNombre")
                .setParameter("descripcion", descripcion)
                .getResultList();
    }

    /**
     * Obtiene Unidad dado su identificador.
     *
     * @param id identificador del elemento Unidad
     * @return Unidad del id dado
     * @generated
     */
    public Unidad obtener(Long id) {
        return em.find(Unidad.class, id);
    }

    /**
     * Almacena la informacion de Unidad
     *
     * @param entidad Unidad a guardar
     * @return Unidad con los cambios realizados por el proceso de guardar
     * @generated
     */
    public Unidad guardar(Unidad entidad) {
        em.persist(entidad);
        return entidad;
    }

    /**
     * Elimina el registro Unidad con el identificador dado.
     *
     * @param id identificador del Unidad
     * @generated
     */
    public void borrar(Long id) {
        em.remove(em.find(Unidad.class, id));
    }

    /**
     * Actualiza la informacion de Unidad.
     *
     * @param entidad Unidad a actualizar
     * @generated
     */
    public void actualizar(Unidad entidad) {
        em.merge(entidad);
    }

}
