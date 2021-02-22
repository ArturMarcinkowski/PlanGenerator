
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <link href="<c:url value="/resources/style.css" />" rel="stylesheet" type="text/css">



</head>
<body>

<table class="table">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="teacher" items="${teachers}">
        <tr>
            <td>${teacher.id}</td>
            <td>${teacher.name}</td>
            <td>${teacher.surname}</td>
            <td>
                <a href="/teacher/details?id=${teacher.id}">Szczegóły</a>
                <a href="/teacher/edit?id=${teacher.id}">Edytuj</a>
                <a href="/teacher/delete?id=${teacher.id}">Usuń</a>
            </td>
        </tr>
    </c:forEach>


</table>

</body>
</html>

