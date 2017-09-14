package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.ArrayList;

/**
  * @generated
  *  @author Johan Lopez
  */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TipoDocumentoDTO {

    public TipoDocumentoDTO(){
        //constructor base
    }
    
    public TipoDocumentoDTO(Long id){
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
    private String descripcion;
    
    /**
    * @generated
    */
    private Boolean aplicaEmpresa;
    
    
    /**
    * @generated
    */
    public String getDescripcion() {
        return this.descripcion;
    }
    
    /**
    * @generated
    */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
    * @generated
    */
    public Boolean getAplicaEmpresa() {
        return this.aplicaEmpresa;
    }
    
    /**
    * @generated
    */
    public void setAplicaEmpresa(Boolean aplicaEmpresa) {
        this.aplicaEmpresa = aplicaEmpresa;
    }
    
	
}
