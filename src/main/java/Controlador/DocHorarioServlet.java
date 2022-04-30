package Controlador;

import Modelo.Dia;
import Modelo.Doctor;
import Modelo.Horario;
import ModeloDAO.DiaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DocHorarioServlet", urlPatterns = {"/DocHorarioServlet"})
public class DocHorarioServlet extends HttpServlet {

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
            case "Actualizar Horario":
                viewUrl = this.actualizar(request);
                break;
        }

        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    public String actualizar(HttpServletRequest request) {
        try {
            List<String> errores = this.validar(request);
            if (errores.isEmpty()) {
                Doctor doc = (Doctor) request.getSession().getAttribute("doc");
                List<Dia> horario = this.listarDias(request);
                
                DiaDAO diaDAO = new DiaDAO();
                diaDAO.eliminar(doc.getUsuario().getId());
                
                for(Dia d:horario){
                    diaDAO.agregar(d, doc.getUsuario().getId());
                }
                
                doc.setHorario(new Horario(horario));
                request.getSession().setAttribute("doc", doc);

                request.setAttribute("mensaje", "Se ha actulizado los datos correctamente");
                return "/doc/horario.jsp";
            } else {
                request.setAttribute("errores", errores);
                return "/doc/horario.jsp";
            }
        } catch (Exception e) {
            return "/comun/error.jsp";
        }
    }

    List validar(HttpServletRequest request){
        List errores = new ArrayList();

        for(int i=1;i<=7;i++){
            String nomDia = "";
            switch(i){
                case 1: nomDia = "lunes"; break;
                case 2: nomDia = "martes"; break;
                case 3: nomDia = "miercoles"; break;
                case 4: nomDia = "jueves"; break;
                case 5: nomDia = "viernes"; break;
                case 6: nomDia = "sabado"; break;
                case 7: nomDia = "domingo"; break;
            }
            
             if (request.getParameter(nomDia)!=null){
                 LocalTime inicio = null;
                 LocalTime finall = null;
                 try{
                     inicio = LocalTime.parse(request.getParameter(i+"-hora-i"));
                     finall = LocalTime.parse(request.getParameter(i+"-hora-f"));
                 }
                 catch(Exception e){
                     errores.add("ERROR: Se debe brindar tanto la hora de incio como la final en los dias que se trabajan");
                 }
                 
                 if(inicio!=null && finall!=null){
                    if(inicio.isAfter(finall)){
                        errores.add("Error al definir el horario(No se puede establecer una hora inicial que sea despues de la hora final de trabajo)");
                    }
                 }
             }
        }
        
        
        return errores;
    }
        
        
    private List<Dia> listarDias(HttpServletRequest request) {
        List<Dia> horario = new ArrayList();
        
        for(int i=1;i<=7;i++){
            Dia dia = new Dia();
            String nomDia = "";
            switch(i){
                case 1: nomDia = "lunes"; break;
                case 2: nomDia = "martes"; break;
                case 3: nomDia = "miercoles"; break;
                case 4: nomDia = "jueves"; break;
                case 5: nomDia = "viernes"; break;
                case 6: nomDia = "sabado"; break;
                case 7: nomDia = "domingo"; break;
            }
            if (request.getParameter(nomDia)!=null) {
                dia.setId(i);
                dia.setHora_inicio(LocalTime.parse(request.getParameter(i+"-hora-i")));
                dia.setHora_final(LocalTime.parse(request.getParameter(i+"-hora-f")));
                horario.add(dia);
            }
        }
            
        return horario;
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
