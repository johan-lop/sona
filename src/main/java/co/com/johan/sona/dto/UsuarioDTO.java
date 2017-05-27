package co.com.johan.sona.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
  * @generated
  *  @author Johan Lopez
  */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDTO {

    public UsuarioDTO(){
        //constructor base
    }
    
    public UsuarioDTO(Long id){
        this.id=id;
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
    
    private String gRecaptchaResponse;
    
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
    
    
}
