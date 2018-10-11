
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * Esta clase registra la informacion de las clases que van a ser utilizadas como servicios REST
 * @author Johan Lopez
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(co.com.johan.green.servicio.ApuItemServicio.class);
        resources.add(co.com.johan.green.servicio.ApuServicio.class);
        resources.add(co.com.johan.green.servicio.CargoServicio.class);
        resources.add(co.com.johan.green.servicio.CiudadServicio.class);
        resources.add(co.com.johan.green.servicio.ClienteServicio.class);
        resources.add(co.com.johan.green.servicio.ContactoServicio.class);
        resources.add(co.com.johan.green.servicio.CotizacionCapituloServicio.class);
        resources.add(co.com.johan.green.servicio.CotizacionGastosAdministrativosServicio.class);
        resources.add(co.com.johan.green.servicio.CotizacionItemServicio.class);
        resources.add(co.com.johan.green.servicio.CotizacionServicio.class);
        resources.add(co.com.johan.green.servicio.DepartamentoServicio.class);
        resources.add(co.com.johan.green.servicio.EmpresaServicio.class);
        resources.add(co.com.johan.green.servicio.EstadoApuServicio.class);
        resources.add(co.com.johan.green.servicio.GastosAdministrativosServicio.class);
        resources.add(co.com.johan.green.servicio.HerramientaServicio.class);
        resources.add(co.com.johan.green.servicio.HorarioTrabajoServicio.class);
        resources.add(co.com.johan.green.servicio.ImpuestoServicio.class);
        resources.add(co.com.johan.green.servicio.MaterialServicio.class);
        resources.add(co.com.johan.green.servicio.MenuServicio.class);
        resources.add(co.com.johan.green.servicio.RolServicio.class);
        resources.add(co.com.johan.green.servicio.SalariosRecargosServicio.class);
        resources.add(co.com.johan.green.servicio.TipoDocumentoServicio.class);
        resources.add(co.com.johan.green.servicio.UnidadServicio.class);
        resources.add(co.com.johan.green.servicio.UsuarioServicio.class);
        resources.add(co.com.johan.green.servicio.ViaticoServicio.class);
    }
    
}

