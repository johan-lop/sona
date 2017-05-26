package co.com.johan.sona.persistencia.entity;


import javax.persistence.*;

/**
  *  @generated
  *  @author Johan Lopez
  */
@Entity
@Table(name="Rol")//, schema="${schema}")
@NamedQueries({
	@NamedQuery(name="Rol.obtenerTodos", query="select e from Rol e")
})
public class Rol {

	@Id
    //@Column(name = "Rol_id")
    @GeneratedValue(generator = "RolGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "RolGen", sequenceName = "Rol_SEQ",allocationSize = 1)
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
    
    //@Column(name = "nombre")
    private String nombre;
    
    
    /**
    * @generated
    * 0-1-false
    */
    @ManyToOne(cascade={},fetch=FetchType.EAGER)
    private UsuarioRol usuarioRol;
    
    /**
    * @generated
    * 0-1-false
    */
    @ManyToOne(cascade={},fetch=FetchType.EAGER)
    private MenuRol menuRol;
    
    
    /**
    * @generated
    */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
    * @generated
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
	
	/**
	* @generated
	*/
	public UsuarioRol getUsuarioRol() {
	    return this.usuarioRol;
	}
	
	/**
	* @generated
	*/
	public void setUsuarioRol(UsuarioRol usuarioRol) {
	    this.usuarioRol = usuarioRol;
	}
	
	/**
	* @generated
	*/
	public MenuRol getMenuRol() {
	    return this.menuRol;
	}
	
	/**
	* @generated
	*/
	public void setMenuRol(MenuRol menuRol) {
	    this.menuRol = menuRol;
	}
	
}
