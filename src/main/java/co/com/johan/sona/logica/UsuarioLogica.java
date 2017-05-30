package co.com.johan.sona.logica;

import co.com.johan.sona.dto.*;
import co.com.johan.sona.persistencia.*;
import co.com.johan.sona.persistencia.entity.*;
import co.com.johan.utils.VerifyRecaptcha;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class UsuarioLogica {

    @EJB
    private UsuarioDAO persistencia;

    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    /**
     * retorna una lista con los Usuario que se encuentran en la base de datos
     *
     * @return retorna una lista de UsuarioDTO
     * @generated
     */
    public List<UsuarioDTO> obtenerTodos() {
        return convertirEntidad(persistencia.obtenerTodos());
    }

    public UsuarioDTO obtenerPorUsuarioPasword(String nombreUsuario, String password) {
        List<Usuario> usuario = persistencia.obtenerPorUsuarioPassword(nombreUsuario, password);
        if (usuario.isEmpty()) {
            return null;
        }
        return convertirEntidad(usuario.get(0));
    }

    /**
     * @param id identificador del elemento Usuario
     * @return Usuario del id dado
     * @generated
     */
    public UsuarioDTO obtener(Long id) {
        return convertirEntidad(persistencia.obtener(id));
    }

    /**
     * almacena la informacion de Usuario
     *
     * @param dto Usuario a guardar
     * @return Usuario con los cambios realizados por el proceso de guardar
     * @generated
     */
    public UsuarioDTO guardar(UsuarioDTO dto) throws Exception {
        boolean verify = VerifyRecaptcha.verify(dto.getgRecaptchaResponse());
        if (verify) {
            List<Usuario> usuarios = persistencia.obtenerPorTipoNumeroDocumento(dto.getNumeroDocumento(),
                    dto.getTipoDocumento().getId());
            if (usuarios.isEmpty()) {
                dto.setNombreUsuario(dto.getNumeroDocumento());
                return this.convertirEntidad(persistencia.guardar(this.convertirDTO(dto)));
            } else {
                throw new Exception("El usuario ya se encuentra registrado");
            }
        } else {
            throw new Exception("Debe validar el codigo captcha");
        }

//        return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
    }

    /**
     * Elimina el registro Usuario con el identificador dado
     *
     * @param id identificador del Usuario
     * @generated
     */
    public void borrar(Long id) {
        persistencia.borrar(id);
    }

    /**
     * actualiza la informacion de Usuario
     *
     * @param dto Usuario a guardar
     * @return Usuario con los cambios realizados por el proceso de guardar
     * @generated
     */
    public void actualizar(UsuarioDTO dto) {
        persistencia.actualizar(convertirDTO(dto));
    }

    /**
     * @generated
     */
    public Usuario convertirDTO(UsuarioDTO dto) {
        if (dto == null) {
            return null;
        }
        Usuario entidad = new Usuario();
        entidad.setId(dto.getId());
        entidad.setNombreUsuario(dto.getNombreUsuario());
        entidad.setPassword(dto.getPassword());
        if (dto.getFecharegistro() != null) {
            entidad.setFecharegistro(LocalDateTime.parse(dto.getFecharegistro(), formato));
        }
        entidad.setNombres(dto.getNombres());
        entidad.setApellidos(dto.getApellidos());
        entidad.setEmail(dto.getEmail());
        entidad.setNumeroDocumento(dto.getNumeroDocumento());
        if (dto.getTipoDocumento() != null) {
            entidad.setTipoDocumento(new TipoDocumento(dto.getTipoDocumento().getId()));
        }
        if (dto.getEmpresa() != null) {
            entidad.setEmpresa(new Empresa(dto.getEmpresa().getId()));
        }
        return entidad;
    }

    /**
     * @generated
     */
    public List<Usuario> convertirDTO(List<UsuarioDTO> dtos) {
        List<Usuario> entidades = new ArrayList<Usuario>();
        for (UsuarioDTO dto : dtos) {
            entidades.add(convertirDTO(dto));
        }
        return entidades;
    }

    /**
     * @generated
     */
    public UsuarioDTO convertirEntidad(Usuario entidad) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(entidad.getId());
        dto.setNombreUsuario(entidad.getNombreUsuario());
        dto.setPassword(entidad.getPassword());
        if (entidad.getFecharegistro() != null) {
            dto.setFecharegistro(entidad.getFecharegistro().format(formato));
        }
        dto.setNombres(entidad.getNombres());
        dto.setApellidos(entidad.getApellidos());
        dto.setEmail(entidad.getEmail());
        dto.setNumeroDocumento(entidad.getNumeroDocumento());
        if (dto.getTipoDocumento() != null) {
            dto.setTipoDocumento(new TipoDocumentoDTO(entidad.getTipoDocumento().getId()));
        }
        if (entidad.getEmpresa() != null) {
            dto.setEmpresa(new EmpresaDTO(entidad.getEmpresa().getId()));
        }
        return dto;
    }

    /**
     * @generated
     */
    public List<UsuarioDTO> convertirEntidad(List<Usuario> entidades) {
        List<UsuarioDTO> dtos = new ArrayList<UsuarioDTO>();
        for (Usuario entidad : entidades) {
            dtos.add(convertirEntidad(entidad));
        }
        return dtos;
    }

}
