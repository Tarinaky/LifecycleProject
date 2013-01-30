package uk.ac.aber.dcs.cs221.monstermash.UI.HttpServletPackage;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import uk.ac.aber.dcs.cs221.monstermash.data.DataSingleton;
import uk.ac.aber.dcs.cs221.monstermash.data.TableOfAccounts;

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
				
		if ( password.equals(repassword) ) {
			resp.getWriter().println("If statement entered...");	
			//db.addUser(email);
			db.addUser(email).setPassword(repassword);
			try {
				db.buildJSON();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//db.addUser(email);
			
			resp.getWriter().println("<html>");
			resp.getWriter().println("<head>");
			resp.getWriter().println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
			resp.getWriter().println("<title>MonsterMash</title>");
			resp.getWriter().println("</head>");
			resp.getWriter().println("<body>");
			resp.getWriter().println("<h3> Successful Registration </h3>");
			resp.getWriter().println("</body>");
			resp.getWriter().println("</html>");
			
			resp.sendRedirect("http://localhost:8080/Monster_Mash/login.jsp");
						
		} else {
			
			resp.getWriter().println("<html>");
			resp.getWriter().println("<head>");
			resp.getWriter().println("<title>Insert title here</title>");
			resp.getWriter().println("</head>");
			resp.getWriter().println("<body>");
			resp.getWriter().println("<h3>Email or Password invalid</h3>");
			resp.getWriter().println("<form action=\"Register\" method=\"get\">");
			resp.getWriter().println("Name: <input type=\"text\" name=\"userName\"><br>");
			resp.getWriter().println("Password: <input type=\"password\" name=\"password\"><br>");
			resp.getWriter().println("Repassword: <input type=\"password\" name=\"password\"><br>");
			resp.getWriter().println("<input type=\"submit\" value=\"Register\"");
			resp.getWriter().println("</form>");
			resp.getWriter().println("</body>");
			resp.getWriter().println("</html>");
			
		}
	}
}
