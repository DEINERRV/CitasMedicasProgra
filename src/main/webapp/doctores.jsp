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
    
    <section class="contenedor">
        <form class="buscar" action="">
            <label for="especialidad">especialidad</label>
            <select name="especialidad" id="especialidad">
                <option value="999" selected>Todos</option>
                <option value="1">Cardiologia</option>
                <option value="2">Neumologia</option>
                <option value="3">Oftalmologia</option>
                <option value="4">Dermatologia</option>
                <option value="5">Geriatri</option>
            </select>

            <label for="ciudad">Ciudad</label>
            <select name="ciudad" id="ciudad">
                <option value="999">Todas</option>
                <option value="1">A</option>
                <option value="2">B</option>
                <option value="3">C</option>
                <option value="4">D</option>
                <option value="5">E</option>
                <option value="6">F</option>
                <option value="7">G</option>
            </select>

            <input type="submit" class="boton" value="Buscar">
        </form>
    </section>

    <section class="contenedor seccion">
        <h2 class="centrado">CITAS MEDICAS</h2>

        <div class="contenedor-doctores">

            <div class="doctor">
                <img class="foto-doctor" loading="lazy" src="img/blog1.jpg" alt="anuncio">

                <div class="contenido-doctor">
                    <h3>Jose Ramirez Cerdas</h3>
                    <p class="precio">$300</p>
                    <p>San Jose</p>
                    <p>Ortopedico</p>
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

                <div class="inline-block padding1">
                    <a class="boton" href="#">Ver Horario Extendido</a>
                </div>
            </div>

            <div class="doctor">
                <img class="foto-doctor" loading="lazy" src="img/blog1.jpg" alt="anuncio">

                <div class="contenido-doctor">
                    <h3>Jose Ramirez Cerdas</h3>
                    <p class="precio">$300</p>
                    <p>San Jose</p>
                    <p>Ortopedico</p>
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

                <div class="inline-block padding1">
                    <a class="boton" href="#">Ver Horario Extendido</a>
                </div>
            </div>

            <div class="doctor">
                <img class="foto-doctor" loading="lazy" src="img/blog1.jpg" alt="anuncio">

                <div class="contenido-doctor">
                    <h3>Jose Ramirez Cerdas</h3>
                    <p class="precio">$300</p>
                    <p>San Jose</p>
                    <p>Ortopedico</p>
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

                <div class="inline-block padding1">
                    <a class="boton" href="#">Ver Horario Extendido</a>
                </div>
            </div>

        </div>

    </section>


   
    <%@ include file="/footer.jsp" %>
</body>
</html>