<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="view.math.HelperMath" %>
<%
String total=((HelperMath)request.getAttribute("helperMath")).getResult();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Template View Example</title>
</head>
<body>

<p>
The result is <%=total%>. 
</p>

Go <a href="index.jsp">back</a> 
</body>
</html>