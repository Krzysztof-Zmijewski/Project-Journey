<!DOCTYPE html>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete-journey-view</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<style>
    form{
        width: 18%;
        padding: 50px;
        border-radius: 10px;
        background-color: cornflowerblue;

        position: absolute;
        left: 41%;
        top: 23%;
    }

</style>
<body>
<h1 class="title has-text-centered">Delete Journey</h1>
<div class="content">
<form method="post">
    <p class="has-text-centered">Do you want to delete "${journey.title}"?</p>
    <input type="hidden" name="id" value="${journey.id}"/>
    <button class="button is-danger" type="submit">Yes</button><a href="${pageContext.request.contextPath}/journey" class="button is-link">No</a>
</form>
</div>
</body>
</html>
