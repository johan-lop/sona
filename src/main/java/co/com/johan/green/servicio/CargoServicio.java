package co.com.johan.green.servicio;

import co.com.johan.green.dto.*;
import co.com.johan.green.logica.*;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 * @author Johan Lopez
 * @generated
 */
@Stateless
@Path("/Cargo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CargoServicio {

    @EJB
    private CargoLogica logica;

    /**
     * retorna una lista con los Cargo que se encuentran en la base de datos
     *
     * @return retorna una lista de CargoDTO
     * @generated
     */
    @GET
    public List<CargoDTO> obtenerTodosCargos() {
        return logica.obtenerTodos();
    }
    
    @GET
    @Path("/Valor")
    public List<CargoDTO> obtenerTodosCargosValor() {
        return logica.obtenerTodosValor();
    }

    /**
     * @param id identificador del elemento Cargo
     * @return Cargo del id dado
     * @generated
     */
    @GET
    @Path("/{id}")
    public CargoDTO obtenerCargo(@PathParam("id") Long id) {
        return logica.obtener(id);
    }

    /**
     * almacena la informacion de Cargo
     *
     * @param dto Cargo a guardar
     * @return Cargo con los cambios realizados por el proceso de guardar
     * @generated
     */
    @POST
    public CargoDTO guardarCargo(CargoDTO dto) {
        if (dto.getId() != null) {
            logica.actualizar(dto);
            return dto;
        } else {
            return logica.guardar(dto);
        }
    }

    /**
     * elimina el registro Cargo con el identificador dado
     *
     * @param id identificador del Cargo
     * @generated
     */
    @DELETE
    @Path("/{id}")
    public void borrarCargo(@PathParam("id") Long id) {
        logica.borrar(id);
    }

}
