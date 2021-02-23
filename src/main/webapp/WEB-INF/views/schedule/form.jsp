<%@ page import="pl.coderslab.model.Subject" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="schedule">
    <form:hidden path="id"/>
    Select day:<br>
    <form:select path="dayOfWeek" items="${dayOfWeek}" /><br>
    Select hour:<br>
    <form:select path="startHour" items="${startHour}" /><br>
    Select gst:
    <form:select path="gst" items="${gsts}" itemLabel="grade.name" itemValue="id" /><br>
    <input type="submit" value="Save">
</form:form>


</body>
</html>
