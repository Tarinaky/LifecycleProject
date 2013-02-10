package aber.dcs.cs221.group5.UI.HttpServletPackage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aber.dcs.cs221.group5.data.DataSingleton;
import aber.dcs.cs221.group5.data.Monster;
import aber.dcs.cs221.group5.data.TableOfAccounts;


public class BreedOptions extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		TableOfAccounts db = DataSingleton.get();
		HttpSession ses = req.getSession(true);
		String email = (String)ses.getValue("email");
		
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
		
		resp.getWriter().println("<li><a class=\"border\" href=\"http://localhost:8080/Monster_Mash/Homepage\">Home</a></li>");
		resp.getWriter().println("<li><a class=\"border\" href=\"http://localhost:8080/Monster_Mash/FriendRequests\">Friend Requests</a></li>");
		resp.getWriter().println("<li><a class=\"border\" href=\"http://localhost:8080/Monster_Mash/BattleRequest\">Battle Requests</a></li>");
		resp.getWriter().println("<li><a class=\"border\" href=\"http://localhost:8080/Monster_Mash/SellingOptions\">Selling Options</a></li>");
		
		resp.getWriter().println("<li style=\"float: right; border-left: 1px solid #fff;\">");
		resp.getWriter().println("<li style=\"float: right; border-left: 1px solid #fff;\">");
		resp.getWriter().println("<form action=\"LoginController\" method=\"get\">");
		resp.getWriter().println("<a href=\"http://localhost:8080/Monster_Mash/login.jsp\">Logout</a></li>");
		resp.getWriter().println("<li style=\"float: right; border-left: 1px solid #fff;\">");
		
		resp.getWriter().println("<a>Cash:" + db.lookup(email).getCash() + "</a></li>");
		resp.getWriter().println("<li style=\"float: right; border-left: 1px solid #fff;\">");
		resp.getWriter().println("<a>User Name:" + email + "</a></li>");
		resp.getWriter().println("</ul>");
		resp.getWriter().println("</div>");
		resp.getWriter().println("</div>");
		
		resp.getWriter().println("<div id=\"content\">");
		resp.getWriter().println("<img class=\"page_header\" src=\"breedoptions.png\" />");
		resp.getWriter().println("<table border=\"1\">");
		resp.getWriter().println("<tr>");
		
		for (Monster monster : db.lookup(email).getMonsters()) {
			resp.getWriter().println("<td class = \"title_row\">");
			//--------------------Null-Pointer Exception-------------
			//resp.getWriter().println("<p>"+ monster.getName() +"</p>");
			resp.getWriter().println("</td>");
			resp.getWriter().println("<td class = \"title_row\">");
			resp.getWriter().println("<p>Attributes Name</p>");
			resp.getWriter().println("</td>");
			resp.getWriter().println("<td class = \"title_row\">");
			resp.getWriter().println("<p>Cash Value</p>");
			resp.getWriter().println("</td>");
			resp.getWriter().println("<td class = \"title_row\">");
			resp.getWriter().println("<p>Breed</p>");
			resp.getWriter().println("</td>");
			resp.getWriter().println("</tr>");
			resp.getWriter().println("<form action=\"\">");
			resp.getWriter().println("<tr>");
			resp.getWriter().println("<td class=\"td_request\">");
			resp.getWriter().println("</td>");
			resp.getWriter().println("<td class=\"td_request\">");
			resp.getWriter().println("</td>");
			resp.getWriter().println("<td class=\"td_request\">");
			resp.getWriter().println("</td>");
			resp.getWriter().println("<td class=\"td_request\">");
			resp.getWriter().println("<input type=\"radio\" name=\"response\" value=\"yes\">Yes");
			resp.getWriter().println("<input type=\"radio\" name=\"response\" value=\"no\">No<br /><br />");
			resp.getWriter().println("<input type=\"submit\" value=\"Apply\">");
			resp.getWriter().println("</td>");
			resp.getWriter().println("</tr>");
			resp.getWriter().println("</form>");
		}
		
		resp.getWriter().println("</table>  ");
		resp.getWriter().println("</div>");
		resp.getWriter().println("<div id=\"footer\">");
		resp.getWriter().println("<p>Monster Mash &copy; 2013 MonsterMash.com</p>");
		resp.getWriter().println("</div>");
		resp.getWriter().println("</div>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
