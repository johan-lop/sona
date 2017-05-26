package co.com.johan.sona.persistencia.entity;


import javax.persistence.*;

/**
  *  @generated
  *  @author Johan Lopez
  */
@Entity
@Table(name="Menu")//, schema="${schema}")
@NamedQueries({
	@NamedQuery(name="Menu.obtenerTodos", query="select e from Menu e")
})
public class Menu {

	@Id
    //@Column(name = "Menu_id")
    @GeneratedValue(generator = "MenuGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "MenuGen", sequenceName = "Menu_SEQ",allocationSize = 1)
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
    
    //@Column(name = "padre")
    private Long padre;
    
    /**
    * @generated
    * 1-1-false
    */
    
    //@Column(name = "url")
    private String url;
    
    /**
    * @generated
    * 1-1-false
    */
    
    //@Column(name = "orden")
    private Integer orden;
    
    
    
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
    public Long getPadre() {
        return this.padre;
    }
    
    /**
    * @generated
    */
    public void setPadre(Long padre) {
        this.padre = padre;
    }
    
    /**
    * @generated
    */
    public String getUrl() {
        return this.url;
    }
    
    /**
    * @generated
    */
    public void setUrl(String url) {
        this.url = url;
    }
    
    /**
    * @generated
    */
    public Integer getOrden() {
        return this.orden;
    }
    
    /**
    * @generated
    */
    public void setOrden(Integer orden) {
        this.orden = orden;
    }
    
	
}
