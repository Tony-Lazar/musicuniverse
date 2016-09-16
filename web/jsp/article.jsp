<%@ page import="com.lanzdev.classes.DB" %>
<%@ page import="com.lanzdev.classes.essences.Article" %><%--
  Created by IntelliJ IDEA.
  User: Tony
  Date: 13.09.2016
  Time: 15:36
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
    <%
        DB db = DB.getDB();
        System.out.println(request.getParameter("id"));
        Article article = db.getArticle(Integer.parseInt(request.getParameter("id")));
        System.out.println(article.getId());
    %>

    <div class="navbar"></div>

    <div class="content">

        <div class="main-col article">

            <h1><%=article.getTitle()%></h1>

            <%=article.getContent()%>

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
