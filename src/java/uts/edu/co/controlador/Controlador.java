/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package uts.edu.co.controlador;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uts.edu.co.ejb.ClientesFacade;
import uts.edu.co.ejb.ServicioFacade;
import uts.edu.co.entidades.Clientes;
import uts.edu.co.entidades.Servicio;

/**
 *
 * @author josue
 */
public class Controlador extends HttpServlet {

    @EJB 
    private ClientesFacade clientesFacade;
    @EJB
    private ServicioFacade servicioFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cedula ="";
        String nombre =request.getParameter("nombre");
        String direccion =request.getParameter("direccion");
        String _telefono =request.getParameter("telefono");
        String _idServicio =request.getParameter("servicio");
        String _mora = request.getParameter("mora");
        int telefono =0;
        int idServicio =0;
        int mora = 0;
        String action ="";
        Clientes cliente = new Clientes();
        Servicio servicio = new Servicio();
        
        if(request.getParameter("cedula")!= null){
            cedula = request.getParameter("cedula");
        }
        
        if(_telefono != null && !_telefono.isEmpty()){
            telefono = Integer.parseInt(_telefono);
        }
        
        if(_idServicio!= null && !_idServicio.isEmpty()){
            idServicio = Integer.parseInt(_idServicio);
        }
        
        if(_mora != null && !_mora.isEmpty()){
            mora = Integer.parseInt(_mora);
        }
        
        if(request.getParameter("action") != null){
            action = request.getParameter("action");
            switch (action){
                case "borrar":
                    clientesFacade.borrarCliente(cedula);
                    break;
                case "seleccionar":
                    cliente=clientesFacade.buscarCliente(cedula);
                    servicio = cliente.getTipoServicio();
                    break;
                case "editar":
                    cliente.setCedula(cedula);
                    cliente.setNombre(nombre);
                    cliente.setTelefono(telefono);
                    cliente.setDireccion(direccion);
                    servicio = servicioFacade.buscarServicio(idServicio);
                    cliente.setTipoServicio(servicio);
                    cliente.setMesesMora(mora);
                    clientesFacade.edit(cliente);
                    break;
                case "limpiar":
                    cedula = "";
                    nombre = "";
                    telefono = 0;
                    direccion = "";
                    idServicio = 0;
                    mora = 0;
                    servicio = servicioFacade.buscarServicio(idServicio);
                    cliente.setCedula(cedula);
                    cliente.setNombre(nombre);
                    cliente.setTelefono(telefono);
                    cliente.setDireccion(direccion);
                    cliente.setTipoServicio(servicio);
                    cliente.setMesesMora(mora);
                    break;
                case "agregar":
                    cliente.setCedula(cedula);
                    cliente.setNombre(nombre);
                    cliente.setTelefono(telefono);
                    cliente.setDireccion(direccion);
                    servicio = servicioFacade.buscarServicio(idServicio);
                    cliente.setTipoServicio(servicio);
                    cliente.setMesesMora(mora);
                    clientesFacade.create(cliente);
                    break;
            }
        }
        request.setAttribute("cliente", cliente);
        request.setAttribute("servicio", servicio);
        request.setAttribute("clientesTodos", clientesFacade.findAll());
        request.setAttribute("serviciosTodos", servicioFacade.findAll());
        request.getRequestDispatcher("Clientes.jsp").forward(request, response);
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
