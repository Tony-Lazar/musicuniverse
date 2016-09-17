<%@ page import="com.lanzdev.classes.DB" %>
<%@ page import="com.lanzdev.classes.essences.Genre" %>
<%@ page import="com.lanzdev.classes.essences.Nameable" %>
<%@ page import="java.util.HashSet" %>
<%--
  Created by IntelliJ IDEA.
  User: Tony
  Date: 05.09.2016
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Music Universe</title>
    <link rel="stylesheet" href="css/main.css">
    <script type="text/javascript" src="js/jquery-3.1.0.js"></script>
    <script src='//cdn.tinymce.com/4/tinymce.min.js'></script>
    <script>
        tinymce.init({
            selector: '#mytextarea'
        })
    </script>
</head>
<body>


<div class="container">

    <div class="navbar"></div>

    <div class="content">

        <h2>Main Genres</h2>

        <div class="main-col">
            <ul>
                <%
                    DB db = DB.getDB();
                    HashSet<Genre> genres = db.getGenres();
                    for (Genre genre : genres) {
                %>
                <li>
                    <form action="/subgenres" method="post">
                        <input type="hidden" name="id" value="<%=genre.getId()%>">
                        <input title="<%=genre.getName()%>" type="submit" name="name" value="<%=genre.getName()%>">
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
