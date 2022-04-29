<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <%@ include file="/comun/head.jsp" %>

    <body>
        <%@ include file="/comun/header.jsp" %>


        <main class="contenedor">

            <h1 class="centrado">Sobre Nosotros</h1>

            <div class="contenido-nosotros">
                <img class="nosotros-img" src="${pageContext.request.contextPath}/img/nosotros.webp" alt="nosotros.img">
                <p>There are many variations of passages of Lorem Ipsum available,
                    but the majority have suffered alteration in some form, by 
                    injected humour, or randomised words which don't look even slightly
                    believable. If you are going to use a passage of Lorem Ipsum, you
                    need to be sure there isn't anything embarrassing hidden in the
                    middle of text. All the Lorem Ipsum generators on the Internet tend
                    to repeat predefined chunks as necessary, making this the first true 
                    generator on the Internet. It uses a dictionary of over 200 Latin 
                    words, combined with a handful of model sentence structures, to 
                    generate Lorem Ipsum which looks reasonable. The generated Lorem 
                    Ipsum is therefore always free from repetition, injected humour, or 
                    non-characteristic words etc.
                </p>
            </div>

            <div class="historia-nosotros">
                <h2 class="centrado">Nuestra Historia</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ac metus vitae leo mollis viverra a non metus. Nam velit mauris, lobortis at urna id, vestibulum porttitor augue. Curabitur porta ac lorem ut mattis. Fusce hendrerit, lorem nec maximus sagittis, ex tellus sodales libero, ac pulvinar nisl sapien id leo. Donec pharetra rutrum tortor, sed vulputate massa. Proin blandit, libero ut viverra dignissim, orci dolor posuere ligula, ac dapibus felis ligula in quam. Nam nulla justo, auctor id facilisis vel, fringilla et magna. Sed dolor purus, ornare quis vestibulum et, sagittis sit amet sem. Donec lobortis nibh sit amet facilisis efficitur.
                    Quisque malesuada dolor eros, vel placerat nunc tincidunt a. Suspendisse potenti. Nunc vitae ante dapibus, commodo velit in, mattis metus. Donec malesuada tempus hendrerit. Donec augue mi, dictum vitae luctus eu, iaculis ac tortor. Quisque laoreet mauris non dolor pulvinar euismod. Interdum et malesuada fames ac ante ipsum primis in faucibus. Quisque molestie pretium leo. Vivamus vitae erat sed diam varius blandit egestas in eros. Suspendisse potenti. Etiam lobortis porttitor diam, ac porta neque eleifend vitae. Fusce vitae metus at ligula varius consequat id id elit. Curabitur eu magna non tellus venenatis commodo. Donec porta nulla ut lorem convallis euismod.
                </p>
            </div>

            <section>
                <h1 class="centrado">Un Poco Sobre Nosotros</h1>

                <div class="contenido-iconos-nosotros">
                    <div class="info-iconos">
                        <img src="${pageContext.request.contextPath}/img//icono1.svg" alt="icono buscar" loading="lazy">
                        <h2>Busca</h2>
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Perspiciatis ea nulla consectetur
                            officiis omnis expedita quibusdam tempore accusamus pariatur sapiente, optio quae? Optio,
                            asperiores. Ad facere eum accusamus totam est?</p>
                    </div>
                    <div class="info-iconos">
                        <img src="${pageContext.request.contextPath}/img//icono2.svg" alt="icono agendar" loading="lazy">
                        <h2>Agenda</h2>
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Perspiciatis ea nulla consectetur
                            officiis omnis expedita quibusdam tempore accusamus pariatur sapiente, optio quae? Optio,
                            asperiores. Ad facere eum accusamus totam est?</p>
                    </div>
                    <div class="info-iconos">
                        <img src="${pageContext.request.contextPath}/img//icono3.svg" alt="icono calificar" loading="lazy">
                        <h2>Califica</h2>
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Perspiciatis ea nulla consectetur
                            officiis omnis expedita quibusdam tempore accusamus pariatur sapiente, optio quae? Optio,
                            asperiores. Ad facere eum accusamus totam est?</p>
                    </div>
                </div>

            </section>
        </main>


        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>
