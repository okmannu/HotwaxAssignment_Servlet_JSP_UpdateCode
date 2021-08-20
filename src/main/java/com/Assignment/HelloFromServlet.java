package com.Assignment;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.*;


public class HelloFromServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req , HttpServletResponse res)throws ServletException,IOException

	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h1> HellFromServlet </h1>");
		
		
	
	}
}