<%@page import="Modelo.Ciudad"%>
<%@page import="Modelo.Especialidad"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Doctor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Usuario usuario1 = (Usuario) session.getAttribute("usuario");  %>
<% List<String> errores = (List<String>) request.getAttribute("errores");%>


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
        
        
        <main class="contenedor">

            <div class="subImg"> 
                <img class="foto-doctor" loading="lazy" src="${pageContext.request.contextPath}/img/<%=usuario.getId()%>.png" 
                         onerror="this.src='${pageContext.request.contextPath}/img/noFoto.png';" />
                
                <form method="POST" action="/CitasMedicas/PacPerfilServlet" enctype="multipart/form-data" name="upload">
                    <input type="file" name="imagen" accept="image/jpg, image/gif, image/png">
                    <input type="submit" name="accion" value="Upload photo"  >
                </form>
            </div>

            <form action="/CitasMedicas/PacPerfilServlet" method="POST" class="formulario">
                <fieldset>
                    
                    <label for="nombre">Nombre y apellido</label>
                    <input type="text" name="nombre" placeholder="Nombre y apellido" id="nombre" value="<%= usuario.getNombre()%>" required>

                    <label for="telefono">Teléfono</label>
                    <input type="text" name="telefono" placeholder="Número de teléfono" id="telefono" value="<%= usuario.getTelefono()%>" required>

                    <label for="correo">Correo</label>
                    <input type="text" name="correo" placeholder="Correo Electronico" id="correo" value="<%= usuario.getCorreo()%>" required>

                    

                    <input type="submit" class="boton" name="accion" value="Actualizar Datos">
                </fieldset>
            </form>


        </main>



        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>