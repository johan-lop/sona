package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
  * @generated
  *  @author Johan Lopez
  */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MaterialDTO {

    public MaterialDTO(){
        //constructor base
    }
    
    public MaterialDTO(Long id){
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
    private String marca;
    
    /**
    * @generated
    */
    private String descripcion;
    
    /**
    * @generated
    */
    private Double precio;
    
    /**
    * @generated
    */
    private UnidadDTO unidad;
    
    /**
    * @generated
    */
    private Boolean activo;
    
    
    /**
    * @return
    * @generated
    */
    public String getMarca() {
        return this.marca;
    }
    
    /**
    * @param
    * @generated
    */
    public void setMarca(String marca) {
        this.marca = marca;
    }
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
    public Double getPrecio() {
        return this.precio;
    }
    
    /**
    * @param
    * @generated
    */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public UnidadDTO getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadDTO unidad) {
        this.unidad = unidad;
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
    
	
}
