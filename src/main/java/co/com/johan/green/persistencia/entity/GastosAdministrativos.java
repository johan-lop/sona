package co.com.johan.green.persistencia.entity;


import javax.persistence.*;

/**
  *  
  *  @author Johan Lopez
  *  @generated	  
*/
@Entity
@Table(name="GastosAdministrativos")//, schema="${schema}")
@NamedQueries({
	@NamedQuery(name="GastosAdministrativos.obtenerTodos", query="select e from GastosAdministrativos e")
})
public class GastosAdministrativos {

	/**
	 * Identificador de la tabla GastosAdministrativos. 	
	 */
	@Id
    //@Column(name = "GastosAdministrativos_id")
    @GeneratedValue(generator = "GastosAdministrativosGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "GastosAdministrativosGen", sequenceName = "GastosAdministrativos_SEQ",allocationSize = 1)
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
    
    //@Column(name = "porcentaje")
    private Double porcentaje;
    
    /**
    * @generated
    * 1-1-false
    */
    
    //@Column(name = "descripcion")
    private String descripcion;
    
    
    
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
    
	
}
