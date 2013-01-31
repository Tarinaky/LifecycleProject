package uk.ac.aber.dcs.cs221.monstermash.UI.HttpServletPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uk.ac.aber.dcs.cs221.monstermash.data.DataSingleton;
import uk.ac.aber.dcs.cs221.monstermash.data.Monster;
import uk.ac.aber.dcs.cs221.monstermash.data.TableOfAccounts;

public class FriendPage extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		TableOfAccounts db = DataSingleton.get();
		HttpSession ses = req.getSession(true);		
		String email = (String) ses.getValue("email");
		String friendemail = (String)ses.getValue("friend_email");
		
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
		
		//response.getWriter().println("<li><a class=\"border\"> Home </a></li>");
		resp.getWriter().println("<form action=\"Homepage\" method=\"get\">");	
		resp.getWriter().println("<a href=\"http://localhost:8080/Monster_Mash/Homepage\">Home</a></li>");
		//response.getWriter().println("<input type=\"submit\" value=\"Home\">");
		
		//response.getWriter().println("<li><a class=\"border\"> Friend Requests </a></li>");
		resp.getWriter().println("<form action=\"FriendRequests\" method=\"get\">");		
		resp.getWriter().println("<a href=\"http://localhost:8080/Monster_Mash/FriendRequests\">Friend Requests</a></li>");
		//response.getWriter().println("<input type=\"submit\" value=\"FriendRequests\">");
		
		//response.getWriter().println("<li><a class=\"border\">Breed Options</li>");
		resp.getWriter().println("<form action=\"BreedOptions\" method=\"get\">");		
		resp.getWriter().println("<a href=\"http://localhost:8080/Monster_Mash/BreedOptions\">Breed Options</a></li>");
		//response.getWriter().println("<input type=\"submit\" value=\"BreedOptions\">");
		
		//response.getWriter().println("<li><a class=\"border\">Selling Options</a></li>");
		resp.getWriter().println("<form action=\"SellingOptions\" method=\"get\">");	
		resp.getWriter().println("<a href=\"http://localhost:8080/Monster_Mash/SellingOptions\">Selling Options</a></li>");
		//response.getWriter().println("<input type=\"submit\" value=\"SellingOptions\">");
		
		//response.getWriter().println("<li><a class=\border\"> Battle Requests</a></li>");
		resp.getWriter().println("<form action=\"BattleRequests\" method=\"get\">");
		resp.getWriter().println("<a href=\"http://localhost:8080/Monster_Mash/BattleRequests\">Battle Requests</a></li>");
		//response.getWriter().println("<input type=\"submit\" value=\"BattleRequests\">");
		
		resp.getWriter().println("<li style=\"float: right; border-left: 1px solid #fff;");
		resp.getWriter().println("<form action=\"LoginController\" method=\"get\">");
		resp.getWriter().println("<a href=\"http://localhost:8080/Monster_Mash/login.jsp\">Logout</a></li>");
		//response.getWriter().println("<input type=\"submit\" value=\"Log Out\">");				
		resp.getWriter().println("<li style=\"float: right; border-left: 1px solid #fff;\">");
		
		resp.getWriter().println("<a>Cash:" + db.lookup(email).getCash() + "</a></li>");
		resp.getWriter().println("<li style=\"float: right; border-left: 1px solid #fff;");
		resp.getWriter().println("<a>User Name: " + email + "</a></li>");		
		resp.getWriter().println("</ul>");
		resp.getWriter().println("</div>");
		resp.getWriter().println("</div>");
		
		resp.getWriter().println("<div id=\"content\">");
		resp.getWriter().println("<table border=\"1\">");
		resp.getWriter().println("<tr>");
		resp.getWriter().println("<td class =\"title_row\">");
		//----------------Null-Pointer Exception-----------------
		//resp.getWriter().println("<p>User Name:" + friendemail + "</p>");
		resp.getWriter().println("</td>");
		resp.getWriter().println("<td class =\"td_request\">");
		resp.getWriter().println("</td>");
		resp.getWriter().println("</tr>");
		resp.getWriter().println("<tr>");
		resp.getWriter().println("<td class=\"title_row\">");
		//---------------Null-Pointer Exception------------------
		//resp.getWriter().println("<p>Cash Amount:" + db.lookup(friendemail).getCash() + "</p>");
		resp.getWriter().println("</td>");
		resp.getWriter().println("<td class =\"td_request\">");
		resp.getWriter().println("</td>");
		resp.getWriter().println("</td>");
		resp.getWriter().println("</tr>");
		resp.getWriter().println("</table>");
		resp.getWriter().println("<div style=\"float: center; border:1px solid black;width:960px;height:250px;overflow-y:hidden;overflow-x:scroll;margin: 10px auto\">");
		resp.getWriter().println("<table style=\"width: 150%\">");
		resp.getWriter().println("<tr>");
		
		for (Monster monster : db.lookup(friendemail).getMonsters()) {
			resp.getWriter().println("<from action=\"\">");
			resp.getWriter().println("<td class = td_home width =\"180px\";>");
			//---------------Null-Pointer Exception------------
			//resp.getWriter().println("<h3>" + monster.getName() + "</h3>");
			resp.getWriter().println("<p>Attributes</p>");
			//response.getWriter().println("<p>Health " + monster.getHealth() + "</p>");
			//response.getWriter().println("<p>Strength " + monster.getStrength() + "</p>");
			//response.getWriter().println("<p>Toughness " + monster.getToughness() + "</p>");
			//response.getWriter().println("<p>Evade " + monster.getEvade() + "</p>");
			resp.getWriter().println("<p>Value</p>");
			//ask rich about this place?!?!
		}
		
		resp.getWriter().println("</tr>");
		resp.getWriter().println("</table>");
		resp.getWriter().println("</div>");
		resp.getWriter().println("</div>");
		
		resp.getWriter().println("<div id=\"footer\">");
		resp.getWriter().println("<p>Monster Mash &copy; 2013 MonsterMash.com</p>");
		resp.getWriter().println("</div>");
		resp.getWriter().println("</div>");
		resp.getWriter().println("</html>");
	}
	
}
