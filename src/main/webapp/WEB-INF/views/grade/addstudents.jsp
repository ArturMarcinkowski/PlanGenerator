<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="../utilities/header.jsp" %>

<div class="container-fluid">
    <form method="post">

        <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Add Students</h1>
            <input type="submit" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" value="Save">
        </div>

        <div class="col-xl-5 col-lg-1">
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Students</h6>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>Select</th>
                                <th>Current Class</th>
                                <th>Student Id</th>
                                <th>Student Name</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Select</th>
                                <th>Current Class</th>
                                <th>Student Id</th>
                                <th>Student Name</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach var="student" items="${students}" varStatus="status">
                                <tr>
                                    <td><input type="checkbox" id="studentsId[]" name="studentsId[]"
                                               value="${student.id}"/>
                                    <td/>
                                        ${student.grade.name}
                                    <td>${student.id}</td>
                                    <td>${student.name} ${student.surname}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
</div>
<%@include file="../utilities/footer.jsp" %>





