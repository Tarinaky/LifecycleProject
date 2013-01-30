package uk.ac.aber.dcs.cs221.monstermash.UI.HttpServletPackage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ac.aber.dcs.cs221.monstermash.data.DataSingleton;
import uk.ac.aber.dcs.cs221.monstermash.data.TableOfAccounts;
import uk.ac.aber.dcs.cs221.monstermash.data.UserAccount;

public class LoginController extends HttpServlet{
		
	private static final long serialVersionUID = 1L;
	private TableOfAccounts accountDb = DataSingleton.get();
	public static UserAccount user = null;
	
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("userName");
		String password = req.getParameter("password");
		String url = "http://localhost:8080/Monster_Mash/Homepage";
		
		if (accountDb.lookup(email) == null) {
			
			resp.getWriter().println("<html>");
			resp.getWriter().println("<head>");
			resp.getWriter().println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
			resp.getWriter().println("<title>MonsterMash</title>");
			resp.getWriter().println("</head>");
			resp.getWriter().println("<body>");
			resp.getWriter().println("<h1>Monster Mash</h1>");
			resp.getWriter().println("<div id=\"navigation\">");
			resp.getWriter().println("<ul>");
			resp.getWriter().println("<li><a href=\"create_account.jsp\">Sign Up</a></li>");
			resp.getWriter().println("</ul>");
			resp.getWriter().println("</div>");
			resp.getWriter().println("<h3> No Such Email </h3>");			
			resp.getWriter().println("<form action=\"LoginController\" method=\"get\">");
			resp.getWriter().println("Email: <input type=\"text\" name=\"Email\"><br>");
			resp.getWriter().println("Password: <input type=\"password\" name=\"password\"><br>");
			resp.getWriter().println("<input type=\"submit\" value=\"Login\">");
			resp.getWriter().println("</form>");
			resp.getWriter().println("</body>");
			resp.getWriter().println("</html>");
		
		} else {
			
			if(accountDb.lookup(email).checkPassword(password)){
				user = accountDb.lookup(email);
				resp.getWriter().println("<form action=\"Homepage\" method=\"get\">");
				resp.getWriter().println("<h3>Redirect</h3>");
				resp.getWriter().println("<input type=\"submit\" value=\"Redirect\">");
				//resp.sendRedirect("http://localhost8080:/Monster_Mash/Homepage");
			
			} else {
				resp.getWriter().println("<html>");
				resp.getWriter().println("<head>");
				resp.getWriter().println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
				resp.getWriter().println("<title>MonsterMash</title>");
				resp.getWriter().println("</head>");
				resp.getWriter().println("<body>");
				resp.getWriter().println("<h1>Monster Mash</h1>");
				resp.getWriter().println("<div id=\"navigation\">");
				resp.getWriter().println("<ul>");
				resp.getWriter().println("<li><a href=\"create_account.jsp\">Sign Up</a></li>");
				resp.getWriter().println("</ul>");
				resp.getWriter().println("</div>");
				resp.getWriter().println("<h3> Wrong Password </h3>");			
				resp.getWriter().println("<form action=\"LoginController\" method=\"get\">");
				resp.getWriter().println("Email: <input type=\"text\" name=\"Email\"><br>");
				resp.getWriter().println("Password: <input type=\"password\" name=\"password\"><br>");
				resp.getWriter().println("<input type=\"submit\" value=\"Login\">");
				resp.getWriter().println("</form>");
				resp.getWriter().println("</body>");
				resp.getWriter().println("</html>");
			}
		}		
		
	}
}
