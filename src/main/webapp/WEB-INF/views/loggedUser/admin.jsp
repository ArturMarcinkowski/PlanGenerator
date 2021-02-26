<%@ page import="pl.coderslab.model.Subject" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../utilities/header.jsp"%>

<div class="container-fluid">

    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Welcome ${user.username}</h1>


    </div>

    <sec:authorize access="hasRole('TEACHER')">
        You are also a teacher:
        <div>
        <a href="/logged/teacher" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">Check teacher profile</a>
        </div>
    </sec:authorize>
    <sec:authorize access="hasRole('STUDENT')">
        You are also a student:
        <div>
            <a href="/logged/student" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">Check student profile</a>
        </div>
    </sec:authorize>

    <div class="row">
        <div class="col-xl-3 col-lg-3">
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <div class="d-sm-flex align-items-center justify-content-between">
                        <h6 class="m-0 font-weight-bold text-primary">In database we currently have:</h6>
                    </div>
                </div>
                <div class="card-body">
                    <ul>
                        <li>${studentsNumber} students<br></li>
                        <li>${gradesNumber} classes<br></li>
                        <li>${teachersNumber} teachers<br></li>
                        <li>${subjectsNumber} subjects<br></li>
                        <li>${teachersNumber + gradesNumber} different schedules<br></li>
                    </ul>
                </div>
            </div>
        </div>










</div>
</div>
</div>
<%@include file="../utilities/footer.jsp"%>


