package com.studentrf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class StudentDeleteDao {
            public Boolean studentDelete(int id) throws ClassNotFoundException {
    	    boolean rowDeleted = false;
    	    Connection connection=null;
            try
            {                                 
            Class.forName("com.mysql.jdbc.Driver");
        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
        	String USERS_Login = "delete from party_table where userId = ?;"; 
            PreparedStatement preparedStatement = connection.prepareStatement(USERS_Login); 
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
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
            return rowDeleted;
            }
            }
            










