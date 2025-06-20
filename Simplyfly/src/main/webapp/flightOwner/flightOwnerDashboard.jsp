<%@ page contentType="text/html; charset=UTF-8" language="java" session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Flight Owner Dashboard — SimplyFly</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet">
</head>
<body>
  <% String owner = (String) session.getAttribute("userName"); %>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Owner Panel</a>
      <div>
        <span class="navbar-text text-white">Hello, <strong><%= owner %></strong></span>
        <a href="logout" class="btn btn-outline-light ms-3">Logout</a>
      </div>
    </div>
  </nav>

  <div class="container py-4">
    <h2>Manage Your Flights</h2>
    <div class="row g-4">
      <div class="col-md-4">
        <div class="card shadow-sm">
          <div class="card-body">
            <h5 class="card-title">Add New Route</h5>
            <a href="addRoute.jsp" class="btn btn-success">Add Route</a>
          </div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="card shadow-sm">
          <div class="card-body">
            <h5 class="card-title">View Bookings</h5>
            <a href="ownerBookings.jsp" class="btn btn-primary">See Bookings</a>
          </div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="card shadow-sm">
          <div class="card-body">
            <h5 class="card-title">Manage Inventory</h5>
            <a href="manageSeats.jsp" class="btn btn-warning">Manage Seats</a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
