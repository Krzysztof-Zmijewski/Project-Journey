<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>details-journey-view</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<h2 class="title has-text-centered">${journey.title} </h2>
<div class="has-text-centered has-addons-right">
    Since: ${journey.since}  To: ${journey.deadline}  Total cost: ${journey.totalCost} PLN
    <a href="${pageContext.request.contextPath}/journey/edit?id=${journey.id}" class="button is-warning is-small">Edit</a>
    <a href="${pageContext.request.contextPath}/journey/delete?id=${journey.id}" class="button is-danger is-small">Delete</a>
</div>
<div class="has-text-centered">
    <div class="has-text-centered">
        <h2 class="subtitle">Destinations</h2>
        <a href="${pageContext.request.contextPath}/journey/destination/create?id=${journey.id}" class="button is-info is-small">Create Destination</a>
    </div>
    <c:forEach items="${journey.destinations}" var="destination">
        <div>
            <h3>${destination.place}</h3>
        </div>
        <div>
            Since: ${destination.since}  To: ${destination.deadline}  Cost: ${destination.cost} ${destination.currency}  <a href="${destination.link}">${destination.link}</a>
            <a href="${pageContext.request.contextPath}/journey/destination/edit?id=${destination.id}&ids=${journey.id}" class="button is-warning is-small">Edit </a>
            <a href="${pageContext.request.contextPath}/journey/destination/delete?id=${destination.id}&ids=${journey.id}" class="button is-danger is-small"> Delete</a>
        </div>
        <div>
            <h4 class="subtitle">Trips</h4>
            <a href="${pageContext.request.contextPath}/journey/destination/trip/create?ids=${destination.id}" class="button is-small is-info">Create Trip</a>
        </div>
            <table class="table is-bordered is-fullwidth">
                <tr>
                    <th>Place</th>
                    <th>Cost</th>
                    <th>Date</th>
                    <th>Action</th>
                </tr>
            <c:forEach var="trip" items="${destination.trips}">
                <tr>
                    <td>${trip.place}</td>
                    <td>${trip.cost}</td>
                    <td>${trip.current}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/journey/destination/trip/edit?id=${trip.id}&ids=${destination.id}" class="button is-warning is-small">Edit</a>
                        <a href="${pageContext.request.contextPath}/journey/destination/trip/delete?id=${trip.id}&ids=${journey.id}" class="button is-danger is-small">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </table>
   </c:forEach>
</div>
<a href="${pageContext.request.contextPath}/journey" class="button is-info">Back to Homepage</a>
</body>
</html>
