<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Routes Page — SimplyFly Admin</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet"/>
  <link
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
    rel="stylesheet"/>
  <style>
    body { background: #f5f7fa; font-family: 'Segoe UI', sans-serif; }
    .navbar-brand { font-weight: bold; }
    .nav-link { font-weight: 500; }
    .dropdown-menu-end { right: 0; left: auto; }
  </style>
</head>
<body>

  <nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
    <div class="container-fluid">
      <a class="navbar-brand" href="dashboard">SimplyFly Admin</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navMenu">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navMenu">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item"><a class="nav-link" href="dashboard">Dashboard</a></li>
          <li class="nav-item"><a class="nav-link" href="manageUsers">Users</a></li>
          <li class="nav-item"><a class="nav-link" href="addFlightOwner">Flight Owners</a></li>
          <li class="nav-item"><a class="nav-link active" href="routes">Routes</a></li>
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
              <li><a class="dropdown-item" href="logout">Logout</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="d-flex vh-100 justify-content-center align-items-center">
    <h1 class="display-4">Routes Page</h1>
  </div>

  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
  </script>
</body>
</html>
