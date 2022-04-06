<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Citas Medicas</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <%@ include file="/header.jsp" %>

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
    
    
    
    <%@ include file="/footer.jsp" %>
</body>
</html>