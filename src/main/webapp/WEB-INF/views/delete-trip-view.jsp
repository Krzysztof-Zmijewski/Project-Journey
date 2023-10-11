<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete-trip-view</title>
</head>
<body>
<h1>Delete Trip</h1>
<p>Do you want to delete "${trip.place}"?</p>
<form method="post">
    <input type="hidden" name="id" value="${trip.id}"/>
    <input type="hidden" name="ids" value="${ids}">
    <button type="submit">Yes</button>
    | <a href="${pageContext.request.contextPath}/journey">No</a>
</form>
</body>
</html>
