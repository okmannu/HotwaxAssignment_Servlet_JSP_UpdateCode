package com.studentrf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.studentrf.model.*;

public class StudentDao {
            public Boolean registerStudent(Student student) throws ClassNotFoundException {    	
            Boolean result = false;
            Connection connection=null;
            try
            {
        	Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
        	String INSERT_USERS_SQL = "INSERT INTO party_table(firstName, lastName, address, city, zip, state, country, phone, userId, password)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        	PreparedStatement preparedStatement= connection.prepareStatement(INSERT_USERS_SQL); 	
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getCity());
            preparedStatement.setString(5, student.getZip());
            preparedStatement.setString(6, student.getState());   
            preparedStatement.setString(7, student.getCountry());
            preparedStatement.setString(8, student.getPhone());
            preparedStatement.setInt(9, student.getUserId());
            preparedStatement.setString(10, student.getPassword());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            if(preparedStatement.executeUpdate()!=0) {
        	result = true;
            }
            } catch (Exception e) {
            e.printStackTrace();       	  
            }finally
            {
            try {
			connection.close();
			} catch (SQLException e) {
			e.printStackTrace();
			}
            }
            return result;
            }
            }
