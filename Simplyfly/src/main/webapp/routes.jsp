<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Flight Routes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-4">
    <h3 class="mb-3">All Flight Routes</h3>

    <c:if test="${empty routes}">
        <p class="text-muted">No routes found.</p>
    </c:if>

    <c:if test="${not empty routes}">
        <table class="table table-bordered">
            <thead class="table-light">
                <tr>
                    <th>ID</th>
                    <th>Origin</th>
                    <th>Destination</th>
                    <th>Departure</th>
                    <th>Arrival</th>
                    <th>Fare&nbsp;(₹)</th>
                </tr>
            </thead>
            <tbody>
               <c:forEach items="${routes}" var="r">
                   <tr>
                       <td>${r.routeId}</td>
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
