<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab8_iweb_20222238.Beans.ActorBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab8_iweb_20222238.Beans.PeliculaBean" %>
<%
  ArrayList<ActorBean> lista = (ArrayList<ActorBean>) request.getAttribute("lista");
%>
<%
  PeliculaBean pelicula = (PeliculaBean) request.getAttribute("pelicula");
%>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1> pelicula.getTitulo() </h1>
<table border="1">
  <tr>
    <th>idActor</th>
    <th>Nombre</th>
    <th>Apellido</th>
    <th>Año de Nacimiento</th>
    <th>Ganador Premio Oscar</th>

  </tr>
  <% for (ActorBean actores : lista){%>
  <tr>


    <td><%= actores.getIdActor() %></td>
    <td><%=actores.getNombre() %></td>
    <td><%=actores.getApellido() %></td>
    <td><%=actores.getAnoNacimiento() %></td>
    <td><%=actores.isPremioOscar()%></td>

  </tr>
  <% }%>
</table>

</body>
</html>