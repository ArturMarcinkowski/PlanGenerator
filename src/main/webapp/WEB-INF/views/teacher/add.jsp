
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link href="<c:url value="/resources/style.css" />" rel="stylesheet" type="text/css">
</head>
<body>
<form action="/teacher/add" method="post">
    <label for="name">name:</label><br>
    <input type="text" id="name" name="name"><br>
    <label for="surname">name:</label><br>
    <input type="text" id="surname" name="surname"><br>
    <input type="submit" value="Submit">
</form>


</body>
</html>

