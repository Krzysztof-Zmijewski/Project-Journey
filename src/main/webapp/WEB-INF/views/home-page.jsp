<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>HomePage</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
</head>

<body>
<h1 class="title has-text-centered">Your Journeys</h1>
<c:forEach var="journey" items="${journeys}">
<h2 class="subtitle has-text-centered has-text-weight-bold">${journey.title} </h2>
<div class="container has-text-centered">
 Since: ${journey.since}   To: ${journey.deadline}   Total cost: ${journey.totalCost} PLN
    <c:forEach var="destination" items="${journey.destinations}">
        <div class="container">
            <h6>${destination.place}</h6>
        </div>
    </c:forEach>
    <a href="${pageContext.request.contextPath}/journey/edit?id=${journey.id}">Edit</a>
    <a href="${pageContext.request.contextPath}/journey/destination?id=${journey.id}">Details</a>
    <a href="${pageContext.request.contextPath}/journey/delete?id=${journey.id}">Delete</a>
</div>
</c:forEach>
<br/>
<div class="control">
    <a href="${pageContext.request.contextPath}/journey/create" class="button is-link">Create new Journey</a>
</div>
</body>
</html>
