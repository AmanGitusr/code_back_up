package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoveAllBooks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully!");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//Aman_Tiwari:1521/xe", "advjava", "java");
            System.out.println("Connection open successfully!");
            PreparedStatement ps = conn.prepareStatement("delete from allbooks where subject = ?");

            System.out.print("Enter the subject which you want to delete: ");
            String sub = in.nextLine();

            ps.setString(1, sub);

            int ans = ps.executeUpdate();
            System.out.println("Records Deleted: " + ans);
        }catch (ClassNotFoundException cnf) {
            System.out.println("Cannot find driver class: " + cnf.getMessage());
        }catch (SQLException ex) {
            System.out.println("Problem in db: " + ex.getMessage());
        }finally {
            try {
                if (conn!=null) {
                    conn.close();
                    System.out.println("Connection close successfully!");
                }
            }catch (SQLException ex) {
                System.out.println("Problem in closing connection: " + ex);
            }
        }
    }
}
