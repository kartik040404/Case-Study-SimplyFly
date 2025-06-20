<%@ page contentType="text/html; charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>My Profile — SimplyFly Admin</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet"/>
  <link
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
    rel="stylesheet"/>
  <style>
    /* Reused from adminDashboard.jsp */
    body { background: #f5f7fa; font-family: 'Segoe UI', sans-serif; }
    .navbar-brand { font-weight: bold; }
    .nav-link { font-weight: 500; }
    .dropdown-menu-end { right: 0; left: auto; }

    /* Profile card styling */
    .profile-card {
      max-width: 500px;
      margin: 3rem auto;
      border: none;
      border-radius: 12px;
      box-shadow: 0 4px 16px rgba(0,0,0,0.05);
    }
    .profile-header {
      background: linear-gradient(45deg, #4facfe, #00f2fe);
      color: #fff;
      border-top-left-radius: 12px;
      border-top-right-radius: 12px;
      padding: 1.5rem;
      text-align: center;
    }
    .profile-header i {
      font-size: 2.5rem;
      margin-bottom: 0.5rem;
    }
    .profile-body { padding: 1.5rem; }
    .profile-body p {
      font-size: 1rem;
      margin-bottom: 0.75rem;
    }
    .profile-body strong { width: 120px; display: inline-block; }
  </style>
</head>
<body>
  <!-- Navbar identical to dashboard.jsp -->
  <nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
    <div class="container-fluid">
      <a class="navbar-brand" href="dashboard">SimplyFly Admin</a>
      <button class="navbar-toggler" type="button"
              data-bs-toggle="collapse"
              data-bs-target="#navMenu">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navMenu">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link" href="dashboard">Dashboard</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="manageUsers">Users</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="addFlightOwner">Flight Owners</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="routes">Routes</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="bookings">Bookings</a>
          </li>
        </ul>
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link" href="logout">
              <i class="fas fa-sign-out-alt me-1"></i>Logout
            </a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Profile card -->
  <div class="card profile-card">
    <div class="profile-header">
      <i class="fas fa-user-circle"></i>
      <h4>${sessionScope.user.getName()}</h4>
    </div>
    <div class="profile-body">
      <p><strong>Email:</strong> ${sessionScope.user.getEmail()}</p>
      <p><strong>Contact:</strong> ${sessionScope.user.getContactNumber()}</p>
      <p><strong>Address:</strong> ${sessionScope.user.getAddress()}</p>
    </div>
  </div>

  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
  </script>
</body>
</html>
