package co.com.johan.sona.persistencia;

import co.com.johan.sona.persistencia.entity.*;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class CiudadDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * Retorna una lista con los Ciudad que se encuentran en la base de datos.
     *
     * @return lista de Ciudad
     * @generated
     */
    public List<Ciudad> obtenerTodos() {
        return em.createNamedQuery("Ciudad.obtenerTodos").getResultList();
    }
    
    public List<Ciudad> obtenerActivos() {
        return em.createNamedQuery("Ciudad.obtenerActivos").getResultList();
    }

    /**
     *
     * @return
     */
    public List<Ciudad> obtenerTodosNombre(String nombre) {
        return em.createNamedQuery("Ciudad.obtenerTodosNombre")
                .setParameter("nombre", "%" + nombre.toUpperCase() +"%")
                .getResultList();
    }

    /**
     * Obtiene Ciudad dado su identificador.
     *
     * @param id identificador del elemento Ciudad
     * @return Ciudad del id dado
     * @generated
     */
    public Ciudad obtener(Long id) {
        return em.find(Ciudad.class, id);
    }

    /**
     * Almacena la informacion de Ciudad
     *
     * @param entidad Ciudad a guardar
     * @return Ciudad con los cambios realizados por el proceso de guardar
     * @generated
     */
    public Ciudad guardar(Ciudad entidad) {
        em.persist(entidad);
        return entidad;
    }

    /**
     * Elimina el registro Ciudad con el identificador dado.
     *
     * @param id identificador del Ciudad
     * @generated
     */
    public void borrar(Long id) {
        em.remove(em.find(Ciudad.class, id));
    }

    /**
     * Actualiza la informacion de Ciudad.
     *
     * @param entidad Ciudad a actualizar
     * @generated
     */
    public void actualizar(Ciudad entidad) {
        em.merge(entidad);
    }

}
