package Controlador;

import Modelo.Doctor;
import ModeloDAO.DoctorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminDocServlet", urlPatterns = {"/AdminDocServlet"})
public class AdminDocServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String viewUrl="";
        String accion="";
        accion = request.getParameter("accion");
        switch(accion){
            case "listar": 
                viewUrl = this.listarDocs(request,1,"/admin/doc/listar.jsp");
                break;
            case "porAceptar": 
                viewUrl = this.listarDocs(request,0,"/admin/doc/accept.jsp");
                break;
            case "aceptar":
                viewUrl = this.aceptar(request);
                break;
            case "denegar":
                viewUrl = this.denegar(request);
                break;
        }
        
        request.getRequestDispatcher(viewUrl).forward( request, response);
    }
    
    private String listarDocs(HttpServletRequest request,int estado,String url){
        try{
            List<Doctor> doctores = new DoctorDAO().listarXestado(estado);
            request.setAttribute("doctores",doctores);
            return url;
        }
        catch(Exception e){
            return "/index.jsp";
        }
    }
    
    private String aceptar(HttpServletRequest request){
        try{
            DoctorDAO docDAO = new DoctorDAO();
            Doctor doc = docDAO.buscar(Integer.parseInt(request.getParameter("us-id")));
            doc.setEstado(1);
            docDAO.editar(doc);
            return this.listarDocs(request, 0, "/admin/doc/accept.jsp");
        }
        catch(Exception e){
            return "/comun/Error.jsp";
        }
    }
    
    
     private String denegar(HttpServletRequest request){
        try{
            DoctorDAO docDAO = new DoctorDAO();
            docDAO.eliminar(Integer.parseInt(request.getParameter("us-id")));
            return this.listarDocs(request,0,"/admin/doc/accept.jsp");
        }
        catch(Exception e){
            return "/comun/Error.jsp";
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
