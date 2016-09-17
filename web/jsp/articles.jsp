<%@ page import="com.lanzdev.classes.DB" %>
<%@ page import="com.lanzdev.classes.essences.Article" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashSet" %>
<%--
  Created by IntelliJ IDEA.
  User: Tony
  Date: 12.09.2016
  Time: 21:51
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
</h1>

<div class="container">

    <div class="navbar"></div>

    <div class="content">

        <h2>Articles</h2>

        <div class="main-col">
            <ul class="articles-list">
                <%
                    DB db = DB.getDB();
                    HashSet<Article> articles = db.getArticles();
                    for (Article article : articles) {
                %>
                <li>
                    <form method="post" action="/article">
                        <input type="text" name="id" value="<%=article.getId()%>" hidden>
                        <input type="submit" value="<%=article.getTitle()%>">
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
