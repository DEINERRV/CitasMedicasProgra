<%@page import="java.util.List"%>
<%@page import="Modelo.Doctor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Doctor doc = (Doctor) session.getAttribute("doc"); %>
<% List<String> errores = (List<String>) request.getAttribute("errores");%>

<!DOCTYPE html>
<html>
    <%@ include file="/comun/head.jsp" %>

    <body>
        <%@ include file="/comun/header.jsp" %>

        
        <% if (errores != null) {
            for (String error : errores) {%>
        <div class="error contenedor">
            <p>ERROR: <%= error%></p>
        </div>
        <% }
            }%>


        <form action="/CitasMedicas/DocHorarioServlet" method="POST" class="contenedor">
            <div class="horario-form "> 
                <div class="dia-form">
                    <h2>Lunes</h2>

                    <div>
                        <label for="lunes">Trabaja?</label>
                        <input name="lunes" type="checkbox" <% if(doc.getHorario().buscarDia(1)!=null){%>checked<%}%>>
                    </div>

                    <label for="1-hora-i">Hora Inicio</label>
                    <input type="time" name="1-hora-i" <% if(doc.getHorario().buscarDia(1)!=null){%>value="<%=doc.getHorario().buscarDia(1).getHora_inicio() %>"<%}%>>

                    <label for="1-hora-f">Hora Final</label>
                    <input type="time" name="1-hora-f" <% if(doc.getHorario().buscarDia(1)!=null){%>value="<%=doc.getHorario().buscarDia(1).getHora_final() %>"<%}%>>
                </div>

                <div class="dia-form">
                    <h2>Martes</h2>

                    <div>
                        <label for="martes">Trabaja?</label>
                        <input name="martes" type="checkbox" <% if(doc.getHorario().buscarDia(2)!=null){%>checked<%}%>>
                    </div>

                    <label for="2-hora-i">Hora Inicio</label>
                    <input type="time" name="2-hora-i" <% if(doc.getHorario().buscarDia(2)!=null){%>value="<%=doc.getHorario().buscarDia(2).getHora_inicio() %>"<%}%>>

                    <label for="2-hora-f">Hora Final</label>
                    <input type="time" name="2-hora-f" <% if(doc.getHorario().buscarDia(2)!=null){%>value="<%=doc.getHorario().buscarDia(2).getHora_final() %>"<%}%>>
                </div>

                <div class="dia-form">
                    <h2>Miercoles</h2>

                    <div>
                        <label for="miercoles">Trabaja?</label>
                        <input name="miercoles" type="checkbox" <% if(doc.getHorario().buscarDia(3)!=null){%>checked<%}%>>
                    </div>

                    <label for="3-hora-i">Hora Inicio</label>
                    <input type="time" name="3-hora-i" <% if(doc.getHorario().buscarDia(3)!=null){%>value="<%=doc.getHorario().buscarDia(3).getHora_inicio() %>"<%}%>>

                    <label for="3-hora-f">Hora Final</label>
                    <input type="time" name="3-hora-f" <% if(doc.getHorario().buscarDia(3)!=null){%>value="<%=doc.getHorario().buscarDia(3).getHora_final() %>"<%}%>>
                </div>

                <div class="dia-form">
                    <h2>Jueves</h2>

                    <div>
                        <label for="jueves">Trabaja?</label>
                        <input name="jueves" type="checkbox" <% if(doc.getHorario().buscarDia(4)!=null){%>checked<%}%>>
                    </div>

                    <label for="4-hora-i">Hora Inicio</label>
                    <input type="time" name="4-hora-i" <% if(doc.getHorario().buscarDia(4)!=null){%>value="<%=doc.getHorario().buscarDia(4).getHora_inicio() %>"<%}%>>

                    <label for="4-hora-f">Hora Final</label>
                    <input type="time" name="4-hora-f" <% if(doc.getHorario().buscarDia(4)!=null){%>value="<%=doc.getHorario().buscarDia(4).getHora_final() %>"<%}%>>
                </div>

                <div class="dia-form">
                    <h2>Viernes</h2>

                    <div>
                        <label for="viernes">Trabaja?</label>
                        <input name="viernes" type="checkbox" <% if(doc.getHorario().buscarDia(5)!=null){%>checked<%}%>>
                    </div>

                    <label for="5-hora-i">Hora Inicio</label>
                    <input type="time" name="5-hora-i" <% if(doc.getHorario().buscarDia(5)!=null){%>value="<%=doc.getHorario().buscarDia(5).getHora_inicio() %>"<%}%>>

                    <label for="5-hora-f">Hora Final</label>
                    <input type="time" name="5-hora-f" <% if(doc.getHorario().buscarDia(5)!=null){%>value="<%=doc.getHorario().buscarDia(5).getHora_final() %>"<%}%>>
                </div>

                <div class="dia-form">
                    <h2>Sabado</h2>

                    <div>
                        <label for="sabado">Trabaja?</label>
                        <input name="sabado" type="checkbox" <% if(doc.getHorario().buscarDia(6)!=null){%>checked<%}%>>
                    </div>

                    <label for="6-hora-i">Hora Inicio</label>
                    <input type="time" name="6-hora-i" <% if(doc.getHorario().buscarDia(6)!=null){%>value="<%=doc.getHorario().buscarDia(6).getHora_inicio() %>"<%}%>>

                    <label for="6-hora-f">Hora Final</label>
                    <input type="time" name="6-hora-f" <% if(doc.getHorario().buscarDia(6)!=null){%>value="<%=doc.getHorario().buscarDia(6).getHora_final() %>"<%}%>>
                </div>

                <div class="dia-form">
                    <h2>Domingo</h2>

                    <div>
                        <label for="domingo">Trabaja?</label>
                        <input name="domingo" type="checkbox" <% if(doc.getHorario().buscarDia(7)!=null){%>checked<%}%>>
                    </div>


                    <label for="7-hora-i">Hora Inicio</label>
                    <input type="time" name="7-hora-i" <% if(doc.getHorario().buscarDia(7)!=null){%>value="<%=doc.getHorario().buscarDia(7).getHora_inicio() %>"<%}%>>

                    <label for="7-hora-f">Hora Final</label>
                    <input type="time" name="7-hora-f" <% if(doc.getHorario().buscarDia(7)!=null){%>value="<%=doc.getHorario().buscarDia(7).getHora_final() %>"<%}%>>
                </div>
            </div>
            <input type="submit" class="boton alinear-izquierda" name="accion" value="Actualizar Horario">
        </form>



        <%@ include file="/comun/footer.jsp" %>
    </body>
</html>
