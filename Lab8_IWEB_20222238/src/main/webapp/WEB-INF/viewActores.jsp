<%@ page import="com.example.lab8_iweb_20222238.Beans.ActorBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ActorBean actor = (ActorBean) request.getAttribute("actor");
%>
<html>
<head>
    <title>Crear un actor</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Nombre</th>
        <td><input type="text"></td>
    </tr>
    <tr>
        <th>Apellido</th>
        <td><input type="text"></td>
    </tr>
    <tr>
        <th>Año de Nacimiento</th>
        <td><input type="text"></td>
    </tr>
    <tr>
        <th>Oscar</th>
        <td><select name="opcion" id="opcion">
            <option value="si">Sí</option>
            <option value="no">No</option>
        </select></td>
    </tr>
</table>
<a href="actorServlet?idActor=<%= actor.getIdActor() %>">Crear Actor</a>
</body>
</html>