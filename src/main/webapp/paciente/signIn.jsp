<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<String> errores = (List<String>) request.getAttribute("errores");
   String id = (String) request.getAttribute("id");
   String nom = (String) request.getAttribute("nom");
   String contra = (String) request.getAttribute("contra");
   String contra2 = (String) request.getAttribute("contra2");
   String tel = (String) request.getAttribute("tel");
%>

<!DOCTYPE html>
<html>
    <%@ include file="/comun/head.jsp" %>
    <body>
        <%@ include file="/comun/header.jsp" %>

        <% if (errores != null) {
            for (String error : errores) {%>
        <div class="error contenedor">
            <p>ERROR: <%= error%></p>
        </div>
        <% }
            }%>


        <section class="contenedor">
            <h1 class="centrado">Sign In</h1>

            <form action="/CitasMedicas/SigninServlet" method="POST" class="formulario">
                <fieldset>
                    <label for="id">ID del Usuario</label>
                    <input type="number" name="id" placeholder="ID del Usuario" id="id" value="<%=(id!=null)?id:""%>" required class="inputNumNone">

                    <label for="contrasena">Contrasena del Usuario</label>
                    <input type="text" name="contrasena" placeholder="Contrasena del Usuario" id="contrasena" value="<%=(contra!=null)?contra:""%>" required>
                    
                    <label for="contrasena">Confirmar Contrasena</label>
                    <input type="text" name="contrasena2" placeholder="Contrasena del Usuario" id="contrasena" value="<%=(contra2!=null)?contra2:""%>" required>
                    
                    <label for="nombre">Nombre y apellido</label>
                    <input type="text" name="nombre" placeholder="Nombre y apellido" id="nombre" value="<%=(nom!=null)?nom:""%>" required>

                    <label for="telefono">Teléfono</label>
                    <input type="text" name="telefono" placeholder="Número de teléfono" id="telefono" value="<%=(tel!=null)?tel:""%>" required>

                    <input type="submit" class="boton" name="accion" value="signinPaciente">
                </fieldset>
            </form>

        </section>
            
        <p class="centrado margen-botton-35">Si eres un DOCTOR y quieres formar parte de esta plataforma registrate <a href="/CitasMedicas/SigninServlet?accion=show">aqui</a></p>

        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>
