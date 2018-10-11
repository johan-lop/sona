package co.com.johan.green.persistencia;

import co.com.johan.green.persistencia.entity.Impuesto;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class ImpuestoDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * Retorna una lista con los Impuesto que se encuentran en la base de datos.
     *
     * @return lista de Impuesto
     * @generated
     */
    public List<Impuesto> obtenerTodos() {
        return em.createNamedQuery("Impuesto.obtenerTodos").getResultList();
    }
    
    
    public List<Impuesto> obtenerPorTipo(String tipo) {
        return em.createNamedQuery("Impuesto.obtenerPorTipo")
                .setParameter("tipo", tipo)
                .getResultList();
    }

    /**
     * Obtiene Impuesto dado su identificador.
     *
     * @param id identificador del elemento Impuesto
     * @return Impuesto del id dado
     * @generated
     */
    public Impuesto obtener(Long id) {
        return em.find(Impuesto.class, id);
    }

    /**
     * Almacena la informacion de Impuesto
     *
     * @param entidad Impuesto a guardar
     * @return Impuesto con los cambios realizados por el proceso de guardar
     * @generated
     */
    public Impuesto guardar(Impuesto entidad) {
        em.persist(entidad);
        return entidad;
    }

    /**
     * Elimina el registro Impuesto con el identificador dado.
     *
     * @param id identificador del Impuesto
     * @generated
     */
    public void borrar(Long id) {
        em.remove(em.find(Impuesto.class, id));
    }

    /**
     * Actualiza la informacion de Impuesto.
     *
     * @param entidad Impuesto a actualizar
     * @generated
     */
    public void actualizar(Impuesto entidad) {
        em.merge(entidad);
    }

}
