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
public class CotizacionItemLogica {

    @EJB
    private CotizacionItemDAO persistencia;

    @EJB
    private ApuLogica apuLogica;

    @EJB
    private ViaticoLogica viaticoLogica;

    @EJB
    private HorarioTrabajoLogica horarioTrabajoLogica;

    /**
     * Retorna una lista con los CotizacionItem que se encuentran en la base de
     * datos
     *
     * @return retorna una lista de CotizacionItemDTO
     * @generated
     */
    public List<CotizacionItemDTO> obtenerTodos() {
        return convertirEntidad(persistencia.obtenerTodos());
    }

    public List<CotizacionItemDTO> obtenerPorCapitulo(Long capituloId) {
        return convertirEntidad(persistencia.obtenerPorCapitulo(capituloId));
    }

    /**
     * Obtiene CotizacionItem dado su identificador.
     *
     * @param id identificador del elemento CotizacionItem
     * @return CotizacionItem del id dado
     * @generated
     */
    public CotizacionItemDTO obtener(Long id) {
        return convertirEntidad(persistencia.obtener(id));
    }

    /**
     * Almacena la informacion de CotizacionItem
     *
     * @param dto CotizacionItem a guardar
     * @return CotizacionItem con los cambios realizados por el proceso de
     * guardar
     * @generated
     */
    public CotizacionItemDTO guardar(CotizacionItemDTO dto) {
        return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
    }

    /**
     * Elimina el registro CotizacionItem con el identificador dado
     *
     * @param id identificador del CotizacionItem
     * @generated
     */
    public void borrar(Long id) {
        persistencia.borrar(id);
    }

    /**
     * Actualiza la informacion de CotizacionItem
     *
     * @param dto CotizacionItem a guardar
     * @generated
     */
    public void actualizar(CotizacionItemDTO dto) {
        persistencia.actualizar(convertirDTO(dto));
    }

    /**
     * Convierte un CotizacionItemDTO en la entidad CotizacionItem.
     *
     * @param dto a convertir
     * @return entidad CotizacionItem
     * @generated
     */
    public CotizacionItem convertirDTO(CotizacionItemDTO dto) {
        if (dto == null) {
            return null;
        }
        CotizacionItem entidad = new CotizacionItem();
        entidad.setId(dto.getId());
        entidad.setCantidad(dto.getCantidad());
        entidad.setTotalManoObraViatico(dto.getTotalManoObraViatico());
        entidad.setTotalMaterialesViatico(dto.getTotalMaterialesViatico());
        entidad.setDescripcion(dto.getDescripcion());
        if (dto.getUnidad() != null) {
            entidad.setUnidad(new Unidad(dto.getUnidad().getId()));
        }
        if (dto.getCotizacionCapitulo() != null) {
            entidad.setCotizacionCapitulo(new CotizacionCapitulo());
            entidad.getCotizacionCapitulo().setId(dto.getCotizacionCapitulo().getId());
        }
        if (dto.getApu() != null) {
            entidad.setApu(new Apu());
            entidad.getApu().setId(dto.getApu().getId());
        }
        return entidad;
    }

    /**
     * Convierte una lista de CotizacionItemDTO en una lista de CotizacionItem.
     *
     * @param dtos a convertir
     * @return entidades List<CotizacionItem>
     * @generated
     */
    public List<CotizacionItem> convertirDTO(List<CotizacionItemDTO> dtos) {
        List<CotizacionItem> entidades = new ArrayList<CotizacionItem>();
        for (CotizacionItemDTO dto : dtos) {
            entidades.add(convertirDTO(dto));
        }
        return entidades;
    }

    /**
     * Convierte CotizacionItem en un DTO CotizacionItemDTO.
     *
     * @param entidad a convertir
     * @return dto CotizacionItemDTO
     * @generated
     */
    public CotizacionItemDTO convertirEntidad(CotizacionItem entidad) {
        CotizacionItemDTO dto = new CotizacionItemDTO();
        dto.setId(entidad.getId());
        dto.setCantidad(entidad.getCantidad());
        dto.setTotalManoObraViatico(entidad.getTotalManoObraViatico());
        dto.setTotalMaterialesViatico(entidad.getTotalMaterialesViatico());
        dto.setDescripcion(entidad.getDescripcion());
        if (entidad.getUnidad() != null) {
            dto.setUnidad(new UnidadDTO(entidad.getUnidad().getId(), entidad.getUnidad().getDescripcion()));
        }
        if (entidad.getCotizacionCapitulo() != null) {
            dto.setCotizacionCapitulo(
                    new CotizacionCapituloDTO(
                            entidad.getCotizacionCapitulo().getId()));
        }
        if (entidad.getApu() != null) {
            dto.setApu(new ApuDTO(entidad.getApu().getId()));
        }
        dto.setValorTotal(entidad.getTotalManoObraViatico() + entidad.getTotalMaterialesViatico());
        return dto;
    }

    /**
     * Convierte una lista de CotizacionItem en una lista de CotizacionItemDTO.
     *
     * @param entidades a convertir
     * @return dtos List<CotizacionItemDTO>
     * @generated
     */
    public List<CotizacionItemDTO> convertirEntidad(List<CotizacionItem> entidades) {
        List<CotizacionItemDTO> dtos = new ArrayList<CotizacionItemDTO>();
        for (CotizacionItem entidad : entidades) {
            dtos.add(convertirEntidad(entidad));
        }
        return dtos;
    }

    public List<CotizacionCapituloDTO> actualizarItemsCotizacion(ParametrosCotizacionDTO parametrosCotizacionDTO) {
        List<CotizacionCapituloDTO> capitulos = new ArrayList<>();
        if (parametrosCotizacionDTO.getCapitulos() != null
                && !parametrosCotizacionDTO.getCapitulos().isEmpty()) {
            Double porcentajeGastos = this.calculaProcentaje(parametrosCotizacionDTO.getGastosAdministrativos());
            porcentajeGastos = porcentajeGastos / 100;
            Double viaticos = viaticoLogica.valorViaticosDiasCiudad(parametrosCotizacionDTO.getCiudad().getId());
            HorarioTrabajoDTO horario = horarioTrabajoLogica.obtener(parametrosCotizacionDTO.getHorarioTrabajo().getId());
            for (CotizacionCapituloDTO capitulo : parametrosCotizacionDTO.getCapitulos()) {
                if (capitulo.getItems() != null && !capitulo.getItems().isEmpty()) {
                    for (CotizacionItemDTO cotizacionItemDTO : capitulo.getItems()) {
                        if (cotizacionItemDTO.getApu() != null) {
                            ApuDTO apu = apuLogica.obtener(cotizacionItemDTO.getApu().getId());
                            apu = apuLogica.calculaResumenesApu(apu);
                            apu.setPorcentajeGastosAdministrativos(porcentajeGastos);
                            apu.setValorViaticos((viaticos / 8) * apu.getCantidadHoras());
                            apu.setTotalMateriales(apu.getResumenMateriales() * (1 + porcentajeGastos));
                            apu.setTotalManoObra(((apu.getResumenManoObra() + apu.getResumenHerramientas())
                                    * (1 + porcentajeGastos)) * horario.getPorcentaje());
                            cotizacionItemDTO.setTotalMaterialesViatico((apu.getTotalMateriales() / (apu.getTotalMateriales() + apu.getTotalManoObra()) * apu.getValorViaticos()) + apu.getTotalMateriales());
                            cotizacionItemDTO.setTotalManoObraViatico((apu.getTotalManoObra() / (apu.getTotalMateriales() + apu.getTotalManoObra()) * apu.getValorViaticos()) + apu.getTotalManoObra());
                            cotizacionItemDTO.setValorTotal((cotizacionItemDTO.getTotalManoObraViatico() + cotizacionItemDTO.getTotalMaterialesViatico()) * cotizacionItemDTO.getCantidad());
                        }
                    }
                }
                capitulos.add(capitulo);
            }
        }
        return capitulos;
    }

    public Double calculaProcentaje(List<GastosAdministrativosDTO> gastos) {
        Double porcentaje = 0D;
        if (gastos != null && !gastos.isEmpty()) {
            for (GastosAdministrativosDTO gasto : gastos) {
                porcentaje += gasto.getPorcentaje();
            }
        }
        return porcentaje;
    }

}
