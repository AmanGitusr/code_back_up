package servletCode;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class SignUpServlet1 extends HttpServlet {
    private Connection conn = null;
    private PreparedStatement ps = null;

    public void init() throws ServletException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully!");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//Aman_Tiwari:1521/xe", "advjava", "java");
            System.out.println("Connection open successfully!");
            ps = conn.prepareStatement("insert into users values(?, ?, ?)");
        }catch (Exception ex) {
            System.out.println("Problem in init: " + ex);
            ServletException obj = new ServletException("Problem in init");
            throw obj;
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>New Registration</title>");
        pw.println("<style>body { background-color: #66BFBF;text-align: center; } .error { color: red; text-decoration: underline; }</style>");
        pw.println("</head>");
        pw.println("<body>");
        String username = req.getParameter("uname");
        String userId = req.getParameter("uid");
        String pwd = req.getParameter("upwd");


        try {
            ps.setString(1, username);
            ps.setString(2, userId);
            ps.setString(3, pwd);
            int ans = ps.executeUpdate();
            if (ans==1) {
                pw.println("<h3>Thank you for registering with us. You can now <a href = 'Sign-in.html'>login</a></h3>");
            }else {
                pw.println("<h2>Please <a href = 'Sign-up.html'>Try again</a></h2>");
            }
        }catch (SQLException ex) {
            pw.println("<h2>Server is experiencing some issues. Please don't try!!");
        }
        pw.println("</body>");
        pw.println("</html>");
        pw.close();
    }

    public void destory() {
        try {
            conn.close();
            System.out.println("Connection closed successfully!");
        }catch (SQLException ex) {
            System.out.println("Cannot close the DB Connection");
        }
    }

}