<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../utilities/header.jsp"%>


    <div class="container-fluid">

        <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">List</h1>
            <a href="/student/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"> + Add Student</a>
        </div>

        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Students</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Surname</th>
                            <th>Class</th>
                            <th>Account</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Surname</th>
                            <th>Class</th>
                            <th>Account</th>
                            <th>Actions</th>
                        </tr>
                        </tfoot>
                        <tbody>
                        <c:forEach var="student" items="${students}">
                            <tr>
                                <td>${student.id}</td>
                                <td>${student.name}</td>
                                <td>${student.surname}</td>
                                <td>${student.grade.name}</td>
                                <td>${student.user.username} (Id:${student.user.id})</td>
                                <td>
                                    <a href="/student/edit?id=${student.id}"class="d-none d-sm-inline-block btn btn-sm btn-primary">Edit</a>
<%--                                    <a href="/student/account?id=${student.id}"class="d-none d-sm-inline-block btn btn-sm btn-info">Set Account</a>--%>
                                    <a href="/student/delete?id=${student.id}"class="d-none d-sm-inline-block btn btn-sm btn-danger">Delete</a>
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