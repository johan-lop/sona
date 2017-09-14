package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.ArrayList;

/**
  * @generated
  *  @author Johan Lopez
  */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmpresaDTO {

    public EmpresaDTO(){
        //constructor base
    }
    
    public EmpresaDTO(Long id){
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
    private String numeroDocumento;
    
    /**
    * @generated
    */
    private String nombreEmpresa;
    
    /**
    * @generated
    */
    private String direccion;
    
    /**
    * @generated
    */
    private String telefono;
    
    
    /**
    * @generated
    */
    private TipoDocumentoDTO tipoDocumento;
    
    /**
    * @generated
    */
    public String getNumeroDocumento() {
        return this.numeroDocumento;
    }
    
    /**
    * @generated
    */
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    /**
    * @generated
    */
    public String getNombreEmpresa() {
        return this.nombreEmpresa;
    }
    
    /**
    * @generated
    */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    /**
    * @generated
    */
    public String getDireccion() {
        return this.direccion;
    }
    
    /**
    * @generated
    */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
    * @generated
    */
    public String getTelefono() {
        return this.telefono;
    }
    
    /**
    * @generated
    */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
	/**
	* @generated
	*/
	public TipoDocumentoDTO getTipoDocumento() {
	    return this.tipoDocumento;
	}
	
	/**
	* @generated
	*/
	public void setTipoDocumento(TipoDocumentoDTO tipoDocumento) {
	    this.tipoDocumento = tipoDocumento;
	}
	
}
