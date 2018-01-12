package co.com.johan.green.filtros;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.exception.ExceptionUtils;

/**
 * Este filtro procesa las excepciones que se arrojan hacia arriba y generan un mecanismo estandar de salida de la excepci&oacute;n
 * @generated
 * @author Johan Lopez
 */
@WebFilter(filterName = "FiltroExcepciones", urlPatterns = {"/webresources/*"})
public class FiltroExcepciones implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //no realiza ninguna accion
    }

    /**
      * procesa las excepciones y las arroja hacia la capa superior
      */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            response.setContentType("application/json;charset=UTF-8");
            ((HttpServletResponse) response).setStatus(500);
            try (PrintWriter out = response.getWriter()) {
                out.append("{\"mensaje\":\""+procesarTexto(obtenerUltimaExcepcion(e).getMessage())+"\"}");
            }
        }
    }

    @Override
    public void destroy() {
        //no realiza ninguna accion
    }

    /**
      * convierte los saltos de linea y tabuladores para que se interprete en el javascript
      */
    public static String procesarTexto(String texto){
        if (texto == null) return "";
        return texto.replaceAll("\n", "\\\\n")
                .replaceAll("\t", "\\\\t");
    }

    /**
      * Metodo recursivo que obtiene la excepcion original
      */
    public static Throwable obtenerUltimaExcepcion(Throwable e){
        if(e.getCause()!=null){
            return obtenerUltimaExcepcion(e.getCause());
        }else{
            return e;
        }
    }
    
}
