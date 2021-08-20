<!DOCTYPE html>
<html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.Connection"%>
 <%@ page import="java.sql.DriverManager"%>
 <%@ page import="java.sql.Statement"%>
 <%@ page import="java.sql.Connection"%>
 <%@ page import="java.sql.ResultSet"%>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
 <title>Update Form</title>
 <style>  
  .container{
width:auto;
margin:auto;
padding:40px;
}
</style>
</head>
 <body style="background: url(img/growth.jpg);background-size: cover; background-attachment:fixed;">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
 <form class="container"  action="Update" method="post" >  
<%
try{
	 int id = Integer.parseInt(request.getParameter("ed"));
	Class.forName("com.mysql.jdbc.Driver");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
    Statement stm = connection.createStatement();
	String USERS_Login = "Select * from party_table where userId='"+id+"';"; 
    ResultSet resultset = stm.executeQuery(USERS_Login);
    while(resultset.next()){
      %>
    <div class="alert alert-dark" role="alert"> 
    <figure class="text-center">
    <blockquote class="blockquote">
    <p>..STUDENT UPDATE FROM...</p>
    </blockquote>
    </figure>
    </div>
    <div class="row g-3">
    <div class="col">
    <input type="text" class="form-control" placeholder="First name"  aria-label="First name" name="firstName" value="<%= resultset.getString(1)%> id="fname">
    </div>
    <div class="col">
    <input type="text" class="form-control" placeholder="Last name" aria-label="First name" value="<%= resultset.getString(2)%>" name="lastName" id="lname" >  
    </div>
    <div class="col">
    <input type="text" class="form-control" placeholder="ID"  aria-label="First name" value="<%= resultset.getString(9)%>" name="userId" id="id">
    </div>
    <div class="col">
    <input type="password" class="form-control" placeholder="Password"  aria-label="First name" value="<%= resultset.getString(10)%>" name="password" id="pass">
    </div>
    </div>
    <div class="col-8">
    <label for="inputAddress" class="form-label">Address</label>
    <input type="text" class="form-control" id="address" placeholder="1234 Main St" value="<%= resultset.getString(3)%>"  name="address">
    </div>
    <div class="col-md-7">
    <label for="inputCity" class="form-label">City</label>
    <input type="text" class="form-control" id="city"  value="<%= resultset.getString(4)%>"  name="city">
    </div>
    <div class="col-md-6">
    <label for="inputState" class="form-label">State</label>
    <input type="text" class="form-control" id="state"  value="<%= resultset.getString(6)%>"  name="state">       
    </div>
     <div class="col-md-4">
    <label for="inputZip" class="form-label">country</label>
    <input type="text" class="form-control" id="country"   value="<%= resultset.getString(7)%>" name="country">
    </div>
    <div class="col-md-3">
    <label for="inputZip" class="form-label">Zip</label>
    <input type="text" class="form-control" id="zip"  value="<%= resultset.getString(5)%>"  name="zip">
    </div>
    <div class="col-md-2">
    <label for="inputPhone" class="form-label">Phone</label>
    <input type="text" class="form-control" id="phone"   value="<%= resultset.getString(8)%>"  name="phone">
    <span id= "phone" class="text-danger font-weight-bold"> </span>  
    </div>
    <br>
    <div class="col-12">
    <button type="submit" class="btn btn-primary"  value="Submit">Update</button>
    </div>
    </form>           
    <% 
} 
}catch (Exception e) {    
    e.printStackTrace();
}
%>
</body>
</html>

  