package servletCode;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginServlet3 extends HttpServlet {

    private Connection conn = null;
    private PreparedStatement ps = null;

    ServletContext ctxt = super.getServletContext();
    ServletConfig cfg = super.getServletConfig();

    String driver = ctxt.getInitParameter("drivername");
    String connurl = ctxt.getInitParameter("connurl");
    String username = ctxt.getInitParameter("username");
    String pwd = ctxt.getInitParameter("password");
    String dbqury = cfg.getInitParameter("dbqry");

    @Override
    public void init() throws ServletException {
        try {
            Class.forName(driver);
            System.out.println("Driver loaded successfully!!");
            conn = DriverManager.getConnection(connurl, username, pwd);
            System.out.println("Connection open successfully!!");
            ps = conn.prepareStatement(dbqury);
        }catch (Exception ex) {
            System.out.println("Problem in INIT: " + ex);
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

        String userid = req.getParameter("uid");
        String userpwd = req.getParameter("upwd");

        try {
            ps.setString(1, userid);
            ps.setString(2, userpwd);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String username = rs.getString(1);
                pw.println("<h1>Hello, " + username + " Baka</h1>");
            }else {
                pw.println("<h1>Invalid userid/password</h1>");
                pw.println("<p>Please <a href = 'Sign-in.html'>try again</a></p>");
            }
        }catch (Exception ex) {
            System.out.println("Problem in doPost: " + ex);
            pw.println("<h1>Better luck next time.............!!!</h1>");
        }
        pw.println("</body>");
        pw.println("</html>");
        pw.close();
    }

    @Override
    public void destroy() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Connection close successfully!!");
            }
        }catch (Exception ex) {
            System.out.println("Problem in connection closing: " + ex);
        }
    }
}
