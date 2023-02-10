

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginServlet4 extends HttpServlet {

    private Connection conn = null;
    private PreparedStatement ps = null;

    @Override
    public void init() throws ServletException {
        ServletContext ctxt = super.getServletContext();
        ServletConfig cfg = super.getServletConfig();
        String dbqry = cfg.getInitParameter("dbqry");

        try {
            conn = (Connection) ctxt.getAttribute("lsconn");
            System.out.println("Connection established in init successfully!");
            ps = conn.prepareStatement(dbqry);
            System.out.println("Query run successfully!");
        }catch (Exception ex) {
            System.out.println("Problem in init: " + ex.getMessage());
            ServletException se = new ServletException("Error in init: ");
            throw se;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>LogIn Page</title>");
        pw.println("</head>");
        pw.println("<body>");

        String userid = req.getParameter("userid");
        String upwd = req.getParameter("upwd");

        try {
            ps.setString(1, userid);
            ps.setString(2, upwd);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String username = rs.getString(1);
                pw.println("<h1>Hello, " + username + " Baka</h1>");
            }else {
                pw.println("<h1>Invalid userid/password</h1>");
                pw.println("<p>Please <a href = 'Sign-in.html'>try again</a></p>");
            }
        }catch (Exception ex) {
            System.out.println("Problem in dopost: " + ex.getMessage());
            pw.println("<h1>Better luck next time.............!!!</h1>");
        }
        pw.println("</body>");
        pw.println("</html>");
        pw.close();
    }
}
