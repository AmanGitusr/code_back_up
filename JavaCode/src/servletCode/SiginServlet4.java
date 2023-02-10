

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

public class SiginServlet4 extends HttpServlet {
    private Connection conn = null;
    private PreparedStatement ps = null;

    @Override
    public void init() throws ServletException {
        ServletContext ctxt = super.getServletContext();
        ServletConfig cfg = super.getServletConfig();
        String dbqry = cfg.getInitParameter("dbqry");

       try {
           conn = (Connection) ctxt.getAttribute("lsconn");
           System.out.println("Connection open successfully!");
           ps = conn.prepareStatement(dbqry);
       }catch (Exception ex) {
           System.out.println("Error in init: " + ex.getMessage());
           ServletException se = new ServletException("Problem in init: ");
           throw se;
       }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        String username = req.getParameter("username");
        String userid = req.getParameter("uid");
        String userpwd = req.getParameter("upwd");

        try {
            ps.setString(1, username);
            ps.setString(2, userid);
            ps.setString(3, userpwd);
            int ans = ps.executeUpdate();
            if (ans == 1) {
                pw.println("<h3>Thank you for registering with us. You can now <a href = 'Sign-in.html'>login</a></h3>");
            }else {
                pw.println("<h2>Please <a href = 'Sign-up.html'>Try again</a></h2>");
            }
        }catch (Exception ex) {
            System.out.println("Problem in dopost: " + ex.getMessage());
            pw.println("<h2>Server is experiencing some issues. Please don't try!!");
        }
        pw.close();
    }
}
