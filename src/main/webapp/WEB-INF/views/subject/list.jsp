
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
    <c:forEach var="subject" items="${subjects}">
        <tr>
            <td>${subject.id}</td>
            <td>${subject.name}</td>
            <td>
                <a href="/subject/edit?id=${subject.id}">Edytuj</a>
                <a href="/subject/delete?id=${subject.id}">Usuń</a>
            </td>
        </tr>
    </c:forEach>


</table>

</body>
</html>

