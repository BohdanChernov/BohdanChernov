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

<%
    String str = (String) request.getAttribute("colorOfPage");
%>

<body style="background-color: <%=str%>">


<div id="mainContainer">
    Congrats!

    <br>
    <br>

    <form method="post" action="">

        <label><select name="colorOfPage">
            <option value="black">Black</option>
            <option value="white">White</option>
            <option value="red">Red</option>
            <option value="green">Green</option>
        </select></label>


        <label><input type="submit" value="Submit"></label>
    </form>

    <br>
    <p>To main page <a href="/">Click here to the main page.</a></p>
</div>


</body>
</html>
