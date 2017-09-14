package co.com.johan.green.logica;

import co.com.johan.green.persistencia.entity.Rol;
import co.com.johan.green.persistencia.entity.TipoDocumento;
import co.com.johan.green.persistencia.entity.Empresa;
import co.com.johan.green.persistencia.entity.Usuario;
import co.com.johan.green.persistencia.UsuarioDAO;
import co.com.johan.green.dto.TipoDocumentoDTO;
import co.com.johan.green.dto.UsuarioDTO;
import co.com.johan.green.dto.EmpresaDTO;
import co.com.johan.green.dto.RolDTO;
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
                List<RolDTO> roles = rolLogica.obtenerPorDefecto();
                dto.setNombreUsuario(dto.getNumeroDocumento());
                if (!roles.isEmpty()) {
                    dto.setRoles(roles);
                }
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
        if (dto.getRoles() != null && !dto.getRoles().isEmpty()) {
            List<Rol> roles = new ArrayList<>();
            for (RolDTO roldto : dto.getRoles()) {
                Rol rol = new Rol(roldto.getId());
                roles.add(rol);
            }
            entidad.setRoles(roles);
        }
        entidad.setFirma(dto.getFirma());
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
            dto.getEmpresa().setNombreEmpresa(entidad.getEmpresa().getNombreEmpresa());
        }
        if (entidad.getRoles() != null && !entidad.getRoles().isEmpty()) {
            List<RolDTO> roles = new ArrayList<>();
            for (Rol rol : entidad.getRoles()) {
                RolDTO roldto = new RolDTO(rol.getId());
                roles.add(roldto);
            }
            dto.setRoles(roles);
        }
        dto.setFirma(entidad.getFirma());
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
