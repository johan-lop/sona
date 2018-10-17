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

    private List<GastosAdministrativosDTO> gastosAdministrativos;

    private List<CotizacionCapituloDTO> capitulos;

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

    public List<GastosAdministrativosDTO> getGastosAdministrativos() {
        return gastosAdministrativos;
    }

    public void setGastosAdministrativos(List<GastosAdministrativosDTO> gastosAdministrativos) {
        this.gastosAdministrativos = gastosAdministrativos;
    }

    public List<CotizacionCapituloDTO> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<CotizacionCapituloDTO> capitulos) {
        this.capitulos = capitulos;
    }

}
