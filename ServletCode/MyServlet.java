import java.io.*;
import javax.servlet.*;

public class  MyServlet  extends  GenericServlet {
	public void service (ServletRequest req, ServletResponse resp) throws ServletException,IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>"); 
		pw.println("<head>");
		pw.println("<title>My Servlet</title>");
		pw.println("<style>body{background-color: #66BFBF;text-align: center;} h1{color: red; font-style: italic; font-size: 4.2rem;}</style>");
		pw.println("</head>");
		pw.println("<body>"); 
		pw.println("<h1>Hello!</h1>"); 
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}
