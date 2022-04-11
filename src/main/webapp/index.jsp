<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
    
<%@ include file="/comun/head.jsp" %>

<body>
    <%@ include file="/comun/header.jsp" %>
    
    <section>
        <h1 class="centrado">Un Poco Sobre Nosotros</h1>

        <div class="contenido-iconos-nosotros">
            <div class="info-iconos">
                <img src="/img//icono1.svg" alt="icono buscar" loading="lazy">
                <h2>Busca</h2>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Perspiciatis ea nulla consectetur
                    officiis omnis expedita quibusdam tempore accusamus pariatur sapiente, optio quae? Optio,
                    asperiores. Ad facere eum accusamus totam est?</p>
            </div>
            <div class="info-iconos">
                <img src="/img//icono2.svg" alt="icono agendar" loading="lazy">
                <h2>Agenda</h2>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Perspiciatis ea nulla consectetur
                    officiis omnis expedita quibusdam tempore accusamus pariatur sapiente, optio quae? Optio,
                    asperiores. Ad facere eum accusamus totam est?</p>
            </div>
            <div class="info-iconos">
                <img src="/img//icono3.svg" alt="icono calificar" loading="lazy">
                <h2>Califica</h2>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Perspiciatis ea nulla consectetur
                    officiis omnis expedita quibusdam tempore accusamus pariatur sapiente, optio quae? Optio,
                    asperiores. Ad facere eum accusamus totam est?</p>
            </div>
        </div>

    </section>


    <section class="contenedor dos-columnas">
        <div>
            <h2>Estas Buscando un Doctor?</h2>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Alias reiciendis dicta, repellendus impedit aut accusantium excepturi! Provident ad ullam ducimus amet, error quis? Animi labore delectus incidunt illo, culpa similique.</p>
            <a class="inline-block boton" href="doctores.html">Ver Doctores</a>
        </div>
        <div>
            <img src="img/medicos.webp" alt="imagen medicos">
        </div>
    </section>


    <section class="seccion imagen-contacto">
        <h2>Eres Doctor y quieres formar parte de esta Plataforma?</h2>
        <p>Llena el formulario de registro y un asesor se pondra en contacto contigo a la brevedad</p>
        <a class="boton" href="signin.html">Sign In</a>
    </section>



    <%@ include file="/comun/footer.jsp" %>
    
</body>
</html>