package com.sandbox.tafjeemix.war;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sandbox.tafjeemix.ejb.TopRemote;

public class FooServlet extends HttpServlet {
	private static final long serialVersionUID = 4028009567930253820L;

	@EJB
	private TopRemote topEjb;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet FooServlet</title>");
		out.println("</head>");
		out.println("<body>");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		if (firstName == null || lastName == null) {
			out.println("<h1>Please provide &quot;firstname&quot; and &quot;lastname&quot;</h1>");			
		} else {
			out.println("<h1>TopRemote.go returned: "
					+ topEjb.go(firstName, lastName) + "</h1>");
		}
		out.println("</body>");
		out.println("</html>");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}