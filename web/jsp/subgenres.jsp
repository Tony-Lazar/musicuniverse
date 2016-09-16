<%@ page import="com.lanzdev.classes.DB" %>
<%@ page import="com.lanzdev.classes.essences.Nameable" %>
<%@ page import="java.util.HashSet" %>
<%--
  Created by IntelliJ IDEA.
  User: Tony
  Date: 06.09.2016
  Time: 21:43
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

        <h1>Subgenres of <%=request.getParameter("genre")%></h1>

        <div class="main-col">
            <ul>
                <%
                    DB db = DB.getDB();
                    HashSet<Nameable> genres = db.getSubgenresByGenre(request.getParameter("genre"));
                    for (Nameable genre : genres) {
                %>
                <li>
                    <form action="/bands" method="post">
                        <input title="<%=genre.getName()%>" type="submit" name="subgenre" value="<%=genre.getName()%>">
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
