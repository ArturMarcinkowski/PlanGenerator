<%@ page import="pl.coderslab.model.Subject" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../utilities/header.jsp"%>


<div class="container-fluid">

    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Set Subject</h1>
    </div>

    <div class="col-xl-4 col-lg-1">
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Set Subject</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">

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
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <input type="submit" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" value="Save">
                    </div>
                </form:form>
            </div>
        </div>
    </div>
    </div>

</div>
</div>
<%@include file="../utilities/footer.jsp"%>


