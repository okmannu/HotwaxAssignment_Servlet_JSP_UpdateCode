package com.studentrf.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.studentrf.dao.StudentDeleteDao;


@WebServlet("/Delete")
public class StudentDeleteServlet extends HttpServlet {
	        private static final long serialVersionUID = 1L;
            StudentDeleteDao stddelete = new StudentDeleteDao();
	       	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("ed"));
			try {
			stddelete.studentDelete(id);
		    response.sendRedirect("user-list.jsp");
			} catch (ClassNotFoundException e) {
		    e.printStackTrace();
			}
			}	
            }
