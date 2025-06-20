<%@ page contentType="text/html; charset=UTF-8" language="java" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Search Flights — SimplyFly</title>
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
    .card-search {
      max-width: 700px;
      margin: 3rem auto;
      border: none;
      box-shadow: 0 4px 12px rgba(0,0,0,0.05);
      border-radius: 12px;
    }
  </style>
</head>
<body>
  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
    <div class="container-fluid">
      <a class="navbar-brand" href="<c:url value='dashboard'/>">SimplyFly</a>
      <button class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navMenu">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navMenu">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link active" href="<c:url value='dashboard'/>">Dashboard</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<c:url value='bookingHistory'/>">My Bookings</a>
          </li>
        </ul>
        <ul class="navbar-nav">
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#">
              <i class="fas fa-user-circle me-1"></i>${sessionScope.user.getName()}
            </a>
            <ul class="dropdown-menu dropdown-menu-end">
              <li><a class="dropdown-item" href="<c:url value='/profile'/>">Profile</a></li>
              <li><hr class="dropdown-divider"/></li>
              <li><a class="dropdown-item" href="<c:url value='/logout'/>">Logout</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Search Card -->
  <div class="card card-search">
    <div class="card-body p-4">
      <h3 class="card-title text-center mb-4">Search Flights</h3>
      <form action="<c:url value='/passenger/search'/>" method="post">
        <div class="row g-3">
          <div class="col-md-4">
            <label class="form-label" for="origin">Origin</label>
            <input list="cities" class="form-control" id="origin" name="origin" required>
          </div>
          <div class="col-md-4">
            <label class="form-label" for="destination">Destination</label>
            <input list="cities" class="form-control" id="destination" name="destination" required>
          </div>
          <div class="col-md-4">
            <label class="form-label" for="date">Date of Journey</label>
            <input type="date" class="form-control" id="date" name="date"
                   min="${today}" required>
          </div>
        </div>
        <datalist id="cities">
          <option value="New York"/>
          <option value="London"/>
          <option value="Delhi"/>
          <option value="Singapore"/>
          <option value="Tokyo"/>
        </datalist>
        <div class="d-grid mt-4">
          <button type="submit" class="btn btn-primary btn-lg">
            <i class="fas fa-search me-2"></i>Find Flights
          </button>
        </div>
      </form>
    </div>
  </div>

  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"/>
  </script>
</body>
</html>
