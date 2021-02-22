
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link href="<c:url value="/resources/style.css" />" rel="stylesheet" type="text/css">
</head>
<body>
<form action="/gst/add" method="post">
    Select grade:
    <select id="grade" name="gradeId">
        <c:forEach var="grade" items="${grades}">
        <option value="${grade.id}">${grade.name}</option>
        </c:forEach>
    </select><br>
    Select subjects:<br>
    <c:forEach var="subject" items="${subjects}">
        <input type="checkbox" name="subjectsId[]" value="${subject.id}">${subject.name}<br/>
    </c:forEach>
    <input type="submit" value="Submit">
</form>


</body>
</html>

