package co.com.johan.sona.persistencia;

import co.com.johan.sona.persistencia.entity.*;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
  *  @generated
  *  @author Johan Lopez
  */
@Stateless
public class MenuDAO {
	@PersistenceContext
    private EntityManager em;

	
	/**
	* @generated
	*/
	public List<Menu> obtenerTodos(){
		return em.createNamedQuery("Menu.obtenerTodos").getResultList();
	}
	
	/**
	* @generated
	*/
	public Menu obtener(Long id){
		return em.find(Menu.class, id);
	}
	
	
	/**
	* @generated
	*/
	public Menu guardar(Menu entidad){
		em.persist(entidad);
		return entidad;
	}
	
	
	/**
	* @generated
	*/
	public void borrar(Long id){
		em.remove(em.find(Menu.class, id));
	}
	
	
	/**
	* @generated
	*/
	public void actualizar(Menu entidad){
		em.merge(entidad);
	}
	
	
}
