/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Especialidad;
import ModeloDAO.EspecialidadDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author deine
 */
@WebServlet(name = "AdminEspecialidadServlet", urlPatterns = {"/AdminEspecialidadServlet"})
public class AdminEspecialidadServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String viewUrl = "";
        String accion = "";
        accion = request.getParameter("accion");
        switch (accion) {
            case "listar":
                viewUrl = this.listarEspecialidades(request);
                break;
            case "agregar":
                viewUrl = this.agregarEspecialidad(request);
                break;
        }

        request.getRequestDispatcher(viewUrl).forward(request, response);
    }
    
    
       public String listarEspecialidades(HttpServletRequest request) {
        try {
            List<Especialidad> especialidades = new EspecialidadDAO().listar();
            request.setAttribute("especialidades", especialidades);
            return "/admin/especialidad/list.jsp";
        } catch (Exception e) {
            return "/index.jsp";
        }
    }

    public String agregarEspecialidad(HttpServletRequest request) {
        try {
            List<String> errores = this.validar(request);
            if (errores.isEmpty()) {
                Especialidad esp = new Especialidad();
                esp.setNombre(request.getParameter("nombre"));
                EspecialidadDAO espDAO = new EspecialidadDAO();
                espDAO.agregar(esp);
                return this.listarEspecialidades(request);
            } else {
                request.setAttribute("errores", errores);
                return "/admin/especialidad/add.jsp";
            }
        } catch (Exception e) {
            return "/comun/error.jsp";
        }
    }

    List validar(HttpServletRequest request) {
        List errores = new ArrayList();
        if (request.getParameter("nombre").isEmpty()) {
            errores.add("Nombre de la Especialidad requerida");
        }
        
        EspecialidadDAO espDAO = new EspecialidadDAO();
        Especialidad esp = espDAO.buscarNom(request.getParameter("nombre"));
        if(esp!=null){
            errores.add("Especialidad ya esta registrada");
        }
        return errores;
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
