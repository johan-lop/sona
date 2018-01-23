package co.com.johan.green.persistencia;

import co.com.johan.green.persistencia.entity.Usuario;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class UsuarioDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    public List<Usuario> obtenerTodos() {
        return em.createNamedQuery("Usuario.obtenerTodos").getResultList();
    }

    public List<Usuario> obtenerPorUsuarioPassword(String username, String password) {
        return em.createNamedQuery("Usuario.obtenerPorUsuarioPasword")
                .setParameter("nombreUsurio", username.toUpperCase())
                .setParameter("password", password)
                .getResultList();
    }

    public List<Usuario> obtenerPorTipoNumeroDocumento(String numeroDocumento, Long tipoDocumentoId) {
        return em.createNamedQuery("Usuario.obtenerPorTipoNumeroDocumento")
                .setParameter("numeroDocumento", numeroDocumento)
                .setParameter("tipoDoc", tipoDocumentoId)
                .getResultList();
    }

    public void actualizarPassword(String password, Long usuarioId) {
        em.createNamedQuery("Usuario.actualizarPassword")
                .setParameter("usuarioId", usuarioId)
                .setParameter("password", password)
                .executeUpdate();
    }

    /**
     * @generated
     */
    public Usuario obtener(Long id) {
        return em.find(Usuario.class, id);
    }

    /**
     * @generated
     */
    public Usuario guardar(Usuario entidad) {
        em.persist(entidad);
        return entidad;
    }

    /**
     * @generated
     */
    public void borrar(Long id) {
        em.remove(em.find(Usuario.class, id));
    }

    /**
     * @generated
     */
    public void actualizar(Usuario entidad) {
        em.merge(entidad);
    }

}
