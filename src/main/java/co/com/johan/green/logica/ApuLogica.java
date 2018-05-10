package co.com.johan.green.logica;

import co.com.johan.green.dto.*;
import co.com.johan.green.exception.ApplicationException;
import co.com.johan.green.persistencia.*;
import co.com.johan.green.persistencia.entity.*;
import co.com.johan.green.utils.Constantes;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.time.*;
import java.time.format.DateTimeFormatter;
import javax.inject.Inject;

/**
 * @generated @author Johan Lopez
 */
@Stateless
public class ApuLogica {

    @EJB
    private ApuDAO persistencia;

    @EJB
    private ApuItemLogica apuItemLogica;

    @EJB
    private ApuItemDAO apuItemDAO;

    @EJB
    private SalariosRecargosLogica salariosRecargosLogica;

    @Inject
    private InfoUsuario infoUsuario;

    private final DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    /**
     * Retorna una lista con los Apu que se encuentran en la base de datos
     *
     * @return retorna una lista de ApuDTO
     * @generated
     */
    public List<ApuDTO> obtenerTodos() {
        return procesarItemsApu(convertirEntidad(persistencia.obtenerTodos()));
    }
    
    public List<ApuDTO> obtenerPorDescripcion(String descripcion) {
        return procesarItemsApu(convertirEntidad(persistencia.obtenerPorDescripcion(descripcion)));
    }
    
    public List<ApuDTO> obtenerPorDescripcionMaterial(String descripcion) {
        return procesarItemsApu(convertirEntidad(apuItemDAO.obtenerPorDescripcionMaterial(descripcion)));
    }
    
    public List<ApuDTO> procesarItemsApu(List<ApuDTO> apusDTO) {
        if (!apusDTO.isEmpty()) {
            for (ApuDTO apu : apusDTO) {
                apu.setItems(apuItemLogica.obtenerPorApu(apu.getId()));
                apu.setValorTotal(this.valorTotalApu(apu.getItems()));
            }
        }
        return apusDTO;
    }

    private Double valorTotalApu(List<ApuItemDTO> items) {
        Double valorTotal = 0D;
        if (items != null && !items.isEmpty()) {
            for (ApuItemDTO item : items) {
                if (item.getMaterial() != null) {
                    valorTotal += item.getMaterial().getPrecio() * item.getCantidad();
                }
                if (item.getHerramienta() != null) {
                    valorTotal += Math.ceil(((item.getHerramienta().getValor() * item.getHerramienta().getPorcentaje()) / 100)) * item.getCantidad();
                }
                if (item.getCargo() != null) {
                    Double valorTotalCargo = 0D;
                    List<SalariosRecargosDTO> salarios = salariosRecargosLogica.obtenerPorCargo(item.getCargo().getId());
                    if (!salarios.isEmpty()) {
                        for (SalariosRecargosDTO salario : salarios) {
                            if (salario.getActivo()) {
                                valorTotalCargo += (salario.getValor() * salario.getCantidad()) / 100;
                            }
                        }
                    }
                    valorTotal += Math.ceil(((valorTotalCargo / 30) / 8 /60) * item.getCantidad());
                }
            }
        }
        return valorTotal;
    }

    /**
     * Obtiene Apu dado su identificador.
     *
     * @param id identificador del elemento Apu
     * @return Apu del id dado
     * @generated
     */
    public ApuDTO obtener(Long id) {
        ApuDTO apu = convertirEntidad(persistencia.obtener(id));
        apu.setItems(apuItemLogica.obtenerPorApu(apu.getId()));
        return apu;
    }

    /**
     * Almacena la informacion de Apu
     *
     * @param dto Apu a guardar
     * @return Apu con los cambios realizados por el proceso de guardar
     * @generated
     */
    public ApuDTO guardar(ApuDTO dto) {
        List<ApuDTO> apus = this.obtenerPorDescripcion(dto.getDescripcion());
        if (!apus.isEmpty()) {
            throw new ApplicationException("La APU " + dto.getDescripcion() + " ya se encuentra parametrizada.");
        }
        dto.setActivo(Boolean.TRUE);
        dto.setEstadoApu(new EstadoApuDTO(Constantes.EstadoApu.PENDIENTE));
        dto.setUsuarioDTO(infoUsuario.getUsuario());
        ApuDTO apu = convertirEntidad(persistencia.guardar(convertirDTO(dto)));
        if (dto.getItems() != null && !dto.getItems().isEmpty()) {
            for (ApuItemDTO apuItem : dto.getItems()) {
                apuItem.setApu(apu);
                apuItemLogica.guardar(apuItem);
            }
        }
        return apu;
    }

    /**
     * Elimina el registro Apu con el identificador dado
     *
     * @param id identificador del Apu
     * @generated
     */
    public void borrar(Long id) {
        persistencia.borrar(id);
    }

    /**
     * Actualiza la informacion de Apu
     *
     * @param dto Apu a guardar
     * @generated
     */
    public void actualizar(ApuDTO dto) {
        List<ApuDTO> apus = this.obtenerPorDescripcion(dto.getDescripcion());
        if (!apus.isEmpty() && !apus.get(0).getId().equals(dto.getId())) {
            throw new ApplicationException("La APU " + dto.getDescripcion() + " ya se encuentra parametrizada.");
        }
        if (dto.getRevisada() !=  null && dto.getRevisada()) {
            dto.setEstadoApu(new EstadoApuDTO(Constantes.EstadoApu.REVISADA));
            dto.setActivo(Boolean.TRUE);
        }
        persistencia.actualizar(convertirDTO(dto));
        apuItemDAO.borrarPorApu(dto.getId());
        if (dto.getItems() != null && !dto.getItems().isEmpty()) {
            for (ApuItemDTO apuItem : dto.getItems()) {
                apuItem.setApu(dto);
                apuItemLogica.guardar(apuItem);
            }
        }
    }

    /**
     * Convierte un ApuDTO en la entidad Apu.
     *
     * @param dto a convertir
     * @return entidad Apu
     * @generated
     */
    public Apu convertirDTO(ApuDTO dto) {
        if (dto == null) {
            return null;
        }
        Apu entidad = new Apu();
        entidad.setId(dto.getId());
        entidad.setDescripcion(dto.getDescripcion());
        entidad.setActivo(dto.getActivo());
        if (dto.getFechaCreacion() != null) {
            entidad.setFechaCreacion(LocalDateTime.parse(dto.getFechaCreacion(), formatoFechaHora));
        }
        if (dto.getFechaModificacion() != null) {
            entidad.setFechaModificacion(LocalDateTime.parse(dto.getFechaModificacion(), formatoFechaHora));
        }
        if (dto.getEstadoApu() != null) {
            entidad.setEstadoApu(new EstadoApu(dto.getEstadoApu().getId()));
        }
        if (dto.getUnidad()!= null) {
            entidad.setUnidad(new Unidad(dto.getUnidad().getId()));
        }
        if (dto.getUsuarioDTO() != null) {
            entidad.setUsuario(new Usuario());
            entidad.getUsuario().setId(dto.getUsuarioDTO().getId());
        }
        return entidad;
    }

    /**
     * Convierte una lista de ApuDTO en una lista de Apu.
     *
     * @param dtos a convertir
     * @return entidades List<Apu>
     * @generated
     */
    public List<Apu> convertirDTO(List<ApuDTO> dtos) {
        List<Apu> entidades = new ArrayList<Apu>();
        for (ApuDTO dto : dtos) {
            entidades.add(convertirDTO(dto));
        }
        return entidades;
    }

    /**
     * Convierte Apu en un DTO ApuDTO.
     *
     * @param entidad a convertir
     * @return dto ApuDTO
     * @generated
     */
    public ApuDTO convertirEntidad(Apu entidad) {
        ApuDTO dto = new ApuDTO();
        dto.setId(entidad.getId());
        dto.setDescripcion(entidad.getDescripcion());
        dto.setActivo(entidad.getActivo());
        if (entidad.getFechaCreacion() != null) {
            dto.setFechaCreacion(formatoFechaHora.format(entidad.getFechaCreacion()));
        }
        if (entidad.getFechaModificacion() != null) {
            dto.setFechaModificacion(formatoFechaHora.format(entidad.getFechaModificacion()));
        }
        if (entidad.getEstadoApu() != null) {
            dto.setEstadoApu(new EstadoApuDTO(entidad.getEstadoApu().getId()));
            dto.getEstadoApu().setDescripcion(entidad.getEstadoApu().getDescripcion());
            if (entidad.getEstadoApu().getId().equals(Constantes.EstadoApu.REVISADA)) {
                dto.setRevisada(Boolean.TRUE);
            }
        }
        if (entidad.getUnidad()!= null) {
            dto.setUnidad(new UnidadDTO(entidad.getUnidad().getId()));
            dto.getUnidad().setDescripcion(entidad.getUnidad().getDescripcion());
        }
        if (entidad.getUsuario() != null) {
            dto.setUsuarioDTO(new UsuarioDTO(entidad.getUsuario().getId()));
            dto.getUsuarioDTO().setNombres(entidad.getUsuario().getNombres());
            dto.getUsuarioDTO().setApellidos(entidad.getUsuario().getApellidos());
        }
        return dto;
    }

    /**
     * Convierte una lista de Apu en una lista de ApuDTO.
     *
     * @param entidades a convertir
     * @return dtos List<ApuDTO>
     * @generated
     */
    public List<ApuDTO> convertirEntidad(List<Apu> entidades) {
        List<ApuDTO> dtos = new ArrayList<ApuDTO>();
        for (Apu entidad : entidades) {
            dtos.add(convertirEntidad(entidad));
        }
        return dtos;
    }

}
