<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create-journey-view</title>
</head>
<body>
<form:form method="post" modelAttribute="journey" >
    <div>
        <label for="title">Title:
            <form:input path="title"/>
        </label>
    </div>
    <div>
        <label for="since">Since:
            <form:input type="date" path="since"/>
        </label>
    </div>
    <div>
        <label for="deadline">To:
            <form:input type="date" path="deadline"/>
        </label>
    </div>
    <form:button type="submit">Submit</form:button>
</form:form>
</body>
</html>
