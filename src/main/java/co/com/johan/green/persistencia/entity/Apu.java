package co.com.johan.green.persistencia.entity;

import java.time.*;
import javax.persistence.*;

/**
 *
 * @author Johan Lopez
 * @generated
 */
@Entity
@Table(name = "Apu")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "Apu.obtenerTodos", query = "select e from Apu e ORDER BY e.descripcion"),
    @NamedQuery(name = "Apu.obtenerPorNombre", query = "select e from Apu e WHERE UPPER(e.descripcion) = UPPER(:descripcion) ORDER BY e.descripcion")
})
public class Apu {

    /**
     * Identificador de la tabla Apu.
     */
    @Id
    //@Column(name = "Apu_id")
    @GeneratedValue(generator = "ApuGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ApuGen", sequenceName = "Apu_SEQ", allocationSize = 1)
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
    //@Column(name = "descripcion")
    private String descripcion;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "activo")
    private Boolean activo;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    /**
     * @generated 1-1-false
     */
    //@Column(name = "fechaModificacion")
    private LocalDateTime fechaModificacion;
    
    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private EstadoApu estadoApu;
    
    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private Unidad unidad;
    
    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    private Usuario usuario;
    

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
    public Boolean getActivo() {
        return this.activo;
    }

    /**
     * @generated
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    /**
     * @generated
     */
    public LocalDateTime getFechaCreacion() {
        return this.fechaCreacion;
    }

    /**
     * @generated
     */
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @generated
     */
    public LocalDateTime getFechaModificacion() {
        return this.fechaModificacion;
    }

    /**
     * @generated
     */
    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public EstadoApu getEstadoApu() {
        return estadoApu;
    }

    public void setEstadoApu(EstadoApu estadoApu) {
        this.estadoApu = estadoApu;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
}
