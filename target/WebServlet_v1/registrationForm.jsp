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

    <h3>Registration:</h3>

    <form action="" method="post">
        Name: <input type="text" name="userName"/>
        <br>
        <br>
        Last Name: <input type="text" name="lastName"/>
        <br>
        <br>
        E-mail: <input type="text" name="email"/>
        <br>
        <br>
        Password: <input type="text" name="password"/>
        <br>
        <br>
        <input type="submit" value="Submit registration"/>
    </form>


    <p>To main page <a href="/">Click here to the main page.</a></p>

    <p>To login. <a href="/login">"Click here"</a></p>

</div>

</body>
</html>
