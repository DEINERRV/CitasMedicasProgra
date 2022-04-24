package Controlador;

import Modelo.Cita;
import Modelo.Doctor;
import Modelo.Usuario;
import ModeloDAO.CitaDAO;
import ModeloDAO.DoctorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "PacReservarServlet", urlPatterns = {"/PacReservarServlet"})
public class PacReservarServlet extends HttpServlet {

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
                viewUrl = this.confirmar(request);
                break;
            case "cancelar":
                viewUrl = "PacDocsServlet?accion=show";
                break;
            case "reservar":
                viewUrl = this.reservar(request);
                break;
        }
        
        request.getRequestDispatcher(viewUrl).forward( request, response);
    }
    
    
    private String confirmar(HttpServletRequest request){
         if(request.getSession().getAttribute("usuario")==null){
            return "/paciente/signIn.jsp";
         }
         try{
             Doctor doc = new DoctorDAO().buscar(Integer.parseInt(request.getParameter("id-doc")));
             LocalDate dia = LocalDate.parse(request.getParameter("dia"));
             LocalTime hora = LocalTime.parse(request.getParameter("hora"));
             
             request.setAttribute("doc", doc);
             request.setAttribute("dia", dia);
             request.setAttribute("hora", hora);
             
             return "/paciente/doc/confirmarCita.jsp";
         }
         catch(Exception e){
            return "/index.jsp";
        }
         
     }
     
     
     private String reservar(HttpServletRequest request){
         try{
             Doctor doc = new DoctorDAO().buscar(Integer.parseInt(request.getParameter("id-doc")));
             Usuario us = (Usuario) request.getSession().getAttribute("usuario");
             LocalDate dia = LocalDate.parse(request.getParameter("dia"));
             LocalTime hora = LocalTime.parse(request.getParameter("hora"));
             Cita cita = new Cita(doc,us,dia,hora,"");
             CitaDAO citaDAO = new CitaDAO();
             citaDAO.agregar(cita);
             return "PacCitasServlet?accion=show";
         }
         catch(Exception e){
            return "PacDocsServlet?accion=show";
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
