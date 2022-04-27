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
        
        //Para ver si se acaba de aplicar algun filtro de busqueda
        String id_esp_bus = request.getParameter("especialidad");
        String id_ciu_bus = request.getParameter("ciudad");
        
        //Si no se acaba de aplicar, entonces se aplica el ultimo filtro usado por el usuario
        String id_esp = (String) request.getSession().getAttribute("buscEsp");
        String id_ciu = (String) request.getSession().getAttribute("buscCiu");
        
        if(id_esp_bus!=null || id_ciu_bus!=null) viewUrl = this.filtrarDocs(request,id_esp_bus,id_ciu_bus,"/paciente/doc/doctores.jsp");
        else if(id_esp==null && id_ciu==null){
            viewUrl = this.listarAllDocs(request,"/paciente/doc/doctores.jsp");
        }
        else{
            viewUrl = this.filtrarDocs(request,id_esp,id_ciu,"/paciente/doc/doctores.jsp");
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
            
            this.saveProgress(request, "999", "999");
            return url;
        }
        catch(Exception e){
            return "/index.jsp";
        }
    }
    
    private String filtrarDocs(HttpServletRequest request,String idEsp,String idCiu,String url){
        try{
            int id_esp = Integer.parseInt(idEsp);
            int id_ciu = Integer.parseInt(idCiu);
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
            
            this.saveProgress(request,idEsp , idCiu);
            return url;
        }
        catch(Exception e){
            return "/index.jsp";
        }
    }
    
    
    public void saveProgress(HttpServletRequest request,String esp,String ciu){
        request.getSession().setAttribute("buscEsp", esp);
        request.getSession().setAttribute("buscCiu", ciu);
        
        //En el caso que no esten
        if(esp==null) request.getSession().setAttribute("buscEsp", "999");
        if(ciu==null) request.getSession().setAttribute("buscCiu", "999");
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
