<%@ page import="com.lanzdev.classes.DB" %>
<%@ page import="com.lanzdev.classes.essences.Album" %>
<%@ page import="java.util.HashSet" %>
<%--
  Created by IntelliJ IDEA.
  User: Tony
  Date: 07.09.2016
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Music Universe</title>
    <link rel="stylesheet" href="../css/main.css">
    <script type="text/javascript" src="../js/jquery-3.1.0.js"></script>
</head>
<body>

<div class="container">

    <div class="navbar"></div>

    <div class="content">

        <h1>Albums from <%=request.getParameter("band")%></h1>

        <div class="main-col">
            <ul>
                <%
                    DB db = DB.getDB();
                    HashSet<Album> albums = db.getAlbumsByBand(request.getParameter("band"));
                    for (Album album : albums) {
                %>
                <li>
                    <form action="<%=album.getUrl()%>" method="post" target="_blank">
                        <input style="
                                background:url(<%=album.getImagePath()%>) no-repeat;
                                background-size: cover;"
                               title="<%=album.getName()%> (<%=album.getYear()%>)"
                               type="submit" name="album" value="<%=album.getName()%>"
                               class="album">
                    </form>
                </li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>


</div>

<script>
    $(document).ready(function () {
        $('.container .navbar').load('/jsp/secondary/navbar.jsp .menu');
    });
</script>
</body>
</html>
