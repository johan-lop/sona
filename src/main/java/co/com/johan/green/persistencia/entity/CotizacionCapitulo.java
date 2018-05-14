package co.com.johan.green.persistencia.entity;


import javax.persistence.*;

/**
  *  
  *  @author Johan Lopez
  *  @generated	  
*/
@Entity
@Table(name="CotizacionCapitulo")//, schema="${schema}")
@NamedQueries({
	@NamedQuery(name="CotizacionCapitulo.obtenerTodos", query="select e from CotizacionCapitulo e")
})
public class CotizacionCapitulo {

	/**
	 * Identificador de la tabla CotizacionCapitulo. 	
	 */
	@Id
    //@Column(name = "CotizacionCapitulo_id")
    @GeneratedValue(generator = "CotizacionCapituloGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CotizacionCapituloGen", sequenceName = "CotizacionCapitulo_SEQ",allocationSize = 1)
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
