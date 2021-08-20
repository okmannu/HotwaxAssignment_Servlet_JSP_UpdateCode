<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%
String uname = request.getParameter("email");
String upass = request.getParameter("pass");

if(uname.equals("manish") && upass.equals("123"))
{
session.setAttribute("uname" ,uname);
response.sendRedirect("session3");
}else{
	
	out.println( "<h2>user or password do not match!!!!! </h2>");
}
%>



</body>
</html>