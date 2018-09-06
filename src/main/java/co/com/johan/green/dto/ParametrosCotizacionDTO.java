package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.ArrayList;

/**
 * @generated @author Johan Lopez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParametrosCotizacionDTO {

    private CiudadDTO ciudad;
    
    private HorarioTrabajoDTO horarioTrabajo;

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
    
    
}
