package co.com.johan.sona.persistencia.entity;


import javax.persistence.*;

/**
  *  @generated
  *  @author Johan Lopez
  */
@Entity
@Table(name="UsuarioRol")//, schema="${schema}")
@NamedQueries({
	@NamedQuery(name="UsuarioRol.obtenerTodos", query="select e from UsuarioRol e")
})
public class UsuarioRol {

	@Id
    //@Column(name = "UsuarioRol_id")
    @GeneratedValue(generator = "UsuarioRolGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "UsuarioRolGen", sequenceName = "UsuarioRol_SEQ",allocationSize = 1)
	private Long id;

	public Long getId(){
		return this.id;
	}

	public void setId(Long id){
		this.id=id;
	}
    
    
    
	
}
