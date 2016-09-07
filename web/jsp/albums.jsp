<%@ page import="com.lanzdev.classes.DB" %>
<%@ page import="com.lanzdev.classes.essences.Nameable" %>
<%@ page import="java.util.HashSet" %><%--
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
</head>
<body>

<div class="container">
    <h1>Albums from <%=request.getParameter("band")%>
    </h1>

    <div class="main-col">
        <ul>
            <%
                DB db = DB.getDB();
                HashSet<Nameable> albums = db.getAlbums(request.getParameter("band"));
                for (Nameable album : albums) {
            %>
            <li>
                <form action="/album" method="post">
                    <input title="<%=album.getName()%>" type="submit" name="album" value="<%=album.getName()%>">
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
