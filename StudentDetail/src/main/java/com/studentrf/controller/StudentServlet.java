package com.studentrf.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.studentrf.dao.StudentDao;
import com.studentrf.model.Student;


@WebServlet("/register")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentdao = new StudentDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");	
		String address = request.getParameter("address");	
		String city = request.getParameter("city");
		String zip = request.getParameter("zip");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String phone = request.getParameter("phone");
		int  userId = Integer.parseInt(request.getParameter("userId"));
		String password = request.getParameter("password");
		Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setAddress(address);
        student.setCity(city);
        student.setZip(zip);
        student.setState(state);
        student.setCountry(country);
        student.setPhone(phone);
        student.setUserId(userId);
        student.setPassword(password);
        try {
	    Boolean  std = studentdao.registerStudent(student);   
        if(std) {
	    RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
	    dispatcher.forward(request, response);
        }else {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
     	dispatcher.forward(request, response);
        }
	    } catch (ClassNotFoundException e) {
		e.printStackTrace();
	    }
	    }
	    }


