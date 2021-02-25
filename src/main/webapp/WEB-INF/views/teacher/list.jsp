<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../utilities/header.jsp"%>
<div class="container-fluid">

    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">List</h1>
        <a href="/teacher/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"> + Add Teacher</a>
    </div>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Teachers</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Account</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Account</th>
                        <th>Actions</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach var="teacher" items="${teachers}">
                        <tr>
                            <td>${teacher.id}</td>
                            <td>${teacher.name}</td>
                            <td>${teacher.surname}</td>
                            <td>${teacher.user.username} (Id:${teacher.user.id})</td>
                            <td>
                                <a href="/teacher/details?id=${teacher.id}" class="d-none d-sm-inline-block btn btn-sm btn-info">Details</a>
                                <a href="/teacher/edit?id=${teacher.id}"class="d-none d-sm-inline-block btn btn-sm btn-primary">Edit</a>
                                <a href="/teacher/delete?id=${teacher.id}"class="d-none d-sm-inline-block btn btn-sm btn-danger">Delete</a>
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



