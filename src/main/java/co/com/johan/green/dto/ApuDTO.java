package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.ArrayList;

/**
  * @generated
  *  @author Johan Lopez
  */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApuDTO {

    public ApuDTO(){
        //constructor base
    }
    
    public ApuDTO(Long id){
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
    private Boolean activo;
    
    /**
    * @generated
    */
    private String fechaCreacion;
    
    /**
    * @generated
    */
    private String fechaModificacion;
    
    
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
    public String getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    /**
    * @param
    * @generated
    */
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    /**
    * @return
    * @generated
    */
    public String getFechaModificacion() {
        return this.fechaModificacion;
    }
    
    /**
    * @param
    * @generated
    */
    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    
	
}