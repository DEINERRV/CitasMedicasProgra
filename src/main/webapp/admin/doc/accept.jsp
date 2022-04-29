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
            <h1>Solicitudes de Doctores</h1>
            
            <% for (Doctor d : doctores) { %>
            <div class="doctor">
                <img class="foto-doctor" loading="lazy" src="${pageContext.request.contextPath}/img/<%=d.getUsuario().getId()%>.jpg" 
                         onerror="this.src='${pageContext.request.contextPath}/img/noFoto.png';" />

                <div class="contenido-doctor">
                    <p> <%= d.getUsuario().getNombre() %></p>
                    <p class="precio"> $<%= d.getPrecio() %></p>
                    <p> <%= d.getCiudad().getNombre() %></p>
                    <p> <%= d.getEspecialidad().getNombre() %></p>
                </div>
                <div class="inline-block padding1">
                    <a class="boton" href="/CitasMedicas/AdminDocServlet?accion=aceptar&us-id=<%= d.getUsuario().getId() %>">Aceptar</a>
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
