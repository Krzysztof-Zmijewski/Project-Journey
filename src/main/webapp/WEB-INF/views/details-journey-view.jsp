<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>details-journey-view</title>
</head>
<body>
<h2>${journey.title} </h2>
<div>
    Since: ${journey.since}  To: ${journey.deadline}  Total cost: ${journey.totalCost}
    <a href="${pageContext.request.contextPath}/journey/edit?id=${journey.id}">Edit</a>
    <a href="${pageContext.request.contextPath}/journey/delete?id=${journey.id}">Delete</a>
</div>
<div>
    <h2>Destinations</h2>
    <a href="${pageContext.request.contextPath}/journey/destination/create?id=${journey.id}">Create Destination</a>
</div>
<c:forEach items="${journey.destinations}" var="destination" varStatus="current">
    <div>
        <h3>${destination.place}</h3>
    </div>
    <div>
        Since: ${destination.since}  To: ${destination.deadline}  Cost: ${destination.cost}  <a href="${destination.link}">Link</a>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/journey/destination/edit?id=${destination.id}&ids=${journey.id}">Edit </a>
        <a href="${pageContext.request.contextPath}/journey/destination/delete?id=${destination.id}&ids=${journey.id}"> Delete</a>
    </div>
    <div>
        <h4>Trips</h4>
        <a href="${pageContext.request.contextPath}/journey/destination/trip/create?ids=${destination.id}">Create Trip</a>
    </div>
        <table>
            <tr>
                <th>Place</th>
                <th>Cost</th>
                <th>Date</th>
            </tr>
    <c:forEach var="trip" items="${destination.trips}">
            <tr>
                <td>${trip.place}</td>
                <td>${trip.cost}</td>
                <td>${trip.current}</td>
            </tr>
        <a href="${pageContext.request.contextPath}/journey/destination/trip/edit?id=${trip.id}&ids=${journey.id}">Edit</a>
        <a href="${pageContext.request.contextPath}/journey/destination/trip/delete?id=${trip.id}">Delete</a>
        </table>
    </c:forEach>
</c:forEach>
<a href="${pageContext.request.contextPath}/journey">Back to Homepage</a>
</body>
</html>
