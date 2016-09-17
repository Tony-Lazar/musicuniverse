<%@ page import="com.lanzdev.classes.DB" %>
<%@ page import="com.lanzdev.classes.essences.Band" %>
<%@ page import="com.lanzdev.classes.essences.Subgenre" %>
<%@ page import="java.util.HashSet" %><%--
  Created by IntelliJ IDEA.
  User: Tony
  Date: 07.09.2016
  Time: 14:01
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
            Subgenre subgenre = db.getSubgenre(Integer.parseInt(request.getParameter("id")));%>

        <h2>Bands from <%=subgenre.getName()%>
        </h2>

        <div class="main-col">
            <ul>
                <%
                    HashSet<Band> bands = db.getBandsBySubgenre(Integer.parseInt(request.getParameter("id")));
                    for (Band band : bands) {
                %>
                <li>
                    <form action="/albums" method="post">
                        <input type="hidden" name="id" value="<%=band.getId()%>">
                        <input title="<%=band.getName()%>" type="submit" name="name" value="<%=band.getName()%>">
                    </form>
                </li>
                <%
                    }
                %>
            </ul>
            <div class="history">
                <h2><%= "History of " + subgenre.getName()%></h2>
                <%=subgenre.getHistory()%>
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
