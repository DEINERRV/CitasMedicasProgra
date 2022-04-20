<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Usuario usuario = (Usuario) session.getAttribute("usuario");  %>

<header class="header">

    <nav class="navegacion">
        <a href="#">
            <h2 class="logo">Citas<span>Medicas</span></h1>
        </a>
        <div class="navegacion-links">
            <% if (usuario != null) {
                    int tipo = usuario.getTipo();
                    String tipoString = " ";
                    switch (tipo) {
                        case 1:
                            tipoString = "Paciente";//Paciente %> 
            <a href="PacDocsServlet?accion=show">Doctores</a>
            <a href="#">Mis Citas</a>
            <% break;
                case 2: //Doctor 
                    tipoString = "Doctor";%>
            <a href="#">Citas</a>
            <a href="DocPerfilServlet?accion=show">Mi Perfil</a>
            <% break;
                case 3: //Admin 
                    tipoString = "Admin";%>
            <a href="AdminDocServlet?accion=listar">Doctores</a>
            <a href="AdminDocServlet?accion=porAceptar">Por Aceptar</a>
            <a href="AdminCiudadServlet?accion=listar">Ciudades</a>
            <a href="AdminEspecialidadServlet?accion=listar">Especialidades</a>
            <% break;
                }%>
                <a href="LoginServlet?accion=logout">Log Out</a>
            <% } else { %>
            <a href="#">Nosotros</a>
            <a href="PacDocsServlet?accion=show">Doctores</a>
            <a href="${pageContext.request.contextPath}/login/logIn.jsp">Log In</a>
            <a href="${pageContext.request.contextPath}/paciente/signIn.jsp">Sign In</a>
            <% }%>
            
    </nav>

</header>