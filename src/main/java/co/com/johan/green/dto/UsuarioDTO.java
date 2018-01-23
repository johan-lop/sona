package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 * @generated @author Johan Lopez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDTO {

    public UsuarioDTO() {
        //constructor base
    }

    public UsuarioDTO(Long id) {
        this.id = id;
    }

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @generated
     */
    private String nombreUsuario;

    /**
     * @generated
     */
    private String password;

    /**
     * @generated
     */
    private String fecharegistro;

    private String nombres;

    private String apellidos;

    private String email;

    private String telefono;

    private String gRecaptchaResponse;
    
    private EmpresaDTO empresa;
    
    private TipoDocumentoDTO tipoDocumento;
    
    private String numeroDocumento;
    
    private List<RolDTO> roles;
    
    private RolDTO rol;
    
    private String firma;
    
    private String tipoImagen;
    
    private String foto;

    private String tipoImagenFoto;
    
    private Boolean activo;

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

    /**
     * @generated
     */
    public String getFecharegistro() {
        return this.fecharegistro;
    }

    /**
     * @generated
     */
    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
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

    public String getgRecaptchaResponse() {
        return gRecaptchaResponse;
    }

    public void setgRecaptchaResponse(String gRecaptchaResponse) {
        this.gRecaptchaResponse = gRecaptchaResponse;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

    public TipoDocumentoDTO getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoDTO tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public List<RolDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RolDTO> roles) {
        this.roles = roles;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public RolDTO getRol() {
        return rol;
    }

    public void setRol(RolDTO rol) {
        this.rol = rol;
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
    

}
