
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link href="<c:url value="/resources/style.css" />" rel="stylesheet" type="text/css">
</head>
<body>
<form action="/gst/addteachers" method="post">

    <input type="hidden"  name="gradeId" value="${gradeId}">
    <input type="hidden"  name="subjects" value="${subjects}">
<%--    Select grade:--%>
<%--    <select id="grade" name="gradeId">--%>
<%--        <c:forEach var="grade" items="${grades}">--%>
<%--        <option value="${grade.id}">${grade.name}</option>--%>
<%--        </c:forEach>--%>
<%--    </select><br>--%>
    Choose teacher for every subject:<br>
    <c:forEach var="subject" items="${subjects}">
        ${subject.name}:
<%--        <input type="checkbox" name="subjectsId[]" value="${subject.id}">${subject.name}<br/>--%>


    <select name="teachersId[]">
        <c:forEach var="teacher" items="${subject.teacher}">
          <option value="${teacher.id}">${teacher.name} ${teacher.surname}</option>
        </c:forEach>
    </select><br>
    </c:forEach>
    <input type="submit" value="Submit">
</form>


</body>
</html>

