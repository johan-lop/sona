package co.com.johan.green.persistencia;

import co.com.johan.green.persistencia.entity.*;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class CargoDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * Retorna una lista con los Cargo que se encuentran en la base de datos.
     *
     * @return lista de Cargo
     * @generated
     */
    public List<Cargo> obtenerTodos() {
        return em.createNamedQuery("Cargo.obtenerTodos").getResultList();
    }
    
    public List<Cargo> obtenerPorDescripcion(String descripcion) {
        return em.createNamedQuery("Cargo.obtenerPorDescripcion")
                .setParameter("descripcion", descripcion)
                .getResultList();
    }

    /**
     * Obtiene Cargo dado su identificador.
     *
     * @param id identificador del elemento Cargo
     * @return Cargo del id dado
     * @generated
     */
    public Cargo obtener(Long id) {
        return em.find(Cargo.class, id);
    }

    /**
     * Almacena la informacion de Cargo
     *
     * @param entidad Cargo a guardar
     * @return Cargo con los cambios realizados por el proceso de guardar
     * @generated
     */
    public Cargo guardar(Cargo entidad) {
        em.persist(entidad);
        return entidad;
    }

    /**
     * Elimina el registro Cargo con el identificador dado.
     *
     * @param id identificador del Cargo
     * @generated
     */
    public void borrar(Long id) {
        em.remove(em.find(Cargo.class, id));
    }

    /**
     * Actualiza la informacion de Cargo.
     *
     * @param entidad Cargo a actualizar
     * @generated
     */
    public void actualizar(Cargo entidad) {
        em.merge(entidad);
    }

}
