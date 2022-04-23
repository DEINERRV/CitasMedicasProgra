<%@page import="java.time.LocalDate"%>
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
            <h1>Citas</h1>

            <div class="contenedor-doctores">
                <% for (Cita c : citas) {%>
                <div class="doctor">
                    <img class="foto-doctor" loading="lazy" src="${pageContext.request.contextPath}/img/<%=c.getPac().getId()%>.jpg" 
                         onerror="this.src='${pageContext.request.contextPath}/img/noFoto.png';" />

                    <div class="contenido-doctor">
                        <h3><%= c.getPac().getNombre()%> </h3>
                        <p><%=c.getDoc().getCiudad().getNombre()%></p>
                        <p><%=c.getPac().getTelefono()%></p>
                        <p><%=c.getPac().getCorreo()%></p>
                        <p><%=c.getDia()%></p>
                        <p><%=c.getHora()%></p>
                    </div>

                    <div class="formulario"> 
                        <form action="#" >
                            <textarea id="nota" name="nota" rows="8" cols="50" placeholder="Inserte notas de la cita"></textarea>
                            <div class="alinear-derecha">
                                <input type="submit" class="boton" name="accion" value="OK">
                            </div>
                        </form>
                    </div>
                    
                    <% if(LocalDate.now().isAfter(c.getDia())){%>
                    <div class="inline-block padding1">
                        <a class="boton" href="DocCitasServlet?accion=cancelar&dia=<%=c.getDia()%>&hora=<%=c.getHora()%>">Cancelar Cita</a>
                    </div>    
                    <%}%>

                </div>
                <%}%>
            </div>
        </main>

        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>
