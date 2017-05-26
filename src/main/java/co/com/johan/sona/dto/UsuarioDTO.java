package co.com.johan.sona.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

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
    
    
    /**
    * @generated
    */
    private UsuarioRolDTO usuarioRol;
    
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
    
	/**
	* @generated
	*/
	public UsuarioRolDTO getUsuarioRol() {
	    return this.usuarioRol;
	}
	
	/**
	* @generated
	*/
	public void setUsuarioRol(UsuarioRolDTO usuarioRol) {
	    this.usuarioRol = usuarioRol;
	}
	
}
