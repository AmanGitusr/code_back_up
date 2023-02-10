

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Chal gaya ji chal ji INITIALIZED...........!!!");
        try {
            Thread.sleep(9000);
        }catch (Exception ex) {
            System.out.println("Initialized Thread me exception aa gai bhai.......!!!");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Chal gaya ji chal ji Destroyed...........!!!");
        try {
            Thread.sleep(9000);
        }catch (Exception ex) {
            System.out.println("Destroyed ke Thread me exception aa gai bhai.......!!!");
        }
    }
}
