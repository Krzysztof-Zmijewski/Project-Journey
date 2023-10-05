<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete-journey-view</title>
</head>
<body>
<h1>Delete Journey</h1>
<p>Do you want to delete "${journey.get().title}"?</p>
<form method="post">
    <input type="hidden" name="id" value="${journey.get().id}"/>
    <button type="submit">Yes</button>
    | <a href="${pageContext.request.contextPath}/journey">No</a>
</form>
</body>
</html>
