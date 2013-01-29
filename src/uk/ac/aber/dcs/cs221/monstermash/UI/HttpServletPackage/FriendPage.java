package uk.ac.aber.dcs.cs221.monstermash.UI.HttpServletPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FriendPage extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		response.getWriter().println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"");
		response.getWriter().println("\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
		response.getWriter().println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		response.getWriter().println("<head>");
		response.getWriter().println("<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />");
		response.getWriter().println("<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\" />");
		response.getWriter().println("<title> Monster Mash </title>");
		response.getWriter().println("</head>");
		response.getWriter().println("<body>");
		response.getWriter().println("<div id=\"container\">");
		response.getWriter().println("<div id=\"header\">");
		response.getWriter().println("<img src=\"header.png\" />");
		response.getWriter().println("<div id=\"navigation\">");
		response.getWriter().println("<ul>");
		
		response.getWriter().println("<li><a class=\"border\"> Home </a></li>");
		response.sendRedirect("http://localhost:8080/Homepage");
		
		response.getWriter().println("<li><a class=\"border\"> Friend Request </a></li>");
		response.sendRedirect("http://localhost:8080/FriendPage");
		
		response.getWriter().println("<li><a class=\"border\">Breed Options</li>");
		response.sendRedirect("http://localhost:8080/BreedOptions");
		
		response.getWriter().println("<li><a class=\"border\">Selling Option</a></li>");
		response.sendRedirect("http://localhost:8080/SellingOptions");
		
		response.getWriter().println("<li><a class=\border\"> Battle Requests</a></li>");
		response.sendRedirect("http://localhost:8080/BattleRequests");
		
		response.getWriter().println("<li style=\"float: right; border-left: 1px solid #fff;");
		response.getWriter().println("<a>Logout</a></li>");
		response.getWriter().println("<li style=\"float: right; border-left: 1px solid #fff;\">");
		response.getWriter().println("<a>Cash:" + LoginController.user.getCash() + "</a></li>");
		response.getWriter().println("<li style=\"float: right; border-left: 1px solid #fff;");
		response.getWriter().println("<a>User Name" + LoginController.user.getEmail() + "</a></li>");		
		response.getWriter().println("</ul>");
		response.getWriter().println("</div>");
		response.getWriter().println("</div>");
		
		response.getWriter().println("<div id=\"content\">");
		response.getWriter().println("<table border=\"1\">");
		response.getWriter().println("<tr>");
		response.getWriter().println("<td class =\"title_row\">");
		response.getWriter().println("<p>User Name:</p>");
		response.getWriter().println("</td>");
		response.getWriter().println("<td class =\"td_request\">");
		response.getWriter().println("</td>");
		response.getWriter().println("</tr>");
		response.getWriter().println("<tr>");
		response.getWriter().println("<td class=\"title_row\">");
		response.getWriter().println("<p>Cash Amount:</p>");
		response.getWriter().println("</td>");
		response.getWriter().println("<td class =\"td_request\">");
		response.getWriter().println("</td>");
		response.getWriter().println("</td>");
		response.getWriter().println("</tr>");
		response.getWriter().println("</table>");
		response.getWriter().println("<div style=\"float: center; border:1px solid black;width:960px;height:250px;overflow-y:hidden;overflow-x:scroll;margin: 10px auto\">");
		
	}
	
}
