package Controlador;

import Modelo.Ciudad;
import Modelo.Dia;
import Modelo.Doctor;
import Modelo.Especialidad;
import ModeloDAO.CitaDAO;
import ModeloDAO.CiudadDAO;
import ModeloDAO.DoctorDAO;
import ModeloDAO.EspecialidadDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "PacDocsServlet", urlPatterns = {"/PacDocsServlet"})
public class PacDocsServlet extends HttpServlet {

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
                viewUrl = this.listarAllDocs(request,"/paciente/doc/doctores.jsp");
                break;
            case "buscar":
                viewUrl = this.filtrarDocs(request,"/paciente/doc/doctores.jsp");
                break;
        }
        
        request.getRequestDispatcher(viewUrl).forward( request, response);
    }
    
    
    private void listarDocs(HttpServletRequest request,List<Doctor> doctores){
        for(Doctor d:doctores){
                List<LocalDate> dias = d.getHorario().getSigDias(3, LocalDate.now());
                for(LocalDate di:dias){
                    boolean flag = false;
                    if(di.equals(LocalDate.now())) flag = true;
                    Dia dia = d.getHorario().buscarDia(di.getDayOfWeek().getValue());
                    List citasRes = new CitaDAO().listarXDocFecha(d.getUsuario().getId(),di);
                    d.AddSlots(dia.getSlots(d.getTiempo_cita(), di, citasRes, flag));
                }
            }
            
            request.setAttribute("doctores",doctores);
            
            List<Especialidad> especialidades = new EspecialidadDAO().listar();
            request.setAttribute("especialidades", especialidades);
            
             List<Ciudad> ciudades = new CiudadDAO().listar();
            request.setAttribute("ciudades", ciudades);
    }
    
    private String listarAllDocs(HttpServletRequest request,String url){
        try{
            List<Doctor> doctores = new DoctorDAO().listarXestado(1);
            
            this.listarDocs(request, doctores);
            
            return url;
        }
        catch(Exception e){
            return "/index.jsp";
        }
    }
    
    private String filtrarDocs(HttpServletRequest request,String url){
        try{
            int id_esp = Integer.parseInt(request.getParameter("especialidad"));
            int id_ciu = Integer.parseInt(request.getParameter("ciudad"));
             List<Doctor> doctores = new ArrayList();
             
            if(id_esp!=999 && id_ciu!=999)
                doctores = new DoctorDAO().listarXespecialidadCiudad(id_esp, id_ciu);
            else if(id_ciu!=999)
                doctores = new DoctorDAO().listarXciudad(id_ciu);
            else if(id_esp!=999)
                doctores = new DoctorDAO().listarXespecialidad(id_esp);
            else 
                doctores = new DoctorDAO().listarXestado(1);
            
            this.listarDocs(request, doctores);
            
            return url;
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
