package co.com.johan.green.logica;

import co.com.johan.green.persistencia.entity.Rol;
import co.com.johan.green.persistencia.entity.TipoDocumento;
import co.com.johan.green.persistencia.entity.Empresa;
import co.com.johan.green.persistencia.entity.Usuario;
import co.com.johan.green.persistencia.UsuarioDAO;
import co.com.johan.green.dto.TipoDocumentoDTO;
import co.com.johan.green.dto.UsuarioDTO;
import co.com.johan.green.dto.EmpresaDTO;
import co.com.johan.green.dto.InfoUsuario;
import co.com.johan.green.dto.RolDTO;
import co.com.johan.green.exception.ApplicationException;
import co.com.johan.green.utils.VerifyRecaptcha;
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

    @EJB
    private RolLogica rolLogica;

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

    public void actualizarPassword(Long usuarioId, String password) {
        persistencia.actualizarPassword(password, usuarioId);
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
    public UsuarioDTO guardar(UsuarioDTO dto, Boolean validaCaptcha) {
        boolean verify = false;
        try {
            verify = VerifyRecaptcha.verify(dto.getgRecaptchaResponse());
        } catch (Exception e) {
            throw new ApplicationException("Debe validar el codigo captcha");
        }
        dto.setTipoDocumento(new TipoDocumentoDTO(1L));
        if (verify || !validaCaptcha) {
            List<Usuario> usuarios = persistencia.obtenerPorTipoNumeroDocumento(dto.getNumeroDocumento(),
                    dto.getTipoDocumento().getId());
            if (usuarios.isEmpty()) {
//                List<RolDTO> roles = rolLogica.obtenerPorDefecto();
                List<RolDTO> roles = new ArrayList<>();
                roles.add(dto.getRol());
                dto.setNombreUsuario(calculaNombreUsuario(dto));
                dto.setPassword(dto.getNumeroDocumento());
                return this.convertirEntidad(persistencia.guardar(this.convertirDTO(dto)));
            } else {
                throw new ApplicationException("El número de documento " + dto.getNumeroDocumento() + " ya se encuentra registrado");
            }
        } else {
            throw new ApplicationException("Debe validar el codigo captcha");
        }

//        return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
    }

    private String calculaNombreUsuario(UsuarioDTO usuarioDTO) {
        String nombreUsuario = "";
        if (usuarioDTO.getNombres() != null) {
            if (usuarioDTO.getNombres().indexOf(' ') != -1) {
                nombreUsuario += usuarioDTO.getNombres().substring(0, usuarioDTO.getNombres().indexOf(' '));
            } else {
                nombreUsuario += usuarioDTO.getNombres();
            }
        }
        nombreUsuario += ".";
        if (usuarioDTO.getApellidos() != null) {
            if (usuarioDTO.getApellidos().indexOf(' ') != -1) {
                nombreUsuario += usuarioDTO.getApellidos().substring(0, usuarioDTO.getApellidos().indexOf(' '));
            } else {
                nombreUsuario += usuarioDTO.getApellidos();
            }
        }
        return nombreUsuario;
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
        List<Usuario> usuarios = persistencia.obtenerPorTipoNumeroDocumento(dto.getNumeroDocumento(),
                dto.getTipoDocumento().getId());
        if (usuarios.isEmpty() || usuarios.get(0).getId().equals(dto.getId())) {
            dto.setNombreUsuario(this.calculaNombreUsuario(dto));
            persistencia.actualizar(convertirDTO(dto));
        } else {
            throw new ApplicationException("El número de documento " + dto.getNumeroDocumento() + " ya se encuentra registrado");
        }
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
        entidad.setTelefono(dto.getTelefono());
        if (dto.getTipoDocumento() != null) {
            entidad.setTipoDocumento(new TipoDocumento(dto.getTipoDocumento().getId()));
        }
        if (dto.getEmpresa() != null) {
            entidad.setEmpresa(new Empresa(dto.getEmpresa().getId()));
        }
        if (dto.getRol() != null) {
            entidad.setRol(new Rol(dto.getRol().getId()));
        }
        entidad.setFirma(dto.getFirma());
        entidad.setTipoImagen(dto.getTipoImagen());
        entidad.setFoto(dto.getFoto());
        entidad.setTipoImagenFoto(dto.getTipoImagenFoto());
        entidad.setActivo(dto.getActivo());
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
        dto.setTelefono(entidad.getTelefono());
        if (entidad.getTipoDocumento() != null) {
            dto.setTipoDocumento(new TipoDocumentoDTO(entidad.getTipoDocumento().getId()));
            dto.getTipoDocumento().setDescripcion(entidad.getTipoDocumento().getDescripcion());
        }
        if (entidad.getEmpresa() != null) {
            dto.setEmpresa(new EmpresaDTO(entidad.getEmpresa().getId()));
            dto.getEmpresa().setNombreEmpresa(entidad.getEmpresa().getNombreEmpresa());
        }
        if (entidad.getRol() != null) {
            dto.setRol(new RolDTO(entidad.getRol().getId()));
            dto.getRol().setNombre(entidad.getRol().getNombre());
        }
        dto.setFirma(entidad.getFirma());
        dto.setTipoImagen(entidad.getTipoImagen());
        dto.setFoto(entidad.getFoto());
        dto.setTipoImagenFoto(entidad.getTipoImagenFoto());
        dto.setActivo(entidad.getActivo());
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
