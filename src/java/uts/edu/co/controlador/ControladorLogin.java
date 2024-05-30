/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package uts.edu.co.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.edu.co.ejb.UsuariosFacade;
import uts.edu.co.entidades.Usuarios;

/**
 *
 * @author josue
 */
public class ControladorLogin extends HttpServlet {

    @EJB
    private UsuariosFacade usuariosFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        String correo = request.getParameter("correo");
        String password = request.getParameter("password"); 
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proyecto3PU");
        EntityManager em = emf.createEntityManager();
        
        try{
            if("logout".equals(accion)){
                HttpSession session = request.getSession(false);
                if(session != null){
                    session.invalidate();
                }
                response.sendRedirect("Login.jsp");
                return;
            }
            
            Usuarios usuarios = usuariosFacade.findByCorreo(correo);
            
            if(usuarios != null && usuarios.getContraseña().equals(password)){
                HttpSession session = request.getSession();
                session.setAttribute("username", usuarios.getUsuario());
                response.sendRedirect("index.html");
            }
            else{
                response.sendRedirect("Login.jsp?error=true");
            }
        } finally {
            em.close();
            emf.close();
        }
        
        if("logout".equals(accion)){
            HttpSession session = request.getSession(false);
            if(session != null){
                session.invalidate();
            }
            response.sendRedirect("Login.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
