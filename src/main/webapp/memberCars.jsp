<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Member" %>
<%@ page import="models.Car" %>
<%@ page import="java.util.List" %><%--
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

    Congrats!

    <br>

    <%
        Member member = (Member) request.getAttribute("member");
        List<Car> list = (List<Car>) request.getAttribute("cars");
    %>

    <%
        for (Car car : list) {
    %>
    <br><%= "Model: " + car.getModel() + " Owner: " + car.getOwner().getName()%>
    <%
        }
    %>

    <p>To main page <a href="/">Click here to the main page.</a></p>

</div>

</body>
</html>
