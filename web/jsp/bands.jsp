<%@ page import="com.lanzdev.classes.DB" %>
<%@ page import="com.lanzdev.classes.essences.Band" %>
<%@ page import="com.lanzdev.classes.essences.Nameable" %>
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

        <h1>Bands from <%=request.getParameter("subgenre")%></h1>

        <div class="main-col">
            <ul>
                <%
                    DB db = DB.getDB();
                    HashSet<Band> bands = db.getBandsBySubgenre(request.getParameter("subgenre"));
                    for (Band band : bands) {
                %>
                <li>
                    <form action="/albums" method="post">
                        <input title="<%=band.getName()%>" type="submit" name="band" value="<%=band.getName()%>">
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
