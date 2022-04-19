<%@page import="java.util.List"%>
<%@page import="Modelo.Doctor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Doctor> doctores = (List) request.getAttribute("doctores");
%>

<!DOCTYPE html>
<html>
    <%@ include file="/comun/head.jsp" %>
    
    <body>
        <%@ include file="/comun/header.jsp" %>
       
        <main class="contenedor">
            <% for (Doctor d : doctores) { %>
            <div class="doctor">
                <img class="foto-doctor" loading="lazy" src="img/blog1.jpg" alt="anuncio">

                <div class="contenido-doctor">
                    <p> <%= d.getUsuario().getNombre() %></p>
                    <p class="precio"> $<%= d.getPrecio() %></p>
                    <p> <%= d.getCiudad().getNombre() %></p>
                    <p> <%= d.getEspecialidad().getNombre() %></p>
                </div>
            </div>
            <% }%>
        </main>
        
        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>
