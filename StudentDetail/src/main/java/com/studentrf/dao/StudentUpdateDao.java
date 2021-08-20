package com.studentrf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.studentrf.model.Student;

public class StudentUpdateDao {
	       Boolean result = false;
	       Connection connection=null;
	       public Boolean updateStudent(Student student) throws ClassNotFoundException {
           try                         
           {
       	   Class.forName("com.mysql.jdbc.Driver");
       	   connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
       	   String INSERT_USERS_SQL = "update party_table set firstname= ?, lastname= ?, address= ?, city= ?, zip= ?, state= ?, country= ?, phone= ?, password= ? where userId = ?;";
       	   PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL); {
           preparedStatement.setString(1, student.getFirstName());
           preparedStatement.setString(2, student.getLastName());
           preparedStatement.setString(3, student.getAddress());
           preparedStatement.setString(4, student.getCity());
           preparedStatement.setString(5, student.getZip());
           preparedStatement.setString(6, student.getState()); 
           preparedStatement.setString(7, student.getCountry());
           preparedStatement.setString(8, student.getPhone());
           preparedStatement.setString(9, student.getPassword());
           preparedStatement.setInt(10, student.getUserId());
           preparedStatement.executeUpdate();
           if(preparedStatement.executeUpdate()!=0) {
           preparedStatement.close();
       	   result = true;
           }
           }
           } catch (Exception e) {
           e.printStackTrace();
           }finally {
           try {
		   connection.close();
		   } catch (SQLException e) {	
		   e.printStackTrace();
		   }
           }
           return result;
           }
           }
