<%--
  Created by IntelliJ IDEA.
  User: Tony
  Date: 13.09.2016
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="navbar">
    <ul class="menu">
        <li>
            <form action="/genres" method="post">
                <input type="submit" value="Home">
            </form>
        </li>
        <li>
            <form action="/articles" method="post">
                <input type="submit" value="Articles">
            </form>
        </li>
        <% int left = (5 - (2 % 5));
            System.out.println(left);
            for (int i = 0; i < left; i++) { %>
        <li>
            <form class="empty">
                <input type="text" readonly>
            </form>
        </li>
        <% } %>
    </ul>
</div>

</body>
</html>
