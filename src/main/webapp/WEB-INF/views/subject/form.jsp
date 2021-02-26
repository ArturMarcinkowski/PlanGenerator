<%@ page import="pl.coderslab.model.Subject" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../utilities/header.jsp" %>


<div class="container-fluid">

    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Add Subject</h1>
    </div>
    <div class="col-xl-3 col-lg-1">
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Add Subject</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">

                    <form:form method="post" modelAttribute="subject">
                        <div>
                            <form:hidden path="id"/>
                            <form:input path="name" placeholder="name"/>
                        </div>
                        <div>
                            <form:errors path="name"/>
                        </div>

                        <input type="submit" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"
                               value="+ Add Subject">
                    </form:form>
                </div>
            </div>
        </div>
    </div>

</div>
</div>
<%@include file="../utilities/footer.jsp" %>
