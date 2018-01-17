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
public class SalariosRecargosDAO {
	
	@PersistenceContext
    private EntityManager em;

	
	/**
	 * Retorna una lista con los SalariosRecargos que se encuentran en la base de datos.
	 * @return lista de SalariosRecargos
	 * @generated
	 */
	public List<SalariosRecargos> obtenerTodos(){
		return em.createNamedQuery("SalariosRecargos.obtenerTodos").getResultList();
	}
	
	/**
	 * Obtiene SalariosRecargos dado su identificador. 	
	 * @param id identificador del elemento SalariosRecargos
	 * @return SalariosRecargos del id dado
	 * @generated
	 */
	public SalariosRecargos obtener(Long id){
		return em.find(SalariosRecargos.class, id);
	}
	
	
	/**
	 * Almacena la informacion de SalariosRecargos
	 * @param entidad SalariosRecargos a guardar
	 * @return SalariosRecargos con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public SalariosRecargos guardar(SalariosRecargos entidad){
		em.persist(entidad);
		return entidad;
	}
	
	
	/**
	 * Elimina el registro SalariosRecargos con el identificador dado.
	 * @param id identificador del SalariosRecargos
	 * @generated 
	 */
	public void borrar(Long id){
		em.remove(em.find(SalariosRecargos.class, id));
	}
	
	
	/**
	 * Actualiza la informacion de SalariosRecargos.
	 * @param entidad SalariosRecargos a actualizar
	 * @generated
	 */
	public void actualizar(SalariosRecargos entidad){
		em.merge(entidad);
	}
	
	
}
