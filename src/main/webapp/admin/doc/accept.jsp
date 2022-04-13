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
        
        <h1>Hello World!</h1>

        <main class="contenedor">
            <% for (Doctor d : doctores) { %>
            <div class="doctor">
                <img class="foto-doctor" loading="lazy" src="img/blog1.jpg" alt="anuncio">

                <div class="contenido-doctor">
                    <p> <%= d.getUsuario().getNombre() %></p>
                    <p class="precio"> $<%= d.getPrecio() %></p>
                    <p> <%= d.getCiudad() %></p>
                    <p> <%= d.getEspecialidad() %></p>
                </div>
                <div class="inline-block padding1">
                    <a class="boton" href="/CitasMedicas/AdminDocServlet?accion=denegar&us-id=<%= d.getUsuario().getId() %>">Aceptar</a>
                </div>
                <div class="inline-block padding1">
                    <a class="boton" href="/CitasMedicas/AdminDocServlet?accion=denegar&us-id=<%= d.getUsuario().getId() %>">Denegar</a>
                </div>
            </div>
            <% }%>
        </main>


        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>
