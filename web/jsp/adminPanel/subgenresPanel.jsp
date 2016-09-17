<%@ page import="com.lanzdev.classes.DB" %>
<%@ page import="com.lanzdev.classes.essences.Subgenre" %>
<%@ page import="java.util.HashSet" %>
<%--
  Created by IntelliJ IDEA.
  User: Tony
  Date: 08.09.2016
  Time: 16:07
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

        <h1>Subgenres Panel</h1>

        <div class="right-col">
            <div class="main-col table-content">
                <form action="/addSubgenre" method="get" class="header">
                    <table>
                        <tr>
                            <td><input type="submit" value="add new"></td>
                            <td><input type="hidden" readonly></td>
                            <td>
                                <select name="" id="">
                                    <option value="by_id">By id</option>
                                    <option value="by_name">By name</option>
                                    <option value="by_history">By history</option>
                                </select>
                            </td>
                        </tr>
                    </table>
                </form>
                <br>
                <%
                    DB db = DB.getDB();
                    HashSet<Subgenre> subgenres = db.getSubgenres();
                    for (Subgenre subgenre : subgenres) {
                %>
                <form method="post">
                    <table>
                        <tr>
                            <td><input type="submit" value="edit" onclick="form.action='/updateSubgenre'"></td>
                            <td><input type="text" name="id" value="<%=subgenre.getId()%>" readonly></td>
                            <td><input type="text" name="name" value="<%=subgenre.getName()%>" readonly></td>
                            <td><input type="text" name="history" value="<%=subgenre.getHistory()%>" readonly></td>
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
