/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.johan.servlet;

import co.com.johan.sona.dto.UsuarioDTO;
import co.com.johan.sona.logica.UsuarioLogica;
import co.com.johan.utils.VerifyRecaptcha;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daniel
 */
@WebServlet(name = "NuevoUsuarioServlet", urlPatterns = {"/nuevoUsuario"})
public class NuevoUsuarioServlet extends HttpServlet {

    @EJB
    private UsuarioLogica usuarioLogica;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gRecaptchaResponse = request
                .getParameter("g-recaptcha-response");
        System.out.println(gRecaptchaResponse);
        boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
        if (verify) {
            response.sendRedirect("/Sona/login");
        } else {
            response.sendRedirect("/Sona/nuevoUsuario.html?error=102");
        }
        
    }

    private String getIp(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        return (remoteAddr == null ? "" : remoteAddr) + ";" + (ipAddress == null ? "" : ipAddress);
    }

}
