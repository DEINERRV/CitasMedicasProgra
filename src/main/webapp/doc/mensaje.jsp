<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <%@ include file="/comun/head.jsp" %>
    <body>
        <%@ include file="/comun/header.jsp" %>
        
        <div class="contenedor">
            <h1>Su solicitud para Formar parte activa de esta plataforma ha sido enviada.Solo falta que algun admin la acepte</h1>
            <div class="alinear-izquierda">
                <a class="boton" href="${pageContext.request.contextPath}/index.jsp">Entendido</a>
            </div>
        </div>
        
        

        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>
