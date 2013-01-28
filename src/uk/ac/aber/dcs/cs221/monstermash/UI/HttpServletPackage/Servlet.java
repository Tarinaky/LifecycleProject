package uk.ac.aber.dcs.cs221.monstermash.UI.HttpServletPackage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet{
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String name = req.getParameter("userName");
		String password = req.getParameter("password");
		String ip = req.getRemoteAddr();
		
		resp.getWriter().println("<html>");
		resp.getWriter().println("<head>");
		resp.getWriter().println("<title>This is the response</title>");
		resp.getWriter().println("</head>");
		resp.getWriter().println("<body>");
		
		resp.getWriter().println("Your name is: " + name);
		resp.getWriter().println("\n<br>Your pass is: " + password);
		resp.getWriter().println("Your IP Address is: " + ip);
		
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
	}
}
