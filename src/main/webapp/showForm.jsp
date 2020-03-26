<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
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
</head>
<body>
<h3>Show form:</h3>

<%
    String name = request.getParameter("userName");
    String last = request.getParameter("lastName");
    ArrayList<String> list = (ArrayList) request.getAttribute("listOfNames");
%>

<c:forEach items="${list}" var="name">
    <br>${name}
</c:forEach>

<br>
Name: <%=name%>
<br>
Last name: <%=last%>


</body>
</html>
