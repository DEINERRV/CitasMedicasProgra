<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<String> errores = (List<String>) request.getAttribute("errores");%>

<!DOCTYPE html>
<html>
    <%@ include file="/comun/head.jsp" %>
    <body>
        <%@ include file="/comun/header.jsp" %>

        <% if (errores != null) {
                for (String error : errores) {%>
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




                    <label for="especialidad">Especialidad</label>
                    <select name="especialidad" id="especialidad">
                        <option value="999" selected>Todos</option>
                        <option value="1"></option>
                        <option value="2"></option>
                        <option value="3"></option>
                        <option value="4">Dermatologia</option>
                        <option value="5">Geriatri</option>
                    </select>



                    <label for="ciudades">Ciudades</label>
                    <select name="ciudades" id="ciudades">
                        <option value="999" selected>Todos</option>
                        <option value="1"></option>
                        <option value="2"></option>
                        <option value="3"></option>
                        <option value="4">San josé</option>
                        <option value="5">Cartago</option>
                    </select>

                    <input type="submit" class="boton" name="accion" value="Sign in">
                </fieldset>
            </form>

        </section>


        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>
