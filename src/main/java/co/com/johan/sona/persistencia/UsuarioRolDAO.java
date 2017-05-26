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
public class UsuarioRolDAO {
	@PersistenceContext
    private EntityManager em;

	
	/**
	* @generated
	*/
	public List<UsuarioRol> obtenerTodos(){
		return em.createNamedQuery("UsuarioRol.obtenerTodos").getResultList();
	}
	
	/**
	* @generated
	*/
	public UsuarioRol obtener(Long id){
		return em.find(UsuarioRol.class, id);
	}
	
	
	/**
	* @generated
	*/
	public UsuarioRol guardar(UsuarioRol entidad){
		em.persist(entidad);
		return entidad;
	}
	
	
	/**
	* @generated
	*/
	public void borrar(Long id){
		em.remove(em.find(UsuarioRol.class, id));
	}
	
	
	/**
	* @generated
	*/
	public void actualizar(UsuarioRol entidad){
		em.merge(entidad);
	}
	
	
}
