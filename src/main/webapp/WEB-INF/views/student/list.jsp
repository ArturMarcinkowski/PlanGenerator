
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
        <th>Grade</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.surname}</td>
            <td>${student.grade.name}</td>
            <td>
                <a href="/student/edit?id=${student.id}">Edytuj</a>
                <a href="/student/delete?id=${student.id}">Usuń</a>
            </td>
        </tr>
    </c:forEach>


</table>

</body>
</html>

