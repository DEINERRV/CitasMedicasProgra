<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<String> errores = (List<String>) request.getAttribute("errores"); 
%>

<!DOCTYPE html>
<html>
    <%@ include file="/comun/head.jsp" %>
    <body>
        <%@ include file="/comun/header.jsp" %>
        
        <% if(errores!=null){ for(String error:errores){ %>
        <div class="error"> 
            <p><%= error %></p>
        </div>
        <% }} %>
        
        
        <section class="contenedor">
            <h1 class="centrado">Log In</h1>

            <form action="/Admin/LoginServlet" method="POST" class="formulario">
                <fieldset>
                    <label for="id">ID del Usuario</label>
                    <input type="text" name="id" placeholder="ID del Usuario" id="id" value="">

                    <label for="contrasena">Contrasena del Usuario</label>
                    <input type="password" name="contrasena" placeholder="Contrasena del Usuario" id="contrasena" value="">

                    <div class="forma-ingreso">
                        <label for="paciente">Paciente</label>
                        <input name="tipo-ingreso" type="radio" value="paciente" id="paciente">

                        <label for="doctor">Doctor</label>
                        <input name="tipo-ingreso" type="radio" value="doctor" id="doctor">

                        <label for="admin">Admin</label>
                        <input name="tipo-ingreso" type="radio" value="admin" id="admin">
                    </div>

                    <input type="submit" class="boton" name="accion" value="login">
                </fieldset>
            </form>
        </section>


        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>
