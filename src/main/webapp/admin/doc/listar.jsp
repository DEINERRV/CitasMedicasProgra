<%@page import="java.util.List"%>
<%@page import="Modelo.Doctor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Doctor> doctores = (List) request.getAttribute("doctores");
%>

<!DOCTYPE html>
<html>
    <%@ include file="/comun/head.jsp" %>
    
    <body>
        <%@ include file="/comun/header.jsp" %>
       
        <p><%= doctores.size() %> </p>
        
        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>
