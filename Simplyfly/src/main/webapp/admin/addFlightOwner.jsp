<%@ page contentType="text/html; charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Flight Owners — SimplyFly Admin</title>
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
    .btn-add {
      background:linear-gradient(45deg,#43cea2,#185a9d);
      color:#fff;
    }
    .btn-add:hover {
      background:linear-gradient(45deg,#185a9d,#43cea2);
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
          <li class="nav-item">
            <a class="nav-link" href="dashboard">Dashboard</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="manageUsers">Users</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" href="addFlightOwner">Flight Owners</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="routes">Routes</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="bookings">Bookings</a>
          </li>
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
    <h2 class="header">Flight Owners Management</h2>
    <div class="row g-4">
      <!-- LIST -->
      <div class="col-lg-7">
        <div class="card">
          <div class="card-header bg-white">
            <h5 class="mb-0">Existing Flight Owners</h5>
          </div>
          <div class="card-body p-0">
            <table class="table mb-0">
              <thead class="table-light">
                <tr>
                  <th>ID</th>
                  <th>Name</th>
                  <th>Email</th>
                  <th>Contact</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="o" items="${owners}">
                  <tr>
                    <td>${o.userID}</td>
                    <td>${o.name}</td>
                    <td>${o.email}</td>
                    <td>${o.contactNumber}</td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>

      <!-- ADD FORM -->
      <div class="col-lg-5">
        <div class="card">
          <div class="card-header bg-white">
            <h5 class="mb-0">Add New Flight Owner</h5>
          </div>
          <div class="card-body">
            <c:if test="${not empty msg}">
              <div class="alert alert-success">${msg}</div>
            </c:if>
            <form action="addFlightOwner" method="post">
              <div class="mb-3">
                <label for="name" class="form-label">Owner Name</label>
                <input type="text" id="name" name="name"
                       class="form-control" required>
              </div>
              <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" id="email" name="email"
                       class="form-control" required>
              </div>
              <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" id="password" name="password"
                       class="form-control" required>
              </div>
              <div class="mb-3">
                <label for="contact" class="form-label">Contact Number</label>
                <input type="tel" id="contact" name="contactNumber"
                       class="form-control">
              </div>
              <div class="mb-3">
                <label for="address" class="form-label">Address</label>
                <textarea id="address" name="address"
                          class="form-control" rows="2"></textarea>
              </div>
              <div class="d-grid">
                <button type="submit" class="btn btn-add">
                  <i class="fas fa-user-plus me-1"></i>Create Owner
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
  </script>
</body>
</html>
