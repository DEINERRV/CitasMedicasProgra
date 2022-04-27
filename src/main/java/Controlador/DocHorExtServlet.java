package Controlador;

import Modelo.Dia;
import Modelo.Doctor;
import ModeloDAO.CitaDAO;
import ModeloDAO.DoctorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DocHorExtServlet", urlPatterns = {"/DocHorExtServlet"})
public class DocHorExtServlet extends HttpServlet {

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
        LocalDate diaBase = LocalDate.now();
        switch (accion) {
            case "show":
                viewUrl = this.show(request,diaBase);
                break;
            case "next":
                String dia_base = (String) request.getParameter("dia-base");
                diaBase = LocalDate.parse(dia_base);
                viewUrl = this.prev(request,diaBase);
                break;
            case "prev":
                String dia_bas = (String) request.getParameter("dia-base");
                diaBase = LocalDate.parse(dia_bas);
                viewUrl = this.prev(request,diaBase);
                break;
        }

        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    private String show(HttpServletRequest request,LocalDate diaAux) {
        try {
            Doctor doc = new DoctorDAO().buscar(Integer.parseInt(request.getParameter("id-doc")));
            doc.setSlots(new ArrayList());
            List<LocalDate> dias = doc.getHorario().getSigDias(3, diaAux);
            for (LocalDate di : dias) {
                boolean flag = false;
                if (di.equals(LocalDate.now())) {flag = true;}
                Dia dia = doc.getHorario().buscarDia(di.getDayOfWeek().getValue());
                List citasRes = new CitaDAO().listarXDocFecha(doc.getUsuario().getId(), di);
                doc.AddSlots(dia.getSlots(doc.getTiempo_cita(), di, citasRes, flag));
            }

            request.setAttribute("doc", doc);

            return "/paciente/doc/docHorarioExt.jsp";
        } catch (Exception e) {
            return "/index.jsp";
        }
    }
    
    
    private String prev(HttpServletRequest request,LocalDate diaAux) {
        try {
            Doctor doc = new DoctorDAO().buscar(Integer.parseInt(request.getParameter("id-doc")));

            diaAux = doc.getHorario().getAntDia(diaAux);
            if(diaAux.isBefore(LocalDate.now())){
                return this.show(request, LocalDate.now());
            }

            return this.show(request, diaAux);
        } catch (Exception e) {
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
