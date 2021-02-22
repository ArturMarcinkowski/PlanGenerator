
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <link href="<c:url value="/resources/style.css" />" rel="stylesheet" type="text/css">



</head>
<body>

<table class="table">
    Id: ${teacher.id}<br>
    Name: ${teacher.name}<br>
    Surname: ${teacher.surname}<br>

    Subjects:
    <ul>
    <c:forEach var="subject" items="${subjects}">
        <li>${subject.name}</li>
    </c:forEach>
    </ul>

</table>

</body>
</html>

