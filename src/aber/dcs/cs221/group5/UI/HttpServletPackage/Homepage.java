package aber.dcs.cs221.group5.UI.HttpServletPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aber.dcs.cs221.group5.data.DataSingleton;
import aber.dcs.cs221.group5.data.Monster;
import aber.dcs.cs221.group5.data.TableOfAccounts;
import aber.dcs.cs221.group5.data.UserAccount;


/**
 * Servlet implementation class homepage
 */
@WebServlet("/homepage")
public class Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	
	TableOfAccounts db = DataSingleton.get();
	
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
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		
		//String email = (String)request.getAttribute("email");
		HttpSession ses = request.getSession(true);
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
		resp.getWriter().println("<li><a class=\"border\" href=\"http://localhost:8080/Monster_Mash/BreedOptions\">Breed Options</a></li>");
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
		
		//copy everything till here for next servlets!
		
		resp.getWriter().println("<div id=\"content\">");

		//monster frame
		resp.getWriter().println("<div style=\"float: center; border:1px solid black; width:960px; height:250px;overflow-y:hidden;overflow-x:scroll;margin: 10px auto\">");
		resp.getWriter().println("<table style=\"width: 150%\">");
		resp.getWriter().println("<tr>");		
		System.out.println(db.lookup(email).getMonsters() );
		for (Monster monster: db.lookup(email).getMonsters() ) {
			if(monster == null) continue;
			
			if (monster.getHealth() <=0) {
				monster.reap();//The monster is dead, remove it.
				continue;//Do not display this monster.
			}
			resp.getWriter().println("<td class = tr_home width =\"180px\";>");
			
			resp.getWriter().println("<h3>" + monster.getName() + "</h3>");
			resp.getWriter().println("<p>Attributes</p>");
			resp.getWriter().println("<p>Health " + monster.getHealth() + "</p>");
			resp.getWriter().println("<p>Strength " + monster.getStrength() + "</p>");
			resp.getWriter().println("<p>Toughness " + monster.getToughness() + "</p>");
			resp.getWriter().println("<p>Evade " + monster.getEvade() + "</p>");
			
			//some more monster stuff here...
			
			resp.getWriter().println("</td>");
			
		}
		
		
		resp.getWriter().println("</tr>");
		resp.getWriter().println("</table>");
		resp.getWriter().println("</div>");		
		
		//friends frame
		resp.getWriter().println("<div style=\"float: center; border:1px solid black; width:960px; height: 170px; overflow-y:hidden; overflow-x:scroll; margin: 10px auto\">");
		resp.getWriter().println("<table style=\"width: 150%\">");
		resp.getWriter().println("<tr>");
		
		for (UserAccount friend : db.lookup(email).getFriends()) {
			
			//response.getWriter().println("<a href=\"#\">");
			resp.getWriter().println("<td class = td_home width = \"180px\">");
			
			//-------------------gives me null-pointer exception here!!!--------------------------
			//-------------------thoughts on changing
			//ses.putValue(friend.getEmail(), friend.getEmail());
			//response.getWriter().println("<h3><a href=\"http://localhost8080/Monster_Mash/FriendPage\">" + friend.getEmail() + "</a></h3>");			
			//response.getWriter().println("<p>Cash Amount: " + friend.getCash() + "</p");
			//more friends here to come...			
			
			resp.getWriter().println("</td>");
			resp.getWriter().println("</a>");
		}
		
		
		
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
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
