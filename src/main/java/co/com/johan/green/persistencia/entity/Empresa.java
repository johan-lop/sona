package co.com.johan.green.persistencia.entity;

import javax.persistence.*;

/**
 * @generated @author Johan Lopez
 */
@Entity
@Table(name = "Empresa")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "Empresa.obtenerTodos", query = "select e from Empresa e"),
	@NamedQuery(name = "Empresa.obtenerTodosPorNombre", query = "select e from Empresa e where UPPER(e.nombreEmpresa) LIKE :nombreEmpresa")
})
public class Empresa {

    public Empresa() {
    }

    public Empresa(Long id) {
        this.id = id;
    }

    @Id
    //@Column(name = "Empresa_id")
    @GeneratedValue(generator = "EmpresaGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "EmpresaGen", sequenceName = "Empresa_SEQ", allocationSize = 1)
    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @generated 1-1-false
     */
    //@Column(name = "numeroDocumento")
    private String numeroDocumento;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "nombreEmpresa")
    private String nombreEmpresa;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "direccion")
    private String direccion;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "telefono")
    private String telefono;

    /**
     * @generated 0-1-false
     */
    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private TipoDocumento tipoDocumento;

    /**
     * @generated
     */
    public String getNumeroDocumento() {
        return this.numeroDocumento;
    }

    /**
     * @generated
     */
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /**
     * @generated
     */
    public String getNombreEmpresa() {
        return this.nombreEmpresa;
    }

    /**
     * @generated
     */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    /**
     * @generated
     */
    public String getDireccion() {
        return this.direccion;
    }

    /**
     * @generated
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @generated
     */
    public String getTelefono() {
        return this.telefono;
    }

    /**
     * @generated
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @generated
     */
    public TipoDocumento getTipoDocumento() {
        return this.tipoDocumento;
    }

    /**
     * @generated
     */
    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

}
