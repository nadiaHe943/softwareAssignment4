<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
Double total=(Double)request.getAttribute("total");
Integer numOperations=(Integer)request.getAttribute("numOperations");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page Controller Example</title>
</head>
<body>

<p>
The result is <%=total%>. The number of executed operations is <%=numOperations %>
</p>

Go <a href="mathPages/index.jsp">back</a> 
</body>
</html>