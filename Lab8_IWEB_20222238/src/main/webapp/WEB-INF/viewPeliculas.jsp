<%@ page import="com.example.lab8_iweb_20222238.Beans.PeliculaBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.DecimalFormat" %>
<%
  PeliculaBean pelicula = (PeliculaBean) request.getAttribute("pelicula");
%>
<% DecimalFormat completo = new DecimalFormat("#,###"); %>
<html>
<head>
  <title><%= pelicula.getTitulo() %></title>
</head>
<body>
<h1>Película número <%= pelicula.getIdPelicula() %></h1>
<a href="<%request.getContextPath();%>/PeliculaServlet?action=guardar"><button type="submit">Guardar información</button></a>
<table border="1">
  <tr>
    <th>Título</th>
    <td><input type="text" value="<%= pelicula.getTitulo() %>"></td>
  </tr>
  <tr>
    <th>Director</th>
    <td><input type="text" value="<%= pelicula.getDirector() %>"></td>
  </tr>
  <tr>
    <th>Año Publicación</th>
    <td><input type="text" value="<%= pelicula.getAnoPublicacion() %>"></td>
  </tr>
  <tr>
    <th>Rating</th>
    <td><input type="text" value="<%= String.valueOf(pelicula.getRating()) %>">/10</td>
  </tr>
  <tr>
    <th>Box Office</th>
    <td>$ <input type="text" value="<%= completo.format(pelicula.getBoxOffice()) %>"></td>
  </tr>
  <tr>
    <th>Actores</th>
    <td><a href="actorServlet?idPelicula=<%= pelicula.getIdPelicula()%>">Regresar</a></td>
  </tr>
</table>
<br>
<a href="PeliculaServlet">Volver a la lista de películas</a>
</body>
</html>
