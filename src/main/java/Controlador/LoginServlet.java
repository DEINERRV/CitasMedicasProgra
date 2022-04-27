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
        }

        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    private String login(HttpServletRequest request) {
        try {
            return this.loginAction(request);
        } catch (Exception e) {
            return "/comun/error.jsp";
        }
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
                this.saveProgres(request);
                return "/login/logIn.jsp";
            } else if (!(us.getContrasena().equals(request.getParameter("contrasena")))) {
                errores.add("Usuario o clave incorrectos");
                request.setAttribute("errores", errores);
                this.saveProgres(request);
                return "/login/logIn.jsp";
            }

            //Registra el usuario en la sesion y busca que tipo es para asignarle 
            //la siguiente ventana
            session.setAttribute("usuario", us);
            String viewUrl = "";
            switch (us.getTipo()) {
                case 1:
                    //Para ver si antes de logearse habia buscado algo o intentado sacar una cita
                    //Y redirigirlo a la pagina de doctores antes que a la de citas del usuario
                    String id_esp = (String) request.getSession().getAttribute("buscEsp");
                    String id_ciu = (String) request.getSession().getAttribute("buscCiu");
                    if(id_esp!=null && id_ciu!=null)viewUrl = "PacDocsServlet?accion=show";
                    else viewUrl = "PacCitasServlet?accion=show";
                    break;
                case 2:
                    Doctor doc = new DoctorDAO().buscar(us.getId());
                    session.setAttribute("doc", doc);
                    viewUrl = "DocPerfilServlet?accion=show";
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

    public void saveProgres(HttpServletRequest request) {
        String id = request.getParameter("id");
        if (id == null) id = "";
        request.setAttribute("id", id);
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
