<%--
  Created by IntelliJ IDEA.
  User: Tony
  Date: 13.09.2016
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/admin.css">
</head>
<body>

<div class="container">
    <div class="wrapper">
        <form action="/admin" method="post" class="login">
            <label for="login">enter login</label>
            <input type="text" id="login" name="login">

            <label for="password">enter password</label>
            <input type="text" id="password" name="password">

            <input type="submit" value="accept">
        </form>
    </div>
</div>

</body>
</html>
