package co.com.johan.sona.persistencia.entity;


import javax.persistence.*;

/**
  *  @generated
  *  @author Johan Lopez
  */
@Entity
@Table(name="MenuRol")//, schema="${schema}")
@NamedQueries({
	@NamedQuery(name="MenuRol.obtenerTodos", query="select e from MenuRol e")
})
public class MenuRol {

	@Id
    //@Column(name = "MenuRol_id")
    @GeneratedValue(generator = "MenuRolGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "MenuRolGen", sequenceName = "MenuRol_SEQ",allocationSize = 1)
	private Long id;

	public Long getId(){
		return this.id;
	}

	public void setId(Long id){
		this.id=id;
	}
    
    
    /**
    * @generated
    * 0-1-false
    */
    @ManyToOne(cascade={},fetch=FetchType.EAGER)
    private Menu menu;
    
    
	
	/**
	* @generated
	*/
	public Menu getMenu() {
	    return this.menu;
	}
	
	/**
	* @generated
	*/
	public void setMenu(Menu menu) {
	    this.menu = menu;
	}
	
}
