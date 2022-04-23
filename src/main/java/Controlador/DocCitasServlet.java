package Controlador;

import Modelo.Cita;
import Modelo.Usuario;
import ModeloDAO.CitaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "DocCitasServlet", urlPatterns = {"/DocCitasServlet"})
public class DocCitasServlet extends HttpServlet {

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
        
        String viewUrl="";
        String accion="";
        accion = request.getParameter("accion");
        switch(accion){
            case "show": 
                viewUrl = this.show(request);
                break;
            case "cancelar": 
                viewUrl = this.cancelar(request);
                break;
        }
        
        request.getRequestDispatcher(viewUrl).forward( request, response);
    }
    
    private String show(HttpServletRequest request){
        try{
            Usuario us = (Usuario) request.getSession().getAttribute("usuario");
            List<Cita> citas = new CitaDAO().listarXDoc(us.getId());
            
            request.setAttribute("citas", citas);
            
            return "/doc/citas.jsp";
        }
        catch(Exception e){
            return "/index.jsp";
        }
    }
    
    
    private String cancelar(HttpServletRequest request){
        try{
            CitaDAO citaDAO = new CitaDAO();
            Usuario us = (Usuario) request.getSession().getAttribute("usuario");
            LocalDate dia = LocalDate.parse(request.getParameter("dia"));
            LocalTime hora = LocalTime.parse(request.getParameter("hora"));
            citaDAO.eliminar(us.getId(), dia, hora);
            return this.show(request);
        }
        catch(Exception e){
            return "/index.jsp";
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
