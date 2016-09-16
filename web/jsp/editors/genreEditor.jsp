<%@ page import="com.lanzdev.classes.DB" %>
<%@ page import="com.lanzdev.classes.essences.Genre" %><%--
  Created by IntelliJ IDEA.
  User: Tony
  Date: 15.09.2016
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Music Universe</title>
    <link rel="stylesheet" href="../../css/main.css">
    <script type="text/javascript" src="../../js/jquery-3.1.0.js"></script>
    <script>
        tinymce.init({
            selector: '#mytextarea',
//            plugins : 'advlist autolink link image lists charmap print preview',
            plugins: [
                'advlist autolink lists link image charmap print preview hr anchor pagebreak',
                'searchreplace wordcount visualblocks visualchars code fullscreen',
                'insertdatetime media nonbreaking save table contextmenu directionality',
                'emoticons template paste textcolor colorpicker textpattern imagetools'
            ],
            toolbar1: 'insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image',
            toolbar2: 'print preview media | forecolor backcolor emoticons',
            image_advtab: true,
            fontsize_formats: '8pt 10pt 12pt 14pt 18pt 24pt 36pt',
            height: 500
        })
    </script>
</head>
<body>

<div class="container">

    <% Genre genre = DB.getDB().getGenre(Integer.parseInt(request.getParameter("id"))); %>

    <div class="navbar"></div>

    <div class="content">

        <h1>Genre Editor</h1>

        <div class="response">

            <form name="changed" id="changed">
                <input type="hidden" name="changed" value="<%=request.getAttribute("response")%>">
            </form>

            <form name="accepted" id="accepted" method="get" style="display: none">
                <input type="text" name="alert" value="Changes accepted!" readonly>
            </form>

            <form name="denied" id="denied" method="get" style="display: none">
                <input type="text" name="alert" value="Changes denied!" readonly>
            </form>

        </div>

        <div class="article-editor">
            <form method="post" action="/updateGenre">
                <input type="hidden" name="id" value="<%=genre.getId()%>">
                <input type="text" name="title" value="<%=genre.getName()%>">
                <textarea name="content" id="mytextarea"><%=genre.getHistory()%></textarea>
                <input type="submit" value="send">
            </form>
        </div>

    </div>

</div>

<script>
    $(document).ready(function () {
        $('.container .navbar').load('/jsp/adminPanel/navbar.jsp .menu');
        showChanged();
    });
</script>
</body>
</html>
