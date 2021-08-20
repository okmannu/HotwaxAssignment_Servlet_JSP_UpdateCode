<!DOCTYPE html>
<html>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
<div align="center">
<caption><h2>Student Management Application List</h2></caption>
 <table border="1" cellpadding="9" class="table table-success table-striped" >
               <tr>      
                <th>FirstName</th>                
                <th>LastName</th>                
                <th>Address</th>                
                <th>City</th>                               
                <th>zip</th>
                <th>State</th>
                <th>Country</th>
                <th>Phone</th>
                <th>Id</th>
                <th>Password</th>   
                <th> Action1</th>
                <th> Action2</th>        
                </tr>
                <%
try{
Class.forName("com.mysql.jdbc.Driver");
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
Statement stm = connection.createStatement();
String USERS_Login = "Select * from party_table"; 
ResultSet resultset = stm.executeQuery(USERS_Login);
while(resultset.next()){  
%>
       <tr> 
        <td><%= resultset.getString(1) %></td>  
        <td><%= resultset.getString(2) %></td>  
        <td><%= resultset.getString(3) %></td> 
        <td><%= resultset.getString(4) %></td>  
        <td><%= resultset.getString(5) %></td>  
        <td><%= resultset.getString(6) %></td>  
        <td><%= resultset.getString(7) %></td>  
        <td><%= resultset.getString(8) %></td>  
        <td><%= resultset.getString(9) %></td> 
        <td><%= resultset.getString(10) %></td> 
        <td> <a href="update.jsp?ed=<%= resultset.getString(9)%>">UPDATE</a> </td> 
        <td> <a href="Delete?ed=<%= resultset.getString(9)%>">DELETE</a> </td> 
        </tr>
 <%
} 
}catch (Exception e){
e.printStackTrace();
}
%> 
</table>
</div>	
</body>
</html>