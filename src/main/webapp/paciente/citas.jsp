<%@page import="Modelo.Cita"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Cita> citas = (List) request.getAttribute("citas");%>


<!DOCTYPE html>
<html>
    <%@ include file="/comun/head.jsp" %>
    <body>
        <%@ include file="/comun/header.jsp" %>

        <main class="contenedor">
            <h1>Mis Citas</h1>

            <div>
                <% for(Cita c:citas){ %>
                <div class="doctor ">
                    <img class="foto-doctor" loading="lazy" src="${pageContext.request.contextPath}/img/<%=c.getDoc().getUsuario().getId()%>.jpg" 
                         onerror="this.src='${pageContext.request.contextPath}/img/noFoto.png';" />
                    
                    <div class="contenido-doctor">
                        <h3><%= c.getDoc().getUsuario().getNombre()%> </h3>
                        <p class="precio">$<%= c.getDoc().getPrecio()%></p>
                        <p><%=c.getDoc().getCiudad().getNombre()%></p>
                        <p><%=c.getDoc().getEspecialidad().getNombre()%></p>
                        <p><%=c.getDia()%></p>
                        <p><%=c.getHora()%></p>
                    </div>
                    
                    <div> 
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Perspiciatis ea nulla consectetur
                    officiis omnis expedita quibusdam tempore accusamus pariatur sapiente, optio quae? Optio,
                    asperiores. Ad facere eum accusamus totam est?</p>
                    </div>
                </div>
                <%}%>
            </div>
        </main>

        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>
