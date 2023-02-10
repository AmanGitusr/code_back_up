

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class LoginServlet2 extends HttpServlet {
    Connection conn = null;
    PreparedStatement ps = null;
    @Override
    public void init() throws ServletException {
//        ServletConfig cfg = super.getServletConfig();
//        String driver = cfg.getInitParameter("drivername");
//        String connurl = cfg.getInitParameter("dburl");
//        String dbname = cfg.getInitParameter("dbname");
//        String dbpwd = cfg.getInitParameter("dbpwd");
//        String dbqry = cfg.getInitParameter("dbqry");
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully!");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//Aman_Tiwari:1521/xe", "advjava", "java");
            System.out.println("Connection open successfully!");
            ps = conn.prepareCall("select username from users where userid = ? and password = ?");
        }catch (Exception ex) {
            System.out.println("Problem in init: " + ex.getMessage());
            ServletException se = new ServletException("Error in init ");
            throw se;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>LogIn</title>");
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
                pw.println("<h1>Hello, " + username + " Baka");
                pw.println("<h2>Enjoy your day!!!</h2>");
            }else {
                pw.println("<h1>Invaild username or password please <a href = 'Sign-in.html'>try again</a></h1>" );
            }
        }catch (SQLException ex) {
            System.out.println("Problem in db: " + ex.getMessage());
            pw.println("<h1>Better luck next time</h1>");
        }
    }

    @Override
    public void destroy() {
        try{
            conn.close();
            System.out.println("Connection close succesfully!");
        }catch (SQLException ex) {
            System.out.println("Problem in DB: " + ex.getMessage());
        }
    }
}
