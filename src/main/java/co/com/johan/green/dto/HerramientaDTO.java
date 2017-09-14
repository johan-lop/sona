package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.ArrayList;

/**
  * @generated
  *  @author Johan Lopez
  */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HerramientaDTO {

    public HerramientaDTO(){
        //constructor base
    }
    
    public HerramientaDTO(Long id){
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
    private Double porcentaje;
    
    
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
    public Double getPorcentaje() {
        return this.porcentaje;
    }
    
    /**
    * @param
    * @generated
    */
    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }
    
	
}
