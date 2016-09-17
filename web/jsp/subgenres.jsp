<%@ page import="com.lanzdev.classes.DB" %>
<%@ page import="com.lanzdev.classes.essences.Genre" %>
<%@ page import="com.lanzdev.classes.essences.Subgenre" %>
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

        <% DB db = DB.getDB();
            Genre genre = db.getGenre(Integer.parseInt(request.getParameter("id"))); %>


        <h2>Subgenres of <%=genre.getName()%>
        </h2>

        <div class="main-col">
            <ul>
                <%
                    HashSet<Subgenre> subgenres = db.getSubgenresByGenre(Integer.parseInt(request.getParameter("id")));
                    for (Subgenre subgenre : subgenres) {
                %>
                <li>
                    <form action="/bands" method="post">
                        <input type="hidden" name="id" value="<%=subgenre.getId()%>">
                        <input title="<%=subgenre.getName()%>" type="submit" name="name"
                               value="<%=subgenre.getName()%>">
                    </form>
                </li>
                <%
                    }
                %>
            </ul>

            <div class="history">
                <h2><%= "History of " + genre.getName() %></h2>
                <%=genre.getHistory()%>
            </div>
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
