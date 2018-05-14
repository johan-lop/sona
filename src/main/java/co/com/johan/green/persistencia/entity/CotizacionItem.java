package co.com.johan.green.persistencia.entity;


import javax.persistence.*;

/**
  *  
  *  @author Johan Lopez
  *  @generated	  
*/
@Entity
@Table(name="CotizacionItem")//, schema="${schema}")
@NamedQueries({
	@NamedQuery(name="CotizacionItem.obtenerTodos", query="select e from CotizacionItem e")
})
public class CotizacionItem {

	/**
	 * Identificador de la tabla CotizacionItem. 	
	 */
	@Id
    //@Column(name = "CotizacionItem_id")
    @GeneratedValue(generator = "CotizacionItemGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CotizacionItemGen", sequenceName = "CotizacionItem_SEQ",allocationSize = 1)
	private Long id;

	public Long getId(){
		return this.id;
	}

	public void setId(Long id){
		this.id=id;
	}
    
    /**
    * @generated
    * 1-1-false
    */
    
    //@Column(name = "cantidad")
    private Double cantidad;
    
    /**
    * @generated
    * 1-1-false
    */
    
    //@Column(name = "valorUnitario")
    private Double valorUnitario;
    
    
    /**
    * @generated
    * 0-1-false
    */
    @ManyToOne(cascade={},fetch=FetchType.EAGER)
    private Cargo cargo;
    
    /**
    * @generated
    * 0-1-false
    */
    @ManyToOne(cascade={},fetch=FetchType.EAGER)
    private Herramienta herramienta;
    
    /**
    * @generated
    * 0-1-false
    */
    @ManyToOne(cascade={},fetch=FetchType.EAGER)
    private Material material;
    
    /**
    * @generated
    * 0-1-false
    */
    @ManyToOne(cascade={},fetch=FetchType.EAGER)
    private CotizacionCapitulo cotizacionCapitulo;
    
    
    /**
    * @generated
    */
    public Double getCantidad() {
        return this.cantidad;
    }
    
    /**
    * @generated
    */
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
    
    /**
    * @generated
    */
    public Double getValorUnitario() {
        return this.valorUnitario;
    }
    
    /**
    * @generated
    */
    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
	
	/**
	* @generated
	*/
	public Herramienta getHerramienta() {
	    return this.herramienta;
	}
	
	/**
	* @generated
	*/
	public void setHerramienta(Herramienta herramienta) {
	    this.herramienta = herramienta;
	}
	
	/**
	* @generated
	*/
	public Cargo getCargo() {
	    return this.cargo;
	}
	
	/**
	* @generated
	*/
	public void setCargo(Cargo cargo) {
	    this.cargo = cargo;
	}
	
	/**
	* @generated
	*/
	public CotizacionCapitulo getCotizacionCapitulo() {
	    return this.cotizacionCapitulo;
	}
	
	/**
	* @generated
	*/
	public void setCotizacionCapitulo(CotizacionCapitulo cotizacionCapitulo) {
	    this.cotizacionCapitulo = cotizacionCapitulo;
	}
	
	/**
	* @generated
	*/
	public Material getMaterial() {
	    return this.material;
	}
	
	/**
	* @generated
	*/
	public void setMaterial(Material material) {
	    this.material = material;
	}
	
}
