package co.com.johan.green.persistencia;

import co.com.johan.green.persistencia.entity.*;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class HorarioTrabajoDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * Retorna una lista con los HorarioTrabajo que se encuentran en la base de
     * datos.
     *
     * @return lista de HorarioTrabajo
     * @generated
     */
    public List<HorarioTrabajo> obtenerTodos() {
        return em.createNamedQuery("HorarioTrabajo.obtenerTodos").getResultList();
    }

    /**
     * Obtiene HorarioTrabajo dado su identificador.
     *
     * @param id identificador del elemento HorarioTrabajo
     * @return HorarioTrabajo del id dado
     * @generated
     */
    public HorarioTrabajo obtener(Long id) {
        return em.find(HorarioTrabajo.class, id);
    }

    /**
     * Almacena la informacion de HorarioTrabajo
     *
     * @param entidad HorarioTrabajo a guardar
     * @return HorarioTrabajo con los cambios realizados por el proceso de
     * guardar
     * @generated
     */
    public HorarioTrabajo guardar(HorarioTrabajo entidad) {
        em.persist(entidad);
        return entidad;
    }

    /**
     * Elimina el registro HorarioTrabajo con el identificador dado.
     *
     * @param id identificador del HorarioTrabajo
     * @generated
     */
    public void borrar(Long id) {
        em.remove(em.find(HorarioTrabajo.class, id));
    }

    /**
     * Actualiza la informacion de HorarioTrabajo.
     *
     * @param entidad HorarioTrabajo a actualizar
     * @generated
     */
    public void actualizar(HorarioTrabajo entidad) {
        em.merge(entidad);
    }

}
