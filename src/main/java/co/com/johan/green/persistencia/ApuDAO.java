package co.com.johan.green.persistencia;

import co.com.johan.green.persistencia.entity.*;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 *  @generated
 *  @author Johan Lopez
 */
@Stateless
public class ApuDAO {
	
	@PersistenceContext
    private EntityManager em;

	
	/**
	 * Retorna una lista con los Apu que se encuentran en la base de datos.
	 * @return lista de Apu
	 * @generated
	 */
	public List<Apu> obtenerTodos(){
		return em.createNamedQuery("Apu.obtenerTodos").getResultList();
	}
	
	/**
	 * Obtiene Apu dado su identificador. 	
	 * @param id identificador del elemento Apu
	 * @return Apu del id dado
	 * @generated
	 */
	public Apu obtener(Long id){
		return em.find(Apu.class, id);
	}
	
	
	/**
	 * Almacena la informacion de Apu
	 * @param entidad Apu a guardar
	 * @return Apu con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public Apu guardar(Apu entidad){
		em.persist(entidad);
		return entidad;
	}
	
	
	/**
	 * Elimina el registro Apu con el identificador dado.
	 * @param id identificador del Apu
	 * @generated 
	 */
	public void borrar(Long id){
		em.remove(em.find(Apu.class, id));
	}
	
	
	/**
	 * Actualiza la informacion de Apu.
	 * @param entidad Apu a actualizar
	 * @generated
	 */
	public void actualizar(Apu entidad){
		em.merge(entidad);
	}
	
	
}
