<%@ page import="com.lanzdev.classes.DB" %>
<%@ page import="com.lanzdev.classes.essences.Album" %>
<%@ page import="java.util.HashSet" %><%--
  Created by IntelliJ IDEA.
  User: Tony
  Date: 08.09.2016
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Music Universe Admin Panel</title>
    <link rel="stylesheet" href="../../css/main.css">
    <script type="text/javascript" src="../../js/jquery-3.1.0.js"></script>
</head>
<body>

<div class="container">

    <div class="navbar"></div>

    <div class="content">

        <h1>Albums Panel</h1>

        <div class="right-col">
            <div class="main-col table-content">
                <%
                    DB db = DB.getDB();
                    HashSet<Album> albums = db.getAlbums();
                    for (Album album : albums) {
                %>
                <form action="" method="post">
                    <table>
                        <tr>
                            <td><input type="submit" value="edit"></td>
                            <td><input type="text" name="id" value="<%=album.getId()%>" readonly></td>
                            <td><input type="text" name="name" value="<%=album.getName()%>" readonly></td>
                            <td><input type="text" name="year" value="<%=album.getYear()%>" readonly></td>
                            <td><input type="text" name="history" value="<%=album.getHistory()%>" readonly></td>
                            <td><input type="submit" value="remove"></td>
                        </tr>
                    </table>
                </form>
                <% } %>
            </div>
        </div>

    </div>

</div>

<script>
    $(document).ready(function () {
        $('.container .navbar').load('/jsp/adminPanel/navbar.jsp .menu');
    });
</script>
</body>
</html>
