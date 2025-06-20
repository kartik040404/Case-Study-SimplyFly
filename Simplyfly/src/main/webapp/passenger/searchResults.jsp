<%@ page contentType="text/html; charset=UTF-8" language="java" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Available Flights — SimplyFly</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet"/>
</head>
<body>
  <!-- reuse same navbar as dashboard.jsp -->
  <%@ include file="dashboard.jsp" %>

  <div class="container py-5">
    <h3 class="mb-4">
      Flights on ${searchDate} from ${param.origin} → ${param.destination}
    </h3>
    <table class="table table-hover shadow-sm bg-white rounded">
      <thead class="table-light">
        <tr>
          <th>Flight No.</th>
          <th>Flight Name</th>
          <th>Departs</th>
          <th>Arrives</th>
          <th>Fare</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="f" items="${flights}">
          <tr>
            <td>${f.number}</td>
            <td>${f.name}</td>
            <td>${f.departureTime}</td>
            <td>${f.arrivalTime}</td>
            <td>${f.fare}</td>
            <td>
              <a href="<c:url value='/passenger/book?flightId=${f.id}'/>"
                 class="btn btn-sm btn-success">
                Book
              </a>
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
