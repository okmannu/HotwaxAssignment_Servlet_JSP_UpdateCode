package com.studentrf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.studentrf.model.StudentLogin;

public class StudentLoginDao {

            public Boolean studentLogin(StudentLogin student) throws ClassNotFoundException {
            Boolean result = false;
            Connection connection=null;
            try
            {
            Class.forName("com.mysql.jdbc.Driver");
        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
        	String USERS_Login = "Select * from party_table where userId=? and password=?"; 
            PreparedStatement preparedStatement = connection.prepareStatement(USERS_Login); 
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getPassword());
            ResultSet resultset = preparedStatement.executeQuery();
            result = resultset.next();    
            }
            catch (Exception e)
            {
            e.printStackTrace();
            }finally
            {try {
			connection.close();
			} catch (SQLException e) {
			e.printStackTrace();
			}
            }
            return result;
            }
            }


