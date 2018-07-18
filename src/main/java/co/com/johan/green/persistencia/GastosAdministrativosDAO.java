package co.com.johan.green.persistencia;

import co.com.johan.green.persistencia.entity.*;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class GastosAdministrativosDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * Retorna una lista con los GastosAdministrativos que se encuentran en la
     * base de datos.
     *
     * @return lista de GastosAdministrativos
     * @generated
     */
    public List<GastosAdministrativos> obtenerTodos() {
        return em.createNamedQuery("GastosAdministrativos.obtenerTodos").getResultList();
    }

    public List<GastosAdministrativos> obtenerActivos() {
        return em.createNamedQuery("GastosAdministrativos.obtenerTodosActivo").getResultList();
    }

    /**
     * Obtiene GastosAdministrativos dado su identificador.
     *
     * @param id identificador del elemento GastosAdministrativos
     * @return GastosAdministrativos del id dado
     * @generated
     */
    public GastosAdministrativos obtener(Long id) {
        return em.find(GastosAdministrativos.class, id);
    }

    /**
     * Almacena la informacion de GastosAdministrativos
     *
     * @param entidad GastosAdministrativos a guardar
     * @return GastosAdministrativos con los cambios realizados por el proceso
     * de guardar
     * @generated
     */
    public GastosAdministrativos guardar(GastosAdministrativos entidad) {
        em.persist(entidad);
        return entidad;
    }

    /**
     * Elimina el registro GastosAdministrativos con el identificador dado.
     *
     * @param id identificador del GastosAdministrativos
     * @generated
     */
    public void borrar(Long id) {
        em.remove(em.find(GastosAdministrativos.class, id));
    }

    /**
     * Actualiza la informacion de GastosAdministrativos.
     *
     * @param entidad GastosAdministrativos a actualizar
     * @generated
     */
    public void actualizar(GastosAdministrativos entidad) {
        em.merge(entidad);
    }

}
