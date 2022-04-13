<%@page import="Modelo.Especialidad"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Especialidad> especialidades = (List) request.getAttribute("especialidades");
%>

<!DOCTYPE html>
<html>
    <<%@ include file="/comun/head.jsp" %>
    <body>
        <%@ include file="/comun/header.jsp" %>
        
        <main class="contenedor">

            <div class="alinear-izquierda">
                <a href="${pageContext.request.contextPath}/admin/especialidad/add.jsp" class="boton inline-block">Agregar Nueva</a>
            </div>

            <h1>Especialidades</h1>
            <% for (Especialidad esp : especialidades) {%>
            <p><%= esp.getNombre() %></p>
            <%}%>

        </main>
        
        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>
