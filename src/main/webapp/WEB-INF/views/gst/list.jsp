
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
        <th>Number of lessons in week</th>
        <th>Grade</th>
        <th>Subject</th>
        <th>Teacher</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="gst" items="${gsts}">
        <tr>
            <td>${gst.id}</td>
            <td>${gst.lessonsInWeek}</td>
            <td>${gst.grade.name}</td>
            <td>${gst.subject.name}</td>
            <td>${gst.teacher.name} ${gst.teacher.surname}</td>
            <td>
                <a href="/gst/edit?id=${gst.id}">Edytuj</a>
                <a href="/gst/delete?id=${gst.id}">Usuń</a>
            </td>
        </tr>
    </c:forEach>


</table>

</body>
</html>

