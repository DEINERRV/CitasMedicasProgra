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
            <a href="#">Doctores</a>
            <a href="#">Mis Citas</a>
            <% break;
                case 2: //Doctor 
                    tipoString = "Doctor";%>
            <a href="#">Citas</a>
            <% break;
                case 3: //Admin 
                    tipoString = "Admin";%>
            <a href="AdminDocServlet?accion=listar">Doctores</a>
            <a href="AdminDocServlet?accion=porAceptar">Por Aceptar</a>
            <a href="#">Ciudades</a>
            <a href="#">Especialidades</a>
            <% break;
                }%>
                <a href="#"><%= usuario.getNombre() %> / <%= tipoString %></a>
                <a href="LoginServlet?accion=logout">Log Out</a>
            <% } else { %>
            <a href="nosotros.html">Nosotros</a>
            <a href="doctores.html">Doctores</a>
            <a href="LoginServlet?accion=show">Log In</a>
            <a href="Sign.html">Sign In</a>
            <% }%>
            <div class="dropdown">
                <a href="#" class="nav-link dropdown-toogle" data-toggle="dropdown">Salir</a>
                <div class="dropdown-menu">
                    <a href="#"><img src="img/blog1.jpg" alt="foto perfil" height="80"/></a>
                    <a href="#">JUAN / ADMIN </a>
                </div>
            </div>
        </div>
            
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </nav>

</header>