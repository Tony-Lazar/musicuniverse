<%@ page import="com.lanzdev.classes.DB" %>
<%@ page import="com.lanzdev.classes.essences.Genre" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="static javafx.scene.input.KeyCode.L" %>
<%@ page import="com.lanzdev.classes.essences.Nameable" %><%--
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
</head>
<body>


<div class="container">
    <h1>Main Genres</h1>

    <div class="main-col">
        <ul>
            <%
                DB db = DB.getDB();
                HashSet<Nameable> genres = db.getGenres();
                for (Nameable genre : genres) {
            %>
            <li>
                <form action="/subgenre" method="post">
                    <input title="<%=genre.getName()%>" type="submit" name="genre" value="<%=genre.getName()%>"  >
                </form>
            </li>
            <%
                }
            %>
        </ul>
    </div>
</div>

</body>
</html>
