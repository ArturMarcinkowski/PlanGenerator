
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../utilities/header.jsp"%>

<div class="container-fluid">

    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Schedules</h1>
    </div>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">List</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Day</th>
                        <th>Hour</th>
                        <th>Class</th>
                        <th>Subject</th>
                        <th>Teacher</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Id</th>
                        <th>Day</th>
                        <th>Hour</th>
                        <th>Class</th>
                        <th>Subject</th>
                        <th>Teacher</th>
                        <th>Actions</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach var="schedule" items="${schedules}">
                        <tr>
                            <td>${schedule.id}</td>
                            <td>${schedule.dayOfWeek}</td>
                            <td>${schedule.startHour}</td>
                            <td>${schedule.gst.grade.name}</td>
                            <td>${schedule.gst.subject.name}</td>
                            <td>${schedule.gst.teacher.name} ${schedule.gst.teacher.surname}</td>
                            <td>
                                <a href="/schedule/details?id=${schedule.id}">Details</a>
                                <a href="/schedule/edit?id=${schedule.id}">Edit</a>
                                <a href="/schedule/delete?id=${schedule.id}">Delete</a>
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








