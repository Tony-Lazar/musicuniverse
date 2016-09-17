<%@ page import="com.lanzdev.classes.DB" %>
<%@ page import="com.lanzdev.classes.essences.Genre" %>
<%@ page import="com.lanzdev.classes.essences.Subgenre" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="com.lanzdev.utils.Utils" %><%--
  Created by IntelliJ IDEA.
  User: Tony
  Date: 17.09.2016
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Music Universe</title>
    <link rel="stylesheet" href="../../css/main.css">
    <script type="text/javascript" src="../../js/jquery-3.1.0.js"></script>
    <script src='//cdn.tinymce.com/4/tinymce.min.js'></script>
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

    <% DB db = DB.getDB();
        Subgenre subgenre = db.getSubgenre(Integer.parseInt(request.getParameter("id"))); %>

    <div class="navbar"></div>

    <div class="content">

        <h1>Subgenre Editor</h1>

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

        <div class="subgenre-editor">
            <form method="post" action="/updateSubgenre">
                <input type="hidden" name="id" value="<%=subgenre.getId()%>">
                <select name="parent">
                    <% HashSet<Genre> genres = db.getGenres();
                        for (Genre genre : genres) { %>
                    <option <%=Utils.isSelectedGenre(subgenre.getParent(), genre.getId())%>
                            value="<%=genre.getId()%>"><%=genre.getName()%></option>
                        <%}%>
                </select>
                <input type="text" name="name" value="<%=subgenre.getName()%>">
                <textarea name="history" id="mytextarea"><%=subgenre.getHistory()%></textarea>
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

    function showChanged() {
        if (document.changed.changed.value == "1") {
            document.accepted.style.display = "block";
            setTimeout(function () {
                $('#accepted').fadeOut('fast')
            }, 1000);
        }
        else if (document.changed.changed.value == "-1") {
            document.denied.style.display = "block";
            setTimeout(function () {
                $('#denied').fadeOut('fast')
            }, 1000);
        }
    }
</script>
</body>
</html>
