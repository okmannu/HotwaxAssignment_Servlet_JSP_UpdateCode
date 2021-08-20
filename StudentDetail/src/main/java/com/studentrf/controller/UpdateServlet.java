package com.studentrf.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.studentrf.dao.StudentUpdateDao;
import com.studentrf.model.Student;


@WebServlet("/Update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentUpdateDao stdupadte = new StudentUpdateDao();	
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
		Boolean stdupdt = stdupadte.updateStudent(student);
		if(stdupdt) {
	    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	    dispatcher.forward(request, response);
		}else {
		RequestDispatcher dispatcher = request.getRequestDispatcher("aletNotSucc.jsp");
		dispatcher.forward(request, response);
		}	
		} catch (Exception e) {
		e.printStackTrace();	
		}		
	    }
        }
