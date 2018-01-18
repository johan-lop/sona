package co.com.johan.green.servicio;

import co.com.johan.green.dto.*;
import co.com.johan.green.logica.*;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 * @author Johan Lopez
 * @generated
 */
@Stateless
@Path("/SalariosRecargos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SalariosRecargosServicio {

    @EJB
    private SalariosRecargosLogica logica;

    /**
     * retorna una lista con los SalariosRecargos que se encuentran en la base
     * de datos
     *
     * @return retorna una lista de SalariosRecargosDTO
     * @generated
     */
    @GET
    public List<SalariosRecargosDTO> obtenerTodosSalariosRecargoss() {
        return logica.obtenerTodos();
    }

    /**
     * @param id identificador del elemento SalariosRecargos
     * @return SalariosRecargos del id dado
     * @generated
     */
    @GET
    @Path("/{id}")
    public SalariosRecargosDTO obtenerSalariosRecargos(@PathParam("id") Long id) {
        return logica.obtener(id);
    }
    
    @GET
    @Path("/Cargo/{id}")
    public List<SalariosRecargosDTO> obtenerSalariosRecargosPorCargo(@PathParam("id") Long id) {
        return logica.obtenerPorCargo(id);
    }

    /**
     * almacena la informacion de SalariosRecargos
     *
     * @param dto SalariosRecargos a guardar
     * @return SalariosRecargos con los cambios realizados por el proceso de
     * guardar
     * @generated
     */
    @POST
    public SalariosRecargosDTO guardarSalariosRecargos(SalariosRecargosDTO dto) {
        if (dto.getId() != null) {
            logica.actualizar(dto);
            return dto;
        } else {
            return logica.guardar(dto);
        }
    }

    /**
     * elimina el registro SalariosRecargos con el identificador dado
     *
     * @param id identificador del SalariosRecargos
     * @generated
     */
    @DELETE
    @Path("/{id}")
    public void borrarSalariosRecargos(@PathParam("id") Long id) {
        logica.borrar(id);
    }

}
