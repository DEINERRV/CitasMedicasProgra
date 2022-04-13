<%@page import="Modelo.Ciudad"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Ciudad> ciudades = (List) request.getAttribute("ciudades");
%>

<!DOCTYPE html>
<html>
    <%@ include file="/comun/head.jsp" %>
    <body>
        <%@ include file="/comun/header.jsp" %>

        <main class="contenedor">

            <div class="alinear-izquierda">
                <a href="${pageContext.request.contextPath}/admin/ciudad/add.jsp" class="boton inline-block">Agregar Nueva</a>
            </div>

            <h1>Ciudades</h1>
            <% for (Ciudad ciu : ciudades) {%>
            <p><%= ciu.getNombre() %></p>
            <%}%>

        </main>


        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>