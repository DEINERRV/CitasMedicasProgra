<%@page import="Modelo.Ciudad"%>
<%@page import="Modelo.Especialidad"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<String> errores = (List<String>) request.getAttribute("errores");
   String id = (String) request.getAttribute("id");
   String nom = (String) request.getAttribute("nom");
   String contra = (String) request.getAttribute("contra");
   String contra2 = (String) request.getAttribute("contra2");
   String tel = (String) request.getAttribute("tel");
%>
<% List<Especialidad> especialidades = (List) request.getAttribute("especialidades");%>
<% List<Ciudad> ciudades = (List) request.getAttribute("ciudades");%>

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


                    <input type="submit" class="boton" name="accion" value="signin como Doctor">
                </fieldset>
            </form>

        </section>


        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>
