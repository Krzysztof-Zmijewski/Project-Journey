<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>create-journey-view</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
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
<div class="content">
    <form:form method="Post" modelAttribute="journey" action="/journey/create"  >
        <div>
            <label class="label" for="title">Title</label>
                <div class="control">
                    <form:input cssClass="input" path="title" autocomplete="true" />
                </div>
        </div>
        <div>
            <label class="label" for="since">Since</label>
            <div class="control">
                <form:input cssClass="input" type="date" path="since" autocomplete="true"/>
            </div>
        </div>
        <div>
            <label class="label" for="deadline">To</label>
            <div>
                <form:input cssClass="input" type="date" path="deadline" autocomplete="true"/>
            </div>
        </div>
    <%--    <div>--%>
    <%--        <label for="currency">Currency:--%>
    <%--            <form:select path="currency" items="${currency}"/>--%>
    <%--        </label>--%>
    <%--    </div>--%>
        <form:input path="id" autocomplete="true" type="hidden"/>
            <p class="control">
                <button type="submit" class="button is-primary is-small">Submit</button>
            </p>
    </form:form>
</div>
</body>
</html>
