package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
  * @generated
  *  @author Johan Lopez
  */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EstadoCotizacionDTO {

    public EstadoCotizacionDTO(){
        //constructor base
    }
    
    public EstadoCotizacionDTO(Long id){
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
    public String getDescripcion() {
        return this.descripcion;
    }
    
    /**
    * @generated
    */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
