package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * @generated @author Johan Lopez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApuDTO {

    public ApuDTO() {
        //constructor base
    }

    public ApuDTO(Long id) {
        this.id = id;
    }

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @generated
     */
    private String descripcion;

    /**
     * @generated
     */
    private Boolean activo;

    /**
     * @generated
     */
    private String fechaCreacion;

    /**
     * @generated
     */
    private String fechaModificacion;
    
    private List<ApuItemDTO> items;
    
    private EstadoApuDTO estadoApu;
    
    private Double valorTotal;
    
    private UnidadDTO unidad;
    
    private Boolean revisada;
    
    private UsuarioDTO usuarioDTO;
    
    private Integer cantidadHoras;
    
    private Double porcentajeGastosAdministrativos;
    
    private Double resumenHerramientas;
    
    private Double resumenMateriales;
    
    private Double resumenManoObra;
    
    private Double totalMateriales;
    
    private Double totalManoObra;
    
    /**
     * @return @generated
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * @param @generated
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return @generated
     */
    public Boolean getActivo() {
        return this.activo;
    }

    /**
     * @param @generated
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    /**
     * @return @generated
     */
    public String getFechaCreacion() {
        return this.fechaCreacion;
    }

    /**
     * @param @generated
     */
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @return @generated
     */
    public String getFechaModificacion() {
        return this.fechaModificacion;
    }

    /**
     * @param @generated
     */
    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public List<ApuItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ApuItemDTO> items) {
        this.items = items;
    }

    public EstadoApuDTO getEstadoApu() {
        return estadoApu;
    }

    public void setEstadoApu(EstadoApuDTO estadoApu) {
        this.estadoApu = estadoApu;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public UnidadDTO getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadDTO unidad) {
        this.unidad = unidad;
    }

    public Boolean getRevisada() {
        return revisada;
    }

    public void setRevisada(Boolean revisada) {
        this.revisada = revisada;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    public Integer getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(Integer cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    public Double getPorcentajeGastosAdministrativos() {
        return porcentajeGastosAdministrativos;
    }

    public void setPorcentajeGastosAdministrativos(Double porcentajeGastosAdministrativos) {
        this.porcentajeGastosAdministrativos = porcentajeGastosAdministrativos;
    }

    public Double getResumenHerramientas() {
        return resumenHerramientas;
    }

    public void setResumenHerramientas(Double resumenHerramientas) {
        this.resumenHerramientas = resumenHerramientas;
    }

    public Double getResumenMateriales() {
        return resumenMateriales;
    }

    public void setResumenMateriales(Double resumenMateriales) {
        this.resumenMateriales = resumenMateriales;
    }

    public Double getResumenManoObra() {
        return resumenManoObra;
    }

    public void setResumenManoObra(Double resumenManoObra) {
        this.resumenManoObra = resumenManoObra;
    }

    public Double getTotalMateriales() {
        return totalMateriales;
    }

    public void setTotalMateriales(Double totalMateriales) {
        this.totalMateriales = totalMateriales;
    }

    public Double getTotalManoObra() {
        return totalManoObra;
    }

    public void setTotalManoObra(Double totalManoObra) {
        this.totalManoObra = totalManoObra;
    }
    
    
    
}
