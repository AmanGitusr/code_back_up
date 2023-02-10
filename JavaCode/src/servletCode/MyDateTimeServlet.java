package servletCode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class MyDateTimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        Date today = new Date();
        pw.println("<htmla>");
        pw.println("<head>");
        pw.println("<title>Date Time Servlet</title>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("Current Date And Time is <h3> " + today + "</h3>");
        pw.println("</body>");
        pw.println("</html>");
        pw.close();
    }
}
