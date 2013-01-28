package uk.ac.aber.dcs.cs221.monstermash.UI.HttpServletPackage;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ac.aber.dcs.cs221.monstermash.data.DataSingleton;
import uk.ac.aber.dcs.cs221.monstermash.data.TableOfAccounts;

public class Register extends HttpServlet{
	
	TableOfAccounts db = DataSingleton.get();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		
		String email = req.getParameter(email);
		String password = req.getParameter(password);
		String repassword = req.getParameter(repassword);
		String url = "http://localhost:8080/index.jsp";
		
		if (password == repassword) {
			db.addUser(email);
			db.addUser(email).setPassword(repassword);
			try {
				resp.getWriter().println("<html>");
				resp.getWriter().println("<head>");
				resp.getWriter().println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
				resp.getWriter().println("<title>MonsterMash</title>");
				resp.getWriter().println("</head>");
				resp.getWriter().println("<body>");
				resp.getWriter().println("<h3> Successful Registration </h3>");
				resp.getWriter().println("</body>");
				resp.getWriter().println("</html>");
				resp.sendRedirect(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			//register page...
		}
	}
}
