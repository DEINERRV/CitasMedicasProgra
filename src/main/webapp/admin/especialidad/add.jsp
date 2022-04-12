<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <%@ include file="/comun/head.jsp" %>
    
    <body>
        <%@ include file="/comun/header.jsp" %>
        
         <section class="contenedor">
            <h1 class="centrado">Agregar Especialidad</h1>

            <form action="/CitasMedicas/AdminEspServlet" method="POST" class="formulario">
                <fieldset>
                    <label for="especialidad">Nombre de la Especialidad</label>
                    <input type="text" name="especialidad" placeholder="Nombre de la Especialidad" id="Especialidad" value="">


                    <input type="submit" class="boton" name="accion" value="registrar">
                </fieldset>
            </form>
        </section>
        
        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>
