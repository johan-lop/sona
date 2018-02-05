package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.ArrayList;

/**
 * @generated @author Johan Lopez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RolDTO {

    public RolDTO() {
        //constructor base
    }

    public RolDTO(Long id) {
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
    private String nombre;

    /**
     * @generated
     */
    private UsuarioRolDTO usuarioRol;

    /**
     * @generated
     */
    private MenuRolDTO menuRol;
    
    private List<MenuDTO> menus;

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
    public MenuRolDTO getMenuRol() {
        return this.menuRol;
    }

    /**
     * @generated
     */
    public void setMenuRol(MenuRolDTO menuRol) {
        this.menuRol = menuRol;
    }

    /**
     * @generated
     */
    public UsuarioRolDTO getUsuarioRol() {
        return this.usuarioRol;
    }

    /**
     * @generated
     */
    public void setUsuarioRol(UsuarioRolDTO usuarioRol) {
        this.usuarioRol = usuarioRol;
    }

    public List<MenuDTO> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuDTO> menus) {
        this.menus = menus;
    }

}
