package co.com.johan.green.persistencia;

import co.com.johan.green.persistencia.entity.Departamento;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 *  @generated
 *  @author Johan Lopez
 */
@Stateless
public class DepartamentoDAO {
	
	@PersistenceContext
    private EntityManager em;

	
	/**
	 * Retorna una lista con los Departamento que se encuentran en la base de datos.
	 * @return lista de Departamento
	 * @generated
	 */
	public List<Departamento> obtenerTodos(){
		return em.createNamedQuery("Departamento.obtenerTodos").getResultList();
	}
	
	/**
	 * Obtiene Departamento dado su identificador. 	
	 * @param id identificador del elemento Departamento
	 * @return Departamento del id dado
	 * @generated
	 */
	public Departamento obtener(Long id){
		return em.find(Departamento.class, id);
	}
	
	
	/**
	 * Almacena la informacion de Departamento
	 * @param entidad Departamento a guardar
	 * @return Departamento con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public Departamento guardar(Departamento entidad){
		em.persist(entidad);
		return entidad;
	}
	
	
	/**
	 * Elimina el registro Departamento con el identificador dado.
	 * @param id identificador del Departamento
	 * @generated 
	 */
	public void borrar(Long id){
		em.remove(em.find(Departamento.class, id));
	}
	
	
	/**
	 * Actualiza la informacion de Departamento.
	 * @param entidad Departamento a actualizar
	 * @generated
	 */
	public void actualizar(Departamento entidad){
		em.merge(entidad);
	}
	
	
}
