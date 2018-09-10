package co.com.johan.green.persistencia.entity;

import java.time.*;
import javax.persistence.*;

/**
 *
 * @author Johan Lopez
 * @generated
 */
@Entity
@Table(name = "Cotizacion")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "Cotizacion.obtenerTodos", query = "select e from Cotizacion e")
})
public class Cotizacion {

    public Cotizacion() {
    }
    
    public Cotizacion(Long id) {
        this.id = id;
    }
    
    /**
     * Identificador de la tabla Cotizacion.
     */
    @Id
    //@Column(name = "Cotizacion_id")
    @GeneratedValue(generator = "CotizacionGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CotizacionGen", sequenceName = "Cotizacion_SEQ", allocationSize = 1)
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
    //@Column(name = "codigo")
    private Integer codigo;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "proyecto")
    private String proyecto;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "version")
    private Integer version;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "observaciones")
    private String observaciones;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "validez")
    private String validez;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "garantia")
    private String garantia;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "tiempoEntrega")
    private String tiempoEntrega;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "formaPago")
    private String formaPago;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "usuario")
    private String usuario;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "fechaRegistro")
    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false)
    private LocalDateTime fechaRegistro;

    /**
     * @generated 0-1-false
     */
    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private Cliente cliente;

    /**
     * @generated 0-1-false
     */
    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private Contacto contacto;

    /**
     * @generated 0-1-false
     */
    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private HorarioTrabajo horarioTrabajo;

    /**
     * @generated 0-1-false
     */
    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private Ciudad ciudad;

    /**
     * @generated
     */
    public Integer getCodigo() {
        return this.codigo;
    }

    /**
     * @generated
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @generated
     */
    public String getProyecto() {
        return this.proyecto;
    }

    /**
     * @generated
     */
    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    /**
     * @generated
     */
    public Integer getVersion() {
        return this.version;
    }

    /**
     * @generated
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @generated
     */
    public String getObservaciones() {
        return this.observaciones;
    }

    /**
     * @generated
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * @generated
     */
    public String getValidez() {
        return this.validez;
    }

    /**
     * @generated
     */
    public void setValidez(String validez) {
        this.validez = validez;
    }

    /**
     * @generated
     */
    public String getGarantia() {
        return this.garantia;
    }

    /**
     * @generated
     */
    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    /**
     * @generated
     */
    public String getTiempoEntrega() {
        return this.tiempoEntrega;
    }

    /**
     * @generated
     */
    public void setTiempoEntrega(String tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }

    /**
     * @generated
     */
    public String getFormaPago() {
        return this.formaPago;
    }

    /**
     * @generated
     */
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    /**
     * @generated
     */
    public String getUsuario() {
        return this.usuario;
    }

    /**
     * @generated
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @generated
     */
    public LocalDateTime getFechaRegistro() {
        return this.fechaRegistro;
    }

    /**
     * @generated
     */
    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * @generated
     */
    public Ciudad getCiudad() {
        return this.ciudad;
    }

    /**
     * @generated
     */
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @generated
     */
    public Cliente getCliente() {
        return this.cliente;
    }

    /**
     * @generated
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @generated
     */
    public Contacto getContacto() {
        return this.contacto;
    }

    /**
     * @generated
     */
    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    /**
     * @generated
     */
    public HorarioTrabajo getHorarioTrabajo() {
        return this.horarioTrabajo;
    }

    /**
     * @generated
     */
    public void setHorarioTrabajo(HorarioTrabajo horarioTrabajo) {
        this.horarioTrabajo = horarioTrabajo;
    }

}
