<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<String> errores = (List<String>) request.getAttribute("errores");
%>

<!DOCTYPE html>
<html>
    <%@ include file="/comun/head.jsp" %>

    <body>
        <%@ include file="/comun/header.jsp" %>

        <% if (errores != null) {
                for (String error : errores) {%>
        <div class="error contenedor"> 
            <p><%= error%></p>
        </div>
        <% }
            }%>

        <section class="contenedor">
            <h1 class="centrado">Agregar Ciudad</h1>

            <form action="/CitasMedicas/AdminCiudadServlet" method="POST" class="formulario">
                <fieldset>
                    <label for="nombre">Nombre de la Ciudad</label>
                    <input type="text" name="nombre" placeholder="Nombre de la Ciudad" id="Ciudad" value="" required>


                    <input type="submit" class="boton" name="accion" value="agregar">
                </fieldset>
            </form>
        </section>

        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>
