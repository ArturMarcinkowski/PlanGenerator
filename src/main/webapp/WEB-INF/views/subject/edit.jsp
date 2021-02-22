
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link href="<c:url value="/resources/style.css" />" rel="stylesheet" type="text/css">
</head>
<body>

<form action="/subject/edit" method="POST">
    <input type="hidden"  name="id" value="${subject.id}">
    <label for="name">name:</label><br>
    <input type="text" id="name" name="name" value=${subject.name}><br>


    </select><br>
    <input type="submit" value="Submit">
</form>


</body>
</html>

