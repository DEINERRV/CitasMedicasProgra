<%@page import="Modelo.Especialidad"%>
<%@page import="Modelo.Ciudad"%>
<%@page import="Modelo.Cita"%>
<%@page import="Modelo.Doctor"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Doctor> doctores = (List) request.getAttribute("doctores");%>
<% List<Ciudad> ciudades = (List) request.getAttribute("ciudades");%>
<% List<Especialidad> especialidades = (List) request.getAttribute("especialidades");%>

<!DOCTYPE html>
<html>
    <%@ include file="/comun/head.jsp" %>

    <body>
        <%@ include file="/comun/header.jsp" %>
        
        
        <section class="contenedor">
        <form action="/CitasMedicas/PacDocsServlet" method="POST" class="buscar">
            <label for="especialidad">especialidad</label>
            <select name="especialidad" id="especialidad">
                <option value="999" selected>Todos</option>
                <%for(Especialidad esp:especialidades){ %>
                <option value="<%= esp.getId() %>"><%= esp.getNombre() %></option>
                <% } %>
            </select>

            <label for="ciudad">Ciudad</label>
            <select name="ciudad" id="ciudad">
                <option value="999">Todas</option>
                <% for(Ciudad ciu:ciudades){ %>
                <option value="<%= ciu.getId() %>"><%= ciu.getNombre() %></option>
                <% } %>
            </select>

            <input type="submit" name="accion" class="boton" value="buscar">
        </form>
    </section>
        
        
        <section class="contenedor seccion">
            <h2 class="centrado">CITAS MEDICAS</h2>

            <div class="contenedor-doctores">
                <% for(Doctor d:doctores){ %>
                <div class="doctor">
                    <img class="foto-doctor" loading="lazy" src="${pageContext.request.contextPath}/img/<%=d.getUsuario().getId()%>.jpg" 
                         onerror="this.src='${pageContext.request.contextPath}/img/noFoto.png';" />

                    <div class="contenido-doctor">
                        <h3><%= d.getUsuario().getNombre() %></h3>
                        <p class="precio">$<%= d.getPrecio() %></p>
                        <p><%= d.getCiudad().getNombre() %></p>
                        <p><%= d.getEspecialidad().getNombre() %></p>
                    </div>
                    
                    <div class="horario-doctor">
                        <% for(int i=0;i<d.getSlots().size();i++){ %>
                        <div class="dia-doctor">
                            <p><%= d.getSlots().get(i).getDia() %></p>
                            <ul>
                                <% boolean flag = true; %>
                                <% do{ %>
                                <% if(d.getSlots().get(i).getPac()==null){ %>
                                <li><a href="PacReservarServlet?accion=show&id-doc=<%= d.getUsuario().getId()%>&dia=<%= d.getSlots().get(i).getDia()%>&hora=<%= d.getSlots().get(i).getHora() %>"><%= d.getSlots().get(i).getHora() %></a></li>
                                <% }else{ %>
                                <li><span><%= d.getSlots().get(i).getHora() %></span></li>
                                <% } %>
                                <% if(i+1==d.getSlots().size()){ flag = false; %>
                                <% }else if(!d.getSlots().get(i).getDia().equals(d.getSlots().get(i+1).getDia())){flag = false; %>
                                <% }else{ i++; } %>
                                <% }while(flag); %>
                            </ul>
                        </div>
                        <% } %>
                    </div>

                    <div class="inline-block padding1">
                        <a class="boton" href="#">Ver Horario Extendido</a>
                    </div>
                </div>
                <% } %>


            </div>

        </section>

        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>
