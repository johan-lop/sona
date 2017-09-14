package co.com.johan.green.persistencia;

import co.com.johan.green.persistencia.entity.Viatico;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 *  @generated
 *  @author Johan Lopez
 */
@Stateless
public class ViaticoDAO {
	
	@PersistenceContext
    private EntityManager em;

	
	/**
	 * Retorna una lista con los Viatico que se encuentran en la base de datos.
	 * @return lista de Viatico
	 * @generated
	 */
	public List<Viatico> obtenerTodos(){
		return em.createNamedQuery("Viatico.obtenerTodos").getResultList();
	}
	
	/**
	 * Obtiene Viatico dado su identificador. 	
	 * @param id identificador del elemento Viatico
	 * @return Viatico del id dado
	 * @generated
	 */
	public Viatico obtener(Long id){
		return em.find(Viatico.class, id);
	}
	
	
	/**
	 * Almacena la informacion de Viatico
	 * @param entidad Viatico a guardar
	 * @return Viatico con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public Viatico guardar(Viatico entidad){
		em.persist(entidad);
		return entidad;
	}
	
	
	/**
	 * Elimina el registro Viatico con el identificador dado.
	 * @param id identificador del Viatico
	 * @generated 
	 */
	public void borrar(Long id){
		em.remove(em.find(Viatico.class, id));
	}
	
	
	/**
	 * Actualiza la informacion de Viatico.
	 * @param entidad Viatico a actualizar
	 * @generated
	 */
	public void actualizar(Viatico entidad){
		em.merge(entidad);
	}
	
	
}
