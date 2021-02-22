
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <link href="<c:url value="/resources/style.css" />" rel="stylesheet" type="text/css">



</head>
<body>

<table class="table">
    Id: ${grade.id}<br>
    Name: ${grade.name}<br>

    Students:
    <ul>
    <c:forEach var="student" items="${students}">
        <li>${student.name} ${student.surname}</li>
    </c:forEach>
    </ul>

</table>

</body>
</html>

