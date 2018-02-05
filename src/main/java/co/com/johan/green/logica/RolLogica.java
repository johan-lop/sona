package co.com.johan.green.logica;

import co.com.johan.green.dto.MenuDTO;
import co.com.johan.green.persistencia.entity.Rol;
import co.com.johan.green.persistencia.RolDAO;
import co.com.johan.green.dto.RolDTO;
import co.com.johan.green.persistencia.MenuDAO;
import co.com.johan.green.persistencia.MenuRolDAO;
import co.com.johan.green.persistencia.entity.Menu;
import co.com.johan.green.persistencia.entity.MenuRol;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class RolLogica {

    @EJB
    private RolDAO persistencia;

    @EJB
    private MenuDAO menuDAO;

    @EJB
    private MenuRolDAO menuRolDAO;

    /**
     * retorna una lista con los Rol que se encuentran en la base de datos
     *
     * @return retorna una lista de RolDTO
     * @generated
     */
    public List<RolDTO> obtenerTodos() {
        return convertirEntidad(persistencia.obtenerTodos());
    }

    public List<RolDTO> obtenerPorDefecto() {
        return convertirEntidad(persistencia.obtenerPorDefecto());
    }

    /**
     * @param id identificador del elemento Rol
     * @return Rol del id dado
     * @generated
     */
    public RolDTO obtener(Long id) {
        return convertirEntidad(persistencia.obtener(id));
    }

    /**
     * almacena la informacion de Rol
     *
     * @param dto Rol a guardar
     * @return Rol con los cambios realizados por el proceso de guardar
     * @generated
     */
    public RolDTO guardar(RolDTO dto) {
        return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
    }

    /**
     * Elimina el registro Rol con el identificador dado
     *
     * @param id identificador del Rol
     * @generated
     */
    public void borrar(Long id) {
        persistencia.borrar(id);
    }

    /**
     * actualiza la informacion de Rol
     *
     * @param dto Rol a guardar
     * @return Rol con los cambios realizados por el proceso de guardar
     * @generated
     */
    public void actualizar(RolDTO dto) {
        if (dto.getMenus() != null && !dto.getMenus().isEmpty()) {
            menuRolDAO.borrarPorRol(dto.getId());
            for (MenuDTO menu : dto.getMenus()) {
                MenuRol menuRol = new MenuRol();
                menuRol.setMenu(new Menu(menu.getId()));
                menuRol.setRol(new Rol(dto.getId()));
                menuRolDAO.guardar(menuRol);
            }
        }
        persistencia.actualizar(convertirDTO(dto));
    }

    /**
     * @generated
     */
    public Rol convertirDTO(RolDTO dto) {
        if (dto == null) {
            return null;
        }
        Rol entidad = new Rol();
        entidad.setId(dto.getId());
        entidad.setNombre(dto.getNombre());
        if (dto.getMenus() != null && !dto.getMenus().isEmpty()) {
            List<Menu> menus = new ArrayList<>();
            for (MenuDTO menuDTO : dto.getMenus()) {
                menus.add(menuDAO.obtener(menuDTO.getId()));
            }
//            entidad.setMenus(menus);
        }
        return entidad;
    }

    /**
     * @generated
     */
    public List<Rol> convertirDTO(List<RolDTO> dtos) {
        List<Rol> entidades = new ArrayList<Rol>();
        for (RolDTO dto : dtos) {
            entidades.add(convertirDTO(dto));
        }
        return entidades;
    }

    /**
     * @generated
     */
    public RolDTO convertirEntidad(Rol entidad) {
        RolDTO dto = new RolDTO();
        dto.setId(entidad.getId());
        dto.setNombre(entidad.getNombre());
//        if (entidad.getMenus() != null) {
//            List<MenuDTO> menus = new ArrayList<>();
//            for (Menu menu : entidad.getMenus()) {
//                MenuDTO menuDTO = new MenuDTO();
//                menuDTO.setId(menu.getId());
//                menus.add(menuDTO);
//            }
//            dto.setMenus(menus);
//        }
        return dto;
    }

    /**
     * @generated
     */
    public List<RolDTO> convertirEntidad(List<Rol> entidades) {
        List<RolDTO> dtos = new ArrayList<RolDTO>();
        for (Rol entidad : entidades) {
            dtos.add(convertirEntidad(entidad));
        }
        return dtos;
    }

}
