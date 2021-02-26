<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/logged/profile">
        <div class="sidebar-brand-icon rotate-n-15">
        </div>
        <div class="sidebar-brand-text mx-3">Plan Generator</div>
    </a>
    <sec:authorize access="isAuthenticated()">
        <hr class="sidebar-divider">
        <div class="sidebar-heading">
            User Panel
        </div>

        <li class="nav-item">
            <a class="nav-link" href="/logged/profile">
                <i class="fas fa-fw fa-chart-area"></i>
                <span>Profile</span></a>
        </li>

<%--        <li class="nav-item">--%>
<%--            <a class="nav-link" href="/logged/settings">--%>
<%--                <i class="fas fa-fw fa-table"></i>--%>
<%--                <span>Settings</span></a>--%>
<%--        </li>--%>
    </sec:authorize>

    <sec:authorize access="hasRole('ADMIN')">
        <hr class="sidebar-divider">
        <div class="sidebar-heading">
            Admin Panel
        </div>
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
               aria-expanded="true" aria-controls="collapseTwo">
                <i class="fas fa-fw fa-cog"></i>
                <span>Students</span>
            </a>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Panel:</h6>
                    <a class="collapse-item" href="/student/list">Students List</a>
                    <a class="collapse-item" href="/student/add">Add Student</a>
                </div>
            </div>
        </li>

        <!-- Nav Item - Utilities Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTeachers"
               aria-expanded="true" aria-controls="collapseTeachers">
                <i class="fas fa-fw fa-wrench"></i>
                <span>Teachers</span>
            </a>
            <div id="collapseTeachers" class="collapse" aria-labelledby="headingUtilities"
                 data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Panel:</h6>
                    <a class="collapse-item" href="/teacher/add">Add Teacher</a>
                    <a class="collapse-item" href="/teacher/list">Teachers List</a>
                </div>
            </div>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseClasses"
               aria-expanded="true" aria-controls="collapseClasses">
                <i class="fas fa-fw fa-wrench"></i>
                <span>Classes</span>
            </a>
            <div id="collapseClasses" class="collapse" aria-labelledby="headingClasses"
                 data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Panel:</h6>
                    <a class="collapse-item" href="/grades/add">Add Class</a>
                    <a class="collapse-item" href="/grades/list">Classes List</a>
                </div>
            </div>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseSubjects"
               aria-expanded="true" aria-controls="collapseSubjects">
                <i class="fas fa-fw fa-wrench"></i>
                <span>Subjects</span>
            </a>
            <div id="collapseSubjects" class="collapse" aria-labelledby="headingUtilities"
                 data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Panel:</h6>
                    <a class="collapse-item" href="/subject/add">Add Subject</a>
                    <a class="collapse-item" href="/subject/list">Subjects List</a>
                </div>
            </div>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseSPlans"
               aria-expanded="true" aria-controls="collapseUtilities">
                <i class="fas fa-fw fa-wrench"></i>
                <span>Plans</span>
            </a>
            <div id="collapseSPlans" class="collapse" aria-labelledby="headingUtilities"
                 data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Panel:</h6>
                    <a class="collapse-item" href="/plan/gradeList">Students Plans</a>
                    <a class="collapse-item" href="/plan/teacherlist">Teachers Plans</a>
                </div>
            </div>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUsers"
               aria-expanded="true" aria-controls="collapseUsers">
                <i class="fas fa-fw fa-wrench"></i>
                <span>Users</span>
            </a>
            <div id="collapseUsers" class="collapse" aria-labelledby="headingUsers"
                 data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Panel:</h6>
                    <a class="collapse-item" href="/user/add">Add User</a>
                    <a class="collapse-item" href="/user/list">Users List</a>
                </div>
            </div>
        </li>
    </sec:authorize>
</ul>