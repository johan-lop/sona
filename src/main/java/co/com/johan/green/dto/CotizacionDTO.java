package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.ArrayList;

/**
  * @generated
  *  @author Johan Lopez
  */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CotizacionDTO {

    public CotizacionDTO(){
        //constructor base
    }
    
    public CotizacionDTO(Long id){
        this.id=id;
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
    private Integer codigo;
    
    /**
    * @generated
    */
    private String proyecto;
    
    /**
    * @generated
    */
    private Integer version;
    
    /**
    * @generated
    */
    private String observaciones;
    
    /**
    * @generated
    */
    private String validez;
    
    /**
    * @generated
    */
    private String garantia;
    
    /**
    * @generated
    */
    private String tiempoEntrega;
    
    /**
    * @generated
    */
    private String formaPago;
    
    /**
    * @generated
    */
    private String usuario;
    
    /**
    * @generated
    */
    private String fechaRegistro;
    
    
    /**
    * @generated
    */
    private CiudadDTO ciudad;
    
    /**
    * @generated
    */
    private ContactoDTO contacto;
    
    /**
    * @generated
    */
    private ClienteDTO cliente;
    
    /**
    * @generated
    */
    private HorarioTrabajoDTO horarioTrabajo;
    
    /**
    * @return
    * @generated
    */
    public Integer getCodigo() {
        return this.codigo;
    }
    
    /**
    * @param
    * @generated
    */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    /**
    * @return
    * @generated
    */
    public String getProyecto() {
        return this.proyecto;
    }
    
    /**
    * @param
    * @generated
    */
    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }
    /**
    * @return
    * @generated
    */
    public Integer getVersion() {
        return this.version;
    }
    
    /**
    * @param
    * @generated
    */
    public void setVersion(Integer version) {
        this.version = version;
    }
    /**
    * @return
    * @generated
    */
    public String getObservaciones() {
        return this.observaciones;
    }
    
    /**
    * @param
    * @generated
    */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    /**
    * @return
    * @generated
    */
    public String getValidez() {
        return this.validez;
    }
    
    /**
    * @param
    * @generated
    */
    public void setValidez(String validez) {
        this.validez = validez;
    }
    /**
    * @return
    * @generated
    */
    public String getGarantia() {
        return this.garantia;
    }
    
    /**
    * @param
    * @generated
    */
    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }
    /**
    * @return
    * @generated
    */
    public String getTiempoEntrega() {
        return this.tiempoEntrega;
    }
    
    /**
    * @param
    * @generated
    */
    public void setTiempoEntrega(String tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }
    /**
    * @return
    * @generated
    */
    public String getFormaPago() {
        return this.formaPago;
    }
    
    /**
    * @param
    * @generated
    */
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }
    /**
    * @return
    * @generated
    */
    public String getUsuario() {
        return this.usuario;
    }
    
    /**
    * @param
    * @generated
    */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /**
    * @return
    * @generated
    */
    public String getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    /**
    * @param
    * @generated
    */
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
	/**
	* @return
	* @generated
	*/
	public CiudadDTO getCiudad() {
	    return this.ciudad;
	}
	
	/**
	* @param
	* @generated
	*/
	public void setCiudad(CiudadDTO ciudad) {
	    this.ciudad = ciudad;
	}
	/**
	* @return
	* @generated
	*/
	public ContactoDTO getContacto() {
	    return this.contacto;
	}
	
	/**
	* @param
	* @generated
	*/
	public void setContacto(ContactoDTO contacto) {
	    this.contacto = contacto;
	}
	/**
	* @return
	* @generated
	*/
	public HorarioTrabajoDTO getHorarioTrabajo() {
	    return this.horarioTrabajo;
	}
	
	/**
	* @param
	* @generated
	*/
	public void setHorarioTrabajo(HorarioTrabajoDTO horarioTrabajo) {
	    this.horarioTrabajo = horarioTrabajo;
	}
	/**
	* @return
	* @generated
	*/
	public ClienteDTO getCliente() {
	    return this.cliente;
	}
	
	/**
	* @param
	* @generated
	*/
	public void setCliente(ClienteDTO cliente) {
	    this.cliente = cliente;
	}
	
}
