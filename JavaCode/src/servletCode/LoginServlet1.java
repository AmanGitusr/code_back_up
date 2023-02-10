package servletCode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class LoginServlet1 extends HttpServlet {
    private Connection conn = null;
    private PreparedStatement ps = null;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully!");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//Aman_Tiwari:1521/xe", "advjava", "java");
            System.out.println("Connection open successfully!");
            ps = conn.prepareStatement("select username from users where userid = ? and password = ?");
        }catch (Exception ex) {
            System.out.println("Error in init: " + ex);
            ServletException obj = new ServletException("Problem in init");
            throw obj;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>New Registration</title>");
        pw.println("<style>body { background-color: #66BFBF;text-align: center; margin:200px auto;  } .error { color: red; text-decoration: underline; } </style>");
        pw.println("</head>");
        pw.println("<body>");
        String userid = req.getParameter("uid");
        String pwd = req.getParameter("upwd");

        try {
            ps.setString(1, userid);
            ps.setString(2, pwd);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String username = rs.getString(1);
                pw.println("<h1>Hello, " + username + " Baka");
                pw.println("<h2>Enjoy your day!!!</h2>");
            }else {
                pw.println("<h1>Invaild username or password please <a href = 'Sign-in.html'>try again</a></h1>" );
            }
        }catch (SQLException ex) {
            pw.println("<h1>Better luck next time!!</h1>");
        }
        pw.println("</body>");
        pw.println("</html>");
        pw.close();
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
