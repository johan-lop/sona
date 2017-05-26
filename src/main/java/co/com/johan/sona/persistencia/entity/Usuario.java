package co.com.johan.sona.persistencia.entity;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;

/**
 * @generated @author Johan Lopez
 */
@Entity
@Table(name = "Usuario")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "Usuario.obtenerTodos", query = "select e from Usuario e")
})
public class Usuario {

    @Id
    //@Column(name = "Usuario_id")
    @GeneratedValue(generator = "UsuarioGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "UsuarioGen", sequenceName = "Usuario_SEQ", allocationSize = 1)
    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @generated 1-1-false
     */
    //@Column(name = "nombreUsuario")
    private String nombreUsuario;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "password")
    private String password;

    /**
     * @generated 1-1-false
     */
    @Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "fecharegistro")
    private LocalDateTime fecharegistro;

    /**
     * @generated 0-1-false
     */
    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private UsuarioRol usuarioRol;

    /**
     * @generated
     */
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    /**
     * @generated
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @generated
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @generated
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(LocalDateTime fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    /**
     * @generated
     */
    public UsuarioRol getUsuarioRol() {
        return this.usuarioRol;
    }

    /**
     * @generated
     */
    public void setUsuarioRol(UsuarioRol usuarioRol) {
        this.usuarioRol = usuarioRol;
    }

}
