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
		
		String email = req.getParameter("Email");
		String password = req.getParameter("password");
		String url = "http://localhost:8080/Homepage";
		
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
				resp.getWriter().println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"");
				resp.getWriter().println("\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
				resp.getWriter().println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
				resp.getWriter().println("<head>");
				resp.getWriter().println("<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />");
				resp.getWriter().println("<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\" />");
				resp.getWriter().println("<title> Monster Mash </title>");
				resp.getWriter().println("</head>");
				resp.getWriter().println("<body>");
				resp.getWriter().println("<div id=\"container\">");
				resp.getWriter().println("<div id=\"header\">");
				resp.getWriter().println("<img src=\"header.png\" />");
				resp.getWriter().println("<div id=\"navigation\">");
				resp.getWriter().println("<ul>");
				
				resp.getWriter().println("<li><a class=\"border\"> Home </a></li>");
				resp.sendRedirect("http://localhost:8080/Homepage");
				
				resp.getWriter().println("<li><a class=\"border\"> Friend Request </a></li>");
				resp.sendRedirect("http://localhost:8080/FriendPage");
				
				resp.getWriter().println("<li><a class=\"border\">Breed Options</li>");
				resp.sendRedirect("http://localhost:8080/BreedOptions");
				
				resp.getWriter().println("<li><a class=\"border\">Selling Option</a></li>");
				resp.sendRedirect("http://localhost:8080/SellingOptions");
				
				resp.getWriter().println("<li><a class=\border\"> Battle Requests</a></li>");
				resp.sendRedirect("http://localhost:8080/BattleRequests");
				
				resp.getWriter().println("<li style=\"float: right; border-left: 1px solid #fff;");
				resp.getWriter().println("<a>Logout</a></li>");
				resp.getWriter().println("<li style=\"float: right; border-left: 1px solid #fff;\">");
				resp.getWriter().println("<a>Cash:" + user.getCash() + "</a></li>");
				resp.getWriter().println("<li style=\"float: right; border-left: 1px solid #fff;");
				resp.getWriter().println("<a>User Name" + user.getEmail() + "</a></li>");		
				resp.getWriter().println("</ul>");
				resp.getWriter().println("</div>");
				resp.getWriter().println("</div>");
				//copy everything till here for next servlets!
				resp.getWriter().println("<div id=\"content\">");
				resp.getWriter().println("div style=\"float: center; border:1px solid black; width:960px; height:250px;overfloww-y:hidden;overflow-x:scroll;margin: 10px auto>");
				resp.getWriter().println("<table style=\"width: 150%\"");
				resp.getWriter().println("<tr>");
				resp.getWriter().println("td class = tr_home width =\"180px\";>");
				resp.getWriter().println("<h3>" + user.getMonsters() + "</h3>");
				resp.getWriter().println("<p>Attributes</p>");
				//some more monster stuff here...
				resp.getWriter().println("</td>");
				resp.getWriter().println("</tr>");
				resp.getWriter().println("</table>");
				resp.getWriter().println("</div>");
				resp.getWriter().println("<div style=\"float: center; border:1px solid black; width:960px; height: 170px; overflow-y:hidden; overflow-x:scroll; margin: 10px auto\">");
				resp.getWriter().println("<table style=\"width: 150%\">");
				resp.getWriter().println("<tr>");
				resp.getWriter().println("<a href=\"#\">");
				resp.getWriter().println("<td class = td_home width = \"180px\">");
				resp.getWriter().println("<h3>" + user.getFriends() + "</h3>");
				resp.getWriter().println("<br /><br /><br />");
				//more friends here to come...
				resp.getWriter().println("</td>");
				resp.getWriter().println("</a>");
				resp.getWriter().println("</tr>");
				resp.getWriter().println("</table>");
				resp.getWriter().println("</div>");
				resp.getWriter().println("</div>");
				resp.getWriter().println("<div id=\"footer\">");
				resp.getWriter().println("<p>Monster Mash &copy; 2013 MonsterMash.com</p>");
				resp.getWriter().println("</div>");
				resp.getWriter().println("</div>");
				resp.getWriter().println("</body>");
				resp.getWriter().println("</html>");
			
			
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
