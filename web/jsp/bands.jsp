<%@ page import="com.lanzdev.classes.DB" %>
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
</head>
<body>

<div class="container">
    <h1>Bands from <%=request.getParameter("subgenre")%>
    </h1>

    <div class="main-col">
        <ul>
            <%
                DB db = DB.getDB();
                HashSet<Nameable> bands = db.getBands(request.getParameter("subgenre"));
                for (Nameable band : bands) {
            %>
            <li>
                <form action="" method="post">
                    <input title="<%=band.getName()%>" type="submit" name="band" value="<%=band.getName()%>">
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
