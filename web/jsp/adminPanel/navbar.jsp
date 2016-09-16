<%--
  Created by IntelliJ IDEA.
  User: Tony
  Date: 08.09.2016
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.lanzdev.utils.Menu" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="navbar">
    <ul class="menu">
        <%
            Menu[] menuItems = Menu.values();
            for (int i = 0; i < menuItems.length; i++) {
        %>

        <li>
            <form action="<%=menuItems[i].getUrl()%>" method="post">
                <input type="submit" value="<%=menuItems[i].getTitle()%>">
            </form>
        </li>

        <%}%>
        <li>
            <form action="/genres" method="post">
                <input type="submit" value="Home">
            </form>
        </li>
    </ul>
</div>

</body>
</html>
