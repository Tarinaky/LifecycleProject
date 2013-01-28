package uk.ac.aber.dcs.cs221.monstermash.UI.HttpServletPackage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ac.aber.dcs.cs221.monstermash.data.DataSingleton;
import uk.ac.aber.dcs.cs221.monstermash.data.TableOfAccounts;



public class LoginController extends HttpServlet{
	
	TableOfAccounts accountDb = DataSingleton.get();
	//UserAccount user = new UserAccount(0);
	
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("Email");
		String password = req.getParameter("password");
		String url = "http://localhost:8080/home.jsp";
		
		if (accountDb.lookup(email) == null) {
			resp.getWriter().println("<html>");
			resp.getWriter().println("<head>");
			resp.getWriter().println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
			resp.getWriter().println("<title>MonsterMash</title>");
			resp.getWriter().println("</head>");
			resp.getWriter().println("<body>");
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
				resp.sendRedirect(url);
			
			} else {
				resp.getWriter().println("<html>");
				resp.getWriter().println("<head>");
				resp.getWriter().println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
				resp.getWriter().println("<title>MonsterMash</title>");
				resp.getWriter().println("</head>");
				resp.getWriter().println("<body>");
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
