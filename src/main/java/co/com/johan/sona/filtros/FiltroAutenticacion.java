/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.johan.sona.filtros;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequestWrapper;
import org.apache.commons.io.IOUtils;


/**
 *
 * @author daniel
 */
@WebFilter(filterName = "FiltroAutenticacion", urlPatterns = {"*.html", "/partials/*", "/js/*", "/webresources/*"})
public class FiltroAutenticacion implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //inicio del filtro
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;

            if (validarPath(req.getRequestURI())) {
                chain.doFilter(request, response);
                return;
            }
            
            String path = ((HttpServletRequest) request).getRequestURI();
            
            String nombreUsuario = (String) req.getSession().getAttribute("nombreUsuario");

            if (nombreUsuario == null && !path.contains("nuevoUsuario")) {
                if(req.getRequestURI().contains("webresources")){
                    resp.setStatus(403);
//                    resp.sendRedirect("/Contravencional/login.html?error=401");
                }else{
                    //enviar al login
                    resp.sendRedirect("/Sona/login.html");
                }
                return;
            }

            chain.doFilter(req, response);

            if (req.getHeader("aplicacion") != null) {
                req.getSession().invalidate();
            }
        } catch (Exception ex) {
            response.setContentType("application/json;charset=UTF-8");
            ((HttpServletResponse) response).setStatus(500);
            try (PrintWriter out = response.getWriter()) {
                out.append("{\"mensaje\": Error al autenticar \"\"}");
            }
        } 
    }

    @Override
    public void destroy() {
        //destruccion del filtro
    }

    private boolean validarPath(String requestURI) {
        return requestURI.contains("login") || requestURI.contains("js/lib");
    }

    
    public class MultiReadHttpServletRequest extends HttpServletRequestWrapper {

        private ByteArrayOutputStream cachedBytes;

        public MultiReadHttpServletRequest(HttpServletRequest request) {
            super(request);
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            if (cachedBytes == null) {
                cacheInputStream();
            }

            return new CachedServletInputStream();
        }

        @Override
        public BufferedReader getReader() throws IOException {
            return new BufferedReader(new InputStreamReader(getInputStream()));
        }

        private void cacheInputStream() throws IOException {
            /* Cache the inputstream in order to read it multiple times. For
     * convenience, I use apache.commons IOUtils
             */
            cachedBytes = new ByteArrayOutputStream();
            IOUtils.copy(super.getInputStream(), cachedBytes);
        }

        /* An inputstream which reads the cached request body */
        public class CachedServletInputStream extends ServletInputStream {

            private ByteArrayInputStream input;

            public CachedServletInputStream() {
                /* create a new input stream from the cached request body */
                input = new ByteArrayInputStream(cachedBytes.toByteArray());
            }

            @Override
            public int read() throws IOException {
                return input.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }
        }
    }
}
