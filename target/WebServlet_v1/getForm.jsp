<%@ page import="models.Member" %>
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
<h3>Registration:</h3>

<form action="" method="post">
    Name: <input type="text" name="userName"/>
    <br>
    LastName: <input type="text" name="lastName"/>
    <br>
    <input type="submit" value="Okay"/>
</form>


<h3>Show form:</h3>

<%
    ArrayList<Member> members = (ArrayList) request.getAttribute("listOfNames");
    String name = (String)request.getAttribute("userName");
    String last = (String)request.getAttribute("lastName");

%>


Your name: <%=name%>
<br>
Your last name: <%=last%>

<p>Go <a href="/">back</a> </p>

<p><h3>List of registered members:</h3></p>
<br>
<%for (Member m : members) {%>
<br><%=m.getName()%>
<%=m.getLastName()%>
<br>

<%}%>


</body>
</html>
