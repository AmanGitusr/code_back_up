package jdbc;

import java.sql.*;

public class MyResultSet3 {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully!");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//Aman_Tiwari:1521/xe", "advjava", "java");
            System.out.println("Connection opened successfully!");
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select subject, price, name from allbooks");
            int count = 0;
            while (rs.next()) {
                String sub = rs.getString(1);

                String name = rs.getString(3);

                if (sub.equalsIgnoreCase("Development")) {
                    double amt = rs.getDouble(2);
                    amt = amt + (amt * 0.1);
                    rs.updateDouble(2, amt);
                    rs.updateRow();
                    ++count;
                    System.out.println("Updated books name: " + name);

                }

            }
            System.out.println("Total books updated: " + count);
        }catch (ClassNotFoundException ex) {
            System.out.println("Cannot loaded driver class: " + ex.getMessage());
        }catch (SQLException ex) {
            System.out.println("Problem in db: " + ex.getMessage());
        }finally {
            try {
                if (conn!=null) {
                    conn.close();
                    System.out.println("Connection close successfully");
                }
            }catch (SQLException ex) {
                System.out.println("Problem in closing connection: " + ex.getMessage());
            }
        }

    }
}
