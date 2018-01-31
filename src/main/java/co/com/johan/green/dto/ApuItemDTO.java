package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
  * @generated
  *  @author Johan Lopez
  */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApuItemDTO {

    public ApuItemDTO(){
        //constructor base
    }
    
    public ApuItemDTO(Long id){
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
    private Double cantidad;
    
    
    /**
    * @generated
    */
    private CargoDTO cargo;
    
    /**
    * @generated
    */
    private HerramientaDTO herramienta;
    
    /**
    * @generated
    */
    private MaterialDTO material;
    
    /**
    * @generated
    */
    private ApuDTO apu;
    
    /**
    * @return
    * @generated
    */
    public Double getCantidad() {
        return this.cantidad;
    }
    
    /**
    * @param
    * @generated
    */
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
    
	/**
	* @return
	* @generated
	*/
	public HerramientaDTO getHerramienta() {
	    return this.herramienta;
	}
	
	/**
	* @param
	* @generated
	*/
	public void setHerramienta(HerramientaDTO herramienta) {
	    this.herramienta = herramienta;
	}
	/**
	* @return
	* @generated
	*/
	public MaterialDTO getMaterial() {
	    return this.material;
	}
	
	/**
	* @param
	* @generated
	*/
	public void setMaterial(MaterialDTO material) {
	    this.material = material;
	}
	/**
	* @return
	* @generated
	*/
	public ApuDTO getApu() {
	    return this.apu;
	}
	
	/**
	* @param
	* @generated
	*/
	public void setApu(ApuDTO apu) {
	    this.apu = apu;
	}
	/**
	* @return
	* @generated
	*/
	public CargoDTO getCargo() {
	    return this.cargo;
	}
	
	/**
	* @param
	* @generated
	*/
	public void setCargo(CargoDTO cargo) {
	    this.cargo = cargo;
	}
	
}
