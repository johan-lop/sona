package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.ArrayList;

/**
  * @generated
  *  @author Johan Lopez
  */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactoDTO {

    public ContactoDTO(){
        //constructor base
    }
    
    public ContactoDTO(Long id){
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
    private String nombres;
    
    /**
    * @generated
    */
    private String telefono;
    
    /**
    * @generated
    */
    private String correo;
    
    /**
    * @generated
    */
    private String celular;
    
    /**
    * @generated
    */
    private Boolean activo;
    
    
    /**
    * @generated
    */
    private ClienteDTO cliente;
    
    /**
    * @return
    * @generated
    */
    public String getNombres() {
        return this.nombres;
    }
    
    /**
    * @param
    * @generated
    */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    /**
    * @return
    * @generated
    */
    public String getTelefono() {
        return this.telefono;
    }
    
    /**
    * @param
    * @generated
    */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    /**
    * @return
    * @generated
    */
    public String getCorreo() {
        return this.correo;
    }
    
    /**
    * @param
    * @generated
    */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    /**
    * @return
    * @generated
    */
    public String getCelular() {
        return this.celular;
    }
    
    /**
    * @param
    * @generated
    */
    public void setCelular(String celular) {
        this.celular = celular;
    }
    /**
    * @return
    * @generated
    */
    public Boolean getActivo() {
        return this.activo;
    }
    
    /**
    * @param
    * @generated
    */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
	/**
	* @return
	* @generated
	*/
	public ClienteDTO getCliente() {
	    return this.cliente;
	}
	
	/**
	* @param
	* @generated
	*/
	public void setCliente(ClienteDTO cliente) {
	    this.cliente = cliente;
	}
	
}
