package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.ArrayList;

/**
  * @generated
  *  @author Johan Lopez
  */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CotizacionItemDTO {

    public CotizacionItemDTO(){
        //constructor base
    }
    
    public CotizacionItemDTO(Long id){
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
    private Double valorUnitario;
    
    
    /**
    * @generated
    */
    private HerramientaDTO herramienta;
    
    /**
    * @generated
    */
    private CargoDTO cargo;
    
    /**
    * @generated
    */
    private MaterialDTO material;
    
    /**
    * @generated
    */
    private CotizacionCapituloDTO cotizacionCapitulo;
    
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
    public Double getValorUnitario() {
        return this.valorUnitario;
    }
    
    /**
    * @param
    * @generated
    */
    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
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
	/**
	* @return
	* @generated
	*/
	public CotizacionCapituloDTO getCotizacionCapitulo() {
	    return this.cotizacionCapitulo;
	}
	
	/**
	* @param
	* @generated
	*/
	public void setCotizacionCapitulo(CotizacionCapituloDTO cotizacionCapitulo) {
	    this.cotizacionCapitulo = cotizacionCapitulo;
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
	
}
