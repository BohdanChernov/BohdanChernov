<%--
  Created by IntelliJ IDEA.
  User: PCUser
  Date: 03/26/2020
  Time: 8:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@ include file="css/style.css"%>
    </style>
</head>
<body>

<div id="mainContainer">

    <h3>Login:</h3>

    <form action="" method="post">
        E-mail: <input type="text" name="email"/>
        <br>
        <br>
        Password: <input type="text" name="password"/>
        <br>
        <br>
        <input type="submit" value="Submit login"/>
    </form>

    <p>To main page <a href="/">Click here to the main page.</a></p>

    <p>To make registration. <a href="/registration">"Click here"</a></p>

</div>

</body>
</html>
