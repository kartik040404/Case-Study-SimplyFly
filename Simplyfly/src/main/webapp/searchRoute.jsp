<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Search Flight Routes</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
  <h3>Search Flight Routes</h3>
  <form action="searchRoute" method="post" class="row g-2 mb-4">
    <div class="col-md-4">
      <input name="origin" class="form-control" placeholder="Origin (e.g. DEL)" required>
    </div>
    <div class="col-md-4">
      <input name="destination" class="form-control" placeholder="Destination (e.g. BOM)" required>
    </div>
    <div class="col-md-3">
      <input type="date" name="date" class="form-control" required>
    </div>
    <div class="col-md-1 d-grid">
      <button class="btn btn-primary">Search</button>
    </div>
  </form>

  <c:if test="${empty routes}">
    <p>No routes found.</p>
  </c:if>

  <c:if test="${not empty routes}">
    <table class="table table-striped">
      <thead>
        <tr>
          <th>ID</th><th>Origin</th><th>Destination</th>
          <th>Departure</th><th>Arrival</th><th>Fare</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="r" items="${routes}">
          <tr>
            <td>${r.routeID}</td>
            <td>${r.origin}</td>
            <td>${r.destination}</td>
            <td>${r.departureTs}</td>
            <td>${r.arrivalTs}</td>
            <td>${r.farePerSeat}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </c:if>
</div>
</body>
</html>
