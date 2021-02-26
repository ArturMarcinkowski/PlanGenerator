<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../utilities/header.jsp"%>

<div class="container-fluid">

    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">${grade.name}</h1>
    </div>

        Class Id: ${grade.id}<br>

    <div class="row">
    <div class="col-xl-7 col-lg-6">
    <div class="card shadow mb-4">
        <div class="card-header">
            <div class="d-sm-flex align-items-center justify-content-between">
                    <h6 class="m-0 font-weight-bold text-primary">Students</h6>
                <a href="/grade/${grade.id}/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"> + Add Student to Class</a>
            </div>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Username</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Username</th>
                        <th>Actions</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach var="student" items="${students}">
                        <tr>
                            <td>${student.id}</td>
                            <td>${student.name}</td>
                            <td>${student.surname}</td>
                            <td>${student.user.username}</td>
                            <td>
                                <a href="/student/edit?id=${student.id}" class="d-none d-sm-inline-block btn btn-sm btn-primary">Edit</a>
<%--                                <a href="/student/account?id=${student.id}"class="d-none d-sm-inline-block btn btn-sm btn-info">Set Account</a>--%>
                                <a href="/student/delete?id=${student.id}"class="d-none d-sm-inline-block btn btn-sm btn-danger">Delete Student</a>
                                <a href="/grade/${grade.id}/removeStudent?studentId=${student.id}"class="d-none d-sm-inline-block btn btn-sm btn-warning">Remove form Class</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>



    <div class="col-xl-5 col-lg-3">
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <div class="d-sm-flex align-items-center justify-content-between">
                <h6 class="m-0 font-weight-bold text-primary">Subjects</h6>
                <a href="/gst/addtograde?gradeId=${grade.id}" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"> + Add Subject</a>
            </div>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Subject</th>
                        <th>Teacher</th>
                        <th>Times in Week</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Subject</th>
                        <th>Teacher</th>
                        <th>Times in Week</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach var="gst" items="${gsts}">
                        <tr>
                            <td>${gst.subject.name}</td>
                            <td>${gst.teacher.name} ${gst.teacher.surname}</td>
                            <td><a href="/gst/change?id=${gst.id}&value=-1" class=" d-sm-inline-block btn btn-sm btn-info btn-circle">-</a>
                                    ${gst.lessonsInWeek}
                                <a href="/gst/change?id=${gst.id}&value=1" class="btn btn-sm btn-info btn-circle">+</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    </div>
    </div>





</div>
</div>
<%@include file="../utilities/footer.jsp"%>






