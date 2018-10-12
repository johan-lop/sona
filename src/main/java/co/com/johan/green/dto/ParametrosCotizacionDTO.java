package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * @generated @author Johan Lopez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParametrosCotizacionDTO {

    private CiudadDTO ciudad;
    
    private HorarioTrabajoDTO horarioTrabajo;
    
    private GastosAdministrativosDTO gastosAdministrativos;
    
    private List<CotizacionItemDTO> itemsCotizacion;

    public CiudadDTO getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadDTO ciudad) {
        this.ciudad = ciudad;
    }

    public HorarioTrabajoDTO getHorarioTrabajo() {
        return horarioTrabajo;
    }

    public void setHorarioTrabajo(HorarioTrabajoDTO horarioTrabajo) {
        this.horarioTrabajo = horarioTrabajo;
    }

    public GastosAdministrativosDTO getGastosAdministrativos() {
        return gastosAdministrativos;
    }

    public void setGastosAdministrativos(GastosAdministrativosDTO gastosAdministrativos) {
        this.gastosAdministrativos = gastosAdministrativos;
    }

    public List<CotizacionItemDTO> getItemsCotizacion() {
        return itemsCotizacion;
    }

    public void setItemsCotizacion(List<CotizacionItemDTO> itemsCotizacion) {
        this.itemsCotizacion = itemsCotizacion;
    }
    
    
    
}
