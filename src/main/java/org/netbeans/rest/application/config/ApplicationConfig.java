
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;
import co.com.johan.sona.servicio.*;

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
        resources.add(co.com.johan.sona.servicio.MenuRolServicio.class);
resources.add(co.com.johan.sona.servicio.MenuServicio.class);
resources.add(co.com.johan.sona.servicio.RolServicio.class);
resources.add(co.com.johan.sona.servicio.UsuarioRolServicio.class);
resources.add(co.com.johan.sona.servicio.UsuarioServicio.class);
    }
    
}

