package co.com.johan.sona.persistencia.entity;

import javax.persistence.*;

/**
 * @generated @author Johan Lopez
 */
@Entity
@Table(name = "TipoDocumento")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.obtenerTodos", query = "select e from TipoDocumento e"),
	@NamedQuery(name = "TipoDocumento.obtenerTodosEmpresa", query = "select e from TipoDocumento e where e.aplicaEmpresa = true")
})
public class TipoDocumento {

    
    
    @Id
    //@Column(name = "TipoDocumento_id")
    @GeneratedValue(generator = "TipoDocumentoGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "TipoDocumentoGen", sequenceName = "TipoDocumento_SEQ", allocationSize = 1)
    private Long id;

    public TipoDocumento() {
    }

    public TipoDocumento(Long id) {
        this.id = id;
    }

    /**
     * @generated 1-1-false
     */
    //@Column(name = "descripcion")
    private String descripcion;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "aplicaEmpresa")
    private Boolean aplicaEmpresa;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public Boolean getAplicaEmpresa() {
        return this.aplicaEmpresa;
    }

    /**
     * @generated
     */
    public void setAplicaEmpresa(Boolean aplicaEmpresa) {
        this.aplicaEmpresa = aplicaEmpresa;
    }

}
