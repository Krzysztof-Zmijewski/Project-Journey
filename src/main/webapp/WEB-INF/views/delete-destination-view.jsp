<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete-destination-view</title>
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
    body {
        background-image: url('${pageContext.request.contextPath}/jpg/pexels-asad-photo-maldives-457881.jpg');
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-size: cover;
    }

</style>
<body>
<div class="content">
    <h1 class="title has-text-centered">Delete Destination</h1>
    <form method="post">
        <p class="has-text-centered">Do you want to delete "${destination.place}"?</p>
        <input type="hidden" name="id" value="${destination.id}"/>
        <input type="hidden" name="ids" value="${ids}">
        <button type="submit" class="button is-danger">Yes</button><a href="${pageContext.request.contextPath}/journey" class="button is-link">No</a>
    </form>
</div>
</body>
</html>
