package co.com.johan.green.logica;

import co.com.johan.green.dto.*;
import co.com.johan.green.persistencia.*;
import co.com.johan.green.persistencia.entity.*;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class ApuItemLogica {

    @EJB
    private ApuItemDAO persistencia;

    @EJB
    private SalariosRecargosLogica salariosRecargosLogica;

    /**
     * Retorna una lista con los ApuItem que se encuentran en la base de datos
     *
     * @return retorna una lista de ApuItemDTO
     * @generated
     */
    public List<ApuItemDTO> obtenerTodos() {
        return convertirEntidad(persistencia.obtenerTodos());
    }

    public List<ApuItemDTO> obtenerPorApu(Long apuId) {
        List<ApuItemDTO> apus = convertirEntidad(persistencia.obtenerPorApu(apuId));
        for (ApuItemDTO apu : apus) {
            if (apu.getCargo() != null) {
                Double valorTotal = 0D;
                List<SalariosRecargosDTO> salarios = salariosRecargosLogica.obtenerPorCargo(apu.getCargo().getId());
                if (!salarios.isEmpty()) {
                    for (SalariosRecargosDTO salario : salarios) {
                        if (salario.getActivo()) {
                            valorTotal += (salario.getValor() * salario.getCantidad()) / 100;
                        }
                    }
                }
                apu.getCargo().setTotal(Math.ceil(valorTotal));
                apu.getCargo().setTotalHora(Math.ceil((valorTotal / 30) / 8));
            }

        }
        return apus;
    }

    /**
     * Obtiene ApuItem dado su identificador.
     *
     * @param id identificador del elemento ApuItem
     * @return ApuItem del id dado
     * @generated
     */
    public ApuItemDTO obtener(Long id) {
        return convertirEntidad(persistencia.obtener(id));
    }

    /**
     * Almacena la informacion de ApuItem
     *
     * @param dto ApuItem a guardar
     * @return ApuItem con los cambios realizados por el proceso de guardar
     * @generated
     */
    public ApuItemDTO guardar(ApuItemDTO dto) {
        return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
    }

    /**
     * Elimina el registro ApuItem con el identificador dado
     *
     * @param id identificador del ApuItem
     * @generated
     */
    public void borrar(Long id) {
        persistencia.borrar(id);
    }

    /**
     * Actualiza la informacion de ApuItem
     *
     * @param dto ApuItem a guardar
     * @generated
     */
    public void actualizar(ApuItemDTO dto) {
        persistencia.actualizar(convertirDTO(dto));
    }

    /**
     * Convierte un ApuItemDTO en la entidad ApuItem.
     *
     * @param dto a convertir
     * @return entidad ApuItem
     * @generated
     */
    public ApuItem convertirDTO(ApuItemDTO dto) {
        if (dto == null) {
            return null;
        }
        ApuItem entidad = new ApuItem();
        entidad.setId(dto.getId());
        entidad.setCantidad(dto.getCantidad());

        if (dto.getApu() != null) {
            entidad.setApu(new Apu());
            entidad.getApu().setId(dto.getApu().getId());
        }
        if (dto.getCargo() != null) {
            entidad.setCargo(new Cargo());
            entidad.getCargo().setId(dto.getCargo().getId());
        }
        if (dto.getHerramienta() != null) {
            entidad.setHerramienta(new Herramienta());
            entidad.getHerramienta().setId(dto.getHerramienta().getId());
        }
        if (dto.getMaterial() != null) {
            entidad.setMaterial(new Material());
            entidad.getMaterial().setId(dto.getMaterial().getId());
        }

        return entidad;
    }

    /**
     * Convierte una lista de ApuItemDTO en una lista de ApuItem.
     *
     * @param dtos a convertir
     * @return entidades List<ApuItem>
     * @generated
     */
    public List<ApuItem> convertirDTO(List<ApuItemDTO> dtos) {
        List<ApuItem> entidades = new ArrayList<ApuItem>();
        for (ApuItemDTO dto : dtos) {
            entidades.add(convertirDTO(dto));
        }
        return entidades;
    }

    /**
     * Convierte ApuItem en un DTO ApuItemDTO.
     *
     * @param entidad a convertir
     * @return dto ApuItemDTO
     * @generated
     */
    public ApuItemDTO convertirEntidad(ApuItem entidad) {
        ApuItemDTO dto = new ApuItemDTO();
        dto.setId(entidad.getId());
        dto.setCantidad(entidad.getCantidad());
        if (entidad.getApu() != null) {
            dto.setApu(new ApuDTO(entidad.getApu().getId()));
        }
        if (entidad.getHerramienta() != null) {
            dto.setHerramienta(new HerramientaDTO(entidad.getHerramienta().getId()));
            dto.getHerramienta().setDescripcion(entidad.getHerramienta().getDescripcion());
            dto.getHerramienta().setValor(entidad.getHerramienta().getValor());
            dto.getHerramienta().setPorcentaje(entidad.getHerramienta().getPorcentaje());
        }
        if (entidad.getCargo() != null) {
            dto.setCargo(new CargoDTO(entidad.getCargo().getId()));
            dto.getCargo().setDescripcion(entidad.getCargo().getDescripcion());
        }
        if (entidad.getMaterial() != null) {
            dto.setMaterial(new MaterialDTO(entidad.getMaterial().getId()));
            dto.getMaterial().setDescripcion(entidad.getMaterial().getDescripcion());
            dto.getMaterial().setPrecio(entidad.getMaterial().getPrecio());
            if (entidad.getMaterial().getUnidad() != null) {
                dto.getMaterial().setUnidad(new UnidadDTO(entidad.getMaterial().getUnidad().getId(), 
                        entidad.getMaterial().getUnidad().getDescripcion()));
            }
        }

        return dto;
    }

    /**
     * Convierte una lista de ApuItem en una lista de ApuItemDTO.
     *
     * @param entidades a convertir
     * @return dtos List<ApuItemDTO>
     * @generated
     */
    public List<ApuItemDTO> convertirEntidad(List<ApuItem> entidades) {
        List<ApuItemDTO> dtos = new ArrayList<ApuItemDTO>();
        for (ApuItem entidad : entidades) {
            dtos.add(convertirEntidad(entidad));
        }
        return dtos;
    }

}
