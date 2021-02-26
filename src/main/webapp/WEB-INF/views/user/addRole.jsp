<%@ page import="pl.coderslab.model.Subject" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../utilities/header.jsp"%>


<div class="container-fluid">

    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Set role</h1>
    </div>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">${user.username}</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">

                <form method="post">
                    <div>
                        <input type="hidden" value="${user.id}" name="userId" id="userId"/>
                    <div>

<%--                    <select name="rolesId[]" id="rolesId[]">--%>
<%--                        <option value="">--Please choose an option--</option>--%>
<%--                        <option value="1">admin</option>--%>
<%--                        <option value="2">student</option>--%>
<%--                        <option value="3">teacher</option>--%>
<%--                    </select>--%>
                           <input type="checkbox" value="1" name="rolesId[]" id="rolesId[]"/>ADMIN<br>
                          <input type="checkbox" value="2" name="rolesId[]" id="rolesId[]"/>TEACHER<br>
                           <input type="checkbox" value="3" name="rolesId[]" id="rolesId[]"/>STUDENT<br>
                    </div>
                    <input type="submit" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" value="Set">
                </form>


<%--    <c:forEach var="role" items="${roles}">--%>
<%--        <tr>--%>
<%--            <td>${role.name}</td>--%>

<%--        </tr>--%>
<%--    </c:forEach>--%>


            </div>
        </div>
    </div>

</div>
</div>
<%@include file="../utilities/footer.jsp"%>

