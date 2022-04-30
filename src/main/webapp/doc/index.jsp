<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String mensaje = (String) request.getAttribute("mensaje"); %>

<!DOCTYPE html>
<html>
    <%@ include file="/comun/head.jsp" %>
    
    <body>
        <%@ include file="/comun/header.jsp" %>
        
        <h1>DOCTOR</h1>
        
        <p style="color:green;"><%=mensaje%></p>
        
        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>

