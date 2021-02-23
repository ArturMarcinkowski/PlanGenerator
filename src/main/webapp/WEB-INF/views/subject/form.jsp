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

<form:form method="post" modelAttribute="subject">
    <div>
        <form:hidden path="id"/>
        <form:input path="name"/>
    </div>
    <div>
        <form:errors path="name"/>
    </div>

<%--    <div>--%>
<%--          <form:checkboxes path="subject" items="${subject}"/>--%>
<%--    </div>--%>
<%--    <form:select path="subject" items="${subjects}" itemLabel="name" itemValue="id" />--%>


<%--    Subjects:<br>--%>
<%--    <c:forEach var="subject" items="${subjects}">--%>
<%--        <input type="checkbox" name="subject[]" value="${subject}">${subject.name}<br/>--%>
<%--    </c:forEach>--%>

<%--    <%--%>
<%--        List<Subject> subjects =(List<Subject>) request.getAttribute("subjects");--%>
<%--        for(Subject subject:subjects) {--%>
<%--            out.println(subject.getName());--%>
<%--        }--%>
<%--    %>--%>



    <input type="submit" value="Save">
</form:form>



</body>
</html>
