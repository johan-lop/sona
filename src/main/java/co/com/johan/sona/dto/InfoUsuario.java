package co.com.johan.sona.dto;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * @generated @author Johan Lopez
 */
@Named
@SessionScoped
public class InfoUsuario implements Serializable {

    private UsuarioDTO usuario;

    public InfoUsuario() {
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        if (this.usuario == null) {
            this.usuario = usuario;
        }
    }

}
