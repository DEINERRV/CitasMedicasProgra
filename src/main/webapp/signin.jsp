<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Citas Medicas/Log in</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <%@ include file="/header.jsp" %>

    <section class="contenedor">
        <h1 class="centrado">Sign In</h1>

        <form action="" class="formulario">
            <fieldset>
                <label for="id">ID del Usuario</label>
                <input type="text" placeholder="ID del Usuario" id="id">

                <label for="contrasena">Contrasena del Usuario</label>
                <input type="password" placeholder="Contrasena del Usuario" id="contrasena">

                <div class="forma-ingreso">
                    <label for="paciente">Paciente</label>
                    <input name="tipo-ingreso" type="radio" value="paciente" id="paciente">
                    
                    <label for="doctor">Doctor</label>
                    <input name="tipo-ingreso" type="radio" value="doctor" id="doctor">
                </div>

                <input type="submit" class="boton" value="Registrar">
            </fieldset>
        </form>
    </section>


    <%@ include file="/footer.jsp" %>
</body>
</html>