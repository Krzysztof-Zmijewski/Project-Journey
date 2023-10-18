<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Destination</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<style>
    form{
        width: 25%;
        padding: 50px;
        border-radius: 10px;
        background-color: cornflowerblue;

        position: absolute;
        left: 37%;
        top: 20%;
    }

</style>
<body>
<form:form method="Post" modelAttribute="destination" action="/journey/destination/create?ids=${ids}" >
    <div>
        <label class="label" for="place">Place:
            <form:input path="place" autocomplete="true"/>
        </label>
    </div>
    <div>
        <label class="label" for="since">Since:
            <form:input type="date" path="since" autocomplete="true"/>
        </label>
    </div>
    <div>
        <label class="label" for="deadline">To:
            <form:input type="date" path="deadline" autocomplete="true"/>
        </label>
    </div>
    <div>
        <label class="label" for="cost">Cost:
            <form:input path="cost" autocomplete="true"/>
        </label>
    </div>
    <div>
        <label class="label" for="currency">Currency:
            <form:select path="currency" items="${currency}"/>
        </label>
    </div>
    <div>
        <label class="label" for="link">Link:
            <form:input path="link" autocomplete="true"/>
        </label>
    </div>
    <form:input path="id" autocomplete="true" type="hidden"/>
    <button type="submit" class="button is-primary is-small">Submit</button>
</form:form>
</body>
</html>
