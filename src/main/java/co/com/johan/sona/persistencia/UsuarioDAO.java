package co.com.johan.sona.persistencia;

import co.com.johan.sona.persistencia.entity.*;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
  *  @generated
  *  @author Johan Lopez
  */
@Stateless
public class UsuarioDAO {
	@PersistenceContext
    private EntityManager em;

	
	/**
	* @generated
	*/
	public List<Usuario> obtenerTodos(){
		return em.createNamedQuery("Usuario.obtenerTodos").getResultList();
	}
	
     public List<Usuario> obtenerPorUsuarioPassword(String username, String password){
		return em.createNamedQuery("Usuario.obtenerPorUsuarioPasword")
                  .setParameter("nombreUsurio", username)
                  .setParameter("password", password)
                  .getResultList();
	}
	
	/**
	* @generated
	*/
	public Usuario obtener(Long id){
		return em.find(Usuario.class, id);
	}
	
	
	/**
	* @generated
	*/
	public Usuario guardar(Usuario entidad){
		em.persist(entidad);
		return entidad;
	}
	
	
	/**
	* @generated
	*/
	public void borrar(Long id){
		em.remove(em.find(Usuario.class, id));
	}
	
	
	/**
	* @generated
	*/
	public void actualizar(Usuario entidad){
		em.merge(entidad);
	}
	
	
}
