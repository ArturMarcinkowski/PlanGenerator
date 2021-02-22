
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <link href="<c:url value="/resources/style.css" />" rel="stylesheet" type="text/css">



</head>
<body>

<table class="table">
    Id: ${subject.id}<br>
    Name: ${subject.name}<br>

    Teachers:
    <ul>
    <c:forEach var="teacher" items="${teachers}">
        <li>${teacher.name} ${teacher.surname}</li>
    </c:forEach>
    </ul>

</table>

</body>
</html>

