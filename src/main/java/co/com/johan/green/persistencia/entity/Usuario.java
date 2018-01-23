package co.com.johan.green.persistencia.entity;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

/**
 * @generated @author Johan Lopez
 */
@Entity
@Table(name = "Usuario")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "Usuario.obtenerTodos", query = "select e from Usuario e order by e.nombres")
    ,
    @NamedQuery(name = "Usuario.obtenerPorTipoNumeroDocumento",
            query = "select e from Usuario e WHERE e.numeroDocumento = :numeroDocumento AND e.tipoDocumento.id = :tipoDoc")
    ,
    @NamedQuery(name = "Usuario.obtenerPorUsuarioPasword", query = "select e from Usuario e where UPPER(e.nombreUsuario) = :nombreUsurio AND e.password = :password")
    ,
    @NamedQuery(name = "Usuario.actualizarPassword", query = "UPDATE Usuario u set u.password = :password where u.id = :usuarioId")
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

    private String telefono;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Rol> roles;

    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private Empresa empresa;

    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private TipoDocumento tipoDocumento;

    private String numeroDocumento;

    @Column(columnDefinition = "TEXT")
    private String firma;

    private String tipoImagen;
    
    @Column(columnDefinition = "TEXT")
    private String foto;

    private String tipoImagenFoto;
    
    private Boolean activo;

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

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getTipoImagen() {
        return tipoImagen;
    }

    public void setTipoImagen(String tipoImagen) {
        this.tipoImagen = tipoImagen;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTipoImagenFoto() {
        return tipoImagenFoto;
    }

    public void setTipoImagenFoto(String tipoImagenFoto) {
        this.tipoImagenFoto = tipoImagenFoto;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    
    
}
