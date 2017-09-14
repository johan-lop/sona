package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.ArrayList;

/**
  * @generated
  *  @author Johan Lopez
  */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartamentoDTO {

    public DepartamentoDTO(){
        //constructor base
    }
    
    public DepartamentoDTO(Long id){
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
    private String codigo;
    
    /**
    * @generated
    */
    private String nombre;
    
    
    /**
    * @return
    * @generated
    */
    public String getCodigo() {
        return this.codigo;
    }
    
    /**
    * @param
    * @generated
    */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
    * @return
    * @generated
    */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
    * @param
    * @generated
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
	
}
