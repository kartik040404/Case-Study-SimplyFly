<%@ page contentType="text/html; charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Manage Users — SimplyFly Admin</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet"/>
  <link
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
    rel="stylesheet"/>
  <style>
    body { font-family:'Segoe UI',sans-serif; background:#f5f7fa; }
    .navbar-brand { font-weight:bold; }
    .nav-link { font-weight:500; }
    .dropdown-menu-end { right:0; left:auto; }
    .header { margin:2rem 0; text-align:center; }
    .card { border:none; box-shadow:0 4px 12px rgba(0,0,0,0.05); }
    .table thead { background:#fff; }
    .btn-delete {
      color:#dc3545;
      border:1px solid #dc3545;
    }
    .btn-delete:hover {
      background: #dc3545; color:#fff;
    }
  </style>
</head>
<body>
  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
    <div class="container-fluid">
      <a class="navbar-brand" href="dashboard">SimplyFly Admin</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navMenu">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navMenu">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item"><a class="nav-link" href="dashboard">Dashboard</a></li>
          <li class="nav-item"><a class="nav-link active" href="manageUsers">Users</a></li>
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
              <li><a class="dropdown-item" href="logout">Logout</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Content -->
  <div class="container">
    <h2 class="header">Manage Users</h2>
    <div class="card mb-4">
      <div class="card-body p-0">
        <table class="table mb-0">
          <thead class="table-light">
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Email</th>
              <th>Contact</th>
              <th>Address</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="u" items="${users}">
              <tr>
                <td>${u.userID}</td>
                <td>${u.name}</td>
                <td>${u.email}</td>
                <td>${u.contactNumber}</td>
                <td>${u.address}</td>
                <td>
                  <form action="deleteUser/${u.userID}" method="post" style="display:inline-block">
                    <input type="hidden" name="userId" value="${u.userID}" />
                    <button type="submit"
                            class="btn btn-sm btn-delete"
                            onclick="return confirm('Delete user ${u.name}?');">
                      <i class="fas fa-trash"></i>
                    </button>
                  </form>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>

  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
  </script>
</body>
</html>
