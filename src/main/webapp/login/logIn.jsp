<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<String> errores = (List<String>) request.getAttribute("errores"); 
   String cedula = (String) request.getAttribute("id");
%>

<!DOCTYPE html>
<html>
    <%@ include file="/comun/head.jsp" %>
    <body>
        <%@ include file="/comun/header.jsp" %>
        
        <% if(errores!=null){ for(String error:errores){ %>
        <div class="error contenedor"> 
            <p><%= error %></p>
        </div>
        <% }} %>
        
        
        <section class="contenedor">
            <h1 class="centrado">Log In</h1>

            <form action="/CitasMedicas/LoginServlet" method="POST" class="formulario">
                <fieldset>
                    <label for="id">ID del Usuario</label>
                    <input type="number" name="id" placeholder="ID del Usuario" id="id" value="<%=(cedula!=null)?cedula:""%>" required class="inputNumNone">

                    <label for="contrasena">Contrasena del Usuario</label>
                    <input type="password" name="contrasena" placeholder="Contrasena del Usuario" id="contrasena" value="" required>

                    <input type="submit" class="boton" name="accion" value="login">
                </fieldset>
            </form>
        </section>


        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>
