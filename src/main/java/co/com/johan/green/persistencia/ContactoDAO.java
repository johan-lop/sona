package co.com.johan.green.persistencia;

import co.com.johan.green.persistencia.entity.*;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class ContactoDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * Retorna una lista con los Contacto que se encuentran en la base de datos.
     *
     * @return lista de Contacto
     * @generated
     */
    public List<Contacto> obtenerTodos() {
        return em.createNamedQuery("Contacto.obtenerTodos").getResultList();
    }
    
    public List<Contacto> obtenerPorCliente(Long clienteId) {
        return em.createNamedQuery("Contacto.obtenerPorCliente")
                .setParameter("cliente", clienteId)
                .getResultList();
    }

    /**
     * Obtiene Contacto dado su identificador.
     *
     * @param id identificador del elemento Contacto
     * @return Contacto del id dado
     * @generated
     */
    public Contacto obtener(Long id) {
        return em.find(Contacto.class, id);
    }

    /**
     * Almacena la informacion de Contacto
     *
     * @param entidad Contacto a guardar
     * @return Contacto con los cambios realizados por el proceso de guardar
     * @generated
     */
    public Contacto guardar(Contacto entidad) {
        em.persist(entidad);
        return entidad;
    }

    /**
     * Elimina el registro Contacto con el identificador dado.
     *
     * @param id identificador del Contacto
     * @generated
     */
    public void borrar(Long id) {
        em.remove(em.find(Contacto.class, id));
    }

    /**
     * Actualiza la informacion de Contacto.
     *
     * @param entidad Contacto a actualizar
     * @generated
     */
    public void actualizar(Contacto entidad) {
        em.merge(entidad);
    }

}
