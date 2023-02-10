package jdbc;

import java.sql.*;

public class MyResultSet2 {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully!");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//Aman_Tiwari:1521/xe", "advjava", "java");
            System.out.println("Connection opened successfully!");
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select name, price from allbooks");
            while (rs.next()) {
                String name = rs.getString(1);
                int price = rs.getInt(2);
                System.out.println("Name of the books: '" + name + "' and the price of books: $" + price);
            }
            System.out.println("Now traversing in reversal direction.....!");
            while (rs.previous()) {
                String name = rs.getString(1);
                int price = rs.getInt(2);
                System.out.println("Name of the books: '" + name + "' and the price of books: $" + price);
            }
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
