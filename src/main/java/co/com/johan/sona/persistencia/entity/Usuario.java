package co.com.johan.sona.persistencia.entity;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

/**
 * @generated @author Johan Lopez
 */
@Entity
@Table(name = "Usuario")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "Usuario.obtenerTodos", query = "select e from Usuario e"),
    @NamedQuery(name = "Usuario.obtenerPorTipoNumeroDocumento", 
            query = "select e from Usuario e WHERE e.numeroDocumento = :numeroDocumento AND e.tipoDocumento.id = :tipoDoc"),
    @NamedQuery(name = "Usuario.obtenerPorUsuarioPasword", query = "select e from Usuario e where e.nombreUsuario = :nombreUsurio AND e.password = :password")
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
    private LocalDateTime fecharegistro;
    
    private String nombres;
    
    private String apellidos;
    
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Rol> roles;
    
    @ManyToOne(cascade={},fetch=FetchType.EAGER)
    private Empresa empresa;
    
    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private TipoDocumento tipoDocumento;
    
    private String numeroDocumento;

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

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

}
