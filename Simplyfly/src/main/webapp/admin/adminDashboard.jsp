<%@ page contentType="text/html; charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Admin Dashboard — SimplyFly</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet"/>
  <link
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
    rel="stylesheet"/>
  <style>
    body { font-family: 'Segoe UI', sans-serif; background: #f5f7fa; }
    .navbar-brand { font-weight: bold; }
    .nav-link { font-weight: 500; }
    .card-dashboard {
      border: none;
      border-radius: 12px;
      box-shadow: 0 4px 12px rgba(0,0,0,0.05);
      transition: transform .3s, box-shadow .3s;
    }
    .card-dashboard:hover {
      transform: translateY(-5px);
      box-shadow: 0 10px 30px rgba(0,0,0,0.1);
    }
    .card-icon {
      font-size: 2rem;
      width: 60px; height: 60px;
      display: flex; align-items: center; justify-content: center;
      border-radius: 50%;
      margin: auto 0 1rem;
      color: #fff;
    }
    .icon-users    { background: #007bff; }
    .icon-owners   { background: #28a745; }
    .icon-routes   { background: #ffc107; }
    .icon-bookings { background: #dc3545; }
  </style>
</head>
<body>
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
              <i class="fas fa-user-circle me-1"></i>${sessionScope.user.getName()}
            </a>
            <ul class="dropdown-menu dropdown-menu-end">
              <li><a class="dropdown-item" href="profilePage">Profile</a></li>
              <li><hr class="dropdown-divider"></li>
<li>
  <a class="dropdown-item" href="<c:url value='/logout'/>">Logout</a>
</li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="container py-5">
    <h2 class="mb-4">Welcome, ${sessionScope.user.getName()}</h2>
    <div class="row g-4">
      <div class="col-sm-6 col-lg-3">
        <div class="card card-dashboard text-center p-4">
          <div class="card-icon icon-users">
            <i class="fas fa-users"></i>
          </div>
          <h5>Manage Users</h5>
          <a href="admin/manageUsers" class="btn btn-outline-primary mt-2">Go</a>
        </div>
      </div>
      <div class="col-sm-6 col-lg-3">
        <div class="card card-dashboard text-center p-4">
          <div class="card-icon icon-owners">
            <i class="fas fa-plane"></i>
          </div>
          <h5>Flight Owners</h5>
          <a href="admin/addFlightOwner" class="btn btn-outline-success mt-2">Go</a>
        </div>
      </div>
      <div class="col-sm-6 col-lg-3">
        <div class="card card-dashboard text-center p-4">
          <div class="card-icon icon-routes">
            <i class="fas fa-route"></i>
          </div>
          <h5>Manage Routes</h5>
          <a href="admin/manageRoutes" class="btn btn-outline-warning mt-2">Go</a>
        </div>
      </div>
      <div class="col-sm-6 col-lg-3">
        <div class="card card-dashboard text-center p-4">
          <div class="card-icon icon-bookings">
            <i class="fas fa-ticket-alt"></i>
          </div>
          <h5>View Bookings</h5>
          <a href="admin/manageBookings" class="btn btn-outline-danger mt-2">Go</a>
        </div>
      </div>
    </div>
  </div>
  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
  </script>
</body>
</html>
