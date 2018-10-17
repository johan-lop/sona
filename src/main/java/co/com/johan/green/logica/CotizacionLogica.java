package co.com.johan.green.logica;

import co.com.johan.green.dto.*;
import co.com.johan.green.persistencia.*;
import co.com.johan.green.persistencia.entity.*;
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
public class CotizacionLogica {

    @EJB
    private CotizacionDAO persistencia;

    @EJB
    private CotizacionCapituloDAO cotizacionCapituloDAO;

    @EJB
    private CotizacionItemDAO cotizacionItemDAO;

    @EJB
    private CotizacionCapituloLogica cotizacionCapituloLogica;

    @EJB
    private CotizacionGastosAdministrativosDAO cotizacionGastosAdministrativosDAO;

    @EJB
    private CotizacionGastosAdministrativosLogica cotizacionGastosAdministrativosLogica;

    @EJB
    private CotizacionImpuestoLogica cotizacionImpuestoLogica;

    @EJB
    private CotizacionImpuestoDAO cotizacionImpuestoDAO;

    @Inject
    private InfoUsuario infoUsuario;

    private final DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    /**
     * Retorna una lista con los Cotizacion que se encuentran en la base de
     * datos
     *
     * @return retorna una lista de CotizacionDTO
     * @generated
     */
    public List<CotizacionDTO> obtenerTodos() {
        return convertirEntidad(persistencia.obtenerTodos());
    }

    /**
     * Obtiene Cotizacion dado su identificador.
     *
     * @param id identificador del elemento Cotizacion
     * @return Cotizacion del id dado
     * @generated
     */
    public CotizacionDTO obtener(Long id) {
        return convertirEntidad(persistencia.obtener(id));
    }

    /**
     * Almacena la informacion de Cotizacion
     *
     * @param dto Cotizacion a guardar
     * @return Cotizacion con los cambios realizados por el proceso de guardar
     * @generated
     */
    public CotizacionDTO guardar(CotizacionDTO dto) {
        if (dto.getId() != null) {
            persistencia.actualizar(convertirDTO(dto));
        } else {
            dto.setVersion(1);
            dto.setUsuario(infoUsuario.getUsuario().getNombreUsuario());
            CotizacionDTO nuevoDto = convertirEntidad(persistencia.guardar(convertirDTO(dto)));
            dto.setId(nuevoDto.getId());
        }
        if (dto.getCapitulos() != null && !dto.getCapitulos().isEmpty()) {
            for (CotizacionCapituloDTO capitulo : dto.getCapitulos()) {
                if (capitulo.getId() != null) {
                    cotizacionItemDAO.borrarPorCapitulo(capitulo.getId());
                    cotizacionCapituloDAO.borrar(capitulo.getId());
                }
                CotizacionCapitulo cap = new CotizacionCapitulo();
                cap.setCotizacion(new Cotizacion(dto.getId()));
                cap.setDescripcion(capitulo.getDescripcion());
                cap = cotizacionCapituloDAO.guardar(cap);
                if (capitulo.getItems() != null && !capitulo.getItems().isEmpty()) {
                    for (CotizacionItemDTO item : capitulo.getItems()) {
                        CotizacionItem itemCap = new CotizacionItem();
                        itemCap.setCotizacionCapitulo(cap);
                        itemCap.setCantidad(item.getCantidad());
                        itemCap.setTotalManoObraViatico(item.getTotalManoObraViatico());
                        itemCap.setTotalMaterialesViatico(item.getTotalMaterialesViatico());
                        if (item.getUnidad() != null) {
                            itemCap.setUnidad(new Unidad(item.getUnidad().getId()));
                        }
                        itemCap.setDescripcion(item.getDescripcion());
                        if (item.getApu() != null) {
                            itemCap.setApu(new Apu(item.getApu().getId()));
                        }
                        cotizacionItemDAO.guardar(itemCap);
                    }
                }
            }
        }
        if (dto.getGastosAdministrativos() != null && !dto.getGastosAdministrativos().isEmpty()) {
            cotizacionGastosAdministrativosDAO.borrarPorCotizacion(dto.getId());
            for (CotizacionGastosAdministrativosDTO gasto : dto.getGastosAdministrativos()) {
                CotizacionGastosAdministrativos cotizacionGastosAdministrativos = new CotizacionGastosAdministrativos();
                cotizacionGastosAdministrativos.setCotizacion(new Cotizacion(dto.getId()));
                cotizacionGastosAdministrativos.setDescripcion(gasto.getDescripcion());
                cotizacionGastosAdministrativos.setValor(gasto.getPorcentaje());
                cotizacionGastosAdministrativosDAO.guardar(cotizacionGastosAdministrativos);
            }
        }
        if (dto.getImpuestos() != null && !dto.getImpuestos().isEmpty()) {
            cotizacionImpuestoDAO.borrarPorCotizacion(dto.getId());
            for (CotizacionImpuestoDTO impuesto : dto.getImpuestos()) {
                CotizacionImpuesto cotizacionImpuesto = new CotizacionImpuesto();
                cotizacionImpuesto.setCotizacion(new Cotizacion(dto.getId()));
                cotizacionImpuesto.setDescripcion(impuesto.getDescripcion());
                cotizacionImpuesto.setPorcentaje(impuesto.getPorcentaje());
                cotizacionImpuesto.setPorcentajeAdicional(impuesto.getPorcentajeAdicional());
                cotizacionImpuestoDAO.guardar(cotizacionImpuesto);
            }
        }
        return dto;
    }

    /**
     * Elimina el registro Cotizacion con el identificador dado
     *
     * @param id identificador del Cotizacion
     * @generated
     */
    public void borrar(Long id) {
        persistencia.borrar(id);
    }

    /**
     * Actualiza la informacion de Cotizacion
     *
     * @param dto Cotizacion a guardar
     * @generated
     */
    public void actualizar(CotizacionDTO dto) {
        persistencia.actualizar(convertirDTO(dto));
    }

    /**
     * Convierte un CotizacionDTO en la entidad Cotizacion.
     *
     * @param dto a convertir
     * @return entidad Cotizacion
     * @generated
     */
    public Cotizacion convertirDTO(CotizacionDTO dto) {
        if (dto == null) {
            return null;
        }
        Cotizacion entidad = new Cotizacion();
        entidad.setId(dto.getId());
        entidad.setCodigo(dto.getCodigo());
        entidad.setProyecto(dto.getProyecto());
        entidad.setVersion(dto.getVersion());
        entidad.setObservaciones(dto.getObservaciones());
        entidad.setValidez(dto.getValidez());
        entidad.setGarantia(dto.getGarantia());
        entidad.setTiempoEntrega(dto.getTiempoEntrega());
        entidad.setFormaPago(dto.getFormaPago());
        entidad.setUsuario(dto.getUsuario());
        if (dto.getFechaRegistro() != null) {
            entidad.setFechaRegistro(LocalDateTime.parse(dto.getFechaRegistro(), formatoFechaHora));
        }

        if (dto.getCliente() != null) {
            entidad.setCliente(new Cliente());
            entidad.getCliente().setId(dto.getCliente().getId());
        }
        if (dto.getCiudad() != null) {
            entidad.setCiudad(new Ciudad());
            entidad.getCiudad().setId(dto.getCiudad().getId());
        }
        if (dto.getContacto() != null) {
            entidad.setContacto(new Contacto());
            entidad.getContacto().setId(dto.getContacto().getId());
        }
        if (dto.getHorarioTrabajo() != null) {
            entidad.setHorarioTrabajo(new HorarioTrabajo());
            entidad.getHorarioTrabajo().setId(dto.getHorarioTrabajo().getId());
        }
        entidad.setTipoImpuesto(dto.getTipoImpuesto());
        return entidad;
    }

    /**
     * Convierte una lista de CotizacionDTO en una lista de Cotizacion.
     *
     * @param dtos a convertir
     * @return entidades List<Cotizacion>
     * @generated
     */
    public List<Cotizacion> convertirDTO(List<CotizacionDTO> dtos) {
        List<Cotizacion> entidades = new ArrayList<Cotizacion>();
        for (CotizacionDTO dto : dtos) {
            entidades.add(convertirDTO(dto));
        }
        return entidades;
    }

    /**
     * Convierte Cotizacion en un DTO CotizacionDTO.
     *
     * @param entidad a convertir
     * @return dto CotizacionDTO
     * @generated
     */
    public CotizacionDTO convertirEntidad(Cotizacion entidad) {
        CotizacionDTO dto = new CotizacionDTO();
        dto.setId(entidad.getId());
        dto.setCodigo(entidad.getCodigo());
        dto.setProyecto(entidad.getProyecto());
        dto.setVersion(entidad.getVersion());
        dto.setObservaciones(entidad.getObservaciones());
        dto.setValidez(entidad.getValidez());
        dto.setGarantia(entidad.getGarantia());
        dto.setTiempoEntrega(entidad.getTiempoEntrega());
        dto.setFormaPago(entidad.getFormaPago());
        dto.setUsuario(entidad.getUsuario());
        if (entidad.getFechaRegistro() != null) {
            dto.setFechaRegistro(formatoFechaHora.format(entidad.getFechaRegistro()));
        }

        if (entidad.getHorarioTrabajo() != null) {
            dto.setHorarioTrabajo(new HorarioTrabajoDTO(entidad.getHorarioTrabajo().getId()));
            dto.getHorarioTrabajo().setDescripcion(entidad.getHorarioTrabajo().getDescripcion());
        }
        if (entidad.getContacto() != null) {
            dto.setContacto(new ContactoDTO(entidad.getContacto().getId()));
            dto.getContacto().setNombres(entidad.getContacto().getNombres());
            dto.getContacto().setCorreo(entidad.getContacto().getCorreo());
            dto.getContacto().setCelular(entidad.getContacto().getCelular());
        }
        if (entidad.getCiudad() != null) {
            dto.setCiudad(new CiudadDTO(entidad.getCiudad().getId()));
            dto.getCiudad().setNombre(entidad.getCiudad().getNombre());
        }
        if (entidad.getCliente() != null) {
            dto.setCliente(new ClienteDTO(entidad.getCliente().getId()));
            dto.getCliente().setNombre(entidad.getCliente().getNombre());
            dto.getCliente().setDireccion(entidad.getCliente().getDireccion());
            dto.getCliente().setTelefono(entidad.getCliente().getTelefono());
        }
        dto.setCapitulos(cotizacionCapituloLogica.obtenerPorCotizacion(dto.getId()));
        dto.setGastosAdministrativos(cotizacionGastosAdministrativosLogica.obtenerPorCotizacion(dto.getId()));
        dto.setImpuestos(cotizacionImpuestoLogica.obtenerPorCotizacion(dto.getId()));
        dto.setTipoImpuesto(entidad.getTipoImpuesto());
        return dto;
    }

    /**
     * Convierte una lista de Cotizacion en una lista de CotizacionDTO.
     *
     * @param entidades a convertir
     * @return dtos List<CotizacionDTO>
     * @generated
     */
    public List<CotizacionDTO> convertirEntidad(List<Cotizacion> entidades) {
        List<CotizacionDTO> dtos = new ArrayList<CotizacionDTO>();
        for (Cotizacion entidad : entidades) {
            dtos.add(convertirEntidad(entidad));
        }
        return dtos;
    }

}
