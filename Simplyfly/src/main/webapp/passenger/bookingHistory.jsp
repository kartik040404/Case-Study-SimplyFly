<%@ page contentType="text/html; charset=UTF-8" language="java" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>My Bookings — SimplyFly</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet"/>
</head>
<body>
  <!-- reuse same navbar as dashboard.jsp -->
  <%@ include file="dashboard.jsp" %>

  <div class="container py-5">
    <h3 class="mb-4">My Booking History</h3>
    <table class="table table-bordered shadow-sm bg-white rounded">
      <thead class="table-light">
        <tr>
          <th>Booking ID</th>
          <th>Flight No.</th>
          <th>Date</th>
          <th>Seats</th>
          <th>Total Fare</th>
          <th>Status</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="b" items="${bookings}">
          <tr>
            <td>${b.id}</td>
            <td>${b.flight.number}</td>
            <td>${b.date}</td>
            <td>${b.seatsBooked}</td>
            <td>${b.totalFare}</td>
            <td>${b.status}</td>
            <td>
              <form action="<c:url value='/passenger/cancel/${b.id}'/>"
                    method="post" style="display:inline">
                <button class="btn btn-sm btn-danger"
                        onclick="return confirm('Cancel this booking?')">
                  Cancel
                </button>
              </form>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"/>
  </script>
</body>
</html>
