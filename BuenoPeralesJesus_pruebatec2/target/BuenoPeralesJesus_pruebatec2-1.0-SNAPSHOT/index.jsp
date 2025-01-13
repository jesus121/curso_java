<%-- 
    Document   : Index
    Created on : 8 ene 2025, 13:17:07
    Author     : jesus
--%>

<%@page import="logica.Ciudadano"%>
<%@page import="logica.Turno"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Turneros</title>
        <!-- Agregar estilos de Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">        
    </head>
    <body>
        <!-- Cuestionario para Ciudadano -->
        <div class="container mt-4">
            <h2>Formulario de ciudadano </h2>
            <form action="SvCiudadano" method="POST">
                 <div class="form-group">
                    <label for="nombre">Nombre del cuidadano:</label>
                    <input type="text" class="form-control" id="nombre_ciudadano" name="nombre_ciudadano" required>
                </div>
                <div class="form-group">
                    <label for="apellido">Apellidos del ciudadano:</label>
                    <input type="text" class="form-control" id="apellido_ciudadano" name="apellido_ciudadano" required>
                </div>
                <button type="submit" class="btn btn-primary">Guardar</button>
            </form>
            <br>
                <form action="SvCiudadano" method="GET">    
                    <button type="submit" class="btn btn-primary">Ver todos los Ciudadanos </button>
                </form>
            <br>
            <!-- Resultados en tabla Ciudadano -->
            <div class="results-table">
                <% if (request.getAttribute("ciudadanos") != null) { %>
                    <h3>Ciudadanos registrados:</h3>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>ID del ciudadano</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Ciudadano ciudadano : (List<Ciudadano>) request.getAttribute("ciudadanos")) { %>
                                <tr>
                                    <td><%= ciudadano.getId() %></td>
                                    <td><%= ciudadano.getNombre() %></td>
                                    <td><%= ciudadano.getApellido() %></td>
                            <% } %>
                        </tbody>
                    </table>
                <% } %>
            </div>
        <br>
        <!-- Cuestionario para Turno -->
        <div class="container mt-4">
            <h2>Formulario de turno </h2>
            <form action="SvTurno" method="POST">
                <div class="form-group">
                    <label for="nombre">Número del turno:</label>
                    <input type="text" class="form-control" id="numero_turno" name="numero_turno" required>
                </div>
                <div class="form-group">
                    <label for="fecha">Fecha:</label>
                    <input type="date" class="form-control" id="fecha_turno" name="fecha_turno" required>
                </div>
                <div class="form-group">
                    <label for="descripcion">Motivo del turno :</label>
                    <textarea type="text" class="form-control" id="descripcion_turno" name="descripcion_turno"></textarea>
                </div>
                <div class="form-group">
                    <label for="nombre">Id del ciudadano:</label>
                    <input type="text" class="form-control" id="id_ciudadano" name="id_ciudadano" required>
                </div>
                <div class="form-group">
                    <label>
                        Estado del turno :
                        <select id="estado_turno" name="estado_turno">
                            <option value="en espera">En espera</option>
                            <option value="ya atendido">Ya atendido</option>
                        </select>
                    </label>
                </div>
                 </div>
                <button type="submit" class="btn btn-primary">Guardar</button>
            </form>
            <br>
            <br>
                <form action="SvTurno" method="GET">    
                    <button type="submit" class="btn btn-primary">Ver todos los Turnos </button>
                </form>
            <br>
            <!-- Resultados en tabla Turno -->
            <div class="results-table">
                <% if (request.getAttribute("turnos") != null) { %>
                    <h3>Turnos registrados:</h3>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Número del turno</th>
                                <th>Fecha</th>
                                <th>Descripción</th>
                                <th>Id del Ciudadano</th>
                                <th>Estado</th>
                                <th>Opcion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Turno turno : (List<Turno>) request.getAttribute("turnos")) { %>
                                <tr>
                                    <td><%= turno.getNumero() %></td>
                                    <td><%= turno.getFecha() %></td>
                                    <td><%= turno.getDescripcion() %></td>
                                    <td><%= turno.getCiudadano().getId() %></td>
                                    <td><%= turno.getEstado() %></td>
                                    <td>
                                        <form name="eliminar" id="eliminar" action="SvTurnoEliminar" method="POST">
                                            <button type="submit" class="btn btn-primary">Elimiar</button>
                                            <input type="hidden" name="id" value="<%= turno.getId() %>"> 
                                        </form>
                                    </td>
                            <% } %>
                        </tbody>
                    </table>
                <% } %>
            </div>
        <br>
        <!-- Filtro por fecha -->
        <h2>Filtrado de turno </h2>
        <form action="SvFiltradoTurnos" method="GET"> 
            <div class="form-group">
                <label for="fecha">Fecha:</label>
                <input type="date" class="form-control" id="fecha_turno_filtrado" name="fecha_turno_filtrado" required>
            </div>
            <br>
            <div class="form-group">
                <input type="radio" value="ya atendido" name="estado_turno_filtrado">
                    <label for="selector1">Ya atendido</label>
                    <input type="radio" value="en espera" name="estado_turno_filtrado">
                    <label for="selector2">En espera</label>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Ver Turnos filtrados </button>
            </div>    
        </form>
        <div class="results-table">
                <% if (request.getAttribute("turnosFiltrados") != null) { %>
                    <h3>Turnos registrados:</h3>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Número del turno</th>
                                <th>Fecha</th>
                                <th>Descripción</th>
                                <th>Estado</th>
                                <th>Id del Ciudadano</th>
                                <th>Nombre Ciudadano</th>
                                <th>Apellido Ciudadano</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Turno turno : (List<Turno>) request.getAttribute("turnosFiltrados")) { %>
                                <tr>
                                    <td><%= turno.getNumero() %></td>
                                    <td><%= turno.getFecha() %></td>
                                    <td><%= turno.getDescripcion() %></td>
                                    <td><%= turno.getEstado() %></td>
                                    <td><%= turno.getCiudadano().getId() %></td>
                                    <td><%= turno.getCiudadano().getNombre() %></td>
                                    <td><%= turno.getCiudadano().getApellido() %></td>
                                    <td>
                                    </td>
                            <% } %>
                        </tbody>
                    </table>
                <% } %>
            </div>
        
    </body>
</html>
