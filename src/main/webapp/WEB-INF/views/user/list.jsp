<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../utilities/header.jsp"%>
<div class="container-fluid">

    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">List</h1>
        <a href="/user/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"> + Add User</a>
    </div>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Users</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Username</th>
                        <th>Student/Teacher</th>
                        <th>Roles</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Id</th>
                        <th>Username</th>
                        <th>Student/Teacher</th>
                        <th>Roles</th>
                        <th>Actions</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.username}</td>
                            <td>${user.studentTeacher}</td>
                            <td><c:forEach var="role" items="${user.roles}">
                                ${role.name}<br></c:forEach></td>
<%--                            <td><c:forEach var="role" items="${user}">--%>

<%--                            </c:forEach></td>--%>
                            <td>
                                <a href="/user/details?id=${user.id}" class="d-none d-sm-inline-block btn btn-sm btn-info">Details</a>
                                <a href="/user/edit?id=${user.id}"class="d-none d-sm-inline-block btn btn-sm btn-primary">Edit</a>
                                <a href="/user/addrole?id=${user.id}"class="d-none d-sm-inline-block btn btn-sm btn-warning">Set Roles</a>
                                <a href="/user/delete?id=${user.id}"class="d-none d-sm-inline-block btn btn-sm btn-danger">Delete User</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
</div>
<%@include file="../utilities/footer.jsp"%>



