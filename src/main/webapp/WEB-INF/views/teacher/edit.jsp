
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link href="<c:url value="/resources/style.css" />" rel="stylesheet" type="text/css">
</head>
<body>

<form action="/teacher/edit" method="POST">
    <input type="hidden"  name="id" value="${teacher.id}">
    <label for="name">name:</label><br>
    <input type="text" id="name" name="name" value=${teacher.name}><br>
    <label for="name">name:</label><br>
    <input type="text" id="surname" name="surname" value=${teacher.surname}><br>
<%--    <select multiple="multiple" name="subjectsId[]">--%>


    Subjects:<br>
    <c:forEach var="subject" items="${allSubjects}">
        <input type="checkbox" name="subjectsId[]" value="${subject.id}">${subject.name}<br/>

<%--            <option value="${subject.id}">${subject.name}</option>--%>


    </c:forEach>
<%--    </select>--%>

    <input type="submit" value="Submit">

</form>


</body>
</html>

