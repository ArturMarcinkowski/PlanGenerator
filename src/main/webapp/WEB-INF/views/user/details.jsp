<%@ page import="pl.coderslab.model.Subject" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../utilities/header.jsp" %>

<div class="container-fluid">

    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">User</h1>
        <a href="/user/list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"> Back to List</a>
    </div>
    <div class="row">
        <div class="col-xl-4 col-lg-3">
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <div class="d-sm-flex align-items-center justify-content-between">
                        <h6 class="m-0 font-weight-bold text-primary">${user.username}</h6>
                        <a href="/user/edit?id=${user.id}"
                           class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"> Edit Details</a>
                    </div>
                </div>
                <div class="card-body">
                    Informations:
                    <ul>
                        <li>Id: ${user.id}<br></li>
                        <li>Username: ${user.username}<br></li>
                        <li>Set to Person: ${user.studentTeacher}<br></li>
                        <li>Role/Roles:<c:forEach var="role" items="${user.roles}">
                            ${role.name} ,</c:forEach><br></li>
                    </ul>
                </div>
            </div>
        </div>

    </div>
</div>
</div>
<%@include file="../utilities/footer.jsp" %>


