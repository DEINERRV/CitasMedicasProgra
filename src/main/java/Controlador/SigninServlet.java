package Controlador;

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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SigninServlet", urlPatterns = {"/SigninServlet"})
public class SigninServlet extends HttpServlet {

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
            case "signin como Paciente":
                viewUrl = this.signinPaciente(request);
                break;
            case "signin como Doctor":
                viewUrl = this.signinDoctor(request);
                break;
        }

        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    //Parar Traer las Especialidades y Ciudades de la base y mandarlas
    public String show(HttpServletRequest request) {
        try {
            EspecialidadDAO espDAO = new EspecialidadDAO();
            List<Especialidad> especialidades = espDAO.listar();
            request.setAttribute("especialidades", especialidades);

            CiudadDAO ciuDAO = new CiudadDAO();
            List<Ciudad> ciudades = ciuDAO.listar();
            request.setAttribute("ciudades", ciudades);

            return "/doc/signIn.jsp";
        } catch (Exception e) {
            return "/comun/Error.jsp";
        }
    }

    public String signinPaciente(HttpServletRequest request) {
        try {
            List<String> errores = this.validar(request);
            if (errores.isEmpty()) {
                this.signinPacienteAction(request);
                return "index.jsp";
            } else {
                request.setAttribute("errores", errores);
                this.saveProgress(request);
                return "/paciente/signIn.jsp";
            }
        } catch (Exception e) {
            return "/comun/error.jsp";
        }
    }

    //Verifica que los campos del formulario no esten vacios
    List validar(HttpServletRequest request) {
        List errores = new ArrayList();

        try {
            UsuarioDAO usDAO = new UsuarioDAO();
            Usuario us = usDAO.buscar(Integer.parseInt(request.getParameter("id")));
            if (us != null) {
                errores.add("Usuario ya registrado");
            }
        } catch (Exception e) {
        }

        if (!request.getParameter("contrasena").equals(request.getParameter("contrasena2"))) {
            errores.add("Las contrasenas no coinciden");
        }

        return errores;
    }

    public void signinPacienteAction(HttpServletRequest request) {
        try {
            UsuarioDAO usDAO = new UsuarioDAO();
            int id = Integer.parseInt(request.getParameter("id"));
            String contra = request.getParameter("contrasena");
            String nom = request.getParameter("nombre");
            String tel = request.getParameter("telefono");

            Usuario us = new Usuario(id, contra, nom, 1, tel, " ");
            usDAO.agregar(us);
        } catch (Exception e) {
            throw e;
        }
    }

    List validarDoc(HttpServletRequest request) {
        List errores = this.validar(request);
        if (request.getParameter("especialidad").isEmpty()) {
            errores.add("Seleccione una especialidad");
        }
        if (request.getParameter("ciudad").isEmpty()) {
            errores.add("Seleccione una ciudad");
        }

        return errores;
    }

    public String signinDoctor(HttpServletRequest request) {
        try {
            List<String> errores = this.validar(request);
            if (errores.isEmpty()) {
                this.signinDoctorAction(request);
                return "/doc/mensaje.jsp";
            } else {
                request.setAttribute("errores", errores);
                this.saveProgress(request);
                this.saveProgressDoc(request);
                return this.show(request);
            }
        } catch (Exception e) {
            return "/comun/error.jsp";
        }
    }

    public void signinDoctorAction(HttpServletRequest request) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String contra = request.getParameter("contrasena");
            String nom = request.getParameter("nombre");
            String tel = request.getParameter("telefono");

            Usuario us = new Usuario(id, contra, nom, 2, tel, " ");
            Especialidad esp = new EspecialidadDAO().buscar(Integer.parseInt(request.getParameter("especialidad")));
            Ciudad ciu = new CiudadDAO().buscar(Integer.parseInt(request.getParameter("ciudad")));

            Doctor doc = new Doctor(esp, ciu, 0, 0, us, 0);
            DoctorDAO docDAO = new DoctorDAO();
            docDAO.agregar(doc);
        } catch (Exception e) {
            throw e;
        }
    }

    
    
    public void saveProgress(HttpServletRequest request) {
        String id = request.getParameter("id");
        String contra = request.getParameter("contrasena");
        String contra2 = request.getParameter("contrasena2");
        String nom = request.getParameter("nombre");
        String tel = request.getParameter("telefono");
        
        request.setAttribute("id", id);
        request.setAttribute("contra", contra);
        request.setAttribute("contra2", contra2);
        request.setAttribute("nom", nom);
        request.setAttribute("tel", tel);
    }
    
    public void saveProgressDoc(HttpServletRequest request) {
        String idEsp = request.getParameter("especialidad");
        String idCiu = request.getParameter("ciudad");
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
