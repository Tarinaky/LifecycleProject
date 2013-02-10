package aber.dcs.cs221.group5.UI.HttpServletPackage;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import aber.dcs.cs221.group5.data.DataSingleton;
import aber.dcs.cs221.group5.data.Monster;
import aber.dcs.cs221.group5.data.TableOfAccounts;
import aber.dcs.cs221.group5.data.UserAccount;


public class Register extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TableOfAccounts db = DataSingleton.get();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException, ServletException {
		
		String email = req.getParameter("userName");
		String password = req.getParameter("password");
		String repassword = req.getParameter("pasword");
		
		String jsValidation[] = {
				"<script language=\"JavaScript\">",	
							"function validate(form)",
									"var email = document.forms[\"details\"][\"email\"].value;\"",
									"var emailValue = document.forms[\"details\"][\"email\"].value;",
									"if (!email.test(emailValue)) {",
										"alert(\"Please entter a valid email adress\");",
										"return false;",
									"}",
									"return true;",
									"}",
									"</script>"
									};
									
		
		
		if ( password.equals(repassword) ) {
			System.out.println(email+ ""+ repassword);
				
				UserAccount user = db.addUser(email);
				if (user == null) {
					//Error crap here
					resp.getWriter().println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"");
					resp.getWriter().println("\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
					resp.getWriter().println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
					resp.getWriter().println("<head>");
					resp.getWriter().println("<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />");
					resp.getWriter().println("<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\" />");
					resp.getWriter().println("<title> Monster Mash </title>");
					
					for (int i = 0; i < jsValidation.length; i++) {
						resp.getWriter().println(jsValidation[i]);
					}
					
					resp.getWriter().println("</head>");
					resp.getWriter().println("<body>");
					resp.getWriter().println("<div id=\"container\">");
					resp.getWriter().println("<div id=\"header\">");
					resp.getWriter().println("<img src=\"header.png\" />");
					resp.getWriter().println("<div id=\"navigation\">");
					resp.getWriter().println("<ul>");
					resp.getWriter().println("<li><a href=\"login.jsp\">Login</a></li>");
					resp.getWriter().println("</ul>");
					resp.getWriter().println("</div>");
					resp.getWriter().println("</div>");
					resp.getWriter().println("<div id=\"content\">");
					resp.getWriter().println("<img class=\"page_header\" src=\"createaccount.png\" />");
					resp.getWriter().println("<form id=\"details\" action =\"#\" method=\"post\" onsubmit=\"return validate(this)\">");
					resp.getWriter().println("<p style=\"text-align:center;\">Email: <input type=\"text\" name=\"email\" size=\"20\" maxlength=\"60\" /> </p>");
					resp.getWriter().println("<p style=\"text-align:center;\">Password: <input type=\"text\" name=\"pass\" size=\"20\" maxlength=\"60\" /> </p>");
					resp.getWriter().println("<p style=\"text-align:center;\">Re-enter Password: <input type=\"text\" name=\"confirm\" size=\"20\" maxlength=\"60\" /> </p>");
					resp.getWriter().println("<p style=\"text-align:center;\"><input style = \"text-align: center\" type=\"submit\" name=\"submit\" value=\"Submit\" /></p>");
					resp.getWriter().println("</form>");
					resp.getWriter().println("</div>");
					resp.getWriter().println("<div id=\"footer\">");
					resp.getWriter().println("<p>Monster Mash &copy; 2013 MonsterMash.com</p>");
					resp.getWriter().println("</div>");
					resp.getWriter().println("</div>");
					resp.getWriter().println("</body>");
					resp.getWriter().println("</html>");
					
				} else {
				
					user.setPassword(repassword);
					Monster.generateRandom().setOwner(user);
					System.out.println(user.getMonsters()[0]);
					resp.sendRedirect("http://localhost:8080/Monster_Mash/login.jsp");
				}
				
				
			} else {
			
			resp.getWriter().println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"");
			resp.getWriter().println("\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
			resp.getWriter().println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
			resp.getWriter().println("<head>");
			resp.getWriter().println("<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />");
			resp.getWriter().println("<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\" />");
			resp.getWriter().println("<title> Monster Mash </title>");
			
			for (int i = 0; i < jsValidation.length; i++) {
				resp.getWriter().println(jsValidation[i]);
			}
			
			resp.getWriter().println("</head>");
			resp.getWriter().println("<body>");
			resp.getWriter().println("<div id=\"container\">");
			resp.getWriter().println("<div id=\"header\">");
			resp.getWriter().println("<img src=\"header.png\" />");
			resp.getWriter().println("<div id=\"navigation\">");
			resp.getWriter().println("<ul>");
			resp.getWriter().println("<li><a href=\"login.jsp\">Login</a></li>");
			resp.getWriter().println("</ul>");
			resp.getWriter().println("</div>");
			resp.getWriter().println("</div>");
			resp.getWriter().println("<div id=\"content\">");
			resp.getWriter().println("<img class=\"page_header\" src=\"createaccount.png\" />");
			resp.getWriter().println("<form id=\"details\" action =\"#\" method=\"post\" onsubmit=\"return validate(this)\">");
			resp.getWriter().println("<p style=\"text-align:center;\">Email: <input type=\"text\" name=\"email\" size=\"20\" maxlength=\"60\" /> </p>");
			resp.getWriter().println("<p style=\"text-align:center;\">Password: <input type=\"text\" name=\"pass\" size=\"20\" maxlength=\"60\" /> </p>");
			resp.getWriter().println("<p style=\"text-align:center;\">Re-enter Password: <input type=\"text\" name=\"confirm\" size=\"20\" maxlength=\"60\" /> </p>");
			resp.getWriter().println("<p style=\"text-align:center;\"><input style = \"text-align: center\" type=\"submit\" name=\"submit\" value=\"Submit\" /></p>");
			resp.getWriter().println("</form>");
			resp.getWriter().println("</div>");
			resp.getWriter().println("<div id=\"footer\">");
			resp.getWriter().println("<p>Monster Mash &copy; 2013 MonsterMash.com</p>");
			resp.getWriter().println("</div>");
			resp.getWriter().println("</div>");
			resp.getWriter().println("</body>");
			resp.getWriter().println("</html>");
			
		}
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
