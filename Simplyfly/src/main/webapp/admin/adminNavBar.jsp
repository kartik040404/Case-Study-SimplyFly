<nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">SimplyFly Admin</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navMenu">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navMenu">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item"><a class="nav-link active" href="dashboard">Dashboard</a></li>
          <li class="nav-item"><a class="nav-link" href="manageUsers">Users</a></li>
          <li class="nav-item"><a class="nav-link" href="addFlightOwner">Flight Owners</a></li>
          <li class="nav-item"><a class="nav-link" href="routes">Routes</a></li>
          <li class="nav-item"><a class="nav-link" href="bookings">Bookings</a></li>
        </ul>
        <ul class="navbar-nav">
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="profileMenu" role="button"
               data-bs-toggle="dropdown">
              <i class="fas fa-user-circle me-1"></i>${sessionScope.userName}
            </a>
            <ul class="dropdown-menu dropdown-menu-end">
              <li><a class="dropdown-item" href="profilePage">Profile</a></li>
              <li><hr class="dropdown-divider"></li>
              <li><a class="dropdown-item" href="logout">Logout</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>