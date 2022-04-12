<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<String> errores = (List<String>) request.getAttribute("errores");%>

<!DOCTYPE html>
<html>
    <%@ include file="/comun/head.jsp" %>
    <body>
        <%@ include file="/comun/header.jsp" %>

        <% if (errores != null) {
               a for (String error : errores) {%>
        <div class="error">
            <p><%= error%></p>
        </div>
        <% }
            }%>


        <section class="contenedor">
            <h1 class="centrado">Sign In</h1>

            <form action="/CitasMedicas/LoginServlet" method="POST" class="formulario">
                <fieldset>
                    <label for="id">ID del Usuario</label>
                    <input type="text" name="id" placeholder="ID del Usuario" id="id" value="">

                    <label for="contrasena">Contrasena del Usuario</label>
                    <input type="text" name="contrasena" placeholder="Contrasena del Usuario" id="contrasena" value="">

                    <label for="nombre">Nombre y apellido</label>
                    <input type="text" name="nombre y apellido" placeholder="Nombre y apellido" id="nombre" value="">

                    <label for="telefono">Teléfono</label>
                    <input type="text" name="telefono" placeholder="Número de teléfono" id="telefono" value="">

                    <input type="submit" class="boton" name="accion" value="Sign in">
                </fieldset>
            </form>

        </section>
            
        <p class="centrado margen-botton-35">Si eres un DOCTOR y quieres formar parte de esta plataforma registrate <a href="${pageContext.request.contextPath}/doc/signIn.jsp">aqui</a></p>

        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>
