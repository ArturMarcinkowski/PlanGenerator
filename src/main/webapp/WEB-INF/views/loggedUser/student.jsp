<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../utilities/header.jsp"%>

<div class="container-fluid">

    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Welcome ${student.name} ${student.surname}</h1>
        <a href="/teacher/list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"> Back to List</a>
    </div>

    <sec:authorize access="hasRole('ADMIN')">
        You are also an admin:
        <div>
            <a href="/logged/admin" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">Check admin profile</a>
        </div>
    </sec:authorize>
    <sec:authorize access="hasRole('TEACHER')">
        You are also a teacher:
        <div>
            <a href="/logged/teacher" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">Check teacher profile</a>
        </div>
    </sec:authorize>



    <div class="row">
        <div class="col-xl-3 col-lg-3">
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <div class="d-sm-flex align-items-center justify-content-between">
                        <h6 class="m-0 font-weight-bold text-primary">Info:</h6>
                    </div>
                </div>
                <div class="card-body">
                    <ul>
                        <li>Name: ${student.name}<br></li>
                        <li>Surname: ${student.surname}<br></li>
                        <li>Username: ${student.user.username}<br></li>
                    </ul>
                </div>
            </div>
        </div>



        <div class="col-xl-3 col-lg-3">
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <div class="d-sm-flex align-items-center justify-content-between">
                        <h6 class="m-0 font-weight-bold text-primary">Your Classmates:</h6>
                    </div>
                </div>
                <div class="card-body">
                    <ul>
                        <c:forEach var="student" items="${students}">
                            <li>${student.name} ${student.surname}</li>

                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>




        <div class="col-xl-5 col-lg-1">
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <div class="d-sm-flex align-items-center justify-content-between">
                    <h6 class="m-0 font-weight-bold text-primary">Your Subjects:</h6>
                </div>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th>Subject</th>
                            <th>Teacher</th>
                            <th>Number in Week</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Subject</th>
                            <th>Teacher</th>
                            <th>Number in Week</th>
                        </tr>
                        </tfoot>
                        <tbody>
                        <c:forEach var="gst" items="${gsts}">
                            <tr>
                                <td>${gst.subject.name}</td>
                                <td>${gst.teacher.name} ${gst.teacher.surname}</td>
                                <td>${gst.lessonsInWeek}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        </div>
    </div>




        <div class="row">
        <div class="col-xl-11 col-lg-8">
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <div class="d-sm-flex align-items-center justify-content-between">
                    <h6 class="m-0 font-weight-bold text-primary">Your Schedule</h6>
                </div>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <tr>
                            <th>Monday</th>
                            <th>Tuesday</th>
                            <th>Wednesday</th>
                            <th>Thursday</th>
                            <th>Friday</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="gsts" items="${allGsts}">
                            <tr>
                                <c:forEach var="gst" items="${gsts}">
                                    <td>${gst.subject.name}<br>
                                            ${gst.teacher.name} ${gst.teacher.surname}</td>
                                </c:forEach>
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
</div>
<%@include file="../utilities/footer.jsp"%>


