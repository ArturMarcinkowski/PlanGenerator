<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

    <!-- Sidebar Toggle (Topbar) -->
    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
        <i class="fa fa-bars"></i>
    </button>

    <div>

        <sec:authorize access="isAuthenticated()">
            Welcome <sec:authentication property="principal.username" />
        </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
            Plan Generator
        </sec:authorize>
    </div>

    <!-- Topbar Navbar -->
    <ul class="navbar-nav ml-auto">

        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
        <li class="nav-item dropdown no-arrow d-sm-none">
            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-search fa-fw"></i>
            </a>
            <!-- Dropdown - Messages -->
            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                 aria-labelledby="searchDropdown">
                <form class="form-inline mr-auto w-100 navbar-search">
                    <div class="input-group">
                        <input type="text" class="form-control bg-light border-0 small"
                               placeholder="Search for..." aria-label="Search"
                               aria-describedby="basic-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-primary" type="button">
                                <i class="fas fa-search fa-sm"></i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </li>

        <!-- Nav Item - Alerts -->




        <div class="topbar-divider d-none d-sm-block"></div>

        <!-- Nav Item - User Information -->
        <sec:authorize access="!isAuthenticated()">
            <div><a href="/login" class="d-none d-sm-inline-block btn btn btn-primary shadow-sm">  Login  </a></div>
            <div class="topbar-divider d-none d-sm-block"></div>
            <div> <a href="/register" class="d-none d-sm-inline-block btn btn btn-info shadow-sm">  Register  </a></div>

        </sec:authorize>

        <sec:authorize access="isAuthenticated()">
            <div> <a href="/logout" class="d-none d-sm-inline-block btn btn btn-danger shadow-sm">  Logout  </a></div>

            <%--        <li class="nav-item dropdown no-arrow">--%>
<%--            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"--%>
<%--               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
<%--                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Douglas McGee</span>--%>
<%--                <img class="img-profile rounded-circle"--%>
<%--                     src="../../resources/admin2/img/undraw_profile.svg">--%>
<%--            </a>--%>
<%--            <!-- Dropdown - User Information -->--%>
<%--            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"--%>
<%--                 aria-labelledby="userDropdown">--%>

<%--                <a class="dropdown-item" href="/logged/profile">--%>
<%--                    <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>--%>
<%--                    Profile--%>
<%--                </a>--%>
<%--                <a class="dropdown-item" href="/logged/settings">--%>
<%--                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>--%>
<%--                    Settings--%>
<%--                </a>--%>
<%--                <div class="dropdown-divider"></div>--%>
<%--                <a class="dropdown-item" href="/logout" data-toggle="modal" data-target="#logoutModal">--%>
<%--                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>--%>
<%--                    Logout--%>
<%--                </a>--%>
<%--            </div>--%>
<%--        </li>--%>
        </sec:authorize>
    </ul>

</nav>