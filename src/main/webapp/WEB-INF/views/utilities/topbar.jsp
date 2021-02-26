<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

    <!-- Sidebar Toggle (Topbar) -->
    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
        <i class="fa fa-bars"></i>
    </button>

    <div>
        <sec:authorize access="isAuthenticated()">
            Welcome <sec:authentication property="principal.username"/>
        </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
            Plan Generator
        </sec:authorize>
    </div>

    <!-- Topbar Navbar -->
    <ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown no-arrow d-sm-none">
            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-search fa-fw"></i>
            </a>
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

        <div class="topbar-divider d-none d-sm-block"></div>

        <!-- Nav Item - User Information -->
        <sec:authorize access="!isAuthenticated()">
            <div><a href="/login" class="d-none d-sm-inline-block btn btn btn-primary shadow-sm"> Login </a></div>
            <div class="topbar-divider d-none d-sm-block"></div>
            <div><a href="/register" class="d-none d-sm-inline-block btn btn btn-info shadow-sm"> Register </a></div>
        </sec:authorize>

        <sec:authorize access="isAuthenticated()">
            <div><a href="/logout" class="d-none d-sm-inline-block btn btn btn-danger shadow-sm"> Logout </a></div>
        </sec:authorize>
    </ul>

</nav>