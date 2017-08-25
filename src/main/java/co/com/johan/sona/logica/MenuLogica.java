package co.com.johan.sona.logica;

import co.com.johan.sona.dto.*;
import co.com.johan.sona.persistencia.*;
import co.com.johan.sona.persistencia.entity.*;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class MenuLogica {

    @EJB
    private MenuDAO persistencia;

    /**
     * retorna una lista con los Menu que se encuentran en la base de datos
     *
     * @return retorna una lista de MenuDTO
     * @generated
     */
    public List<MenuDTO> obtenerTodos() {
        return convertirEntidad(persistencia.obtenerTodos());
    }

    /**
     * @param id identificador del elemento Menu
     * @return Menu del id dado
     * @generated
     */
    public MenuDTO obtener(Long id) {
        return convertirEntidad(persistencia.obtener(id));
    }

    /**
     * almacena la informacion de Menu
     *
     * @param dto Menu a guardar
     * @return Menu con los cambios realizados por el proceso de guardar
     * @generated
     */
    public MenuDTO guardar(MenuDTO dto) {
        return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
    }

    /**
     * Elimina el registro Menu con el identificador dado
     *
     * @param id identificador del Menu
     * @generated
     */
    public void borrar(Long id) {
        persistencia.borrar(id);
    }

    /**
     * actualiza la informacion de Menu
     *
     * @param dto Menu a guardar
     * @return Menu con los cambios realizados por el proceso de guardar
     * @generated
     */
    public void actualizar(MenuDTO dto) {
        persistencia.actualizar(convertirDTO(dto));
    }

    /**
     * @generated
     */
    public Menu convertirDTO(MenuDTO dto) {
        if (dto == null) {
            return null;
        }
        Menu entidad = new Menu();
        entidad.setId(dto.getId());
        entidad.setDescripcion(dto.getDescripcion());
        entidad.setPadre(dto.getPadre());
        entidad.setUrl(dto.getUrl());
        entidad.setOrden(dto.getOrden());

        return entidad;
    }

    /**
     * @generated
     */
    public List<Menu> convertirDTO(List<MenuDTO> dtos) {
        List<Menu> entidades = new ArrayList<Menu>();
        for (MenuDTO dto : dtos) {
            entidades.add(convertirDTO(dto));
        }
        return entidades;
    }

    /**
     * @generated
     */
    public MenuDTO convertirEntidad(Menu entidad) {
        MenuDTO dto = new MenuDTO();
        dto.setId(entidad.getId());
        dto.setDescripcion(entidad.getDescripcion());
        dto.setPadre(entidad.getPadre());
        dto.setUrl(entidad.getUrl());
        dto.setOrden(entidad.getOrden());

        return dto;
    }

    /**
     * @generated
     */
    public List<MenuDTO> convertirEntidad(List<Menu> entidades) {
        List<MenuDTO> dtos = new ArrayList<MenuDTO>();
        for (Menu entidad : entidades) {
            dtos.add(convertirEntidad(entidad));
        }
        return dtos;
    }

    public String obtenerMenuPorRoles(List<Long> roles) {
        List<Menu> menus = persistencia.obtenerPadresPorRoles(roles);
        StringBuilder sb = new StringBuilder();
        sb.append("<ul class=\"nav navbar-nav\" id=\"sidenav01\">\n" +
"                                <li class=\"active\">\n" +
"                                    <a data-toggle=\"collapse\" data-target=\"#toggleDemo0\" \n" +
"                                       data-parent=\"#sidenav01\" class=\"collapsed\">\n" +
"                                        <div id=\"nombreUsuario\"></div>\n" +
"                                        <small id=\"empresa\"></small>&nbsp;<span class=\"caret\"></span>\n" +
"                                    </a>\n" +
"                                    <div class=\"collapse\" id=\"toggleDemo0\" style=\"height: 0px;\">\n" +
"                                        <ul class=\"nav nav-list\">\n" +
"                                            <li><a href=\"#\">ProfileSubMenu1</a></li>\n" +
"                                        </ul>\n" +
"                                    </div>\n" +
"                                </li>");
        
        
        for (Menu menu : menus) {
            sb.append("<li>");
            sb.append("<a href=\"#\" data-toggle=\"collapse\" data-target=\"#toggleDemo\" ");
            sb.append("data-parent=\"#sidenav01\" class=\"collapsed\">");
            sb.append("<span class=\"glyphicon glyphicon-cloud\"></span> ");
            sb.append(menu.getDescripcion());
            sb.append("<span class=\"caret pull-right\"></span> </a>");
            List<Menu> menusHijos = persistencia.obtenerPadresPorRolesHijos(roles, menu.getId());
            if (!menusHijos.isEmpty()) {
                sb.append("<div class=\"collapse\" id=\"toggleDemo\" style=\"height: 0px;\">");
                sb.append("<ul class=\"nav nav-list\">");
                for (Menu menuHijo : menusHijos) {
                    sb.append("<li><a href='");
                    sb.append(menuHijo.getUrl());
                    sb.append("'>").append(menuHijo.getDescripcion());
                    sb.append("</a></li>");
                }
                sb.append("</ul>");
            }
            sb.append("</li>");
            sb.append("<li><a href='/Sona/logout'><span class='glyphicon glyphicon-off'></span> Salir</a></li>");
        }
        sb.append("</ul>");
        return sb.toString();
    }

    public List<MenuDTO> obtenerTodosSubmenus() {
        List<Menu> menusPadre = persistencia.obtenerTodosPadre();
        List<MenuDTO> resultado = new ArrayList<>();
        for (Menu menu : menusPadre) {
            MenuDTO menuDTO = this.convertirEntidad(menu);
            List<Menu> menuHijos = persistencia.obtenerTodosHijos(menu.getId());
            List<MenuDTO> hijos = new ArrayList<>();
            for (Menu menuHijo : menuHijos) {
                MenuDTO menuHijoDTO = this.convertirEntidad(menuHijo);
                hijos.add(menuHijoDTO);
            }
            menuDTO.setMenusHijos(hijos);
            resultado.add(menuDTO);
        }
        return resultado;
    }
    
}
