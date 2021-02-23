
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="<c:url value="/resources/style.css" />" rel="stylesheet" type="text/css">
</head>
<body>

<form:form method="post" modelAttribute="gst">
    <form:hidden path="id"/>
    <form:select path="teacher" items="${teachers}" itemLabel="name" itemValue="id" />
    <input type="submit" value="Save">
</form:form>

</body>
</html>

