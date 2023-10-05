<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
</head>
<body>
<c:forEach var="journey" items="${journeys}">
<h2>${journey.title} </h2>
<div>
Since: ${journey.since}  To: ${journey.deadline}  Total cost: ${journey.totalCost}
</div>
    <c:forEach var="destination" items="${journey.destinations}">
    <div>
        <h6>${destination.place}</h6>
    </div>
    </c:forEach>
    <a href="${pageContext.request.contextPath}/journey/edit?id=${journey.id}">Edit</a>
    <a href="${pageContext.request.contextPath}/journey">Details</a>
    <a href="${pageContext.request.contextPath}/journey/delete?id=${journey.id}">Delete</a>
</c:forEach>
<br/>
<a href="${pageContext.request.contextPath}/journey/create">Create new Journey</a>
</body>
</html>
