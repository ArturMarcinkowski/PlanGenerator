<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../utilities/header.jsp" %>

<div class="container-fluid">

    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">List</h1>
        <a href="/subject/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"> + Add Subject</a>
    </div>
    <div class="col-xl-6 col-lg-1">
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Subjects</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Actions</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach var="subject" items="${subjects}">
                        <tr>
                            <td>${subject.id}</td>
                            <td>${subject.name}</td>
                            <td>
                                <a href="/subject/edit?id=${subject.id}"
                                   class="d-none d-sm-inline-block btn btn-sm btn-primary">Edit</a>
                                <a href="/subject/delete?id=${subject.id}"
                                   class="d-none d-sm-inline-block btn btn-sm btn-danger">Delete</a>
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
</div>
<%@include file="../utilities/footer.jsp" %>


