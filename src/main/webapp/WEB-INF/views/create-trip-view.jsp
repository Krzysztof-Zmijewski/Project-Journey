<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create-trip-view</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<form:form method="Post" modelAttribute="trip" action="/journey/destination/trip/create?ids=${ids}" >
    <div>
        <label for="place">place:
            <form:input path="place" autocomplete="true"/>
        </label>
    </div>
    <div>
        <label for="current">Date:
            <form:input type="date" path="current" autocomplete="true"/>
        </label>
    </div>
    <div>
        <label for="cost">Cost:
            <form:input path="cost" autocomplete="true"/>
        </label>
    </div>
    <div>
        <label for="currency">Currency:
            <form:select path="currency" items="${currency}"/>
        </label>
    </div>
    <form:input path="id" autocomplete="true" type="hidden"/>
    <form:button type="submit">Submit</form:button>
</form:form>
</body>
</html>
