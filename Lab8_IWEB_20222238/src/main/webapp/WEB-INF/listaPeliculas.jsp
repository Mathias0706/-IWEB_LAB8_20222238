<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab8_iweb_20222238.Beans.PeliculaBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<PeliculaBean> lista = (ArrayList) request.getAttribute("lista");%>
<%@ page import="java.text.DecimalFormat" %>
<% DecimalFormat completo = new DecimalFormat("#,###"); %>
<html>
<head>
  <title>Películas</title>
</head>
<body>
<h1>Lista de Películas</h1>
<form action="PeliculaServlet" method="get">
  <input type="text" name="nombrePelicula" placeholder="Buscar por nombre de película"
         value="<%= request.getParameter("nombrePelicula") != null ? request.getParameter("nombrePelicula") : "" %>">
  <a href="<%request.getContextPath();%>/PeliculaServlet?action=buscar"><button type="submit">Buscar</button></a>
</form>
<table border="1">
  <tr>
    <th>Título</th>
    <th>Director</th>
    <th>Año Publicación</th>
    <th>Rating</th>
    <th>BoxOffice</th>
    <th>Género</th>
    <th>Actores</th>
    <th>Accionable</th>
  </tr>
  <% for (PeliculaBean peliculas : lista) { %>
  <tr>
    <td><a href="detalleServlet?idPelicula=<%= peliculas.getIdPelicula() %>"><%= peliculas.getTitulo() %></a></td>
    <td><%= peliculas.getDirector() %></td>
    <td><%= peliculas.getAnoPublicacion() %></td>
    <td><%= String.valueOf(peliculas.getRating()) %>/10</td>
    <td>$ <%= completo.format(peliculas.getBoxOffice()) %></td>
    <td><%= peliculas.getGenero() %></td>
    <td><a href="actorServlet?idPelicula=<%= peliculas.getIdPelicula() %>">Ver actores</a></td>
    <td><a href="PeliculaServlet?action=eliminar" onclick="confirmDelete(<%= peliculas.getIdPelicula() %>)">Eliminar</a></td>
  </tr>
  <% } %>
</table>
</body>

<script>
  function confirmDelete(idPelicula) {
    // Muestra un cuadro de confirmación
    if (confirm("¿Estás seguro de que deseas eliminar esta película?")) {
      // Si el usuario confirma, redirige al servlet con el parámetro id
      window.location.href = "PeliculaServlet?action=eliminar&idPelicula=" + idPelicula;
    }
  }
</script>
</html>