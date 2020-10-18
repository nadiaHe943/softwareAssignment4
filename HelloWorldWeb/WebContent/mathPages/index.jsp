<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page Controller Example</title>
</head>
<body>

Enter two numeric values
<form name="frm" method="get" action="/HelloWorldWeb/MathPageController">
Enter value a: <input type="text" name="a">
Enter value b: <input type="text" name="b">
<input type="submit" name="submit" value="submit">
</form>

go <a href="/HelloWorldWeb/index.jsp">back</a>
<h2></h2>
</body>
</html>