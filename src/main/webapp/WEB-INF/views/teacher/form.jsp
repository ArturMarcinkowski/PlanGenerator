<%@ page import="pl.coderslab.model.Subject" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../utilities/header.jsp"%>


<div class="container-fluid">

    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Add Teacher</h1>
    </div>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Add Teacher</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">

                <form:form method="post" modelAttribute="teacher">
                    <div>
                        <form:hidden path="id"/>

                        <form:input path="name" placeholder="name"/>
                    </div>
                    <div>
                        <form:errors path="name"/>
                    </div>
                    <div>
                        <form:input path="surname" placeholder="surname"/>
                    </div>
                    <div>
                        <form:errors path="surname"/>
                    </div>
                    Select Account:<br>
                    <form:select  path="user">
                        <form:option value = "" label = "Select"/>
                        <form:options items="${users}" itemLabel="username" itemValue="id"/>
                    </form:select><br>
                    <input type="submit" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" value="+ Add Teacher">
                </form:form>
            </div>
        </div>
    </div>

</div>
</div>
<%@include file="../utilities/footer.jsp"%>
