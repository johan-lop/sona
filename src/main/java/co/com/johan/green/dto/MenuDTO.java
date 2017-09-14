package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.ArrayList;

/**
 * @generated @author Johan Lopez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuDTO {

    public MenuDTO() {
        //constructor base
    }

    public MenuDTO(Long id) {
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
    private Long padre;

    /**
     * @generated
     */
    private String url;

    /**
     * @generated
     */
    private Integer orden;

    private List<MenuDTO> menusHijos;

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

    public List<MenuDTO> getMenusHijos() {
        return menusHijos;
    }

    public void setMenusHijos(List<MenuDTO> menusHijos) {
        this.menusHijos = menusHijos;
    }

}
