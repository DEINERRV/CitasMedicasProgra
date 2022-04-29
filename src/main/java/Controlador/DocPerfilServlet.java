package Controlador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Modelo.Ciudad;
import Modelo.Doctor;
import Modelo.Especialidad;
import Modelo.Usuario;
import ModeloDAO.CiudadDAO;
import ModeloDAO.DoctorDAO;
import ModeloDAO.EspecialidadDAO;
import ModeloDAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;



@WebServlet(name = "DocPerfilServlet", urlPatterns = {"/DocPerfilServlet"})
@MultipartConfig(
        location = "C:/Users/deine/Documents/NetBeansProjects/CitasMedicas/src/main/webapp/img"
)
public class DocPerfilServlet extends HttpServlet {

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
            case "show":
                viewUrl = this.show(request);
                break;
            case "Actualizar Datos":
                viewUrl = this.actualizar(request);
                break;
            case "Upload photo":
                upload(request);
                viewUrl = "index.jsp";
                break;
        }

        request.getRequestDispatcher(viewUrl).forward(request, response);
    }
    
    
     public String show(HttpServletRequest request) {
        try {
            EspecialidadDAO espDAO = new EspecialidadDAO();
            List<Especialidad> especialidades = espDAO.listar();
            request.setAttribute("especialidades", especialidades);

            CiudadDAO ciuDAO = new CiudadDAO();
            List<Ciudad> ciudades = ciuDAO.listar();
            request.setAttribute("ciudades", ciudades);

            return "/doc/perfil.jsp";
        } catch (Exception e) {
            return "/comun/Error.jsp";
        }
    }
    
     
      public String actualizar(HttpServletRequest request) {
        try {
            List<String> errores = this.validar(request);
            if (errores.isEmpty()) {
                Doctor doc = (Doctor) request.getSession().getAttribute("doc");
                
                doc.getUsuario().setNombre(request.getParameter("nombre"));
                doc.getUsuario().setTelefono(request.getParameter("telefono"));
                doc.getUsuario().setCorreo(request.getParameter("correo"));
                doc.setPrecio(Integer.parseInt(request.getParameter("precio")));
                doc.setTiempo_cita(Integer.parseInt(request.getParameter("tiempo")));
                
                Especialidad esp = new EspecialidadDAO().buscar(Integer.parseInt(request.getParameter("especialidad")));
                Ciudad ciu = new CiudadDAO().buscar(Integer.parseInt(request.getParameter("ciudad")));
                doc.setEspecialidad(esp);
                doc.setCiudad(ciu);
                
                DoctorDAO docDAO = new DoctorDAO();
                docDAO.editar(doc);
                
                request.getSession().setAttribute("usuario", doc.getUsuario());
                request.getSession().setAttribute("doc", doc);
                
                return "index.jsp";
            } else {
                request.setAttribute("errores", errores);
                return this.show(request);
            }
        } catch (Exception e) {
            return "/comun/error.jsp";
        }
    }

    //Verifica que los campos del formulario no esten vacios
    List validar(HttpServletRequest request) {
        List errores = new ArrayList();

        if (request.getParameter("nombre").isEmpty()) {
            errores.add("Nombre requerida");
        }
        if (request.getParameter("telefono").isEmpty()) {
            errores.add("Telefono requerida");
        }
        if (request.getParameter("correo").isEmpty()) {
            errores.add("Correo requerida");
        }
        if (request.getParameter("precio").isEmpty()) {
            errores.add("Precio requerido");
        }
        

        return errores;
    }
    
    
    private void upload(HttpServletRequest request) throws IOException, ServletException {

        final Part imagen;
        HttpSession session = request.getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        imagen = request.getPart("imagen");
        String s=String.valueOf(usuario.getId());  
        imagen.write(s+".png");

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
