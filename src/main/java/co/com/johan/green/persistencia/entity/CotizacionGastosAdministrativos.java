package co.com.johan.green.persistencia.entity;


import javax.persistence.*;

/**
  *  
  *  @author Johan Lopez
  *  @generated	  
*/
@Entity
@Table(name="CotizacionGastosAdministrativos")//, schema="${schema}")
@NamedQueries({
	@NamedQuery(name="CotizacionGastosAdministrativos.obtenerTodos", query="select e from CotizacionGastosAdministrativos e")
})
public class CotizacionGastosAdministrativos {

	/**
	 * Identificador de la tabla CotizacionGastosAdministrativos. 	
	 */
	@Id
    //@Column(name = "CotizacionGastosAdministrativos_id")
    @GeneratedValue(generator = "CotizacionGastosAdministrativosGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CotizacionGastosAdministrativosGen", sequenceName = "CotizacionGastosAdministrativos_SEQ",allocationSize = 1)
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
    
    //@Column(name = "valor")
    private Double valor;
    
    /**
    * @generated
    * 1-1-false
    */
    
    //@Column(name = "descripcion")
    private String descripcion;
    
    
    /**
    * @generated
    * 0-1-false
    */
    @ManyToOne(cascade={},fetch=FetchType.EAGER)
    private Cotizacion cotizacion;
    
    
    /**
    * @generated
    */
    public Double getValor() {
        return this.valor;
    }
    
    /**
    * @generated
    */
    public void setValor(Double valor) {
        this.valor = valor;
    }
    
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
	public Cotizacion getCotizacion() {
	    return this.cotizacion;
	}
	
	/**
	* @generated
	*/
	public void setCotizacion(Cotizacion cotizacion) {
	    this.cotizacion = cotizacion;
	}
	
}
