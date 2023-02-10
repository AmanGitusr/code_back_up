

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;


public class MyDBListener implements ServletContextListener {

    private Connection conn = null;

    @Override
    public void contextInitialized(ServletContextEvent e) {
        ServletContext ctxt = e.getServletContext();
        String driver = ctxt.getInitParameter("drivername");
        String connurl = ctxt.getInitParameter("connurl");
        String dbuser = ctxt.getInitParameter("dbuser");
        String dbpwd = ctxt.getInitParameter("dbpwd");

        try {
            Class.forName(driver);
            System.out.println("Driver loaded successfull!");
            conn = DriverManager.getConnection(connurl, dbuser, dbpwd);
            System.out.println("Connection opened successfully!");
        }catch (Exception ex) {
            System.out.println("Error in init: " + ex.getMessage());
        }finally {
            ctxt.setAttribute("lsconn", conn);
            System.out.println("Connection set in ctxt");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Connection close successfully!");
            }
        }catch (Exception ex) {
            System.out.println("Error in listener: " + ex.getMessage());
        }
    }
}
