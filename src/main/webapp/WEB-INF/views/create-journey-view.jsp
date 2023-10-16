<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create-journey-view</title>
</head>
<body>
<form:form method="Post" modelAttribute="journey" action="/journey/create" >
    <div>
        <label for="title">Title:
            <form:input path="title" autocomplete="true"/>
        </label>
    </div>
    <div>
        <label for="since">Since:
            <form:input type="date" path="since" autocomplete="true"/>
        </label>
    </div>
    <div>
        <label for="deadline">To:
            <form:input type="date" path="deadline" autocomplete="true"/>
        </label>
    </div>
<%--    <div>--%>
<%--        <label for="currency">Currency:--%>
<%--            <form:select path="currency" items="${currency}"/>--%>
<%--        </label>--%>
<%--    </div>--%>
    <form:input path="id" autocomplete="true" type="hidden"/>
    <form:button type="submit">Submit</form:button>
</form:form>
</body>
</html>
