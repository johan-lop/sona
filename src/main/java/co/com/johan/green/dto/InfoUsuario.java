package co.com.johan.green.dto;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * @generated @author Johan Lopez
 */
@Named
@SessionScoped
public class InfoUsuario implements Serializable {

    private UsuarioDTO usuario;

    private List<MenuDTO> permisos;
    
    public InfoUsuario() {
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public List<MenuDTO> getPermisos() {
        return permisos;
    }
    
    

    public void setUsuario(UsuarioDTO usuario, List<MenuDTO> permisos) {
        if (this.usuario == null) {
            this.usuario = usuario;
        }
        if (this.permisos == null) {
            this.permisos = permisos;
        }
    }

}
