<%@page import="Modelo.Ciudad"%>
<%@page import="Modelo.Especialidad"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<String> errores = (List<String>) request.getAttribute("errores");%>
<% List<Especialidad> especialidades = (List) request.getAttribute("especialidades");%>
<% List<Ciudad> ciudades = (List) request.getAttribute("ciudades");%>

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
                    
                    <label for="contrasena">Contrasena</label>
                    <input type="text" name="contrasena2" placeholder="Contrasena" id="contrasena2" value="">

                    <label for="nombre">Nombre y apellido</label>
                    <input type="text" name="nombre" placeholder="Nombre y apellido" id="nombre" value="">

                    <label for="telefono">Teléfono</label>
                    <input type="text" name="telefono" placeholder="Número de teléfono" id="telefono" value="">




                    <label for="especialidad">Especialidad</label>
                    <select name="especialidad" id="especialidad">
                        <%for(Especialidad esp:especialidades){ %>
                        <option value="<%= esp.getId() %>"><%= esp.getNombre() %></option>
                        <% } %>
                    </select>



                    <label for="ciudades">Ciudades</label>
                    <select name="ciudad" id="ciudad">
                        <% for(Ciudad ciu:ciudades){ %>
                        <option value="<%= ciu.getId() %>" ><%= ciu.getNombre() %></option>
                        <% } %>
                    </select>


                    <input type="submit" class="boton" name="accion" value="signinDoctor">
                </fieldset>
            </form>

        </section>


        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>
