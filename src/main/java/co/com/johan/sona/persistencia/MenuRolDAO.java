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
public class MenuRolDAO {
	@PersistenceContext
    private EntityManager em;

	
	/**
	* @generated
	*/
	public List<MenuRol> obtenerTodos(){
		return em.createNamedQuery("MenuRol.obtenerTodos").getResultList();
	}
	
	/**
	* @generated
	*/
	public MenuRol obtener(Long id){
		return em.find(MenuRol.class, id);
	}
	
	
	/**
	* @generated
	*/
	public MenuRol guardar(MenuRol entidad){
		em.persist(entidad);
		return entidad;
	}
	
	
	/**
	* @generated
	*/
	public void borrar(Long id){
		em.remove(em.find(MenuRol.class, id));
	}
	
	
	/**
	* @generated
	*/
	public void actualizar(MenuRol entidad){
		em.merge(entidad);
	}
	
	
}
