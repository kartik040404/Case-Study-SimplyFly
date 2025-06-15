<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Add Flight Route</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">

  <h4 class="mb-3">Add Flight Route</h4>

  <form action="addRoute" method="post" class="row g-3">

      <div class="col-md-6">
          <label class="form-label">Origin</label>
          <input name="origin" class="form-control" placeholder="DEL" required>
      </div>

      <div class="col-md-6">
          <label class="form-label">Destination</label>
          <input name="destination" class="form-control" placeholder="BOM" required>
      </div>

      <div class="col-md-6">
          <label class="form-label">Departure</label>
          <input type="datetime-local" name="departureTs" class="form-control" required>
      </div>

      <div class="col-md-6">
          <label class="form-label">Arrival</label>
          <input type="datetime-local" name="arrivalTs" class="form-control" required>
      </div>

      <div class="col-md-4">
          <label class="form-label">Fare (₹)</label>
          <input type="number" step="0.01" name="farePerSeat" class="form-control" required>
      </div>

      <div class="col-12">
          <button class="btn btn-primary">Save</button>
          <a href="/" class="btn btn-secondary">Cancel</a>
      </div>
  </form>
</div>
</body>
</html>
