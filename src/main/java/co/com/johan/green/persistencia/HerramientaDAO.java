package co.com.johan.green.persistencia;

import co.com.johan.green.persistencia.entity.Herramienta;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class HerramientaDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * Retorna una lista con los Herramienta que se encuentran en la base de
     * datos.
     *
     * @return lista de Herramienta
     * @generated
     */
    public List<Herramienta> obtenerTodos() {
        return em.createNamedQuery("herramienta.obtenerTodos").getResultList();
    }

    public List<Herramienta> obtenerPorDescripcion(String descripcion) {
        return em.createNamedQuery("herramienta.obtenerPorDescripcion")
                .setParameter("descripcion", "%" + descripcion.toUpperCase() + "%")
                .getResultList();
    }

    /**
     * Obtiene Herramienta dado su identificador.
     *
     * @param id identificador del elemento Herramienta
     * @return Herramienta del id dado
     * @generated
     */
    public Herramienta obtener(Long id) {
        return em.find(Herramienta.class, id);
    }

    /**
     * Almacena la informacion de Herramienta
     *
     * @param entidad Herramienta a guardar
     * @return Herramienta con los cambios realizados por el proceso de guardar
     * @generated
     */
    public Herramienta guardar(Herramienta entidad) {
        em.persist(entidad);
        return entidad;
    }

    /**
     * Elimina el registro Herramienta con el identificador dado.
     *
     * @param id identificador del Herramienta
     * @generated
     */
    public void borrar(Long id) {
        em.remove(em.find(Herramienta.class, id));
    }

    /**
     * Actualiza la informacion de Herramienta.
     *
     * @param entidad Herramienta a actualizar
     * @generated
     */
    public void actualizar(Herramienta entidad) {
        em.merge(entidad);
    }

}
