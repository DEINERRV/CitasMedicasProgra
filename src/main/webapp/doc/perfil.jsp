<%@page import="Modelo.Ciudad"%>
<%@page import="Modelo.Especialidad"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Doctor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Usuario usuario1 = (Usuario) session.getAttribute("usuario");  %>
<% Doctor doc = (Doctor) session.getAttribute("doc"); %>
<% List<Especialidad> especialidades = (List) request.getAttribute("especialidades");%>
<% List<Ciudad> ciudades = (List) request.getAttribute("ciudades");%>
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
        
        
        <main class="contenedor">

            <div class="subImg"> 

                <form method="POST" action="/CitasMedicas/DocPerfilServlet" enctype="multipart/form-data" name="upload">
                    <input type="file" name="imagen" accept="image/jpg, image/gif, image/png">
                    <input type="submit" name="accion" value="Upload photo"  >
                </form>
            </div>

            <form action="/CitasMedicas/DocPerfilServlet" method="POST" class="formulario">
                <fieldset>
                    
                    <label for="nombre">Nombre y apellido</label>
                    <input type="text" name="nombre" placeholder="Nombre y apellido" id="nombre" value="<%= usuario.getNombre()%>">

                    <label for="telefono">Teléfono</label>
                    <input type="text" name="telefono" placeholder="Número de teléfono" id="telefono" value="<%= usuario.getTelefono()%>">

                    <label for="correo">Correo</label>
                    <input type="text" name="correo" placeholder="Correo Electronico" id="telefono" value="<%= usuario.getCorreo()%>">

                    <label for="precio">Precio por Consulta</label>
                    <input type="number" name="precio" id="telefono" value="<%= doc.getPrecio()%>">

                    <label for="especialidad">Especialidad</label>
                    <select name="especialidad" id="especialidad">
                        <%for (Especialidad esp : especialidades) {%>
                        <option value="<%= esp.getId()%>"  <% if (esp.getId()==doc.getEspecialidad().getId()) { %> selected <%}%>><%= esp.getNombre()%></option>
                        <% } %>
                    </select>


                    <label for="ciudades">Ciudades</label>
                    <select name="ciudad" id="ciudad">
                        <% for (Ciudad ciu : ciudades) {%>
                        <option value="<%= ciu.getId()%>" <%if (ciu.getId()==doc.getCiudad().getId()) { %> selected <%}%> ><%= ciu.getNombre()%></option>
                        <% }%>
                    </select>

                    <input type="submit" class="boton" name="accion" value="Actualizar Datos">
                </fieldset>
            </form>


        </main>



        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>
