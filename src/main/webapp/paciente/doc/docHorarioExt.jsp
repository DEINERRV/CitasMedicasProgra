<%@page import="Modelo.Doctor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Doctor doc = (Doctor) request.getAttribute("doc");%>

<!DOCTYPE html>
<html>
    <%@ include file="/comun/head.jsp" %>
    <body>
        <%@ include file="/comun/header.jsp" %>

        <main class="contenedor">

            <div class="dos-columnas">
                <img class="foto-doctor" loading="lazy" src="${pageContext.request.contextPath}/img/<%=doc.getUsuario().getId()%>.png" 
                         onerror="this.src='${pageContext.request.contextPath}/img/noFoto.png';" />
                
                <div class="contenido-doctor">
                    <h3><%=doc.getUsuario().getNombre()%></h3>
                    <p class="precio">$<%=doc.getPrecio()%></p>
                    <p><%=doc.getCiudad().getNombre()%></p>
                    <p><%=doc.getEspecialidad().getNombre()%></p>
                </div>
            </div>

            <div class="horario-extenso">
                <div class="move-horario">
                    <a href="/CitasMedicas/DocHorExtServlet?accion=prev&id-doc=<%= doc.getUsuario().getId()%>&dia-base=<%=doc.getSlots().get(0).getDia()%>">
                        <img src="img//back.svg" alt="back" loading="lazy">
                    </a>
                </div>

                <div class="horario-doctor">
                        <% for(int i=0;i<doc.getSlots().size();i++){ %>
                        <div class="dia-doctor">
                            <p><%= doc.getSlots().get(i).getDia() %></p>
                            <ul>
                                <% boolean flag = true; %>
                                <% do{ %>
                                <% if(doc.getSlots().get(i).getPac()==null){ %>
                                <li><a href="PacReservarServlet?accion=show&id-doc=<%= doc.getUsuario().getId()%>&dia=<%= doc.getSlots().get(i).getDia()%>&hora=<%= doc.getSlots().get(i).getHora() %>"><%= doc.getSlots().get(i).getHora() %></a></li>
                                <% }else{ %>
                                <li><span><%= doc.getSlots().get(i).getHora() %></span></li>
                                <% } %>
                                <% if(i+1==doc.getSlots().size()){ flag = false; %>
                                <% }else if(!doc.getSlots().get(i).getDia().equals(doc.getSlots().get(i+1).getDia())){flag = false; %>
                                <% }else{ i++; } %>
                                <% }while(flag); %>
                            </ul>
                        </div>
                        <% } %>
                    </div>

                <div class="move-horario">
                    <a href="/CitasMedicas/DocHorExtServlet?accion=next&id-doc=<%= doc.getUsuario().getId()%>&dia-base=<%=doc.getSlots().get(doc.getSlots().size()-1).getDia()%>">
                        <img src="img//next.svg" alt="next" loading="lazy">
                    </a>
                </div>
            </div>

        </main>

        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>
