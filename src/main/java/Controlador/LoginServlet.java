package Controlador;

import Modelo.Doctor;
import Modelo.Usuario;
import ModeloDAO.DoctorDAO;
import ModeloDAO.UsuarioDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
            case "login":
                viewUrl = this.login(request);
                break;
            case "logout":
                viewUrl = this.logout(request);
                break;
            case "show":
                viewUrl = this.show(request);
                break;
        }

        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    private String login(HttpServletRequest request) {
        try {
            List<String> errores = this.validar(request);
            if (errores.isEmpty()) {
                return this.loginAction(request);
            } else {
                request.setAttribute("errores", errores);
                return "/login/logIn.jsp";
            }
        } catch (Exception e) {
            return "/comun/error.jsp";
        }
    }

    //Verifica que los campos del formulario no esten vacios
    List validar(HttpServletRequest request) {
        List errores = new ArrayList();
        if (request.getParameter("id").isEmpty()) {
            errores.add("ID requerida");
        }
        if (request.getParameter("contrasena").isEmpty()) {
            errores.add("Clave requerida");
        }
        return errores;
    }

    public String loginAction(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        List<String> errores = new ArrayList();
        try {
            UsuarioDAO usDAO = new UsuarioDAO();
            Usuario us = usDAO.buscar(Integer.parseInt(request.getParameter("id")));

            //ID o contrasena incorrecta
            if (us == null) {
                errores.add("Usuario No Registrado");
                request.setAttribute("errores", errores);
                return "/login/logIn.jsp";
            } else if (!(us.getContrasena().equals(request.getParameter("contrasena")))) {
                errores.add("Usuario o clave incorrectos");
                request.setAttribute("errores", errores);
                return "/login/logIn.jsp";
            }

            //Registra el usuario en la sesion y busca que tipo es para asignarle 
            //la siguiente ventana
            session.setAttribute("usuario", us);
            String viewUrl = "";
            switch (us.getTipo()) {
                case 1:
                    viewUrl = "/paciente/citas.jsp";
                    break;
                case 2:
                    Doctor doc = new DoctorDAO().buscar(us.getId());
                    session.setAttribute("doc", doc);
                    viewUrl = "/doc/perfil.jsp";
                    break;
                case 3:
                    viewUrl = "/admin/index.jsp";
                    break;
            }

            return viewUrl;

        } catch (Exception ex) {
            errores.add("ID invalida");
            request.setAttribute("errores", errores);
            return "/login/logIn.jsp";
        }

    }

    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute("usuario");
        session.removeAttribute("doc");
        session.invalidate();
        return "/index.jsp";
    }

    public String show(HttpServletRequest request) {
        String id = request.getParameter("id");
        String contra = request.getParameter("contrasena");

        if (id == null) {
            id = "";
        }
        if (contra == null) {
            contra = "";
        }

        request.setAttribute("id", id);
        request.setAttribute("contra", contra);

        return "/login/logIn.jsp";
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
