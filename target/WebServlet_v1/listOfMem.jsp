<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Member" %><%--
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
    ArrayList<Member> list = (ArrayList) request.getAttribute("list");
%>

<%
    for (Member member : list) {
%>
<br><%= "Name: " + member.getName() + " Last name: " + member.getLastName()%>
<%
    }
%>

<p>To main page <a href="/">Click here to the main page.</a></p>

</div>

</body>
</html>
