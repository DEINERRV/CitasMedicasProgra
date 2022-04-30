package Controlador;


import Modelo.Usuario;
import ModeloDAO.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet(name = "PacPerfilServlet", urlPatterns = {"/PacPerfilServlet"})
@MultipartConfig(
        location = "C:/Users/deine/Documents/NetBeansProjects/CitasMedicas/src/main/webapp/img"
)
public class PacPerfilServlet extends HttpServlet {

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
            case "Actualizar Datos":
                viewUrl = this.actualizar(request);
                break;
            case "Upload photo":
                upload(request);
                viewUrl = "/paciente/perfil.jsp";
                break;
        }

        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    public String actualizar(HttpServletRequest request) {
        try {
            Usuario us = (Usuario) request.getSession().getAttribute("usuario");
            
            us.setNombre(request.getParameter("nombre"));
            us.setTelefono(request.getParameter("telefono"));
            us.setCorreo(request.getParameter("correo"));
            
            UsuarioDAO usDAO = new UsuarioDAO();
            usDAO.editar(us);
            

            request.getSession().setAttribute("usuario", us);

            request.setAttribute("mensaje", "Se ha actulizado los datos correctamente");
            return "/paciente/perfil.jsp";

        } catch (Exception e) {
            return "/paciente/perfil.jsp";
        }
    }

    private void upload(HttpServletRequest request) throws IOException, ServletException {

        final Part imagen;
        HttpSession session = request.getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        imagen = request.getPart("imagen");
        String s = String.valueOf(usuario.getId());
        imagen.write(s + ".png");

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
