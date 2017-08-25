package co.com.johan.sona.persistencia.entity;


import javax.persistence.*;

/**
  *  
  *  @author Johan Lopez
  *  @generated	  
*/
@Entity
@Table(name="Herramienta")//, schema="${schema}")
@NamedQueries({
	@NamedQuery(name="herramienta.obtenerTodos", query="select e from Herramienta e")
})
public class Herramienta {

	/**
	 * Identificador de la tabla Herramienta. 	
	 */
	@Id
    //@Column(name = "herramienta_id")
    @GeneratedValue(generator = "herramientaGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "herramientaGen", sequenceName = "herramienta_SEQ",allocationSize = 1)
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
    * 1-1-false
    */
    
    //@Column(name = "porcentaje")
    private Double porcentaje;
    
    
    
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
    public Double getPorcentaje() {
        return this.porcentaje;
    }
    
    /**
    * @generated
    */
    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }
    
	
}
