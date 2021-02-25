<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../utilities/header.jsp"%>

<div class="container-fluid">

    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">${grade.name}</h1>

        <a href="/plan/gradeList" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"> Back to Class List</a>
    </div>
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800"></h1>
        <a href="/schedule/addplanforgrade?gradeId=${grade.id}" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">Set Lesson</a>
    </div>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Plan</h6>
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
<%@include file="../utilities/footer.jsp"%>





