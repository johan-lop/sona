/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.johan.servlet;

import co.com.johan.sona.dto.UsuarioDTO;
import co.com.johan.sona.logica.UsuarioLogica;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class AutenticacionServlet extends HttpServlet {

    @EJB
    private UsuarioLogica usuarioLogica;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("usuario");
        String password = request.getParameter("password");
        String ip = this.getIp(request);

        UsuarioDTO usuario = usuarioLogica.obtenerPorUsuarioPasword(login, password);

        //cuando esta bien el usuario
        if (usuario != null) {
            //autenticado 

            request.getSession().setAttribute("usuario", login);
            request.getSession().setAttribute("nombreUsuario", login);
            request.getSession().setAttribute("menu", "");
            response.setStatus(200);
            response.sendRedirect("/Sona/");
        } else {
            //no autenticado
            response.sendRedirect("/Sona/login.html?error=402");
        }
    }

    private String getIp(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        return (remoteAddr == null ? "" : remoteAddr) + ";" + (ipAddress == null ? "" : ipAddress);
    }

}
