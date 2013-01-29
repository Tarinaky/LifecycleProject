package uk.ac.aber.dcs.cs221.monstermash.UI.HttpServletPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ac.aber.dcs.cs221.monstermash.data.UserAccount;

/**
 * Servlet implementation class homepage
 */
@WebServlet("/homepage")
public class Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Homepage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		//copy everything till here for next servlets!
		response.getWriter().println("<div id=\"content\">");
		response.getWriter().println("div style=\"float: center; border:1px solid black; width:960px; height:250px;overfloww-y:hidden;overflow-x:scroll;margin: 10px auto>");
		response.getWriter().println("<table style=\"width: 150%\"");
		response.getWriter().println("<tr>");
		response.getWriter().println("td class = tr_home width =\"180px\";>");
		response.getWriter().println("<h3>" + LoginController.user.getMonsters() + "</h3>");
		response.getWriter().println("<p>Attributes</p>");
		//some more monster stuff here...
		response.getWriter().println("</td>");
		response.getWriter().println("</tr>");
		response.getWriter().println("</table>");
		response.getWriter().println("</div>");
		response.getWriter().println("<div style=\"float: center; border:1px solid black; width:960px; height: 170px; overflow-y:hidden; overflow-x:scroll; margin: 10px auto\">");
		response.getWriter().println("<table style=\"width: 150%\">");
		response.getWriter().println("<tr>");
		response.getWriter().println("<a href=\"#\">");
		response.getWriter().println("<td class = td_home width = \"180px\">");
		response.getWriter().println("<h3>" + LoginController.user.getFriends() + "</h3>");
		response.getWriter().println("<br /><br /><br />");
		//more friends here to come...
		response.getWriter().println("</td>");
		response.getWriter().println("</a>");
		response.getWriter().println("</tr>");
		response.getWriter().println("</table>");
		response.getWriter().println("</div>");
		response.getWriter().println("</div>");
		response.getWriter().println("<div id=\"footer\">");
		response.getWriter().println("<p>Monster Mash &copy; 2013 MonsterMash.com</p>");
		response.getWriter().println("</div>");
		response.getWriter().println("</div>");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
