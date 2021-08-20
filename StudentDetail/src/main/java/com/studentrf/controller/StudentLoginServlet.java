package com.studentrf.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentrf.dao.StudentLoginDao;
import com.studentrf.model.StudentLogin;


@WebServlet("/login")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int  id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		StudentLogin stdLogin = new StudentLogin();
		stdLogin.setId(id);
		stdLogin.setPassword(password);
		StudentLoginDao studentlogind = new StudentLoginDao();
	    try {
		Boolean sd = studentlogind.studentLogin(stdLogin);
		if(sd)
		{
	    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		}else{
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
		dispatcher.forward(request, response);
		}
	    } catch (ClassNotFoundException e) 
	    {
		e.printStackTrace();
    	}        
     	}
        }
