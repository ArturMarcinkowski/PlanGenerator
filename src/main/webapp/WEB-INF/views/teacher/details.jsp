<%@ page import="pl.coderslab.model.Subject" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../utilities/header.jsp"%>

<div class="container-fluid">

    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Teacher</h1>
        <a href="/teacher/list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"> Back to List</a>
    </div>
    <div class="row">
        <div class="col-xl-4 col-lg-3">
            <div class="card shadow mb-4">
                <div
                        class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                    <h6 class="m-0 font-weight-bold text-primary">${teacher.name} ${teacher.surname}</h6>
                </div>
                <div class="card-body">
                    Informations:
                    <ul>
                        <li>Id: ${teacher.id}<br></li>
                        <li>Name: ${teacher.name}<br></li>
                        <li>Surname: ${teacher.surname}<br></li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="col-xl-2 col-lg-1">
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Teaching Subjects</h6>
            </div>
            <div class="card-body">
                <ul>
                    <c:forEach var="subject" items="${subjects}">
                        <li>${subject.name}</li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        </div>

        <div class="col-xl-2 col-lg-1">
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Teaching Classes</h6>
            </div>
            <div class="card-body">
                    <ul>
                        <c:forEach var="grade" items="${grades}">
                            <li>${grade.name}</li>
                        </c:forEach>
                    </ul>
            </div>
        </div>
        </div>
    </div>
</div>
</div>
<%@include file="../utilities/footer.jsp"%>


