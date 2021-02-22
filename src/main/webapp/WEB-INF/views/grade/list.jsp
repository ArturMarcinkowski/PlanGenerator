
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
        <th>Actions</th>
    </tr>
    <c:forEach var="grade" items="${grades}">
        <tr>
            <td>${grade.id}</td>
            <td>${grade.name}</td>
            <td>
                <a href="/grade/details?id=${grade.id}">Szczegóły</a>
                <a href="/grade/edit?id=${grade.id}">Edytuj</a>
                <a href="/grade/delete?id=${grade.id}">Usuń</a>
            </td>
        </tr>
    </c:forEach>


</table>

</body>
</html>

