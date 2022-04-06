<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Citas Medicas</title>
    <link rel="stylesheet" href="../css/normalize.css">
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <%@ include file="/header.jsp" %>
    
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

    <%@ include file="/footer.jsp" %>
</body>
</html>