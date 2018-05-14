package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.ArrayList;

/**
  * @generated
  *  @author Johan Lopez
  */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CotizacionCapituloDTO {

    public CotizacionCapituloDTO(){
        //constructor base
    }
    
    public CotizacionCapituloDTO(Long id){
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
    private CotizacionDTO cotizacion;
    
    /**
    * @return
    * @generated
    */
    public String getDescripcion() {
        return this.descripcion;
    }
    
    /**
    * @param
    * @generated
    */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
	/**
	* @return
	* @generated
	*/
	public CotizacionDTO getCotizacion() {
	    return this.cotizacion;
	}
	
	/**
	* @param
	* @generated
	*/
	public void setCotizacion(CotizacionDTO cotizacion) {
	    this.cotizacion = cotizacion;
	}
	
}
