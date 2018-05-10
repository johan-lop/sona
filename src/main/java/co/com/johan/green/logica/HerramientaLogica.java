package co.com.johan.green.logica;

import co.com.johan.green.persistencia.entity.Herramienta;
import co.com.johan.green.persistencia.HerramientaDAO;
import co.com.johan.green.dto.HerramientaDTO;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class HerramientaLogica {

    @EJB
    private HerramientaDAO persistencia;

    /**
     * Retorna una lista con los Herramienta que se encuentran en la base de
     * datos
     *
     * @return retorna una lista de herramientaDTO
     * @generated
     */
    public List<HerramientaDTO> obtenerTodos() {
        return convertirEntidad(persistencia.obtenerTodos());
    }

    /**
     * Obtiene Herramienta dado su identificador.
     *
     * @param id identificador del elemento Herramienta
     * @return Herramienta del id dado
     * @generated
     */
    public HerramientaDTO obtener(Long id) {
        return convertirEntidad(persistencia.obtener(id));
    }

    public List<HerramientaDTO> obtenerPorDescripcion(String descripcion) {
        return convertirEntidad(persistencia.obtenerPorDescripcion(descripcion));
    }

    public List<HerramientaDTO> obtenerPorDescripcionActivo(String descripcion) {
        return convertirEntidad(persistencia.obtenerPorDescripcionActivo(descripcion));
    }

    /**
     * Almacena la informacion de Herramienta
     *
     * @param dto Herramienta a guardar
     * @return Herramienta con los cambios realizados por el proceso de guardar
     * @generated
     */
    public HerramientaDTO guardar(HerramientaDTO dto) {
        dto.setActivo(Boolean.TRUE);
        return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
    }

    /**
     * Elimina el registro Herramienta con el identificador dado
     *
     * @param id identificador del Herramienta
     * @generated
     */
    public void borrar(Long id) {
        persistencia.borrar(id);
    }

    /**
     * Actualiza la informacion de Herramienta
     *
     * @param dto Herramienta a guardar
     * @generated
     */
    public void actualizar(HerramientaDTO dto) {
        persistencia.actualizar(convertirDTO(dto));
    }

    /**
     * Convierte un herramientaDTO en la entidad Herramienta.
     *
     * @param dto a convertir
     * @return entidad Herramienta
     * @generated
     */
    public Herramienta convertirDTO(HerramientaDTO dto) {
        if (dto == null) {
            return null;
        }
        Herramienta entidad = new Herramienta();
        entidad.setId(dto.getId());
        entidad.setDescripcion(dto.getDescripcion());
        entidad.setPorcentaje(dto.getPorcentaje());
        entidad.setValor(dto.getValor());
        entidad.setActivo(dto.getActivo());
        return entidad;
    }

    /**
     * Convierte una lista de herramientaDTO en una lista de Herramienta.
     *
     * @param dtos a convertir
     * @return entidades List<herramienta>
     * @generated
     */
    public List<Herramienta> convertirDTO(List<HerramientaDTO> dtos) {
        List<Herramienta> entidades = new ArrayList<Herramienta>();
        for (HerramientaDTO dto : dtos) {
            entidades.add(convertirDTO(dto));
        }
        return entidades;
    }

    /**
     * Convierte Herramienta en un DTO herramientaDTO.
     *
     * @param entidad a convertir
     * @return dto herramientaDTO
     * @generated
     */
    public HerramientaDTO convertirEntidad(Herramienta entidad) {
        HerramientaDTO dto = new HerramientaDTO();
        dto.setId(entidad.getId());
        dto.setDescripcion(entidad.getDescripcion());
        dto.setPorcentaje(entidad.getPorcentaje());
        dto.setValor(entidad.getValor());
        dto.setActivo(entidad.getActivo());
        return dto;
    }

    /**
     * Convierte una lista de Herramienta en una lista de herramientaDTO.
     *
     * @param entidades a convertir
     * @return dtos List<herramientaDTO>
     * @generated
     */
    public List<HerramientaDTO> convertirEntidad(List<Herramienta> entidades) {
        List<HerramientaDTO> dtos = new ArrayList<HerramientaDTO>();
        for (Herramienta entidad : entidades) {
            dtos.add(convertirEntidad(entidad));
        }
        return dtos;
    }

}
