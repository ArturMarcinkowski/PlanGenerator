
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
        <th>Day</th>
        <th>Hour</th>
        <th>Class</th>
        <th>Subject</th>
        <th>Teacher</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="schedule" items="${schedules}">
        <tr>
            <td>${schedule.id}</td>
            <td>${schedule.dayOfWeek}</td>
            <td>${schedule.startHour}</td>
            <td>${schedule.gst.grade.name}</td>
            <td>${schedule.gst.subject.name}</td>
            <td>${schedule.gst.teacher.name} ${schedule.gst.teacher.surname}</td>
            <td>
                <a href="/schedule/details?id=${schedule.id}">Szczegóły</a>
                <a href="/schedule/edit?id=${schedule.id}">Edytuj</a>
                <a href="/schedule/delete?id=${schedule.id}">Usuń</a>
            </td>
        </tr>
    </c:forEach>


</table>

</body>
</html>

