
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link href="<c:url value="/resources/style.css" />" rel="stylesheet" type="text/css">
</head>
<body>
<form action="/student/add" method="post">
    <label for="name">name:</label><br>
    <input type="text" id="name" name="name"><br>
    <label for="surname">surname:</label><br>
    <input type="text" id="surname" name="surname"><br>
    <label for="grade">grade:</label><br>
<%--    <input for="gradelist" id="grade" name="grade">--%>
    <select id="grade" name="gradeId">
    <c:forEach var="grade" items="${grades}">
        <option value="${grade.id}">${grade.name}</option>
    </c:forEach>

    </select><br>
    <input type="submit" value="Submit">
</form>


</body>
</html>

