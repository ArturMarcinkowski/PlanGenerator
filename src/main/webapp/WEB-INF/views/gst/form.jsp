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

<form:form method="post" modelAttribute="gst">
    <form:hidden path="id"/>
    Select class:<br>
    <form:select path="grade" items="${grades}" itemLabel="name" itemValue="id" /><br>
    select subject:<br>
    <form:select path="subject" items="${subjects}" itemLabel="name" itemValue="id" /><br>
    Select teacher:<br>
    <form:select path="teacher" items="${teachers}" itemLabel="name" itemValue="id" /><br>
    Type number of lessons in week:<br>
    <form:input path="lessonsInWeek"/><br>
    <form:errors path="lessonsInWeek"/>
    <input type="submit" value="Save">
</form:form>


</body>
</html>
