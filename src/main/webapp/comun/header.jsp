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
            <a href="/CitasMedicas/PacDocsServlet?accion=show">Doctores</a>
            <a href="/CitasMedicas/PacCitasServlet?accion=show">Mis Citas</a>
            <a href="${pageContext.request.contextPath}/paciente/perfil.jsp">Mi Perfil</a>
            <% break;
                case 2: //Doctor 
                    tipoString = "Doctor";%>
            <a href="/CitasMedicas/DocCitasServlet?accion=show">Citas</a>
            <a href="/CitasMedicas/DocPerfilServlet?accion=show">Mi Perfil</a>
            <a href="${pageContext.request.contextPath}/doc/horario.jsp">Mi Horario</a>
            <% break;
                case 3: //Admin 
                    tipoString = "Admin";%>
            <a href="/CitasMedicas/AdminDocServlet?accion=listar">Doctores</a>
            <a href="/CitasMedicas/AdminDocServlet?accion=porAceptar">Por Aceptar</a>
            <a href="/CitasMedicas/AdminCiudadServlet?accion=listar">Ciudades</a>
            <a href="/CitasMedicas/AdminEspecialidadServlet?accion=listar">Especialidades</a>
            <% break;
                }%>
                <a href="/CitasMedicas/LoginServlet?accion=logout">Log Out</a>
            <% } else { %>
            <a href="#">Nosotros</a>
            <a href="/CitasMedicas/PacDocsServlet?accion=show">Doctores</a>
            <a href="${pageContext.request.contextPath}/login/logIn.jsp">Log In</a>
            <a href="${pageContext.request.contextPath}/paciente/signIn.jsp">Sign In</a>
            <% }%>
            
    </nav>

</header>