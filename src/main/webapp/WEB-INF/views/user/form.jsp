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

<form:form method="post" modelAttribute="student">
    <div>
        <form:hidden path="id"/>
        <form:input path="username"/>
    </div>
    <div>
        <form:errors path="name"/>
    </div>
    <div>
        <form:input path="surname"/>
    </div>
    <div>
        <form:errors path="surname"/>
    </div>
    <form:select path="teacher" items="${teachers}" itemLabel="name" itemValue="id" />





    <input type="submit" value="Save">
</form:form>



</body>
</html>
