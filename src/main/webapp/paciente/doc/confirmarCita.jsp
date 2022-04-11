<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <%@ include file="/comun/head.jsp" %>

    <body>
        <%@ include file="/comun/header.jsp" %>

        <div class="doctor contenedor">
            <img class="foto-doctor" loading="lazy" src="../img/blog1.jpg" alt="anuncio">

            <div class="contenido-doctor">
                <h3>Jose Ramirez Cerdas</h3>
                <p class="precio">$300</p>
                <p>San Jose</p>
                <p>Ortopedico</p>
                <p>15:30</p>
            </div>
            <div class="inline-block padding1">
                <a class="boton" href="#">Confirmar Cita</a>
            </div>
            <div class="inline-block padding1">
                <a class="boton" href="#">Cancelar</a>
            </div>
        </div>

        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>
