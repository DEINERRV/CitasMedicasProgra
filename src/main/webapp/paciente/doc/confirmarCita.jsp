<%@page import="java.time.format.FormatStyle"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="Modelo.Doctor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Doctor doc = (Doctor) request.getAttribute("doc"); 
   LocalDate dia = (LocalDate) request.getAttribute("dia");
%>


<!DOCTYPE html>
<html>
    <%@ include file="/comun/head.jsp" %>

    <body>
        <%@ include file="/comun/header.jsp" %>

        <div class="doctor contenedor">
            <img class="foto-doctor" loading="lazy" src="${pageContext.request.contextPath}/img/<%=doc.getUsuario().getId()%>.png" 
                         onerror="this.src='${pageContext.request.contextPath}/img/noFoto.png';" />

            <div class="contenido-doctor">
                <h3><%= doc.getUsuario().getNombre() %></h3>
                <p class="precio">$<%= doc.getPrecio() %></p>
                <p><%= doc.getCiudad().getNombre() %></p>
                <p><%= doc.getEspecialidad().getNombre() %></p>
                <p><%=dia.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))%></p>
                <p><%= request.getAttribute("hora") %></p>
            </div>
            <div class="inline-block padding1">
                <a class="boton" href="PacReservarServlet?accion=reservar&id-doc=<%=doc.getUsuario().getId()%>&dia=<%=request.getAttribute("dia")%>&hora=<%= request.getAttribute("hora") %>">Confirmar Cita</a>
            </div>
            <div class="inline-block padding1">
                <a class="boton" href="PacReservarServlet?accion=cancelar">Cancelar</a>
            </div>
        </div>

        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>
