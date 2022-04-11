<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <%@ include file="/comun/head.jsp" %>
    <body>
        <%@ include file="/comun/header.jsp" %>

        <main class="contenedor">

            <div class="dos-columnas">
                <img class="foto-doctor max-width40" loading="lazy" src="img/blog1.jpg" alt="anuncio">
                <div class="contenido-doctor">
                    <h3>Jose Ramirez Cerdas</h3>
                    <p class="precio">$300</p>
                    <p>San Jose</p>
                    <p>Ortopedico</p>
                </div>
            </div>

            <div class="horario-extenso">
                <div class="move-horario">
                    <img src="img//back.svg" alt="back" loading="lazy">
                </div>

                <div class="horario-doctor">
                    <div class="dia-doctor">
                        <p>Miercoles</p>
                        <ul>
                            <li>14:00</li>
                            <li>14:30</li>
                            <li>15:00</li>
                            <li>15:30</li>
                        </ul>
                    </div>
                    <div class="dia-doctor">
                        <p>Jueves</p>
                        <ul>
                            <li>14:00</li>
                            <li>14:30</li>
                            <li>15:00</li>
                            <li>15:30</li>
                        </ul>
                    </div>
                    <div class="dia-doctor">
                        <p>Viernes</p>
                        <ul>
                            <li>14:00</li>
                            <li>14:30</li>
                            <li>15:00</li>
                            <li>15:30</li>
                        </ul>
                    </div>
                </div>

                <div class="move-horario">
                    <img src="img//next.svg" alt="next" loading="lazy">
                </div>
            </div>

        </main>

        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>
